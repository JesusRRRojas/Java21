package com.pe.proyecto.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDConexion {
	private final String DRIVER_DEFAULT = "oracle.jdbc.OracleDriver";

	private String driver;
	private String url;
	private String userName;
	private String password;
	
	public BDConexion() {
		this.driver = DRIVER_DEFAULT;
		this.url = "";
		this.userName = "";
		this.password = "";
	}

	public BDConexion(String driver) {
		this();
		this.driver = driver;
	}

	public BDConexion(String driver, String url) {
		this(driver);
		this.url = url;
	}


	private Boolean loadDriver() {
		try {
			Class.forName(this.driver);
			return true;
		} catch (Exception e) {
			System.err.println("Error al cargar el driver \n" + e.getMessage());
			return false;
		}
	}
	
	public Connection getConnection() {
		try {
			if (!this.loadDriver()) {
				return null;
			}
			Connection cn = DriverManager.getConnection(this.url, this.userName, this.password);
			return cn;
		} catch (Exception e) {
			System.err.println("Error al conectar a la BD \n" + e.getMessage());
			return null;
		}
	}
	

	public Connection getConnection(String url, String userName, String password) {
		try {
			this.url = url;
			this.userName = userName;
			this.password = password;
			return getConnection();
			
		} catch (Exception e) {
			System.err.println("Error al conectar a la BD \n" + e.getMessage());
			return null;
		}
	}
	
	public Connection getConnection(String driver ,String url, String userName, String password) {
		try {
			this.setDriver(driver);
			return getConnection(url,userName,password);
			
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Error al conectar a la BD \n" + e.getMessage());
			return null;
		}

	}
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		if (driver==null || driver.trim().equals("")) 
		{
			System.err.println("El driver es requerido o no es válido");
		}
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDRIVER_DEFAULT() {
		return DRIVER_DEFAULT;
	}

	@Override
	public String toString() {
		return "BDConexion [DRIVER_DEFAULT=" + DRIVER_DEFAULT + ", driver=" + driver + ", url=" + url + ", userName="
				+ userName + ", password=" + password + "]";
	}
	
	

}
