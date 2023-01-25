package com.tambo.evaluation.app.service;

import com.tambo.evaluation.app.model.Producto;
import com.tambo.evaluation.app.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Producto> findAll() {
        List<Producto> list;
        try{
            list = iProductRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Producto producto) {
        int row;
        try{
            row = iProductRepository.save(producto);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Producto producto) {
        int row;
        try{
            row = iProductRepository.update(producto);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try{
            row = iProductRepository.deleteById(id);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
