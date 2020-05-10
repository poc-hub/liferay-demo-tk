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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link projgaiyo}.
 * </p>
 *
 * @author Sanjay.Panchal
 * @see projgaiyo
 * @generated
 */
public class projgaiyoWrapper
	extends BaseModelWrapper<projgaiyo>
	implements ModelWrapper<projgaiyo>, projgaiyo {

	public projgaiyoWrapper(projgaiyo projgaiyo) {
		super(projgaiyo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("groupId", getGroupId());
		attributes.put("projNm", getProjNm());
		attributes.put("projNmKana", getProjNmKana());
		attributes.put("kenchikuNusiCd", getKenchikuNusiCd());
		attributes.put("kenchikuNusiNm", getKenchikuNusiNm());
		attributes.put("kenchikuChiCd", getKenchikuChiCd());
		attributes.put("kenchikuChiNm", getKenchikuChiNm());
		attributes.put("tatemonoYoto1", getTatemonoYoto1());
		attributes.put("tatemonoYoto2", getTatemonoYoto2());
		attributes.put("tatemonoYoto3", getTatemonoYoto3());
		attributes.put("kaisuB", getKaisuB());
		attributes.put("kaisuF", getKaisuF());
		attributes.put("kaisuP", getKaisuP());
		attributes.put("kozoShubetu1", getKozoShubetu1());
		attributes.put("kozoShubetu2", getKozoShubetu2());
		attributes.put("kozoShubetu3", getKozoShubetu3());
		attributes.put("nobeyukaMenseki", getNobeyukaMenseki());
		attributes.put("kenchikuMenseki", getKenchikuMenseki());
		attributes.put("chakkoBi", getChakkoBi());
		attributes.put("shunkoBi", getShunkoBi());
		attributes.put("sekkeiKb", getSekkeiKb());
		attributes.put("sekoKb", getSekoKb());
		attributes.put("sagyoshoChiku", getSagyoshoChiku());
		attributes.put("updDate", getUpdDate());
		attributes.put("updTime", getUpdTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String projNm = (String)attributes.get("projNm");

		if (projNm != null) {
			setProjNm(projNm);
		}

		String projNmKana = (String)attributes.get("projNmKana");

		if (projNmKana != null) {
			setProjNmKana(projNmKana);
		}

		String kenchikuNusiCd = (String)attributes.get("kenchikuNusiCd");

		if (kenchikuNusiCd != null) {
			setKenchikuNusiCd(kenchikuNusiCd);
		}

		String kenchikuNusiNm = (String)attributes.get("kenchikuNusiNm");

		if (kenchikuNusiNm != null) {
			setKenchikuNusiNm(kenchikuNusiNm);
		}

		String kenchikuChiCd = (String)attributes.get("kenchikuChiCd");

		if (kenchikuChiCd != null) {
			setKenchikuChiCd(kenchikuChiCd);
		}

		String kenchikuChiNm = (String)attributes.get("kenchikuChiNm");

		if (kenchikuChiNm != null) {
			setKenchikuChiNm(kenchikuChiNm);
		}

		String tatemonoYoto1 = (String)attributes.get("tatemonoYoto1");

		if (tatemonoYoto1 != null) {
			setTatemonoYoto1(tatemonoYoto1);
		}

		String tatemonoYoto2 = (String)attributes.get("tatemonoYoto2");

		if (tatemonoYoto2 != null) {
			setTatemonoYoto2(tatemonoYoto2);
		}

		String tatemonoYoto3 = (String)attributes.get("tatemonoYoto3");

		if (tatemonoYoto3 != null) {
			setTatemonoYoto3(tatemonoYoto3);
		}

		Double kaisuB = (Double)attributes.get("kaisuB");

		if (kaisuB != null) {
			setKaisuB(kaisuB);
		}

		Double kaisuF = (Double)attributes.get("kaisuF");

		if (kaisuF != null) {
			setKaisuF(kaisuF);
		}

		Double kaisuP = (Double)attributes.get("kaisuP");

		if (kaisuP != null) {
			setKaisuP(kaisuP);
		}

		String kozoShubetu1 = (String)attributes.get("kozoShubetu1");

		if (kozoShubetu1 != null) {
			setKozoShubetu1(kozoShubetu1);
		}

		String kozoShubetu2 = (String)attributes.get("kozoShubetu2");

		if (kozoShubetu2 != null) {
			setKozoShubetu2(kozoShubetu2);
		}

		String kozoShubetu3 = (String)attributes.get("kozoShubetu3");

		if (kozoShubetu3 != null) {
			setKozoShubetu3(kozoShubetu3);
		}

		Double nobeyukaMenseki = (Double)attributes.get("nobeyukaMenseki");

		if (nobeyukaMenseki != null) {
			setNobeyukaMenseki(nobeyukaMenseki);
		}

		Double kenchikuMenseki = (Double)attributes.get("kenchikuMenseki");

		if (kenchikuMenseki != null) {
			setKenchikuMenseki(kenchikuMenseki);
		}

		String chakkoBi = (String)attributes.get("chakkoBi");

		if (chakkoBi != null) {
			setChakkoBi(chakkoBi);
		}

		String shunkoBi = (String)attributes.get("shunkoBi");

		if (shunkoBi != null) {
			setShunkoBi(shunkoBi);
		}

		String sekkeiKb = (String)attributes.get("sekkeiKb");

		if (sekkeiKb != null) {
			setSekkeiKb(sekkeiKb);
		}

		String sekoKb = (String)attributes.get("sekoKb");

		if (sekoKb != null) {
			setSekoKb(sekoKb);
		}

		String sagyoshoChiku = (String)attributes.get("sagyoshoChiku");

		if (sagyoshoChiku != null) {
			setSagyoshoChiku(sagyoshoChiku);
		}

		String updDate = (String)attributes.get("updDate");

		if (updDate != null) {
			setUpdDate(updDate);
		}

		String updTime = (String)attributes.get("updTime");

		if (updTime != null) {
			setUpdTime(updTime);
		}
	}

	/**
	 * Returns the chakko bi of this projgaiyo.
	 *
	 * @return the chakko bi of this projgaiyo
	 */
	@Override
	public String getChakkoBi() {
		return model.getChakkoBi();
	}

	/**
	 * Returns the group ID of this projgaiyo.
	 *
	 * @return the group ID of this projgaiyo
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the kaisu b of this projgaiyo.
	 *
	 * @return the kaisu b of this projgaiyo
	 */
	@Override
	public Double getKaisuB() {
		return model.getKaisuB();
	}

	/**
	 * Returns the kaisu f of this projgaiyo.
	 *
	 * @return the kaisu f of this projgaiyo
	 */
	@Override
	public Double getKaisuF() {
		return model.getKaisuF();
	}

	/**
	 * Returns the kaisu p of this projgaiyo.
	 *
	 * @return the kaisu p of this projgaiyo
	 */
	@Override
	public Double getKaisuP() {
		return model.getKaisuP();
	}

	/**
	 * Returns the kenchiku chi cd of this projgaiyo.
	 *
	 * @return the kenchiku chi cd of this projgaiyo
	 */
	@Override
	public String getKenchikuChiCd() {
		return model.getKenchikuChiCd();
	}

	/**
	 * Returns the kenchiku chi nm of this projgaiyo.
	 *
	 * @return the kenchiku chi nm of this projgaiyo
	 */
	@Override
	public String getKenchikuChiNm() {
		return model.getKenchikuChiNm();
	}

	/**
	 * Returns the kenchiku menseki of this projgaiyo.
	 *
	 * @return the kenchiku menseki of this projgaiyo
	 */
	@Override
	public Double getKenchikuMenseki() {
		return model.getKenchikuMenseki();
	}

	/**
	 * Returns the kenchiku nusi cd of this projgaiyo.
	 *
	 * @return the kenchiku nusi cd of this projgaiyo
	 */
	@Override
	public String getKenchikuNusiCd() {
		return model.getKenchikuNusiCd();
	}

	/**
	 * Returns the kenchiku nusi nm of this projgaiyo.
	 *
	 * @return the kenchiku nusi nm of this projgaiyo
	 */
	@Override
	public String getKenchikuNusiNm() {
		return model.getKenchikuNusiNm();
	}

	/**
	 * Returns the kozo shubetu1 of this projgaiyo.
	 *
	 * @return the kozo shubetu1 of this projgaiyo
	 */
	@Override
	public String getKozoShubetu1() {
		return model.getKozoShubetu1();
	}

	/**
	 * Returns the kozo shubetu2 of this projgaiyo.
	 *
	 * @return the kozo shubetu2 of this projgaiyo
	 */
	@Override
	public String getKozoShubetu2() {
		return model.getKozoShubetu2();
	}

	/**
	 * Returns the kozo shubetu3 of this projgaiyo.
	 *
	 * @return the kozo shubetu3 of this projgaiyo
	 */
	@Override
	public String getKozoShubetu3() {
		return model.getKozoShubetu3();
	}

	/**
	 * Returns the nobeyuka menseki of this projgaiyo.
	 *
	 * @return the nobeyuka menseki of this projgaiyo
	 */
	@Override
	public Double getNobeyukaMenseki() {
		return model.getNobeyukaMenseki();
	}

	/**
	 * Returns the primary key of this projgaiyo.
	 *
	 * @return the primary key of this projgaiyo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the proj nm of this projgaiyo.
	 *
	 * @return the proj nm of this projgaiyo
	 */
	@Override
	public String getProjNm() {
		return model.getProjNm();
	}

	/**
	 * Returns the proj nm kana of this projgaiyo.
	 *
	 * @return the proj nm kana of this projgaiyo
	 */
	@Override
	public String getProjNmKana() {
		return model.getProjNmKana();
	}

	/**
	 * Returns the sagyosho chiku of this projgaiyo.
	 *
	 * @return the sagyosho chiku of this projgaiyo
	 */
	@Override
	public String getSagyoshoChiku() {
		return model.getSagyoshoChiku();
	}

	/**
	 * Returns the sekkei kb of this projgaiyo.
	 *
	 * @return the sekkei kb of this projgaiyo
	 */
	@Override
	public String getSekkeiKb() {
		return model.getSekkeiKb();
	}

	/**
	 * Returns the seko kb of this projgaiyo.
	 *
	 * @return the seko kb of this projgaiyo
	 */
	@Override
	public String getSekoKb() {
		return model.getSekoKb();
	}

	/**
	 * Returns the shunko bi of this projgaiyo.
	 *
	 * @return the shunko bi of this projgaiyo
	 */
	@Override
	public String getShunkoBi() {
		return model.getShunkoBi();
	}

	/**
	 * Returns the tatemono yoto1 of this projgaiyo.
	 *
	 * @return the tatemono yoto1 of this projgaiyo
	 */
	@Override
	public String getTatemonoYoto1() {
		return model.getTatemonoYoto1();
	}

	/**
	 * Returns the tatemono yoto2 of this projgaiyo.
	 *
	 * @return the tatemono yoto2 of this projgaiyo
	 */
	@Override
	public String getTatemonoYoto2() {
		return model.getTatemonoYoto2();
	}

	/**
	 * Returns the tatemono yoto3 of this projgaiyo.
	 *
	 * @return the tatemono yoto3 of this projgaiyo
	 */
	@Override
	public String getTatemonoYoto3() {
		return model.getTatemonoYoto3();
	}

	/**
	 * Returns the upd date of this projgaiyo.
	 *
	 * @return the upd date of this projgaiyo
	 */
	@Override
	public String getUpdDate() {
		return model.getUpdDate();
	}

	/**
	 * Returns the upd time of this projgaiyo.
	 *
	 * @return the upd time of this projgaiyo
	 */
	@Override
	public String getUpdTime() {
		return model.getUpdTime();
	}

	/**
	 * Returns the uuid of this projgaiyo.
	 *
	 * @return the uuid of this projgaiyo
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the chakko bi of this projgaiyo.
	 *
	 * @param chakkoBi the chakko bi of this projgaiyo
	 */
	@Override
	public void setChakkoBi(String chakkoBi) {
		model.setChakkoBi(chakkoBi);
	}

	/**
	 * Sets the group ID of this projgaiyo.
	 *
	 * @param groupId the group ID of this projgaiyo
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the kaisu b of this projgaiyo.
	 *
	 * @param kaisuB the kaisu b of this projgaiyo
	 */
	@Override
	public void setKaisuB(Double kaisuB) {
		model.setKaisuB(kaisuB);
	}

	/**
	 * Sets the kaisu f of this projgaiyo.
	 *
	 * @param kaisuF the kaisu f of this projgaiyo
	 */
	@Override
	public void setKaisuF(Double kaisuF) {
		model.setKaisuF(kaisuF);
	}

	/**
	 * Sets the kaisu p of this projgaiyo.
	 *
	 * @param kaisuP the kaisu p of this projgaiyo
	 */
	@Override
	public void setKaisuP(Double kaisuP) {
		model.setKaisuP(kaisuP);
	}

	/**
	 * Sets the kenchiku chi cd of this projgaiyo.
	 *
	 * @param kenchikuChiCd the kenchiku chi cd of this projgaiyo
	 */
	@Override
	public void setKenchikuChiCd(String kenchikuChiCd) {
		model.setKenchikuChiCd(kenchikuChiCd);
	}

	/**
	 * Sets the kenchiku chi nm of this projgaiyo.
	 *
	 * @param kenchikuChiNm the kenchiku chi nm of this projgaiyo
	 */
	@Override
	public void setKenchikuChiNm(String kenchikuChiNm) {
		model.setKenchikuChiNm(kenchikuChiNm);
	}

	/**
	 * Sets the kenchiku menseki of this projgaiyo.
	 *
	 * @param kenchikuMenseki the kenchiku menseki of this projgaiyo
	 */
	@Override
	public void setKenchikuMenseki(Double kenchikuMenseki) {
		model.setKenchikuMenseki(kenchikuMenseki);
	}

	/**
	 * Sets the kenchiku nusi cd of this projgaiyo.
	 *
	 * @param kenchikuNusiCd the kenchiku nusi cd of this projgaiyo
	 */
	@Override
	public void setKenchikuNusiCd(String kenchikuNusiCd) {
		model.setKenchikuNusiCd(kenchikuNusiCd);
	}

	/**
	 * Sets the kenchiku nusi nm of this projgaiyo.
	 *
	 * @param kenchikuNusiNm the kenchiku nusi nm of this projgaiyo
	 */
	@Override
	public void setKenchikuNusiNm(String kenchikuNusiNm) {
		model.setKenchikuNusiNm(kenchikuNusiNm);
	}

	/**
	 * Sets the kozo shubetu1 of this projgaiyo.
	 *
	 * @param kozoShubetu1 the kozo shubetu1 of this projgaiyo
	 */
	@Override
	public void setKozoShubetu1(String kozoShubetu1) {
		model.setKozoShubetu1(kozoShubetu1);
	}

	/**
	 * Sets the kozo shubetu2 of this projgaiyo.
	 *
	 * @param kozoShubetu2 the kozo shubetu2 of this projgaiyo
	 */
	@Override
	public void setKozoShubetu2(String kozoShubetu2) {
		model.setKozoShubetu2(kozoShubetu2);
	}

	/**
	 * Sets the kozo shubetu3 of this projgaiyo.
	 *
	 * @param kozoShubetu3 the kozo shubetu3 of this projgaiyo
	 */
	@Override
	public void setKozoShubetu3(String kozoShubetu3) {
		model.setKozoShubetu3(kozoShubetu3);
	}

	/**
	 * Sets the nobeyuka menseki of this projgaiyo.
	 *
	 * @param nobeyukaMenseki the nobeyuka menseki of this projgaiyo
	 */
	@Override
	public void setNobeyukaMenseki(Double nobeyukaMenseki) {
		model.setNobeyukaMenseki(nobeyukaMenseki);
	}

	/**
	 * Sets the primary key of this projgaiyo.
	 *
	 * @param primaryKey the primary key of this projgaiyo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the proj nm of this projgaiyo.
	 *
	 * @param projNm the proj nm of this projgaiyo
	 */
	@Override
	public void setProjNm(String projNm) {
		model.setProjNm(projNm);
	}

	/**
	 * Sets the proj nm kana of this projgaiyo.
	 *
	 * @param projNmKana the proj nm kana of this projgaiyo
	 */
	@Override
	public void setProjNmKana(String projNmKana) {
		model.setProjNmKana(projNmKana);
	}

	/**
	 * Sets the sagyosho chiku of this projgaiyo.
	 *
	 * @param sagyoshoChiku the sagyosho chiku of this projgaiyo
	 */
	@Override
	public void setSagyoshoChiku(String sagyoshoChiku) {
		model.setSagyoshoChiku(sagyoshoChiku);
	}

	/**
	 * Sets the sekkei kb of this projgaiyo.
	 *
	 * @param sekkeiKb the sekkei kb of this projgaiyo
	 */
	@Override
	public void setSekkeiKb(String sekkeiKb) {
		model.setSekkeiKb(sekkeiKb);
	}

	/**
	 * Sets the seko kb of this projgaiyo.
	 *
	 * @param sekoKb the seko kb of this projgaiyo
	 */
	@Override
	public void setSekoKb(String sekoKb) {
		model.setSekoKb(sekoKb);
	}

	/**
	 * Sets the shunko bi of this projgaiyo.
	 *
	 * @param shunkoBi the shunko bi of this projgaiyo
	 */
	@Override
	public void setShunkoBi(String shunkoBi) {
		model.setShunkoBi(shunkoBi);
	}

	/**
	 * Sets the tatemono yoto1 of this projgaiyo.
	 *
	 * @param tatemonoYoto1 the tatemono yoto1 of this projgaiyo
	 */
	@Override
	public void setTatemonoYoto1(String tatemonoYoto1) {
		model.setTatemonoYoto1(tatemonoYoto1);
	}

	/**
	 * Sets the tatemono yoto2 of this projgaiyo.
	 *
	 * @param tatemonoYoto2 the tatemono yoto2 of this projgaiyo
	 */
	@Override
	public void setTatemonoYoto2(String tatemonoYoto2) {
		model.setTatemonoYoto2(tatemonoYoto2);
	}

	/**
	 * Sets the tatemono yoto3 of this projgaiyo.
	 *
	 * @param tatemonoYoto3 the tatemono yoto3 of this projgaiyo
	 */
	@Override
	public void setTatemonoYoto3(String tatemonoYoto3) {
		model.setTatemonoYoto3(tatemonoYoto3);
	}

	/**
	 * Sets the upd date of this projgaiyo.
	 *
	 * @param updDate the upd date of this projgaiyo
	 */
	@Override
	public void setUpdDate(String updDate) {
		model.setUpdDate(updDate);
	}

	/**
	 * Sets the upd time of this projgaiyo.
	 *
	 * @param updTime the upd time of this projgaiyo
	 */
	@Override
	public void setUpdTime(String updTime) {
		model.setUpdTime(updTime);
	}

	/**
	 * Sets the uuid of this projgaiyo.
	 *
	 * @param uuid the uuid of this projgaiyo
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected projgaiyoWrapper wrap(projgaiyo projgaiyo) {
		return new projgaiyoWrapper(projgaiyo);
	}

}