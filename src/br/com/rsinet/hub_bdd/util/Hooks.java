package br.com.rsinet.hub_bdd.util;

import br.com.rsinet.hub_bdd.cucumber.TestContext;
import br.com.rsinet.hub_bdd.managers.WebDriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;
	WebDriverManager manager;

	public Hooks(TestContext context) {
		testContext = context;
		manager = testContext.getWebDriverManager();
	}

	@Before
	public void BeforeSteps() {
		manager.getDriver();
	}

	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().quitDriver();
	}

}
