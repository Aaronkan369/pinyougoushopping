package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();		
	}
	
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/findByPage")
	public PageResult  findByPage(int pageNum, int pageSize) {
		
		return brandService.findByPage(pageNum, pageSize);
		
	}
	
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult  findPage(@RequestBody TbBrand tbBrand,int pageNum, int pageSize) {
		
		System.out.println(tbBrand);
		return brandService.findPage(tbBrand,pageNum, pageSize);
		
	}
	
	/**
	 * 品牌新增
	 * @param tbBrand
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand tbBrand){
		
		try {
			
			brandService.add(tbBrand);
			
			return  new Result(true,"新增成功"); 
			
		} catch (Exception e) {
			e.printStackTrace();
			return  new Result(false,"新增失败"); 
		}
		
	}
	
	
	
	/**
	 * 根据主键查找指定的品牌
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		
		return brandService.findOne(id);
	}
	
	/**
	 * 修改方法
	 * @param tbBrands
	 * @return 
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand tbBrand) {
		
		System.out.println("tbBrands = " + tbBrand);
		try {
			brandService.update(tbBrand);
			
			return  new Result(true,"修改成功"); 
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return  new Result(false,"修改失败"); 
		}
		
		
	}
	
	/**
	 * 批量删除操纵
	 * @param ids
	 * @return
	 */
	
	@RequestMapping("/delete")
	public Result delete(Long[] ids){
		
		try {
			
			brandService.delete(ids);
			return new Result(true,"删除成功");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return new Result(true,"删除失败");
		}
		
	}
	
	
	
	
}
