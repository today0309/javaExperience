package com.ztw.springRedis;

import java.io.Serializable;

public class NewsInfo implements Serializable {

	private static final long serialVersionUID = 8842011557150614359L;

	private String title;// 新闻标题

	private String time;// 发布时间

	private String source;// 新闻来源

	private String content;// 新闻内容

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "NewsInfo [title=" + title + ", time=" + time + ", source=" + source + ", content=" + content + "]";
	}

	public NewsInfo(String title, String time, String source, String content) {
		super();
		this.title = title;
		this.time = time;
		this.source = source;
		this.content = content;
	}

	public NewsInfo() {

	}

}
