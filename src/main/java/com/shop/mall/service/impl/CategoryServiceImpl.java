package com.shop.mall.service.impl;

import com.shop.mall.consts.MallConst;
import com.shop.mall.dao.CategoryMapper;
import com.shop.mall.pojo.Category;
import com.shop.mall.service.ICategoryService;
import com.shop.mall.vo.CategoryVo;
import com.shop.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 耗时: http(请求微信api) > 磁盘 > 内存
     * mysql(内网 + 磁盘)
     * @return
     */

    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {
        List<Category> categories = categoryMapper.selectAll();

        //for 循环方法
        //查出parent_id=0的数据
//        for (Category category : categories){
//            if (category.getParentId().equals(MallConst.ROOT_PARENT_ID)){
//                CategoryVo categoryVo = new CategoryVo();
//                //把前者对象拷贝到后者中
//                BeanUtils.copyProperties(category,categoryVo);
//                categoryVoList.add(categoryVo);
//            }
//        }

        //lambda + stream  语法
        //第二行也可以  .map(this::CategoryToCategoryVo)
        List<CategoryVo> categoryVoList = categories.stream().filter(e -> e.getParentId().equals(MallConst.ROOT_PARENT_ID))
                .map(e -> CategoryToCategoryVo(e))
                .sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
                .collect(Collectors.toList());

        //查询子目录
        findSubCategory(categoryVoList,categories);

        return ResponseVo.success(categoryVoList);
    }

    @Override
    public void findSubCategoryId(Integer id, Set<Integer> resultSet) {
        List<Category> categories = categoryMapper.selectAll();
        findSubCategoryId(id, resultSet,categories);
    }

    public void findSubCategoryId(Integer id, Set<Integer> resultSet,List<Category> categories){
        for (Category category : categories){
            if (category.getParentId().equals(id)){
                resultSet.add(category.getId());
                findSubCategoryId(category.getId(),resultSet,categories);
            }
        }
    }

    private void findSubCategory(List<CategoryVo> categoryVoList,List<Category> categories){
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();
            for (Category category : categories) {
                //如果查到内容，设置subCategory,继续往下查
                if (categoryVo.getId().equals(category.getParentId())){
                    CategoryVo subCategoryVo = CategoryToCategoryVo(category);
                    subCategoryVoList.add(subCategoryVo);
                }
                //设置排序规则
                subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
                //set设置子目录
                categoryVo.setSubCategories(subCategoryVoList);
                //递归算法
                findSubCategory(subCategoryVoList,categories);
            }
        }
    }

    private CategoryVo CategoryToCategoryVo(Category category){
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}
