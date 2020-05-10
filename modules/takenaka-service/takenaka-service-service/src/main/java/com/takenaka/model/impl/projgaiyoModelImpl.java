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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.takenaka.model.projgaiyo;
import com.takenaka.model.projgaiyoModel;
import com.takenaka.model.projgaiyoSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the projgaiyo service. Represents a row in the &quot;PROJGAIYO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>projgaiyoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link projgaiyoImpl}.
 * </p>
 *
 * @author Sanjay.Panchal
 * @see projgaiyoImpl
 * @generated
 */
@JSON(strict = true)
public class projgaiyoModelImpl
	extends BaseModelImpl<projgaiyo> implements projgaiyoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a projgaiyo model instance should use the <code>projgaiyo</code> interface instead.
	 */
	public static final String TABLE_NAME = "PROJGAIYO";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"GROUP_ID", Types.BIGINT},
		{"PROJ_NM", Types.VARCHAR}, {"PROJ_NM_KANA", Types.VARCHAR},
		{"KENCHIKU_NUSI_CD", Types.VARCHAR},
		{"KENCHIKU_NUSI_NM", Types.VARCHAR}, {"KENCHIKU_CHI_CD", Types.VARCHAR},
		{"KENCHIKU_CHI_NM", Types.VARCHAR}, {"TATEMONO_YOTO1", Types.VARCHAR},
		{"TATEMONO_YOTO2", Types.VARCHAR}, {"TATEMONO_YOTO3", Types.VARCHAR},
		{"KAISU_B", Types.DOUBLE}, {"KAISU_F", Types.DOUBLE},
		{"KAISU_P", Types.DOUBLE}, {"KOZO_SHUBETU1", Types.VARCHAR},
		{"KOZO_SHUBETU2", Types.VARCHAR}, {"KOZO_SHUBETU3", Types.VARCHAR},
		{"NOBEYUKA_MENSEKI", Types.DOUBLE}, {"KENCHIKU_MENSEKI", Types.DOUBLE},
		{"CHAKKO_BI", Types.VARCHAR}, {"SHUNKO_BI", Types.VARCHAR},
		{"SEKKEI_KB", Types.VARCHAR}, {"SEKO_KB", Types.VARCHAR},
		{"SAGYOSHO_CHIKU", Types.VARCHAR}, {"UPD_DATE", Types.VARCHAR},
		{"UPD_TIME", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("GROUP_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("PROJ_NM", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PROJ_NM_KANA", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("KENCHIKU_NUSI_CD", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("KENCHIKU_NUSI_NM", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("KENCHIKU_CHI_CD", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("KENCHIKU_CHI_NM", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("TATEMONO_YOTO1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("TATEMONO_YOTO2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("TATEMONO_YOTO3", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("KAISU_B", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("KAISU_F", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("KAISU_P", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("KOZO_SHUBETU1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("KOZO_SHUBETU2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("KOZO_SHUBETU3", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("NOBEYUKA_MENSEKI", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("KENCHIKU_MENSEKI", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("CHAKKO_BI", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("SHUNKO_BI", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("SEKKEI_KB", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("SEKO_KB", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("SAGYOSHO_CHIKU", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("UPD_DATE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("UPD_TIME", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PROJGAIYO (uuid_ VARCHAR(75) null,GROUP_ID LONG not null primary key,PROJ_NM VARCHAR(75) null,PROJ_NM_KANA VARCHAR(75) null,KENCHIKU_NUSI_CD VARCHAR(75) null,KENCHIKU_NUSI_NM VARCHAR(75) null,KENCHIKU_CHI_CD VARCHAR(75) null,KENCHIKU_CHI_NM VARCHAR(75) null,TATEMONO_YOTO1 VARCHAR(75) null,TATEMONO_YOTO2 VARCHAR(75) null,TATEMONO_YOTO3 VARCHAR(75) null,KAISU_B DOUBLE,KAISU_F DOUBLE,KAISU_P DOUBLE,KOZO_SHUBETU1 VARCHAR(75) null,KOZO_SHUBETU2 VARCHAR(75) null,KOZO_SHUBETU3 VARCHAR(75) null,NOBEYUKA_MENSEKI DOUBLE,KENCHIKU_MENSEKI DOUBLE,CHAKKO_BI VARCHAR(75) null,SHUNKO_BI VARCHAR(75) null,SEKKEI_KB VARCHAR(75) null,SEKO_KB VARCHAR(75) null,SAGYOSHO_CHIKU VARCHAR(75) null,UPD_DATE VARCHAR(75) null,UPD_TIME VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table PROJGAIYO";

	public static final String ORDER_BY_JPQL =
		" ORDER BY projgaiyo.groupId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY PROJGAIYO.GROUP_ID ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long GROUPID_COLUMN_BITMASK = 1L;

	public static final long UUID_COLUMN_BITMASK = 2L;

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
	public static projgaiyo toModel(projgaiyoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		projgaiyo model = new projgaiyoImpl();

		model.setUuid(soapModel.getUuid());
		model.setGroupId(soapModel.getGroupId());
		model.setProjNm(soapModel.getProjNm());
		model.setProjNmKana(soapModel.getProjNmKana());
		model.setKenchikuNusiCd(soapModel.getKenchikuNusiCd());
		model.setKenchikuNusiNm(soapModel.getKenchikuNusiNm());
		model.setKenchikuChiCd(soapModel.getKenchikuChiCd());
		model.setKenchikuChiNm(soapModel.getKenchikuChiNm());
		model.setTatemonoYoto1(soapModel.getTatemonoYoto1());
		model.setTatemonoYoto2(soapModel.getTatemonoYoto2());
		model.setTatemonoYoto3(soapModel.getTatemonoYoto3());
		model.setKaisuB(soapModel.getKaisuB());
		model.setKaisuF(soapModel.getKaisuF());
		model.setKaisuP(soapModel.getKaisuP());
		model.setKozoShubetu1(soapModel.getKozoShubetu1());
		model.setKozoShubetu2(soapModel.getKozoShubetu2());
		model.setKozoShubetu3(soapModel.getKozoShubetu3());
		model.setNobeyukaMenseki(soapModel.getNobeyukaMenseki());
		model.setKenchikuMenseki(soapModel.getKenchikuMenseki());
		model.setChakkoBi(soapModel.getChakkoBi());
		model.setShunkoBi(soapModel.getShunkoBi());
		model.setSekkeiKb(soapModel.getSekkeiKb());
		model.setSekoKb(soapModel.getSekoKb());
		model.setSagyoshoChiku(soapModel.getSagyoshoChiku());
		model.setUpdDate(soapModel.getUpdDate());
		model.setUpdTime(soapModel.getUpdTime());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<projgaiyo> toModels(projgaiyoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<projgaiyo> models = new ArrayList<projgaiyo>(soapModels.length);

		for (projgaiyoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public projgaiyoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _groupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return projgaiyo.class;
	}

	@Override
	public String getModelClassName() {
		return projgaiyo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<projgaiyo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<projgaiyo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<projgaiyo, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((projgaiyo)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<projgaiyo, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<projgaiyo, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(projgaiyo)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<projgaiyo, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<projgaiyo, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, projgaiyo>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			projgaiyo.class.getClassLoader(), projgaiyo.class,
			ModelWrapper.class);

		try {
			Constructor<projgaiyo> constructor =
				(Constructor<projgaiyo>)proxyClass.getConstructor(
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

	private static final Map<String, Function<projgaiyo, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<projgaiyo, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<projgaiyo, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<projgaiyo, Object>>();
		Map<String, BiConsumer<projgaiyo, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<projgaiyo, ?>>();

		attributeGetterFunctions.put("uuid", projgaiyo::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<projgaiyo, String>)projgaiyo::setUuid);
		attributeGetterFunctions.put("groupId", projgaiyo::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<projgaiyo, Long>)projgaiyo::setGroupId);
		attributeGetterFunctions.put("projNm", projgaiyo::getProjNm);
		attributeSetterBiConsumers.put(
			"projNm", (BiConsumer<projgaiyo, String>)projgaiyo::setProjNm);
		attributeGetterFunctions.put("projNmKana", projgaiyo::getProjNmKana);
		attributeSetterBiConsumers.put(
			"projNmKana",
			(BiConsumer<projgaiyo, String>)projgaiyo::setProjNmKana);
		attributeGetterFunctions.put(
			"kenchikuNusiCd", projgaiyo::getKenchikuNusiCd);
		attributeSetterBiConsumers.put(
			"kenchikuNusiCd",
			(BiConsumer<projgaiyo, String>)projgaiyo::setKenchikuNusiCd);
		attributeGetterFunctions.put(
			"kenchikuNusiNm", projgaiyo::getKenchikuNusiNm);
		attributeSetterBiConsumers.put(
			"kenchikuNusiNm",
			(BiConsumer<projgaiyo, String>)projgaiyo::setKenchikuNusiNm);
		attributeGetterFunctions.put(
			"kenchikuChiCd", projgaiyo::getKenchikuChiCd);
		attributeSetterBiConsumers.put(
			"kenchikuChiCd",
			(BiConsumer<projgaiyo, String>)projgaiyo::setKenchikuChiCd);
		attributeGetterFunctions.put(
			"kenchikuChiNm", projgaiyo::getKenchikuChiNm);
		attributeSetterBiConsumers.put(
			"kenchikuChiNm",
			(BiConsumer<projgaiyo, String>)projgaiyo::setKenchikuChiNm);
		attributeGetterFunctions.put(
			"tatemonoYoto1", projgaiyo::getTatemonoYoto1);
		attributeSetterBiConsumers.put(
			"tatemonoYoto1",
			(BiConsumer<projgaiyo, String>)projgaiyo::setTatemonoYoto1);
		attributeGetterFunctions.put(
			"tatemonoYoto2", projgaiyo::getTatemonoYoto2);
		attributeSetterBiConsumers.put(
			"tatemonoYoto2",
			(BiConsumer<projgaiyo, String>)projgaiyo::setTatemonoYoto2);
		attributeGetterFunctions.put(
			"tatemonoYoto3", projgaiyo::getTatemonoYoto3);
		attributeSetterBiConsumers.put(
			"tatemonoYoto3",
			(BiConsumer<projgaiyo, String>)projgaiyo::setTatemonoYoto3);
		attributeGetterFunctions.put("kaisuB", projgaiyo::getKaisuB);
		attributeSetterBiConsumers.put(
			"kaisuB", (BiConsumer<projgaiyo, Double>)projgaiyo::setKaisuB);
		attributeGetterFunctions.put("kaisuF", projgaiyo::getKaisuF);
		attributeSetterBiConsumers.put(
			"kaisuF", (BiConsumer<projgaiyo, Double>)projgaiyo::setKaisuF);
		attributeGetterFunctions.put("kaisuP", projgaiyo::getKaisuP);
		attributeSetterBiConsumers.put(
			"kaisuP", (BiConsumer<projgaiyo, Double>)projgaiyo::setKaisuP);
		attributeGetterFunctions.put(
			"kozoShubetu1", projgaiyo::getKozoShubetu1);
		attributeSetterBiConsumers.put(
			"kozoShubetu1",
			(BiConsumer<projgaiyo, String>)projgaiyo::setKozoShubetu1);
		attributeGetterFunctions.put(
			"kozoShubetu2", projgaiyo::getKozoShubetu2);
		attributeSetterBiConsumers.put(
			"kozoShubetu2",
			(BiConsumer<projgaiyo, String>)projgaiyo::setKozoShubetu2);
		attributeGetterFunctions.put(
			"kozoShubetu3", projgaiyo::getKozoShubetu3);
		attributeSetterBiConsumers.put(
			"kozoShubetu3",
			(BiConsumer<projgaiyo, String>)projgaiyo::setKozoShubetu3);
		attributeGetterFunctions.put(
			"nobeyukaMenseki", projgaiyo::getNobeyukaMenseki);
		attributeSetterBiConsumers.put(
			"nobeyukaMenseki",
			(BiConsumer<projgaiyo, Double>)projgaiyo::setNobeyukaMenseki);
		attributeGetterFunctions.put(
			"kenchikuMenseki", projgaiyo::getKenchikuMenseki);
		attributeSetterBiConsumers.put(
			"kenchikuMenseki",
			(BiConsumer<projgaiyo, Double>)projgaiyo::setKenchikuMenseki);
		attributeGetterFunctions.put("chakkoBi", projgaiyo::getChakkoBi);
		attributeSetterBiConsumers.put(
			"chakkoBi", (BiConsumer<projgaiyo, String>)projgaiyo::setChakkoBi);
		attributeGetterFunctions.put("shunkoBi", projgaiyo::getShunkoBi);
		attributeSetterBiConsumers.put(
			"shunkoBi", (BiConsumer<projgaiyo, String>)projgaiyo::setShunkoBi);
		attributeGetterFunctions.put("sekkeiKb", projgaiyo::getSekkeiKb);
		attributeSetterBiConsumers.put(
			"sekkeiKb", (BiConsumer<projgaiyo, String>)projgaiyo::setSekkeiKb);
		attributeGetterFunctions.put("sekoKb", projgaiyo::getSekoKb);
		attributeSetterBiConsumers.put(
			"sekoKb", (BiConsumer<projgaiyo, String>)projgaiyo::setSekoKb);
		attributeGetterFunctions.put(
			"sagyoshoChiku", projgaiyo::getSagyoshoChiku);
		attributeSetterBiConsumers.put(
			"sagyoshoChiku",
			(BiConsumer<projgaiyo, String>)projgaiyo::setSagyoshoChiku);
		attributeGetterFunctions.put("updDate", projgaiyo::getUpdDate);
		attributeSetterBiConsumers.put(
			"updDate", (BiConsumer<projgaiyo, String>)projgaiyo::setUpdDate);
		attributeGetterFunctions.put("updTime", projgaiyo::getUpdTime);
		attributeSetterBiConsumers.put(
			"updTime", (BiConsumer<projgaiyo, String>)projgaiyo::setUpdTime);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public String getProjNm() {
		if (_projNm == null) {
			return "";
		}
		else {
			return _projNm;
		}
	}

	@Override
	public void setProjNm(String projNm) {
		_projNm = projNm;
	}

	@JSON
	@Override
	public String getProjNmKana() {
		if (_projNmKana == null) {
			return "";
		}
		else {
			return _projNmKana;
		}
	}

	@Override
	public void setProjNmKana(String projNmKana) {
		_projNmKana = projNmKana;
	}

	@JSON
	@Override
	public String getKenchikuNusiCd() {
		if (_kenchikuNusiCd == null) {
			return "";
		}
		else {
			return _kenchikuNusiCd;
		}
	}

	@Override
	public void setKenchikuNusiCd(String kenchikuNusiCd) {
		_kenchikuNusiCd = kenchikuNusiCd;
	}

	@JSON
	@Override
	public String getKenchikuNusiNm() {
		if (_kenchikuNusiNm == null) {
			return "";
		}
		else {
			return _kenchikuNusiNm;
		}
	}

	@Override
	public void setKenchikuNusiNm(String kenchikuNusiNm) {
		_kenchikuNusiNm = kenchikuNusiNm;
	}

	@JSON
	@Override
	public String getKenchikuChiCd() {
		if (_kenchikuChiCd == null) {
			return "";
		}
		else {
			return _kenchikuChiCd;
		}
	}

	@Override
	public void setKenchikuChiCd(String kenchikuChiCd) {
		_kenchikuChiCd = kenchikuChiCd;
	}

	@JSON
	@Override
	public String getKenchikuChiNm() {
		if (_kenchikuChiNm == null) {
			return "";
		}
		else {
			return _kenchikuChiNm;
		}
	}

	@Override
	public void setKenchikuChiNm(String kenchikuChiNm) {
		_kenchikuChiNm = kenchikuChiNm;
	}

	@JSON
	@Override
	public String getTatemonoYoto1() {
		if (_tatemonoYoto1 == null) {
			return "";
		}
		else {
			return _tatemonoYoto1;
		}
	}

	@Override
	public void setTatemonoYoto1(String tatemonoYoto1) {
		_tatemonoYoto1 = tatemonoYoto1;
	}

	@JSON
	@Override
	public String getTatemonoYoto2() {
		if (_tatemonoYoto2 == null) {
			return "";
		}
		else {
			return _tatemonoYoto2;
		}
	}

	@Override
	public void setTatemonoYoto2(String tatemonoYoto2) {
		_tatemonoYoto2 = tatemonoYoto2;
	}

	@JSON
	@Override
	public String getTatemonoYoto3() {
		if (_tatemonoYoto3 == null) {
			return "";
		}
		else {
			return _tatemonoYoto3;
		}
	}

	@Override
	public void setTatemonoYoto3(String tatemonoYoto3) {
		_tatemonoYoto3 = tatemonoYoto3;
	}

	@JSON
	@Override
	public Double getKaisuB() {
		return _kaisuB;
	}

	@Override
	public void setKaisuB(Double kaisuB) {
		_kaisuB = kaisuB;
	}

	@JSON
	@Override
	public Double getKaisuF() {
		return _kaisuF;
	}

	@Override
	public void setKaisuF(Double kaisuF) {
		_kaisuF = kaisuF;
	}

	@JSON
	@Override
	public Double getKaisuP() {
		return _kaisuP;
	}

	@Override
	public void setKaisuP(Double kaisuP) {
		_kaisuP = kaisuP;
	}

	@JSON
	@Override
	public String getKozoShubetu1() {
		if (_kozoShubetu1 == null) {
			return "";
		}
		else {
			return _kozoShubetu1;
		}
	}

	@Override
	public void setKozoShubetu1(String kozoShubetu1) {
		_kozoShubetu1 = kozoShubetu1;
	}

	@JSON
	@Override
	public String getKozoShubetu2() {
		if (_kozoShubetu2 == null) {
			return "";
		}
		else {
			return _kozoShubetu2;
		}
	}

	@Override
	public void setKozoShubetu2(String kozoShubetu2) {
		_kozoShubetu2 = kozoShubetu2;
	}

	@JSON
	@Override
	public String getKozoShubetu3() {
		if (_kozoShubetu3 == null) {
			return "";
		}
		else {
			return _kozoShubetu3;
		}
	}

	@Override
	public void setKozoShubetu3(String kozoShubetu3) {
		_kozoShubetu3 = kozoShubetu3;
	}

	@JSON
	@Override
	public Double getNobeyukaMenseki() {
		return _nobeyukaMenseki;
	}

	@Override
	public void setNobeyukaMenseki(Double nobeyukaMenseki) {
		_nobeyukaMenseki = nobeyukaMenseki;
	}

	@JSON
	@Override
	public Double getKenchikuMenseki() {
		return _kenchikuMenseki;
	}

	@Override
	public void setKenchikuMenseki(Double kenchikuMenseki) {
		_kenchikuMenseki = kenchikuMenseki;
	}

	@JSON
	@Override
	public String getChakkoBi() {
		if (_chakkoBi == null) {
			return "";
		}
		else {
			return _chakkoBi;
		}
	}

	@Override
	public void setChakkoBi(String chakkoBi) {
		_chakkoBi = chakkoBi;
	}

	@JSON
	@Override
	public String getShunkoBi() {
		if (_shunkoBi == null) {
			return "";
		}
		else {
			return _shunkoBi;
		}
	}

	@Override
	public void setShunkoBi(String shunkoBi) {
		_shunkoBi = shunkoBi;
	}

	@JSON
	@Override
	public String getSekkeiKb() {
		if (_sekkeiKb == null) {
			return "";
		}
		else {
			return _sekkeiKb;
		}
	}

	@Override
	public void setSekkeiKb(String sekkeiKb) {
		_sekkeiKb = sekkeiKb;
	}

	@JSON
	@Override
	public String getSekoKb() {
		if (_sekoKb == null) {
			return "";
		}
		else {
			return _sekoKb;
		}
	}

	@Override
	public void setSekoKb(String sekoKb) {
		_sekoKb = sekoKb;
	}

	@JSON
	@Override
	public String getSagyoshoChiku() {
		if (_sagyoshoChiku == null) {
			return "";
		}
		else {
			return _sagyoshoChiku;
		}
	}

	@Override
	public void setSagyoshoChiku(String sagyoshoChiku) {
		_sagyoshoChiku = sagyoshoChiku;
	}

	@JSON
	@Override
	public String getUpdDate() {
		if (_updDate == null) {
			return "";
		}
		else {
			return _updDate;
		}
	}

	@Override
	public void setUpdDate(String updDate) {
		_updDate = updDate;
	}

	@JSON
	@Override
	public String getUpdTime() {
		if (_updTime == null) {
			return "";
		}
		else {
			return _updTime;
		}
	}

	@Override
	public void setUpdTime(String updTime) {
		_updTime = updTime;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, projgaiyo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public projgaiyo toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, projgaiyo>
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
		projgaiyoImpl projgaiyoImpl = new projgaiyoImpl();

		projgaiyoImpl.setUuid(getUuid());
		projgaiyoImpl.setGroupId(getGroupId());
		projgaiyoImpl.setProjNm(getProjNm());
		projgaiyoImpl.setProjNmKana(getProjNmKana());
		projgaiyoImpl.setKenchikuNusiCd(getKenchikuNusiCd());
		projgaiyoImpl.setKenchikuNusiNm(getKenchikuNusiNm());
		projgaiyoImpl.setKenchikuChiCd(getKenchikuChiCd());
		projgaiyoImpl.setKenchikuChiNm(getKenchikuChiNm());
		projgaiyoImpl.setTatemonoYoto1(getTatemonoYoto1());
		projgaiyoImpl.setTatemonoYoto2(getTatemonoYoto2());
		projgaiyoImpl.setTatemonoYoto3(getTatemonoYoto3());
		projgaiyoImpl.setKaisuB(getKaisuB());
		projgaiyoImpl.setKaisuF(getKaisuF());
		projgaiyoImpl.setKaisuP(getKaisuP());
		projgaiyoImpl.setKozoShubetu1(getKozoShubetu1());
		projgaiyoImpl.setKozoShubetu2(getKozoShubetu2());
		projgaiyoImpl.setKozoShubetu3(getKozoShubetu3());
		projgaiyoImpl.setNobeyukaMenseki(getNobeyukaMenseki());
		projgaiyoImpl.setKenchikuMenseki(getKenchikuMenseki());
		projgaiyoImpl.setChakkoBi(getChakkoBi());
		projgaiyoImpl.setShunkoBi(getShunkoBi());
		projgaiyoImpl.setSekkeiKb(getSekkeiKb());
		projgaiyoImpl.setSekoKb(getSekoKb());
		projgaiyoImpl.setSagyoshoChiku(getSagyoshoChiku());
		projgaiyoImpl.setUpdDate(getUpdDate());
		projgaiyoImpl.setUpdTime(getUpdTime());

		projgaiyoImpl.resetOriginalValues();

		return projgaiyoImpl;
	}

	@Override
	public int compareTo(projgaiyo projgaiyo) {
		long primaryKey = projgaiyo.getPrimaryKey();

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

		if (!(obj instanceof projgaiyo)) {
			return false;
		}

		projgaiyo projgaiyo = (projgaiyo)obj;

		long primaryKey = projgaiyo.getPrimaryKey();

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
		projgaiyoModelImpl projgaiyoModelImpl = this;

		projgaiyoModelImpl._originalUuid = projgaiyoModelImpl._uuid;

		projgaiyoModelImpl._originalGroupId = projgaiyoModelImpl._groupId;

		projgaiyoModelImpl._setOriginalGroupId = false;

		projgaiyoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<projgaiyo> toCacheModel() {
		projgaiyoCacheModel projgaiyoCacheModel = new projgaiyoCacheModel();

		projgaiyoCacheModel.uuid = getUuid();

		String uuid = projgaiyoCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			projgaiyoCacheModel.uuid = null;
		}

		projgaiyoCacheModel.groupId = getGroupId();

		projgaiyoCacheModel.projNm = getProjNm();

		String projNm = projgaiyoCacheModel.projNm;

		if ((projNm != null) && (projNm.length() == 0)) {
			projgaiyoCacheModel.projNm = null;
		}

		projgaiyoCacheModel.projNmKana = getProjNmKana();

		String projNmKana = projgaiyoCacheModel.projNmKana;

		if ((projNmKana != null) && (projNmKana.length() == 0)) {
			projgaiyoCacheModel.projNmKana = null;
		}

		projgaiyoCacheModel.kenchikuNusiCd = getKenchikuNusiCd();

		String kenchikuNusiCd = projgaiyoCacheModel.kenchikuNusiCd;

		if ((kenchikuNusiCd != null) && (kenchikuNusiCd.length() == 0)) {
			projgaiyoCacheModel.kenchikuNusiCd = null;
		}

		projgaiyoCacheModel.kenchikuNusiNm = getKenchikuNusiNm();

		String kenchikuNusiNm = projgaiyoCacheModel.kenchikuNusiNm;

		if ((kenchikuNusiNm != null) && (kenchikuNusiNm.length() == 0)) {
			projgaiyoCacheModel.kenchikuNusiNm = null;
		}

		projgaiyoCacheModel.kenchikuChiCd = getKenchikuChiCd();

		String kenchikuChiCd = projgaiyoCacheModel.kenchikuChiCd;

		if ((kenchikuChiCd != null) && (kenchikuChiCd.length() == 0)) {
			projgaiyoCacheModel.kenchikuChiCd = null;
		}

		projgaiyoCacheModel.kenchikuChiNm = getKenchikuChiNm();

		String kenchikuChiNm = projgaiyoCacheModel.kenchikuChiNm;

		if ((kenchikuChiNm != null) && (kenchikuChiNm.length() == 0)) {
			projgaiyoCacheModel.kenchikuChiNm = null;
		}

		projgaiyoCacheModel.tatemonoYoto1 = getTatemonoYoto1();

		String tatemonoYoto1 = projgaiyoCacheModel.tatemonoYoto1;

		if ((tatemonoYoto1 != null) && (tatemonoYoto1.length() == 0)) {
			projgaiyoCacheModel.tatemonoYoto1 = null;
		}

		projgaiyoCacheModel.tatemonoYoto2 = getTatemonoYoto2();

		String tatemonoYoto2 = projgaiyoCacheModel.tatemonoYoto2;

		if ((tatemonoYoto2 != null) && (tatemonoYoto2.length() == 0)) {
			projgaiyoCacheModel.tatemonoYoto2 = null;
		}

		projgaiyoCacheModel.tatemonoYoto3 = getTatemonoYoto3();

		String tatemonoYoto3 = projgaiyoCacheModel.tatemonoYoto3;

		if ((tatemonoYoto3 != null) && (tatemonoYoto3.length() == 0)) {
			projgaiyoCacheModel.tatemonoYoto3 = null;
		}

		projgaiyoCacheModel.kaisuB = getKaisuB();

		projgaiyoCacheModel.kaisuF = getKaisuF();

		projgaiyoCacheModel.kaisuP = getKaisuP();

		projgaiyoCacheModel.kozoShubetu1 = getKozoShubetu1();

		String kozoShubetu1 = projgaiyoCacheModel.kozoShubetu1;

		if ((kozoShubetu1 != null) && (kozoShubetu1.length() == 0)) {
			projgaiyoCacheModel.kozoShubetu1 = null;
		}

		projgaiyoCacheModel.kozoShubetu2 = getKozoShubetu2();

		String kozoShubetu2 = projgaiyoCacheModel.kozoShubetu2;

		if ((kozoShubetu2 != null) && (kozoShubetu2.length() == 0)) {
			projgaiyoCacheModel.kozoShubetu2 = null;
		}

		projgaiyoCacheModel.kozoShubetu3 = getKozoShubetu3();

		String kozoShubetu3 = projgaiyoCacheModel.kozoShubetu3;

		if ((kozoShubetu3 != null) && (kozoShubetu3.length() == 0)) {
			projgaiyoCacheModel.kozoShubetu3 = null;
		}

		projgaiyoCacheModel.nobeyukaMenseki = getNobeyukaMenseki();

		projgaiyoCacheModel.kenchikuMenseki = getKenchikuMenseki();

		projgaiyoCacheModel.chakkoBi = getChakkoBi();

		String chakkoBi = projgaiyoCacheModel.chakkoBi;

		if ((chakkoBi != null) && (chakkoBi.length() == 0)) {
			projgaiyoCacheModel.chakkoBi = null;
		}

		projgaiyoCacheModel.shunkoBi = getShunkoBi();

		String shunkoBi = projgaiyoCacheModel.shunkoBi;

		if ((shunkoBi != null) && (shunkoBi.length() == 0)) {
			projgaiyoCacheModel.shunkoBi = null;
		}

		projgaiyoCacheModel.sekkeiKb = getSekkeiKb();

		String sekkeiKb = projgaiyoCacheModel.sekkeiKb;

		if ((sekkeiKb != null) && (sekkeiKb.length() == 0)) {
			projgaiyoCacheModel.sekkeiKb = null;
		}

		projgaiyoCacheModel.sekoKb = getSekoKb();

		String sekoKb = projgaiyoCacheModel.sekoKb;

		if ((sekoKb != null) && (sekoKb.length() == 0)) {
			projgaiyoCacheModel.sekoKb = null;
		}

		projgaiyoCacheModel.sagyoshoChiku = getSagyoshoChiku();

		String sagyoshoChiku = projgaiyoCacheModel.sagyoshoChiku;

		if ((sagyoshoChiku != null) && (sagyoshoChiku.length() == 0)) {
			projgaiyoCacheModel.sagyoshoChiku = null;
		}

		projgaiyoCacheModel.updDate = getUpdDate();

		String updDate = projgaiyoCacheModel.updDate;

		if ((updDate != null) && (updDate.length() == 0)) {
			projgaiyoCacheModel.updDate = null;
		}

		projgaiyoCacheModel.updTime = getUpdTime();

		String updTime = projgaiyoCacheModel.updTime;

		if ((updTime != null) && (updTime.length() == 0)) {
			projgaiyoCacheModel.updTime = null;
		}

		return projgaiyoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<projgaiyo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<projgaiyo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<projgaiyo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((projgaiyo)this));
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
		Map<String, Function<projgaiyo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<projgaiyo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<projgaiyo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((projgaiyo)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, projgaiyo>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _projNm;
	private String _projNmKana;
	private String _kenchikuNusiCd;
	private String _kenchikuNusiNm;
	private String _kenchikuChiCd;
	private String _kenchikuChiNm;
	private String _tatemonoYoto1;
	private String _tatemonoYoto2;
	private String _tatemonoYoto3;
	private Double _kaisuB;
	private Double _kaisuF;
	private Double _kaisuP;
	private String _kozoShubetu1;
	private String _kozoShubetu2;
	private String _kozoShubetu3;
	private Double _nobeyukaMenseki;
	private Double _kenchikuMenseki;
	private String _chakkoBi;
	private String _shunkoBi;
	private String _sekkeiKb;
	private String _sekoKb;
	private String _sagyoshoChiku;
	private String _updDate;
	private String _updTime;
	private long _columnBitmask;
	private projgaiyo _escapedModel;

}