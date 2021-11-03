package com.dn.boot.enable_interface;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/**
 * ClassName:ServerImportBeanDefinitionRegistrar
 * Package:com.dn.boot.enable_interface
 * Description:
 *
 * @Date:2021/10/23 11:08
 * @Author: mark   另一种方式
 */
public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importClassMetadata, BeanDefinitionRegistry registry) {
        //复用｛@link ServerImportSelector｝
        ImportSelector importSelector = new ServerImportSelector();
        //筛选Class名称集合
        String[] selectedClassNames = importSelector.selectImports(importClassMetadata);
        //创建Bean定义
        Stream.of(selectedClassNames)
                //转化为BeanDefinitionBuilder
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                //转化 为BeanDefinition
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition ->
                        //注册BeanDefinition 到BeanDefinitionRegistry
                        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry));
    }
}
