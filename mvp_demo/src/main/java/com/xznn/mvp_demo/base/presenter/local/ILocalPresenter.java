package com.xznn.mvp_demo.base.presenter.local;

import com.ivan.mvp.base.model.Params;
import com.ivan.mvp.base.presenter.IPresenter;

import java.util.List;

/**
 * 
 * @description 从手机本地获取数据的Presenter
 * @author Ivan Mo
 * @date 2016年8月2日
 * @param <T>
 * @version 1.0
 */
public interface ILocalPresenter<T> extends IPresenter {

	/**
	 * Get bean by id
	 * @param id
	 * @return
	 */
	public T findById(String id);

	/**
	 * Query list by params
	 * @param params
	 * @return
	 */
	public List<T> queryList(Params params);
	
	/**
	 * Query package by params
	 * @param params
	 * @return
	 */
	public Package<T> queryPackage(Params params);

	/**
	 * Save or update bean
	 * @param params
	 * @return
	 */
	public boolean saveOrUpdate(T object);

	/**
	 * Delete bean by id
	 * @param params
	 * @return
	 */
	public boolean delete(String id);

}
