package cn.gdpu.service.impl;

import java.util.Set;

import cn.gdpu.dao.ActivityApplyDao;
import cn.gdpu.service.ActivityApplyService;
import cn.gdpu.vo.ActivityApply;

public class ActivityApplyServiceImpl implements ActivityApplyService {
	private ActivityApplyDao activityApplyDao;

	public void addActivityApply(ActivityApply activityApply) {
		activityApplyDao.insertActivityApply(activityApply);
	}

	public void delActivityApplyByID(int aid) {
		activityApplyDao.deleteActivityApplyByID(aid);
	}

	public void delActivityApplyByStuID(int sid) {
		activityApplyDao.deleteActivityApplyByStuID(sid);
	}

	public ActivityApply getActivityApply(int aid) {
		return activityApplyDao.queryActivityApply(aid);
	}

	public Set<ActivityApply> getActivityApplysByStuID(int sid) {
		return activityApplyDao.queryActivityApplysByStuID(sid);
	}

	public void updateActivityApply(ActivityApply activityApply) {
		activityApplyDao.updateActivityApply(activityApply);
	}

	public ActivityApplyDao getActivityApplyDao() {
		return activityApplyDao;
	}

	public void setActivityApplyDao(ActivityApplyDao activityApplyDao) {
		this.activityApplyDao = activityApplyDao;
	}

}
