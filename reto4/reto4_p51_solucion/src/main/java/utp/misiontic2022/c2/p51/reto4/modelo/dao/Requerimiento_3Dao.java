package utp.misiontic2022.c2.p51.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p51.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        var response = new ArrayList<Requerimiento_3>();
        String consulta = "SELECT c.Proveedor, mc.Nombre_Material, mc.Importado, mc.Precio_Unidad, SUM(c.Cantidad) as Cantidad"
                        + " FROM MaterialConstruccion mc"
                        + " JOIN Compra c ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion"
                        + " WHERE mc.Importado = 'Si' AND c.Proveedor = 'Homecenter'"
                        + " GROUP BY c.Proveedor, mc.ID_MaterialConstruccion"
                        + " HAVING SUM(c.Cantidad)>100"
                        + " ORDER BY c.Proveedor, mc.Nombre_Material";
                        
        try(var connection = JDBCUtilities.getConnection();
            var statement = connection.prepareStatement(consulta);
            var rset = statement.executeQuery()){

                while (rset.next()){
                    var requerimiento3_VO = new Requerimiento_3();
                    requerimiento3_VO.setProveedor(rset.getString("Proveedor"));
                    requerimiento3_VO.setNombreMaterial(rset.getString("Nombre_Material"));
                    requerimiento3_VO.setImportado(rset.getString("Importado"));
                    requerimiento3_VO.setPrecioUnidad(rset.getInt("Precio_Unidad"));
                    requerimiento3_VO.setCantidad(rset.getInt("Cantidad"));

                    response.add(requerimiento3_VO);
                }

        }
        return response;
    }
    
}