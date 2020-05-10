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
 * This class is a wrapper for {@link TriggerMeetingDetails}.
 * </p>
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingDetails
 * @generated
 */
public class TriggerMeetingDetailsWrapper
	extends BaseModelWrapper<TriggerMeetingDetails>
	implements ModelWrapper<TriggerMeetingDetails>, TriggerMeetingDetails {

	public TriggerMeetingDetailsWrapper(
		TriggerMeetingDetails triggerMeetingDetails) {

		super(triggerMeetingDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("meetingdetailSeqno", getMeetingdetailSeqno());
		attributes.put("meetingSeqno", getMeetingSeqno());
		attributes.put("category", getCategory());
		attributes.put("floor", getFloor());
		attributes.put("item", getItem());
		attributes.put("actions", getActions());
		attributes.put("RESPONSE_DUEDATE", getRESPONSE_DUEDATE());
		attributes.put("personInCharge", getPersonInCharge());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedOn", getModifiedOn());
		attributes.put("isActive", isIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long meetingdetailSeqno = (Long)attributes.get("meetingdetailSeqno");

		if (meetingdetailSeqno != null) {
			setMeetingdetailSeqno(meetingdetailSeqno);
		}

		Long meetingSeqno = (Long)attributes.get("meetingSeqno");

		if (meetingSeqno != null) {
			setMeetingSeqno(meetingSeqno);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String floor = (String)attributes.get("floor");

		if (floor != null) {
			setFloor(floor);
		}

		String item = (String)attributes.get("item");

		if (item != null) {
			setItem(item);
		}

		String actions = (String)attributes.get("actions");

		if (actions != null) {
			setActions(actions);
		}

		Date RESPONSE_DUEDATE = (Date)attributes.get("RESPONSE_DUEDATE");

		if (RESPONSE_DUEDATE != null) {
			setRESPONSE_DUEDATE(RESPONSE_DUEDATE);
		}

		String personInCharge = (String)attributes.get("personInCharge");

		if (personInCharge != null) {
			setPersonInCharge(personInCharge);
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
	 * Returns the actions of this trigger meeting details.
	 *
	 * @return the actions of this trigger meeting details
	 */
	@Override
	public String getActions() {
		return model.getActions();
	}

	/**
	 * Returns the category of this trigger meeting details.
	 *
	 * @return the category of this trigger meeting details
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the created by of this trigger meeting details.
	 *
	 * @return the created by of this trigger meeting details
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created on of this trigger meeting details.
	 *
	 * @return the created on of this trigger meeting details
	 */
	@Override
	public Date getCreatedOn() {
		return model.getCreatedOn();
	}

	/**
	 * Returns the floor of this trigger meeting details.
	 *
	 * @return the floor of this trigger meeting details
	 */
	@Override
	public String getFloor() {
		return model.getFloor();
	}

	/**
	 * Returns the is active of this trigger meeting details.
	 *
	 * @return the is active of this trigger meeting details
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the item of this trigger meeting details.
	 *
	 * @return the item of this trigger meeting details
	 */
	@Override
	public String getItem() {
		return model.getItem();
	}

	/**
	 * Returns the meetingdetail seqno of this trigger meeting details.
	 *
	 * @return the meetingdetail seqno of this trigger meeting details
	 */
	@Override
	public long getMeetingdetailSeqno() {
		return model.getMeetingdetailSeqno();
	}

	/**
	 * Returns the meeting seqno of this trigger meeting details.
	 *
	 * @return the meeting seqno of this trigger meeting details
	 */
	@Override
	public long getMeetingSeqno() {
		return model.getMeetingSeqno();
	}

	/**
	 * Returns the modified by of this trigger meeting details.
	 *
	 * @return the modified by of this trigger meeting details
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified on of this trigger meeting details.
	 *
	 * @return the modified on of this trigger meeting details
	 */
	@Override
	public Date getModifiedOn() {
		return model.getModifiedOn();
	}

	/**
	 * Returns the person in charge of this trigger meeting details.
	 *
	 * @return the person in charge of this trigger meeting details
	 */
	@Override
	public String getPersonInCharge() {
		return model.getPersonInCharge();
	}

	/**
	 * Returns the primary key of this trigger meeting details.
	 *
	 * @return the primary key of this trigger meeting details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the response_duedate of this trigger meeting details.
	 *
	 * @return the response_duedate of this trigger meeting details
	 */
	@Override
	public Date getRESPONSE_DUEDATE() {
		return model.getRESPONSE_DUEDATE();
	}

	/**
	 * Returns <code>true</code> if this trigger meeting details is is active.
	 *
	 * @return <code>true</code> if this trigger meeting details is is active; <code>false</code> otherwise
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
	 * Sets the actions of this trigger meeting details.
	 *
	 * @param actions the actions of this trigger meeting details
	 */
	@Override
	public void setActions(String actions) {
		model.setActions(actions);
	}

	/**
	 * Sets the category of this trigger meeting details.
	 *
	 * @param category the category of this trigger meeting details
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the created by of this trigger meeting details.
	 *
	 * @param createdBy the created by of this trigger meeting details
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created on of this trigger meeting details.
	 *
	 * @param createdOn the created on of this trigger meeting details
	 */
	@Override
	public void setCreatedOn(Date createdOn) {
		model.setCreatedOn(createdOn);
	}

	/**
	 * Sets the floor of this trigger meeting details.
	 *
	 * @param floor the floor of this trigger meeting details
	 */
	@Override
	public void setFloor(String floor) {
		model.setFloor(floor);
	}

	/**
	 * Sets whether this trigger meeting details is is active.
	 *
	 * @param isActive the is active of this trigger meeting details
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the item of this trigger meeting details.
	 *
	 * @param item the item of this trigger meeting details
	 */
	@Override
	public void setItem(String item) {
		model.setItem(item);
	}

	/**
	 * Sets the meetingdetail seqno of this trigger meeting details.
	 *
	 * @param meetingdetailSeqno the meetingdetail seqno of this trigger meeting details
	 */
	@Override
	public void setMeetingdetailSeqno(long meetingdetailSeqno) {
		model.setMeetingdetailSeqno(meetingdetailSeqno);
	}

	/**
	 * Sets the meeting seqno of this trigger meeting details.
	 *
	 * @param meetingSeqno the meeting seqno of this trigger meeting details
	 */
	@Override
	public void setMeetingSeqno(long meetingSeqno) {
		model.setMeetingSeqno(meetingSeqno);
	}

	/**
	 * Sets the modified by of this trigger meeting details.
	 *
	 * @param modifiedBy the modified by of this trigger meeting details
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified on of this trigger meeting details.
	 *
	 * @param modifiedOn the modified on of this trigger meeting details
	 */
	@Override
	public void setModifiedOn(Date modifiedOn) {
		model.setModifiedOn(modifiedOn);
	}

	/**
	 * Sets the person in charge of this trigger meeting details.
	 *
	 * @param personInCharge the person in charge of this trigger meeting details
	 */
	@Override
	public void setPersonInCharge(String personInCharge) {
		model.setPersonInCharge(personInCharge);
	}

	/**
	 * Sets the primary key of this trigger meeting details.
	 *
	 * @param primaryKey the primary key of this trigger meeting details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the response_duedate of this trigger meeting details.
	 *
	 * @param RESPONSE_DUEDATE the response_duedate of this trigger meeting details
	 */
	@Override
	public void setRESPONSE_DUEDATE(Date RESPONSE_DUEDATE) {
		model.setRESPONSE_DUEDATE(RESPONSE_DUEDATE);
	}

	@Override
	protected TriggerMeetingDetailsWrapper wrap(
		TriggerMeetingDetails triggerMeetingDetails) {

		return new TriggerMeetingDetailsWrapper(triggerMeetingDetails);
	}

}