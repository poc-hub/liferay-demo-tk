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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.takenaka.service.http.projgaiyoServiceSoap}.
 *
 * @author Sanjay.Panchal
 * @generated
 */
public class projgaiyoSoap implements Serializable {

	public static projgaiyoSoap toSoapModel(projgaiyo model) {
		projgaiyoSoap soapModel = new projgaiyoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setProjNm(model.getProjNm());
		soapModel.setProjNmKana(model.getProjNmKana());
		soapModel.setKenchikuNusiCd(model.getKenchikuNusiCd());
		soapModel.setKenchikuNusiNm(model.getKenchikuNusiNm());
		soapModel.setKenchikuChiCd(model.getKenchikuChiCd());
		soapModel.setKenchikuChiNm(model.getKenchikuChiNm());
		soapModel.setTatemonoYoto1(model.getTatemonoYoto1());
		soapModel.setTatemonoYoto2(model.getTatemonoYoto2());
		soapModel.setTatemonoYoto3(model.getTatemonoYoto3());
		soapModel.setKaisuB(model.getKaisuB());
		soapModel.setKaisuF(model.getKaisuF());
		soapModel.setKaisuP(model.getKaisuP());
		soapModel.setKozoShubetu1(model.getKozoShubetu1());
		soapModel.setKozoShubetu2(model.getKozoShubetu2());
		soapModel.setKozoShubetu3(model.getKozoShubetu3());
		soapModel.setNobeyukaMenseki(model.getNobeyukaMenseki());
		soapModel.setKenchikuMenseki(model.getKenchikuMenseki());
		soapModel.setChakkoBi(model.getChakkoBi());
		soapModel.setShunkoBi(model.getShunkoBi());
		soapModel.setSekkeiKb(model.getSekkeiKb());
		soapModel.setSekoKb(model.getSekoKb());
		soapModel.setSagyoshoChiku(model.getSagyoshoChiku());
		soapModel.setUpdDate(model.getUpdDate());
		soapModel.setUpdTime(model.getUpdTime());

		return soapModel;
	}

	public static projgaiyoSoap[] toSoapModels(projgaiyo[] models) {
		projgaiyoSoap[] soapModels = new projgaiyoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static projgaiyoSoap[][] toSoapModels(projgaiyo[][] models) {
		projgaiyoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new projgaiyoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new projgaiyoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static projgaiyoSoap[] toSoapModels(List<projgaiyo> models) {
		List<projgaiyoSoap> soapModels = new ArrayList<projgaiyoSoap>(
			models.size());

		for (projgaiyo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new projgaiyoSoap[soapModels.size()]);
	}

	public projgaiyoSoap() {
	}

	public long getPrimaryKey() {
		return _groupId;
	}

	public void setPrimaryKey(long pk) {
		setGroupId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getProjNm() {
		return _projNm;
	}

	public void setProjNm(String projNm) {
		_projNm = projNm;
	}

	public String getProjNmKana() {
		return _projNmKana;
	}

	public void setProjNmKana(String projNmKana) {
		_projNmKana = projNmKana;
	}

	public String getKenchikuNusiCd() {
		return _kenchikuNusiCd;
	}

	public void setKenchikuNusiCd(String kenchikuNusiCd) {
		_kenchikuNusiCd = kenchikuNusiCd;
	}

	public String getKenchikuNusiNm() {
		return _kenchikuNusiNm;
	}

	public void setKenchikuNusiNm(String kenchikuNusiNm) {
		_kenchikuNusiNm = kenchikuNusiNm;
	}

	public String getKenchikuChiCd() {
		return _kenchikuChiCd;
	}

	public void setKenchikuChiCd(String kenchikuChiCd) {
		_kenchikuChiCd = kenchikuChiCd;
	}

	public String getKenchikuChiNm() {
		return _kenchikuChiNm;
	}

	public void setKenchikuChiNm(String kenchikuChiNm) {
		_kenchikuChiNm = kenchikuChiNm;
	}

	public String getTatemonoYoto1() {
		return _tatemonoYoto1;
	}

	public void setTatemonoYoto1(String tatemonoYoto1) {
		_tatemonoYoto1 = tatemonoYoto1;
	}

	public String getTatemonoYoto2() {
		return _tatemonoYoto2;
	}

	public void setTatemonoYoto2(String tatemonoYoto2) {
		_tatemonoYoto2 = tatemonoYoto2;
	}

	public String getTatemonoYoto3() {
		return _tatemonoYoto3;
	}

	public void setTatemonoYoto3(String tatemonoYoto3) {
		_tatemonoYoto3 = tatemonoYoto3;
	}

	public Double getKaisuB() {
		return _kaisuB;
	}

	public void setKaisuB(Double kaisuB) {
		_kaisuB = kaisuB;
	}

	public Double getKaisuF() {
		return _kaisuF;
	}

	public void setKaisuF(Double kaisuF) {
		_kaisuF = kaisuF;
	}

	public Double getKaisuP() {
		return _kaisuP;
	}

	public void setKaisuP(Double kaisuP) {
		_kaisuP = kaisuP;
	}

	public String getKozoShubetu1() {
		return _kozoShubetu1;
	}

	public void setKozoShubetu1(String kozoShubetu1) {
		_kozoShubetu1 = kozoShubetu1;
	}

	public String getKozoShubetu2() {
		return _kozoShubetu2;
	}

	public void setKozoShubetu2(String kozoShubetu2) {
		_kozoShubetu2 = kozoShubetu2;
	}

	public String getKozoShubetu3() {
		return _kozoShubetu3;
	}

	public void setKozoShubetu3(String kozoShubetu3) {
		_kozoShubetu3 = kozoShubetu3;
	}

	public Double getNobeyukaMenseki() {
		return _nobeyukaMenseki;
	}

	public void setNobeyukaMenseki(Double nobeyukaMenseki) {
		_nobeyukaMenseki = nobeyukaMenseki;
	}

	public Double getKenchikuMenseki() {
		return _kenchikuMenseki;
	}

	public void setKenchikuMenseki(Double kenchikuMenseki) {
		_kenchikuMenseki = kenchikuMenseki;
	}

	public String getChakkoBi() {
		return _chakkoBi;
	}

	public void setChakkoBi(String chakkoBi) {
		_chakkoBi = chakkoBi;
	}

	public String getShunkoBi() {
		return _shunkoBi;
	}

	public void setShunkoBi(String shunkoBi) {
		_shunkoBi = shunkoBi;
	}

	public String getSekkeiKb() {
		return _sekkeiKb;
	}

	public void setSekkeiKb(String sekkeiKb) {
		_sekkeiKb = sekkeiKb;
	}

	public String getSekoKb() {
		return _sekoKb;
	}

	public void setSekoKb(String sekoKb) {
		_sekoKb = sekoKb;
	}

	public String getSagyoshoChiku() {
		return _sagyoshoChiku;
	}

	public void setSagyoshoChiku(String sagyoshoChiku) {
		_sagyoshoChiku = sagyoshoChiku;
	}

	public String getUpdDate() {
		return _updDate;
	}

	public void setUpdDate(String updDate) {
		_updDate = updDate;
	}

	public String getUpdTime() {
		return _updTime;
	}

	public void setUpdTime(String updTime) {
		_updTime = updTime;
	}

	private String _uuid;
	private long _groupId;
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

}