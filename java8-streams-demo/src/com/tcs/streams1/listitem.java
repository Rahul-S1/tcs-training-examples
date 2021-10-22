package com.tcs.streams1;

import java.util.ArrayList;
import java.util.List;



public class listitem
{
	public static  List<MobileList> getAllMobile()
	{
	List<MobileList> list = new ArrayList<MobileList>();
	list.add(new MobileList("Nokiac1","Nokia",10000));
	list.add(new MobileList("Galaxy s2","samsung",8000));
	list.add(new MobileList("vivo v2","vivo",12000));
	list.add(new MobileList("oppo f2","oppo",15000));
	list.add(new MobileList("moto g20","Motorola",9000));
	list.add(new MobileList("Nokiac2","Nokia",20000));
	
	return list;
	}
	
}
