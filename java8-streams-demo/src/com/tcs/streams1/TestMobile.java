package com.tcs.streams1;

import java.util.List;
import java.util.stream.Collectors;

import com.tcs.streams.Dish;

public class TestMobile 
{
	public static void main(String[] args) {
		
		//System.out.println(listitem.getAllMobile());
		//MobileList ml = new MobileList();
		
		List<MobileList> list1 = listitem.getAllMobile();
		
		list1.forEach(System.out::println);
		
		System.out.println("---------After sorting----------");
		List<MobileList>list2=list1.stream().filter(ml -> ml.getPrice()>8000).collect(Collectors.toList());
		printitem(list2);
		
		System.out.println("---------After sorting by name----------");
		
		List<MobileList>list3=list1.stream().filter(ml -> ml.getCompany().equals("Nokia")).collect(Collectors.toList());
		printitem(list3);
		
		System.out.println("---------After sorting by price----------");
		
		List<MobileList>asclist=list1.stream()
				.sorted((x, y) -> Double.compare(x.getPrice(), y.getPrice())).collect(Collectors.toList());
		
		
		printitem(asclist);
		
		
		System.out.println("---------After sorting by Name----------");
		
		
		List<MobileList>ascname=list1.stream()
				.sorted((i1, i2) -> i1.getMobilename().compareTo(i2.getMobilename())).collect(Collectors.toList());
		
		printitem(ascname);
		
	}
	
	public static void printitem(List<MobileList> mlist) {
		mlist.forEach(System.out::println);
		System.out.println("-----------------");
	}

}
