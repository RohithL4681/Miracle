package com.example.demo.paging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class paginationservice {
	@Autowired
	JdbcTemplate jt;
	
	public List getList(int pagenumber,int size) {
	   List l=new ArrayList<>();
	   HashMap hm=null;
	   List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		String sql="select * from student limit ? offset ?";
		data=jt.queryForList(sql,size,pagenumber*10);
		for(Map listdata:data) {
			hm=new HashMap<>();
			hm.put("id",listdata.get("id"));
			hm.put("name",listdata.get("name"));
			l.add(hm);
		}
		return l;

}

}