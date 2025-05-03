package com.pe.proyecto.consola;

import com.pe.proyecto.interfaces.DepartamentoDAO;
import com.pe.proyecto.interfaces.EscuelaConductorDAO;

import java.util.List;
import java.util.Scanner;

import com.pe.proyecto.entity.Departamento;
import com.pe.proyecto.entity.EscuelaConductor;
import com.pe.proyecto.persistencia.DepartamentoImpl;
import com.pe.proyecto.persistencia.EscuelaConductorImpl;

public class Consola {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		//insertarDataUbigeo();
		//insertarEscuela();	
		//actualizarEscuela();
		//eliminarEscuela(3l);
		
		listarEscuela("",1);
		
		/*Scanner scanner = new Scanner(System.in);
	
		int opcion = 0;
		
		do 
		{
			printMenu();
			
			System.out.print("Seleccione una opcion: ");
			opcion = scanner.nextInt();
			
			switch (opcion) {
	        case 1:
	        	printMenuLista();
	        	int opcionBusqueda = 0;
	        	String nombreBusqueda = "" ;
	        	
	        	System.out.print("Seleccione una opcion: ");
				opcionBusqueda = scanner.nextInt();
				
	        	System.out.print("Ingrese el valor a buscar: ");
	        	nombreBusqueda = scanner.next();
	        	
	        	if (opcionBusqueda == 1 ||opcionBusqueda == 2 )
	        		listarEscuela(nombreBusqueda, opcionBusqueda);
	        	else
	        		opcion = 5;
	            
	        	break;
	        case 2:
	        	insertarEscuela();	
	            break;
	        case 3:
	            System.out.println("Has seleccionado Actualizar Escuela.");

	            break;
	        case 4:
	            System.out.println("Has seleccionado Eliminar Escuela.");
	        
	            break;
	        default:
	            System.out.println("Opción no válida.");
	            break;
			}
			
			
			
			Thread.sleep(3000);			
		}
		while( opcion  != 5);

		scanner.close();
	
		*/
	}
	
	private static void printMenu()
	{
		System.out.println("==============================================");
		System.out.println("Sistema de Escuela de Conductor");
		System.out.println("==============================================");
		System.out.println("=    MENU");
		System.out.println("=    1. Listar Escuelas");
		System.out.println("=    2. Crear Escuela");
		System.out.println("=    3. Actualizar Escuela");
		System.out.println("=    4. Eliminar Escuela");		
		System.out.println("=    5. Salir");		
		System.out.println("==============================================");
		
	}
	private static void printMenuLista()
	{
		System.out.println("==============================================");
		System.out.println("=    Busqueda por : ");
		System.out.println("=    1. Departamneto, Provincia o Distrito");
		System.out.println("=    2. Nombre de escuela");
		System.out.println("=    5. Salir");		
		System.out.println("==============================================");
	}
	
	private static void insertarDataUbigeo()
	{
		insertarDepartamento("26", "Test");
	}
	
	private static void insertarDepartamento(String CodigoDepartamneto, String NombreDepartamento)
	{
		try {
			
			//ProductoDAOImpl productoDAOImpl= new ProductoDAOImpl();
			DepartamentoDAO departamentoDAO= new DepartamentoImpl();
			
			Departamento departamento= new Departamento(CodigoDepartamneto,NombreDepartamento);

			if (departamentoDAO.insertar(departamento)) {
				System.out.println("El DEPARTAMENTO ha sido registrado con exito");
			}else {
				System.err.println("Error al registrar el DEPARTAMENTO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void listarEscuela(String nombre, Integer opcion)
	{
		System.out.println("Ingresando a istar");
		try
		{
			EscuelaConductorDAO escuelaDAO = new EscuelaConductorImpl();
			List<EscuelaConductor> lista =  escuelaDAO.listar(nombre, opcion);
			for (EscuelaConductor escuelaConductor : lista) {
				System.out.println(escuelaConductor.toString());				
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void insertarEscuela()
	{
		try
		{
			EscuelaConductorDAO escuelaDAO = new EscuelaConductorImpl();
			
			EscuelaConductor escuela = new EscuelaConductor( 
					"01", 
					"0101",
					"010101",
					"20000000006",
					"Primera Escuela ABC",
					"av. Las americas N 123",
					"abc@gmail.com",
					"981212121",
					"Activo") ;
			if (escuelaDAO.insertar(escuela))
			{
				System.out.println("La escuela de conductores ha sido registrado con exito");
			}else {
				System.err.println("Error al registrar la escuela de conductores");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private static void actualizarEscuela()
	{
		try
		{
			EscuelaConductorDAO escuelaDAO = new EscuelaConductorImpl();
			
			EscuelaConductor escuela = new EscuelaConductor( 
					1,
					"01", 
					"0101",
					"010101",
					"20000000003",
					"Nombre modificado",
					"av. Las americas N 123",
					"abc@gmail.com",
					"981212121",
					"Activo") ;
			if (escuelaDAO.actualizar(escuela))
			{
				System.out.println("La escuela de conductores ha sido modificado con exito");
			}else {
				System.err.println("Error al actualizar la escuela de conductores");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	private static void eliminarEscuela(Long id)
	{
		try
		{
			EscuelaConductorDAO escuelaDAO = new EscuelaConductorImpl();
			
			if (escuelaDAO.eliminar(id))
			{
				System.out.println("La escuela de conductores ha sido eliminado con exito");
			}else {
				System.err.println("Error al eliminar la escuela de conductores");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
