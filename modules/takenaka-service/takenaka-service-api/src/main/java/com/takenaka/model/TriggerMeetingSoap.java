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
 * This class is used by SOAP remote services, specifically {@link com.takenaka.service.http.TriggerMeetingServiceSoap}.
 *
 * @author Sanjay.Panchal
 * @generated
 */
public class TriggerMeetingSoap implements Serializable {

	public static TriggerMeetingSoap toSoapModel(TriggerMeeting model) {
		TriggerMeetingSoap soapModel = new TriggerMeetingSoap();

		soapModel.setMeetingSeqno(model.getMeetingSeqno());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setMeetingId(model.getMeetingId());
		soapModel.setMeetingTitle(model.getMeetingTitle());
		soapModel.setIssuer(model.getIssuer());
		soapModel.setMeetingType(model.getMeetingType());
		soapModel.setMeetDate(model.getMeetDate());
		soapModel.setParticipant(model.getParticipant());
		soapModel.setMeetingPlace(model.getMeetingPlace());
		soapModel.setMeetingSummary(model.getMeetingSummary());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedOn(model.getCreatedOn());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedOn(model.getModifiedOn());
		soapModel.setIsActive(model.isIsActive());

		return soapModel;
	}

	public static TriggerMeetingSoap[] toSoapModels(TriggerMeeting[] models) {
		TriggerMeetingSoap[] soapModels = new TriggerMeetingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TriggerMeetingSoap[][] toSoapModels(
		TriggerMeeting[][] models) {

		TriggerMeetingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TriggerMeetingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TriggerMeetingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TriggerMeetingSoap[] toSoapModels(
		List<TriggerMeeting> models) {

		List<TriggerMeetingSoap> soapModels = new ArrayList<TriggerMeetingSoap>(
			models.size());

		for (TriggerMeeting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TriggerMeetingSoap[soapModels.size()]);
	}

	public TriggerMeetingSoap() {
	}

	public long getPrimaryKey() {
		return _meetingSeqno;
	}

	public void setPrimaryKey(long pk) {
		setMeetingSeqno(pk);
	}

	public long getMeetingSeqno() {
		return _meetingSeqno;
	}

	public void setMeetingSeqno(long meetingSeqno) {
		_meetingSeqno = meetingSeqno;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getMeetingId() {
		return _meetingId;
	}

	public void setMeetingId(String meetingId) {
		_meetingId = meetingId;
	}

	public String getMeetingTitle() {
		return _meetingTitle;
	}

	public void setMeetingTitle(String meetingTitle) {
		_meetingTitle = meetingTitle;
	}

	public String getIssuer() {
		return _issuer;
	}

	public void setIssuer(String issuer) {
		_issuer = issuer;
	}

	public String getMeetingType() {
		return _meetingType;
	}

	public void setMeetingType(String meetingType) {
		_meetingType = meetingType;
	}

	public Date getMeetDate() {
		return _meetDate;
	}

	public void setMeetDate(Date meetDate) {
		_meetDate = meetDate;
	}

	public String getParticipant() {
		return _participant;
	}

	public void setParticipant(String participant) {
		_participant = participant;
	}

	public String getMeetingPlace() {
		return _meetingPlace;
	}

	public void setMeetingPlace(String meetingPlace) {
		_meetingPlace = meetingPlace;
	}

	public String getMeetingSummary() {
		return _meetingSummary;
	}

	public void setMeetingSummary(String meetingSummary) {
		_meetingSummary = meetingSummary;
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

	private long _meetingSeqno;
	private long _groupId;
	private String _meetingId;
	private String _meetingTitle;
	private String _issuer;
	private String _meetingType;
	private Date _meetDate;
	private String _participant;
	private String _meetingPlace;
	private String _meetingSummary;
	private String _createdBy;
	private Date _createdOn;
	private String _modifiedBy;
	private Date _modifiedOn;
	private boolean _isActive;

}