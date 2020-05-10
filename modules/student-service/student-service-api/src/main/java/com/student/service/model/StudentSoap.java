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

package com.student.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.student.service.service.http.StudentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentSoap implements Serializable {

	public static StudentSoap toSoapModel(Student model) {
		StudentSoap soapModel = new StudentSoap();

		soapModel.setStudentId(model.getStudentId());
		soapModel.setStudentName(model.getStudentName());
		soapModel.setStudentNickName(model.getStudentNickName());
		soapModel.setStudentMobNo(model.getStudentMobNo());
		soapModel.setStudentGender(model.isStudentGender());
		soapModel.setStudentAge(model.getStudentAge());
		soapModel.setStudentDOB(model.getStudentDOB());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static StudentSoap[] toSoapModels(Student[] models) {
		StudentSoap[] soapModels = new StudentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[][] toSoapModels(Student[][] models) {
		StudentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[] toSoapModels(List<Student> models) {
		List<StudentSoap> soapModels = new ArrayList<StudentSoap>(
			models.size());

		for (Student model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentSoap[soapModels.size()]);
	}

	public StudentSoap() {
	}

	public long getPrimaryKey() {
		return _studentId;
	}

	public void setPrimaryKey(long pk) {
		setStudentId(pk);
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public String getStudentName() {
		return _studentName;
	}

	public void setStudentName(String studentName) {
		_studentName = studentName;
	}

	public String getStudentNickName() {
		return _studentNickName;
	}

	public void setStudentNickName(String studentNickName) {
		_studentNickName = studentNickName;
	}

	public long getStudentMobNo() {
		return _studentMobNo;
	}

	public void setStudentMobNo(long studentMobNo) {
		_studentMobNo = studentMobNo;
	}

	public boolean getStudentGender() {
		return _studentGender;
	}

	public boolean isStudentGender() {
		return _studentGender;
	}

	public void setStudentGender(boolean studentGender) {
		_studentGender = studentGender;
	}

	public int getStudentAge() {
		return _studentAge;
	}

	public void setStudentAge(int studentAge) {
		_studentAge = studentAge;
	}

	public Date getStudentDOB() {
		return _studentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		_studentDOB = studentDOB;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _studentId;
	private String _studentName;
	private String _studentNickName;
	private long _studentMobNo;
	private boolean _studentGender;
	private int _studentAge;
	private Date _studentDOB;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _groupId;

}