package cn.gdpu.service;



import java.util.List;

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
	public abstract void delete(int fid);
	
	/**
	 * 更新班费
	 * @param classFee
	 */
	public abstract void update(ClassFee classFee);
	
	/**
	 * 根据ID获取班费
	 * @param fid
	 */
	public abstract ClassFee getClassFee(int fid);
	
	/**
	 * 获取所有班费
	 */
	public abstract List<ClassFee> getAllClassFees();

}
