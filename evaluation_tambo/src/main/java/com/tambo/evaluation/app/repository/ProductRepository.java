package com.tambo.evaluation.app.repository;

import com.tambo.evaluation.app.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Producto> findAll() {
        String SQL = "SELECT p.id, p.ean, p.codigo, p.nombre, p.costo, pro.id as proveedor_id, p.estado FROM productos p INNER JOIN proveedores pro on p.proveedor_id=pro.id WHERE p.estado=1";
        return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Producto.class));
    }


    @Override
    public int save(Producto producto) {
        String SQL = "INSERT INTO productos VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{producto.getEan(), producto.getCodigo(), producto.getNombre(), producto.getCosto(), producto.getProveedor().getId()});

    }

    @Override
    public int update(Producto producto) {
        String SQL = "UPDATE productos SET ean=?, codigo=?, nombre=?, costo=?, proveedor_id=? WHERE producto_id=?";
        return jdbcTemplate.update(SQL, new Object[]{producto.getEan(), producto.getCodigo(), producto.getNombre(), producto.getCosto(), producto.getProveedor()});
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE productos SET estado=0 WHERE producto_id=?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
}
