package com.jd.hackason.dto;

public class ProCommentDto {
	int limit;
	int offset;
	int mode;
	int has_image;
	int has_addcomment;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getHas_image() {
		return has_image;
	}

	public void setHas_image(int has_image) {
		this.has_image = has_image;
	}

	public int getHas_addcomment() {
		return has_addcomment;
	}

	public void setHas_addcomment(int has_addcomment) {
		this.has_addcomment = has_addcomment;
	}

}
