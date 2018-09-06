package model3.DTO;

import java.util.Date;

public class QnaBoardBean {
	private int qnaNum;
	private String memberId; 
	private String qnaPw; 
	private String qnaSubject;
	private String qnaContent; 
	private String qnaImage; 
	private int qnaRef; 
	private int qnaLev; 
	private int qnaSeq; 
	private int qnaReadcount; 
	private Date qnaRegdate;
	
	public int getQnaNum() {
		return qnaNum;
	}
	public void setQnaNum(int qnaNum) {
		this.qnaNum = qnaNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getQnaPw() {
		return qnaPw;
	}
	public void setQnaPw(String qnaPw) {
		this.qnaPw = qnaPw;
	}
	public String getQnaSubject() {
		return qnaSubject;
	}
	public void setQnaSubject(String qnaSubject) {
		this.qnaSubject = qnaSubject;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaImage() {
		return qnaImage;
	}
	public void setQnaImage(String qnaImage) {
		this.qnaImage = qnaImage;
	}
	public int getQnaRef() {
		return qnaRef;
	}
	public void setQnaRef(int qnaRef) {
		this.qnaRef = qnaRef;
	}
	public int getQnaLev() {
		return qnaLev;
	}
	public void setQnaLev(int qnaLev) {
		this.qnaLev = qnaLev;
	}
	public int getQnaSeq() {
		return qnaSeq;
	}
	public void setQnaSeq(int qnaSeq) {
		this.qnaSeq = qnaSeq;
	}
	public int getQnaReadcount() {
		return qnaReadcount;
	}
	public void setQnaReadcount(int qnaReadcount) {
		this.qnaReadcount = qnaReadcount;
	}
	public Date getQnaRegdate() {
		return qnaRegdate;
	}
	public void setQnaRegdate(Date qnaRegdate) {
		this.qnaRegdate = qnaRegdate;
	}
	
	
}
