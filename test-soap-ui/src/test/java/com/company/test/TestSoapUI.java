package com.company.test;

import com.eviware.soapui.tools.SoapUITestCaseRunner;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestSoapUI {

	public static String[] readFile(String path) {
		List<String> list = null;
		try {
			list = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			//log.error(e.getMessage());
		}
		String[] array = list.toArray((new String[0]));
		return array;
	}

	@Test
	public void smokeTest() throws Exception {
		SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
		runner.setProjectFile("src/resources/demo-film-service.xml");
		runner.setJUnitReport(true);
		runner.setPrintReport(true);
		runner.setOutputFolder("target/failedTestsReports");
		runner.run();
	}
}
