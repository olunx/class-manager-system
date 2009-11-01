package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.PostDao;
import cn.gdpu.vo.Notice;
import cn.gdpu.vo.Post;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

	public void deletePostByID(int pid) {
		Post post = (Post) this.getHibernateTemplate().get(Post.class, pid);
		Notice notice = post.getParent();
		List<Post> list = notice.getComment();
		if (list.contains(post)) {
			list.remove(post);
			notice.setComment(list);
			this.getHibernateTemplate().save(notice);
		}
		this.getHibernateTemplate().delete(post);
	}

	public void insertPost(Post post) {
		Notice notice = post.getParent();
		List<Post> list = notice.getComment();
		list.add(post);
		notice.setComment(list);
		this.getHibernateTemplate().save(post);
		this.getHibernateTemplate().save(notice);
	}

	public List<Post> queryAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Post queryPostByID(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePost(Post post) {
		// TODO Auto-generated method stub

	}

}
