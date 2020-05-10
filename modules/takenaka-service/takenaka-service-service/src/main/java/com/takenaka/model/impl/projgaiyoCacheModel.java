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

import com.takenaka.model.projgaiyo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing projgaiyo in entity cache.
 *
 * @author Sanjay.Panchal
 * @generated
 */
public class projgaiyoCacheModel
	implements CacheModel<projgaiyo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof projgaiyoCacheModel)) {
			return false;
		}

		projgaiyoCacheModel projgaiyoCacheModel = (projgaiyoCacheModel)obj;

		if (groupId == projgaiyoCacheModel.groupId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, groupId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", projNm=");
		sb.append(projNm);
		sb.append(", projNmKana=");
		sb.append(projNmKana);
		sb.append(", kenchikuNusiCd=");
		sb.append(kenchikuNusiCd);
		sb.append(", kenchikuNusiNm=");
		sb.append(kenchikuNusiNm);
		sb.append(", kenchikuChiCd=");
		sb.append(kenchikuChiCd);
		sb.append(", kenchikuChiNm=");
		sb.append(kenchikuChiNm);
		sb.append(", tatemonoYoto1=");
		sb.append(tatemonoYoto1);
		sb.append(", tatemonoYoto2=");
		sb.append(tatemonoYoto2);
		sb.append(", tatemonoYoto3=");
		sb.append(tatemonoYoto3);
		sb.append(", kaisuB=");
		sb.append(kaisuB);
		sb.append(", kaisuF=");
		sb.append(kaisuF);
		sb.append(", kaisuP=");
		sb.append(kaisuP);
		sb.append(", kozoShubetu1=");
		sb.append(kozoShubetu1);
		sb.append(", kozoShubetu2=");
		sb.append(kozoShubetu2);
		sb.append(", kozoShubetu3=");
		sb.append(kozoShubetu3);
		sb.append(", nobeyukaMenseki=");
		sb.append(nobeyukaMenseki);
		sb.append(", kenchikuMenseki=");
		sb.append(kenchikuMenseki);
		sb.append(", chakkoBi=");
		sb.append(chakkoBi);
		sb.append(", shunkoBi=");
		sb.append(shunkoBi);
		sb.append(", sekkeiKb=");
		sb.append(sekkeiKb);
		sb.append(", sekoKb=");
		sb.append(sekoKb);
		sb.append(", sagyoshoChiku=");
		sb.append(sagyoshoChiku);
		sb.append(", updDate=");
		sb.append(updDate);
		sb.append(", updTime=");
		sb.append(updTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public projgaiyo toEntityModel() {
		projgaiyoImpl projgaiyoImpl = new projgaiyoImpl();

		if (uuid == null) {
			projgaiyoImpl.setUuid("");
		}
		else {
			projgaiyoImpl.setUuid(uuid);
		}

		projgaiyoImpl.setGroupId(groupId);

		if (projNm == null) {
			projgaiyoImpl.setProjNm("");
		}
		else {
			projgaiyoImpl.setProjNm(projNm);
		}

		if (projNmKana == null) {
			projgaiyoImpl.setProjNmKana("");
		}
		else {
			projgaiyoImpl.setProjNmKana(projNmKana);
		}

		if (kenchikuNusiCd == null) {
			projgaiyoImpl.setKenchikuNusiCd("");
		}
		else {
			projgaiyoImpl.setKenchikuNusiCd(kenchikuNusiCd);
		}

		if (kenchikuNusiNm == null) {
			projgaiyoImpl.setKenchikuNusiNm("");
		}
		else {
			projgaiyoImpl.setKenchikuNusiNm(kenchikuNusiNm);
		}

		if (kenchikuChiCd == null) {
			projgaiyoImpl.setKenchikuChiCd("");
		}
		else {
			projgaiyoImpl.setKenchikuChiCd(kenchikuChiCd);
		}

		if (kenchikuChiNm == null) {
			projgaiyoImpl.setKenchikuChiNm("");
		}
		else {
			projgaiyoImpl.setKenchikuChiNm(kenchikuChiNm);
		}

		if (tatemonoYoto1 == null) {
			projgaiyoImpl.setTatemonoYoto1("");
		}
		else {
			projgaiyoImpl.setTatemonoYoto1(tatemonoYoto1);
		}

		if (tatemonoYoto2 == null) {
			projgaiyoImpl.setTatemonoYoto2("");
		}
		else {
			projgaiyoImpl.setTatemonoYoto2(tatemonoYoto2);
		}

		if (tatemonoYoto3 == null) {
			projgaiyoImpl.setTatemonoYoto3("");
		}
		else {
			projgaiyoImpl.setTatemonoYoto3(tatemonoYoto3);
		}

		projgaiyoImpl.setKaisuB(kaisuB);
		projgaiyoImpl.setKaisuF(kaisuF);
		projgaiyoImpl.setKaisuP(kaisuP);

		if (kozoShubetu1 == null) {
			projgaiyoImpl.setKozoShubetu1("");
		}
		else {
			projgaiyoImpl.setKozoShubetu1(kozoShubetu1);
		}

		if (kozoShubetu2 == null) {
			projgaiyoImpl.setKozoShubetu2("");
		}
		else {
			projgaiyoImpl.setKozoShubetu2(kozoShubetu2);
		}

		if (kozoShubetu3 == null) {
			projgaiyoImpl.setKozoShubetu3("");
		}
		else {
			projgaiyoImpl.setKozoShubetu3(kozoShubetu3);
		}

		projgaiyoImpl.setNobeyukaMenseki(nobeyukaMenseki);
		projgaiyoImpl.setKenchikuMenseki(kenchikuMenseki);

		if (chakkoBi == null) {
			projgaiyoImpl.setChakkoBi("");
		}
		else {
			projgaiyoImpl.setChakkoBi(chakkoBi);
		}

		if (shunkoBi == null) {
			projgaiyoImpl.setShunkoBi("");
		}
		else {
			projgaiyoImpl.setShunkoBi(shunkoBi);
		}

		if (sekkeiKb == null) {
			projgaiyoImpl.setSekkeiKb("");
		}
		else {
			projgaiyoImpl.setSekkeiKb(sekkeiKb);
		}

		if (sekoKb == null) {
			projgaiyoImpl.setSekoKb("");
		}
		else {
			projgaiyoImpl.setSekoKb(sekoKb);
		}

		if (sagyoshoChiku == null) {
			projgaiyoImpl.setSagyoshoChiku("");
		}
		else {
			projgaiyoImpl.setSagyoshoChiku(sagyoshoChiku);
		}

		if (updDate == null) {
			projgaiyoImpl.setUpdDate("");
		}
		else {
			projgaiyoImpl.setUpdDate(updDate);
		}

		if (updTime == null) {
			projgaiyoImpl.setUpdTime("");
		}
		else {
			projgaiyoImpl.setUpdTime(updTime);
		}

		projgaiyoImpl.resetOriginalValues();

		return projgaiyoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		groupId = objectInput.readLong();
		projNm = objectInput.readUTF();
		projNmKana = objectInput.readUTF();
		kenchikuNusiCd = objectInput.readUTF();
		kenchikuNusiNm = objectInput.readUTF();
		kenchikuChiCd = objectInput.readUTF();
		kenchikuChiNm = objectInput.readUTF();
		tatemonoYoto1 = objectInput.readUTF();
		tatemonoYoto2 = objectInput.readUTF();
		tatemonoYoto3 = objectInput.readUTF();

		kaisuB = objectInput.readDouble();

		kaisuF = objectInput.readDouble();

		kaisuP = objectInput.readDouble();
		kozoShubetu1 = objectInput.readUTF();
		kozoShubetu2 = objectInput.readUTF();
		kozoShubetu3 = objectInput.readUTF();

		nobeyukaMenseki = objectInput.readDouble();

		kenchikuMenseki = objectInput.readDouble();
		chakkoBi = objectInput.readUTF();
		shunkoBi = objectInput.readUTF();
		sekkeiKb = objectInput.readUTF();
		sekoKb = objectInput.readUTF();
		sagyoshoChiku = objectInput.readUTF();
		updDate = objectInput.readUTF();
		updTime = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(groupId);

		if (projNm == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projNm);
		}

		if (projNmKana == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projNmKana);
		}

		if (kenchikuNusiCd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kenchikuNusiCd);
		}

		if (kenchikuNusiNm == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kenchikuNusiNm);
		}

		if (kenchikuChiCd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kenchikuChiCd);
		}

		if (kenchikuChiNm == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kenchikuChiNm);
		}

		if (tatemonoYoto1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tatemonoYoto1);
		}

		if (tatemonoYoto2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tatemonoYoto2);
		}

		if (tatemonoYoto3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tatemonoYoto3);
		}

		objectOutput.writeDouble(kaisuB);

		objectOutput.writeDouble(kaisuF);

		objectOutput.writeDouble(kaisuP);

		if (kozoShubetu1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kozoShubetu1);
		}

		if (kozoShubetu2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kozoShubetu2);
		}

		if (kozoShubetu3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kozoShubetu3);
		}

		objectOutput.writeDouble(nobeyukaMenseki);

		objectOutput.writeDouble(kenchikuMenseki);

		if (chakkoBi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chakkoBi);
		}

		if (shunkoBi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shunkoBi);
		}

		if (sekkeiKb == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sekkeiKb);
		}

		if (sekoKb == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sekoKb);
		}

		if (sagyoshoChiku == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sagyoshoChiku);
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

	public String uuid;
	public long groupId;
	public String projNm;
	public String projNmKana;
	public String kenchikuNusiCd;
	public String kenchikuNusiNm;
	public String kenchikuChiCd;
	public String kenchikuChiNm;
	public String tatemonoYoto1;
	public String tatemonoYoto2;
	public String tatemonoYoto3;
	public double kaisuB;
	public double kaisuF;
	public double kaisuP;
	public String kozoShubetu1;
	public String kozoShubetu2;
	public String kozoShubetu3;
	public double nobeyukaMenseki;
	public double kenchikuMenseki;
	public String chakkoBi;
	public String shunkoBi;
	public String sekkeiKb;
	public String sekoKb;
	public String sagyoshoChiku;
	public String updDate;
	public String updTime;

}