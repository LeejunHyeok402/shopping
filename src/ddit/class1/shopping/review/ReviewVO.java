package ddit.class1.shopping.review;

public class ReviewVO {
	private int revNo;
	private String revCont;
	private String revDt;
	private int cusNo;
	private int cartNo;
	private int prodNo;
	private String revTitle;
	private String prodNm;
	private String cusNm;


	public ReviewVO() {
		super();
	}


	public ReviewVO(int cartNo, String revTitle, String revCont,int prodNo, int cusNo) {
		   this.revCont = revCont;
		   this.cusNo = cusNo;
		   this.cartNo = cartNo;
		   this.revTitle = revTitle;
		   this.prodNo = prodNo;
		}
	public ReviewVO(String revCont, String revTitle) {
		super();
		this.revCont = revCont;
		this.revTitle = revTitle;
	}



	public ReviewVO(int revNo, String revCont, String revDt, int cusNo, int cartNo, int prodNo, String revTitle,
			String prodNm, String cusNm) {
		super();
		this.revNo = revNo;
		this.revCont = revCont;
		this.revDt = revDt;
		this.cusNo = cusNo;
		this.cartNo = cartNo;
		this.prodNo = prodNo;
		this.revTitle = revTitle;
		this.prodNm = prodNm;
		this.cusNm = cusNm;
	}


	public int getRevNo() {
		return revNo;
	}


	public void setRevNo(int revNo) {
		this.revNo = revNo;
	}


	public String getRevCont() {
		return revCont;
	}


	public void setRevCont(String revCont) {
		this.revCont = revCont;
	}


	public String getRevDt() {
		return revDt;
	}


	public void setRevDt(String revDt) {
		this.revDt = revDt;
	}


	public int getCusNo() {
		return cusNo;
	}


	public void setCusNo(int cusNo) {
		this.cusNo = cusNo;
	}


	public int getCartNo() {
		return cartNo;
	}


	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}


	public int getProdNo() {
		return prodNo;
	}


	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}


	public String getRevTitle() {
		return revTitle;
	}


	public void setRevTitle(String revTitle) {
		this.revTitle = revTitle;
	}


	public String getProdNm() {
		return prodNm;
	}


	public void setProdNm(String prodNm) {
		this.prodNm = prodNm;
	}


	public String getCusNm() {
		return cusNm;
	}


	public void setCusNm(String cusNm) {
		this.cusNm = cusNm;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("CustomerVO{");
		sb.append("revNo=").append(revNo);
		sb.append(", revCont='").append(revCont).append('\'');
		sb.append(", revDt='").append(revDt).append('\'');
		sb.append(", cusNo='").append(cusNo).append('\'');
		sb.append(", cartNo='").append(cartNo).append('\'');
		sb.append(", prodNo='").append(prodNo).append('\'');
		sb.append(", cusNm='").append(cusNm).append('\'');
		sb.append(", prodNm='").append(prodNm).append('\'');
		sb.append('}');
		return sb.toString();
	}
}