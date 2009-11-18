package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.ClassFee;
import cn.gdpu.vo.Notice;
import cn.gdpu.vo.Post;

public interface NoticeDao {
	
	/**
	 * 添加公告
	 * @param notice
	 */
	public abstract void insertNotice(Notice notice);
	
	/**
	 * 根据ID删除公告
	 * @param nid
	 */
	public abstract void deleteNoticeByID(int id);
	
	/**
	 * 更新公告
	 * @param notice
	 */
	public abstract void updateNotice(Notice notice);
	
	/**
	 * 根据ID获取公告
	 * @param id
	 */
	public abstract Notice queryNoticeByID(int id);
	
	/**
	 * 获取所有公告
	 */
	public abstract List<Notice> queryAllNotices();
	
	/**
	 * 获取该公告的所有评论
	 * @return
	 */
	public abstract List<Post> queryPostsByID(int id);
	/** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
	public abstract List<Notice> queryForPage(final String hql,final int offset,final int length);  
 
    /** *//** 
     * 查询所有记录数 
     * @param hql 查询的条件 
     * @return 总记录数 
     */  
    public abstract int getAllRowCount(String hql);  

}
