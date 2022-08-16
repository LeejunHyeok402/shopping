package ddit.class1.shopping.notice;

import java.util.Objects;

public class NoticeVO {
   private int notiNo;
   private String notiCont;
   private String notiDate;
   private int manNo;
   private String notiTitle;
   
   
  
   public NoticeVO() {
   
}



public NoticeVO(int notiNo) {
   this.notiNo = notiNo;
}



public NoticeVO(String notiCont, String notiTitle) {
	this.notiCont = notiCont;
	this.notiTitle = notiTitle;
}



public NoticeVO(int notiNo, String notiCont, String notiDate, int manNo, String notiTitle) {
   
   this.notiNo = notiNo;
   this.notiCont = notiCont;
   this.notiDate = notiDate;
   this.manNo = manNo;
   this.notiTitle = notiTitle;
}

public int getNotiNo() {
   return notiNo;
}

public void setNotiNo(int notiNo) {
   this.notiNo = notiNo;
}

public String getNotiCont() {
   return notiCont;
}

public void setNotiCont(String notiCont) {
   this.notiCont = notiCont;
}

public String getNotiDate() {
   return notiDate;
}

public void setNotiDate(String notiDate) {
   this.notiDate = notiDate;
}

public int getManNo() {
   return manNo;
}


public void setManNo(int manNo) {
   this.manNo = manNo;
}

public String getNotiTitle() {
   return notiTitle;
}

public void setNotiTitle(String notiTitle) {
   this.notiTitle = notiTitle;
}

@Override
public int hashCode() {
   return Objects.hash(manNo, notiCont, notiDate, notiNo, notiTitle);
}

@Override
public boolean equals(Object obj) {
   if (this == obj) {
      return true;
   }
   if (!(obj instanceof NoticeVO)) {
      return false;
   }
   NoticeVO other = (NoticeVO) obj;
   return manNo == other.manNo && Objects.equals(notiCont, other.notiCont) && Objects.equals(notiDate, other.notiDate)
         && notiNo == other.notiNo && Objects.equals(notiTitle, other.notiTitle);
}

@Override
   public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerVO{");
        sb.append("notiNo=").append(notiNo);
        sb.append(", notiCont='").append(notiCont).append('\'');
        sb.append(", notiDate='").append(notiDate).append('\'');
        sb.append(", manNo='").append(manNo).append('\'');
        sb.append(", notiTitle='").append(notiTitle).append('\'');
        sb.append('}');
        return sb.toString();
   }
   
   
}