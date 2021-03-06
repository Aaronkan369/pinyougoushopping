package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;
	
	@Override
	public List<TbBrand> findAll() {

		return brandMapper.selectByExample(null);
	}

	
	/**
	 * 分页查询
	 * @param pageNum  当前页
	 * @param pageSize  每页记录数
	 * @return
	 */
	@Override
	public PageResult  findByPage(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum,pageSize);
		
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
		
		return new PageResult(page.getTotal(),page.getResult());
	}


    /**
     *  新增方法
     */
	@Override
	public void add(TbBrand tbBrands) {
		
		brandMapper.insert(tbBrands);
	}


	
	/**
	 * 根据主键查找指定的品牌
	 * @param id
	 * @return
	 */
	@Override
	public TbBrand findOne(Long id) {
		
	
		return brandMapper.selectByPrimaryKey(id);
	}

	/**
	 * 修改方法
	 * @param tbBrands
	 * @return 
	 */
	@Override
	public void update(TbBrand tbBrands) {
	
		System.out.println(tbBrands);
		brandMapper.updateByPrimaryKey(tbBrands);
		
	}


	/**
	 * 删除方法
	 * @param tbBrands
	 * @return 
	 */
	@Override
	public void delete(Long[] ids) {
		
		for (Long id : ids) {
			
			brandMapper.deleteByPrimaryKey(id);
		}
		
	}

	/**
	 * 分页查询
	 *  @param tbBrand  参数
	 * @param pageNum  当前页
	 * @param pageSize  每页记录数
	 * @return
	 */
	@Override
	public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize) {
		
		 System.out.println("service......."+tbBrand);
		
         PageHelper.startPage(pageNum,pageSize);
         
         TbBrandExample example = new TbBrandExample();
         
         Criteria criteria = example.createCriteria();
         
         if(tbBrand.getName() != null){
        	 
        	 criteria.andNameEqualTo(tbBrand.getName());
         }
         if(tbBrand.getFirstChar() != null){
        	 criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
         }
		
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
		
		return new PageResult(page.getTotal(),page.getResult()); 
	}

}
