package com.test.boot.vo;

import java.io.Serializable;

public class UserVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3778316247167208340L;

	private Integer user_id;

	private String user_name;

	private Integer org_id; // company_id

	private String org_name; // company_name

	private Integer brand_id;

	private String sub_model_id;

	private Integer source_id;

	private String start_time;

	private String end_time;

	private String code; // source code

	private String source_name;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Integer org_id) {
		this.org_id = org_id;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public Integer getSource_id() {
		return source_id;
	}

	public void setSource_id(Integer source_id) {
		this.source_id = source_id;
	}

	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

	public String getSub_model_id() {
		return sub_model_id;
	}

	public void setSub_model_id(String sub_model_id) {
		this.sub_model_id = sub_model_id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSource_name() {
		return source_name;
	}

	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}

}
