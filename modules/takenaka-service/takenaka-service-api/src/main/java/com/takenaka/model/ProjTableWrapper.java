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
 * This class is a wrapper for {@link ProjTable}.
 * </p>
 *
 * @author Sanjay.Panchal
 * @see ProjTable
 * @generated
 */
public class ProjTableWrapper
	extends BaseModelWrapper<ProjTable>
	implements ModelWrapper<ProjTable>, ProjTable {

	public ProjTableWrapper(ProjTable projTable) {
		super(projTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recId", getRecId());
		attributes.put("groupId", getGroupId());
		attributes.put("groupFlag", getGroupFlag());
		attributes.put("yosoKojiCd", getYosoKojiCd());
		attributes.put("sekkeiCd", getSekkeiCd());
		attributes.put("sekkeiCdYy", getSekkeiCdYy());
		attributes.put("mitumoriNendo", getMitumoriNendo());
		attributes.put("mitumoriCd", getMitumoriCd());
		attributes.put("kojiCd", getKojiCd());
		attributes.put("mitumoriSeiriNo", getMitumoriSeiriNo());
		attributes.put("shukanSekkeiCd", getShukanSekkeiCd());
		attributes.put("sekkeiTogoSaki", getSekkeiTogoSaki());
		attributes.put("sekkeiBunkatuMoto", getSekkeiBunkatuMoto());
		attributes.put("jutakuSekkeiTaisho", getJutakuSekkeiTaisho());
		attributes.put("honsitenRid", getHonsitenRid());
		attributes.put("honsitenGid", getHonsitenGid());
		attributes.put("orgYkoji", getOrgYkoji());
		attributes.put("orgJKOJI", getOrgJKOJI());
		attributes.put("orgMdd", getOrgMdd());
		attributes.put("orgPdd", getOrgPdd());
		attributes.put("orgEsmas", getOrgEsmas());
		attributes.put("orgPrist", getOrgPrist());
		attributes.put("procSekkei", getProcSekkei());
		attributes.put("procMitumori", getProcMitumori());
		attributes.put("procSekkeiOen", getProcSekkeiOen());
		attributes.put("procSekkeiTogo", getProcSekkeiTogo());
		attributes.put("procSekkeiBunkatu", getProcSekkeiBunkatu());
		attributes.put("procSekkeiJutaku", getProcSekkeiJutaku());
		attributes.put("taketuChusiToketuKb", getTaketuChusiToketuKb());
		attributes.put("kanryoChusiStatus", getKanryoChusiStatus());
		attributes.put("mitumoriKeijoShubetu", getMitumoriKeijoShubetu());
		attributes.put("torikesiKb", getTorikesiKb());
		attributes.put("kessanNendo", getKessanNendo());
		attributes.put("updDate", getUpdDate());
		attributes.put("updTime", getUpdTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recId = (Long)attributes.get("recId");

		if (recId != null) {
			setRecId(recId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String groupFlag = (String)attributes.get("groupFlag");

		if (groupFlag != null) {
			setGroupFlag(groupFlag);
		}

		String yosoKojiCd = (String)attributes.get("yosoKojiCd");

		if (yosoKojiCd != null) {
			setYosoKojiCd(yosoKojiCd);
		}

		String sekkeiCd = (String)attributes.get("sekkeiCd");

		if (sekkeiCd != null) {
			setSekkeiCd(sekkeiCd);
		}

		String sekkeiCdYy = (String)attributes.get("sekkeiCdYy");

		if (sekkeiCdYy != null) {
			setSekkeiCdYy(sekkeiCdYy);
		}

		String mitumoriNendo = (String)attributes.get("mitumoriNendo");

		if (mitumoriNendo != null) {
			setMitumoriNendo(mitumoriNendo);
		}

		String mitumoriCd = (String)attributes.get("mitumoriCd");

		if (mitumoriCd != null) {
			setMitumoriCd(mitumoriCd);
		}

		String kojiCd = (String)attributes.get("kojiCd");

		if (kojiCd != null) {
			setKojiCd(kojiCd);
		}

		String mitumoriSeiriNo = (String)attributes.get("mitumoriSeiriNo");

		if (mitumoriSeiriNo != null) {
			setMitumoriSeiriNo(mitumoriSeiriNo);
		}

		String shukanSekkeiCd = (String)attributes.get("shukanSekkeiCd");

		if (shukanSekkeiCd != null) {
			setShukanSekkeiCd(shukanSekkeiCd);
		}

		String sekkeiTogoSaki = (String)attributes.get("sekkeiTogoSaki");

		if (sekkeiTogoSaki != null) {
			setSekkeiTogoSaki(sekkeiTogoSaki);
		}

		String sekkeiBunkatuMoto = (String)attributes.get("sekkeiBunkatuMoto");

		if (sekkeiBunkatuMoto != null) {
			setSekkeiBunkatuMoto(sekkeiBunkatuMoto);
		}

		String jutakuSekkeiTaisho = (String)attributes.get(
			"jutakuSekkeiTaisho");

		if (jutakuSekkeiTaisho != null) {
			setJutakuSekkeiTaisho(jutakuSekkeiTaisho);
		}

		String honsitenRid = (String)attributes.get("honsitenRid");

		if (honsitenRid != null) {
			setHonsitenRid(honsitenRid);
		}

		String honsitenGid = (String)attributes.get("honsitenGid");

		if (honsitenGid != null) {
			setHonsitenGid(honsitenGid);
		}

		String orgYkoji = (String)attributes.get("orgYkoji");

		if (orgYkoji != null) {
			setOrgYkoji(orgYkoji);
		}

		String orgJKOJI = (String)attributes.get("orgJKOJI");

		if (orgJKOJI != null) {
			setOrgJKOJI(orgJKOJI);
		}

		String orgMdd = (String)attributes.get("orgMdd");

		if (orgMdd != null) {
			setOrgMdd(orgMdd);
		}

		String orgPdd = (String)attributes.get("orgPdd");

		if (orgPdd != null) {
			setOrgPdd(orgPdd);
		}

		String orgEsmas = (String)attributes.get("orgEsmas");

		if (orgEsmas != null) {
			setOrgEsmas(orgEsmas);
		}

		String orgPrist = (String)attributes.get("orgPrist");

		if (orgPrist != null) {
			setOrgPrist(orgPrist);
		}

		String procSekkei = (String)attributes.get("procSekkei");

		if (procSekkei != null) {
			setProcSekkei(procSekkei);
		}

		String procMitumori = (String)attributes.get("procMitumori");

		if (procMitumori != null) {
			setProcMitumori(procMitumori);
		}

		String procSekkeiOen = (String)attributes.get("procSekkeiOen");

		if (procSekkeiOen != null) {
			setProcSekkeiOen(procSekkeiOen);
		}

		String procSekkeiTogo = (String)attributes.get("procSekkeiTogo");

		if (procSekkeiTogo != null) {
			setProcSekkeiTogo(procSekkeiTogo);
		}

		String procSekkeiBunkatu = (String)attributes.get("procSekkeiBunkatu");

		if (procSekkeiBunkatu != null) {
			setProcSekkeiBunkatu(procSekkeiBunkatu);
		}

		String procSekkeiJutaku = (String)attributes.get("procSekkeiJutaku");

		if (procSekkeiJutaku != null) {
			setProcSekkeiJutaku(procSekkeiJutaku);
		}

		String taketuChusiToketuKb = (String)attributes.get(
			"taketuChusiToketuKb");

		if (taketuChusiToketuKb != null) {
			setTaketuChusiToketuKb(taketuChusiToketuKb);
		}

		String kanryoChusiStatus = (String)attributes.get("kanryoChusiStatus");

		if (kanryoChusiStatus != null) {
			setKanryoChusiStatus(kanryoChusiStatus);
		}

		String mitumoriKeijoShubetu = (String)attributes.get(
			"mitumoriKeijoShubetu");

		if (mitumoriKeijoShubetu != null) {
			setMitumoriKeijoShubetu(mitumoriKeijoShubetu);
		}

		String torikesiKb = (String)attributes.get("torikesiKb");

		if (torikesiKb != null) {
			setTorikesiKb(torikesiKb);
		}

		String kessanNendo = (String)attributes.get("kessanNendo");

		if (kessanNendo != null) {
			setKessanNendo(kessanNendo);
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
	 * Returns the group flag of this proj table.
	 *
	 * @return the group flag of this proj table
	 */
	@Override
	public String getGroupFlag() {
		return model.getGroupFlag();
	}

	/**
	 * Returns the group ID of this proj table.
	 *
	 * @return the group ID of this proj table
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the honsiten gid of this proj table.
	 *
	 * @return the honsiten gid of this proj table
	 */
	@Override
	public String getHonsitenGid() {
		return model.getHonsitenGid();
	}

	/**
	 * Returns the honsiten rid of this proj table.
	 *
	 * @return the honsiten rid of this proj table
	 */
	@Override
	public String getHonsitenRid() {
		return model.getHonsitenRid();
	}

	/**
	 * Returns the jutaku sekkei taisho of this proj table.
	 *
	 * @return the jutaku sekkei taisho of this proj table
	 */
	@Override
	public String getJutakuSekkeiTaisho() {
		return model.getJutakuSekkeiTaisho();
	}

	/**
	 * Returns the kanryo chusi status of this proj table.
	 *
	 * @return the kanryo chusi status of this proj table
	 */
	@Override
	public String getKanryoChusiStatus() {
		return model.getKanryoChusiStatus();
	}

	/**
	 * Returns the kessan nendo of this proj table.
	 *
	 * @return the kessan nendo of this proj table
	 */
	@Override
	public String getKessanNendo() {
		return model.getKessanNendo();
	}

	/**
	 * Returns the koji cd of this proj table.
	 *
	 * @return the koji cd of this proj table
	 */
	@Override
	public String getKojiCd() {
		return model.getKojiCd();
	}

	/**
	 * Returns the mitumori cd of this proj table.
	 *
	 * @return the mitumori cd of this proj table
	 */
	@Override
	public String getMitumoriCd() {
		return model.getMitumoriCd();
	}

	/**
	 * Returns the mitumori keijo shubetu of this proj table.
	 *
	 * @return the mitumori keijo shubetu of this proj table
	 */
	@Override
	public String getMitumoriKeijoShubetu() {
		return model.getMitumoriKeijoShubetu();
	}

	/**
	 * Returns the mitumori nendo of this proj table.
	 *
	 * @return the mitumori nendo of this proj table
	 */
	@Override
	public String getMitumoriNendo() {
		return model.getMitumoriNendo();
	}

	/**
	 * Returns the mitumori seiri no of this proj table.
	 *
	 * @return the mitumori seiri no of this proj table
	 */
	@Override
	public String getMitumoriSeiriNo() {
		return model.getMitumoriSeiriNo();
	}

	/**
	 * Returns the org esmas of this proj table.
	 *
	 * @return the org esmas of this proj table
	 */
	@Override
	public String getOrgEsmas() {
		return model.getOrgEsmas();
	}

	/**
	 * Returns the org jkoji of this proj table.
	 *
	 * @return the org jkoji of this proj table
	 */
	@Override
	public String getOrgJKOJI() {
		return model.getOrgJKOJI();
	}

	/**
	 * Returns the org mdd of this proj table.
	 *
	 * @return the org mdd of this proj table
	 */
	@Override
	public String getOrgMdd() {
		return model.getOrgMdd();
	}

	/**
	 * Returns the org pdd of this proj table.
	 *
	 * @return the org pdd of this proj table
	 */
	@Override
	public String getOrgPdd() {
		return model.getOrgPdd();
	}

	/**
	 * Returns the org prist of this proj table.
	 *
	 * @return the org prist of this proj table
	 */
	@Override
	public String getOrgPrist() {
		return model.getOrgPrist();
	}

	/**
	 * Returns the org ykoji of this proj table.
	 *
	 * @return the org ykoji of this proj table
	 */
	@Override
	public String getOrgYkoji() {
		return model.getOrgYkoji();
	}

	/**
	 * Returns the primary key of this proj table.
	 *
	 * @return the primary key of this proj table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the proc mitumori of this proj table.
	 *
	 * @return the proc mitumori of this proj table
	 */
	@Override
	public String getProcMitumori() {
		return model.getProcMitumori();
	}

	/**
	 * Returns the proc sekkei of this proj table.
	 *
	 * @return the proc sekkei of this proj table
	 */
	@Override
	public String getProcSekkei() {
		return model.getProcSekkei();
	}

	/**
	 * Returns the proc sekkei bunkatu of this proj table.
	 *
	 * @return the proc sekkei bunkatu of this proj table
	 */
	@Override
	public String getProcSekkeiBunkatu() {
		return model.getProcSekkeiBunkatu();
	}

	/**
	 * Returns the proc sekkei jutaku of this proj table.
	 *
	 * @return the proc sekkei jutaku of this proj table
	 */
	@Override
	public String getProcSekkeiJutaku() {
		return model.getProcSekkeiJutaku();
	}

	/**
	 * Returns the proc sekkei oen of this proj table.
	 *
	 * @return the proc sekkei oen of this proj table
	 */
	@Override
	public String getProcSekkeiOen() {
		return model.getProcSekkeiOen();
	}

	/**
	 * Returns the proc sekkei togo of this proj table.
	 *
	 * @return the proc sekkei togo of this proj table
	 */
	@Override
	public String getProcSekkeiTogo() {
		return model.getProcSekkeiTogo();
	}

	/**
	 * Returns the rec ID of this proj table.
	 *
	 * @return the rec ID of this proj table
	 */
	@Override
	public long getRecId() {
		return model.getRecId();
	}

	/**
	 * Returns the sekkei bunkatu moto of this proj table.
	 *
	 * @return the sekkei bunkatu moto of this proj table
	 */
	@Override
	public String getSekkeiBunkatuMoto() {
		return model.getSekkeiBunkatuMoto();
	}

	/**
	 * Returns the sekkei cd of this proj table.
	 *
	 * @return the sekkei cd of this proj table
	 */
	@Override
	public String getSekkeiCd() {
		return model.getSekkeiCd();
	}

	/**
	 * Returns the sekkei cd yy of this proj table.
	 *
	 * @return the sekkei cd yy of this proj table
	 */
	@Override
	public String getSekkeiCdYy() {
		return model.getSekkeiCdYy();
	}

	/**
	 * Returns the sekkei togo saki of this proj table.
	 *
	 * @return the sekkei togo saki of this proj table
	 */
	@Override
	public String getSekkeiTogoSaki() {
		return model.getSekkeiTogoSaki();
	}

	/**
	 * Returns the shukan sekkei cd of this proj table.
	 *
	 * @return the shukan sekkei cd of this proj table
	 */
	@Override
	public String getShukanSekkeiCd() {
		return model.getShukanSekkeiCd();
	}

	/**
	 * Returns the taketu chusi toketu kb of this proj table.
	 *
	 * @return the taketu chusi toketu kb of this proj table
	 */
	@Override
	public String getTaketuChusiToketuKb() {
		return model.getTaketuChusiToketuKb();
	}

	/**
	 * Returns the torikesi kb of this proj table.
	 *
	 * @return the torikesi kb of this proj table
	 */
	@Override
	public String getTorikesiKb() {
		return model.getTorikesiKb();
	}

	/**
	 * Returns the upd date of this proj table.
	 *
	 * @return the upd date of this proj table
	 */
	@Override
	public String getUpdDate() {
		return model.getUpdDate();
	}

	/**
	 * Returns the upd time of this proj table.
	 *
	 * @return the upd time of this proj table
	 */
	@Override
	public String getUpdTime() {
		return model.getUpdTime();
	}

	/**
	 * Returns the yoso koji cd of this proj table.
	 *
	 * @return the yoso koji cd of this proj table
	 */
	@Override
	public String getYosoKojiCd() {
		return model.getYosoKojiCd();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the group flag of this proj table.
	 *
	 * @param groupFlag the group flag of this proj table
	 */
	@Override
	public void setGroupFlag(String groupFlag) {
		model.setGroupFlag(groupFlag);
	}

	/**
	 * Sets the group ID of this proj table.
	 *
	 * @param groupId the group ID of this proj table
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the honsiten gid of this proj table.
	 *
	 * @param honsitenGid the honsiten gid of this proj table
	 */
	@Override
	public void setHonsitenGid(String honsitenGid) {
		model.setHonsitenGid(honsitenGid);
	}

	/**
	 * Sets the honsiten rid of this proj table.
	 *
	 * @param honsitenRid the honsiten rid of this proj table
	 */
	@Override
	public void setHonsitenRid(String honsitenRid) {
		model.setHonsitenRid(honsitenRid);
	}

	/**
	 * Sets the jutaku sekkei taisho of this proj table.
	 *
	 * @param jutakuSekkeiTaisho the jutaku sekkei taisho of this proj table
	 */
	@Override
	public void setJutakuSekkeiTaisho(String jutakuSekkeiTaisho) {
		model.setJutakuSekkeiTaisho(jutakuSekkeiTaisho);
	}

	/**
	 * Sets the kanryo chusi status of this proj table.
	 *
	 * @param kanryoChusiStatus the kanryo chusi status of this proj table
	 */
	@Override
	public void setKanryoChusiStatus(String kanryoChusiStatus) {
		model.setKanryoChusiStatus(kanryoChusiStatus);
	}

	/**
	 * Sets the kessan nendo of this proj table.
	 *
	 * @param kessanNendo the kessan nendo of this proj table
	 */
	@Override
	public void setKessanNendo(String kessanNendo) {
		model.setKessanNendo(kessanNendo);
	}

	/**
	 * Sets the koji cd of this proj table.
	 *
	 * @param kojiCd the koji cd of this proj table
	 */
	@Override
	public void setKojiCd(String kojiCd) {
		model.setKojiCd(kojiCd);
	}

	/**
	 * Sets the mitumori cd of this proj table.
	 *
	 * @param mitumoriCd the mitumori cd of this proj table
	 */
	@Override
	public void setMitumoriCd(String mitumoriCd) {
		model.setMitumoriCd(mitumoriCd);
	}

	/**
	 * Sets the mitumori keijo shubetu of this proj table.
	 *
	 * @param mitumoriKeijoShubetu the mitumori keijo shubetu of this proj table
	 */
	@Override
	public void setMitumoriKeijoShubetu(String mitumoriKeijoShubetu) {
		model.setMitumoriKeijoShubetu(mitumoriKeijoShubetu);
	}

	/**
	 * Sets the mitumori nendo of this proj table.
	 *
	 * @param mitumoriNendo the mitumori nendo of this proj table
	 */
	@Override
	public void setMitumoriNendo(String mitumoriNendo) {
		model.setMitumoriNendo(mitumoriNendo);
	}

	/**
	 * Sets the mitumori seiri no of this proj table.
	 *
	 * @param mitumoriSeiriNo the mitumori seiri no of this proj table
	 */
	@Override
	public void setMitumoriSeiriNo(String mitumoriSeiriNo) {
		model.setMitumoriSeiriNo(mitumoriSeiriNo);
	}

	/**
	 * Sets the org esmas of this proj table.
	 *
	 * @param orgEsmas the org esmas of this proj table
	 */
	@Override
	public void setOrgEsmas(String orgEsmas) {
		model.setOrgEsmas(orgEsmas);
	}

	/**
	 * Sets the org jkoji of this proj table.
	 *
	 * @param orgJKOJI the org jkoji of this proj table
	 */
	@Override
	public void setOrgJKOJI(String orgJKOJI) {
		model.setOrgJKOJI(orgJKOJI);
	}

	/**
	 * Sets the org mdd of this proj table.
	 *
	 * @param orgMdd the org mdd of this proj table
	 */
	@Override
	public void setOrgMdd(String orgMdd) {
		model.setOrgMdd(orgMdd);
	}

	/**
	 * Sets the org pdd of this proj table.
	 *
	 * @param orgPdd the org pdd of this proj table
	 */
	@Override
	public void setOrgPdd(String orgPdd) {
		model.setOrgPdd(orgPdd);
	}

	/**
	 * Sets the org prist of this proj table.
	 *
	 * @param orgPrist the org prist of this proj table
	 */
	@Override
	public void setOrgPrist(String orgPrist) {
		model.setOrgPrist(orgPrist);
	}

	/**
	 * Sets the org ykoji of this proj table.
	 *
	 * @param orgYkoji the org ykoji of this proj table
	 */
	@Override
	public void setOrgYkoji(String orgYkoji) {
		model.setOrgYkoji(orgYkoji);
	}

	/**
	 * Sets the primary key of this proj table.
	 *
	 * @param primaryKey the primary key of this proj table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the proc mitumori of this proj table.
	 *
	 * @param procMitumori the proc mitumori of this proj table
	 */
	@Override
	public void setProcMitumori(String procMitumori) {
		model.setProcMitumori(procMitumori);
	}

	/**
	 * Sets the proc sekkei of this proj table.
	 *
	 * @param procSekkei the proc sekkei of this proj table
	 */
	@Override
	public void setProcSekkei(String procSekkei) {
		model.setProcSekkei(procSekkei);
	}

	/**
	 * Sets the proc sekkei bunkatu of this proj table.
	 *
	 * @param procSekkeiBunkatu the proc sekkei bunkatu of this proj table
	 */
	@Override
	public void setProcSekkeiBunkatu(String procSekkeiBunkatu) {
		model.setProcSekkeiBunkatu(procSekkeiBunkatu);
	}

	/**
	 * Sets the proc sekkei jutaku of this proj table.
	 *
	 * @param procSekkeiJutaku the proc sekkei jutaku of this proj table
	 */
	@Override
	public void setProcSekkeiJutaku(String procSekkeiJutaku) {
		model.setProcSekkeiJutaku(procSekkeiJutaku);
	}

	/**
	 * Sets the proc sekkei oen of this proj table.
	 *
	 * @param procSekkeiOen the proc sekkei oen of this proj table
	 */
	@Override
	public void setProcSekkeiOen(String procSekkeiOen) {
		model.setProcSekkeiOen(procSekkeiOen);
	}

	/**
	 * Sets the proc sekkei togo of this proj table.
	 *
	 * @param procSekkeiTogo the proc sekkei togo of this proj table
	 */
	@Override
	public void setProcSekkeiTogo(String procSekkeiTogo) {
		model.setProcSekkeiTogo(procSekkeiTogo);
	}

	/**
	 * Sets the rec ID of this proj table.
	 *
	 * @param recId the rec ID of this proj table
	 */
	@Override
	public void setRecId(long recId) {
		model.setRecId(recId);
	}

	/**
	 * Sets the sekkei bunkatu moto of this proj table.
	 *
	 * @param sekkeiBunkatuMoto the sekkei bunkatu moto of this proj table
	 */
	@Override
	public void setSekkeiBunkatuMoto(String sekkeiBunkatuMoto) {
		model.setSekkeiBunkatuMoto(sekkeiBunkatuMoto);
	}

	/**
	 * Sets the sekkei cd of this proj table.
	 *
	 * @param sekkeiCd the sekkei cd of this proj table
	 */
	@Override
	public void setSekkeiCd(String sekkeiCd) {
		model.setSekkeiCd(sekkeiCd);
	}

	/**
	 * Sets the sekkei cd yy of this proj table.
	 *
	 * @param sekkeiCdYy the sekkei cd yy of this proj table
	 */
	@Override
	public void setSekkeiCdYy(String sekkeiCdYy) {
		model.setSekkeiCdYy(sekkeiCdYy);
	}

	/**
	 * Sets the sekkei togo saki of this proj table.
	 *
	 * @param sekkeiTogoSaki the sekkei togo saki of this proj table
	 */
	@Override
	public void setSekkeiTogoSaki(String sekkeiTogoSaki) {
		model.setSekkeiTogoSaki(sekkeiTogoSaki);
	}

	/**
	 * Sets the shukan sekkei cd of this proj table.
	 *
	 * @param shukanSekkeiCd the shukan sekkei cd of this proj table
	 */
	@Override
	public void setShukanSekkeiCd(String shukanSekkeiCd) {
		model.setShukanSekkeiCd(shukanSekkeiCd);
	}

	/**
	 * Sets the taketu chusi toketu kb of this proj table.
	 *
	 * @param taketuChusiToketuKb the taketu chusi toketu kb of this proj table
	 */
	@Override
	public void setTaketuChusiToketuKb(String taketuChusiToketuKb) {
		model.setTaketuChusiToketuKb(taketuChusiToketuKb);
	}

	/**
	 * Sets the torikesi kb of this proj table.
	 *
	 * @param torikesiKb the torikesi kb of this proj table
	 */
	@Override
	public void setTorikesiKb(String torikesiKb) {
		model.setTorikesiKb(torikesiKb);
	}

	/**
	 * Sets the upd date of this proj table.
	 *
	 * @param updDate the upd date of this proj table
	 */
	@Override
	public void setUpdDate(String updDate) {
		model.setUpdDate(updDate);
	}

	/**
	 * Sets the upd time of this proj table.
	 *
	 * @param updTime the upd time of this proj table
	 */
	@Override
	public void setUpdTime(String updTime) {
		model.setUpdTime(updTime);
	}

	/**
	 * Sets the yoso koji cd of this proj table.
	 *
	 * @param yosoKojiCd the yoso koji cd of this proj table
	 */
	@Override
	public void setYosoKojiCd(String yosoKojiCd) {
		model.setYosoKojiCd(yosoKojiCd);
	}

	@Override
	protected ProjTableWrapper wrap(ProjTable projTable) {
		return new ProjTableWrapper(projTable);
	}

}