package com.pe.proyecto.api_jersey.escuelaConductores.entity.id;

public class DistritoId {

	private String COD_DEP;
	

	private String COD_PRO;
	

	private String COD_DIS;
	
	public DistritoId()
	{}
	public DistritoId(String cod_dep, String cod_pro, String cod_dis)
	{
		this.COD_DEP = cod_dep;
		this.COD_PRO = cod_pro;
		this.COD_DIS = cod_dis;
	}

	public String getCOD_DEP() {
		return COD_DEP;
	}

	public void setCOD_DEP(String cOD_DEP) {
		COD_DEP = cOD_DEP;
	}

	public String getCOD_PRO() {
		return COD_PRO;
	}

	public void setCOD_PRO(String cOD_PRO) {
		COD_PRO = cOD_PRO;
	}

	public String getCOD_DIS() {
		return COD_DIS;
	}

	public void setCOD_DIS(String cOD_DIS) {
		COD_DIS = cOD_DIS;
	}
	
}
