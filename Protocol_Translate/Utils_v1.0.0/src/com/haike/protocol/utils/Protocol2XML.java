package com.haike.protocol.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Protocol2XML {

	public static void BuildXMLDoc(String mid,Protocol protocol) throws IOException,
			JDOMException {
		// 创建根节点 并设置它的属性 ;
		Element _root = new Element("protocl");
		// 将根节点添加到文档中；
		Document Doc = new Document(_root);

		Element _status = new Element("status");
		_status.addContent(new Element("value").setText(protocol.getStatus()));
		_root.addContent(_status);
		
		Element _version = new Element("version");
		_version.addContent(new Element("value").setText(Integer.toString(protocol.getVersion())));
		_root.addContent(_version);
		
		Element _frametypes = new Element("frametypes");
		for(Comment frametype:protocol.getFrametype()){
			Element _frametype = new Element("frametype");
			_frametype.addContent(new Element("value").setText(frametype.getValue()));
			_frametype.addContent(new Element("desc").setText(frametype.getDesc()));
			_frametypes.addContent(_frametype);
		}
		_root.addContent(_frametypes);
		
		Element _datas = new Element("datas");
		for (Data data : protocol.getData()) {
			Element _data = new Element("data");
			_data.addContent(new Element("code").setText(data.getCode()));
			_data.addContent(new Element("desc").setText(data.getDesc()));
			Element _fields = new Element("fields");
			for(Field field : data.getFields()){
				Element _field = new Element("field");
				_field.addContent(new Element("id").setText(field.getId()));
				_field.addContent(new Element("name").setText(field.getName()));
				_field.addContent(new Element("datatype").setText(field.getDatatype()));
				_field.addContent(new Element("length").setText(field.getLength()));
				_field.addContent(new Element("expr").setText(field.getExpr()));
				Element _comments = new Element("comments");
				for (Comment comment : field.getComments()) {
					Element _comment = new Element("comment");
					_comment.addContent(new Element("value").setText(comment.getValue()));
					_comment.addContent(new Element("desc").setText(comment.getDesc()));
					_comments.addContent(_comment);
				}
				_field.addContent(_comments);
				_fields.addContent(_field);
			}
			_data.addContent(_fields);
			_datas.addContent(_data);
		}
		
		_root.addContent(_datas);
		
		// 输出 books.xml 文件；
		// 使xml文件 缩进效果
		Format format = Format.getPrettyFormat();
		XMLOutputter XMLOut = new XMLOutputter(format);
		File file = new File("xml");
		XMLOut.output(Doc, new FileOutputStream(file.getAbsolutePath()
				+ "/"+mid+".xml"));
	}
}
