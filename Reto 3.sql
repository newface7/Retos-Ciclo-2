--Materiales de construccion importados con precio (Validado)
SELECT mc.Nombre_Material, mc.Precio_Unidad
FROM MaterialConstruccion mc
WHERE mc.Importado = 'Si'
ORDER BY mc.Precio_Unidad DESC

--Proveedores que importan materiales de construcción (Revisado)

SELECT DISTINCT c.Proveedor, mc.Nombre_Material, mc.Importado 
FROM MaterialConstruccion mc
JOIN Compra c ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion 
WHERE mc.Importado = 'Si'
ORDER BY c.Proveedor, mc.Nombre_Material

--Unidades de material para construcción vendidas, importadas por Homecenter

SELECT c.Proveedor, mc.Nombre_Material, mc.Importado, mc.Precio_Unidad, SUM(c.Cantidad) as Cantidad 
FROM MaterialConstruccion mc
JOIN Compra c ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion
WHERE mc.Importado = 'Si' AND c.Proveedor = 'Homecenter'
GROUP BY c.Proveedor, mc.ID_MaterialConstruccion 
ORDER BY c.Proveedor, mc.Nombre_Material

--Empresas constructoras que empresa tiene letra B (Validado)
SELECT DISTINCT p.Constructora, p.Ciudad
FROM Proyecto p 
WHERE p.Ciudad LIKE 'B%'
ORDER BY p.Ciudad
 
--
SELECT c.Proveedor, mc.Nombre_Material, mc.Importado, mc.Precio_Unidad, SUM(c.Cantidad) as Cantidad 
FROM MaterialConstruccion mc
JOIN Compra c ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion
WHERE mc.Importado = 'Si' AND c.Proveedor = 'Homecenter'
GROUP BY c.Proveedor, mc.ID_MaterialConstruccion 
HAVING SUM(c.Cantidad)>100
ORDER BY c.Proveedor, mc.Nombre_Material


