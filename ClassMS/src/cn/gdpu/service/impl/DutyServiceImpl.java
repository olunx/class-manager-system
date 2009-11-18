package cn.gdpu.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.gdpu.bean.PageBean;
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

	public Set<Duty> getDutysByDutyNameString(String dutyNames) {
		
		String[] names = dutyNames.split("\\,");
		
		Set<Duty> dutys = new HashSet<Duty>();
		for(int i=0;i<names.length;i++) {
			System.out.println(names[i]);
			dutys.add(dutyDao.queryDutyByName(names[i]));
		}
		return dutys;
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

		final String hql = "from Duty"; // 查询语句
		int allRow = dutyDao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<Duty> list = dutyDao.queryForPage(hql, offset, length); // "一页"的记录

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
