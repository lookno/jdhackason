package com.jd.hackason.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jd.hackason.bean.Pro_com_label;
import com.jd.hackason.dao.Pro_com_labelDao;
import com.jd.hackason.service.IPro_com_labelService;
@Service
public class Pro_com_labelServiceImpl implements IPro_com_labelService{
	@Resource
	private Pro_com_labelDao pro_com_label;
	@Override
	public void update_table(String[] labels_name) {
		for(int i=0;i<labels_name.length;i++){
			if(pro_com_label.exist(labels_name[i])==0){
				Pro_com_label label_bean=new Pro_com_label();
				label_bean.setPro_id(1);
				label_bean.setLabel_name(labels_name[i]);
				label_bean.setNum(1);
				pro_com_label.insert(label_bean);
			}
			else pro_com_label.update(labels_name[i]);
		}
	}

}
