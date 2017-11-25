package com.jl.user_manager.dao;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * 基础DAO接口  所有DAO接口继承此接口 
 * @date 2017年11月10日 上午9:23:51
 * @author lin
 *
 */

public interface BaseDao<T> {

    public Serializable save(T o);

    public void delete(Serializable id);

    public void delete(T o);

    public void update(T o);

    public void saveOrUpdate(T o);

    public T get(Serializable id);

    public List<T> find(String hql);

    public List<T> find(String hql, Map<String, Object> params);

    public List<T> find(String hql, int page, int rows);

    public List<T> find(String hql, Map<String, Object> params, int page, int rows);

    public Integer count(String hql);

    public Integer count(String hql, Integer id);

    public Integer count(String hql, Map<String, Object> params);

    public int executeHql(String hql);

    public int executeHql(String hql, Map<String, Object> params);

    Integer findByUid(Integer uid);

    Integer findTicketByCid(Integer cid);
}	
