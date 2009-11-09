package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.DutyDao;
import cn.gdpu.vo.Duty;

public class DutyDaoImpl extends HibernateDaoSupport implements DutyDao {

	public void insertDuty(Duty duty) {
		this.getHibernateTemplate().save(duty);
	}

	public void deleteDutyById(int dutyId) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Duty.class, dutyId));
	}

	public void updateDuty(Duty duty) {
		this.getHibernateTemplate().update(duty);
	}

	@SuppressWarnings("unchecked")
	public Duty queryDutyByName(String dutyName) {
		//return (Duty) this.getHibernateTemplate().get(Duty.class, dutyName);
		Duty duty = null;
		List list = this.getHibernateTemplate().find("form Duty where dutyName=='" + dutyName + "'");
		if (list != null && list.size() > 0) {
			duty = (Duty) list.get(0);
		}
		return duty;
	}

	@SuppressWarnings("unchecked")
	public List<Duty> queryAllDutys() {
		return this.getHibernateTemplate().find("from Duty");
	}

}
