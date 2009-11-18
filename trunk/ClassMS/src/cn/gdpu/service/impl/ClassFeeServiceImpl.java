package cn.gdpu.service.impl;

import java.util.List;

import cn.gdpu.bean.PageBean;
import cn.gdpu.dao.ClassFeeDao;
import cn.gdpu.service.ClassFeeService;
import cn.gdpu.vo.ClassFee;

public class ClassFeeServiceImpl implements ClassFeeService {

	private ClassFeeDao classFeeDao;

	public void add(ClassFee classFee) {
		classFeeDao.insertClassFee(classFee);
	}

	public void delete(String fid) {
		classFeeDao.deleteClassFeeByID(fid);
	}

	public List<ClassFee> getAllClassFees() {
		return classFeeDao.queryAllClassFees();
	}

	public ClassFee getClassFee(String fid) {
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

	public double getTotalMoney() {
		List<ClassFee> list = classFeeDao.queryAllClassFees();
		double total = 0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i).getFee();
		}
		return total;
	}
	
	/** */
	/**
	 * 分页查询
	 * 
	 * @param currentPage
	 *            当前第几页
	 * @param pageSize
	 *            每页大小
	 * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	public PageBean queryForPage(int pageSize, int page) {

		final String hql = "from ClassFee"; // 查询语句
		int allRow = classFeeDao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<ClassFee> list = classFeeDao.queryForPage(hql, offset, length); // "一页"的记录

		// 把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}


}
