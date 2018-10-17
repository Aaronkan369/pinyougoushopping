package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;
import entity.Result;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	/**
	 * 查询所有
	 * @return
	 */
	public List<TbBrand> findAll();
	
	
	/**
	 * 分页查询
	 * @param pageNum  当前页
	 * @param pageSize  每页记录数
	 * @return
	 */
	public PageResult findByPage(int pageNum,int pageSize);
	
	
	/**
	 * 新增方法
	 * @param tbBrands
	 * @return 
	 */
	public void add(TbBrand tbBrands);
	
	
	/**
	 * 根据主键查找指定的品牌
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);
	
	
	/**
	 * 修改方法
	 * @param tbBrands
	 * @return 
	 */
	public void update(TbBrand tbBrands);
	
	
	
	/**
	 * 删除方法
	 * @param tbBrands
	 * @return 
	 */
	public void delete(Long[] ids);
	
	/**
	 * 分页查询
	 *  @param tbBrand  参数
	 * @param pageNum  当前页
	 * @param pageSize  每页记录数
	 * @return
	 */
	public PageResult findPage(TbBrand  tbBrand,int pageNum,int pageSize);
	
	
}
