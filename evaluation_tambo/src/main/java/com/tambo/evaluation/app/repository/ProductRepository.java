package com.tambo.evaluation.app.repository;

import com.tambo.evaluation.app.model.Producto;
import com.tambo.evaluation.app.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Producto> findAll() {
        String SQL = "SELECT p.*, pr.nombre as nombre_proveedor FROM productos p JOIN proveedores pr ON p.proveedor_id = pr.id WHERE p.estado=1";
        return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<Producto>(Producto.class) {
            @Override
            public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
                Producto producto = super.mapRow(rs, rowNum);
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getLong("proveedor_id"));
                proveedor.setNombre(rs.getString("nombre_proveedor"));
                producto.setProveedor(proveedor);
                return producto;
            }
        });
    }


    @Override
    public int save(Producto producto) {
        String SQL = "INSERT INTO productos (ean, codigo, nombre, costo, proveedor_id, estado) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{producto.getEan(), producto.getCodigo(), producto.getNombre(), producto.getCosto(), producto.getProveedor().getId(), 1});
    }

    @Override
    public int update(Producto producto) {
        String SQL = "UPDATE productos SET ean=?, codigo=?, nombre=?, costo=?, proveedor_id=? WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{producto.getEan(), producto.getCodigo(), producto.getNombre(), producto.getCosto(), producto.getProveedor().getId(), producto.getId()});
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE productos SET estado=0 WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
}
