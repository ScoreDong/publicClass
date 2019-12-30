package com.xiaomi.utils;

public class PageTool {
	private int pageCount;// 总页数
	private int totalCount;// 总数量数
	private int currentPage;// 当前页码
	private int lastPage;// 上一页
	private int nextPage;// 下一页
	private int startIndex;// 起始下标
	private int pageSize;// 每页数量数

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageTool() {

	}

	public PageTool(int totalCount, String currentPage) {
		super();
		this.totalCount = totalCount;
		pageSize = 5;//每页数据量固定为5条
		//初始化当前页码
		initialCurrentPage(currentPage);
		//初始化总页数
		initialPageCount();
		//初始化上一页
		initalLastPage();
		//初始化下一页
		initalNextPage();
		//初始化起始下标
		initialStartIndex();
	}
	//初始化起始下标方法
	private void initialStartIndex() {
		startIndex = (currentPage - 1) * pageSize;
	}
	//下一页
	private void initalNextPage() {
		if (currentPage == pageCount) {
			nextPage = pageCount;
		}else {
			nextPage = currentPage + 1;
		}
	}
	//上一页
	private void initalLastPage() {
		if (currentPage == 1) {
			lastPage = 1;
		}else {
			lastPage = currentPage - 1;
		}
	}
	//初始化总页数
	private void initialPageCount() {
		pageCount = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
	}
	//初始化当前页码方法
	private void initialCurrentPage(String currentPage) {
		/*
			因为当前页码是从页面中传过来的,那么在第一次进入show.jsp页面时, 没有办法传值
			此时的当前页码就是第一页,赋值为1
			其余情况下,进行类型转换,该死第几页就是第几页
		 */
		if (currentPage == null) {
			this.currentPage = 1;
		}else {
			this.currentPage = Integer.valueOf(currentPage);
		}
	}

	@Override
	public String toString() {
		return "PageTool [pageCount=" + pageCount + ", totalCount=" + totalCount + ", currentPage=" + currentPage
				+ ", lastPage=" + lastPage + ", nextPage=" + nextPage + ", startIndex=" + startIndex + ", pageSize="
				+ pageSize + "]";
	}	
	

}
