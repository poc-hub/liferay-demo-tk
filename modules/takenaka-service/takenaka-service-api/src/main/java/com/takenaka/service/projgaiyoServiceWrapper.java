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
 * Provides a wrapper for {@link projgaiyoService}.
 *
 * @author Sanjay.Panchal
 * @see projgaiyoService
 * @generated
 */
public class projgaiyoServiceWrapper
	implements projgaiyoService, ServiceWrapper<projgaiyoService> {

	public projgaiyoServiceWrapper(projgaiyoService projgaiyoService) {
		_projgaiyoService = projgaiyoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projgaiyoService.getOSGiServiceIdentifier();
	}

	@Override
	public projgaiyoService getWrappedService() {
		return _projgaiyoService;
	}

	@Override
	public void setWrappedService(projgaiyoService projgaiyoService) {
		_projgaiyoService = projgaiyoService;
	}

	private projgaiyoService _projgaiyoService;

}