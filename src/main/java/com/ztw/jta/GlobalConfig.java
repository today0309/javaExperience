package com.ztw.jta;

public class GlobalConfig {

	/**
	 * 公告文件路径
	 */
	private String announcementFileHttpUrl;

	/**
	 * APP菜單展示url
	 */
	private String appMenuHttpUrl;

	/**
	 * 优品资讯图片展示url
	 */
	private String upzxHttpUrl;

	public String getAnnouncementFileHttpUrl() {
		return announcementFileHttpUrl;
	}

	public void setAnnouncementFileHttpUrl(String announcementFileHttpUrl) {
		this.announcementFileHttpUrl = announcementFileHttpUrl;
	}

	public String getAppMenuHttpUrl() {
		return appMenuHttpUrl;
	}

	public void setAppMenuHttpUrl(String appMenuHttpUrl) {
		this.appMenuHttpUrl = appMenuHttpUrl;
	}

	public String getUpzxHttpUrl() {
		return upzxHttpUrl;
	}

	public void setUpzxHttpUrl(String upzxHttpUrl) {
		this.upzxHttpUrl = upzxHttpUrl;
	}

	@Override
	public String toString() {
		return "GlobalConfig [announcementFileHttpUrl=" + announcementFileHttpUrl + ", appMenuHttpUrl=" + appMenuHttpUrl
				+ ", upzxHttpUrl=" + upzxHttpUrl + "]";
	}

}
