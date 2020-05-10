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
 * This class is used by SOAP remote services, specifically {@link com.takenaka.service.http.DesignChangeDetailsServiceSoap}.
 *
 * @author Sanjay.Panchal
 * @generated
 */
public class DesignChangeDetailsSoap implements Serializable {

	public static DesignChangeDetailsSoap toSoapModel(
		DesignChangeDetails model) {

		DesignChangeDetailsSoap soapModel = new DesignChangeDetailsSoap();

		soapModel.setDcrChangeSeqno(model.getDcrChangeSeqno());
		soapModel.setDesignchangeSubseqno(model.getDesignchangeSubseqno());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setRevisionNo(model.getRevisionNo());
		soapModel.setMeetingId(model.getMeetingId());
		soapModel.setIssuer(model.getIssuer());
		soapModel.setChangeType(model.getChangeType());
		soapModel.setChangeRequestby(model.getChangeRequestby());
		soapModel.setRfcId(model.getRfcId());
		soapModel.setRfcOthers(model.getRfcOthers());
		soapModel.setRangeOfDisclosure(model.getRangeOfDisclosure());
		soapModel.setFloor(model.getFloor());
		soapModel.setItem(model.getItem());
		soapModel.setOriginaldesginDetail(model.getOriginaldesginDetail());
		soapModel.setChangeDetail(model.getChangeDetail());
		soapModel.setAction(model.getAction());
		soapModel.setEstdesignCosttype(model.getEstdesignCosttype());
		soapModel.setEstdesignCost(model.getEstdesignCost());
		soapModel.setEstconstructionCosttype(
			model.getEstconstructionCosttype());
		soapModel.setEstconstructionCost(model.getEstconstructionCost());
		soapModel.setExpenseAjustmentDivision(
			model.getExpenseAjustmentDivision());
		soapModel.setAttachmentId1(model.getAttachmentId1());
		soapModel.setAttachmentId2(model.getAttachmentId2());
		soapModel.setAttachmentId3(model.getAttachmentId3());
		soapModel.setAttachmentId4(model.getAttachmentId4());
		soapModel.setAttachment1(model.getAttachment1());
		soapModel.setAttachment2(model.getAttachment2());
		soapModel.setAttachment3(model.getAttachment3());
		soapModel.setAttachment4(model.getAttachment4());
		soapModel.setResponsePeriod(model.getResponsePeriod());
		soapModel.setPersonInCharge(model.getPersonInCharge());
		soapModel.setApprovalNo(model.getApprovalNo());
		soapModel.setApprovalStatus(model.getApprovalStatus());
		soapModel.setApprovalDate(model.getApprovalDate());
		soapModel.setClientApprovalStatus(model.getClientApprovalStatus());
		soapModel.setClientApprovalDate(model.getClientApprovalDate());
		soapModel.setConstructionStatus(model.getConstructionStatus());
		soapModel.setConstructionDate(model.getConstructionDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedOn(model.getCreatedOn());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedOn(model.getModifiedOn());
		soapModel.setIsActive(model.isIsActive());

		return soapModel;
	}

	public static DesignChangeDetailsSoap[] toSoapModels(
		DesignChangeDetails[] models) {

		DesignChangeDetailsSoap[] soapModels =
			new DesignChangeDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DesignChangeDetailsSoap[][] toSoapModels(
		DesignChangeDetails[][] models) {

		DesignChangeDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DesignChangeDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DesignChangeDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DesignChangeDetailsSoap[] toSoapModels(
		List<DesignChangeDetails> models) {

		List<DesignChangeDetailsSoap> soapModels =
			new ArrayList<DesignChangeDetailsSoap>(models.size());

		for (DesignChangeDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DesignChangeDetailsSoap[soapModels.size()]);
	}

	public DesignChangeDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _dcrChangeSeqno;
	}

	public void setPrimaryKey(long pk) {
		setDcrChangeSeqno(pk);
	}

	public long getDcrChangeSeqno() {
		return _dcrChangeSeqno;
	}

	public void setDcrChangeSeqno(long dcrChangeSeqno) {
		_dcrChangeSeqno = dcrChangeSeqno;
	}

	public long getDesignchangeSubseqno() {
		return _designchangeSubseqno;
	}

	public void setDesignchangeSubseqno(long designchangeSubseqno) {
		_designchangeSubseqno = designchangeSubseqno;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getRevisionNo() {
		return _revisionNo;
	}

	public void setRevisionNo(int revisionNo) {
		_revisionNo = revisionNo;
	}

	public String getMeetingId() {
		return _meetingId;
	}

	public void setMeetingId(String meetingId) {
		_meetingId = meetingId;
	}

	public String getIssuer() {
		return _issuer;
	}

	public void setIssuer(String issuer) {
		_issuer = issuer;
	}

	public String getChangeType() {
		return _changeType;
	}

	public void setChangeType(String changeType) {
		_changeType = changeType;
	}

	public String getChangeRequestby() {
		return _changeRequestby;
	}

	public void setChangeRequestby(String changeRequestby) {
		_changeRequestby = changeRequestby;
	}

	public String getRfcId() {
		return _rfcId;
	}

	public void setRfcId(String rfcId) {
		_rfcId = rfcId;
	}

	public String getRfcOthers() {
		return _rfcOthers;
	}

	public void setRfcOthers(String rfcOthers) {
		_rfcOthers = rfcOthers;
	}

	public String getRangeOfDisclosure() {
		return _rangeOfDisclosure;
	}

	public void setRangeOfDisclosure(String rangeOfDisclosure) {
		_rangeOfDisclosure = rangeOfDisclosure;
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

	public String getOriginaldesginDetail() {
		return _originaldesginDetail;
	}

	public void setOriginaldesginDetail(String originaldesginDetail) {
		_originaldesginDetail = originaldesginDetail;
	}

	public String getChangeDetail() {
		return _changeDetail;
	}

	public void setChangeDetail(String changeDetail) {
		_changeDetail = changeDetail;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getEstdesignCosttype() {
		return _estdesignCosttype;
	}

	public void setEstdesignCosttype(String estdesignCosttype) {
		_estdesignCosttype = estdesignCosttype;
	}

	public long getEstdesignCost() {
		return _estdesignCost;
	}

	public void setEstdesignCost(long estdesignCost) {
		_estdesignCost = estdesignCost;
	}

	public String getEstconstructionCosttype() {
		return _estconstructionCosttype;
	}

	public void setEstconstructionCosttype(String estconstructionCosttype) {
		_estconstructionCosttype = estconstructionCosttype;
	}

	public long getEstconstructionCost() {
		return _estconstructionCost;
	}

	public void setEstconstructionCost(long estconstructionCost) {
		_estconstructionCost = estconstructionCost;
	}

	public String getExpenseAjustmentDivision() {
		return _expenseAjustmentDivision;
	}

	public void setExpenseAjustmentDivision(String expenseAjustmentDivision) {
		_expenseAjustmentDivision = expenseAjustmentDivision;
	}

	public long getAttachmentId1() {
		return _attachmentId1;
	}

	public void setAttachmentId1(long attachmentId1) {
		_attachmentId1 = attachmentId1;
	}

	public long getAttachmentId2() {
		return _attachmentId2;
	}

	public void setAttachmentId2(long attachmentId2) {
		_attachmentId2 = attachmentId2;
	}

	public long getAttachmentId3() {
		return _attachmentId3;
	}

	public void setAttachmentId3(long attachmentId3) {
		_attachmentId3 = attachmentId3;
	}

	public long getAttachmentId4() {
		return _attachmentId4;
	}

	public void setAttachmentId4(long attachmentId4) {
		_attachmentId4 = attachmentId4;
	}

	public String getAttachment1() {
		return _attachment1;
	}

	public void setAttachment1(String attachment1) {
		_attachment1 = attachment1;
	}

	public String getAttachment2() {
		return _attachment2;
	}

	public void setAttachment2(String attachment2) {
		_attachment2 = attachment2;
	}

	public String getAttachment3() {
		return _attachment3;
	}

	public void setAttachment3(String attachment3) {
		_attachment3 = attachment3;
	}

	public String getAttachment4() {
		return _attachment4;
	}

	public void setAttachment4(String attachment4) {
		_attachment4 = attachment4;
	}

	public String getResponsePeriod() {
		return _responsePeriod;
	}

	public void setResponsePeriod(String responsePeriod) {
		_responsePeriod = responsePeriod;
	}

	public String getPersonInCharge() {
		return _personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		_personInCharge = personInCharge;
	}

	public long getApprovalNo() {
		return _approvalNo;
	}

	public void setApprovalNo(long approvalNo) {
		_approvalNo = approvalNo;
	}

	public String getApprovalStatus() {
		return _approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		_approvalStatus = approvalStatus;
	}

	public Date getApprovalDate() {
		return _approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		_approvalDate = approvalDate;
	}

	public String getClientApprovalStatus() {
		return _clientApprovalStatus;
	}

	public void setClientApprovalStatus(String clientApprovalStatus) {
		_clientApprovalStatus = clientApprovalStatus;
	}

	public Date getClientApprovalDate() {
		return _clientApprovalDate;
	}

	public void setClientApprovalDate(Date clientApprovalDate) {
		_clientApprovalDate = clientApprovalDate;
	}

	public String getConstructionStatus() {
		return _constructionStatus;
	}

	public void setConstructionStatus(String constructionStatus) {
		_constructionStatus = constructionStatus;
	}

	public Date getConstructionDate() {
		return _constructionDate;
	}

	public void setConstructionDate(Date constructionDate) {
		_constructionDate = constructionDate;
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

	private long _dcrChangeSeqno;
	private long _designchangeSubseqno;
	private long _groupId;
	private int _revisionNo;
	private String _meetingId;
	private String _issuer;
	private String _changeType;
	private String _changeRequestby;
	private String _rfcId;
	private String _rfcOthers;
	private String _rangeOfDisclosure;
	private String _floor;
	private String _item;
	private String _originaldesginDetail;
	private String _changeDetail;
	private String _action;
	private String _estdesignCosttype;
	private long _estdesignCost;
	private String _estconstructionCosttype;
	private long _estconstructionCost;
	private String _expenseAjustmentDivision;
	private long _attachmentId1;
	private long _attachmentId2;
	private long _attachmentId3;
	private long _attachmentId4;
	private String _attachment1;
	private String _attachment2;
	private String _attachment3;
	private String _attachment4;
	private String _responsePeriod;
	private String _personInCharge;
	private long _approvalNo;
	private String _approvalStatus;
	private Date _approvalDate;
	private String _clientApprovalStatus;
	private Date _clientApprovalDate;
	private String _constructionStatus;
	private Date _constructionDate;
	private String _createdBy;
	private Date _createdOn;
	private String _modifiedBy;
	private Date _modifiedOn;
	private boolean _isActive;

}