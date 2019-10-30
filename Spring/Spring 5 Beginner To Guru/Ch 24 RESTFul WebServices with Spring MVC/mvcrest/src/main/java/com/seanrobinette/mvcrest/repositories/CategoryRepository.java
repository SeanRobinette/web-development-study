package com.seanrobinette.mvcrest.repositories;

import com.seanrobinette.mvcrest.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
