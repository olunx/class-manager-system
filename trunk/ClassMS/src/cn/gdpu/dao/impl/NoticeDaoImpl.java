package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.NoticeDao;
import cn.gdpu.vo.Notice;

public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {

	public void deleteNoticeByID(int nid) {
		Notice notice = null;
		notice = queryNoticeByID(nid);
		System.out.println("notice:"+notice);
		if (notice != null)
			this.getHibernateTemplate().delete(notice);
	}

	public void insertNotice(Notice notice) {
		this.getHibernateTemplate().save(notice);
	}

	@SuppressWarnings("unchecked")
	public List<Notice> queryAllNotices() {
		List<Notice> notices = null;
		notices = this.getHibernateTemplate().find("from Notice");
		return notices;
	}

	public Notice queryNoticeByID(int id) {
		Notice notice = null;
		notice = (Notice) this.getHibernateTemplate().get(Notice.class, id);
		return notice;
	}

	public void updateNotice(Notice notice) {
		this.getHibernateTemplate().update(notice);
	}

}
