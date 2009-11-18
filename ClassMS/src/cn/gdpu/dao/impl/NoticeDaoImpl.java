package cn.gdpu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.NoticeDao;
import cn.gdpu.vo.ClassFee;
import cn.gdpu.vo.Notice;
import cn.gdpu.vo.Post;

public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {

	public void deleteNoticeByID(int id) {
		Notice notice = null;
		notice = queryNoticeByID(id);
		System.out.println("notice:" + notice);
		if (notice != null)
			this.getHibernateTemplate().delete(notice);
	}

	public void insertNotice(Notice notice) {
		this.getHibernateTemplate().save(notice);
	}

	@SuppressWarnings("unchecked")
	public List<Notice> queryAllNotices() {
		List<Notice> notices = null;
		notices = this.getHibernateTemplate().find("from Notice n order by n.nid desc");
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

	public List<Post> queryPostsByID(int id) {
		Notice notice = null;
		notice = (Notice) this.getHibernateTemplate().get(Notice.class, id);
		List<Post> list = notice.getComment();
		// 评论中可能不是连续的列表（被删除某条后）
		List<Post> list2 = new ArrayList<Post>();
		Iterator<Post> iter = list.iterator();
		while (iter.hasNext()) {
			Post post = iter.next();
			if (post != null) {
				list2.add(post);
			}
		}
		return list2;
	}

	  /** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    public List<Notice> queryForPage(final String hql,final int offset,final int length){  
        List list = getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session) throws HibernateException,SQLException{  
                Query query = session.createQuery(hql);  
                query.setFirstResult(offset);  
                query.setMaxResults(length);  
                List list = query.list();  
                return list;  
            }  
        });  
        return list;  
    }  
      
      
    /** *//** 
     * 查询所有记录数 
     * @return 总记录数 
     */  
    public int getAllRowCount(String hql){  
        return getHibernateTemplate().find(hql).size();  
    }  
	
}
