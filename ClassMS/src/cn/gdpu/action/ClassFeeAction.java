package cn.gdpu.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.service.ClassFeeService;
import cn.gdpu.vo.ClassFee;
import cn.gdpu.vo.Student;
import com.opensymphony.xwork2.ActionSupport;


public class ClassFeeAction extends ActionSupport implements RequestAware,SessionAware{
	
	private static final long serialVersionUID = 1L;


	ClassFeeService classFeeService = null;
	
	ClassFee classFee = null;
	
	@SuppressWarnings("unchecked")
	private Map request;
	@SuppressWarnings("unchecked")
	private Map session;
	
    String fee;
	String fid;
	

	/**
	 * 保存班费记录
	 * 
	 * @return
	 * @throws Exception
	 */	
	@SuppressWarnings("unchecked")
	public String save() throws Exception{
		if(fid == null || fid.trim().equals("")){                    //新建班费
			Student cmaker = (Student) session.get("student");
			System.out.println(Double.parseDouble(fee));
			classFee.setFee(Double.parseDouble(fee));
			classFee.setCmaker(cmaker );
			Date date = new Date();
			classFee.setTime(date);
			String remarks = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) + "：" + cmaker.getRealName() + "，创建班费记录；";
			classFee.setRemarks(remarks);
			classFeeService.add(classFee);
			return "addsuc";
		}
		else {															//修改班费
			ClassFee classFee1 = classFeeService.getClassFee(fid) ;
			classFee1.setEvent(classFee.getEvent());
			classFee1.setFee(Double.parseDouble(fee));
			String remarks = classFee1.getRemarks() +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "：" + classFee1.getCmaker().getRealName() + "，修改了班费记录；";
			classFee1.setRemarks(remarks);
			classFeeService.update(classFee1);
			request.put("classFee", classFee1);
			return "modifysuc";					
		} 
		
	}
	
	
	/**
	 * 删除班费记录
	 * 
	 * @return
	 * @throws Exception
	 */	
	@SkipValidation
	public String delete() throws Exception{	
		classFeeService.delete(fid);
		return SUCCESS;
	}
	
	/**
	 * 修改页面跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	@SuppressWarnings("unchecked")
	public String modifyLink() throws Exception {
		ClassFee classFee = classFeeService.getClassFee(fid);
		request.put("classFee", classFee);
		return "modifylink";
	}
	
	/**
	 * 按ID查询班费记录
	 * 
	 * @return
	 * @throws Exception
	 */	
	@SkipValidation
	@SuppressWarnings("unchecked")
	public String query() throws Exception{		
		classFee = classFeeService.getClassFee(fid);
		request.put("classFee", classFee);
		return "query";	
	}
	
	/**
	 * 列出所有班费
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	@SuppressWarnings("unchecked")
	public String list() throws Exception{		
		List<ClassFee> classFees = new ArrayList<ClassFee>();
		classFees = classFeeService.getAllClassFees();
		if (classFees.size() == 0)
			classFees = null;
		request.put("classFees", classFees);
		return "queryall";	
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
	
	@SuppressWarnings("unchecked")
	public void setRequest(Map request) {
		this.request = request;
	}

	@SuppressWarnings("unchecked")
	public Map getRequest() {
		return request;
	}
	
	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
	       this.session = session;
	    }
	
	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
	
	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}
	
}
