package com.taotao.manager.service.impl;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.abel533.mapper.Mapper;
import com.taotao.manager.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
/***
 *
 * @param <T>
 */
public class BaseServiceImpl<T> implements BaseService<T> {


    /**
     * 存储父类泛型
     */
    private Class clazz;

    public BaseServiceImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class)type.getActualTypeArguments()[0];
    }

    /**
     * 通用mapper
     */
    @Autowired
    private Mapper<T> mapper;

    @Override
    public int save(T t) {
        return mapper.insert(t);
    }

    @Override
    public int saveSelective(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    public int delete(T t) {
        return mapper.delete(t);
    }

    @Override
    public int deleteById(Object t) {
        return mapper.deleteByPrimaryKey(t);
    }

    @Override
    public int deleteByIds(List<Object> ids) {
        Example example = new Example(clazz);
        Criteria criteria = example.createCriteria();
        //获取所有的域，从注解上获取对应的主键
        String key = "";
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                //判断是否是同一注解
                if(annotation.annotationType().equals(Id.class)){
                    key = field.getName();
                    break;
                }
            }
            if(!"".equals(key.trim())){
                break;
            }
        }

        //指定对应的ID
        criteria.andIn(key, ids);
        return mapper.deleteByExample(example);
    }

    @Override
    public T getOneById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }
    @Override
    public T getOne(T t) {
        return mapper.selectOne(t);
    }
    @Override
    public int update(T t) {
        return mapper.updateByPrimaryKey(t);
    }
    @Override
    public int updateSelective(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }
    @Override
    public List<T> getList() {
        return mapper.select(null);
    }
    @Override
    public List<T> getPageList(int page, int size) {
        return null;
    }
}
