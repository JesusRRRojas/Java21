package com.pe.proyecto.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pe.proyecto.entity.Distrito;
import com.pe.proyecto.exception.DAOException;
import com.pe.proyecto.interfaces.DistritoDAO;

public class DistritoImpl extends GenericoImpl implements DistritoDAO {

	@Override
	public List<Distrito> listar(String nombre) throws DAOException {
		try 
		{
			String sql = "SELECT COD_DEP, COD_PRO, COD_DIS, NOMBRE FROM DISTRITOS "
					+ " WHERE COD_PRO = ? ;";
			Connection cn = super.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, "%" + nombre.toUpperCase() + "%");

			ResultSet rs = ps.executeQuery();

			List<Distrito> distritos = new ArrayList<Distrito>();

			while (rs.next()) {
				distritos.add(
						
						new Distrito(
								rs.getString("COD_DEP"), 
								rs.getString("COD_PRO"), 
								rs.getString("COD_DIS"),
								rs.getString("NOMBRE")
								)
						);
			}
			rs.close();
			ps.close();
			cn.close();
			return distritos;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new DAOException("Error al listar los Distrito");
		}
	}

	@Override
	public Boolean insertar(Distrito producto) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean actualizar(Distrito producto) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
