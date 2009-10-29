package cn.gdpu.service;

import java.util.List;

import cn.gdpu.vo.Notice;

public interface NoticeService {
	
	/**
	 * 添加公告
	 * @param notice
	 */
	public abstract void add(Notice notice);
	
	/**
	 * 根据ID删除公告
	 * @param nid
	 */
	public abstract void delete(int nid);
	
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

}