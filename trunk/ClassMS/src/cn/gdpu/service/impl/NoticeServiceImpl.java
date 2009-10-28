package cn.gdpu.service.impl;

import java.util.List;

import cn.gdpu.dao.NoticeDao;
import cn.gdpu.service.NoticeService;
import cn.gdpu.vo.Notice;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDao noticeDao;

	public void add(Notice notice) {
		noticeDao.insertNotice(notice);
	}

	public void delete(int nid) {
		// TODO Auto-generated method stub

	}

	public Notice getNotice(int id) {
		return noticeDao.queryNoticeByID(id);
	}

	public List<Notice> getAllNotices() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Notice notice) {
		// TODO Auto-generated method stub

	}

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

}
