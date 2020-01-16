package jdbc;

import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngProject {
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	@Test
	public void test1() {
		System.out.println("test1");
	}
	@Test
	public void test2() {
		System.out.println("test2");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("AfterClass");
	}
	@AfterTest
	public void AfterTest() {
		System.out.println("AfterTest");
	}
	//2020.1.16
}
