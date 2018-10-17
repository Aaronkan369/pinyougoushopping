package com.pinyougou.pojogroup;

import java.io.Serializable;
import java.util.List;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;

/**
 * 商品信息vo
 * @author Mindy
 *
 */
public class Goods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6930178985783467519L;
	
	private TbGoods goods;//商品SPU
	private TbGoodsDesc goodsDesc;//商品扩展
	private List<TbItem> itemList;//商品SKU列表	
	public TbGoods getGoods() {
		return goods;
	}
	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}
	public TbGoodsDesc getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(TbGoodsDesc goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public List<TbItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<TbItem> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return "Goods [goods=" + goods + ", goodsDesc=" + goodsDesc
				+ ", itemList=" + itemList + "]";
	}
	
	
	
}
