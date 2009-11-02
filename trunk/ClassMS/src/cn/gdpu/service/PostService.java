package cn.gdpu.service;

import java.util.List;

import cn.gdpu.vo.Post;

public interface PostService {
	
	/**
	 * 添加评论
	 * @param post
	 */
	public abstract void add(Post post);
	
	/**
	 * 根据ID删除评论
	 * @param nid
	 */
	public abstract void delete(int id);
	
	/**
	 * 更新评论
	 * @param post
	 */
	public abstract void update(Post post);
	
	/**
	 * 根据ID获取评论
	 * @param id
	 */
	public abstract Post getPost(int id);
	
	/**
	 * 获取所有评论
	 */
	public abstract List<Post> getAllPosts();
	
	/**
	 * 保存评论(add或update)
	 * @param post
	 */
	public abstract void save(Post post);

}
