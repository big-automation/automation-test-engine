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
package org.bigtester.ate.model.data;

import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.annotation.RepeatStepRefreshable;
import org.bigtester.ate.annotation.RepeatStepRefreshable.RefreshDataType;
import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * This class AbstractOnTheFlyDataHolder defines ....
 *
 * @author Peidong Hu
 * @param <T> the generic type
 */
public abstract class AbstractOnTheFlyDataHolder<T> { //NOPMD
	
	/** The on the fly data. */
	@Nullable
	private T onTheFlyData;

	/**
	 * @return the onTheFlyData
	 */
	@SuppressWarnings("unchecked")
	@RepeatStepRefreshable (dataType=RefreshDataType.ONTHEFLY)
	public T getOnTheFlyData() {
		final Object onTheFlyData2 = onTheFlyData;
		if (null == onTheFlyData2 ) {
			throw GlobalUtils.createNotInitializedException("onTheFlyData");
		} else {
			return  (T) onTheFlyData2;
		}
	}

	/**
	 * @param onTheFlyData the onTheFlyData to set
	 */
	public void setOnTheFlyData(T onTheFlyData) {
		this.onTheFlyData = onTheFlyData;
	}
	
	
}
