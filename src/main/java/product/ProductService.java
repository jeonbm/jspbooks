package product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	
	Map<String,Product> productList = new HashMap<>();
	
	public ProductService() {
		Product p1 = new Product("101","아이폰","Apple inc", 1500000, "20240116");
		productList.put("101",p1);
		
		Product p2 = new Product("102","갤럭시","Samsung Electronic", 1300000, "20240116");
		productList.put("102",p2);
		
		Product p3 = new Product("103","벨벳","LG Electronic", 800000, "20240116");
		productList.put("103",p3);
	}
	
	public List<Product> findAll(){
		return new ArrayList<>(productList.values());
	}
	
	public Product getId(String _id) {
		return productList.get(_id);
	}
	

}
