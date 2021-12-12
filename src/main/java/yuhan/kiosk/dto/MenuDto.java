package yuhan.kiosk.dto;

import java.util.ArrayList;

public class MenuDto {
	
	//menu table
	private int seq;
	private int category;
	private int sale_num;
	private String name;
	private int price;
	private int provid;
	private int saturated_fat;
	private int protein;
	private int sodium;
	private int sugar;
	private int caffeine;
	private String allergy;
	private String context;
	
	//menu_img table
	private int menu_seq;
	private String img_url;
	
	//test
	private ArrayList<MenuDto> item;
	
	//생성자 필요
	public MenuDto() {
		
	}
	
	public MenuDto(int seq, int category, int sale_num, String name, int price, int provid, int saturated_fat, 
			int protein, int sodium, int sugar, int caffeine, String allergy, String context,
			int menu_seq, String img_url) {
		
		//menu table
		this.seq = seq;
		this.category = category;
		this.sale_num = sale_num;
		this.name = name;
		this.price = price;
		this.provid = provid;
		this.saturated_fat = saturated_fat;
		this.protein = protein;
		this. sodium = sodium;
		this.sugar = sugar;
		this.caffeine = caffeine;
		this.allergy = allergy;
		this.context = context;
		
		//menu_img table
		this.menu_seq = menu_seq;
		this.img_url = img_url;
	}

	//menu_table
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getSale_num() {
		return sale_num;
	}

	public void setSale_num(int sale_num) {
		this.sale_num = sale_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProvid() {
		return provid;
	}

	public void setProvid(int provid) {
		this.provid = provid;
	}

	public int getSaturated_fat() {
		return saturated_fat;
	}

	public void setSaturated_fat(int saturated_fat) {
		this.saturated_fat = saturated_fat;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	public int getCaffeine() {
		return caffeine;
	}

	public void setCaffeine(int caffeine) {
		this.caffeine = caffeine;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	//menu_img table
	public int getMenu_seq() {
		return menu_seq;
	}

	public void setMenu_seq(int menu_seq) {
		this.menu_seq = menu_seq;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public ArrayList<MenuDto> getItem() {
		return item;
	}

	public void setItem(ArrayList<MenuDto> item) {
		this.item = item;
	
	}

}
