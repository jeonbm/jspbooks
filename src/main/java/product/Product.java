package product;

public class Product {
	private String id;
	private String name;
	private String maker;
	private int price;
	private String date;
	
	//생성자 초기화
	public Product(String _id,String _name,String _maker,int _price,String _date) {
		this.id = _id;
		this.name = _name;
		this.maker = _maker;
		this.price = _price;
		this.date = _date;
	}

	// 게터세터 구현
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
