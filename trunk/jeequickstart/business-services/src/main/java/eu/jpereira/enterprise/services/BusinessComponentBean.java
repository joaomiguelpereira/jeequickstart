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

import java.util.List;
import javax.ejb.Stateless;
import eu.jpereira.enterprise.model.BusinessEntity;

/**
 * Generic BusinessComponent Implementation
 * 
 * @author jpereira
 * 
 */
@Stateless
public class BusinessComponentBean extends AbstractBusinessComponent implements BusinessComponent {


	@Override
	public void createBusinessEntity(BusinessEntity zone) {
		em.persist(zone);

	}

	@Override
	public void removeBusinessEntity(Long businessEntityId) {
		BusinessEntity entity = em.find(BusinessEntity.class, businessEntityId);
		if (entity!=null) {
			em.remove(entity);
		}

	}

	@Override
	public void updateBusinessEntity(Long entityId,
			BusinessEntity businessEntity) {


	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.enterprise.services.BusinessComponent#retrieveAllBusinessEntities
	 * ()
	 */
	@Override
	public List<BusinessEntity> retrieveAllBusinessEntities() {
		StringBuilder jpqlBuilder = new StringBuilder();
		jpqlBuilder.append("from ");
		jpqlBuilder.append(BusinessEntity.class.getSimpleName());
		return em.createQuery(jpqlBuilder.toString(), BusinessEntity.class)
				.getResultList();
	}

}
