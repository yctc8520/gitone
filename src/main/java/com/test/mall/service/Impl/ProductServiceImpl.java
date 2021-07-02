package com.test.mall.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.mall.dao.ProductMapper;
import com.test.mall.pojo.Product;
import com.test.mall.service.ICategoryService;
import com.test.mall.service.IProductService;
import com.test.mall.vo.ProductDetailVo;
import com.test.mall.vo.ProductVo;
import com.test.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.test.mall.enums.ProductStatusEnum.DELETE;
import static com.test.mall.enums.ProductStatusEnum.OFF_SALE;
import static com.test.mall.enums.ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: IProductService实现类
 */

@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ICategoryService catogoryService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {

        Set<Integer> categoryIdSet = new HashSet<>();
        if (categoryId != null){
            catogoryService.findSubCategoryId(categoryId, categoryIdSet);
            categoryIdSet.add(categoryId);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.selectByCategoryIdSet(categoryIdSet);
        List<ProductVo> productVoList = productList.stream()
                .map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                })
                .collect(Collectors.toList());

        PageInfo pageInfo = new PageInfo<>(productList);
        pageInfo.setList(productVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<ProductDetailVo> detail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);

        //只对确定性条件判断
        if (product.getStatus().equals(OFF_SALE.getCode())
                || product.getStatus().equals(DELETE.getCode())){
            return ResponseVo.error(PRODUCT_OFF_SALE_OR_DELETE);
        }

        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product, productDetailVo);
        //敏感数据处理 商品库存>100，则置为100，否则显示实际库存
        productDetailVo.setStock(product.getStock() > 100 ? 100 : product.getStock());
        return ResponseVo.success(productDetailVo);
    }
}
