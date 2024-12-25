package com.example.lms.bookservice.dto;
import java.util.*;
public class CategoryDtoImpl implements CategoryDto {

    private Long id;
    private String categoryName;
    private String desc;
    private List<Long> bookIds;

    public CategoryDtoImpl() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public List<Long> getBookIds() {
        return bookIds;
    }

    @Override
    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }
}