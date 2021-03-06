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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.takenaka.model.TriggerMeetingDetails;
import com.takenaka.model.TriggerMeetingDetailsModel;
import com.takenaka.model.TriggerMeetingDetailsSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the TriggerMeetingDetails service. Represents a row in the &quot;Trigger_Meeting_Details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TriggerMeetingDetailsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TriggerMeetingDetailsImpl}.
 * </p>
 *
 * @author Sanjay.Panchal
 * @see TriggerMeetingDetailsImpl
 * @generated
 */
@JSON(strict = true)
public class TriggerMeetingDetailsModelImpl
	extends BaseModelImpl<TriggerMeetingDetails>
	implements TriggerMeetingDetailsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a trigger meeting details model instance should use the <code>TriggerMeetingDetails</code> interface instead.
	 */
	public static final String TABLE_NAME = "Trigger_Meeting_Details";

	public static final Object[][] TABLE_COLUMNS = {
		{"MEETINGDETAIL_SEQNO", Types.BIGINT}, {"MEETING_SEQNO", Types.BIGINT},
		{"CATEGORY", Types.VARCHAR}, {"FLOOR", Types.VARCHAR},
		{"ITEM", Types.VARCHAR}, {"ACTIONS", Types.VARCHAR},
		{"RESPONSE_DUEDATE", Types.TIMESTAMP},
		{"PERSON_IN_CHARGE", Types.VARCHAR}, {"CREATED_BY", Types.VARCHAR},
		{"CREATED_ON", Types.TIMESTAMP}, {"MODIFIED_BY", Types.VARCHAR},
		{"MODIFIED_ON", Types.TIMESTAMP}, {"IS_ACTIVE", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("MEETINGDETAIL_SEQNO", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("MEETING_SEQNO", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CATEGORY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("FLOOR", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ITEM", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ACTIONS", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("RESPONSE_DUEDATE", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("PERSON_IN_CHARGE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CREATED_BY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CREATED_ON", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("MODIFIED_BY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MODIFIED_ON", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("IS_ACTIVE", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Trigger_Meeting_Details (MEETINGDETAIL_SEQNO LONG not null primary key,MEETING_SEQNO LONG,CATEGORY VARCHAR(75) null,FLOOR VARCHAR(75) null,ITEM VARCHAR(75) null,ACTIONS VARCHAR(75) null,RESPONSE_DUEDATE DATE null,PERSON_IN_CHARGE VARCHAR(75) null,CREATED_BY VARCHAR(75) null,CREATED_ON DATE null,MODIFIED_BY VARCHAR(75) null,MODIFIED_ON DATE null,IS_ACTIVE BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table Trigger_Meeting_Details";

	public static final String ORDER_BY_JPQL =
		" ORDER BY triggerMeetingDetails.meetingdetailSeqno ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Trigger_Meeting_Details.MEETINGDETAIL_SEQNO ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long MEETINGSEQNO_COLUMN_BITMASK = 1L;

	public static final long MEETINGDETAILSEQNO_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TriggerMeetingDetails toModel(
		TriggerMeetingDetailsSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		TriggerMeetingDetails model = new TriggerMeetingDetailsImpl();

		model.setMeetingdetailSeqno(soapModel.getMeetingdetailSeqno());
		model.setMeetingSeqno(soapModel.getMeetingSeqno());
		model.setCategory(soapModel.getCategory());
		model.setFloor(soapModel.getFloor());
		model.setItem(soapModel.getItem());
		model.setActions(soapModel.getActions());
		model.setRESPONSE_DUEDATE(soapModel.getRESPONSE_DUEDATE());
		model.setPersonInCharge(soapModel.getPersonInCharge());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedOn(soapModel.getCreatedOn());
		model.setModifiedBy(soapModel.getModifiedBy());
		model.setModifiedOn(soapModel.getModifiedOn());
		model.setIsActive(soapModel.isIsActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TriggerMeetingDetails> toModels(
		TriggerMeetingDetailsSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<TriggerMeetingDetails> models =
			new ArrayList<TriggerMeetingDetails>(soapModels.length);

		for (TriggerMeetingDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TriggerMeetingDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _meetingdetailSeqno;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMeetingdetailSeqno(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _meetingdetailSeqno;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TriggerMeetingDetails.class;
	}

	@Override
	public String getModelClassName() {
		return TriggerMeetingDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TriggerMeetingDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TriggerMeetingDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TriggerMeetingDetails, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TriggerMeetingDetails)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TriggerMeetingDetails, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TriggerMeetingDetails, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TriggerMeetingDetails)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TriggerMeetingDetails, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TriggerMeetingDetails, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TriggerMeetingDetails>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TriggerMeetingDetails.class.getClassLoader(),
			TriggerMeetingDetails.class, ModelWrapper.class);

		try {
			Constructor<TriggerMeetingDetails> constructor =
				(Constructor<TriggerMeetingDetails>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<TriggerMeetingDetails, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TriggerMeetingDetails, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TriggerMeetingDetails, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<TriggerMeetingDetails, Object>>();
		Map<String, BiConsumer<TriggerMeetingDetails, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<TriggerMeetingDetails, ?>>();

		attributeGetterFunctions.put(
			"meetingdetailSeqno", TriggerMeetingDetails::getMeetingdetailSeqno);
		attributeSetterBiConsumers.put(
			"meetingdetailSeqno",
			(BiConsumer<TriggerMeetingDetails, Long>)
				TriggerMeetingDetails::setMeetingdetailSeqno);
		attributeGetterFunctions.put(
			"meetingSeqno", TriggerMeetingDetails::getMeetingSeqno);
		attributeSetterBiConsumers.put(
			"meetingSeqno",
			(BiConsumer<TriggerMeetingDetails, Long>)
				TriggerMeetingDetails::setMeetingSeqno);
		attributeGetterFunctions.put(
			"category", TriggerMeetingDetails::getCategory);
		attributeSetterBiConsumers.put(
			"category",
			(BiConsumer<TriggerMeetingDetails, String>)
				TriggerMeetingDetails::setCategory);
		attributeGetterFunctions.put("floor", TriggerMeetingDetails::getFloor);
		attributeSetterBiConsumers.put(
			"floor",
			(BiConsumer<TriggerMeetingDetails, String>)
				TriggerMeetingDetails::setFloor);
		attributeGetterFunctions.put("item", TriggerMeetingDetails::getItem);
		attributeSetterBiConsumers.put(
			"item",
			(BiConsumer<TriggerMeetingDetails, String>)
				TriggerMeetingDetails::setItem);
		attributeGetterFunctions.put(
			"actions", TriggerMeetingDetails::getActions);
		attributeSetterBiConsumers.put(
			"actions",
			(BiConsumer<TriggerMeetingDetails, String>)
				TriggerMeetingDetails::setActions);
		attributeGetterFunctions.put(
			"RESPONSE_DUEDATE", TriggerMeetingDetails::getRESPONSE_DUEDATE);
		attributeSetterBiConsumers.put(
			"RESPONSE_DUEDATE",
			(BiConsumer<TriggerMeetingDetails, Date>)
				TriggerMeetingDetails::setRESPONSE_DUEDATE);
		attributeGetterFunctions.put(
			"personInCharge", TriggerMeetingDetails::getPersonInCharge);
		attributeSetterBiConsumers.put(
			"personInCharge",
			(BiConsumer<TriggerMeetingDetails, String>)
				TriggerMeetingDetails::setPersonInCharge);
		attributeGetterFunctions.put(
			"createdBy", TriggerMeetingDetails::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<TriggerMeetingDetails, String>)
				TriggerMeetingDetails::setCreatedBy);
		attributeGetterFunctions.put(
			"createdOn", TriggerMeetingDetails::getCreatedOn);
		attributeSetterBiConsumers.put(
			"createdOn",
			(BiConsumer<TriggerMeetingDetails, Date>)
				TriggerMeetingDetails::setCreatedOn);
		attributeGetterFunctions.put(
			"modifiedBy", TriggerMeetingDetails::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<TriggerMeetingDetails, String>)
				TriggerMeetingDetails::setModifiedBy);
		attributeGetterFunctions.put(
			"modifiedOn", TriggerMeetingDetails::getModifiedOn);
		attributeSetterBiConsumers.put(
			"modifiedOn",
			(BiConsumer<TriggerMeetingDetails, Date>)
				TriggerMeetingDetails::setModifiedOn);
		attributeGetterFunctions.put(
			"isActive", TriggerMeetingDetails::getIsActive);
		attributeSetterBiConsumers.put(
			"isActive",
			(BiConsumer<TriggerMeetingDetails, Boolean>)
				TriggerMeetingDetails::setIsActive);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMeetingdetailSeqno() {
		return _meetingdetailSeqno;
	}

	@Override
	public void setMeetingdetailSeqno(long meetingdetailSeqno) {
		_meetingdetailSeqno = meetingdetailSeqno;
	}

	@JSON
	@Override
	public long getMeetingSeqno() {
		return _meetingSeqno;
	}

	@Override
	public void setMeetingSeqno(long meetingSeqno) {
		_columnBitmask |= MEETINGSEQNO_COLUMN_BITMASK;

		if (!_setOriginalMeetingSeqno) {
			_setOriginalMeetingSeqno = true;

			_originalMeetingSeqno = _meetingSeqno;
		}

		_meetingSeqno = meetingSeqno;
	}

	public long getOriginalMeetingSeqno() {
		return _originalMeetingSeqno;
	}

	@JSON
	@Override
	public String getCategory() {
		if (_category == null) {
			return "";
		}
		else {
			return _category;
		}
	}

	@Override
	public void setCategory(String category) {
		_category = category;
	}

	@JSON
	@Override
	public String getFloor() {
		if (_floor == null) {
			return "";
		}
		else {
			return _floor;
		}
	}

	@Override
	public void setFloor(String floor) {
		_floor = floor;
	}

	@JSON
	@Override
	public String getItem() {
		if (_item == null) {
			return "";
		}
		else {
			return _item;
		}
	}

	@Override
	public void setItem(String item) {
		_item = item;
	}

	@JSON
	@Override
	public String getActions() {
		if (_actions == null) {
			return "";
		}
		else {
			return _actions;
		}
	}

	@Override
	public void setActions(String actions) {
		_actions = actions;
	}

	@JSON
	@Override
	public Date getRESPONSE_DUEDATE() {
		return _RESPONSE_DUEDATE;
	}

	@Override
	public void setRESPONSE_DUEDATE(Date RESPONSE_DUEDATE) {
		_RESPONSE_DUEDATE = RESPONSE_DUEDATE;
	}

	@JSON
	@Override
	public String getPersonInCharge() {
		if (_personInCharge == null) {
			return "";
		}
		else {
			return _personInCharge;
		}
	}

	@Override
	public void setPersonInCharge(String personInCharge) {
		_personInCharge = personInCharge;
	}

	@JSON
	@Override
	public String getCreatedBy() {
		if (_createdBy == null) {
			return "";
		}
		else {
			return _createdBy;
		}
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	@JSON
	@Override
	public Date getCreatedOn() {
		return _createdOn;
	}

	@Override
	public void setCreatedOn(Date createdOn) {
		_createdOn = createdOn;
	}

	@JSON
	@Override
	public String getModifiedBy() {
		if (_modifiedBy == null) {
			return "";
		}
		else {
			return _modifiedBy;
		}
	}

	@Override
	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	@JSON
	@Override
	public Date getModifiedOn() {
		return _modifiedOn;
	}

	@Override
	public void setModifiedOn(Date modifiedOn) {
		_modifiedOn = modifiedOn;
	}

	@JSON
	@Override
	public boolean getIsActive() {
		return _isActive;
	}

	@JSON
	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, TriggerMeetingDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TriggerMeetingDetails toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TriggerMeetingDetails>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TriggerMeetingDetailsImpl triggerMeetingDetailsImpl =
			new TriggerMeetingDetailsImpl();

		triggerMeetingDetailsImpl.setMeetingdetailSeqno(
			getMeetingdetailSeqno());
		triggerMeetingDetailsImpl.setMeetingSeqno(getMeetingSeqno());
		triggerMeetingDetailsImpl.setCategory(getCategory());
		triggerMeetingDetailsImpl.setFloor(getFloor());
		triggerMeetingDetailsImpl.setItem(getItem());
		triggerMeetingDetailsImpl.setActions(getActions());
		triggerMeetingDetailsImpl.setRESPONSE_DUEDATE(getRESPONSE_DUEDATE());
		triggerMeetingDetailsImpl.setPersonInCharge(getPersonInCharge());
		triggerMeetingDetailsImpl.setCreatedBy(getCreatedBy());
		triggerMeetingDetailsImpl.setCreatedOn(getCreatedOn());
		triggerMeetingDetailsImpl.setModifiedBy(getModifiedBy());
		triggerMeetingDetailsImpl.setModifiedOn(getModifiedOn());
		triggerMeetingDetailsImpl.setIsActive(isIsActive());

		triggerMeetingDetailsImpl.resetOriginalValues();

		return triggerMeetingDetailsImpl;
	}

	@Override
	public int compareTo(TriggerMeetingDetails triggerMeetingDetails) {
		long primaryKey = triggerMeetingDetails.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TriggerMeetingDetails)) {
			return false;
		}

		TriggerMeetingDetails triggerMeetingDetails =
			(TriggerMeetingDetails)obj;

		long primaryKey = triggerMeetingDetails.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		TriggerMeetingDetailsModelImpl triggerMeetingDetailsModelImpl = this;

		triggerMeetingDetailsModelImpl._originalMeetingSeqno =
			triggerMeetingDetailsModelImpl._meetingSeqno;

		triggerMeetingDetailsModelImpl._setOriginalMeetingSeqno = false;

		triggerMeetingDetailsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TriggerMeetingDetails> toCacheModel() {
		TriggerMeetingDetailsCacheModel triggerMeetingDetailsCacheModel =
			new TriggerMeetingDetailsCacheModel();

		triggerMeetingDetailsCacheModel.meetingdetailSeqno =
			getMeetingdetailSeqno();

		triggerMeetingDetailsCacheModel.meetingSeqno = getMeetingSeqno();

		triggerMeetingDetailsCacheModel.category = getCategory();

		String category = triggerMeetingDetailsCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			triggerMeetingDetailsCacheModel.category = null;
		}

		triggerMeetingDetailsCacheModel.floor = getFloor();

		String floor = triggerMeetingDetailsCacheModel.floor;

		if ((floor != null) && (floor.length() == 0)) {
			triggerMeetingDetailsCacheModel.floor = null;
		}

		triggerMeetingDetailsCacheModel.item = getItem();

		String item = triggerMeetingDetailsCacheModel.item;

		if ((item != null) && (item.length() == 0)) {
			triggerMeetingDetailsCacheModel.item = null;
		}

		triggerMeetingDetailsCacheModel.actions = getActions();

		String actions = triggerMeetingDetailsCacheModel.actions;

		if ((actions != null) && (actions.length() == 0)) {
			triggerMeetingDetailsCacheModel.actions = null;
		}

		Date RESPONSE_DUEDATE = getRESPONSE_DUEDATE();

		if (RESPONSE_DUEDATE != null) {
			triggerMeetingDetailsCacheModel.RESPONSE_DUEDATE =
				RESPONSE_DUEDATE.getTime();
		}
		else {
			triggerMeetingDetailsCacheModel.RESPONSE_DUEDATE = Long.MIN_VALUE;
		}

		triggerMeetingDetailsCacheModel.personInCharge = getPersonInCharge();

		String personInCharge = triggerMeetingDetailsCacheModel.personInCharge;

		if ((personInCharge != null) && (personInCharge.length() == 0)) {
			triggerMeetingDetailsCacheModel.personInCharge = null;
		}

		triggerMeetingDetailsCacheModel.createdBy = getCreatedBy();

		String createdBy = triggerMeetingDetailsCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			triggerMeetingDetailsCacheModel.createdBy = null;
		}

		Date createdOn = getCreatedOn();

		if (createdOn != null) {
			triggerMeetingDetailsCacheModel.createdOn = createdOn.getTime();
		}
		else {
			triggerMeetingDetailsCacheModel.createdOn = Long.MIN_VALUE;
		}

		triggerMeetingDetailsCacheModel.modifiedBy = getModifiedBy();

		String modifiedBy = triggerMeetingDetailsCacheModel.modifiedBy;

		if ((modifiedBy != null) && (modifiedBy.length() == 0)) {
			triggerMeetingDetailsCacheModel.modifiedBy = null;
		}

		Date modifiedOn = getModifiedOn();

		if (modifiedOn != null) {
			triggerMeetingDetailsCacheModel.modifiedOn = modifiedOn.getTime();
		}
		else {
			triggerMeetingDetailsCacheModel.modifiedOn = Long.MIN_VALUE;
		}

		triggerMeetingDetailsCacheModel.isActive = isIsActive();

		return triggerMeetingDetailsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TriggerMeetingDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TriggerMeetingDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TriggerMeetingDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((TriggerMeetingDetails)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<TriggerMeetingDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TriggerMeetingDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TriggerMeetingDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((TriggerMeetingDetails)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TriggerMeetingDetails>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _meetingdetailSeqno;
	private long _meetingSeqno;
	private long _originalMeetingSeqno;
	private boolean _setOriginalMeetingSeqno;
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
	private long _columnBitmask;
	private TriggerMeetingDetails _escapedModel;

}