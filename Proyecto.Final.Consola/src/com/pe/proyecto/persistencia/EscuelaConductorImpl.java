package com.pe.proyecto.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pe.proyecto.entity.EscuelaConductor;
import com.pe.proyecto.exception.DAOException;
import com.pe.proyecto.interfaces.EscuelaConductorDAO;

public class EscuelaConductorImpl extends GenericoImpl implements EscuelaConductorDAO {

	@Override
	public List<EscuelaConductor> listar(String nombre) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insertar(EscuelaConductor producto) throws DAOException {
		try {

			Connection cn = super.getConnection();

			String sql = "INSERT INTO ESCUELAS_CONDUCTORES(COD_DEP, COD_PRO,COD_DIS, NRO_RUC, NOMBRE_ESTABLECIMIENTO, DIRECCION, CORREO, TELEFONO, ESTADO,ELIMINADO) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";

			System.out.println(sql);

			PreparedStatement ps = cn.prepareStatement(sql);

			ps.setString(1, producto.getCodDepartamento());
			ps.setString(2, producto.getCodProvincia());
			ps.setString(3, producto.getCodDistrito());
			ps.setString(4, producto.getNroRUC());
			ps.setString(5, producto.getNombreEstablecimiento());
			ps.setString(6, producto.getDireccion());
			ps.setString(7, producto.getCorreo());
			ps.setString(8, producto.getTelefono());
			ps.setString(9, producto.getEstado());
			ps.setInt(10, 0);
			
			ps.setQueryTimeout(30); 

			System.out.println(producto.toString());
			
			int ret = ps.executeUpdate(); 
			ps.close();
			cn.close();
			
			 if (ret > 0) {
		            System.out.println("Transacción confirmada.");
		        } else {
		            System.out.println("No se afectaron filas.");
		        }
			 
			return (ret > 0);

			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error al insertar producto" + e.getMessage());
		}


	}

	@Override
	public Boolean actualizar(EscuelaConductor producto) throws DAOException {
		try {

			Connection cn = super.getConnection();

			String sql = "UPDATE ESCUELAS_CONDUCTORES "
					+ "	SET     "
					+ "	   COD_DEP = ?      "
					+ ",   COD_PRO = ?     "
					+ ",   COD_DIS = ?     "
					+ ",   NRO_RUC = ?     "
					+ ",   NOMBRE_ESTABLECIMIENTO = ?     "
					+ ",   DIRECCION = ?     "
					+ ",   CORREO = ?      "
					+ ",   TELEFONO = ?     "
					+ ",   ESTADO = ? "
					+ " WHERE ID = ?";

			System.out.println(sql);

			PreparedStatement ps = cn.prepareStatement(sql);

			ps.setString(1, producto.getCodDepartamento());
			ps.setString(2, producto.getCodProvincia());
			ps.setString(3, producto.getCodDistrito());
			ps.setString(4, producto.getNroRUC());
			ps.setString(5, producto.getNombreEstablecimiento());
			ps.setString(6, producto.getDireccion());
			ps.setString(7, producto.getCorreo());
			ps.setString(8, producto.getTelefono());
			ps.setString(9, producto.getEstado());
			ps.setInt(10, producto.getId());


			int ret = ps.executeUpdate(); 
			ps.close();
			cn.close();

			return (ret > 0);

			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error al insertar producto" + e.getMessage());
		}

	}

	@Override
	public Boolean eliminar(Long id) throws DAOException {
		try {

			Connection cn = super.getConnection();

			String sql = "UPDATE ESCUELAS_CONDUCTORES "
					+ "	SET     "
					+ "   ELIMINADO = ? "
					+ " WHERE ID = ?";

			System.out.println(sql);

			PreparedStatement ps = cn.prepareStatement(sql);

			ps.setInt(1, 1);
			ps.setInt(2, id.intValue());


			int ret = ps.executeUpdate(); // Updata db (agregar, actualizas, eliminas)
			ps.close();
			cn.close();

			return (ret > 0);

			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error al insertar producto" + e.getMessage());
		}
	}
/*
	@Override
	public List<EscuelaConductor> listar() throws DAOException {
		try 
		{
			
			String sql = "SELECT ID, COD_DEP, COD_PRO,COD_DIS, NRO_RUC, NOMBRE_ESTABLECIMIENTO, DIRECCION, CORREO, TELEFONO, ESTADO FROM ESCUELAS_CONDUCTORES WHERE ELIMINADO = 0";
			Connection cn = super.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<EscuelaConductor> listaEscuelaConductor = new ArrayList<EscuelaConductor>();

			while (rs.next()) {
				listaEscuelaConductor.add(
						new EscuelaConductor(
								rs.getInt("ID"),
								rs.getString("COD_DEP"),
								rs.getString("COD_PRO"),
								rs.getString("COD_DIS"),
								rs.getString("NRO_RUC"),
								rs.getString("NOMBRE_ESTABLECIMIENTO"),
								rs.getString("DIRECCION"),
								rs.getString("CORREO"),
								rs.getString("TELEFONO"),
								rs.getString("ESTADO")
								)
						);
			}
			rs.close();
			ps.close();
			cn.close();
			return listaEscuelaConductor;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new DAOException("Error al listar los Departamentos");
		}
	}
*/
	@Override
	public List<EscuelaConductor> listar(String nombre, Integer opcion) throws DAOException {
		try 
		{
			
			String sql = "SELECT "
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
					+ "from escuelas_conductores "
					+ "INNER JOIN DEPARTAMENTOS ON ESCUELAS_CONDUCTORES.cod_dep= DEPARTAMENTOS.COD_DEP "
					+ "INNER JOIN PROVINCIAS ON ESCUELAS_CONDUCTORES.cod_pro = PROVINCIAS.COD_PRO "
					+ "INNER JOIN DISTRITOS ON ESCUELAS_CONDUCTORES.COD_DIS = DISTRITOS.COD_DIS "
					+ "WHERE "
					+ "(? = 1 AND ( "
					+ "    UPPER(DEPARTAMENTOS.NOMBRE) LIKE UPPER(?) "
					+ "OR  UPPER(PROVINCIAS.NOMBRE) LIKE UPPER(?) "
					+ "OR  UPPER(DISTRITOS.NOMBRE) LIKE UPPER(?)) "
					+ ") OR "
					+ "(? = 2 AND UPPER(NOMBRE_ESTABLECIMIENTO) LIKE UPPER(?)) "
					+ "AND "
					+ " ELIMINADO = 0";
			Connection cn = super.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);

			ps.setInt(1, opcion);
			ps.setString(2, nombre);
			ps.setString(3, nombre);
			ps.setString(4, nombre);
			ps.setInt(5, opcion);
			ps.setString(6, nombre);
			
			
			ResultSet rs = ps.executeQuery();

			List<EscuelaConductor> listaEscuelaConductor = new ArrayList<EscuelaConductor>();

			while (rs.next()) {
				EscuelaConductor escuela =  new EscuelaConductor();
				escuela.setId(rs.getInt("ID"));
				
				escuela.setCodDepartamento(rs.getString("COD_DEP"));
				escuela.setCodProvincia(rs.getString("COD_PRO"));
				escuela.setCodDistrito (rs.getString("COD_DIS"));

				escuela.setNombreDepartamento(rs.getString("NOM_DEP"));
				escuela.setNombreProvincia(rs.getString("NOM_PRO")) ;
				escuela.setNombreDistrito (rs.getString("NOM_DIS")) ;

				escuela.setNroRUC(rs.getString("NRO_RUC")) ;
				escuela.setNombreEstablecimiento(rs.getString("NOMBRE_ESTABLECIMIENTO")) ;
				escuela.setDireccion (rs.getString("DIRECCION")) ;
				escuela.setCorreo (rs.getString("CORREO")) ;
				escuela.setTelefono(rs.getString("TELEFONO")) ;
				escuela.setEstado(rs.getString("ESTADO")) ;
				
				listaEscuelaConductor.add(escuela);
			}
			rs.close();
			ps.close();
			cn.close();
			return listaEscuelaConductor;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new DAOException("Error al listar los Departamentos");
		}
	}

}
