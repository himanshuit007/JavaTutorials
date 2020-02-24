package com.him.Test2;

import com.him.Test1.PubClass;

public class App {
	public static void main(String[] args) {
		PubClass p=new PubClass();
		System.out.println(p.pub);
//		System.out.println(p.pri);
//		System.out.println(p.pro);
//		System.out.println(p.def);
		System.out.println(p.getPub());
		System.out.println(p.getPri());
		System.out.println(p.getPro());
		System.out.println(p.getDef());
		
		p.setPub(0);
		p.setPri(0);
		p.setPro(0);
		p.setDef(0);
		
		Extender e=new Extender();
		System.out.println(e.pub);
//		System.out.println(e.pri);
// 		System.out.println(e.pro);
//		System.out.println(e.def);
		
		System.out.println(e.getPub());
		System.out.println(e.getPri());
		System.out.println(e.getPro());
		System.out.println(e.getDef());
		
		e.setPub(0);
		e.setPri(0);
		e.setPro(0);
		e.setDef(0);
	}
}
