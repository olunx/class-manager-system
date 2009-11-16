package cn.gdpu.service;



import java.util.List;

import cn.gdpu.bean.PageBean;
import cn.gdpu.vo.ClassFee;

public interface ClassFeeService {
	
	/**
	 * 添加班费
	 * @param classFee
	 */
	public abstract void add(ClassFee classFee);
	
	/**
	 * 根据ID删除班费
	 * @param fid
	 */
	public abstract void delete(String fid);
	
	/**
	 * 更新班费
	 * @param classFee
	 */
	public abstract void update(ClassFee classFee);
	
	/**
	 * 根据ID获取班费
	 * @param fid
	 */
	public abstract ClassFee getClassFee(String fid);
	
	/**
	 * 获取所有班费
	 */
	public abstract List<ClassFee> getAllClassFees();
	
	/** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public abstract PageBean queryForPage(int pageSize,int currentPage);  
}
