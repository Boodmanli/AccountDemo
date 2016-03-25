package com.boodman.mvntest.persist.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.boodman.mvntest.exception.AccountPersistException;
import com.boodman.mvntest.persist.api.AccountPersistService;
import com.boodman.mvntest.persist.api.AccountVO;

@Service("accountpersistService")
public class AccountPersistServiceImpl implements AccountPersistService{

	@Value("${persist.fileName}")
	private String file;
	private SAXReader read = new SAXReader();
	
	/** 读取文本到文档*/
	private Document readDocument()throws AccountPersistException{
		System.out.println(file);
		File dataFile = new File(file);
		if (!dataFile.exists()) {
			System.out.println("is emity");
			dataFile.getParentFile().mkdirs();
			Document doc = DocumentFactory.getInstance().createDocument();
			Element rootEle = doc.addElement("root");
			rootEle.addElement("accounts");
			writeDocument(doc);
		}
		try {
			return read.read(new File(file));
		} catch (DocumentException e) {
			throw new AccountPersistException("001", "文件读取失败");
		}
	}
	/** 写入文档*/
	private void writeDocument(Document doc){
		Writer out = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			XMLWriter writer = new XMLWriter(out,OutputFormat.createPrettyPrint());
			try {
				writer.write(doc);
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if (out!=null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/** 创建文档*/
	private AccountVO bulidAccount(Element element){
		AccountVO accountVO = new AccountVO();
		accountVO.setId(element.elementText("id"));
		accountVO.setName(element.elementText("name"));
		accountVO.setEmail(element.elementText("email"));
		accountVO.setPassword(element.elementText("password"));
		return accountVO;
		
	}
	public AccountVO createAccount(AccountVO accountVO) throws AccountPersistException {
		
		// TODO Auto-generated method stub
		return null;
	}

	
	@SuppressWarnings("unchecked")
	public AccountVO findAccount(String id) throws AccountPersistException {
		Document doc = readDocument();
		Element accountsEle = doc.getRootElement().element("accounts");
		System.out.println("arg:"+id);
		System.out.println("elementName:"+accountsEle.getPath());
		for (Element accountEle : (List<Element>)accountsEle.elements()) {
			if (accountEle.elementText("id").equals(id)) {
				return bulidAccount(accountEle);
			}
		}
		return null;
	}

}
