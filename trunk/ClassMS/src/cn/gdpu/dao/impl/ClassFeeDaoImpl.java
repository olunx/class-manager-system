package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.ClassFeeDao;
import cn.gdpu.vo.ClassFee;


public class ClassFeeDaoImpl extends HibernateDaoSupport implements ClassFeeDao {

	public void deleteClassFeeByID(String fid) {
		ClassFee classFee = null;
		classFee = (ClassFee)this.getHibernateTemplate().get(ClassFee.class, fid);
		if(classFee != null)
			this.getHibernateTemplate().delete(classFee);
	}

	public void insertClassFee(ClassFee classFee) {
		this.getHibernateTemplate().save(classFee);
	}
	
	@SuppressWarnings("unchecked")
	public List<ClassFee> queryAllClassFees() {
		List<ClassFee> classFees = null;
		classFees = this.getHibernateTemplate().find("from ClassFee");
		return classFees;
	}

	public ClassFee queryClassFeeByID(String fid) {
		ClassFee classFee = null;
		classFee = (ClassFee)this.getHibernateTemplate().get(ClassFee.class, fid);
		return classFee;
	}

	public void updateClassFee(ClassFee classFee) {
		this.getHibernateTemplate().update(classFee);
	}

	
}
