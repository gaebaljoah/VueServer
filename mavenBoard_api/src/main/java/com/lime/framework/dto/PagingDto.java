package com.lime.framework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.apache.ibatis.type.Alias;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PagingDto {
	int page = 1;
	int rowCnt = 10;
	int blockCnt = 5;
	int rowStart;
	int rowEnd;
	int blockStart;
	int blockEnd;
	int totalCnt; 
	int lastPage;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRowCnt() {
		return rowCnt;
	}
	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}
	public int getBlockCnt() {
		return blockCnt;
	}
	public void setBlockCnt(int blockCnt) {
		this.blockCnt = blockCnt;
	}
	public int getRowStart() {
		this.rowStart = (this.page-1) * 10;
		return rowStart;
	}
	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}
	public int getRowEnd() {
		this.rowEnd = getRowStart()+this.rowCnt - 1; 
		return rowEnd;
	}
	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}
	public int getBlockStart() {
		this.blockStart = this.getBlockEnd() - this.blockCnt + 1;
		return blockStart;
	}
	public void setBlockStart(int blockStart) {
		this.blockStart = blockStart;
	}
	public int getBlockEnd() {
		Double page = (double) this.page;
		Double blockCnt = (double) this.blockCnt;
		Double tmp = Math.ceil(page/ blockCnt);
		tmp *= this.blockCnt;
		this.blockEnd = tmp.intValue();
		return blockEnd;
	}
	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getLastPage() {
		Double totaclCnt = (double) this.totalCnt;
		Double rowCnt = (double) this.rowCnt;
		Double tmp = Math.ceil(totaclCnt/ rowCnt);
		this.lastPage = tmp.intValue();
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	} 
	
	

}
