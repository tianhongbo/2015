package com.ibytecode.client;

import javax.naming.Context;
import javax.naming.NamingException;

import com.ibytecode.business.*;
import com.ibytecode.businesslogic.*;
import com.ibytecode.clientutility.*;

public class EJBApplicationClient {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloWorld bean = doLookup();
		System.out.println(bean.sayHello());

	}
	
	private static HelloWorld doLookup() {
		Context context = null;
		HelloWorld bean = null;
		
		try {
			context = ClientUtility.getInitialContext();
			String lookupName = getlookupName();
			bean = (HelloWorld) context.lookup(lookupName);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	private static String getlookupName() {
		String appName = "";
		String moduleName = "HelloWorldSessionBean";
		String  distinctName = "";
		String beanName = HelloWorldBean.class.getSimpleName();
		final String interfaceName = HelloWorld.class.getName();
		
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
		
		return name;
	}

}
