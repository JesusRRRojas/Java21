package com.pe.proyecto.api_jersey.escuelaConductores.entity.id;

public class ProvinciaId {
	private String COD_DEP;
	

	private String COD_PRO;
	public ProvinciaId()
	{}
	public ProvinciaId(String cod_dep, String cod_pro)
	{
		this.COD_DEP = cod_dep;
		this.COD_PRO = cod_pro;
	}
	public String getCOD_DEP() {
		return COD_DEP;
	}
	public void setCOD_DEP(String cod_dep) {
		this.COD_DEP = cod_dep;
	}
	public String getCOD_PRO() {
		return COD_PRO;
	}
	public void setCOD_PRO(String cod_pro) {
		this.COD_PRO = cod_pro;
	}
	
}
