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
	public abstract void deleteClassFeeByID(int fid);
	
	/**
	 * 更新班费
	 * @param classFee
	 */
	public abstract void updateClassFee(ClassFee classFee);
	
	/**
	 * 根据ID获取班费
	 * @param fid
	 */
	public abstract ClassFee queryClassFeeByID(int fid);
	
	/**
	 * 获取所有班费
	 */
	public abstract List<ClassFee> queryAllClassFees();

}
