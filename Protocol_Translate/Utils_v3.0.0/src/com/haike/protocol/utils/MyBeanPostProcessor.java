package com.haike.protocol.utils;



import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;



/**
 * @author lindec BeanPostProcessor 会对所有bean做前置处理
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		 System.out.println("Before--init--beanName:" + beanName);
		// Protocol protocol = JSON.parseObject(
		// JOYOUNG.DEVICE_LED_1X.PROTOCOL, Protocol.class);
		ProtocolModule protocolModule = InitBean.getProtocolModuleBean(beanName);
		//System.out.println("");
		return protocolModule;
//		if (beanName.equals(JOYOUNG.DEVICE_LED_1X.MID)) {
//			Protocol protocol = JSON.parseObject(
//					JOYOUNG.DEVICE_LED_1X.PROTOCOL, Protocol.class);
//			return protocol;
//		}
//		if (beanName.equals(GREE.DEVICE_WASHER_55.MID)) {
//
//			Protocol protocol = JSON.parseObject(
//					GREE.DEVICE_WASHER_55.PROTOCOL, Protocol.class);
//			return protocol;
//		}
//		if (beanName.equals(FOTILE.DEVICE_COOKER_12CC.MID)) {
//			Protocol protocol = JSON.parseObject(
//					FOTILE.DEVICE_COOKER_12CC.PROTOCOL, Protocol.class);
//			return protocol;
//		}
		
		//return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// System.out.println("After--init--,bean:" + bean + "---beanName:" +
		// beanName);
		System.out.println("After--init--beanName:" + beanName);

		return bean;
	}

}
