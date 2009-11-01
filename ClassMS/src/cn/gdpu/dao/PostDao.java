package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.Post;

public interface PostDao {
	
	/**
	 * 添加评论
	 * @param post
	 */
	public abstract void insertPost(Post post);
	
	/**
	 * 根据ID删除评论
	 * @param nid
	 */
	public abstract void deletePostByID(int pid);
	
	/**
	 * 更新评论
	 * @param post
	 */
	public abstract void updatePost(Post post);
	
	/**
	 * 根据ID获取评论
	 * @param id
	 */
	public abstract Post queryPostByID(int pid);
	
	/**
	 * 获取所有评论
	 */
	public abstract List<Post> queryAllPosts();

}
