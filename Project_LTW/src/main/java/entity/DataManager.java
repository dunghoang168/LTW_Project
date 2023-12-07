package entity;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
	ArrayList<Product> products;
	ArrayList<Category> categorys;
	
	private static DataManager instance = null;
	
	private  DataManager() {
		products = new ArrayList();
		categorys = new ArrayList();
	}

	
	public static DataManager getInstance() {
		if(instance == null) {
			instance = new DataManager();
		}
		return instance;
	}


	public ArrayList<Product> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}


	public ArrayList<Category> getCategorys() {
		return categorys;
	}


	public void setCategorys(ArrayList<Category> categorys) {
		this.categorys = categorys;
	}
	
	
}
