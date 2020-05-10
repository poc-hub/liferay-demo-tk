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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TriggerMeeting}.
 * </p>
 *
 * @author Sanjay.Panchal
 * @see TriggerMeeting
 * @generated
 */
public class TriggerMeetingWrapper
	extends BaseModelWrapper<TriggerMeeting>
	implements ModelWrapper<TriggerMeeting>, TriggerMeeting {

	public TriggerMeetingWrapper(TriggerMeeting triggerMeeting) {
		super(triggerMeeting);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("meetingSeqno", getMeetingSeqno());
		attributes.put("groupId", getGroupId());
		attributes.put("meetingId", getMeetingId());
		attributes.put("meetingTitle", getMeetingTitle());
		attributes.put("issuer", getIssuer());
		attributes.put("meetingType", getMeetingType());
		attributes.put("meetDate", getMeetDate());
		attributes.put("participant", getParticipant());
		attributes.put("meetingPlace", getMeetingPlace());
		attributes.put("meetingSummary", getMeetingSummary());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedOn", getModifiedOn());
		attributes.put("isActive", isIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long meetingSeqno = (Long)attributes.get("meetingSeqno");

		if (meetingSeqno != null) {
			setMeetingSeqno(meetingSeqno);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String meetingId = (String)attributes.get("meetingId");

		if (meetingId != null) {
			setMeetingId(meetingId);
		}

		String meetingTitle = (String)attributes.get("meetingTitle");

		if (meetingTitle != null) {
			setMeetingTitle(meetingTitle);
		}

		String issuer = (String)attributes.get("issuer");

		if (issuer != null) {
			setIssuer(issuer);
		}

		String meetingType = (String)attributes.get("meetingType");

		if (meetingType != null) {
			setMeetingType(meetingType);
		}

		Date meetDate = (Date)attributes.get("meetDate");

		if (meetDate != null) {
			setMeetDate(meetDate);
		}

		String participant = (String)attributes.get("participant");

		if (participant != null) {
			setParticipant(participant);
		}

		String meetingPlace = (String)attributes.get("meetingPlace");

		if (meetingPlace != null) {
			setMeetingPlace(meetingPlace);
		}

		String meetingSummary = (String)attributes.get("meetingSummary");

		if (meetingSummary != null) {
			setMeetingSummary(meetingSummary);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdOn = (Date)attributes.get("createdOn");

		if (createdOn != null) {
			setCreatedOn(createdOn);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedOn = (Date)attributes.get("modifiedOn");

		if (modifiedOn != null) {
			setModifiedOn(modifiedOn);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	/**
	 * Returns the created by of this trigger meeting.
	 *
	 * @return the created by of this trigger meeting
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created on of this trigger meeting.
	 *
	 * @return the created on of this trigger meeting
	 */
	@Override
	public Date getCreatedOn() {
		return model.getCreatedOn();
	}

	/**
	 * Returns the group ID of this trigger meeting.
	 *
	 * @return the group ID of this trigger meeting
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this trigger meeting.
	 *
	 * @return the is active of this trigger meeting
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the issuer of this trigger meeting.
	 *
	 * @return the issuer of this trigger meeting
	 */
	@Override
	public String getIssuer() {
		return model.getIssuer();
	}

	/**
	 * Returns the meet date of this trigger meeting.
	 *
	 * @return the meet date of this trigger meeting
	 */
	@Override
	public Date getMeetDate() {
		return model.getMeetDate();
	}

	/**
	 * Returns the meeting ID of this trigger meeting.
	 *
	 * @return the meeting ID of this trigger meeting
	 */
	@Override
	public String getMeetingId() {
		return model.getMeetingId();
	}

	/**
	 * Returns the meeting place of this trigger meeting.
	 *
	 * @return the meeting place of this trigger meeting
	 */
	@Override
	public String getMeetingPlace() {
		return model.getMeetingPlace();
	}

	/**
	 * Returns the meeting seqno of this trigger meeting.
	 *
	 * @return the meeting seqno of this trigger meeting
	 */
	@Override
	public long getMeetingSeqno() {
		return model.getMeetingSeqno();
	}

	/**
	 * Returns the meeting summary of this trigger meeting.
	 *
	 * @return the meeting summary of this trigger meeting
	 */
	@Override
	public String getMeetingSummary() {
		return model.getMeetingSummary();
	}

	/**
	 * Returns the meeting title of this trigger meeting.
	 *
	 * @return the meeting title of this trigger meeting
	 */
	@Override
	public String getMeetingTitle() {
		return model.getMeetingTitle();
	}

	/**
	 * Returns the meeting type of this trigger meeting.
	 *
	 * @return the meeting type of this trigger meeting
	 */
	@Override
	public String getMeetingType() {
		return model.getMeetingType();
	}

	/**
	 * Returns the modified by of this trigger meeting.
	 *
	 * @return the modified by of this trigger meeting
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified on of this trigger meeting.
	 *
	 * @return the modified on of this trigger meeting
	 */
	@Override
	public Date getModifiedOn() {
		return model.getModifiedOn();
	}

	/**
	 * Returns the participant of this trigger meeting.
	 *
	 * @return the participant of this trigger meeting
	 */
	@Override
	public String getParticipant() {
		return model.getParticipant();
	}

	/**
	 * Returns the primary key of this trigger meeting.
	 *
	 * @return the primary key of this trigger meeting
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this trigger meeting is is active.
	 *
	 * @return <code>true</code> if this trigger meeting is is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsActive() {
		return model.isIsActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created by of this trigger meeting.
	 *
	 * @param createdBy the created by of this trigger meeting
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created on of this trigger meeting.
	 *
	 * @param createdOn the created on of this trigger meeting
	 */
	@Override
	public void setCreatedOn(Date createdOn) {
		model.setCreatedOn(createdOn);
	}

	/**
	 * Sets the group ID of this trigger meeting.
	 *
	 * @param groupId the group ID of this trigger meeting
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this trigger meeting is is active.
	 *
	 * @param isActive the is active of this trigger meeting
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the issuer of this trigger meeting.
	 *
	 * @param issuer the issuer of this trigger meeting
	 */
	@Override
	public void setIssuer(String issuer) {
		model.setIssuer(issuer);
	}

	/**
	 * Sets the meet date of this trigger meeting.
	 *
	 * @param meetDate the meet date of this trigger meeting
	 */
	@Override
	public void setMeetDate(Date meetDate) {
		model.setMeetDate(meetDate);
	}

	/**
	 * Sets the meeting ID of this trigger meeting.
	 *
	 * @param meetingId the meeting ID of this trigger meeting
	 */
	@Override
	public void setMeetingId(String meetingId) {
		model.setMeetingId(meetingId);
	}

	/**
	 * Sets the meeting place of this trigger meeting.
	 *
	 * @param meetingPlace the meeting place of this trigger meeting
	 */
	@Override
	public void setMeetingPlace(String meetingPlace) {
		model.setMeetingPlace(meetingPlace);
	}

	/**
	 * Sets the meeting seqno of this trigger meeting.
	 *
	 * @param meetingSeqno the meeting seqno of this trigger meeting
	 */
	@Override
	public void setMeetingSeqno(long meetingSeqno) {
		model.setMeetingSeqno(meetingSeqno);
	}

	/**
	 * Sets the meeting summary of this trigger meeting.
	 *
	 * @param meetingSummary the meeting summary of this trigger meeting
	 */
	@Override
	public void setMeetingSummary(String meetingSummary) {
		model.setMeetingSummary(meetingSummary);
	}

	/**
	 * Sets the meeting title of this trigger meeting.
	 *
	 * @param meetingTitle the meeting title of this trigger meeting
	 */
	@Override
	public void setMeetingTitle(String meetingTitle) {
		model.setMeetingTitle(meetingTitle);
	}

	/**
	 * Sets the meeting type of this trigger meeting.
	 *
	 * @param meetingType the meeting type of this trigger meeting
	 */
	@Override
	public void setMeetingType(String meetingType) {
		model.setMeetingType(meetingType);
	}

	/**
	 * Sets the modified by of this trigger meeting.
	 *
	 * @param modifiedBy the modified by of this trigger meeting
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified on of this trigger meeting.
	 *
	 * @param modifiedOn the modified on of this trigger meeting
	 */
	@Override
	public void setModifiedOn(Date modifiedOn) {
		model.setModifiedOn(modifiedOn);
	}

	/**
	 * Sets the participant of this trigger meeting.
	 *
	 * @param participant the participant of this trigger meeting
	 */
	@Override
	public void setParticipant(String participant) {
		model.setParticipant(participant);
	}

	/**
	 * Sets the primary key of this trigger meeting.
	 *
	 * @param primaryKey the primary key of this trigger meeting
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected TriggerMeetingWrapper wrap(TriggerMeeting triggerMeeting) {
		return new TriggerMeetingWrapper(triggerMeeting);
	}

}