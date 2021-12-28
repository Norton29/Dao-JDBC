package application;

import java.util.Scanner;

import model.Dao.DaoFactory;
import model.Dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		/*
		System.out.println("\n=== Test1: Insert ===");
		Department dep = new Department(null, "Carros");
		departmentDao.insert(dep);
		System.out.println("Departamento Incluído");
		
		
		System.out.println("\n=== Test2: DeleteByID ===");
		System.out.println("Digite o Id que deseja deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);*/
		
		System.out.println("\n=== Test3: FindByID ===");
		System.out.println("Digite o Id que deseja buscar: ");
		int id = sc.nextInt();
		Department dep = departmentDao.findById(id);
		System.out.println(dep);
		
		
		
		sc.close();
	}

}
