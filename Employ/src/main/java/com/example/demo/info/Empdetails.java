package com.example.demo.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class Empdetails {
	@Autowired
	JdbcTemplate js;
	public List fetchList(Employ e) {
		List getdata=new ArrayList();
		HashMap dataList=null;
		List<Map<String,Object>>data=new ArrayList<Map<String,Object>>();
		String sql="select * from info " ;
		data=js.queryForList(sql);
		for(Map listdata:data) {
			dataList=new HashMap();
			dataList.put("id",listdata.get("id"));
			dataList.put("name",listdata.get("name"));
			dataList.put("age",listdata.get("age"));
			dataList.put("deg",listdata.get("deg"));
			dataList.put("email",listdata.get("email"));
			getdata.add(dataList);
		}
		return getdata;
		
	}
}
