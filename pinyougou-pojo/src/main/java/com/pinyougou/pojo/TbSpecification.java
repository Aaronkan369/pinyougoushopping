package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.List;

public class TbSpecification implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5963544798517861298L;

	private Long id;

    private String specName;
    
    private List<TbSpecificationOption>  tbSpecificationOptions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

	public List<TbSpecificationOption> getTbSpecificationOptions() {
		return tbSpecificationOptions;
	}

	public void setTbSpecificationOptions(
			List<TbSpecificationOption> tbSpecificationOptions) {
		this.tbSpecificationOptions = tbSpecificationOptions;
	}

	@Override
	public String toString() {
		return "TbSpecification [id=" + id + ", specName=" + specName
				+ ", tbSpecificationOptions=" + tbSpecificationOptions + "]";
	}
    
    
    
}