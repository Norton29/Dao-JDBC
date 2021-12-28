package application;

import java.util.List;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test1: findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test2: findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj: list) {
			System.out.println(obj);
			
		}		
		System.out.println("\n=== Test3: findByAll ===");
		list = sellerDao.findAll();
		for(Seller obj: list) {
			System.out.println(obj);
			
		}
		/*System.out.println("\n=== Test4: Insert ===");
		Seller newSeller = new Seller(null, "Nortinho","nortno@hotmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		*/
		System.out.println("\n=== Test5: Update ===");
		seller = sellerDao.findById(2);
		seller.setName("Carmelia");
		sellerDao.uptade(seller);
		System.out.println("Update Complete");
		
}
}
