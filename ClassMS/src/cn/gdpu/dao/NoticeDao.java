package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.Notice;

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
	public abstract void deleteNoticeByID(int nid);
	
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

}
