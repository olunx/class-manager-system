package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.DutyDao;
import cn.gdpu.vo.Duty;

public class DutyDaoImpl extends HibernateDaoSupport implements DutyDao {

	public void insertDuty(Duty duty) {
		this.getHibernateTemplate().save(duty);
	}

	public void deleteDutyByName(String dutyName) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Duty.class, dutyName));
	}

	public void updateDuty(Duty duty) {
		this.getHibernateTemplate().update(duty);
	}

	public Duty queryDutyByName(String dutyName) {
		return (Duty) this.getHibernateTemplate().get(Duty.class, dutyName);
	}

	@SuppressWarnings("unchecked")
	public List<Duty> queryAllDutys() {
		return this.getHibernateTemplate().find("from Duty");
	}

}
