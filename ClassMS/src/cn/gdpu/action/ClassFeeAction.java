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
	

	//CRUD add() ��Ӱ�Ѽ�¼
	public String doAdd() throws Exception{
		try {
			classFee.setTime(new Date());
			classFeeService.add(classFee);
			System.out.println("-----------��Ӱ�Ѽ�¼�ɹ�-----------");
			return SUCCESS;
		} catch (RuntimeException e) {
			System.out.println("-----------��Ӱ�Ѽ�¼ʧ��-----------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//CRUD delete()
	public String doDelete() throws Exception{
		try {
			classFeeService.delete(fid);
			System.out.println("-------ɾ����Ѽ�¼�ɹ�--------");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("-------ɾ����Ѽ�¼ʧ��--------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//CRUD modify()
	public String doModify() throws Exception{
		if(classFeeService.getClassFee(classFee.getFid()) != null){
			try {
				classFee.setTime(new Date());
				classFeeService.update(classFee);
				System.out.println("-----------��Ѽ�¼�޸ĳɹ�-----------");
				return SUCCESS;
			} catch (RuntimeException e) {
				System.out.println("-----------��Ѽ�¼�޸�ʧ��-----------");
				e.printStackTrace();
			}
			return ERROR;
		}else {
			System.out.println("-----------��Ѽ�¼�޸�ʧ��.�Ҳ�����ID-----------");
			return ERROR;
		}
	}
	
	//CRUD query() ��ID��ѯ��Ѽ�¼
	public String doQuery() throws Exception{
		try {
			classFee = classFeeService.getClassFee(fid);
			request.put("req", classFee);
			System.out.println("-------��ѯ��Ѽ�¼�ɹ�--------");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("-------��ѯ��Ѽ�¼ʧ��--------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//CRUD queryAll() ��ѯȫ����Ѽ�¼
	public String doQueryAll() throws Exception{
		try {
			List<ClassFee> classFees = new ArrayList<ClassFee>();
			classFees = classFeeService.getAllClassFees();
			request.put("req", classFees);
			System.out.println("-------��ѯȫ����Ѽ�¼�ɹ�--------");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("-------��ѯȫ����Ѽ�¼ʧ��--------");
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
