package application;

import java.util.Date;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Books");

		
		Seller seller = new Seller(1, "Norton", "norton@gmail", new Date(), 2000.0, obj);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		sellerDao.insert(seller);
		System.out.println(seller);
	}

}
