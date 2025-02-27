/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2015, Montreal PROT, or individual contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Montreal PROT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.bigtester.ate.test.ead;


import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.model.casestep.HomeStep;
import org.bigtester.ate.model.casestep.ElementTestStep;
import org.bigtester.ate.model.casestep.LastStep;
import org.bigtester.ate.model.data.exception.RuntimeDataException;
import org.bigtester.ate.model.page.atewebdriver.exception.BrowserUnexpectedException;
import org.bigtester.ate.model.page.exception.PageValidationException;
import org.bigtester.ate.model.page.exception.StepExecutionException;
import org.bigtester.ate.model.page.page.MyWebElement;
import org.bigtester.ate.test.BigtesterProjectTest;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.AfterClass;


/**
 * This class EadSaveAllCookiesTest testing the save and load cookies
 * elementaction definition. It is a good example of how to use real spring bean
 * to unit test or integration test.
 * 
 * To run this test, the web site bigtester.com has to be alive and Internet connection is required.
 * 
 * @author Peidong Hu
 *
 */
//@ContextConfiguration(locations = { "classpath:bigtesterTestNG/testSuite01/unexpectedAlertHandling.xml" })
public class UnexpectedAlertEADTest extends BigtesterProjectTest {

	/**
	 * Ead test.
	 * 
	 * @throws RuntimeDataException
	 * @throws PageValidationException
	 * @throws StepExecutionException 
	 * @throws BrowserUnexpectedException 
	 * @throws NoSuchElementException 
	 */
	//@Test(priority = 1)
	public void eadHandleUnexpectedAlertTest() throws PageValidationException,
			RuntimeDataException, StepExecutionException, NoSuchElementException, BrowserUnexpectedException {

		getMyDriver().getWebDriverInstance();

		HomeStep homeStep = (HomeStep) GlobalUtils
				.getTargetObject(getApplicationContext().getBean(
						"stepOpenAlertHomePage"));
		homeStep.doStep(null);


		MyWebElement<?> clickAlertWinLink = (MyWebElement<?>) getApplicationContext()
				.getBean("eadClickAlertWinLink");
		clickAlertWinLink.doAction();
		
		ElementTestStep closeStep = (ElementTestStep) GlobalUtils
				.getTargetObject(getApplicationContext().getBean(
						"stepCloseAlertWindow"));
		
		closeStep.doStep(null);
		ElementTestStep stepAccepAlert = (ElementTestStep) GlobalUtils
				.getTargetObject(getApplicationContext().getBean(
						"stepAccepAlert"));
		stepAccepAlert.doStep(null);
		
		
//		MyWebElement<?> eadSwitchToMainWindow = (MyWebElement<?>) getApplicationContext()
//		.getBean("eadSwitchToMainWindow");
//		eadSwitchToMainWindow.doAction();

		
		LastStep stepLastStep = (LastStep) GlobalUtils
				.getTargetObject(getApplicationContext().getBean(
						"stepLastStep"));
		stepLastStep.doStep(null);
		

	}

	
	
	/**
	 * {@inheritDoc}
	 */
	@AfterClass
	public void tearDown() { //NOPMD
	//nothing to do here.
	}

	
}
