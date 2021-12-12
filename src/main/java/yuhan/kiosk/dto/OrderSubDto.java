package yuhan.kiosk.dto;

public class OrderSubDto extends MenuCartDto{
	private int seq;
	private int order_seq;
	private int menu_seq;
	private String cup_size;
	private String cup_choice;
	private int ea;
	
	public OrderSubDto() {
		
	}
	
	public OrderSubDto(int seq, int order_seq, int menu_seq, String cup_size, String cup_choice, int ea) {
		this.seq = seq;
		this.order_seq = order_seq;
		this.menu_seq = menu_seq;
		this.cup_size = cup_size;
		this.cup_choice = cup_choice;
		this.ea = ea;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getOrder_seq() {
		return order_seq;
	}

	public void setOrder_seq(int order_seq) {
		this.order_seq = order_seq;
	}

	public int getMenu_seq() {
		return menu_seq;
	}

	public void setMenu_seq(int menu_seq) {
		this.menu_seq = menu_seq;
	}

	public String getCup_size() {
		return cup_size;
	}

	public void setCup_size(String cup_size) {
		this.cup_size = cup_size;
	}

	public String getCup_choice() {
		return cup_choice;
	}

	public void setCup_choice(String cup_choice) {
		this.cup_choice = cup_choice;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}
}
