package com.Pages;


	import org.openqa.selenium.By;

	import org.openqa.selenium.WebDriver;

	public class LoginPage
	{

		private WebDriver driver;

		// 1. By Locators:
		private By emailId = By.id("username");
		private By password = By.id("password");
		private By LogInButton = By.name("login");
		private By Lostyourpassword = By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[4]/a");
		
		// 2. Constructor of the page class:
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}

		// 3. page actions:

		public String getLoginPageTitle()
		{
			return driver.getTitle();
		}

		public boolean isForgotPwdLinkExist()
		{
			return driver.findElement(Lostyourpassword).isDisplayed();
		}

		public void enterUserName(String username) 
		{
			driver.findElement(emailId).sendKeys(username);
		}

		public void enterPassword(String pwd)
		{
			driver.findElement(password).sendKeys(pwd);
		}

		public void clickOnLogin()
		{
			driver.findElement(LogInButton).click();
		}

		public AccountsPage doLogin(String un, String pwd)
		{
			System.out.println("login with: " + un + " and " + pwd);
			driver.findElement(emailId).sendKeys(un);
			driver.findElement(password).sendKeys(pwd);
			driver.findElement(LogInButton).click();
			return new AccountsPage(driver);
		}

	}

