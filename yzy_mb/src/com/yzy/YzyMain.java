package com.yzy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yzy.util.ColumnType;
import com.yzy.util.commonUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * @author yangzhenyu
 * */
public class YzyMain {

	//字段
	public static String [] datas = new String[]{"GEN_ID","DATA_STATUS","DATA_SOURCE","FEE","PRICE","VALUE","FEE_H04","FEE_H03","FEE_H02","FEE_H01","PRICE_H04","PRICE_H03","PRICE_H02","PRICE_H01","VALUE_H4","VALUE_H3","VALUE_H2","VALUE_H1","TYPE","BATCH","GEN_NAME","GEN_CODE",
			"ID","CREATE_DATE","TRADE_DATE","CHANNEL","ORGANIZATION_ID","NEW_STATUS","VERSION"};
	//表名
	public static String tableName = "T_SP_INPR_DAY_AHEAD_SETTLE";
	
	//类名
	public static String className = "yzyName";
	
	public static String setDatas(String ... msgs) throws IOException, TemplateException {
        OutputStream bos=null; 
        try {
        	Configuration freemarker_cfg =  new Configuration();
            freemarker_cfg.setClassForTemplateLoading(YzyMain.class,"freemarker");
            Template  t =freemarker_cfg.getTemplate("domain.ftl");
       	    List<ColumnType> list = new ArrayList<>();
            t.setEncoding("UFT-8");
        	 for(String msg:msgs) {
           	    ColumnType o = new ColumnType(msg,commonUtil.lineToHump(msg));
           	    list.add(o);          	    
        	 }
        	 Map<String,Object> dataMap = new HashMap<String, Object>();  
        	 dataMap.put("columnList",list);
             bos = new ByteArrayOutputStream();
             PrintWriter pw=new PrintWriter(bos);
             t.process(dataMap, pw);
             return bos.toString();
        }finally {
        	if (bos!=null) {
          	  bos.close();
           }  
		}
        
	}
	
	public static String setGetDatas(String ... msgs) throws IOException, TemplateException {
        OutputStream bos=null; 
        try {
        	Configuration freemarker_cfg =  new Configuration();
            freemarker_cfg.setClassForTemplateLoading(YzyMain.class,"freemarker");
            Template  t =freemarker_cfg.getTemplate("setget.ftl");
       	    List<ColumnType> list = new ArrayList<>();
            t.setEncoding("UFT-8");
        	 for(String msg:msgs) {
           	    ColumnType o = new ColumnType(commonUtil.lineToHump(msg),commonUtil.captureName(commonUtil.lineToHump(msg)));
           	    list.add(o);          	    
        	 }
        	 Map<String,Object> dataMap = new HashMap<String, Object>();  
        	 dataMap.put("columnList",list);
             bos = new ByteArrayOutputStream();
             PrintWriter pw=new PrintWriter(bos);
             t.process(dataMap, pw);
             return bos.toString();
        }finally {
        	if (bos!=null) {
          	  bos.close();
           }  
		}
        
	}
	
	public static void main(String[] args) throws IOException, TemplateException {
            OutputStream bos=null; 
        	Configuration freemarker_cfg =  new Configuration();
            freemarker_cfg.setClassForTemplateLoading(YzyMain.class,"freemarker");
            Template  t =freemarker_cfg.getTemplate("domains.ftl");
            t.setEncoding("UFT-8");	    	
        	Map<String,String> dataMap = new HashMap<String, String>();
	        dataMap.put("DATA", tableName);		      
	        dataMap.put("CLASSNAME", className);
	        String setDatas = setDatas(datas);
	        dataMap.put("COLUMS", setDatas);
	        String setGetDatas = setGetDatas(datas);
	        dataMap.put("SETGETCOLUMS", setGetDatas);
	        bos = new ByteArrayOutputStream();
	        PrintWriter pw=new PrintWriter(bos);
	        t.process(dataMap, pw);
	        System.out.printf("%s\n",bos.toString());
	        if (bos!=null) {
	       	  bos.close();
	        }   

	}
	       
        
	
}
