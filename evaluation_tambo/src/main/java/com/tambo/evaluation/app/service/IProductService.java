package com.tambo.evaluation.app.service;

import com.tambo.evaluation.app.model.Producto;

import java.util.List;

public interface IProductService {
    public List<Producto> findAll();
    public int save(Producto product);
    public int update(Producto product);
    public int deleteById(int id);
}
