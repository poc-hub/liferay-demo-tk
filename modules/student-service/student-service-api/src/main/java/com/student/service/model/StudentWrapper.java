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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
public class StudentWrapper
	extends BaseModelWrapper<Student>
	implements ModelWrapper<Student>, Student {

	public StudentWrapper(Student student) {
		super(student);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("studentId", getStudentId());
		attributes.put("studentName", getStudentName());
		attributes.put("studentNickName", getStudentNickName());
		attributes.put("studentMobNo", getStudentMobNo());
		attributes.put("studentGender", isStudentGender());
		attributes.put("studentAge", getStudentAge());
		attributes.put("studentDOB", getStudentDOB());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		String studentName = (String)attributes.get("studentName");

		if (studentName != null) {
			setStudentName(studentName);
		}

		String studentNickName = (String)attributes.get("studentNickName");

		if (studentNickName != null) {
			setStudentNickName(studentNickName);
		}

		Long studentMobNo = (Long)attributes.get("studentMobNo");

		if (studentMobNo != null) {
			setStudentMobNo(studentMobNo);
		}

		Boolean studentGender = (Boolean)attributes.get("studentGender");

		if (studentGender != null) {
			setStudentGender(studentGender);
		}

		Integer studentAge = (Integer)attributes.get("studentAge");

		if (studentAge != null) {
			setStudentAge(studentAge);
		}

		Date studentDOB = (Date)attributes.get("studentDOB");

		if (studentDOB != null) {
			setStudentDOB(studentDOB);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	 * Returns the company ID of this student.
	 *
	 * @return the company ID of this student
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this student.
	 *
	 * @return the create date of this student
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this student.
	 *
	 * @return the group ID of this student
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this student.
	 *
	 * @return the modified date of this student
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the student age of this student.
	 *
	 * @return the student age of this student
	 */
	@Override
	public int getStudentAge() {
		return model.getStudentAge();
	}

	/**
	 * Returns the student dob of this student.
	 *
	 * @return the student dob of this student
	 */
	@Override
	public Date getStudentDOB() {
		return model.getStudentDOB();
	}

	/**
	 * Returns the student gender of this student.
	 *
	 * @return the student gender of this student
	 */
	@Override
	public boolean getStudentGender() {
		return model.getStudentGender();
	}

	/**
	 * Returns the student ID of this student.
	 *
	 * @return the student ID of this student
	 */
	@Override
	public long getStudentId() {
		return model.getStudentId();
	}

	/**
	 * Returns the student mob no of this student.
	 *
	 * @return the student mob no of this student
	 */
	@Override
	public long getStudentMobNo() {
		return model.getStudentMobNo();
	}

	/**
	 * Returns the student name of this student.
	 *
	 * @return the student name of this student
	 */
	@Override
	public String getStudentName() {
		return model.getStudentName();
	}

	/**
	 * Returns the student nick name of this student.
	 *
	 * @return the student nick name of this student
	 */
	@Override
	public String getStudentNickName() {
		return model.getStudentNickName();
	}

	/**
	 * Returns the user ID of this student.
	 *
	 * @return the user ID of this student
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this student.
	 *
	 * @return the user name of this student
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this student.
	 *
	 * @return the user uuid of this student
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this student is student gender.
	 *
	 * @return <code>true</code> if this student is student gender; <code>false</code> otherwise
	 */
	@Override
	public boolean isStudentGender() {
		return model.isStudentGender();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this student.
	 *
	 * @param companyId the company ID of this student
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this student.
	 *
	 * @param createDate the create date of this student
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this student.
	 *
	 * @param groupId the group ID of this student
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this student.
	 *
	 * @param modifiedDate the modified date of this student
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the student age of this student.
	 *
	 * @param studentAge the student age of this student
	 */
	@Override
	public void setStudentAge(int studentAge) {
		model.setStudentAge(studentAge);
	}

	/**
	 * Sets the student dob of this student.
	 *
	 * @param studentDOB the student dob of this student
	 */
	@Override
	public void setStudentDOB(Date studentDOB) {
		model.setStudentDOB(studentDOB);
	}

	/**
	 * Sets whether this student is student gender.
	 *
	 * @param studentGender the student gender of this student
	 */
	@Override
	public void setStudentGender(boolean studentGender) {
		model.setStudentGender(studentGender);
	}

	/**
	 * Sets the student ID of this student.
	 *
	 * @param studentId the student ID of this student
	 */
	@Override
	public void setStudentId(long studentId) {
		model.setStudentId(studentId);
	}

	/**
	 * Sets the student mob no of this student.
	 *
	 * @param studentMobNo the student mob no of this student
	 */
	@Override
	public void setStudentMobNo(long studentMobNo) {
		model.setStudentMobNo(studentMobNo);
	}

	/**
	 * Sets the student name of this student.
	 *
	 * @param studentName the student name of this student
	 */
	@Override
	public void setStudentName(String studentName) {
		model.setStudentName(studentName);
	}

	/**
	 * Sets the student nick name of this student.
	 *
	 * @param studentNickName the student nick name of this student
	 */
	@Override
	public void setStudentNickName(String studentNickName) {
		model.setStudentNickName(studentNickName);
	}

	/**
	 * Sets the user ID of this student.
	 *
	 * @param userId the user ID of this student
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this student.
	 *
	 * @param userName the user name of this student
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this student.
	 *
	 * @param userUuid the user uuid of this student
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected StudentWrapper wrap(Student student) {
		return new StudentWrapper(student);
	}

}