package com.jd.hackason.dto;

public class DetailJudge {
	int pack_star;
	int express_star;
	int attitude_star;
	int star;
	String label_names[];
	String content;
	String imge;
	public int getPack_star() {
		return pack_star;
	}
	public void setPack_star(int pack_star) {
		this.pack_star = pack_star;
	}
	public int getExpress_star() {
		return express_star;
	}
	public void setExpress_star(int express_star) {
		this.express_star = express_star;
	}
	public int getAttitude_star() {
		return attitude_star;
	}
	public void setAttitude_star(int attitude_star) {
		this.attitude_star = attitude_star;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String[] getLabel_names() {
		return label_names;
	}
	public void setLabel_names(String[] label_names) {
		this.label_names = label_names;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImge() {
		return imge;
	}
	public void setImge(String imge) {
		this.imge = imge;
	}
	
}
