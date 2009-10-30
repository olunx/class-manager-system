package cn.gdpu.service.impl;

import java.util.List;

import cn.gdpu.dao.ClassFeeDao;
import cn.gdpu.service.ClassFeeService;
import cn.gdpu.vo.ClassFee;

public class ClassFeeServiceImpl implements ClassFeeService {
	
	private ClassFeeDao classFeeDao;

	public void add(ClassFee classFee) {
		classFeeDao.insertClassFee(classFee);
	}

	public void delete(int fid) {
		classFeeDao.deleteClassFeeByID(fid);
	}

	public List<ClassFee> getAllClassFees() {
		return classFeeDao.queryAllClassFees();
	}

	public ClassFee getClassFee(int fid) {
		return classFeeDao.queryClassFeeByID(fid);
	}

	public void update(ClassFee classFee) {
		classFeeDao.updateClassFee(classFee);
	}

	public ClassFeeDao getClassFeeDao() {
		return classFeeDao;
	}

	public void setClassFeeDao(ClassFeeDao classFeeDao) {
		this.classFeeDao = classFeeDao;
	}

	

	
	

}
