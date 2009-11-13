package cn.gdpu.action;

import com.opensymphony.xwork2.ActionSupport;

public class JumpAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	String url;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
