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

package com.takenaka.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.takenaka.service.http.TriggerMeetingDetailsServiceSoap}.
 *
 * @author Sanjay.Panchal
 * @generated
 */
public class TriggerMeetingDetailsSoap implements Serializable {

	public static TriggerMeetingDetailsSoap toSoapModel(
		TriggerMeetingDetails model) {

		TriggerMeetingDetailsSoap soapModel = new TriggerMeetingDetailsSoap();

		soapModel.setMeetingdetailSeqno(model.getMeetingdetailSeqno());
		soapModel.setMeetingSeqno(model.getMeetingSeqno());
		soapModel.setCategory(model.getCategory());
		soapModel.setFloor(model.getFloor());
		soapModel.setItem(model.getItem());
		soapModel.setActions(model.getActions());
		soapModel.setRESPONSE_DUEDATE(model.getRESPONSE_DUEDATE());
		soapModel.setPersonInCharge(model.getPersonInCharge());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedOn(model.getCreatedOn());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedOn(model.getModifiedOn());
		soapModel.setIsActive(model.isIsActive());

		return soapModel;
	}

	public static TriggerMeetingDetailsSoap[] toSoapModels(
		TriggerMeetingDetails[] models) {

		TriggerMeetingDetailsSoap[] soapModels =
			new TriggerMeetingDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TriggerMeetingDetailsSoap[][] toSoapModels(
		TriggerMeetingDetails[][] models) {

		TriggerMeetingDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TriggerMeetingDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TriggerMeetingDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TriggerMeetingDetailsSoap[] toSoapModels(
		List<TriggerMeetingDetails> models) {

		List<TriggerMeetingDetailsSoap> soapModels =
			new ArrayList<TriggerMeetingDetailsSoap>(models.size());

		for (TriggerMeetingDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TriggerMeetingDetailsSoap[soapModels.size()]);
	}

	public TriggerMeetingDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _meetingdetailSeqno;
	}

	public void setPrimaryKey(long pk) {
		setMeetingdetailSeqno(pk);
	}

	public long getMeetingdetailSeqno() {
		return _meetingdetailSeqno;
	}

	public void setMeetingdetailSeqno(long meetingdetailSeqno) {
		_meetingdetailSeqno = meetingdetailSeqno;
	}

	public long getMeetingSeqno() {
		return _meetingSeqno;
	}

	public void setMeetingSeqno(long meetingSeqno) {
		_meetingSeqno = meetingSeqno;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getFloor() {
		return _floor;
	}

	public void setFloor(String floor) {
		_floor = floor;
	}

	public String getItem() {
		return _item;
	}

	public void setItem(String item) {
		_item = item;
	}

	public String getActions() {
		return _actions;
	}

	public void setActions(String actions) {
		_actions = actions;
	}

	public Date getRESPONSE_DUEDATE() {
		return _RESPONSE_DUEDATE;
	}

	public void setRESPONSE_DUEDATE(Date RESPONSE_DUEDATE) {
		_RESPONSE_DUEDATE = RESPONSE_DUEDATE;
	}

	public String getPersonInCharge() {
		return _personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		_personInCharge = personInCharge;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return _createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		_createdOn = createdOn;
	}

	public String getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return _modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		_modifiedOn = modifiedOn;
	}

	public boolean getIsActive() {
		return _isActive;
	}

	public boolean isIsActive() {
		return _isActive;
	}

	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	private long _meetingdetailSeqno;
	private long _meetingSeqno;
	private String _category;
	private String _floor;
	private String _item;
	private String _actions;

	private Date _RESPONSE_DUEDATE;

	private String _personInCharge;
	private String _createdBy;
	private Date _createdOn;
	private String _modifiedBy;
	private Date _modifiedOn;
	private boolean _isActive;

}