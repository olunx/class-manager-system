package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.ClassFee;
import cn.gdpu.vo.Duty;

public interface DutyDao {
	
	/**
	 * 添加一个职责
	 * @param duty
	 */
	public abstract void insertDuty(Duty duty);
	
	/**
	 * 删除一个职责
	 * @param dutyName
	 */
	public abstract void deleteDutyById(int dutyId);

	/**
	 * 更新一个职责
	 * @param duty
	 */
	public abstract void updateDuty(Duty duty);
	
	/**
	 * 获取一个职责信息
	 * @param dutyName
	 * @return
	 */
	public abstract Duty queryDutyByName(String dutyName);
	
	public abstract Duty queryDutyById(int dutyId);
	
	/**
	 * 获取所有职责信息
	 * @return
	 */
	public abstract List<Duty> queryAllDutys();
	
	/** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
	public abstract List<Duty> queryForPage(final String hql,final int offset,final int length);  
 
    /** *//** 
     * 查询所有记录数 
     * @param hql 查询的条件 
     * @return 总记录数 
     */  
    public abstract int getAllRowCount(String hql);  
}
