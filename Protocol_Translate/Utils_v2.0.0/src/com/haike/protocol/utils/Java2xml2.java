//package com.haike.protocol.utils;
//
//import java.io.FileWriter;
//import java.util.List;
//
//import org.jdom.Comment;
//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.input.SAXBuilder;
//import org.jdom.output.Format;
//import org.jdom.output.XMLOutputter;
//
//public class Java2xml2 {
//
//	//@SuppressWarnings("null")
//    public static void createXML() {
//        // ����document
//        Document mydoc = new Document();
//
//        // ����Ԫ��person1
//        Element person1 = new Element("person");
//        person1.setAttribute("id", "ID001");
//        // ���ע��
//        person1.addContent(new Comment("this is person1"));
//
//        person1.addContent(new Element("name").setText("xingoo"));
//        person1.addContent(new Element("age").setText("25"));
//        person1.addContent(new Element("sex").setText("M"));
//        // ����Ƕ�������Ԫ��
//        Element address1 = new Element("address");
//        address1.setAttribute("zone", "province");
//        address1.addContent("LiaoNing");
//        person1.addContent(address1);
//
//        // ����Ԫ��person2
//        Element person2 = new Element("person");
//        person2.setAttribute("id", "ID002");
//        // ���ע��
//        person2.addContent(new Comment("this is person2"));
//
//        person2.addContent(new Element("name").setText("xhalo"));
//        person2.addContent(new Element("age").setText("26"));
//        person2.addContent(new Element("sex").setText("M"));
//        // ����Ƕ�������Ԫ��
//        Element address2 = new Element("address");
//        address2.setAttribute("zone", "province");
//        address2.addContent("JiLin");
//        person2.addContent(address2);
//
//        // ��doc�����Ԫ��Person
//        Element info = new Element("information");
//        info.addContent(person1);
//        info.addContent(person2);
//        mydoc.setRootElement(info);
//        
//        saveXML(mydoc,"person.xml");
//    }
//	
//	public static void saveXML(Document doc,String fileName) {
//        // ��doc����������ļ�
//        try {
//            // ����xml�ļ������
//            XMLOutputter xmlopt = new XMLOutputter();
//
//            // �����ļ������
//            FileWriter writer = new FileWriter(fileName);
//
//            // ָ���ĵ���ʽ
//            Format fm = Format.getPrettyFormat();
//            // fm.setEncoding("GB2312");
//            xmlopt.setFormat(fm);
//
//            // ��docд�뵽ָ�����ļ���
//            xmlopt.output(doc, writer);
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//	
//	public static void readXML() {
//        // ʹ��SAXBuilder����������xml�ļ�
//        SAXBuilder sb = new SAXBuilder();
//        Document doc = null;
//        try {
//            doc = sb.build("person.xml");
//            Element root = doc.getRootElement();
//            List<Element> list = root.getChildren("person");
//           
//            for (Element el : list) {
//                String id = el.getAttributeValue("id");
//                String name = el.getChildText("name");
//                String age = el.getChildText("age");
//                String sex = el.getChildText("sex");
//                System.out.println("id:" + id);
//                System.out.println("name:" + name);
//                System.out.println("age:" + age);
//                System.out.println("sex:" + sex);
//                System.out.println("--------------------------");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//	public static void readXML2() {
//		// ʹ��SAXBuilder����������xml�ļ�
//		SAXBuilder sb = new SAXBuilder();
//		Document doc = null;
//		try {
//			doc = sb.build("ApplicationContext.xml");
//			Element root = doc.getRootElement();
//			System.out.println(root);
//			List<Element> list = root.getChildren("bean");
//			System.out.println(list.size());
//			for (Element el : list) {
//				
//				 String name =el.getAttributeValue("id");
//				 System.out.println("name:"+name);
//				// String id = el.getAttributeValue("id");
//				// String name = el.getChildText("name");
//				// String age = el.getChildText("age");
//				// String sex = el.getChildText("sex");
//				// System.out.println("id:" + id);
//				// System.out.println("name:" + name);
//				// System.out.println("age:" + age);
//				// System.out.println("sex:" + sex);
//				// System.out.println("--------------------------");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void updateXML(){
//        SAXBuilder sb = new SAXBuilder();
//        Document doc = null;
//        try {
//            doc = sb.build("person.xml");
//            System.out.println(doc);
//            Element root = doc.getRootElement();
//            System.out.println(root);
//            List<Element> list = root.getChildren("person");
//            System.out.println(list);
//            for (Element el : list) {
//                if (el.getAttributeValue("id").equals("ID001")) {
//                    Element name = el.getChild("name");
//                    name.setText("xingoo---update");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        saveXML(doc,"person.xml");
//    }
//	
//	public  void updateXML2(){
//        SAXBuilder sb = new SAXBuilder();
//        Document doc = null;
//        try {
//            doc = sb.build("books.xml");
//            System.out.println(doc);
//            Element root = doc.getRootElement();
//            System.out.println(root);
//            List<Element> list = root.getChildren("book");
//            System.out.println(list);
//            for (Element el : list) {
//               // if (el.equals("ID001")) {
//                    Element name = el.getChild("name");
//                    System.out.println(name.getText());
//                    //System.out.println(el.getChildText("nmae"));
//                    //System.out.println(name.getChildText("nmae"));
//                    name.setText("xingoo---update");
//               // }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        saveXML(doc,"books.xml");
//    }
//	
//	public static void removeXML() {
//        SAXBuilder sb = new SAXBuilder();
//        Document doc = null;
//        try {
//            doc = sb.build("person.xml");
//            Element root = doc.getRootElement();
//            List<Element> list = root.getChildren("person");
//            for (Element el : list) {
//                if (el.getAttributeValue("id").equals("ID001")) {
//                    root.removeContent(el);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        saveXML(doc,"person.xml");
//    }
//}
