package cn.gdpu.service.impl;

import java.util.List;

import cn.gdpu.dao.PostDao;
import cn.gdpu.service.PostService;
import cn.gdpu.vo.Post;

public class PostServiceImpl implements PostService {
	PostDao postDao;

	public void add(Post post) {
		postDao.insertPost(post);
	}

	public void delete(int id) {
		postDao.deletePostByID(id);
	}

	public List<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Post getPost(int id) {
		Post post = postDao.queryPostByID(id);
		return post;
	}

	public void save(Post post) {
		
	}

	public void update(Post post) {
		postDao.updatePost(post);
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

}
