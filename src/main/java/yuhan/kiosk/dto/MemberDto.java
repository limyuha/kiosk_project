package yuhan.kiosk.dto;
import java.util.Date;

public class MemberDto {
	
	//member table
	private int seq;
	private String id;
	private String password;
	private String tel;
	Date date;
	
	public MemberDto() {
		
	}
	
	public MemberDto(int seq, String id, String password, String tel, Date date) {
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.tel = tel;
		this.date = date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
