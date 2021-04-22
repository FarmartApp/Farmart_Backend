/*
Copyright [2020] [Apptimus Tech (Pvt) Ltd.]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

/**
 * 
 */
package com.farm.settings;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public class Pagination {
	private Object data;
	private Long totalRows;
	private Long fromRow;
	private Integer totalPage;
	private Integer currentPage;
	

	public static Pageable paginationRequest(Integer pageNo) {

		if (pageNo == 0) {
			Pageable paging = PageRequest.of(pageNo, Constants.PAGINATION_LIMIT, Sort.by(Sort.Direction.ASC, "id"));
			return paging;
		}
		Pageable paging = PageRequest.of((pageNo - 1), Constants.PAGINATION_LIMIT, Sort.by(Sort.Direction.ASC, "id"));
		return paging;
	}
	
	public static Pageable paginationRequest(Integer pageNo,String commonIdName) {

		if (pageNo == 0) {
			Pageable paging = PageRequest.of(pageNo, Constants.PAGINATION_LIMIT, Sort.by(Sort.Direction.ASC, commonIdName));
			return paging;
		}
		Pageable paging = PageRequest.of((pageNo - 1), Constants.PAGINATION_LIMIT, Sort.by(Sort.Direction.ASC, commonIdName));
		return paging;
	}
	

	public static Pageable paginationRequest(Integer pageNo, Sort sort) {

		if (pageNo == 0) {
			Pageable paging = PageRequest.of(pageNo, Constants.PAGINATION_LIMIT, sort);
			return paging;
		}
		Pageable paging = PageRequest.of((pageNo - 1), Constants.PAGINATION_LIMIT, sort);
		return paging;
	}

	public static Object paginatedData(Page<?> contant) {
		Pagination transformData = new Pagination();
		transformData.setData(contant.getContent());
		transformData.setCurrentPage(contant.getPageable().getPageNumber() + 1);
		transformData.setTotalPage(contant.getTotalPages());
		transformData.setTotalRows( contant.getTotalElements());
		transformData.setFromRow(contant.getPageable().getOffset());
		return transformData;
	}

	/**
	 * 
	 */
	public Pagination() {
		super();
	}

	/**
	 * @return the totalRows
	 */
	public Long getTotalRows() {
		return totalRows;
	}

	/**
	 * @param totalRows the totalRows to set
	 */
	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}

	/**
	 * @return the fromRow
	 */
	public Long getFromRow() {
		return fromRow;
	}

	/**
	 * @param fromRow the fromRow to set
	 */
	public void setFromRow(Long fromRow) {
		this.fromRow = fromRow;
	}

	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
