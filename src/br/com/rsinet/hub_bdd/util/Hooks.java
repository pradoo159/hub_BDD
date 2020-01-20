package br.com.rsinet.hub_bdd.util;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void BeforeScenario() {
		System.out.println("Isso irá rodar antes do cenário");
	}

	@After
	public void AfterScenario() {
		System.out.println("Isso irá rodar após o cenário");
	}

}
