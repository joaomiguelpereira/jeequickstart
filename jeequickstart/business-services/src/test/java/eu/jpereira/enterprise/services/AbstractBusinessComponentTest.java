/**
 * Copyright [2011] [Joao Pereira - http://jpereira.eu]
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.enterprise.services;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.mockito.Mockito;

/**
 * Abstract Test for BusinessComponent
 * @author jpereira
 */
public abstract class AbstractBusinessComponentTest<T extends AbstractBusinessComponent> {

	
	
	protected EntityManager emMock;
	 
	
	@Before
	public void setup() {
		this.emMock = Mockito.mock(EntityManager.class);
	}
	
	
	
	
	
	/**
	 * Create a BusinessComponent of type <T> and set a Mocked EntityManager
	 * @return instance of <T>
	 * @throws Exception If T cannot be instantiated. Check if is and concrete class
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected T createBusinessComponentInstanceUnderTest() throws Exception{
		
		ParameterizedType parameterizedType =
			    (ParameterizedType) getClass().getGenericSuperclass();
		//Create new instance
		Class<?> clazz =(Class)parameterizedType.getActualTypeArguments()[0];
		AbstractBusinessComponent component = (AbstractBusinessComponent)clazz.newInstance();
		component.setEntityManager(this.emMock);
		return (T)component;
	}
	


}