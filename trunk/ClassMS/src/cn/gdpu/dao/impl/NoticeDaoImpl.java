package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.NoticeDao;
import cn.gdpu.vo.Notice;

public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {

	public void deleteNoticeByID(int nid) {
		// TODO Auto-generated method stub

	}

	public void insertNotice(Notice notice) {
		this.getHibernateTemplate().save(notice);
	}

	public List<Notice> queryAllNotices() {
		// TODO Auto-generated method stub
		return null;
	}

	public Notice queryNoticeByID(int id) {
		Notice notice = null;
		notice = (Notice)this.getHibernateTemplate().get(Notice.class, id);
		return notice;
	}

	public void updateNotice(Notice notice) {
		// TODO Auto-generated method stub

	}

}
