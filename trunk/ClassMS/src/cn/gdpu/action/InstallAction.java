package cn.gdpu.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.gdpu.service.*;
import cn.gdpu.vo.*;

import com.opensymphony.xwork2.ActionSupport;

public class InstallAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
	private LeaderService leaderService;
	private StudentService studentService;
	private DutyService dutyService;
	private NoticeService noticeService;
	private LessonService lessonService;
	private ClassFeeService classFeeService;
	private VoteService voteService;
	

	@Override
	public String execute() throws Exception {
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setRealName("测试管理员");
		adminService.add(admin);
		
		Leader leader = new Leader();
		leader.setUsername("leader");
		leader.setPassword("leader");
		leader.setRealName("辅导员");
		leaderService.add(leader);
		
		Student stu = new Student();
		stu.setUsername("0707501100");
		stu.setPassword("0707501100");
		stu.setSno("0707501100");
		stu.setRealName("医软3C");
		studentService.add(stu);
		
		Duty duty = new Duty();
		duty.setDutyName("班长");
		duty.setJob("管理班里大小事务");
		dutyService.add(duty);
		
		//公告
		Notice notice = new Notice();
		notice.setAuthor(stu);
		notice.setTitle("篮球比赛");
		notice.setContent("明天下午我们将和医药软件09进行一场篮球比赛，请各位同学前去加油打气！");
		notice.setTime(new Date());
		noticeService.add(notice);
		
		notice = new Notice();
		notice.setAuthor(stu);
		notice.setTitle("计算机网络实验");
		notice.setContent("计算机网络实验需要把所有问题都回答了，并且不少于两百字，做完的同学发邮件到3cxxxxx@qq.com");
		notice.setTime(new Date());
		noticeService.add(notice);

		notice = new Notice();
		notice.setAuthor(stu);
		notice.setTitle("广药学生参加基本医疗保险");
		notice.setContent("根据《国务院办公厅关于将大学生纳入城镇居民基本医疗保险试点范围的指导意见》(国办发［2008］119号)、省府办公厅《关于将在广东省就读的大学生以及中等技术学校和技工学校学生纳入城镇居民基本医疗保险试点范围的通知》(粤府办［2009］56号)和广东省劳动和社会保障厅、教育厅、财政厅、民政厅《关于将在广东省就读的大学生以及中等技术学校和技工学校学生纳入城镇居民基本医疗保险试点范围的实施意见》(粤劳社发［2009］29号)有关精神，将我省就读的大学生以及中等技术学校和技工学校学生纳入城镇居民基本医疗保险试点范围，是构建和谐社会、维护社会稳定、促进大学生和中等技校学生健康水平的重要举措，各二级学院要高度重视这项工作，鼓励在校学生参加基本医疗保险。");
		notice.setTime(new Date());
		noticeService.add(notice);
		
		//课程
		Lesson lesson = new Lesson();
		lesson.setLessonName("毛泽东理论");
		lesson.setLessonPeriod("1,2,3");
		lesson.setDay("一");
		lessonService.add(lesson);
		
		lesson = new Lesson();
		lesson.setLessonName("药学概论");
		lesson.setLessonPeriod("1,2,3");
		lesson.setDay("二");
		lessonService.add(lesson);
		
		lesson = new Lesson();
		lesson.setLessonName("计算机网络");
		lesson.setLessonPeriod("1,2,3");
		lesson.setDay("三");
		lessonService.add(lesson);
		
		lesson = new Lesson();
		lesson.setLessonName("管理信息系统实验");
		lesson.setLessonPeriod("7,8");
		lesson.setDay("三");
		lessonService.add(lesson);
		
		ClassFee classFee = new ClassFee();
		classFee.setCmaker(stu);
		classFee.setFee(1000);
		classFee.setEvent("收取班费");
		classFee.setTime(new Date());
		classFeeService.add(classFee);
		
		classFee = new ClassFee();
		classFee.setCmaker(stu);
		classFee.setFee(-10);
		classFee.setEvent("篮球比赛买水");
		classFee.setTime(new Date());
		classFeeService.add(classFee);
		
		//投票
		Vote vote = new Vote();
		vote.setAuthor(stu);
		vote.setAirTime(new Date());
		vote.setDeadline(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2012-12-1 10:00"));
		vote.setTitle("下次团日活动想去哪里？");
		vote.setType("0");
		Set<VoteItem> items = new HashSet<VoteItem>();
		
		VoteItem voteItem = new VoteItem();
		voteItem.setContent("早上去爬白云山");
		items.add(voteItem);
		voteItem = new VoteItem();
		voteItem.setContent("肇庆一日游");
		items.add(voteItem);
		voteItem = new VoteItem();
		voteItem.setContent("大学城图书馆一日游");
		items.add(voteItem);		
		voteItem = new VoteItem();
		voteItem.setContent("金星农庄烧烤");
		items.add(voteItem);	
		
		vote.setItems(items);
		voteService.addVote(vote);
		
		return SUCCESS;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setLeaderService(LeaderService leaderService) {
		this.leaderService = leaderService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setDutyService(DutyService dutyService) {
		this.dutyService = dutyService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public void setLessonService(LessonService lessonService) {
		this.lessonService = lessonService;
	}

	public void setClassFeeService(ClassFeeService classFeeService) {
		this.classFeeService = classFeeService;
	}

	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}
	
}
