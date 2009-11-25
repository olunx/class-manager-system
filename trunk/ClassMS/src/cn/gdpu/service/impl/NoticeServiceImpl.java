package cn.gdpu.service.impl;

import java.util.List;

import cn.gdpu.bean.PageBean;
import cn.gdpu.dao.NoticeDao;
import cn.gdpu.service.NoticeService;
import cn.gdpu.vo.Notice;
import cn.gdpu.vo.Post;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDao noticeDao;

	public void add(Notice notice) {
		noticeDao.insertNotice(notice);
	}

	public void delete(int id) {
		noticeDao.deleteNoticeByID(id);
	}

	public Notice getNotice(int id) {
		return noticeDao.queryNoticeByID(id);
	}

	public List<Notice> getAllNotices() {
		return noticeDao.queryAllNotices();
	}

	public void update(Notice notice) {
		noticeDao.updateNotice(notice);
	}

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public void save(Notice notice) {
		if (notice.getNid() > 0) {
			noticeDao.updateNotice(notice);
		} else {
			noticeDao.insertNotice(notice);
		}
	}

	public List<Post> getPosts(int id) {
		return noticeDao.queryPostsByID(id);
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

		final String hql = "from Notice"; // 查询语句
		int allRow = noticeDao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<Notice> list = noticeDao.queryForPage(hql, offset, length); // "一页"的记录

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
