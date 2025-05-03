/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.proyecto.persistencia;
import com.pe.proyecto.util.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import com.pe.proyecto.bean.EscuelaConductor;
import com.pe.proyecto.bean.Response;
import com.pe.proyecto.interfaces.EscuelaConductorDAO;
import com.pe.proyecto.util.JPanelMensaje;

/**
 *
 * @author miche
 */
public class ConductorDAOImpl extends Conexion implements EscuelaConductorDAO {

    JPanelMensaje JPanel = new JPanelMensaje();
    @Override
    public List<EscuelaConductor> listarTodos() throws Exception {
        List<EscuelaConductor> lista = new ArrayList<EscuelaConductor>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            this.ConexionOpen();
            
            String Query = "SELECT "
                + "    DEPARTAMENTOS.COD_DEP "
		+ ",   DEPARTAMENTOS.NOMBRE AS NOM_DEP "
		+ ",   PROVINCIAS.COD_PRO "
		+ ",   PROVINCIAS.NOMBRE   AS NOM_PRO "
		+ ",   DISTRITOS.COD_DIS "
		+ ",   DISTRITOS.NOMBRE   AS NOM_DIS "
		+ ",   ID "
		+ ",   NRO_RUC "
		+ ",   NOMBRE_ESTABLECIMIENTO "
		+ ",   DIRECCION "
		+ ",   CORREO "
		+ ",   TELEFONO "
		+ ",   ESTADO "
		+ " FROM escuelas_conductores "
		+ " INNER JOIN DEPARTAMENTOS ON ESCUELAS_CONDUCTORES.cod_dep= DEPARTAMENTOS.COD_DEP "
                + " INNER JOIN PROVINCIAS ON ESCUELAS_CONDUCTORES.cod_pro = PROVINCIAS.COD_PRO "
		+ " INNER JOIN DISTRITOS ON ESCUELAS_CONDUCTORES.COD_DIS = DISTRITOS.COD_DIS "
		+ " WHERE "
		+ " ELIMINADO = 0";
                    
            ps = this.conexion.prepareStatement(Query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                EscuelaConductor escuela = new EscuelaConductor();
                escuela.setId(rs.getInt("ID"));    
                escuela.setCodDep(rs.getString("COD_DEP"));
		escuela.setCodPro(rs.getString("COD_PRO"));
		escuela.setCodDis(rs.getString("COD_DIS"));

		escuela.setNomDep(rs.getString("NOM_DEP"));
		escuela.setNomPro(rs.getString("NOM_PRO")) ;
		escuela.setNomDis (rs.getString("NOM_DIS")) ;

		escuela.setNroRuc(rs.getString("NRO_RUC")) ;
		escuela.setNombreEstablecimiento(rs.getString("NOMBRE_ESTABLECIMIENTO")) ;
		escuela.setDireccion (rs.getString("DIRECCION")) ;
		escuela.setCorreo (rs.getString("CORREO")) ;
		escuela.setTelefono(rs.getString("TELEFONO")) ;
		escuela.setEstado(rs.getString("ESTADO")) ;
                
                lista.add((escuela));
            }
            
            
        } catch (Exception e) {
            JPanel.Error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally{
            CerrarRecursosPS(rs, ps);
        }
        
        return lista;
    }

    @Override
    public List<EscuelaConductor> listarPorNombre(String nombre) throws Exception {
        
        List<EscuelaConductor> lista = new ArrayList<EscuelaConductor>();
        nombre = (nombre == null) ? "" : nombre;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            this.ConexionOpen();
            
           String Query = "SELECT "
                + "    DEPARTAMENTOS.COD_DEP "
		+ ",   DEPARTAMENTOS.NOMBRE AS NOM_DEP "
		+ ",   PROVINCIAS.COD_PRO "
		+ ",   PROVINCIAS.NOMBRE   AS NOM_PRO "
		+ ",   DISTRITOS.COD_DIS "
		+ ",   DISTRITOS.NOMBRE   AS NOM_DIS "
		+ ",   ID "
		+ ",   NRO_RUC "
		+ ",   NOMBRE_ESTABLECIMIENTO "
		+ ",   DIRECCION "
		+ ",   CORREO "
		+ ",   TELEFONO "
		+ ",   ESTADO "
		+ " FROM escuelas_conductores "
		+ " INNER JOIN DEPARTAMENTOS ON ESCUELAS_CONDUCTORES.cod_dep= DEPARTAMENTOS.COD_DEP "
                + " INNER JOIN PROVINCIAS ON ESCUELAS_CONDUCTORES.cod_pro = PROVINCIAS.COD_PRO "
		+ " INNER JOIN DISTRITOS ON ESCUELAS_CONDUCTORES.COD_DIS = DISTRITOS.COD_DIS "
		+ " WHERE ELIMINADO = 0 AND UPPER(NOMBRE_ESTABLECIMIENTO) LIKE ? ORDER BY ID DESC" ;
                    
            ps = this.conexion.prepareStatement(Query);
            ps.setString(1, "%" + nombre.toUpperCase() + "%");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
               EscuelaConductor escuela = new EscuelaConductor();
                escuela.setId(rs.getInt("ID"));    
                escuela.setCodDep(rs.getString("COD_DEP"));
		escuela.setCodPro(rs.getString("COD_PRO"));
		escuela.setCodDis(rs.getString("COD_DIS"));

		escuela.setNomDep(rs.getString("NOM_DEP"));
		escuela.setNomPro(rs.getString("NOM_PRO")) ;
		escuela.setNomDis (rs.getString("NOM_DIS")) ;

		escuela.setNroRuc(rs.getString("NRO_RUC")) ;
		escuela.setNombreEstablecimiento(rs.getString("NOMBRE_ESTABLECIMIENTO")) ;
		escuela.setDireccion (rs.getString("DIRECCION")) ;
		escuela.setCorreo (rs.getString("CORREO")) ;
		escuela.setTelefono(rs.getString("TELEFONO")) ;
		escuela.setEstado(rs.getString("ESTADO")) ;
                
                lista.add((escuela));
            }
            
            
        } catch (Exception e) {
            JPanel.Error(e.getMessage());
            e.printStackTrace();
            throw e;
        }finally{
            CerrarRecursosPS(rs, ps);
        }
        
        return lista;        
    }

    @Override
    public Boolean insertar(EscuelaConductor obj) throws Exception {
       boolean bResultado = false;        
        PreparedStatement ps = null;
        String sql = "INSERT INTO ESCUELAS_CONDUCTORES(COD_DEP, COD_PRO,COD_DIS, NRO_RUC, NOMBRE_ESTABLECIMIENTO, DIRECCION, CORREO, TELEFONO, ESTADO,ELIMINADO) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {

        
 
            this.ConexionOpen();
            ps = this.conexion.prepareStatement(sql);
          ps.setString(1, obj.getCodDep());
			ps.setString(2, obj.getCodPro());
			ps.setString(3, obj.getCodDis());
			ps.setString(4, obj.getNroRuc());
			ps.setString(5, obj.getNombreEstablecimiento());
			ps.setString(6, obj.getDireccion());
			ps.setString(7, obj.getCorreo());
			ps.setString(8, obj.getTelefono());
			ps.setString(9, obj.getEstado());
			ps.setInt(10, 0);
            
            bResultado = ps.executeUpdate() >0;// --> Update (Insert,Update y Delete)
            if (bResultado) {
                JPanel.Succes("Registro actualizado correctamente.");
            } else {
                JPanel.Error("No se encontro el registro para actualizar.");
            }            

        } catch (Exception e) {
            JPanel.Error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally{
            CerrarRecursosPS(null, ps);
        }
        return bResultado;
    }


    @Override
    public Boolean actualizar(EscuelaConductor obj) throws Exception {
        boolean bResultado = false;        
        PreparedStatement ps = null;
        String sqlUpdate = "UPDATE ESCUELAS_CONDUCTORES SET "
                    + "COD_DEP = ?, "
                    + "COD_PRO = ?, "
                    + "COD_DIS = ?, "
                    + "NRO_RUC = ?, "
                    + "NOMBRE_ESTABLECIMIENTO = ?, "
                    + "DIRECCION = ?, "
                    + "CORREO = ?, "
                    + "TELEFONO = ?, "
                    + "ESTADO = ? "
                    + "WHERE ELIMINADO = 0 "
                    + "AND ID = ?";
            
        String queryDebug = String.format("""
                    UPDATE ESCUELAS_CONDUCTORES SET 
                        COD_DEP = '%s', 
                        COD_PRO = '%s', 
                        COD_DIS = '%s', 
                        NRO_RUC = '%s', 
                        NOMBRE_ESTABLECIMIENTO = '%s', 
                        DIRECCION = '%s', 
                        CORREO = '%s', 
                        TELEFONO = '%s', 
                        ESTADO = '%s' 
                    WHERE ELIMINADO = 0 
                    AND ID = %d
                """,
                obj.getCodDep(), obj.getCodPro(), obj.getCodDis(),
                obj.getNroRuc(), obj.getNombreEstablecimiento(), obj.getDireccion(),
                obj.getCorreo(), obj.getTelefono(), obj.getEstado(),
                obj.getId());        
        try {

        
 
            this.ConexionOpen();
            ps = this.conexion.prepareStatement(sqlUpdate);
            ps.setString(1, obj.getCodDep());
            ps.setString(2, obj.getCodPro());
            ps.setString(3, obj.getCodDis());
            ps.setString(4, obj.getNroRuc());
            ps.setString(5, obj.getNombreEstablecimiento());
            ps.setString(6, obj.getDireccion());
            ps.setString(7, obj.getCorreo());
            ps.setString(8, obj.getTelefono());
            ps.setString(9, obj.getEstado());
            ps.setInt(10, obj.getId());
            
            bResultado = ps.executeUpdate() >0;// --> Update (Insert,Update y Delete)
            if (bResultado) {
                JPanel.Succes("Registro actualizado correctamente.");
            } else {
                JPanel.Error("No se encontro el registro para actualizar.");
            }            

        } catch (Exception e) {
            JPanel.Error(e.getMessage());
            JPanel.Debug(queryDebug);
            e.printStackTrace();
            throw e;
        } finally{
            CerrarRecursosPS(null, ps);
        }
        return bResultado;
    }

    @Override
    public Boolean eliminar(int id) throws Exception {
        boolean bResultado = false;  
        PreparedStatement ps = null;
       
        String sqlEliminar = "UPDATE ESCUELAS_CONDUCTORES SET ELIMINADO = 1 WHERE ID = ?";
        try {
            this.ConexionOpen(); 
            ps = this.conexion.prepareStatement(sqlEliminar);
            ps.setInt(1,id);
            
            bResultado = ps.executeUpdate() >0;// --> Update (Insert,Update y Delete)
            if(bResultado){
                JPanel.Succes("Registro eliminado");
            }
            else JPanel.Error("Error al momento de eliminar");             
        } catch (Exception e) {
            JPanel.Error(e.getMessage()); 
            e.printStackTrace();
            throw e;
        } finally{
            CerrarRecursosPS(null, ps);
        }
        return bResultado;
          
    }

    private void CerrarRecursosCS(ResultSet rs,CallableStatement cs){
        try {
            if(rs != null) rs.close();
            if(cs != null) cs.close();
            this.ConexionClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void CerrarRecursosPS(ResultSet rs,PreparedStatement ps){
        try {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            this.ConexionClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    @Override
    public Response Validaciones(EscuelaConductor obj) throws Exception {
        Response oResponse = new Response("", true);
        String queryDebug = "";
        
        String query = """
            SELECT 
                (SELECT COUNT(1) FROM DEPARTAMENTOS WHERE COD_DEP = ?) AS DEP_EXISTE,
                (SELECT COUNT(1) FROM PROVINCIAS WHERE COD_DEP = ? AND COD_PRO = ?) AS PRO_EXISTE,
                (SELECT COUNT(1) FROM DISTRITOS WHERE COD_DEP = ? AND COD_PRO = ? AND COD_DIS = ?) AS DIS_EXISTE,
                (SELECT COUNT(1) FROM ESCUELAS_CONDUCTORES WHERE NRO_RUC = ? AND ELIMINADO = 0)  AS RUC_EXISTE        
            FROM DUAL
        """;

        queryDebug = String.format("""
            SELECT 
                (SELECT COUNT(1) FROM DEPARTAMENTOS WHERE COD_DEP = '%s') AS DEP_EXISTE,
                (SELECT COUNT(1) FROM PROVINCIAS WHERE COD_DEP = '%s' AND COD_PRO = '%s') AS PRO_EXISTE,
                (SELECT COUNT(1) FROM DISTRITOS WHERE COD_DEP = '%s' AND COD_PRO = '%s' AND COD_DIS = '%s') AS DIS_EXISTE,
                (SELECT COUNT(1) FROM ESCUELAS_CONDUCTORES WHERE NRO_RUC = '%s' AND ELIMINADO = 0) AS RUC_EXISTE        
            FROM DUAL
            """,
            obj.getCodDep(), obj.getCodDep(), obj.getCodPro(),
            obj.getCodDep(), obj.getCodPro(), obj.getCodDis(),
            obj.getNroRuc()
        );



        try {
            this.ConexionOpen();

            try (PreparedStatement ps = this.conexion.prepareStatement(query)) {
                ps.setString(1, obj.getCodDep());
                ps.setString(2, obj.getCodDep());
                ps.setString(3, obj.getCodPro());
                ps.setString(4, obj.getCodDep());
                ps.setString(5, obj.getCodPro());
                ps.setString(6, obj.getCodDis());
                ps.setString(7, obj.getNroRuc());

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        StringBuilder errores = new StringBuilder();

                        if (rs.getInt("DEP_EXISTE") == 0) {
                            errores.append("El codigo de departamento no existe.\n");
                        }
                        if (rs.getInt("PRO_EXISTE") == 0) {
                            errores.append("El codigo de provincia no existe para el departamento ingresado.\n");
                        }
                        if (rs.getInt("DIS_EXISTE") == 0) {
                            errores.append("El codigo de distrito no existe para la provincia ingresada.\n");
                        }
                        if (rs.getInt("RUC_EXISTE") > 0 && obj.getId() == 0) { // Si el ruc existe cuando se inserta sale error, si es update no hay problema
                            errores.append("El numero de RUC " + obj.getNroRuc() + " ya existe en la base de datos.\n");
                        }

                        if (errores.length() > 0) {
                            oResponse.setResultadoBit(false);
                            oResponse.setResultadoDesc(errores.toString().trim());
                            //  Revisando errores
                            JPanel.Debug(queryDebug);
                        }
                    }
                }
            }
        } catch (Exception e) 
        {
            JPanel.Error(e.getMessage());
            JPanel.Succes(queryDebug);
            e.printStackTrace();
            throw e;
            
        } 

        return oResponse;
    }
    
    
    
    

    @Override
    public EscuelaConductor BuscarPorId(int Id) throws Exception {
        EscuelaConductor obj = new EscuelaConductor();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            this.ConexionOpen();
            
            String Query = "SELECT ID,COD_DEP,COD_PRO,COD_DIS,NRO_RUC,NOMBRE_ESTABLECIMIENTO,DIRECCION,"
                    + "CORREO,TELEFONO,ESTADO FROM ESCUELAS_CONDUCTORES WHERE ELIMINADO = 0 AND ID = ? " ;
                    
            ps = this.conexion.prepareStatement(Query);
            ps.setInt(1, Id);
            
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                obj.setId(rs.getInt(1));
                obj.setCodDep(rs.getString(2));
                obj.setCodPro(rs.getString(3));
                obj.setCodDis(rs.getString(4));
                obj.setNroRuc(rs.getString(5));
                obj.setNombreEstablecimiento(rs.getString(6));
                obj.setDireccion(rs.getString(7));
                obj.setCorreo(rs.getString(8));
                obj.setTelefono(rs.getString(9));
                obj.setEstado(rs.getString(10));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            CerrarRecursosPS(rs, ps);
        }
        
        return obj;  
    }
     
}


