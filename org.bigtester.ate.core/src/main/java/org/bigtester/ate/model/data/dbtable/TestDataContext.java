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
package org.bigtester.ate.model.data.dbtable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.eclipse.jdt.annotation.Nullable;


// TODO: Auto-generated Javadoc
/**
 * This class TestDataContext defines ....
 * 
 * @author Peidong Hu
 * 
 */
@Entity
@Table
public class TestDataContext extends BaseDBTable {
	@Column(length = 50, nullable = false, unique = false)
	@Nullable
	private String contextFieldValue; //NOPMD

	
	@ManyToOne
	@JoinColumn(name = "contextFieldName_idColumn", referencedColumnName = "idColumn")
	@Nullable
	private TestDataContextFieldName contextFieldName; //NOPMD


	/**
	 * @return the contextFieldValue
	 */
	public String getContextFieldValue() {
		final String retVal = contextFieldValue;
		if (null == retVal) {
			throw new IllegalStateException("contextfieldvalue collumn is not correctly populated");
			
		} else {
			return retVal;
		}
	}


	/**
	 * @param contextFieldValue the contextFieldValue to set
	 */
	public void setContextFieldValue(String contextFieldValue) {
		this.contextFieldValue = contextFieldValue;
	}


	/**
	 * @return the contextFieldName
	 */
	public TestDataContextFieldName getContextFieldName() {
		final TestDataContextFieldName retVal = contextFieldName;
		if (null == retVal) {
			throw new IllegalStateException("contextfieldname collumn is not correctly populated");
			
		} else {
			return retVal;
		}
	}


	/**
	 * @param contextFieldName the contextFieldName to set
	 */
	public void setContextFieldName(TestDataContextFieldName contextFieldName) {
		this.contextFieldName = contextFieldName;
	}

}
