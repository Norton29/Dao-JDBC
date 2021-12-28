package application;

import java.util.List;
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
		
		System.out.println("\n=== Test4: FindAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department dep2 : list ) {
			System.out.println(dep2);
		}
		
		System.out.println("\n=== Test5: Update ===");
		dep = departmentDao.findById(2);
		dep.setName("Cloth");
		departmentDao.update(dep);
		
		
		
		sc.close();
	}

}
