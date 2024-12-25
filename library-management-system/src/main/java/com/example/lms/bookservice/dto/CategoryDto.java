package com.example.lms.bookservice.dto;

import java.util.List;

public interface CategoryDto {
    Long getId();
    void setId(Long id);

    String getCategoryName();
    void setCategoryName(String categoryName);

    String getDesc();
    void setDesc(String desc);

    List<Long> getBookIds();
    void setBookIds(List<Long> bookIds);
}