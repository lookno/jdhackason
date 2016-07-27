package com.jd.hackason.dao;

import java.util.List;

import com.jd.hackason.bean.Goods;
import com.jd.hackason.dto.GoodsDto;

public interface GoodsDao {
	public void insertGoods(Goods goods);

	public void updateGoods(Goods goods);

	public List<Goods> listGoods(GoodsDto goodsDto);

	public void batchInsertGoods(List<Goods> list);
	
	public Integer getTotalNum(GoodsDto goodsDto);
	
	public Goods getGoodsById(int id);
	//public List<Goods> searchGoods(SearchDto searchDto);
	
	//public Integer getSearchCount(SearchDto searchDto);
}
