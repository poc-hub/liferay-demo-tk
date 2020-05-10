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

import com.takenaka.model.TriggerMeeting;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TriggerMeeting in entity cache.
 *
 * @author Sanjay.Panchal
 * @generated
 */
public class TriggerMeetingCacheModel
	implements CacheModel<TriggerMeeting>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TriggerMeetingCacheModel)) {
			return false;
		}

		TriggerMeetingCacheModel triggerMeetingCacheModel =
			(TriggerMeetingCacheModel)obj;

		if (meetingSeqno == triggerMeetingCacheModel.meetingSeqno) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, meetingSeqno);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{meetingSeqno=");
		sb.append(meetingSeqno);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", meetingId=");
		sb.append(meetingId);
		sb.append(", meetingTitle=");
		sb.append(meetingTitle);
		sb.append(", issuer=");
		sb.append(issuer);
		sb.append(", meetingType=");
		sb.append(meetingType);
		sb.append(", meetDate=");
		sb.append(meetDate);
		sb.append(", participant=");
		sb.append(participant);
		sb.append(", meetingPlace=");
		sb.append(meetingPlace);
		sb.append(", meetingSummary=");
		sb.append(meetingSummary);
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
	public TriggerMeeting toEntityModel() {
		TriggerMeetingImpl triggerMeetingImpl = new TriggerMeetingImpl();

		triggerMeetingImpl.setMeetingSeqno(meetingSeqno);
		triggerMeetingImpl.setGroupId(groupId);

		if (meetingId == null) {
			triggerMeetingImpl.setMeetingId("");
		}
		else {
			triggerMeetingImpl.setMeetingId(meetingId);
		}

		if (meetingTitle == null) {
			triggerMeetingImpl.setMeetingTitle("");
		}
		else {
			triggerMeetingImpl.setMeetingTitle(meetingTitle);
		}

		if (issuer == null) {
			triggerMeetingImpl.setIssuer("");
		}
		else {
			triggerMeetingImpl.setIssuer(issuer);
		}

		if (meetingType == null) {
			triggerMeetingImpl.setMeetingType("");
		}
		else {
			triggerMeetingImpl.setMeetingType(meetingType);
		}

		if (meetDate == Long.MIN_VALUE) {
			triggerMeetingImpl.setMeetDate(null);
		}
		else {
			triggerMeetingImpl.setMeetDate(new Date(meetDate));
		}

		if (participant == null) {
			triggerMeetingImpl.setParticipant("");
		}
		else {
			triggerMeetingImpl.setParticipant(participant);
		}

		if (meetingPlace == null) {
			triggerMeetingImpl.setMeetingPlace("");
		}
		else {
			triggerMeetingImpl.setMeetingPlace(meetingPlace);
		}

		if (meetingSummary == null) {
			triggerMeetingImpl.setMeetingSummary("");
		}
		else {
			triggerMeetingImpl.setMeetingSummary(meetingSummary);
		}

		if (createdBy == null) {
			triggerMeetingImpl.setCreatedBy("");
		}
		else {
			triggerMeetingImpl.setCreatedBy(createdBy);
		}

		if (createdOn == Long.MIN_VALUE) {
			triggerMeetingImpl.setCreatedOn(null);
		}
		else {
			triggerMeetingImpl.setCreatedOn(new Date(createdOn));
		}

		if (modifiedBy == null) {
			triggerMeetingImpl.setModifiedBy("");
		}
		else {
			triggerMeetingImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedOn == Long.MIN_VALUE) {
			triggerMeetingImpl.setModifiedOn(null);
		}
		else {
			triggerMeetingImpl.setModifiedOn(new Date(modifiedOn));
		}

		triggerMeetingImpl.setIsActive(isActive);

		triggerMeetingImpl.resetOriginalValues();

		return triggerMeetingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		meetingSeqno = objectInput.readLong();

		groupId = objectInput.readLong();
		meetingId = objectInput.readUTF();
		meetingTitle = objectInput.readUTF();
		issuer = objectInput.readUTF();
		meetingType = objectInput.readUTF();
		meetDate = objectInput.readLong();
		participant = objectInput.readUTF();
		meetingPlace = objectInput.readUTF();
		meetingSummary = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		createdOn = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedOn = objectInput.readLong();

		isActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(meetingSeqno);

		objectOutput.writeLong(groupId);

		if (meetingId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(meetingId);
		}

		if (meetingTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(meetingTitle);
		}

		if (issuer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(issuer);
		}

		if (meetingType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(meetingType);
		}

		objectOutput.writeLong(meetDate);

		if (participant == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(participant);
		}

		if (meetingPlace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(meetingPlace);
		}

		if (meetingSummary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(meetingSummary);
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

	public long meetingSeqno;
	public long groupId;
	public String meetingId;
	public String meetingTitle;
	public String issuer;
	public String meetingType;
	public long meetDate;
	public String participant;
	public String meetingPlace;
	public String meetingSummary;
	public String createdBy;
	public long createdOn;
	public String modifiedBy;
	public long modifiedOn;
	public boolean isActive;

}