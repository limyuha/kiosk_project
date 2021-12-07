package yuhan.kiosk.dao;

public class ListFormDto {
	private int seq;
	private String name;
	private String value;
	
	public ListFormDto() {
		
	}
	
	public ListFormDto(int seq, String name, String value) {
		this.seq = seq;
		this.name = name;
		this.value = value;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
