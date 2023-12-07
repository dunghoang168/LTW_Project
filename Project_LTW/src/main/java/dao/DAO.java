/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;

/**
 *
 * @author trinh
 */
public class DAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static DAO instance = null;

	private DAO() {
	};

	public static DAO getInstance() {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		String query = "select * from product";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		String query = "select * from Category";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Product getLast() {
		String query = "select top 1 * from product\n" + "order by id desc";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<Product> getProductByCID(String cateID) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product \n" + "where cateID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, cateID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Product getProductByID(String id) {
		String query = "select * from product \n" + "where id = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6));
			}

		} catch (Exception e) {
		}
		return null;
	}

	public Account getAccountBySellID(String id) {
		String query = "select * from account \n" + "where  isSell = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}

		} catch (Exception e) {
		}
		return null;
	}

	public Account getAccountByID(String id) {
		String query = "select * from account \n" + "where uID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}

		} catch (Exception e) {
		}
		return null;
	}

	public List<Product> getProductBySellID(int id) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product \n" + "where sell_ID = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> getProductBySearch(String textSearch) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product \n" + "where [name] like ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + textSearch + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Account login(String user, String pass) {
		String query = "select * from Account \n" + "where [user] = ? \n" + "and pass = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));

			}
		} catch (Exception e) {
		}

		return null;

	}

	public void signup(String user, String pass) {
		String query = "insert into Account \n" + " values (?,?,0,0)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	public Account checkAccountExist(String user) {
		String query = "select * from Account \n" + "where [user] = ? \n";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public void delete(String pid) {
		String query = "delete from product \n" + "where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, pid);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	public void deleteAcc(String aid) {
		String query = "delete from account \n" + "where uID = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, aid);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	public void insertProduct(String name, String image, String price, String title, String description,
			String category, int sid) {
		String query = "insert into product \n" + "VALUES (?,?,?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, category);
			ps.setInt(7, sid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void insertAccount(String user, String pass, int isSell, int isAdmin) {
		String query = "insert into account \n" + "VALUES (?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setInt(3, isSell);
			ps.setInt(4, isAdmin);

			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void editProduct(String name, String image, String price, String title, String description, String category,
			String sid) {
		String query = "update product\r\n" + "set [name] = ?,\r\n" + "[image] = ?,\r\n" + "price = ?,\r\n"
				+ "[title] = ?,\r\n" + "[description] = ?,\r\n" + "[cateID] = ?\r\n" + "where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, category);
			ps.setString(7, sid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	public void editAccount(String user,String pass, int isSell, int isAdmin, String aid ) {
		String query = "update account\r\n" + "set [user] = ?,\r\n" + "[pass] = ?,\r\n"  
				+ "[isSell] = ?,\r\n" + "[isAdmin] = ?\r\n" 
				+ "where uID = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setInt(3, isSell);
			ps.setInt(4, isAdmin);
			ps.setString(5, aid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public List<Product> getProductLast() {
		List<Product> list = new ArrayList<>();
		String query = "select * from product \n" + "where( id  <=3 )";
		;
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> getProductBest() {
		List<Product> list = new ArrayList<>();
		String query = "select * from product \n" + "where( id  >13 )";
		;
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Account> getAllAccount() {
		List<Account> list = new ArrayList<>();
		String query = "select * from account";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public static void main(String[] args) {
		DAO dao = new DAO();
		// Account a = dao.login("aaa1","1");
		// dao.signup("aaa1","1");
		// System.out.println(dao.getCartProductByID("1"));
	

	}

}
