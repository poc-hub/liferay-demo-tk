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

import com.takenaka.model.DesignChangeDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DesignChangeDetails in entity cache.
 *
 * @author Sanjay.Panchal
 * @generated
 */
public class DesignChangeDetailsCacheModel
	implements CacheModel<DesignChangeDetails>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DesignChangeDetailsCacheModel)) {
			return false;
		}

		DesignChangeDetailsCacheModel designChangeDetailsCacheModel =
			(DesignChangeDetailsCacheModel)obj;

		if (dcrChangeSeqno == designChangeDetailsCacheModel.dcrChangeSeqno) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dcrChangeSeqno);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(87);

		sb.append("{dcrChangeSeqno=");
		sb.append(dcrChangeSeqno);
		sb.append(", designchangeSubseqno=");
		sb.append(designchangeSubseqno);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", revisionNo=");
		sb.append(revisionNo);
		sb.append(", meetingId=");
		sb.append(meetingId);
		sb.append(", issuer=");
		sb.append(issuer);
		sb.append(", changeType=");
		sb.append(changeType);
		sb.append(", changeRequestby=");
		sb.append(changeRequestby);
		sb.append(", rfcId=");
		sb.append(rfcId);
		sb.append(", rfcOthers=");
		sb.append(rfcOthers);
		sb.append(", rangeOfDisclosure=");
		sb.append(rangeOfDisclosure);
		sb.append(", floor=");
		sb.append(floor);
		sb.append(", item=");
		sb.append(item);
		sb.append(", originaldesginDetail=");
		sb.append(originaldesginDetail);
		sb.append(", changeDetail=");
		sb.append(changeDetail);
		sb.append(", action=");
		sb.append(action);
		sb.append(", estdesignCosttype=");
		sb.append(estdesignCosttype);
		sb.append(", estdesignCost=");
		sb.append(estdesignCost);
		sb.append(", estconstructionCosttype=");
		sb.append(estconstructionCosttype);
		sb.append(", estconstructionCost=");
		sb.append(estconstructionCost);
		sb.append(", expenseAjustmentDivision=");
		sb.append(expenseAjustmentDivision);
		sb.append(", attachmentId1=");
		sb.append(attachmentId1);
		sb.append(", attachmentId2=");
		sb.append(attachmentId2);
		sb.append(", attachmentId3=");
		sb.append(attachmentId3);
		sb.append(", attachmentId4=");
		sb.append(attachmentId4);
		sb.append(", attachment1=");
		sb.append(attachment1);
		sb.append(", attachment2=");
		sb.append(attachment2);
		sb.append(", attachment3=");
		sb.append(attachment3);
		sb.append(", attachment4=");
		sb.append(attachment4);
		sb.append(", responsePeriod=");
		sb.append(responsePeriod);
		sb.append(", personInCharge=");
		sb.append(personInCharge);
		sb.append(", approvalNo=");
		sb.append(approvalNo);
		sb.append(", approvalStatus=");
		sb.append(approvalStatus);
		sb.append(", approvalDate=");
		sb.append(approvalDate);
		sb.append(", clientApprovalStatus=");
		sb.append(clientApprovalStatus);
		sb.append(", clientApprovalDate=");
		sb.append(clientApprovalDate);
		sb.append(", constructionStatus=");
		sb.append(constructionStatus);
		sb.append(", constructionDate=");
		sb.append(constructionDate);
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
	public DesignChangeDetails toEntityModel() {
		DesignChangeDetailsImpl designChangeDetailsImpl =
			new DesignChangeDetailsImpl();

		designChangeDetailsImpl.setDcrChangeSeqno(dcrChangeSeqno);
		designChangeDetailsImpl.setDesignchangeSubseqno(designchangeSubseqno);
		designChangeDetailsImpl.setGroupId(groupId);
		designChangeDetailsImpl.setRevisionNo(revisionNo);

		if (meetingId == null) {
			designChangeDetailsImpl.setMeetingId("");
		}
		else {
			designChangeDetailsImpl.setMeetingId(meetingId);
		}

		if (issuer == null) {
			designChangeDetailsImpl.setIssuer("");
		}
		else {
			designChangeDetailsImpl.setIssuer(issuer);
		}

		if (changeType == null) {
			designChangeDetailsImpl.setChangeType("");
		}
		else {
			designChangeDetailsImpl.setChangeType(changeType);
		}

		if (changeRequestby == null) {
			designChangeDetailsImpl.setChangeRequestby("");
		}
		else {
			designChangeDetailsImpl.setChangeRequestby(changeRequestby);
		}

		if (rfcId == null) {
			designChangeDetailsImpl.setRfcId("");
		}
		else {
			designChangeDetailsImpl.setRfcId(rfcId);
		}

		if (rfcOthers == null) {
			designChangeDetailsImpl.setRfcOthers("");
		}
		else {
			designChangeDetailsImpl.setRfcOthers(rfcOthers);
		}

		if (rangeOfDisclosure == null) {
			designChangeDetailsImpl.setRangeOfDisclosure("");
		}
		else {
			designChangeDetailsImpl.setRangeOfDisclosure(rangeOfDisclosure);
		}

		if (floor == null) {
			designChangeDetailsImpl.setFloor("");
		}
		else {
			designChangeDetailsImpl.setFloor(floor);
		}

		if (item == null) {
			designChangeDetailsImpl.setItem("");
		}
		else {
			designChangeDetailsImpl.setItem(item);
		}

		if (originaldesginDetail == null) {
			designChangeDetailsImpl.setOriginaldesginDetail("");
		}
		else {
			designChangeDetailsImpl.setOriginaldesginDetail(
				originaldesginDetail);
		}

		if (changeDetail == null) {
			designChangeDetailsImpl.setChangeDetail("");
		}
		else {
			designChangeDetailsImpl.setChangeDetail(changeDetail);
		}

		if (action == null) {
			designChangeDetailsImpl.setAction("");
		}
		else {
			designChangeDetailsImpl.setAction(action);
		}

		if (estdesignCosttype == null) {
			designChangeDetailsImpl.setEstdesignCosttype("");
		}
		else {
			designChangeDetailsImpl.setEstdesignCosttype(estdesignCosttype);
		}

		designChangeDetailsImpl.setEstdesignCost(estdesignCost);

		if (estconstructionCosttype == null) {
			designChangeDetailsImpl.setEstconstructionCosttype("");
		}
		else {
			designChangeDetailsImpl.setEstconstructionCosttype(
				estconstructionCosttype);
		}

		designChangeDetailsImpl.setEstconstructionCost(estconstructionCost);

		if (expenseAjustmentDivision == null) {
			designChangeDetailsImpl.setExpenseAjustmentDivision("");
		}
		else {
			designChangeDetailsImpl.setExpenseAjustmentDivision(
				expenseAjustmentDivision);
		}

		designChangeDetailsImpl.setAttachmentId1(attachmentId1);
		designChangeDetailsImpl.setAttachmentId2(attachmentId2);
		designChangeDetailsImpl.setAttachmentId3(attachmentId3);
		designChangeDetailsImpl.setAttachmentId4(attachmentId4);

		if (attachment1 == null) {
			designChangeDetailsImpl.setAttachment1("");
		}
		else {
			designChangeDetailsImpl.setAttachment1(attachment1);
		}

		if (attachment2 == null) {
			designChangeDetailsImpl.setAttachment2("");
		}
		else {
			designChangeDetailsImpl.setAttachment2(attachment2);
		}

		if (attachment3 == null) {
			designChangeDetailsImpl.setAttachment3("");
		}
		else {
			designChangeDetailsImpl.setAttachment3(attachment3);
		}

		if (attachment4 == null) {
			designChangeDetailsImpl.setAttachment4("");
		}
		else {
			designChangeDetailsImpl.setAttachment4(attachment4);
		}

		if (responsePeriod == null) {
			designChangeDetailsImpl.setResponsePeriod("");
		}
		else {
			designChangeDetailsImpl.setResponsePeriod(responsePeriod);
		}

		if (personInCharge == null) {
			designChangeDetailsImpl.setPersonInCharge("");
		}
		else {
			designChangeDetailsImpl.setPersonInCharge(personInCharge);
		}

		designChangeDetailsImpl.setApprovalNo(approvalNo);

		if (approvalStatus == null) {
			designChangeDetailsImpl.setApprovalStatus("");
		}
		else {
			designChangeDetailsImpl.setApprovalStatus(approvalStatus);
		}

		if (approvalDate == Long.MIN_VALUE) {
			designChangeDetailsImpl.setApprovalDate(null);
		}
		else {
			designChangeDetailsImpl.setApprovalDate(new Date(approvalDate));
		}

		if (clientApprovalStatus == null) {
			designChangeDetailsImpl.setClientApprovalStatus("");
		}
		else {
			designChangeDetailsImpl.setClientApprovalStatus(
				clientApprovalStatus);
		}

		if (clientApprovalDate == Long.MIN_VALUE) {
			designChangeDetailsImpl.setClientApprovalDate(null);
		}
		else {
			designChangeDetailsImpl.setClientApprovalDate(
				new Date(clientApprovalDate));
		}

		if (constructionStatus == null) {
			designChangeDetailsImpl.setConstructionStatus("");
		}
		else {
			designChangeDetailsImpl.setConstructionStatus(constructionStatus);
		}

		if (constructionDate == Long.MIN_VALUE) {
			designChangeDetailsImpl.setConstructionDate(null);
		}
		else {
			designChangeDetailsImpl.setConstructionDate(
				new Date(constructionDate));
		}

		if (createdBy == null) {
			designChangeDetailsImpl.setCreatedBy("");
		}
		else {
			designChangeDetailsImpl.setCreatedBy(createdBy);
		}

		if (createdOn == Long.MIN_VALUE) {
			designChangeDetailsImpl.setCreatedOn(null);
		}
		else {
			designChangeDetailsImpl.setCreatedOn(new Date(createdOn));
		}

		if (modifiedBy == null) {
			designChangeDetailsImpl.setModifiedBy("");
		}
		else {
			designChangeDetailsImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedOn == Long.MIN_VALUE) {
			designChangeDetailsImpl.setModifiedOn(null);
		}
		else {
			designChangeDetailsImpl.setModifiedOn(new Date(modifiedOn));
		}

		designChangeDetailsImpl.setIsActive(isActive);

		designChangeDetailsImpl.resetOriginalValues();

		return designChangeDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dcrChangeSeqno = objectInput.readLong();

		designchangeSubseqno = objectInput.readLong();

		groupId = objectInput.readLong();

		revisionNo = objectInput.readInt();
		meetingId = objectInput.readUTF();
		issuer = objectInput.readUTF();
		changeType = objectInput.readUTF();
		changeRequestby = objectInput.readUTF();
		rfcId = objectInput.readUTF();
		rfcOthers = objectInput.readUTF();
		rangeOfDisclosure = objectInput.readUTF();
		floor = objectInput.readUTF();
		item = objectInput.readUTF();
		originaldesginDetail = objectInput.readUTF();
		changeDetail = objectInput.readUTF();
		action = objectInput.readUTF();
		estdesignCosttype = objectInput.readUTF();

		estdesignCost = objectInput.readLong();
		estconstructionCosttype = objectInput.readUTF();

		estconstructionCost = objectInput.readLong();
		expenseAjustmentDivision = objectInput.readUTF();

		attachmentId1 = objectInput.readLong();

		attachmentId2 = objectInput.readLong();

		attachmentId3 = objectInput.readLong();

		attachmentId4 = objectInput.readLong();
		attachment1 = objectInput.readUTF();
		attachment2 = objectInput.readUTF();
		attachment3 = objectInput.readUTF();
		attachment4 = objectInput.readUTF();
		responsePeriod = objectInput.readUTF();
		personInCharge = objectInput.readUTF();

		approvalNo = objectInput.readLong();
		approvalStatus = objectInput.readUTF();
		approvalDate = objectInput.readLong();
		clientApprovalStatus = objectInput.readUTF();
		clientApprovalDate = objectInput.readLong();
		constructionStatus = objectInput.readUTF();
		constructionDate = objectInput.readLong();
		createdBy = objectInput.readUTF();
		createdOn = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedOn = objectInput.readLong();

		isActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dcrChangeSeqno);

		objectOutput.writeLong(designchangeSubseqno);

		objectOutput.writeLong(groupId);

		objectOutput.writeInt(revisionNo);

		if (meetingId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(meetingId);
		}

		if (issuer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(issuer);
		}

		if (changeType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(changeType);
		}

		if (changeRequestby == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(changeRequestby);
		}

		if (rfcId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rfcId);
		}

		if (rfcOthers == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rfcOthers);
		}

		if (rangeOfDisclosure == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rangeOfDisclosure);
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

		if (originaldesginDetail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(originaldesginDetail);
		}

		if (changeDetail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(changeDetail);
		}

		if (action == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (estdesignCosttype == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(estdesignCosttype);
		}

		objectOutput.writeLong(estdesignCost);

		if (estconstructionCosttype == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(estconstructionCosttype);
		}

		objectOutput.writeLong(estconstructionCost);

		if (expenseAjustmentDivision == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(expenseAjustmentDivision);
		}

		objectOutput.writeLong(attachmentId1);

		objectOutput.writeLong(attachmentId2);

		objectOutput.writeLong(attachmentId3);

		objectOutput.writeLong(attachmentId4);

		if (attachment1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attachment1);
		}

		if (attachment2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attachment2);
		}

		if (attachment3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attachment3);
		}

		if (attachment4 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attachment4);
		}

		if (responsePeriod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(responsePeriod);
		}

		if (personInCharge == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(personInCharge);
		}

		objectOutput.writeLong(approvalNo);

		if (approvalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(approvalStatus);
		}

		objectOutput.writeLong(approvalDate);

		if (clientApprovalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientApprovalStatus);
		}

		objectOutput.writeLong(clientApprovalDate);

		if (constructionStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(constructionStatus);
		}

		objectOutput.writeLong(constructionDate);

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

	public long dcrChangeSeqno;
	public long designchangeSubseqno;
	public long groupId;
	public int revisionNo;
	public String meetingId;
	public String issuer;
	public String changeType;
	public String changeRequestby;
	public String rfcId;
	public String rfcOthers;
	public String rangeOfDisclosure;
	public String floor;
	public String item;
	public String originaldesginDetail;
	public String changeDetail;
	public String action;
	public String estdesignCosttype;
	public long estdesignCost;
	public String estconstructionCosttype;
	public long estconstructionCost;
	public String expenseAjustmentDivision;
	public long attachmentId1;
	public long attachmentId2;
	public long attachmentId3;
	public long attachmentId4;
	public String attachment1;
	public String attachment2;
	public String attachment3;
	public String attachment4;
	public String responsePeriod;
	public String personInCharge;
	public long approvalNo;
	public String approvalStatus;
	public long approvalDate;
	public String clientApprovalStatus;
	public long clientApprovalDate;
	public String constructionStatus;
	public long constructionDate;
	public String createdBy;
	public long createdOn;
	public String modifiedBy;
	public long modifiedOn;
	public boolean isActive;

}