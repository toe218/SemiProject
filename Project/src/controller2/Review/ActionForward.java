package controller2.Review;

public class ActionForward { //주소를 반환하기 위해서 만든 것 
	
	private boolean isRedirect = false; // forward인지 sendredirect인지 구분하기 위한 변수
	
	private String path = null; // 주소를 저장
	
	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
