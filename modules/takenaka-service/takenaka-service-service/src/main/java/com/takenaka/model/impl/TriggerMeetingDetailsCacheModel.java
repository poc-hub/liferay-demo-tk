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

package com.takenaka.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.takenaka.model.TriggerMeetingDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TriggerMeetingDetails in entity cache.
 *
 * @author Sanjay.Panchal
 * @generated
 */
public class TriggerMeetingDetailsCacheModel
	implements CacheModel<TriggerMeetingDetails>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TriggerMeetingDetailsCacheModel)) {
			return false;
		}

		TriggerMeetingDetailsCacheModel triggerMeetingDetailsCacheModel =
			(TriggerMeetingDetailsCacheModel)obj;

		if (meetingdetailSeqno ==
				triggerMeetingDetailsCacheModel.meetingdetailSeqno) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, meetingdetailSeqno);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{meetingdetailSeqno=");
		sb.append(meetingdetailSeqno);
		sb.append(", meetingSeqno=");
		sb.append(meetingSeqno);
		sb.append(", category=");
		sb.append(category);
		sb.append(", floor=");
		sb.append(floor);
		sb.append(", item=");
		sb.append(item);
		sb.append(", actions=");
		sb.append(actions);
		sb.append(", RESPONSE_DUEDATE=");
		sb.append(RESPONSE_DUEDATE);
		sb.append(", personInCharge=");
		sb.append(personInCharge);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdOn=");
		sb.append(createdOn);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedOn=");
		sb.append(modifiedOn);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TriggerMeetingDetails toEntityModel() {
		TriggerMeetingDetailsImpl triggerMeetingDetailsImpl =
			new TriggerMeetingDetailsImpl();

		triggerMeetingDetailsImpl.setMeetingdetailSeqno(meetingdetailSeqno);
		triggerMeetingDetailsImpl.setMeetingSeqno(meetingSeqno);

		if (category == null) {
			triggerMeetingDetailsImpl.setCategory("");
		}
		else {
			triggerMeetingDetailsImpl.setCategory(category);
		}

		if (floor == null) {
			triggerMeetingDetailsImpl.setFloor("");
		}
		else {
			triggerMeetingDetailsImpl.setFloor(floor);
		}

		if (item == null) {
			triggerMeetingDetailsImpl.setItem("");
		}
		else {
			triggerMeetingDetailsImpl.setItem(item);
		}

		if (actions == null) {
			triggerMeetingDetailsImpl.setActions("");
		}
		else {
			triggerMeetingDetailsImpl.setActions(actions);
		}

		if (RESPONSE_DUEDATE == Long.MIN_VALUE) {
			triggerMeetingDetailsImpl.setRESPONSE_DUEDATE(null);
		}
		else {
			triggerMeetingDetailsImpl.setRESPONSE_DUEDATE(
				new Date(RESPONSE_DUEDATE));
		}

		if (personInCharge == null) {
			triggerMeetingDetailsImpl.setPersonInCharge("");
		}
		else {
			triggerMeetingDetailsImpl.setPersonInCharge(personInCharge);
		}

		if (createdBy == null) {
			triggerMeetingDetailsImpl.setCreatedBy("");
		}
		else {
			triggerMeetingDetailsImpl.setCreatedBy(createdBy);
		}

		if (createdOn == Long.MIN_VALUE) {
			triggerMeetingDetailsImpl.setCreatedOn(null);
		}
		else {
			triggerMeetingDetailsImpl.setCreatedOn(new Date(createdOn));
		}

		if (modifiedBy == null) {
			triggerMeetingDetailsImpl.setModifiedBy("");
		}
		else {
			triggerMeetingDetailsImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedOn == Long.MIN_VALUE) {
			triggerMeetingDetailsImpl.setModifiedOn(null);
		}
		else {
			triggerMeetingDetailsImpl.setModifiedOn(new Date(modifiedOn));
		}

		triggerMeetingDetailsImpl.setIsActive(isActive);

		triggerMeetingDetailsImpl.resetOriginalValues();

		return triggerMeetingDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		meetingdetailSeqno = objectInput.readLong();

		meetingSeqno = objectInput.readLong();
		category = objectInput.readUTF();
		floor = objectInput.readUTF();
		item = objectInput.readUTF();
		actions = objectInput.readUTF();
		RESPONSE_DUEDATE = objectInput.readLong();
		personInCharge = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		createdOn = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedOn = objectInput.readLong();

		isActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(meetingdetailSeqno);

		objectOutput.writeLong(meetingSeqno);

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (floor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(floor);
		}

		if (item == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(item);
		}

		if (actions == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actions);
		}

		objectOutput.writeLong(RESPONSE_DUEDATE);

		if (personInCharge == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(personInCharge);
		}

		if (createdBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(createdOn);

		if (modifiedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}

		objectOutput.writeLong(modifiedOn);

		objectOutput.writeBoolean(isActive);
	}

	public long meetingdetailSeqno;
	public long meetingSeqno;
	public String category;
	public String floor;
	public String item;
	public String actions;

	public long RESPONSE_DUEDATE;

	public String personInCharge;
	public String createdBy;
	public long createdOn;
	public String modifiedBy;
	public long modifiedOn;
	public boolean isActive;

}