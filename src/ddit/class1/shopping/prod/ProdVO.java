package ddit.class1.shopping.prod;

import java.util.Objects;

public class ProdVO {

	private int prodNo;
   private String prodSize;
   private String prodCol;
   private String prodNm;
   private int prodPri;
   private int prodQty;
   private int manNo;
   
   public ProdVO() {
   }
   
   public ProdVO(int prodNo) {
	super();
	this.prodNo = prodNo;
}
   public ProdVO(String prodNm, String prodSize, String prodCol, int prodPri, int prodQty) {
	   this.prodSize = prodSize;
	   this.prodCol = prodCol;
	   this.prodNm = prodNm;
	   this.prodPri = prodPri;
	   this.prodQty = prodQty;
	}
   

public ProdVO(int prodNo, String prodSize, String prodCol, String prodNm, int prodPri, int prodQty, int manNo) {

   this.prodNo = prodNo;
   this.prodSize = prodSize;
   this.prodCol = prodCol;
   this.prodNm = prodNm;
   this.prodPri = prodPri;
   this.prodQty = prodQty;
   this.manNo = manNo;
}

public int getProdNo() {
   return prodNo;
}

public void setProdNo(int prodNo) {
   this.prodNo = prodNo;
}

public String getProdSize() {
   return prodSize;
}

public void setProdSize(String prodSize) {
   this.prodSize = prodSize;
}

public String getProdCol() {
   return prodCol;
}

public void setProdCol(String prodCol) {
   this.prodCol = prodCol;
}

public String getProdNm() {
   return prodNm;
}

public void setProdNm(String prodNm) {
   this.prodNm = prodNm;
}

public int getProdPri() {
   return prodPri;
}

public void setProdPri(int prodPri) {
   this.prodPri = prodPri;
}

public int getProdQty() {
   return prodQty;
}

public void setProdQty(int prodQty) {
   this.prodQty = prodQty;
}

public int getManNo() {
   return manNo;
}

public void setManNo(int manNo) {
   this.manNo = manNo;
}

@Override
public int hashCode() {
   return Objects.hash(manNo, prodCol, prodNm, prodNo, prodPri, prodQty, prodSize);
}

@Override
public boolean equals(Object obj) {
   if (this == obj) {
      return true;
   }
   if (!(obj instanceof ProdVO)) {
      return false;
   }
   ProdVO other = (ProdVO) obj;
   return manNo == other.manNo && Objects.equals(prodCol, other.prodCol) && Objects.equals(prodNm, other.prodNm)
         && prodNo == other.prodNo && Objects.equals(prodPri, other.prodPri) && prodQty == other.prodQty
         && Objects.equals(prodSize, other.prodSize);
}

@Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("ProdVO{");
      sb.append("prodNo=").append(prodNo);
      sb.append(", prodSize='").append(prodSize).append('\'');
      sb.append(", prodCol='").append(prodCol).append('\'');
      sb.append(", prodNm='").append(prodNm).append('\'');
      sb.append(", prodPri='").append(prodPri).append('\'');
      sb.append(", prodQty='").append(prodQty).append('\'');
      sb.append(", manNo='").append(manNo).append('\'');
      sb.append('}');
      return sb.toString();
   }
}