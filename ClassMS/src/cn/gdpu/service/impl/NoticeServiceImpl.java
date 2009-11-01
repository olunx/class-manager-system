package cn.gdpu.service.impl;

import java.util.List;

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
		if (notice.getNid() != 0) {
			noticeDao.updateNotice(notice);
		} else {
			noticeDao.insertNotice(notice);
		}
	}

	public List<Post> getPosts(int id) {
		return noticeDao.queryPostsByID(id);
	}

}
