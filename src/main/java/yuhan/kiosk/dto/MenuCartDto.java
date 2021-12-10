package yuhan.kiosk.dto;

import java.util.Date;

public class MenuCartDto extends MenuDto{
	private int seq;
	private int member_seq;
	private int menu_seq;
	private String cup_size;
	private String cup_choice;
	private int ea;
	Date date;
	
	public MenuCartDto() {
	
	}
	
	public MenuCartDto( int seq, int member_seq, int menu_seq, String cup_size, String cup_choice, int ea, Date date) {
		this.seq = seq;
		this.member_seq = member_seq;
		this.menu_seq = member_seq;
		this.cup_size = cup_size;
		this.cup_choice = cup_choice;
		this.ea = ea;
		this.date = date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
