package cn.gdpu.service;

import java.util.List;

import cn.gdpu.bean.PageBean;
import cn.gdpu.vo.Notice;
import cn.gdpu.vo.Post;

public interface NoticeService {
	
	/**
	 * 添加公告
	 * @param notice
	 */
	public abstract void add(Notice notice);
	
	/**
	 * 根据ID删除公告
	 * @param id
	 */
	public abstract void delete(int id);
	
	/**
	 * 更新公告
	 * @param notice
	 */
	public abstract void update(Notice notice);
	
	/**
	 * 根据ID获取公告
	 * @param id
	 */
	public abstract Notice getNotice(int id);
	
	/**
	 * 获取所有公告
	 */
	public abstract List<Notice> getAllNotices();
	
	/**
	 * 保存公告(add或update)
	 * @param notice
	 */
	public abstract void save(Notice notice);
	
	/**
	 * 根据公告ID得到所有评论
	 * @param id
	 */
	public abstract List<Post> getPosts(int id);

	  /** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public abstract PageBean queryForPage(int pageSize,int currentPage);  
}
