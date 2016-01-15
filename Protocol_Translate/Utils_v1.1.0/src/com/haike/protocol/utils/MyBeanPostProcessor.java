package com.haike.protocol.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lindec 
 * BeanPostProcessor 会对所有bean做前置处理
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// System.out.println("Before--init--beanName:" + beanName);
		ProtocolModule protocolModule = InitBean.getProtocolModuleBean(beanName);
		return protocolModule;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// System.out.println("After--init--,bean:" + bean + "---beanName:" +
		// beanName);
		return bean;
	}

}
