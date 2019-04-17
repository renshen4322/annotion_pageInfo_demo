package com.dn.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.dn.annotation.NeedSetValue;
import com.github.pagehelper.StringUtil;

@Component
public class BeanUtil implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        if (this.applicationContext == null)
            this.applicationContext = applicationContext;

    }

    //需要在它调用之前，获取那个被加上注解的属性的值，我们可以去在一个结果集中去拿出这个值，并赋值给注解标记的这个属性上。

    public void setFeildValueForCollection(Collection col) {
        //1：获取到结果集的class对象
        Class<?> clazz = col.iterator().next().getClass();
        //2：获取到class对象里的属性，为了优化性能，我们还可以加个缓存
        Field[] fields = clazz.getDeclaredFields();

        Map<String, Object> cache = new HashMap<String, Object>();
        //3:遍历这个属性集合中被注解标注了的字段，再去获取这个注解
        for (Field needfield : fields) {
            NeedSetValue sv = needfield.getAnnotation(NeedSetValue.class);
            if (sv == null) {
                continue;
            }
            needfield.setAccessible(true);

            //拿我们刚才要的那四个东西，准备干活
            try {
                //第一个 我们要调用的bean
                Object bean = this.applicationContext.getBean(sv.beanClass());

                //第二个 我要调用哪个方法
                Method method = sv.beanClass().getMethod(sv.method(),
                        clazz.getDeclaredField(sv.param()).getType());

                //第三个 入参字段
                Field paramField = clazz.getDeclaredField(sv.param());
                paramField.setAccessible(true);

                //第四个 值的来源
                Field targetField = null;
                Boolean needInnerField = !StringUtil.isEmpty(sv.targetField());

                //既然准备做缓存，我们就来做一个key
                String keyPrefix = sv.beanClass().getName() + "-" + sv.method() + "-" + sv.targetField() + "-";

                //4:对我们的结果集进行操作
                for (Object obj : col) {
                    //首先我们去获取到结果集的对象属性，去判断是不是我们要的那个
                    Object paramValue = paramField.get(obj);
                    if (paramValue == null) {
                        continue;
                    }

                    Object value = null;
                    //先从缓存里面获取
                    String key = keyPrefix + paramValue;
                    if (cache.containsKey(key)) {
                        value = cache.get(key);
                    } else {

                        value = method.invoke(bean, paramValue);
                        if (needInnerField) {
                            if (value != null) {
                                if (targetField == null) {
                                    targetField = value.getClass().getDeclaredField(sv.targetField());
                                    targetField.setAccessible(true);
                                }
                                value = targetField.get(value);
                            }

                        }
                        cache.put(key, value);
                    }

                    needfield.set(obj, value);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    public void setFeildValueForCollection2(Object col) {
        //1：获取到结果集的class对象
        Class<?> clazz = col.getClass();
        //2：获取到class对象里的属性，为了优化性能，我们还可以加个缓存
        Field[] fields = clazz.getDeclaredFields();

        Map<String, Object> cache = new HashMap<String, Object>();
        //3:遍历这个属性集合中被注解标注了的字段，再去获取这个注解
        for (Field needfield : fields) {
            NeedSetValue sv = needfield.getAnnotation(NeedSetValue.class);
            if (sv == null) {
                continue;
            }
            needfield.setAccessible(true);

            //拿我们刚才要的那四个东西，准备干活
            try {
                //第一个 我们要调用的bean
                Object bean = this.applicationContext.getBean(sv.beanClass());

                //第二个 我要调用哪个方法
                Method method = sv.beanClass().getMethod(sv.method(),
                        clazz.getDeclaredField(sv.param()).getType());

                //第三个 入参字段
                Field paramField = clazz.getDeclaredField(sv.param());
                paramField.setAccessible(true);

                //第四个 值的来源
                Field targetField = null;
                Boolean needInnerField = !StringUtil.isEmpty(sv.targetField());

                //既然准备做缓存，我们就来做一个key
                String keyPrefix = sv.beanClass().getName() + "-" + sv.method() + "-" + sv.targetField() + "-";

                //4:对我们的结果集进行操作

                //首先我们去获取到结果集的对象属性，去判断是不是我们要的那个
                Object paramValue = paramField.get(clazz);
                if (paramValue == null) {
                    continue;
                }

                Object value = null;
                //先从缓存里面获取
                String key = keyPrefix + paramValue;
                if (cache.containsKey(key)) {
                    value = cache.get(key);
                } else {

                    value = method.invoke(bean, paramValue);
                    if (needInnerField) {
                        if (value != null) {
                            if (targetField == null) {
                                targetField = value.getClass().getDeclaredField(sv.targetField());
                                targetField.setAccessible(true);
                            }
                            value = targetField.get(value);
                        }

                    }
                    cache.put(key, value);
                }

                needfield.set(clazz, value);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
