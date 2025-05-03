package com.pe.proyecto.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.proyecto.api.entity.EscuelaConductorConsultaEntity;
import com.pe.proyecto.api.entity.EscuelaConductorEntity;
import com.pe.proyecto.api.entity.EscuelaConductorEntity;

public interface EscuelaConductorConsultasRepository extends JpaRepository<EscuelaConductorConsultaEntity, Integer>{

	
	@Query(value = "SELECT ES.ID,"
			+ " ES.COD_DEP,"
			+ " DE.NOMBRE AS NOM_DEP,"
			+ " ES.COD_PRO,"
			+ " PR.NOMBRE AS NOM_PRO,"
			+ " ES.COD_DIS,"
			+ " DI.NOMBRE AS NOM_DIS,"
			+ " ES.NRO_RUC,"
			+ " ES.NOMBRE_ESTABLECIMIENTO,"
			+ " ES.DIRECCION,"
			+ " ES.CORREO,"
			+ " ES.TELEFONO,"
			+ " ES.ESTADO "
			+ " FROM ESCUELAS_CONDUCTORES ES "
			+ " INNER JOIN DEPARTAMENTOS DE ON ES.COD_DEP = DE.COD_DEP "
			+ " INNER JOIN PROVINCIAS PR ON ES.COD_PRO = PR.COD_PRO "
			+ " INNER JOIN DISTRITOS DI ON ES.COD_DIS = DI.COD_DIS "
			+ " WHERE ELIMINADO = 0", nativeQuery = true)	
	List<EscuelaConductorConsultaEntity> all();
	
	@Query(value = "SELECT ES.ID,"
			+ " ES.COD_DEP,"
			+ " DE.NOMBRE AS NOM_DEP,"
			+ " ES.COD_PRO,"
			+ " PR.NOMBRE AS NOM_PRO,"
			+ " ES.COD_DIS,"
			+ " DI.NOMBRE AS NOM_DIS,"
			+ " ES.NRO_RUC,"
			+ " ES.NOMBRE_ESTABLECIMIENTO,"
			+ " ES.DIRECCION,"
			+ " ES.CORREO,"
			+ " ES.TELEFONO,"
			+ " ES.ESTADO "
			+ " FROM ESCUELAS_CONDUCTORES ES "
			+ " INNER JOIN DEPARTAMENTOS DE ON ES.COD_DEP = DE.COD_DEP "
			+ " INNER JOIN PROVINCIAS PR ON ES.COD_PRO = PR.COD_PRO "
			+ " INNER JOIN DISTRITOS DI ON ES.COD_DIS = DI.COD_DIS "
			+ " WHERE  ES.ID = :id "
			+ " AND  ELIMINADO = 0", nativeQuery = true)	
	EscuelaConductorConsultaEntity findCustomById(@Param("id") Integer id);
	
	@Query(value = "SELECT ES.ID,"
			+ " ES.COD_DEP,"
			+ " DE.NOMBRE AS NOM_DEP,"
			+ " ES.COD_PRO,"
			+ " PR.NOMBRE AS NOM_PRO,"
			+ " ES.COD_DIS,"
			+ " DI.NOMBRE AS NOM_DIS,"
			+ " ES.NRO_RUC,"
			+ " ES.NOMBRE_ESTABLECIMIENTO,"
			+ " ES.DIRECCION,"
			+ " ES.CORREO,"
			+ " ES.TELEFONO,"
			+ " ES.ESTADO "
			+ " FROM ESCUELAS_CONDUCTORES ES "
			+ " INNER JOIN DEPARTAMENTOS DE ON ES.COD_DEP = DE.COD_DEP "
			+ " INNER JOIN PROVINCIAS PR ON ES.COD_PRO = PR.COD_PRO "
			+ " INNER JOIN DISTRITOS DI ON ES.COD_DIS = DI.COD_DIS "
			+ " WHERE  upper(ES.NOMBRE_ESTABLECIMIENTO) like upper(:nombre) "
			+ " AND  ELIMINADO = 0", nativeQuery = true)	
	List<EscuelaConductorConsultaEntity> findNombreLikeCustom(@Param("nombre") String nombre);
	
	@Query(value = "SELECT ES.ID,"
			+ " ES.COD_DEP,"
			+ " DE.NOMBRE AS NOM_DEP,"
			+ " ES.COD_PRO,"
			+ " PR.NOMBRE AS NOM_PRO,"
			+ " ES.COD_DIS,"
			+ " DI.NOMBRE AS NOM_DIS,"
			+ " ES.NRO_RUC,"
			+ " ES.NOMBRE_ESTABLECIMIENTO,"
			+ " ES.DIRECCION,"
			+ " ES.CORREO,"
			+ " ES.TELEFONO,"
			+ " ES.ESTADO "
			+ " FROM ESCUELAS_CONDUCTORES ES "
			+ " INNER JOIN DEPARTAMENTOS DE ON ES.COD_DEP = DE.COD_DEP "
			+ " INNER JOIN PROVINCIAS PR ON ES.COD_PRO = PR.COD_PRO "
			+ " INNER JOIN DISTRITOS DI ON ES.COD_DIS = DI.COD_DIS "
			+ " WHERE  ( "
			+ "        upper(DE.NOMBRE) like upper(:nombre) or "
			+ "        upper(PR.NOMBRE) like upper(:nombre) or "
			+ "        upper(DI.NOMBRE) like upper(:nombre) "
			+ "    ) "
			+ " AND  ELIMINADO = 0", nativeQuery = true)	
	List<EscuelaConductorConsultaEntity> findUbigeoLikeCustom(@Param("nombre") String nombre);

/*	
	@Query(value = "SELECT COD_DEP, COD_PRO, NOMBRE FROM PROVINCIAS "
			+ " where COD_DEP = :codigoDepartamento and upper(NOMBRE) like upper(:nombre) ", nativeQuery = true)	
	List<ProvinciaEntity> findNombreLikeCustomA( @Param("codigoDepartamento") String codigoDepartamento, @Param("nombre") String nombre);
*/
}
