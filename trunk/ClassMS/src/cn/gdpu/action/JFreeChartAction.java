package cn.gdpu.action;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import cn.gdpu.service.VoteService;
import cn.gdpu.vo.Vote;
import cn.gdpu.vo.VoteItem;

import com.opensymphony.xwork2.ActionSupport;

public class JFreeChartAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L ;
	VoteService voteService;

	private JFreeChart chart;
	private int vid;
	
	public String execute() throws Exception {
		
		System.out.println("-------test------");
		return SUCCESS;
	}

	
	public JFreeChart getChart(){
		Vote vote = voteService.getVote(vid);
		chart = ChartFactory.createBarChart(vote.getTitle(), "投票选项", "票数", getDataSet(vote), PlotOrientation.HORIZONTAL, true, false, false);
		 /*try {
			    FileOutputStream out = new FileOutputStream("d:\\bar.jpg");
			    ChartUtilities.writeChartAsJPEG(out, chart, 800, 600);
			   } catch (FileNotFoundException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   } catch (IOException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   }*/
		return chart;
	}
	
	private CategoryDataset getDataSet(Vote vote){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 		
		for(Iterator iter = vote.getItems().iterator();iter.hasNext(); ){
			VoteItem voteItem = (VoteItem) iter.next();
			dataset.addValue(voteItem.getNum(),voteItem.getContent(),voteItem.getContent());
		}
		return dataset;
	}

	public VoteService getVoteService() {
		return voteService;
	}

	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}


	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	
}
