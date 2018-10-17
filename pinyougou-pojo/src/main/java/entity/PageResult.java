package entity;

import java.io.Serializable;
import java.util.List;


/**
 * 分页通用实体类
 * @author Mindy
 *
 */
public class PageResult implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8896631627664770059L;
	

	private long  total;//总记录数
	
	private List rows;  //分页结果集
	
	
	

	public PageResult(long  l, List rows) {
		super();
		this.total = l;
		this.rows = rows;
	}

	public long  getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
	
	
	

}
