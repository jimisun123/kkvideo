package kkvideo.admin.pojo.vo;

import java.util.Date;

public class Reports {
    private String id;
    private String title;
    private String content;
    private Date createDate;
    
    private String dealUsername;

    private String dealVideoId;
    private String videoDesc;
    private String videoPath;
    private Integer status;
    
    private String submitUsername;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDealUsername() {
		return dealUsername;
	}

	public void setDealUsername(String dealUsername) {
		this.dealUsername = dealUsername;
	}

	public String getDealVideoId() {
		return dealVideoId;
	}

	public void setDealVideoId(String dealVideoId) {
		this.dealVideoId = dealVideoId;
	}

	public String getVideoDesc() {
		return videoDesc;
	}

	public void setVideoDesc(String videoDesc) {
		this.videoDesc = videoDesc;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getSubmitUsername() {
		return submitUsername;
	}

	public void setSubmitUsername(String submitUsername) {
		this.submitUsername = submitUsername;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}