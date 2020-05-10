/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.takenaka.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TriggerMeetingService}.
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingService
 * @generated
 */
public class TriggerMeetingServiceWrapper
	implements ServiceWrapper<TriggerMeetingService>, TriggerMeetingService {

	public TriggerMeetingServiceWrapper(
		TriggerMeetingService triggerMeetingService) {

		_triggerMeetingService = triggerMeetingService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _triggerMeetingService.getOSGiServiceIdentifier();
	}

	@Override
	public TriggerMeetingService getWrappedService() {
		return _triggerMeetingService;
	}

	@Override
	public void setWrappedService(TriggerMeetingService triggerMeetingService) {
		_triggerMeetingService = triggerMeetingService;
	}

	private TriggerMeetingService _triggerMeetingService;

}