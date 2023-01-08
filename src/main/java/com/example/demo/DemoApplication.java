package com.example.demo;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import demo.DemoClass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//IFn cljPlus = Clojure.var("clojure.core", "+");
		//System.out.println("Clojure plus:");
		//System.out.println(cljPlus.invoke(123, 234));

		IFn require = Clojure.var("clojure.core", "require");
		require.invoke(Clojure.read("demo.core"));

		IFn cljFoo = Clojure.var("demo.core", "foo");
		IFn cljBar = Clojure.var("demo.core", "bar");
		System.out.println("Clojure foo: ");
		System.out.println(cljFoo.invoke(123));
		System.out.println("Clojure bar: ");
		System.out.println(cljBar.invoke(123));

		DemoClass dc = new DemoClass();
		dc.foo((long)999);
		dc.bar((long)999);

		SpringApplication.run(DemoApplication.class, args);
	}

}
