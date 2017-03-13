package com.sci.bvi.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.cucumber.listener.Reporter;
//import com.sun.jna.platform.FileUtils;

public class library {
	public String imgName;

	/**
	 * gOX is get Object's xPath Returns the xPath of the object based on the OS
	 * of the device from the file ObjectRepository.xml
	 * 
	 * @author Gangadhar@sciits.com
	 * @since June 10 2015
	 * @category Framework
	 * @param WebDriver
	 * @param String
	 *            Name of the Object in object repository
	 * @return String i.e the xPath of the Object
	 */
	public String gOX(WebDriver driver, String property) {
		String returnval = "";
		// String OStype = "";
		XPathFactory factory = XPathFactory.newInstance();
		XPath xPath = factory.newXPath();
		File xmlDocument = new File("src/test/resources/ObjectRepository.xml");
		InputSource inputSource = null;
		try {
			inputSource = null;
			try {
				inputSource = new InputSource(new FileInputStream(xmlDocument));
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
			returnval = xPath.evaluate("//object/name[.='" + property + "']/../xpath", inputSource);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnval.replace(" &amp; ", " & ");
	}

	/**
	 * 
	 * Gets the value of property from Properties.xml file using the xPath
	 * 
	 * @author Gangadhar@sciits.com
	 * @since June 10 2015
	 * @category Framework
	 * @param property
	 * @return
	 */
	public String getProp(String property) {
		String returnval = "waste";
		XPathFactory factory = XPathFactory.newInstance();
		XPath xPath = factory.newXPath();
		File xmlDocument = new File("src/test/resources/Properties.xml");
		InputSource inputSource = null;
		try {
			inputSource = null;
			try {
				inputSource = new InputSource(new FileInputStream(xmlDocument));
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
			returnval = xPath.evaluate("//" + property, inputSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnval.replace(" &amp; ", " & ");
	}

	/**
	 * 
	 * Set's the value to the property in Properties.xml file using the xPath
	 * 
	 * @author Gangadhar@sciits.com
	 * @since June 10 2015
	 * @category Framework
	 * @param property
	 * @return
	 */
	public void setProp(String property, String value) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse("Properties.xml");
			Element docEle = dom.getDocumentElement();
			NodeList nl = docEle.getElementsByTagName(property);
			nl.item(0).setTextContent(value);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source1 = new DOMSource(dom);
			StreamResult result1 = new StreamResult(new File("Properties.xml"));
			transformer.transform(source1, result1);
		} catch (DOMException e1) {
			e1.printStackTrace();
		} catch (TransformerConfigurationException e1) {
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (TransformerFactoryConfigurationError e1) {
			e1.printStackTrace();
		} catch (TransformerException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Returns the current Date and time in the String format as
	 * EEEdMMMyyyyHHmmss
	 * 
	 * @author Gangadhar@sciits.com
	 * @since June 10 2015
	 * @return String in format as EEEdMMMyyyyHHmmss
	 */
	public String curDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEdMMMyyyyHHmmss");
		return (sdf.format(cal.getTime()));
	}

	public void waitForWorking(WebDriver driver) {
		JavascriptExecutor exec = (JavascriptExecutor) driver;
		// boolean working=true;
		for (int i = 0;; i++) {
			if ((Boolean) exec.executeScript("return true;")) {
				return;
			}
			pause(1000);

		}
	}

	public void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void wait2ObjPresentX(WebDriver driver, String xpath) {
		boolean cond;
		do {
			try {
				driver.findElement(By.xpath(xpath));
				System.out.println(curDateTime() + xpath + " Is now found");
				cond = false;
			} catch (Exception e) {
				cond = true;
			}
		} while (cond);
	}

	public void wait2ObjAbsentX(WebDriver driver, String xpath) {
		boolean cond;
		do {
			try {
				driver.findElement(By.xpath(xpath));
				System.out.println(curDateTime() + xpath + " Is not found Now");
				cond = true;
			} catch (Exception e) {
				cond = false;
			}
		} while (cond);
	}

	public void wait2ObjAbsentX1(WebDriver driver, String xpath) {
		do {
			pause(100);
			System.out.println(curDateTime() + xpath + " Is not found Now");
		} while (driver.findElement(By.xpath(xpath)).isDisplayed());
	}

	public void wait2ObjPresentId(WebDriver driver, String id) {
		boolean cond;
		do {
			try {
				driver.findElement(By.id(id));
				System.out.println(curDateTime() + "Object with id: " + id + " Is now found");
				cond = false;
			} catch (Exception e) {
				cond = true;
			}
		} while (cond);
	}

	public void wait2ObjAbsentId(WebDriver driver, String id) {
		boolean cond;
		do {
			try {
				driver.findElement(By.id(id));
				System.out.println(curDateTime() + "Object with id: " + id + " Is now not found");
				cond = false;
			} catch (Exception e) {
				cond = true;
			}
		} while (!cond);
	}

	public void signin(WebDriver driver) {
		driver.get("http://182.74.133.92:8080/BB_UI/#/login");
		waitForWorking(driver);
		// Reporter.addStepLog("Step Log message goes here");
		// Reporter.addScenarioLog("Scenario Log message goes here");
		// Reporter.addScreenCaptureFromPath("absolute screenshot path");
		// Reporter.addScreenCastFromPath("absolute screen cast path");
		assertEquals(driver.getTitle(), "Theme Template for Bootstrap");
		driver.findElement(By.xpath(gOX(driver, "usrname"))).clear();
		driver.findElement(By.xpath(gOX(driver, "usrname"))).sendKeys(getProp("rausr"));
		log(driver,"Entered the username");
		driver.findElement(By.xpath(gOX(driver, "pwd"))).clear();
		driver.findElement(By.xpath(gOX(driver, "pwd"))).sendKeys(getProp("rapwd"));
		log(driver,"Entered the Password");
		driver.findElement(By.xpath(gOX(driver, "submit"))).click();
		log(driver,"EClicked the Submit button");
		waitForWorking(driver);
		waitForWorking(driver);
	}

	public void log(WebDriver driver,String msg) {
		File scrFile;
		String abspath = "/test-output/Screenshots/";
		imgName = abspath + (curDateTime()) + ".png";
		scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(imgName));
			Reporter.addStepLog(msg);
			Reporter.addScreenCaptureFromPath(scrFile+"/" + imgName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
