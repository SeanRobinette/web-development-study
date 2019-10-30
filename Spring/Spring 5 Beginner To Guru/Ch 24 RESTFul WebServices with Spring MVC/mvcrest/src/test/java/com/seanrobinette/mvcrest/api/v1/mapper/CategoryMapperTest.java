package com.seanrobinette.mvcrest.api.v1.mapper;

import com.seanrobinette.mvcrest.api.v1.model.CategoryDTO;
import com.seanrobinette.mvcrest.domain.Category;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryMapperTest {
    public static final String NAME = "Sean";
    public static final Long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() {
        //given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(categoryDTO.getId(), ID);
        assertEquals(categoryDTO.getName(), NAME);
    }
}