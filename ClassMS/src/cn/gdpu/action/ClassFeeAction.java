package cn.gdpu.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.bean.PageBean;
import cn.gdpu.service.ClassFeeService;
import cn.gdpu.vo.ClassFee;
import cn.gdpu.vo.Student;
import com.opensymphony.xwork2.ActionSupport;


public class ClassFeeAction extends ActionSupport implements RequestAware,SessionAware{
	
	private static final long serialVersionUID = 1L;


	ClassFeeService classFeeService = null;	
	ClassFee classFee = null;
	private PageBean pageBean; 
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> request;
	@SuppressWarnings("unchecked")
	private Map session;
	private int cmd;
	private int page;
	private String fee;
	private String fid;
	private String[] fids;

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
	 * 删除多个投票记录
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String deleteMany() {
		if(cmd == 1){
			for(int i=0;i<fids.length;i++) {
				classFeeService.delete(fids[i]);
			}
			return SUCCESS;
		}
		else{
			return "list";
		}
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
		return SUCCESS;
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
		return SUCCESS;	
	}
	
	/*
	@SkipValidation
	@SuppressWarnings("unchecked")
	public String list() throws Exception{		
		List<ClassFee> classFees = new ArrayList<ClassFee>();
		classFees = classFeeService.getAllClassFees();
		if (classFees.size() == 0)
			classFees = null;
		request.put("classFees", classFees);
		return SUCCESS;	
	}*/
	
	/**
	 * 分页列出所有班费
	 * @return
	 */
	@SkipValidation
	public String list() throws Exception {  
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页  
        this.pageBean = classFeeService.queryForPage(15, page);  
        if(pageBean.getList().size() == 0)
    		pageBean.setList(null);
        
        request.put("total", classFeeService.getTotalMoney());
        return SUCCESS;  
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
	
	 public int getCmd() {
			return cmd;
	}


	public void setCmd(int cmd) {
		this.cmd = cmd;
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

	public String[] getFids() {
		return fids;
	}

	public void setFids(String[] fids) {
		this.fids = fids;
	}

	 public int getPage() {  
	        return page;  
    }  
  
    public void setPage(int page) {        //若URL中无此参数,会默认为第1页  
        this.page = page;  
    }  
  
    public PageBean getPageBean() {  
        return pageBean;  
    }  
  
    public void setPageBean(PageBean pageBean) {  
        this.pageBean = pageBean;  
    }  

}
