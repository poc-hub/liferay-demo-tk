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
 * This class is used by SOAP remote services, specifically {@link com.takenaka.service.http.ProjTableServiceSoap}.
 *
 * @author Sanjay.Panchal
 * @generated
 */
public class ProjTableSoap implements Serializable {

	public static ProjTableSoap toSoapModel(ProjTable model) {
		ProjTableSoap soapModel = new ProjTableSoap();

		soapModel.setRecId(model.getRecId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setGroupFlag(model.getGroupFlag());
		soapModel.setYosoKojiCd(model.getYosoKojiCd());
		soapModel.setSekkeiCd(model.getSekkeiCd());
		soapModel.setSekkeiCdYy(model.getSekkeiCdYy());
		soapModel.setMitumoriNendo(model.getMitumoriNendo());
		soapModel.setMitumoriCd(model.getMitumoriCd());
		soapModel.setKojiCd(model.getKojiCd());
		soapModel.setMitumoriSeiriNo(model.getMitumoriSeiriNo());
		soapModel.setShukanSekkeiCd(model.getShukanSekkeiCd());
		soapModel.setSekkeiTogoSaki(model.getSekkeiTogoSaki());
		soapModel.setSekkeiBunkatuMoto(model.getSekkeiBunkatuMoto());
		soapModel.setJutakuSekkeiTaisho(model.getJutakuSekkeiTaisho());
		soapModel.setHonsitenRid(model.getHonsitenRid());
		soapModel.setHonsitenGid(model.getHonsitenGid());
		soapModel.setOrgYkoji(model.getOrgYkoji());
		soapModel.setOrgJKOJI(model.getOrgJKOJI());
		soapModel.setOrgMdd(model.getOrgMdd());
		soapModel.setOrgPdd(model.getOrgPdd());
		soapModel.setOrgEsmas(model.getOrgEsmas());
		soapModel.setOrgPrist(model.getOrgPrist());
		soapModel.setProcSekkei(model.getProcSekkei());
		soapModel.setProcMitumori(model.getProcMitumori());
		soapModel.setProcSekkeiOen(model.getProcSekkeiOen());
		soapModel.setProcSekkeiTogo(model.getProcSekkeiTogo());
		soapModel.setProcSekkeiBunkatu(model.getProcSekkeiBunkatu());
		soapModel.setProcSekkeiJutaku(model.getProcSekkeiJutaku());
		soapModel.setTaketuChusiToketuKb(model.getTaketuChusiToketuKb());
		soapModel.setKanryoChusiStatus(model.getKanryoChusiStatus());
		soapModel.setMitumoriKeijoShubetu(model.getMitumoriKeijoShubetu());
		soapModel.setTorikesiKb(model.getTorikesiKb());
		soapModel.setKessanNendo(model.getKessanNendo());
		soapModel.setUpdDate(model.getUpdDate());
		soapModel.setUpdTime(model.getUpdTime());

		return soapModel;
	}

	public static ProjTableSoap[] toSoapModels(ProjTable[] models) {
		ProjTableSoap[] soapModels = new ProjTableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjTableSoap[][] toSoapModels(ProjTable[][] models) {
		ProjTableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjTableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjTableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjTableSoap[] toSoapModels(List<ProjTable> models) {
		List<ProjTableSoap> soapModels = new ArrayList<ProjTableSoap>(
			models.size());

		for (ProjTable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjTableSoap[soapModels.size()]);
	}

	public ProjTableSoap() {
	}

	public long getPrimaryKey() {
		return _recId;
	}

	public void setPrimaryKey(long pk) {
		setRecId(pk);
	}

	public long getRecId() {
		return _recId;
	}

	public void setRecId(long recId) {
		_recId = recId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getGroupFlag() {
		return _groupFlag;
	}

	public void setGroupFlag(String groupFlag) {
		_groupFlag = groupFlag;
	}

	public String getYosoKojiCd() {
		return _yosoKojiCd;
	}

	public void setYosoKojiCd(String yosoKojiCd) {
		_yosoKojiCd = yosoKojiCd;
	}

	public String getSekkeiCd() {
		return _sekkeiCd;
	}

	public void setSekkeiCd(String sekkeiCd) {
		_sekkeiCd = sekkeiCd;
	}

	public String getSekkeiCdYy() {
		return _sekkeiCdYy;
	}

	public void setSekkeiCdYy(String sekkeiCdYy) {
		_sekkeiCdYy = sekkeiCdYy;
	}

	public String getMitumoriNendo() {
		return _mitumoriNendo;
	}

	public void setMitumoriNendo(String mitumoriNendo) {
		_mitumoriNendo = mitumoriNendo;
	}

	public String getMitumoriCd() {
		return _mitumoriCd;
	}

	public void setMitumoriCd(String mitumoriCd) {
		_mitumoriCd = mitumoriCd;
	}

	public String getKojiCd() {
		return _kojiCd;
	}

	public void setKojiCd(String kojiCd) {
		_kojiCd = kojiCd;
	}

	public String getMitumoriSeiriNo() {
		return _mitumoriSeiriNo;
	}

	public void setMitumoriSeiriNo(String mitumoriSeiriNo) {
		_mitumoriSeiriNo = mitumoriSeiriNo;
	}

	public String getShukanSekkeiCd() {
		return _shukanSekkeiCd;
	}

	public void setShukanSekkeiCd(String shukanSekkeiCd) {
		_shukanSekkeiCd = shukanSekkeiCd;
	}

	public String getSekkeiTogoSaki() {
		return _sekkeiTogoSaki;
	}

	public void setSekkeiTogoSaki(String sekkeiTogoSaki) {
		_sekkeiTogoSaki = sekkeiTogoSaki;
	}

	public String getSekkeiBunkatuMoto() {
		return _sekkeiBunkatuMoto;
	}

	public void setSekkeiBunkatuMoto(String sekkeiBunkatuMoto) {
		_sekkeiBunkatuMoto = sekkeiBunkatuMoto;
	}

	public String getJutakuSekkeiTaisho() {
		return _jutakuSekkeiTaisho;
	}

	public void setJutakuSekkeiTaisho(String jutakuSekkeiTaisho) {
		_jutakuSekkeiTaisho = jutakuSekkeiTaisho;
	}

	public String getHonsitenRid() {
		return _honsitenRid;
	}

	public void setHonsitenRid(String honsitenRid) {
		_honsitenRid = honsitenRid;
	}

	public String getHonsitenGid() {
		return _honsitenGid;
	}

	public void setHonsitenGid(String honsitenGid) {
		_honsitenGid = honsitenGid;
	}

	public String getOrgYkoji() {
		return _orgYkoji;
	}

	public void setOrgYkoji(String orgYkoji) {
		_orgYkoji = orgYkoji;
	}

	public String getOrgJKOJI() {
		return _orgJKOJI;
	}

	public void setOrgJKOJI(String orgJKOJI) {
		_orgJKOJI = orgJKOJI;
	}

	public String getOrgMdd() {
		return _orgMdd;
	}

	public void setOrgMdd(String orgMdd) {
		_orgMdd = orgMdd;
	}

	public String getOrgPdd() {
		return _orgPdd;
	}

	public void setOrgPdd(String orgPdd) {
		_orgPdd = orgPdd;
	}

	public String getOrgEsmas() {
		return _orgEsmas;
	}

	public void setOrgEsmas(String orgEsmas) {
		_orgEsmas = orgEsmas;
	}

	public String getOrgPrist() {
		return _orgPrist;
	}

	public void setOrgPrist(String orgPrist) {
		_orgPrist = orgPrist;
	}

	public String getProcSekkei() {
		return _procSekkei;
	}

	public void setProcSekkei(String procSekkei) {
		_procSekkei = procSekkei;
	}

	public String getProcMitumori() {
		return _procMitumori;
	}

	public void setProcMitumori(String procMitumori) {
		_procMitumori = procMitumori;
	}

	public String getProcSekkeiOen() {
		return _procSekkeiOen;
	}

	public void setProcSekkeiOen(String procSekkeiOen) {
		_procSekkeiOen = procSekkeiOen;
	}

	public String getProcSekkeiTogo() {
		return _procSekkeiTogo;
	}

	public void setProcSekkeiTogo(String procSekkeiTogo) {
		_procSekkeiTogo = procSekkeiTogo;
	}

	public String getProcSekkeiBunkatu() {
		return _procSekkeiBunkatu;
	}

	public void setProcSekkeiBunkatu(String procSekkeiBunkatu) {
		_procSekkeiBunkatu = procSekkeiBunkatu;
	}

	public String getProcSekkeiJutaku() {
		return _procSekkeiJutaku;
	}

	public void setProcSekkeiJutaku(String procSekkeiJutaku) {
		_procSekkeiJutaku = procSekkeiJutaku;
	}

	public String getTaketuChusiToketuKb() {
		return _taketuChusiToketuKb;
	}

	public void setTaketuChusiToketuKb(String taketuChusiToketuKb) {
		_taketuChusiToketuKb = taketuChusiToketuKb;
	}

	public String getKanryoChusiStatus() {
		return _kanryoChusiStatus;
	}

	public void setKanryoChusiStatus(String kanryoChusiStatus) {
		_kanryoChusiStatus = kanryoChusiStatus;
	}

	public String getMitumoriKeijoShubetu() {
		return _mitumoriKeijoShubetu;
	}

	public void setMitumoriKeijoShubetu(String mitumoriKeijoShubetu) {
		_mitumoriKeijoShubetu = mitumoriKeijoShubetu;
	}

	public String getTorikesiKb() {
		return _torikesiKb;
	}

	public void setTorikesiKb(String torikesiKb) {
		_torikesiKb = torikesiKb;
	}

	public String getKessanNendo() {
		return _kessanNendo;
	}

	public void setKessanNendo(String kessanNendo) {
		_kessanNendo = kessanNendo;
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

	private long _recId;
	private long _groupId;
	private String _groupFlag;
	private String _yosoKojiCd;
	private String _sekkeiCd;
	private String _sekkeiCdYy;
	private String _mitumoriNendo;
	private String _mitumoriCd;
	private String _kojiCd;
	private String _mitumoriSeiriNo;
	private String _shukanSekkeiCd;
	private String _sekkeiTogoSaki;
	private String _sekkeiBunkatuMoto;
	private String _jutakuSekkeiTaisho;
	private String _honsitenRid;
	private String _honsitenGid;
	private String _orgYkoji;
	private String _orgJKOJI;
	private String _orgMdd;
	private String _orgPdd;
	private String _orgEsmas;
	private String _orgPrist;
	private String _procSekkei;
	private String _procMitumori;
	private String _procSekkeiOen;
	private String _procSekkeiTogo;
	private String _procSekkeiBunkatu;
	private String _procSekkeiJutaku;
	private String _taketuChusiToketuKb;
	private String _kanryoChusiStatus;
	private String _mitumoriKeijoShubetu;
	private String _torikesiKb;
	private String _kessanNendo;
	private String _updDate;
	private String _updTime;

}