package com.pe.proyecto.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pe.proyecto.entity.Departamento;
import com.pe.proyecto.exception.DAOException;
import com.pe.proyecto.interfaces.DepartamentoDAO;

public class DepartamentoImpl extends GenericoImpl implements DepartamentoDAO {

	@Override
	public List<Departamento> listar(String nombre) throws DAOException {
		try 
		{
			
			String sql = "SELECT COD_DEP, NOMBRE FROM DEPARTAMENTOS ;";
			Connection cn = super.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Departamento> departamentos = new ArrayList<Departamento>();

			while (rs.next()) {
				departamentos.add(
						new Departamento(
								rs.getString("COD_DEP"),
								rs.getString("NOMBRE"))
						);
			}
			rs.close();
			ps.close();
			cn.close();
			return departamentos;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new DAOException("Error al listar los Departamentos");
		}
	}

	@Override
	public Boolean insertar(Departamento producto) throws DAOException {
		try {

			Connection cn = super.getConnection();

			String sql = "{call PKG_DEPARTAMENTOS.SP_INSERTAR(?,?)}";

			System.out.println(sql);

			java.sql.CallableStatement cs = cn.prepareCall(sql);
			
			//cs.registerOutParameter(1, java.sql.Types.NUMERIC);
			
			cs.setString(1, producto.getCodigoDepartamento());
			cs.setString(2, producto.getNombreDepartamento());

			int ret = cs.executeUpdate(); // Updata db (agregar, actualizas, eliminas)
			System.out.println("ret => "+ret);
			//long id=cs.getLong(1);
			//System.out.println("id => "+id);
			
			cs.close();
			cn.close();
			
			//producto.setId(id);
			return ret>0;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error al insertar departamento" + e.getMessage());
		}
	}

	@Override
	public Boolean actualizar(Departamento producto) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
