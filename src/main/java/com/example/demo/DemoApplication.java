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
		System.out.print("Clojure foo: ");
		System.out.println(cljFoo.invoke(123));
		System.out.print("Clojure bar: ");
		System.out.println(cljBar.invoke(123));

		DemoClass dc = new DemoClass();
		dc.foo((long)999);
		dc.bar((long)999);

		IFn cljStartXtdb = Clojure.var("demo.core", "start-xtdb");
		IFn cljStopXtdb = Clojure.var("demo.core", "stop-xtdb");
		Object node = cljStartXtdb.invoke();
		System.out.print("Xtdb Node: ");
		System.out.println(node);
		cljStopXtdb.invoke(node);

		SpringApplication.run(DemoApplication.class, args);
	}
}
