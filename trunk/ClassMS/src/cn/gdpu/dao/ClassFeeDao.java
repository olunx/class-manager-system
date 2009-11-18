package cn.gdpu.dao;


import java.util.List;

import cn.gdpu.vo.ClassFee;

public interface ClassFeeDao {

	/**
	 * 添加班费
	 * @param classFee
	 */
	public abstract void insertClassFee(ClassFee classFee);
	
	/**
	 * 根据ID删除班费
	 * @param fid
	 */
	public abstract void deleteClassFeeByID(String fid);
	
	/**
	 * 更新班费
	 * @param classFee
	 */
	public abstract void updateClassFee(ClassFee classFee);
	
	/**
	 * 根据ID获取班费
	 * @param fid
	 */
	public abstract ClassFee queryClassFeeByID(String fid);
	
	/**
	 * 获取所有班费
	 */
	public abstract List<ClassFee> queryAllClassFees();
	
	/** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
	public abstract List<ClassFee> queryForPage(final String hql,final int offset,final int length);  
 
    /** *//** 
     * 查询所有记录数 
     * @param hql 查询的条件 
     * @return 总记录数 
     */  
    public abstract int getAllRowCount(String hql);  

}
