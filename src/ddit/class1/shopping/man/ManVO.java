package ddit.class1.shopping.man;

public class ManVO {
	private int manNo;
	private String manNm;
	private String manId;
	private String manPw;
	
	public ManVO() {
	}
	
	public ManVO(String manId, String manPw) {
		
		this.manId = manId;
		this.manPw = manPw;
	}

	public ManVO(int manNo, String manNm, String manId, String manPw) {
		super();
		this.manNo = manNo;
		this.manNm = manNm;
		this.manId = manId;
		this.manPw = manPw;
	}

	public int getManNo() {
		return manNo;
	}

	public void setManNo(int manNo) {
		this.manNo = manNo;
	}

	public String getManNm() {
		return manNm;
	}

	public void setManNm(String manNm) {
		this.manNm = manNm;
	}

	public String getManId() {
		return manId;
	}

	public void setManId(String manId) {
		this.manId = manId;
	}

	public String getManPw() {
		return manPw;
	}

	public void setManPw(String manPw) {
		this.manPw = manPw;
	}
	
	public void invalidate() {
		this.manNo = 0;
		this.manId  =  null;
		this.manNm  = null;
		this.manPw = null;
	}          
}
