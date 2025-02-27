/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2014, Montreal PROT, or individual contributors as
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
package org.bigtester.ate.xmlschema;

import java.util.List;

import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.constant.XsdElementConstants;
import org.bigtester.ate.model.project.TestProject;
import org.eclipse.jdt.annotation.Nullable;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

// TODO: Auto-generated Javadoc
/**
 * This class SimpleDateFormatBeanDefinitionParser defines ....
 * 
 * @author Peidong Hu
 *
 */
public class TestProjectBeanDefinitionParser extends
		AbstractBeanDefinitionParser {
	
	/** The Constant ELEMENT_MAILER. */
	public final static String ELEMENT_MAILER = "mailer";
	
	/** The Constant PROP_MAILER. */
	public final static String PROP_MAILER = "mailer";
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @Nullable AbstractBeanDefinition parseInternal(@Nullable Element element,
			@Nullable ParserContext parserContext) {
		// Here we parse the Spring elements such as < property>
		if (parserContext==null || element == null ) throw GlobalUtils.createNotInitializedException("element and parserContext");
		// this will never be null since the schema explicitly requires that a
		// value be supplied
		
		BeanDefinitionBuilder factory = BeanDefinitionBuilder
				.rootBeanDefinition(TestProject.class);
		
		int stepThinkTime = Integer.parseInt(element
				.getAttribute(XsdElementConstants.ATTR_TESTPROJECT_STEPTHINKTIME));
		factory.addPropertyValue(XsdElementConstants.ATTR_TESTPROJECT_STEPTHINKTIME,
				stepThinkTime);
		
		String globalInitXml = element
				.getAttribute(XsdElementConstants.ATTR_TESTPROJECT_GLOBALINITXMLFILE);
		
		factory.addConstructorArgValue(globalInitXml);

		List<Element> suiteListElements = (List<Element>) DomUtils
				.getChildElementsByTagName(element,
						XsdElementConstants.ELEMENT_TESTSUITE);

		if (suiteListElements != null && !suiteListElements.isEmpty()) {
			parseSuiteComponents(suiteListElements, factory, parserContext);
		}

		Element mailerElement = DomUtils.getChildElementByTagName(element, ELEMENT_MAILER);
		if (mailerElement != null) {
			parseMailerComponent(mailerElement, factory, parserContext);
		}
		
		return factory.getBeanDefinition();
	}

	/**
	 * Parses the suite components.
	 *
	 * @param childElements the child elements
	 * @param factory the factory
	 * @param parserContext the parser context
	 */
	private static void parseSuiteComponents(List<Element> childElements,
			BeanDefinitionBuilder factory, ParserContext parserContext) {
		ManagedList<BeanDefinition> children = new ManagedList<BeanDefinition>(
				childElements.size());
		for (Element element : childElements) {
			TestSuiteBeanDefinitionParser xmltestsuite = new TestSuiteBeanDefinitionParser();
			children.add(xmltestsuite.parse(element, parserContext));

		}
		factory.addPropertyValue(XsdElementConstants.PROP_TESTPROJECT_SUITELIST, children);
	}
	
	/**
	 * Parses the mailer component.
	 *
	 * @param child the child
	 * @param factory the factory
	 * @param parserContext the parser context
	 */
	private static void parseMailerComponent(Element child,
			BeanDefinitionBuilder factory, ParserContext parserContext) {
		
		MailerBeanDefinitionParser childMailerParser = new MailerBeanDefinitionParser();
		BeanDefinition mailerBD = childMailerParser.parse(child, parserContext);
				

		factory.addPropertyValue(PROP_MAILER, mailerBD);
	}

}
