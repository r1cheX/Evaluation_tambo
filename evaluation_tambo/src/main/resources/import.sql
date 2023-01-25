INSERT INTO proveedores(nombre,estado) VALUES('ALICORP',1);
INSERT INTO proveedores(nombre,estado) VALUES('BACKUS',1);
INSERT INTO proveedores(nombre,estado) VALUES('GLORIA',1);
INSERT INTO proveedores(nombre,estado) VALUES('INKAFARMA',1);

INSERT INTO productos (ean, codigo, nombre, costo, proveedor_id,estado) VALUES('1987564528','1003348','DETERGENTE SAPOLIO FLORAL X 450 GR',8,1,1);
INSERT INTO productos (ean, codigo, nombre, costo, proveedor_id,estado) VALUES('1987564528','1003348','DETERGENTE ACE FLORAL X 200 GR',12,2,1);
INSERT INTO productos (ean, codigo, nombre, costo, proveedor_id,estado) VALUES('1987564528','1003348','DETERGENTE BOLIVAR FLORAL X 300 GR',5,3,1);


INSERT INTO tiendas (codigo, nombre,estado) VALUES('25','TDA EUCALIPTOS',1);
INSERT INTO tiendas (codigo, nombre,estado) VALUES('23','TIENDA 2',1);
INSERT INTO tiendas (codigo, nombre,estado) VALUES('22','TIENDA 3',1);


INSERT INTO stocks (stock, valorizado, tienda_id, producto_id,estado,estado) VALUES(2,16,3,1,1);
INSERT INTO stocks (stock, valorizado, tienda_id, producto_id,estado) VALUES(2,24,1,2,1);
INSERT INTO stocks (stock, valorizado, tienda_id, producto_id,estado) VALUES(2,24,2,2,1);
INSERT INTO stocks (stock, valorizado, tienda_id, producto_id,estado) VALUES(2,24,3,2,1);
INSERT INTO stocks (stock, valorizado, tienda_id, producto_id,estado) VALUES(2,10,1,3,1);
INSERT INTO stocks (stock, valorizado, tienda_id, producto_id,estado) VALUES(2,10,2,3,1);
INSERT INTO stocks (stock, valorizado, tienda_id, producto_id,estado) VALUES(2,10,3,3,1);


