package cn.gdpu.dao;

import java.util.List;

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
}
