package com.neuq.entities;

public class Paging {
	
	private int totalRow;//总共行数
	private int showNum;//每页显示行数
	private int totalPage;//总页数
	private int reqPage;//当前页数
	private int start;//开始行数
	private int end;//结束行数
	private int next;//下一页
	private int previous;//上一页
	
	public Paging()
	{
		
	}
	
	public Paging(int totalRow,int showNum)
	{
		this.totalRow=totalRow;
		this.showNum=showNum;
		if(this.totalRow%this.showNum==0)
		  this.totalPage=this.totalRow/this.showNum;
		else
		  this.totalPage=this.totalRow/this.showNum+1;
	}
	
	//���з�ҳ
	public void doPaging(int reqP)
	{
	  this.reqPage=reqP;
	  this.start=(this.reqPage-1)*this.showNum+1;
	  this.end=this.start*this.showNum;
	}
	
	
	public int getTotalRow() {
		return totalRow;
	}

	public int getShowNum() {
		return showNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getReqPage() {
		return reqPage;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	//��ȡ��һҳ
	public int getNext() {
		if(this.reqPage==this.totalPage)
			this.next=this.totalPage;
		else
			this.next=this.reqPage+1;
		return next;
	}
    //��ȡ��һҳ
	public int getPrevious() {
		if(this.reqPage==1)
			this.previous=1;
		else
			this.previous=this.reqPage-1;
		return previous;
	}
	
	

}
