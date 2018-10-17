package com.pinyougou.sellergoods.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.pojo.TbSpecificationExample.Criteria;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;
	
	@Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;
	
	
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSpecification> page=   (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Specification  specification) {
		

		
		//新增主表-规格表
		specificationMapper.insert(specification.getSpecification());	
		
		//新增字表-规格选项表
		for(TbSpecificationOption specificationOption:specification.getSpecificationOptionList()){
			
			specificationOption.setSpecId(specification.getSpecification().getId());//设置规
			
			tbSpecificationOptionMapper.insert(specificationOption);	
		}
		
		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification){
		
		//更新主表
		specificationMapper.updateByPrimaryKey(specification.getSpecification());
		
		//删除原子表记录
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		com.pinyougou.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(specification.getSpecification().getId());
		
		tbSpecificationOptionMapper.deleteByExample(example);
		
		
		//添加新的子表数据
		
		for (int i = 0; i < specification.getSpecificationOptionList().size(); i++) {
			
			
			TbSpecificationOption tbSpecificationOption  = specification.getSpecificationOptionList().get(i);
			
			tbSpecificationOption.setSpecId(specification.getSpecification().getId());
			
			tbSpecificationOptionMapper.insert(tbSpecificationOption);
		}
		
		
		
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
		
         Specification specification=new Specification();
		
		//获取规格实体
		TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
		specification.setSpecification(tbSpecification);
		
		//获取规格选项列表	
		TbSpecificationOptionExample example=new TbSpecificationOptionExample();
		com.pinyougou.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<TbSpecificationOption> specificationOptionList = tbSpecificationOptionMapper.selectByExample(example);
		
		specification.setSpecificationOptionList(specificationOptionList);
		
		return specification;//组合实体类
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
          for(Long id:ids){
			
			//删除规格表数据
			specificationMapper.deleteByPrimaryKey(id);
			
			//删除规格选项表数据		
			TbSpecificationOptionExample example=new TbSpecificationOptionExample();
			com.pinyougou.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			
			tbSpecificationOptionMapper.deleteByExample(example);
		}	
	}
	
	
	@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
			
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		Criteria criteria = example.createCriteria();
		
		if(specification!=null){		
			
			  if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				  
				criteria.andSpecNameLike("%"+specification.getSpecName().trim()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);
		
		
		return new PageResult(page.getTotal(), page.getResult());
		
		
	}
	
}
