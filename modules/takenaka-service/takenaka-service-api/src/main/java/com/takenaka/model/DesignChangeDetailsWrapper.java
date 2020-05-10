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
 * This class is a wrapper for {@link DesignChangeDetails}.
 * </p>
 *
 * @author Sanjay.Panchal
 * @see DesignChangeDetails
 * @generated
 */
public class DesignChangeDetailsWrapper
	extends BaseModelWrapper<DesignChangeDetails>
	implements DesignChangeDetails, ModelWrapper<DesignChangeDetails> {

	public DesignChangeDetailsWrapper(DesignChangeDetails designChangeDetails) {
		super(designChangeDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dcrChangeSeqno", getDcrChangeSeqno());
		attributes.put("designchangeSubseqno", getDesignchangeSubseqno());
		attributes.put("groupId", getGroupId());
		attributes.put("revisionNo", getRevisionNo());
		attributes.put("meetingId", getMeetingId());
		attributes.put("issuer", getIssuer());
		attributes.put("changeType", getChangeType());
		attributes.put("changeRequestby", getChangeRequestby());
		attributes.put("rfcId", getRfcId());
		attributes.put("rfcOthers", getRfcOthers());
		attributes.put("rangeOfDisclosure", getRangeOfDisclosure());
		attributes.put("floor", getFloor());
		attributes.put("item", getItem());
		attributes.put("originaldesginDetail", getOriginaldesginDetail());
		attributes.put("changeDetail", getChangeDetail());
		attributes.put("action", getAction());
		attributes.put("estdesignCosttype", getEstdesignCosttype());
		attributes.put("estdesignCost", getEstdesignCost());
		attributes.put("estconstructionCosttype", getEstconstructionCosttype());
		attributes.put("estconstructionCost", getEstconstructionCost());
		attributes.put(
			"expenseAjustmentDivision", getExpenseAjustmentDivision());
		attributes.put("attachmentId1", getAttachmentId1());
		attributes.put("attachmentId2", getAttachmentId2());
		attributes.put("attachmentId3", getAttachmentId3());
		attributes.put("attachmentId4", getAttachmentId4());
		attributes.put("attachment1", getAttachment1());
		attributes.put("attachment2", getAttachment2());
		attributes.put("attachment3", getAttachment3());
		attributes.put("attachment4", getAttachment4());
		attributes.put("responsePeriod", getResponsePeriod());
		attributes.put("personInCharge", getPersonInCharge());
		attributes.put("approvalNo", getApprovalNo());
		attributes.put("approvalStatus", getApprovalStatus());
		attributes.put("approvalDate", getApprovalDate());
		attributes.put("clientApprovalStatus", getClientApprovalStatus());
		attributes.put("clientApprovalDate", getClientApprovalDate());
		attributes.put("constructionStatus", getConstructionStatus());
		attributes.put("constructionDate", getConstructionDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedOn", getModifiedOn());
		attributes.put("isActive", isIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dcrChangeSeqno = (Long)attributes.get("dcrChangeSeqno");

		if (dcrChangeSeqno != null) {
			setDcrChangeSeqno(dcrChangeSeqno);
		}

		Long designchangeSubseqno = (Long)attributes.get(
			"designchangeSubseqno");

		if (designchangeSubseqno != null) {
			setDesignchangeSubseqno(designchangeSubseqno);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer revisionNo = (Integer)attributes.get("revisionNo");

		if (revisionNo != null) {
			setRevisionNo(revisionNo);
		}

		String meetingId = (String)attributes.get("meetingId");

		if (meetingId != null) {
			setMeetingId(meetingId);
		}

		String issuer = (String)attributes.get("issuer");

		if (issuer != null) {
			setIssuer(issuer);
		}

		String changeType = (String)attributes.get("changeType");

		if (changeType != null) {
			setChangeType(changeType);
		}

		String changeRequestby = (String)attributes.get("changeRequestby");

		if (changeRequestby != null) {
			setChangeRequestby(changeRequestby);
		}

		String rfcId = (String)attributes.get("rfcId");

		if (rfcId != null) {
			setRfcId(rfcId);
		}

		String rfcOthers = (String)attributes.get("rfcOthers");

		if (rfcOthers != null) {
			setRfcOthers(rfcOthers);
		}

		String rangeOfDisclosure = (String)attributes.get("rangeOfDisclosure");

		if (rangeOfDisclosure != null) {
			setRangeOfDisclosure(rangeOfDisclosure);
		}

		String floor = (String)attributes.get("floor");

		if (floor != null) {
			setFloor(floor);
		}

		String item = (String)attributes.get("item");

		if (item != null) {
			setItem(item);
		}

		String originaldesginDetail = (String)attributes.get(
			"originaldesginDetail");

		if (originaldesginDetail != null) {
			setOriginaldesginDetail(originaldesginDetail);
		}

		String changeDetail = (String)attributes.get("changeDetail");

		if (changeDetail != null) {
			setChangeDetail(changeDetail);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String estdesignCosttype = (String)attributes.get("estdesignCosttype");

		if (estdesignCosttype != null) {
			setEstdesignCosttype(estdesignCosttype);
		}

		Long estdesignCost = (Long)attributes.get("estdesignCost");

		if (estdesignCost != null) {
			setEstdesignCost(estdesignCost);
		}

		String estconstructionCosttype = (String)attributes.get(
			"estconstructionCosttype");

		if (estconstructionCosttype != null) {
			setEstconstructionCosttype(estconstructionCosttype);
		}

		Long estconstructionCost = (Long)attributes.get("estconstructionCost");

		if (estconstructionCost != null) {
			setEstconstructionCost(estconstructionCost);
		}

		String expenseAjustmentDivision = (String)attributes.get(
			"expenseAjustmentDivision");

		if (expenseAjustmentDivision != null) {
			setExpenseAjustmentDivision(expenseAjustmentDivision);
		}

		Long attachmentId1 = (Long)attributes.get("attachmentId1");

		if (attachmentId1 != null) {
			setAttachmentId1(attachmentId1);
		}

		Long attachmentId2 = (Long)attributes.get("attachmentId2");

		if (attachmentId2 != null) {
			setAttachmentId2(attachmentId2);
		}

		Long attachmentId3 = (Long)attributes.get("attachmentId3");

		if (attachmentId3 != null) {
			setAttachmentId3(attachmentId3);
		}

		Long attachmentId4 = (Long)attributes.get("attachmentId4");

		if (attachmentId4 != null) {
			setAttachmentId4(attachmentId4);
		}

		String attachment1 = (String)attributes.get("attachment1");

		if (attachment1 != null) {
			setAttachment1(attachment1);
		}

		String attachment2 = (String)attributes.get("attachment2");

		if (attachment2 != null) {
			setAttachment2(attachment2);
		}

		String attachment3 = (String)attributes.get("attachment3");

		if (attachment3 != null) {
			setAttachment3(attachment3);
		}

		String attachment4 = (String)attributes.get("attachment4");

		if (attachment4 != null) {
			setAttachment4(attachment4);
		}

		String responsePeriod = (String)attributes.get("responsePeriod");

		if (responsePeriod != null) {
			setResponsePeriod(responsePeriod);
		}

		String personInCharge = (String)attributes.get("personInCharge");

		if (personInCharge != null) {
			setPersonInCharge(personInCharge);
		}

		Long approvalNo = (Long)attributes.get("approvalNo");

		if (approvalNo != null) {
			setApprovalNo(approvalNo);
		}

		String approvalStatus = (String)attributes.get("approvalStatus");

		if (approvalStatus != null) {
			setApprovalStatus(approvalStatus);
		}

		Date approvalDate = (Date)attributes.get("approvalDate");

		if (approvalDate != null) {
			setApprovalDate(approvalDate);
		}

		String clientApprovalStatus = (String)attributes.get(
			"clientApprovalStatus");

		if (clientApprovalStatus != null) {
			setClientApprovalStatus(clientApprovalStatus);
		}

		Date clientApprovalDate = (Date)attributes.get("clientApprovalDate");

		if (clientApprovalDate != null) {
			setClientApprovalDate(clientApprovalDate);
		}

		String constructionStatus = (String)attributes.get(
			"constructionStatus");

		if (constructionStatus != null) {
			setConstructionStatus(constructionStatus);
		}

		Date constructionDate = (Date)attributes.get("constructionDate");

		if (constructionDate != null) {
			setConstructionDate(constructionDate);
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
	 * Returns the action of this design change details.
	 *
	 * @return the action of this design change details
	 */
	@Override
	public String getAction() {
		return model.getAction();
	}

	/**
	 * Returns the approval date of this design change details.
	 *
	 * @return the approval date of this design change details
	 */
	@Override
	public Date getApprovalDate() {
		return model.getApprovalDate();
	}

	/**
	 * Returns the approval no of this design change details.
	 *
	 * @return the approval no of this design change details
	 */
	@Override
	public long getApprovalNo() {
		return model.getApprovalNo();
	}

	/**
	 * Returns the approval status of this design change details.
	 *
	 * @return the approval status of this design change details
	 */
	@Override
	public String getApprovalStatus() {
		return model.getApprovalStatus();
	}

	/**
	 * Returns the attachment1 of this design change details.
	 *
	 * @return the attachment1 of this design change details
	 */
	@Override
	public String getAttachment1() {
		return model.getAttachment1();
	}

	/**
	 * Returns the attachment2 of this design change details.
	 *
	 * @return the attachment2 of this design change details
	 */
	@Override
	public String getAttachment2() {
		return model.getAttachment2();
	}

	/**
	 * Returns the attachment3 of this design change details.
	 *
	 * @return the attachment3 of this design change details
	 */
	@Override
	public String getAttachment3() {
		return model.getAttachment3();
	}

	/**
	 * Returns the attachment4 of this design change details.
	 *
	 * @return the attachment4 of this design change details
	 */
	@Override
	public String getAttachment4() {
		return model.getAttachment4();
	}

	/**
	 * Returns the attachment id1 of this design change details.
	 *
	 * @return the attachment id1 of this design change details
	 */
	@Override
	public long getAttachmentId1() {
		return model.getAttachmentId1();
	}

	/**
	 * Returns the attachment id2 of this design change details.
	 *
	 * @return the attachment id2 of this design change details
	 */
	@Override
	public long getAttachmentId2() {
		return model.getAttachmentId2();
	}

	/**
	 * Returns the attachment id3 of this design change details.
	 *
	 * @return the attachment id3 of this design change details
	 */
	@Override
	public long getAttachmentId3() {
		return model.getAttachmentId3();
	}

	/**
	 * Returns the attachment id4 of this design change details.
	 *
	 * @return the attachment id4 of this design change details
	 */
	@Override
	public long getAttachmentId4() {
		return model.getAttachmentId4();
	}

	/**
	 * Returns the change detail of this design change details.
	 *
	 * @return the change detail of this design change details
	 */
	@Override
	public String getChangeDetail() {
		return model.getChangeDetail();
	}

	/**
	 * Returns the change requestby of this design change details.
	 *
	 * @return the change requestby of this design change details
	 */
	@Override
	public String getChangeRequestby() {
		return model.getChangeRequestby();
	}

	/**
	 * Returns the change type of this design change details.
	 *
	 * @return the change type of this design change details
	 */
	@Override
	public String getChangeType() {
		return model.getChangeType();
	}

	/**
	 * Returns the client approval date of this design change details.
	 *
	 * @return the client approval date of this design change details
	 */
	@Override
	public Date getClientApprovalDate() {
		return model.getClientApprovalDate();
	}

	/**
	 * Returns the client approval status of this design change details.
	 *
	 * @return the client approval status of this design change details
	 */
	@Override
	public String getClientApprovalStatus() {
		return model.getClientApprovalStatus();
	}

	/**
	 * Returns the construction date of this design change details.
	 *
	 * @return the construction date of this design change details
	 */
	@Override
	public Date getConstructionDate() {
		return model.getConstructionDate();
	}

	/**
	 * Returns the construction status of this design change details.
	 *
	 * @return the construction status of this design change details
	 */
	@Override
	public String getConstructionStatus() {
		return model.getConstructionStatus();
	}

	/**
	 * Returns the created by of this design change details.
	 *
	 * @return the created by of this design change details
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created on of this design change details.
	 *
	 * @return the created on of this design change details
	 */
	@Override
	public Date getCreatedOn() {
		return model.getCreatedOn();
	}

	/**
	 * Returns the dcr change seqno of this design change details.
	 *
	 * @return the dcr change seqno of this design change details
	 */
	@Override
	public long getDcrChangeSeqno() {
		return model.getDcrChangeSeqno();
	}

	/**
	 * Returns the designchange subseqno of this design change details.
	 *
	 * @return the designchange subseqno of this design change details
	 */
	@Override
	public long getDesignchangeSubseqno() {
		return model.getDesignchangeSubseqno();
	}

	/**
	 * Returns the estconstruction cost of this design change details.
	 *
	 * @return the estconstruction cost of this design change details
	 */
	@Override
	public long getEstconstructionCost() {
		return model.getEstconstructionCost();
	}

	/**
	 * Returns the estconstruction costtype of this design change details.
	 *
	 * @return the estconstruction costtype of this design change details
	 */
	@Override
	public String getEstconstructionCosttype() {
		return model.getEstconstructionCosttype();
	}

	/**
	 * Returns the estdesign cost of this design change details.
	 *
	 * @return the estdesign cost of this design change details
	 */
	@Override
	public long getEstdesignCost() {
		return model.getEstdesignCost();
	}

	/**
	 * Returns the estdesign costtype of this design change details.
	 *
	 * @return the estdesign costtype of this design change details
	 */
	@Override
	public String getEstdesignCosttype() {
		return model.getEstdesignCosttype();
	}

	/**
	 * Returns the expense ajustment division of this design change details.
	 *
	 * @return the expense ajustment division of this design change details
	 */
	@Override
	public String getExpenseAjustmentDivision() {
		return model.getExpenseAjustmentDivision();
	}

	/**
	 * Returns the floor of this design change details.
	 *
	 * @return the floor of this design change details
	 */
	@Override
	public String getFloor() {
		return model.getFloor();
	}

	/**
	 * Returns the group ID of this design change details.
	 *
	 * @return the group ID of this design change details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this design change details.
	 *
	 * @return the is active of this design change details
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the issuer of this design change details.
	 *
	 * @return the issuer of this design change details
	 */
	@Override
	public String getIssuer() {
		return model.getIssuer();
	}

	/**
	 * Returns the item of this design change details.
	 *
	 * @return the item of this design change details
	 */
	@Override
	public String getItem() {
		return model.getItem();
	}

	/**
	 * Returns the meeting ID of this design change details.
	 *
	 * @return the meeting ID of this design change details
	 */
	@Override
	public String getMeetingId() {
		return model.getMeetingId();
	}

	/**
	 * Returns the modified by of this design change details.
	 *
	 * @return the modified by of this design change details
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified on of this design change details.
	 *
	 * @return the modified on of this design change details
	 */
	@Override
	public Date getModifiedOn() {
		return model.getModifiedOn();
	}

	/**
	 * Returns the originaldesgin detail of this design change details.
	 *
	 * @return the originaldesgin detail of this design change details
	 */
	@Override
	public String getOriginaldesginDetail() {
		return model.getOriginaldesginDetail();
	}

	/**
	 * Returns the person in charge of this design change details.
	 *
	 * @return the person in charge of this design change details
	 */
	@Override
	public String getPersonInCharge() {
		return model.getPersonInCharge();
	}

	/**
	 * Returns the primary key of this design change details.
	 *
	 * @return the primary key of this design change details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the range of disclosure of this design change details.
	 *
	 * @return the range of disclosure of this design change details
	 */
	@Override
	public String getRangeOfDisclosure() {
		return model.getRangeOfDisclosure();
	}

	/**
	 * Returns the response period of this design change details.
	 *
	 * @return the response period of this design change details
	 */
	@Override
	public String getResponsePeriod() {
		return model.getResponsePeriod();
	}

	/**
	 * Returns the revision no of this design change details.
	 *
	 * @return the revision no of this design change details
	 */
	@Override
	public int getRevisionNo() {
		return model.getRevisionNo();
	}

	/**
	 * Returns the rfc ID of this design change details.
	 *
	 * @return the rfc ID of this design change details
	 */
	@Override
	public String getRfcId() {
		return model.getRfcId();
	}

	/**
	 * Returns the rfc others of this design change details.
	 *
	 * @return the rfc others of this design change details
	 */
	@Override
	public String getRfcOthers() {
		return model.getRfcOthers();
	}

	/**
	 * Returns <code>true</code> if this design change details is is active.
	 *
	 * @return <code>true</code> if this design change details is is active; <code>false</code> otherwise
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
	 * Sets the action of this design change details.
	 *
	 * @param action the action of this design change details
	 */
	@Override
	public void setAction(String action) {
		model.setAction(action);
	}

	/**
	 * Sets the approval date of this design change details.
	 *
	 * @param approvalDate the approval date of this design change details
	 */
	@Override
	public void setApprovalDate(Date approvalDate) {
		model.setApprovalDate(approvalDate);
	}

	/**
	 * Sets the approval no of this design change details.
	 *
	 * @param approvalNo the approval no of this design change details
	 */
	@Override
	public void setApprovalNo(long approvalNo) {
		model.setApprovalNo(approvalNo);
	}

	/**
	 * Sets the approval status of this design change details.
	 *
	 * @param approvalStatus the approval status of this design change details
	 */
	@Override
	public void setApprovalStatus(String approvalStatus) {
		model.setApprovalStatus(approvalStatus);
	}

	/**
	 * Sets the attachment1 of this design change details.
	 *
	 * @param attachment1 the attachment1 of this design change details
	 */
	@Override
	public void setAttachment1(String attachment1) {
		model.setAttachment1(attachment1);
	}

	/**
	 * Sets the attachment2 of this design change details.
	 *
	 * @param attachment2 the attachment2 of this design change details
	 */
	@Override
	public void setAttachment2(String attachment2) {
		model.setAttachment2(attachment2);
	}

	/**
	 * Sets the attachment3 of this design change details.
	 *
	 * @param attachment3 the attachment3 of this design change details
	 */
	@Override
	public void setAttachment3(String attachment3) {
		model.setAttachment3(attachment3);
	}

	/**
	 * Sets the attachment4 of this design change details.
	 *
	 * @param attachment4 the attachment4 of this design change details
	 */
	@Override
	public void setAttachment4(String attachment4) {
		model.setAttachment4(attachment4);
	}

	/**
	 * Sets the attachment id1 of this design change details.
	 *
	 * @param attachmentId1 the attachment id1 of this design change details
	 */
	@Override
	public void setAttachmentId1(long attachmentId1) {
		model.setAttachmentId1(attachmentId1);
	}

	/**
	 * Sets the attachment id2 of this design change details.
	 *
	 * @param attachmentId2 the attachment id2 of this design change details
	 */
	@Override
	public void setAttachmentId2(long attachmentId2) {
		model.setAttachmentId2(attachmentId2);
	}

	/**
	 * Sets the attachment id3 of this design change details.
	 *
	 * @param attachmentId3 the attachment id3 of this design change details
	 */
	@Override
	public void setAttachmentId3(long attachmentId3) {
		model.setAttachmentId3(attachmentId3);
	}

	/**
	 * Sets the attachment id4 of this design change details.
	 *
	 * @param attachmentId4 the attachment id4 of this design change details
	 */
	@Override
	public void setAttachmentId4(long attachmentId4) {
		model.setAttachmentId4(attachmentId4);
	}

	/**
	 * Sets the change detail of this design change details.
	 *
	 * @param changeDetail the change detail of this design change details
	 */
	@Override
	public void setChangeDetail(String changeDetail) {
		model.setChangeDetail(changeDetail);
	}

	/**
	 * Sets the change requestby of this design change details.
	 *
	 * @param changeRequestby the change requestby of this design change details
	 */
	@Override
	public void setChangeRequestby(String changeRequestby) {
		model.setChangeRequestby(changeRequestby);
	}

	/**
	 * Sets the change type of this design change details.
	 *
	 * @param changeType the change type of this design change details
	 */
	@Override
	public void setChangeType(String changeType) {
		model.setChangeType(changeType);
	}

	/**
	 * Sets the client approval date of this design change details.
	 *
	 * @param clientApprovalDate the client approval date of this design change details
	 */
	@Override
	public void setClientApprovalDate(Date clientApprovalDate) {
		model.setClientApprovalDate(clientApprovalDate);
	}

	/**
	 * Sets the client approval status of this design change details.
	 *
	 * @param clientApprovalStatus the client approval status of this design change details
	 */
	@Override
	public void setClientApprovalStatus(String clientApprovalStatus) {
		model.setClientApprovalStatus(clientApprovalStatus);
	}

	/**
	 * Sets the construction date of this design change details.
	 *
	 * @param constructionDate the construction date of this design change details
	 */
	@Override
	public void setConstructionDate(Date constructionDate) {
		model.setConstructionDate(constructionDate);
	}

	/**
	 * Sets the construction status of this design change details.
	 *
	 * @param constructionStatus the construction status of this design change details
	 */
	@Override
	public void setConstructionStatus(String constructionStatus) {
		model.setConstructionStatus(constructionStatus);
	}

	/**
	 * Sets the created by of this design change details.
	 *
	 * @param createdBy the created by of this design change details
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created on of this design change details.
	 *
	 * @param createdOn the created on of this design change details
	 */
	@Override
	public void setCreatedOn(Date createdOn) {
		model.setCreatedOn(createdOn);
	}

	/**
	 * Sets the dcr change seqno of this design change details.
	 *
	 * @param dcrChangeSeqno the dcr change seqno of this design change details
	 */
	@Override
	public void setDcrChangeSeqno(long dcrChangeSeqno) {
		model.setDcrChangeSeqno(dcrChangeSeqno);
	}

	/**
	 * Sets the designchange subseqno of this design change details.
	 *
	 * @param designchangeSubseqno the designchange subseqno of this design change details
	 */
	@Override
	public void setDesignchangeSubseqno(long designchangeSubseqno) {
		model.setDesignchangeSubseqno(designchangeSubseqno);
	}

	/**
	 * Sets the estconstruction cost of this design change details.
	 *
	 * @param estconstructionCost the estconstruction cost of this design change details
	 */
	@Override
	public void setEstconstructionCost(long estconstructionCost) {
		model.setEstconstructionCost(estconstructionCost);
	}

	/**
	 * Sets the estconstruction costtype of this design change details.
	 *
	 * @param estconstructionCosttype the estconstruction costtype of this design change details
	 */
	@Override
	public void setEstconstructionCosttype(String estconstructionCosttype) {
		model.setEstconstructionCosttype(estconstructionCosttype);
	}

	/**
	 * Sets the estdesign cost of this design change details.
	 *
	 * @param estdesignCost the estdesign cost of this design change details
	 */
	@Override
	public void setEstdesignCost(long estdesignCost) {
		model.setEstdesignCost(estdesignCost);
	}

	/**
	 * Sets the estdesign costtype of this design change details.
	 *
	 * @param estdesignCosttype the estdesign costtype of this design change details
	 */
	@Override
	public void setEstdesignCosttype(String estdesignCosttype) {
		model.setEstdesignCosttype(estdesignCosttype);
	}

	/**
	 * Sets the expense ajustment division of this design change details.
	 *
	 * @param expenseAjustmentDivision the expense ajustment division of this design change details
	 */
	@Override
	public void setExpenseAjustmentDivision(String expenseAjustmentDivision) {
		model.setExpenseAjustmentDivision(expenseAjustmentDivision);
	}

	/**
	 * Sets the floor of this design change details.
	 *
	 * @param floor the floor of this design change details
	 */
	@Override
	public void setFloor(String floor) {
		model.setFloor(floor);
	}

	/**
	 * Sets the group ID of this design change details.
	 *
	 * @param groupId the group ID of this design change details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this design change details is is active.
	 *
	 * @param isActive the is active of this design change details
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the issuer of this design change details.
	 *
	 * @param issuer the issuer of this design change details
	 */
	@Override
	public void setIssuer(String issuer) {
		model.setIssuer(issuer);
	}

	/**
	 * Sets the item of this design change details.
	 *
	 * @param item the item of this design change details
	 */
	@Override
	public void setItem(String item) {
		model.setItem(item);
	}

	/**
	 * Sets the meeting ID of this design change details.
	 *
	 * @param meetingId the meeting ID of this design change details
	 */
	@Override
	public void setMeetingId(String meetingId) {
		model.setMeetingId(meetingId);
	}

	/**
	 * Sets the modified by of this design change details.
	 *
	 * @param modifiedBy the modified by of this design change details
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified on of this design change details.
	 *
	 * @param modifiedOn the modified on of this design change details
	 */
	@Override
	public void setModifiedOn(Date modifiedOn) {
		model.setModifiedOn(modifiedOn);
	}

	/**
	 * Sets the originaldesgin detail of this design change details.
	 *
	 * @param originaldesginDetail the originaldesgin detail of this design change details
	 */
	@Override
	public void setOriginaldesginDetail(String originaldesginDetail) {
		model.setOriginaldesginDetail(originaldesginDetail);
	}

	/**
	 * Sets the person in charge of this design change details.
	 *
	 * @param personInCharge the person in charge of this design change details
	 */
	@Override
	public void setPersonInCharge(String personInCharge) {
		model.setPersonInCharge(personInCharge);
	}

	/**
	 * Sets the primary key of this design change details.
	 *
	 * @param primaryKey the primary key of this design change details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the range of disclosure of this design change details.
	 *
	 * @param rangeOfDisclosure the range of disclosure of this design change details
	 */
	@Override
	public void setRangeOfDisclosure(String rangeOfDisclosure) {
		model.setRangeOfDisclosure(rangeOfDisclosure);
	}

	/**
	 * Sets the response period of this design change details.
	 *
	 * @param responsePeriod the response period of this design change details
	 */
	@Override
	public void setResponsePeriod(String responsePeriod) {
		model.setResponsePeriod(responsePeriod);
	}

	/**
	 * Sets the revision no of this design change details.
	 *
	 * @param revisionNo the revision no of this design change details
	 */
	@Override
	public void setRevisionNo(int revisionNo) {
		model.setRevisionNo(revisionNo);
	}

	/**
	 * Sets the rfc ID of this design change details.
	 *
	 * @param rfcId the rfc ID of this design change details
	 */
	@Override
	public void setRfcId(String rfcId) {
		model.setRfcId(rfcId);
	}

	/**
	 * Sets the rfc others of this design change details.
	 *
	 * @param rfcOthers the rfc others of this design change details
	 */
	@Override
	public void setRfcOthers(String rfcOthers) {
		model.setRfcOthers(rfcOthers);
	}

	@Override
	protected DesignChangeDetailsWrapper wrap(
		DesignChangeDetails designChangeDetails) {

		return new DesignChangeDetailsWrapper(designChangeDetails);
	}

}