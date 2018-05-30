package org.struts.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ServletAPIAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 7067548548204336283L;
	
	private HttpServletRequest req1;
    private HttpServletRequest req2;
    private HttpServletRequest req3;
    
    @Override
    public String execute() throws Exception {
    	//第一种方式：ActionContext
        req1 = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        //第三种方式：ServletActionContext
        req3 = ServletActionContext.getRequest();
        return SUCCESS;
    }
    
    
    //第二种方式：实现*Aware接口
	@Override
	public void setServletRequest(HttpServletRequest request) {
		req2 = request;
	}

	public HttpServletRequest getReq1() {
		return req1;
	}


	public HttpServletRequest getReq2() {
		return req2;
	}


	public HttpServletRequest getReq3() {
		return req3;
	}

}
