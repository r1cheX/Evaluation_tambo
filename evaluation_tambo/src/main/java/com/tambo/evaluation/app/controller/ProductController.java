package com.tambo.evaluation.app.controller;

//Cualquier cliente puede consumir nuestro servicio

import com.tambo.evaluation.app.model.Producto;
import com.tambo.evaluation.app.model.ServiceResponse;
import com.tambo.evaluation.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
@CrossOrigin("*")
public class ProductController {
    //        Se realiza los endpoints para consumir el servicio
    @Autowired
    private IProductService iProductService;

    @GetMapping("/list")
    public ResponseEntity<List<Producto>> list() {
        var result = iProductService.findAll();
        System.out.println("RESULTADO>>><" + result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Producto producto) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iProductService.save(producto);
        if (result == 1) {
            serviceResponse.setMessage("Item guardado con éxito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    //    make the same but for /update
    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Producto producto) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iProductService.update(producto);
        if (result == 1) {
            serviceResponse.setMessage("Item actualizado con éxito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iProductService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Item eliminado con éxito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
