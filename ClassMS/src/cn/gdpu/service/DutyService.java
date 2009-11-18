package cn.gdpu.service;

import java.util.List;
import java.util.Set;

import cn.gdpu.bean.PageBean;
import cn.gdpu.vo.Duty;

public interface DutyService {
	
	/**
	 * 添加一个职责
	 * @param duty
	 */
	public abstract void add(Duty duty);
	
	/**
	 * 删除一个职责
	 * @param dutyName
	 */
	public abstract void delete(int dutyId);
	
	/**
	 * 更新一个职责
	 * @param duty
	 */
	public abstract void update(Duty duty);
	
	/**
	 * 获取一个职责
	 * @param dutyName
	 * @return
	 */
	public abstract Duty getDutyByName(String dutyName);
	
	/**
	 * @param dutyId
	 * @return
	 */
	public abstract Duty getDutyById(int dutyId);
	
	/**
	 * 获取所有职责
	 * @return
	 */
	public abstract List<Duty> getAllDutys();

	/**
	 * @param dutyNames
	 * @return
	 */
	public abstract Set<Duty> getDutysByDutyNameString(String dutyNames);
	
	/** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public abstract PageBean queryForPage(int pageSize,int currentPage);  
    
}
