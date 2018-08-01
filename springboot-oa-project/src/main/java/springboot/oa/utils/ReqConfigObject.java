package springboot.oa.utils;
/**
 * 接口请求参数
 * @author Administrator
 *
 */
public class ReqConfigObject {
	
	/**
	 * 当前页数，可选
	 */
	private int pageNo=999999;
	/**
	 * 每页数据量，可选
	 */
	private int pageSize=999999;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
