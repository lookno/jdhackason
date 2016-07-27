package com.jd.hackason.dto;

public class ProCommentDto {
	int limit;
	int offset;
	int star_mode;
	int has_image;
	int has_addcomment;
	int order_mode;

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

	public int getStar_mode() {
		return star_mode;
	}

	public void setStar_mode(int star_mode) {
		this.star_mode = star_mode;
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

	public int getOrder_mode() {
		return order_mode;
	}

	public void setOrder_mode(int order_mode) {
		this.order_mode = order_mode;
	}

}
