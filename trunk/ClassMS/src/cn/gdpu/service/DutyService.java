package cn.gdpu.service;

import java.util.List;

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
	 * 获取所有职责
	 * @return
	 */
	public abstract List<Duty> getAllDutys();

}
