package model.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
	  try {  
		st = conn.prepareStatement(
				"SELECT seller.*,department.Name as DepName "
				+ "FROM seller INNER JOIN department "
				+ "ON seller.DepartmentId = department.Id "
				+ "WHERE seller.Id = ?");
		st.setInt(1, id);
		rs = st.executeQuery();
		
		if(rs.next()) {
			Department dep = InstantiationDepartment(rs);
			Seller obj = InstantiationSeller(rs, dep);
			return obj;
		}
		return null;
	  }
	  catch(SQLException e){
		  throw new DbException(e.getMessage());		  
	  }
	  finally {
		  DB.closeStatament(st);
		  DB.closeResultSet(rs);
		}
	}

	private Seller InstantiationSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setSalary(rs.getDouble("BaseSalary"));
		obj.setDepartment(dep);
		return obj;
	}

	private Department InstantiationDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
	  try {  
		st = conn.prepareStatement(
				"SELECT seller.*,department.Name as DepName "
				+ "FROM seller INNER JOIN department "
				+ "ON seller.DepartmentId = department.Id "
				+ "ORDER BY Name");
		
		rs = st.executeQuery();
		
		List<Seller> list = new ArrayList<>();
		Map<Integer, Department> map = new HashMap<>();
				
		while (rs.next()) {
			
			Department dep = map.get(rs.getInt("DepartmentId"));
			
			if(dep == null) {
				dep = InstantiationDepartment(rs);
				map.put(rs.getInt("DepartmentId"), dep);
			}		
			
			Seller obj = InstantiationSeller(rs, dep);
			list.add(obj);
		}
		return list;
	  }
	  catch(SQLException e){
		  throw new DbException(e.getMessage());		  
	  }
	  finally {
		  DB.closeStatament(st);
		  DB.closeResultSet(rs);
		}
	}


	
	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
	  try {  
		st = conn.prepareStatement(
				"SELECT seller.*,department.Name as DepName "
				+ "FROM seller INNER JOIN department "
				+ "ON seller.DepartmentId = department.Id "
				+ "WHERE DepartmentId = ? "
				+ "ORDER BY Name");
		
		st.setInt(1, department.getId());
		rs = st.executeQuery();
		
		List<Seller> list = new ArrayList<>();
		Map<Integer, Department> map = new HashMap<>();
				
		while (rs.next()) {
			
			Department dep = map.get(rs.getInt("DepartmentId"));
			
			if(dep == null) {
				dep = InstantiationDepartment(rs);
				map.put(rs.getInt("DepartmentId"), dep);
			}		
			
			Seller obj = InstantiationSeller(rs, dep);
			list.add(obj);
		}
		return list;
	  }
	  catch(SQLException e){
		  throw new DbException(e.getMessage());		  
	  }
	  finally {
		  DB.closeStatament(st);
		  DB.closeResultSet(rs);
		}
	}
}

