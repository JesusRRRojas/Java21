package com.pe.proyecto.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pe.proyecto.entity.Provincia;
import com.pe.proyecto.exception.DAOException;
import com.pe.proyecto.interfaces.ProvinciaDAO;

public class ProvinciaImpl extends GenericoImpl implements ProvinciaDAO {

	@Override
	public List<Provincia> listar(String nombre) throws DAOException {
		try 
		{
			String sql = "SELECT COD_DEP,COD_PRO, NOMBRE FROM PROVINCIAS "
					+ " WHERE COD_DEP = ?;";
			Connection cn = super.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, "%" + nombre.toUpperCase() + "%");

			ResultSet rs = ps.executeQuery();

			List<Provincia> provincias = new ArrayList<Provincia>();

			while (rs.next()) {
				provincias.add(						
						new Provincia(
								rs.getString("COD_DEP"), 
								rs.getString("COD_PRO"), 
								rs.getString("NOMBRE")
								)
						);
			}
			rs.close();
			ps.close();
			cn.close();
			return provincias;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new DAOException("Error al listar los Distrito");
		}
	}

	@Override
	public Boolean insertar(Provincia producto) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean actualizar(Provincia producto) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
