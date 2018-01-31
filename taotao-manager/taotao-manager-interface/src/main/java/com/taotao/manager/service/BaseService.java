package com.taotao.manager.service;

import java.util.List;

 public interface BaseService<T> {
    /***
     * 增加数据，不忽略空值
     * @param t
     * @return
     */
    int save(T t);

    /***
     * 增加数据忽略空值
     * @param t
     * @return
     */
    int saveSelective(T t);

    /***
     * 根据对象执行删除
     * @param t
     * @return
     */
     int delete(T t);

    /***
     * 根据ID删除数据
     * @param t
     * @return
     */
     int deleteById(Object t);

    /***
     * 根据ID集合删除数据
     * @param ids
     * @return
     */
    int deleteByIds(List<Object> ids);

    /***
     * 根据ID查询一个对象
     * @param id
     * @return
     */
     T getOneById(Object id);

    /***
     * 根据对象信息查询一个对象
     * @param t
     * @return
     */
     T getOne(T t);

    /***
     * 修改一个对象，不忽略空值
     * @param t
     * @return
     */
     int update(T t);

    /***
     * 修改一个对象，忽略空值
     * @param t
     * @return
     */
     int updateSelective(T t);

    /**
     * 获取数据集合
     * @return
     */
     List<T> getList();

    /***
     * 获取分页数据
     * @param page
     * @param size
     * @return
     */
     List<T> getPageList(int page,int size);
}
