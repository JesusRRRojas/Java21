package com.pe.proyecto.api.entity;

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
	
	/*
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    DistritoId that = (DistritoId) o;

	    if (!COD_DEP.equals(that.COD_DEP)) return false;
	    if (!COD_PRO.equals(that.COD_PRO)) return false;
	    return COD_DIS.equals(that.COD_DIS);
	}

	@Override
	public int hashCode() {
		int result = COD_DEP.hashCode();
	    result = 31 * result + COD_PRO.hashCode();
	    result = 31 * result + COD_DIS.hashCode();
	    return result;
	}
	 */
	
	
}