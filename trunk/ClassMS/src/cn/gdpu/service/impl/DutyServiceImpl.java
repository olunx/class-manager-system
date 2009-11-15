package cn.gdpu.service.impl;

import java.util.List;

import cn.gdpu.dao.DutyDao;
import cn.gdpu.service.DutyService;
import cn.gdpu.vo.Duty;

public class DutyServiceImpl implements DutyService {

	private DutyDao dutyDao;

	public DutyDao getDutyDao() {
		return dutyDao;
	}

	public void setDutyDao(DutyDao dutyDao) {
		this.dutyDao = dutyDao;
	}

	public void add(Duty duty) {
		dutyDao.insertDuty(duty);
	}

	public void delete(int dutyId) {
		dutyDao.deleteDutyById(dutyId);
	}

	public List<Duty> getAllDutys() {
		return dutyDao.queryAllDutys();
	}

	public Duty getDutyByName(String dutyName) {
		return dutyDao.queryDutyByName(dutyName);
	}

	public Duty getDutyById(int dutyId) {
		return dutyDao.queryDutyById(dutyId);
	}
	
	public void update(Duty duty) {
		dutyDao.updateDuty(duty);
	}

}
