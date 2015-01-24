/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.fhir.resources;

import ca.uhn.fhir.model.dstu.resource.Location;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.openmrs.api.context.Context;
import org.openmrs.module.fhir.api.LocationService;

public class FHIRLocationResource extends Resource {

	public Location getByUniqueId(IdDt id) {
		LocationService locationService = Context.getService(LocationService.class);
		Location fhirLocation = locationService.getLocation(id.getIdPart());
		if(fhirLocation == null) {
			throw new ResourceNotFoundException("Location is not found for the given Id " + id.getIdPart());
		}
		return fhirLocation;
	}

}