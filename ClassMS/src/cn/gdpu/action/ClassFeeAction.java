package cn.gdpu.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.gdpu.service.ClassFeeService;
import cn.gdpu.vo.ClassFee;

import com.opensymphony.xwork2.ActionSupport;

public class ClassFeeAction extends ActionSupport implements RequestAware{
	
	private static final long serialVersionUID = 1L;


	ClassFeeService classFeeService = null;
	
	ClassFee classFee = null;
	
	Map request;
	
	String fid;
	

	//CRUD add() 添加班费记录
	public String doAdd() throws Exception{
		try {
			classFee.setTime(new Date());
			classFeeService.add(classFee);
			System.out.println("-----------添加班费记录成功-----------");
			return SUCCESS;
		} catch (RuntimeException e) {
			System.out.println("-----------添加班费记录失败-----------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//CRUD delete() 删除班费记录
	public String doDelete() throws Exception{
		try {
			classFeeService.delete(fid);
			System.out.println("-------删除班费记录" + fid + "--------");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("-------删除班费记录失败--------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//CRUD modify() 修改班费记录
	public String doModify() throws Exception{
		if(classFeeService.getClassFee(classFee.getFid()) != null){
			try {
				classFee.setTime(new Date());
				classFeeService.update(classFee);
				System.out.println("-----------修改班费记录成功-----------");
				return SUCCESS;
			} catch (RuntimeException e) {
				System.out.println("-----------修改班费记录失败-----------");
				e.printStackTrace();
			}
			return ERROR;
		}else {
			System.out.println("-----------修改班费记录失败.找不到ID=" + classFee.getFid() + "-----------");
			return ERROR;
		}
	}
	
	//CRUD query() 查询班费记录
	public String doQuery() throws Exception{
		try {
			classFee = classFeeService.getClassFee(fid);
			request.put("req", classFee);
			System.out.println("-------查询班费记录成功--------");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("-------查询班费记录失败--------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//CRUD queryAll() 查询全部班费记录
	public String doQueryAll() throws Exception{
		try {
			List<ClassFee> classFees = new ArrayList<ClassFee>();
			classFees = classFeeService.getAllClassFees();
			request.put("req", classFees);
			System.out.println("-------查询全部班费记录成功--------");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("-------查询全部班费记录失败--------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//getter,setter	
	public ClassFeeService getClassFeeService() {
		return classFeeService;
	}

	public void setClassFeeService(ClassFeeService classFeeService) {
		this.classFeeService = classFeeService;
	}

	public ClassFee getClassFee() {
		return classFee;
	}

	public void setClassFee(ClassFee classFee) {
		this.classFee = classFee;
	}
	
	public void setRequest(Map request) {
		this.request = request;
	}

	public Map getRequest() {
		return request;
	}
	
	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}
	
}
