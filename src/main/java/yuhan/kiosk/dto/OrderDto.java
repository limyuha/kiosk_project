package yuhan.kiosk.dto;

import java.util.ArrayList;
import java.util.Date;

public class OrderDto {
	private int seq;
	private int member_seq;
	private int sum;
	Date date;
	
	private ArrayList<OrderSubDto> orderitem;
	
	public OrderDto() {
	
	}
	
	public OrderDto(int seq, int member_seq, int sum, Date date) {
		this.seq = seq;
		this.member_seq = member_seq;
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
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<OrderSubDto> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(ArrayList<OrderSubDto> orderitem) {
		this.orderitem = orderitem;
	}
}
