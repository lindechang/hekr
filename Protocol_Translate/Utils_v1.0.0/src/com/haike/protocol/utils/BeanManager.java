package com.haike.protocol.utils;



import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lindec on 2015/12/14.
 */
public class BeanManager {
	// private static Logger logger =
	// LoggerFactory.getLogger(BeanManager.class.getName());
	static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"ApplicationContext.xml");

	// public static void init(String beanName) {
	// System.out.println("测试。。。");
	// }

	public static void destroy(String beanName) {
		ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) ctx;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext
				.getBeanFactory();

		// logger.info("destroy bean " + beanName);
		if (beanFactory.containsBean(beanName)) {
			beanFactory.destroySingleton(beanName);
			beanFactory.destroyBean(beanName);
			beanFactory.removeBeanDefinition(beanName);
		} else {
			// logger.info("No {} defined in bean container.", beanName);
		}
	}

	public static void addMongoToBeanFactory(Class<?> beanClass,
			String beanName, String host, int port, String database) {

		ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) ctx;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext
				.getBeanFactory();
		if (!beanFactory.containsBean(beanName)) {
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
					.rootBeanDefinition(beanClass);
			beanDefinitionBuilder.addPropertyValue("host", host);
			beanDefinitionBuilder.addPropertyValue("port", port);
			beanDefinitionBuilder.addPropertyValue("database", database);
			beanDefinitionBuilder.setInitMethodName("init");
			beanDefinitionBuilder.setDestroyMethodName("destroy");
			beanFactory.registerBeanDefinition(beanName,
					beanDefinitionBuilder.getBeanDefinition());
			// logger.info("Add {} to bean container.", beanName);
		}
	}

	public static void testCreateBean(ApplicationContext ctx,
			Class<?> beanClass, String beanName, Object obj) {
		// ApplicationContext ctx = new ClassPathXmlApplicationContext(
		// "ApplicationContext.xml");

		ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) ctx;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext
				.getBeanFactory();
		if (!beanFactory.containsBean(beanName)) {
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
					.rootBeanDefinition(beanClass);
			beanDefinitionBuilder.addConstructorArgValue(obj);
			// beanDefinitionBuilder.a
			// beanDefinitionBuilder.addPropertyValue("value", "SS");
			// beanDefinitionBuilder.addPropertyValue("desc", "AAAA");
			beanFactory.registerBeanDefinition(beanName,
					beanDefinitionBuilder.getBeanDefinition());
			// logger.info("Add {} to bean container.", beanName);
		}
	}

	public static void testCreateBean(ApplicationContext ctx,
			Class<?> beanClass, String beanName) {
		// ApplicationContext ctx = new ClassPathXmlApplicationContext(
		// "ApplicationContext.xml");

		ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) ctx;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext
				.getBeanFactory();
		if (!beanFactory.containsBean(beanName)) {
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
					.rootBeanDefinition(beanClass);
			// beanDefinitionBuilder.addPropertyValue("status", "testOK");
			// beanDefinitionBuilder.addPropertyValue("desc", "AAAA");
			beanDefinitionBuilder.setInitMethodName("init");
			beanFactory.registerBeanDefinition(beanName,
					beanDefinitionBuilder.getBeanDefinition());
			// logger.info("Add {} to bean container.", beanName);
		}
	}
	
	
	public static void CreateBean(ApplicationContext ctx,Class<?> beanClass, String beanName) {
		
		ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) ctx;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext
				.getBeanFactory();
		if (!beanFactory.containsBean(beanName)) {
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
					.rootBeanDefinition(beanClass);
			beanFactory.registerBeanDefinition(beanName,
					beanDefinitionBuilder.getBeanDefinition());
		}
	}
	

	// public static void main(String[] args) {
	//
	// String str = "{\"status\": \"ok\",\"version\": 1,\"data\": [{\"code\":
	// \"5\",\"desc\": \"第五字节\",\"fields\": [{\"id\": \"11\",\"name\":
	// \"\",\"datatype\": \"Undefined\",\"length\": \"\",\"expr\":
	// \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"开\"}]}]}]}";
	// ApplicationContext ctx = new ClassPathXmlApplicationContext(
	// "ApplicationContext.xml");
	//
	// // JSONObject jsonObject2 = JSONObject.fromObject(str);
	// //
	// // Protocol protocol2 = (Protocol) JSONObject.toBean(jsonObject2,
	// // Protocol.class);
	//
	// // testCreateBean(ctx, Protocol.class, "testbean",protocol2);
	// testCreateBean(ctx, Protocol.class, "testbean");
	//
	// Protocol testProtocol = (Protocol) ctx.getBean("testbean");
	//
	// System.out.println("Status:" + testProtocol.getStatus());
	// System.out.println("Version:" + testProtocol.getVersion());
	// List<Data> datas = new ArrayList<Data>();
	// datas = testProtocol.getData();
	//
	// }

}
