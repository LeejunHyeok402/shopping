package ddit.class1.shopping.join;

public class CustomerVO {
	

	private int cusNo;
    private String cusId;
    private String cusNm;
    private String cusAddr;
    private String cusPh;
    private String cusMail;
    private String cusPw;

   public CustomerVO() {
   }
   
   public CustomerVO(String cusId, String cusPw) {
      this.cusId = cusId;
      this.cusPw = cusPw;
   }

   public CustomerVO(String cusId, String cusNm, String cusAddr, String cusPh, String cusMail, String cusPw) {
	   this.cusId = cusId;
	   this.cusNm = cusNm;
	   this.cusAddr = cusAddr;
	   this.cusPh = cusPh;
	   this.cusMail = cusMail;
	   this.cusPw = cusPw;
   }
   public CustomerVO(int cusNo, String cusId, String cusNm, String cusAddr,  String cusPh, String cusMail, String cusPw) {
      this.cusNo = cusNo;
      this.cusId = cusId;
      this.cusNm = cusNm;
      this.cusAddr = cusAddr;
      this.cusPh = cusPh;
      this.cusMail = cusMail;
      this.cusPw = cusPw;
   }
   
public int getCusNo() {
   return cusNo;
}

public void setCusNo(int cusNo) {
   this.cusNo = cusNo;
}

public String getCusId() {
   return cusId;
}

public void setCusId(String cusId) {
   this.cusId = cusId;
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

public String getCusPh() {
   return cusPh;
}

public void setCusPh(String cusPh) {
   this.cusPh = cusPh;
}

public String getCusMail() {
   return cusMail;
}

public void setCusMail(String cusMail) {
   this.cusMail = cusMail;
}

public String getCusPw() {
   return cusPw;
}

public void setCusPw(String cusPw) {
   this.cusPw = cusPw;
}
public void invalidate() {
	this.cusNo = 0;
	this.cusId  =  null;
	this.cusNm  = null;
	this.cusAddr  = null;
	this.cusPh =  null;
	this.cusMail = null;
	this.cusPw = null;
}          
	
@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerVO{");
        sb.append("userId=").append(cusId);
        sb.append(", name='").append(cusNm).append('\'');
        sb.append(", address='").append(cusAddr).append('\'');
        sb.append(", phone='").append(cusPh).append('\'');
        sb.append(", password='").append(cusPw).append('\'');
        sb.append('}');
        return sb.toString();
    }
}