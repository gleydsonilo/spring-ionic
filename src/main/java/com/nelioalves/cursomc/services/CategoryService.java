package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Category;
import com.nelioalves.cursomc.repositories.CategoryRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepositoy categoryRepository;

    public Optional<Category> find(Integer id){
        Optional<Category> cat = categoryRepository.findById(id);
        return cat;
    }
}
