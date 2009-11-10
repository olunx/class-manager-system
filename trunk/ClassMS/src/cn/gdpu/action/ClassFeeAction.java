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
	

	//CRUD add() 添加班费记录
	public String add() throws Exception{
		try {
			Student cmaker = (Student) session.get("student");
			System.out.println(Double.parseDouble(fee));
			classFee.setFee(Double.parseDouble(fee));
			classFee.setCmaker(cmaker );
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			classFee.setTime(date);
			String remarks = date + "：" + cmaker.getRealName() + "，创建班费记录；";
			classFee.setRemarks(remarks);
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
	public String delete() throws Exception{
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
	
	/**
	 * 修改页面跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String modifyLink() throws Exception {
		ClassFee classFee = classFeeService.getClassFee(fid);
		request.put("classFee", classFee);
		return "modifylink";
	}
	
	//CRUD modify() 修改班费记录
	public String modify() throws Exception{
		ClassFee classFee1 = classFeeService.getClassFee(classFee.getFid()) ;
		if(classFee1 != null){
			try {
				classFee1.setEvent(classFee.getEvent());
				classFee1.setFee(Double.parseDouble(fee));
				String remarks = classFee1.getRemarks() +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "：" + classFee1.getCmaker().getRealName() + "，修改了班费记录；";
				classFee1.setRemarks(remarks);
				classFeeService.update(classFee1);
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
	
	//CRUD query() 按ID查询班费记录
	@SuppressWarnings("unchecked")
	public String query() throws Exception{
		try {
			classFee = classFeeService.getClassFee(fid);
			request.put("req", classFee);
			System.out.println("-------查询班费记录成功--------");
			return "query";
		} catch (Exception e) {
			System.out.println("-------查询班费记录失败--------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//CRUD queryAll() 查询全部班费记录
	@SuppressWarnings("unchecked")
	public String queryAll() throws Exception{
		try {
			List<ClassFee> classFees = new ArrayList<ClassFee>();
			classFees = classFeeService.getAllClassFees();
			if (classFees.size() == 0)
				classFees = null;
			request.put("classFees", classFees);
			System.out.println("-------查询全部班费记录成功--------");
			return "queryall";
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
