package com.seanrobinette.mvcrest.services;

import com.seanrobinette.mvcrest.api.v1.mapper.CategoryMapper;
import com.seanrobinette.mvcrest.api.v1.model.CategoryDTO;
import com.seanrobinette.mvcrest.domain.Category;
import com.seanrobinette.mvcrest.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for(Category category : categoryRepository.findAll())
            categoryDTOS.add(categoryMapper.categoryToCategoryDTO(category));
        return categoryDTOS;
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
    }
}
