package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;

import entity.PageResult;
import entity.Result;


@RestController
@RequestMapping("/specification")
public class SpecificationController {
	
	
			@Reference
			private SpecificationService specificationService;
			
			
			/**
			 * 查询所有
			 * @return
			 */
			@RequestMapping("/findAll")
			public List<TbSpecification> findAll(){
				return specificationService.findAll();		
			}
			
			
			/**
			 * 分页查询
			 * @param pageNum
			 * @param pageSize
			 * @return
			 */
			@RequestMapping("/findByPage")
			public PageResult findByPage(int pageNum, int pageSize) {
				
				return specificationService.findPage(pageNum, pageSize);
			}
			
			
			/**
			 * 分页查询
			 * @param pageNum
			 * @param pageSize
			 * @return
			 */
			@RequestMapping("/search")
			public PageResult  search(@RequestBody TbSpecification tbSpecification,int pageNum, int pageSize) {
				
				System.out.println(tbSpecification);
				return specificationService.findPage(tbSpecification,pageNum, pageSize);
				
			}
			
			
			
			/**
			 * 品牌新增
			 * @param tbBrand
			 */
			@RequestMapping("/add")
			public Result add(@RequestBody Specification  specification){
				
				System.out.println(specification);
				try {
					
					specificationService.add(specification);
					
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
			public Specification findOne(Long id) {
				Specification specification = specificationService.findOne(id);
				System.out.println(specification);
				return specification;
			}
			
			/**
			 * 修改方法
			 * @param tbBrands
			 * @return 
			 */
			@RequestMapping("/update")
			public Result update(@RequestBody Specification Specification) {
				
				System.out.println("tbSpecification = " + Specification);
				try {
					specificationService.update(Specification);
					
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
					
					specificationService.delete(ids);
					return new Result(true,"删除成功");
					
				} catch (Exception e) {
					
					e.printStackTrace();
					return new Result(true,"删除失败");
				}
				
			}

}
