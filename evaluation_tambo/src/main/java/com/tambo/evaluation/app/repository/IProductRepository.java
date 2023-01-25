package com.tambo.evaluation.app.repository;


import com.tambo.evaluation.app.model.Producto;

import java.util.List;

public interface IProductRepository {
    public List<Producto> findAll();
    public int save(Producto product);
    public int update(Producto product);
    public int deleteById(int id);
}
