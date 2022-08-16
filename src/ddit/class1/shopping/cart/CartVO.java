package ddit.class1.shopping.cart;

import java.time.LocalDate;

public class CartVO {
	private int cartNo;
	private int prodNo;
	private int cusNo;
	private String cusNm;
	private String cusAddr;
	private LocalDate purDt;
	private int purQty;
	private String prodNm;
	private String prodCol;
	private String prodSize;
	private String prodPri;
	private String total;
	private int sumPri;

	public CartVO() {

	}

	public CartVO(int cusNo) {

		this.cusNo = cusNo;
	}

	public CartVO(int prodNo, int purQty, int cusNo) {
		super();
		this.prodNo = prodNo;
		this.purQty = purQty;
		this.cusNo = cusNo;
	}
	public CartVO(int cartNo, int prodNo, int cusNo, LocalDate purDt, int purQty, String prodNm, String prodCol,
			String prodSize, String prodPri, String total) {
		super();
		this.cartNo = cartNo;
		this.prodNo = prodNo;
		this.cusNo = cusNo;
		this.purDt = purDt;
		this.purQty = purQty;
		this.prodNm = prodNm;
		this.prodCol = prodCol;
		this.prodSize = prodSize;
		this.prodPri = prodPri;
		this.total = total;
	}




	public String getCusNm() {
		return cusNm;
	}

	public void setCusNm(String cusNm) {
		this.cusNm = cusNm;
	}

	public String getCusAddr() {
		return cusAddr;
	}

	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}

	public int getSumPri() {
		return sumPri;
	}

	public void setSumPri(int sumPri) {
		this.sumPri = sumPri;
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

	public int getCusNo() {
		return cusNo;
	}

	public void setCusNo(int cusNo) {
		this.cusNo = cusNo;
	}

	public LocalDate getPurDt() {
		return purDt;
	}

	public void setPurDt(LocalDate purDt) {
		this.purDt = purDt;
	}

	public int getPurQty() {
		return purQty;
	}

	public void setPurQty(int purQty) {
		this.purQty = purQty;
	}

	public String getProdNm() {
		return prodNm;
	}

	public void setProdNm(String prodNm) {
		this.prodNm = prodNm;
	}

	public String getProdCol() {
		return prodCol;
	}

	public void setProdCol(String prodCol) {
		this.prodCol = prodCol;
	}

	public String getProdSize() {
		return prodSize;
	}

	public void setProdSize(String prodSize) {
		this.prodSize = prodSize;
	}

	public String getProdPri() {
		return prodPri;
	}

	public void setProdPri(String prodPri) {
		this.prodPri = prodPri;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("OrderVO{");
		sb.append("carNo=").append(cartNo);
		sb.append(", prodNo=").append(prodNo);
		sb.append(", cusNo=").append(cusNo);
		sb.append(", purDt='").append(purDt);
		sb.append(", purQty=").append(purQty);
		sb.append(", prodNm=").append(prodNm);
		sb.append(", prodCol=").append(prodCol);
		sb.append(", prodSize=").append(prodSize);
		sb.append(", prodPri=").append(prodPri);
		sb.append(", total=").append(total).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
