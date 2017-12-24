package com.imooc.form;

/**
 * Created by hh on 2017/9/25.
 */
public class CategoryForm {

    /**类目id*/
    private Integer categoryId;

    /**类目名字*/
    private String categoryName;

    /**类目编号*/
    private Integer categoryType;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }
}
