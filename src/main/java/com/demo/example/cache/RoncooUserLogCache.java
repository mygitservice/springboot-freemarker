package com.demo.example.cache;

import com.demo.example.bean.RoncooUserLog;

/**
 * @author wujing
 */
public interface RoncooUserLogCache {

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	RoncooUserLog selectById(Integer id);

	/**
	 * 更新
	 * 
	 * @param roncooUserLog
	 * @return
	 */
	RoncooUserLog updateById(RoncooUserLog roncooUserLog);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	String deleteById(Integer id);
}