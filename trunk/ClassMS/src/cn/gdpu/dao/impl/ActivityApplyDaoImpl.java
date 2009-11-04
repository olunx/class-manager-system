package cn.gdpu.dao.impl;

import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.ActivityApplyDao;
import cn.gdpu.vo.ActivityApply;
import cn.gdpu.vo.Student;

public class ActivityApplyDaoImpl extends HibernateDaoSupport implements ActivityApplyDao {

	public void deleteActivityApplyByID(int aid) {
		ActivityApply activityApply = (ActivityApply) this.getHibernateTemplate().get(ActivityApply.class, aid);
		this.getHibernateTemplate().delete(activityApply);
	}

	public void deleteActivityApplyByStuID(int sid) {
		Student stu = (Student) this.getHibernateTemplate().get(Student.class, sid);
		stu.setActivityApplys(null);
		this.getHibernateTemplate().save(stu);
	}

	public void insertActivityApply(ActivityApply activityApply) {
		this.getHibernateTemplate().save(activityApply);
	}

	public ActivityApply queryActivityApply(int aid) {
		ActivityApply activityApply = null;
		activityApply = (ActivityApply) this.getHibernateTemplate().get(ActivityApply.class, aid);
		return activityApply;
	}

	public Set<ActivityApply> queryActivityApplysByStuID(int sid) {
		Student stu = (Student) this.getHibernateTemplate().get(Student.class, sid);
		Set<ActivityApply> set = null;
		set = stu.getActivityApplys();
		return set;
	}

	public void updateActivityApply(ActivityApply activityApply) {
		this.getHibernateTemplate().update(activityApply);
	}

}
