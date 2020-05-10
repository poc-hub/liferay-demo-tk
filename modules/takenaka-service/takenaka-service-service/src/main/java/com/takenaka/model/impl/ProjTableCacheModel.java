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

import com.takenaka.model.ProjTable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProjTable in entity cache.
 *
 * @author Sanjay.Panchal
 * @generated
 */
public class ProjTableCacheModel
	implements CacheModel<ProjTable>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjTableCacheModel)) {
			return false;
		}

		ProjTableCacheModel projTableCacheModel = (ProjTableCacheModel)obj;

		if (recId == projTableCacheModel.recId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, recId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(71);

		sb.append("{recId=");
		sb.append(recId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", groupFlag=");
		sb.append(groupFlag);
		sb.append(", yosoKojiCd=");
		sb.append(yosoKojiCd);
		sb.append(", sekkeiCd=");
		sb.append(sekkeiCd);
		sb.append(", sekkeiCdYy=");
		sb.append(sekkeiCdYy);
		sb.append(", mitumoriNendo=");
		sb.append(mitumoriNendo);
		sb.append(", mitumoriCd=");
		sb.append(mitumoriCd);
		sb.append(", kojiCd=");
		sb.append(kojiCd);
		sb.append(", mitumoriSeiriNo=");
		sb.append(mitumoriSeiriNo);
		sb.append(", shukanSekkeiCd=");
		sb.append(shukanSekkeiCd);
		sb.append(", sekkeiTogoSaki=");
		sb.append(sekkeiTogoSaki);
		sb.append(", sekkeiBunkatuMoto=");
		sb.append(sekkeiBunkatuMoto);
		sb.append(", jutakuSekkeiTaisho=");
		sb.append(jutakuSekkeiTaisho);
		sb.append(", honsitenRid=");
		sb.append(honsitenRid);
		sb.append(", honsitenGid=");
		sb.append(honsitenGid);
		sb.append(", orgYkoji=");
		sb.append(orgYkoji);
		sb.append(", orgJKOJI=");
		sb.append(orgJKOJI);
		sb.append(", orgMdd=");
		sb.append(orgMdd);
		sb.append(", orgPdd=");
		sb.append(orgPdd);
		sb.append(", orgEsmas=");
		sb.append(orgEsmas);
		sb.append(", orgPrist=");
		sb.append(orgPrist);
		sb.append(", procSekkei=");
		sb.append(procSekkei);
		sb.append(", procMitumori=");
		sb.append(procMitumori);
		sb.append(", procSekkeiOen=");
		sb.append(procSekkeiOen);
		sb.append(", procSekkeiTogo=");
		sb.append(procSekkeiTogo);
		sb.append(", procSekkeiBunkatu=");
		sb.append(procSekkeiBunkatu);
		sb.append(", procSekkeiJutaku=");
		sb.append(procSekkeiJutaku);
		sb.append(", taketuChusiToketuKb=");
		sb.append(taketuChusiToketuKb);
		sb.append(", kanryoChusiStatus=");
		sb.append(kanryoChusiStatus);
		sb.append(", mitumoriKeijoShubetu=");
		sb.append(mitumoriKeijoShubetu);
		sb.append(", torikesiKb=");
		sb.append(torikesiKb);
		sb.append(", kessanNendo=");
		sb.append(kessanNendo);
		sb.append(", updDate=");
		sb.append(updDate);
		sb.append(", updTime=");
		sb.append(updTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjTable toEntityModel() {
		ProjTableImpl projTableImpl = new ProjTableImpl();

		projTableImpl.setRecId(recId);
		projTableImpl.setGroupId(groupId);

		if (groupFlag == null) {
			projTableImpl.setGroupFlag("");
		}
		else {
			projTableImpl.setGroupFlag(groupFlag);
		}

		if (yosoKojiCd == null) {
			projTableImpl.setYosoKojiCd("");
		}
		else {
			projTableImpl.setYosoKojiCd(yosoKojiCd);
		}

		if (sekkeiCd == null) {
			projTableImpl.setSekkeiCd("");
		}
		else {
			projTableImpl.setSekkeiCd(sekkeiCd);
		}

		if (sekkeiCdYy == null) {
			projTableImpl.setSekkeiCdYy("");
		}
		else {
			projTableImpl.setSekkeiCdYy(sekkeiCdYy);
		}

		if (mitumoriNendo == null) {
			projTableImpl.setMitumoriNendo("");
		}
		else {
			projTableImpl.setMitumoriNendo(mitumoriNendo);
		}

		if (mitumoriCd == null) {
			projTableImpl.setMitumoriCd("");
		}
		else {
			projTableImpl.setMitumoriCd(mitumoriCd);
		}

		if (kojiCd == null) {
			projTableImpl.setKojiCd("");
		}
		else {
			projTableImpl.setKojiCd(kojiCd);
		}

		if (mitumoriSeiriNo == null) {
			projTableImpl.setMitumoriSeiriNo("");
		}
		else {
			projTableImpl.setMitumoriSeiriNo(mitumoriSeiriNo);
		}

		if (shukanSekkeiCd == null) {
			projTableImpl.setShukanSekkeiCd("");
		}
		else {
			projTableImpl.setShukanSekkeiCd(shukanSekkeiCd);
		}

		if (sekkeiTogoSaki == null) {
			projTableImpl.setSekkeiTogoSaki("");
		}
		else {
			projTableImpl.setSekkeiTogoSaki(sekkeiTogoSaki);
		}

		if (sekkeiBunkatuMoto == null) {
			projTableImpl.setSekkeiBunkatuMoto("");
		}
		else {
			projTableImpl.setSekkeiBunkatuMoto(sekkeiBunkatuMoto);
		}

		if (jutakuSekkeiTaisho == null) {
			projTableImpl.setJutakuSekkeiTaisho("");
		}
		else {
			projTableImpl.setJutakuSekkeiTaisho(jutakuSekkeiTaisho);
		}

		if (honsitenRid == null) {
			projTableImpl.setHonsitenRid("");
		}
		else {
			projTableImpl.setHonsitenRid(honsitenRid);
		}

		if (honsitenGid == null) {
			projTableImpl.setHonsitenGid("");
		}
		else {
			projTableImpl.setHonsitenGid(honsitenGid);
		}

		if (orgYkoji == null) {
			projTableImpl.setOrgYkoji("");
		}
		else {
			projTableImpl.setOrgYkoji(orgYkoji);
		}

		if (orgJKOJI == null) {
			projTableImpl.setOrgJKOJI("");
		}
		else {
			projTableImpl.setOrgJKOJI(orgJKOJI);
		}

		if (orgMdd == null) {
			projTableImpl.setOrgMdd("");
		}
		else {
			projTableImpl.setOrgMdd(orgMdd);
		}

		if (orgPdd == null) {
			projTableImpl.setOrgPdd("");
		}
		else {
			projTableImpl.setOrgPdd(orgPdd);
		}

		if (orgEsmas == null) {
			projTableImpl.setOrgEsmas("");
		}
		else {
			projTableImpl.setOrgEsmas(orgEsmas);
		}

		if (orgPrist == null) {
			projTableImpl.setOrgPrist("");
		}
		else {
			projTableImpl.setOrgPrist(orgPrist);
		}

		if (procSekkei == null) {
			projTableImpl.setProcSekkei("");
		}
		else {
			projTableImpl.setProcSekkei(procSekkei);
		}

		if (procMitumori == null) {
			projTableImpl.setProcMitumori("");
		}
		else {
			projTableImpl.setProcMitumori(procMitumori);
		}

		if (procSekkeiOen == null) {
			projTableImpl.setProcSekkeiOen("");
		}
		else {
			projTableImpl.setProcSekkeiOen(procSekkeiOen);
		}

		if (procSekkeiTogo == null) {
			projTableImpl.setProcSekkeiTogo("");
		}
		else {
			projTableImpl.setProcSekkeiTogo(procSekkeiTogo);
		}

		if (procSekkeiBunkatu == null) {
			projTableImpl.setProcSekkeiBunkatu("");
		}
		else {
			projTableImpl.setProcSekkeiBunkatu(procSekkeiBunkatu);
		}

		if (procSekkeiJutaku == null) {
			projTableImpl.setProcSekkeiJutaku("");
		}
		else {
			projTableImpl.setProcSekkeiJutaku(procSekkeiJutaku);
		}

		if (taketuChusiToketuKb == null) {
			projTableImpl.setTaketuChusiToketuKb("");
		}
		else {
			projTableImpl.setTaketuChusiToketuKb(taketuChusiToketuKb);
		}

		if (kanryoChusiStatus == null) {
			projTableImpl.setKanryoChusiStatus("");
		}
		else {
			projTableImpl.setKanryoChusiStatus(kanryoChusiStatus);
		}

		if (mitumoriKeijoShubetu == null) {
			projTableImpl.setMitumoriKeijoShubetu("");
		}
		else {
			projTableImpl.setMitumoriKeijoShubetu(mitumoriKeijoShubetu);
		}

		if (torikesiKb == null) {
			projTableImpl.setTorikesiKb("");
		}
		else {
			projTableImpl.setTorikesiKb(torikesiKb);
		}

		if (kessanNendo == null) {
			projTableImpl.setKessanNendo("");
		}
		else {
			projTableImpl.setKessanNendo(kessanNendo);
		}

		if (updDate == null) {
			projTableImpl.setUpdDate("");
		}
		else {
			projTableImpl.setUpdDate(updDate);
		}

		if (updTime == null) {
			projTableImpl.setUpdTime("");
		}
		else {
			projTableImpl.setUpdTime(updTime);
		}

		projTableImpl.resetOriginalValues();

		return projTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		recId = objectInput.readLong();

		groupId = objectInput.readLong();
		groupFlag = objectInput.readUTF();
		yosoKojiCd = objectInput.readUTF();
		sekkeiCd = objectInput.readUTF();
		sekkeiCdYy = objectInput.readUTF();
		mitumoriNendo = objectInput.readUTF();
		mitumoriCd = objectInput.readUTF();
		kojiCd = objectInput.readUTF();
		mitumoriSeiriNo = objectInput.readUTF();
		shukanSekkeiCd = objectInput.readUTF();
		sekkeiTogoSaki = objectInput.readUTF();
		sekkeiBunkatuMoto = objectInput.readUTF();
		jutakuSekkeiTaisho = objectInput.readUTF();
		honsitenRid = objectInput.readUTF();
		honsitenGid = objectInput.readUTF();
		orgYkoji = objectInput.readUTF();
		orgJKOJI = objectInput.readUTF();
		orgMdd = objectInput.readUTF();
		orgPdd = objectInput.readUTF();
		orgEsmas = objectInput.readUTF();
		orgPrist = objectInput.readUTF();
		procSekkei = objectInput.readUTF();
		procMitumori = objectInput.readUTF();
		procSekkeiOen = objectInput.readUTF();
		procSekkeiTogo = objectInput.readUTF();
		procSekkeiBunkatu = objectInput.readUTF();
		procSekkeiJutaku = objectInput.readUTF();
		taketuChusiToketuKb = objectInput.readUTF();
		kanryoChusiStatus = objectInput.readUTF();
		mitumoriKeijoShubetu = objectInput.readUTF();
		torikesiKb = objectInput.readUTF();
		kessanNendo = objectInput.readUTF();
		updDate = objectInput.readUTF();
		updTime = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(recId);

		objectOutput.writeLong(groupId);

		if (groupFlag == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(groupFlag);
		}

		if (yosoKojiCd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(yosoKojiCd);
		}

		if (sekkeiCd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sekkeiCd);
		}

		if (sekkeiCdYy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sekkeiCdYy);
		}

		if (mitumoriNendo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mitumoriNendo);
		}

		if (mitumoriCd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mitumoriCd);
		}

		if (kojiCd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kojiCd);
		}

		if (mitumoriSeiriNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mitumoriSeiriNo);
		}

		if (shukanSekkeiCd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shukanSekkeiCd);
		}

		if (sekkeiTogoSaki == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sekkeiTogoSaki);
		}

		if (sekkeiBunkatuMoto == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sekkeiBunkatuMoto);
		}

		if (jutakuSekkeiTaisho == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jutakuSekkeiTaisho);
		}

		if (honsitenRid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(honsitenRid);
		}

		if (honsitenGid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(honsitenGid);
		}

		if (orgYkoji == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(orgYkoji);
		}

		if (orgJKOJI == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(orgJKOJI);
		}

		if (orgMdd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(orgMdd);
		}

		if (orgPdd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(orgPdd);
		}

		if (orgEsmas == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(orgEsmas);
		}

		if (orgPrist == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(orgPrist);
		}

		if (procSekkei == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procSekkei);
		}

		if (procMitumori == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procMitumori);
		}

		if (procSekkeiOen == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procSekkeiOen);
		}

		if (procSekkeiTogo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procSekkeiTogo);
		}

		if (procSekkeiBunkatu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procSekkeiBunkatu);
		}

		if (procSekkeiJutaku == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procSekkeiJutaku);
		}

		if (taketuChusiToketuKb == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taketuChusiToketuKb);
		}

		if (kanryoChusiStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kanryoChusiStatus);
		}

		if (mitumoriKeijoShubetu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mitumoriKeijoShubetu);
		}

		if (torikesiKb == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(torikesiKb);
		}

		if (kessanNendo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kessanNendo);
		}

		if (updDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updDate);
		}

		if (updTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updTime);
		}
	}

	public long recId;
	public long groupId;
	public String groupFlag;
	public String yosoKojiCd;
	public String sekkeiCd;
	public String sekkeiCdYy;
	public String mitumoriNendo;
	public String mitumoriCd;
	public String kojiCd;
	public String mitumoriSeiriNo;
	public String shukanSekkeiCd;
	public String sekkeiTogoSaki;
	public String sekkeiBunkatuMoto;
	public String jutakuSekkeiTaisho;
	public String honsitenRid;
	public String honsitenGid;
	public String orgYkoji;
	public String orgJKOJI;
	public String orgMdd;
	public String orgPdd;
	public String orgEsmas;
	public String orgPrist;
	public String procSekkei;
	public String procMitumori;
	public String procSekkeiOen;
	public String procSekkeiTogo;
	public String procSekkeiBunkatu;
	public String procSekkeiJutaku;
	public String taketuChusiToketuKb;
	public String kanryoChusiStatus;
	public String mitumoriKeijoShubetu;
	public String torikesiKb;
	public String kessanNendo;
	public String updDate;
	public String updTime;

}