package com.jd.hackason.service;

import java.util.List;

import com.jd.hackason.bean.Goods;
import com.jd.hackason.bean.OutputGoods;
import com.jd.hackason.dto.GoodsDto;
import com.jd.hackason.exception.ServerException;
import com.jd.hackason.exception.ServiceException;

public interface IGoodsService {
	public void insertGoods(Goods goods) throws ServerException, ServiceException;

	public void updateGoods(Goods goods) throws ServerException;

	public List<Goods> listGoods(GoodsDto goodsParams) throws ServerException;

	public List<OutputGoods> output(GoodsDto goodsDto) throws ServerException;

	public void batchInsertGoods(String fileName) throws ServerException, ServiceException;

	public Integer getTotalNum(GoodsDto goodsDto) throws ServerException, ServiceException;

	//public List<Goods> searchGoods(SearchDto searchDto) throws ServerException, ServiceException;
	
	//public Integer getSearchCount(SearchDto searchDto) throws ServerException, ServiceException;
}
