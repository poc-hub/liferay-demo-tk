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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Student service. Represents a row in the &quot;STUDENT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.student.service.model.impl.StudentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.student.service.model.impl.StudentImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
@ProviderType
public interface StudentModel
	extends BaseModel<Student>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a student model instance should use the {@link Student} interface instead.
	 */

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the student ID of this student.
	 *
	 * @return the student ID of this student
	 */
	public long getStudentId();

	/**
	 * Sets the student ID of this student.
	 *
	 * @param studentId the student ID of this student
	 */
	public void setStudentId(long studentId);

	/**
	 * Returns the student name of this student.
	 *
	 * @return the student name of this student
	 */
	@AutoEscape
	public String getStudentName();

	/**
	 * Sets the student name of this student.
	 *
	 * @param studentName the student name of this student
	 */
	public void setStudentName(String studentName);

	/**
	 * Returns the student nick name of this student.
	 *
	 * @return the student nick name of this student
	 */
	@AutoEscape
	public String getStudentNickName();

	/**
	 * Sets the student nick name of this student.
	 *
	 * @param studentNickName the student nick name of this student
	 */
	public void setStudentNickName(String studentNickName);

	/**
	 * Returns the student mob no of this student.
	 *
	 * @return the student mob no of this student
	 */
	public long getStudentMobNo();

	/**
	 * Sets the student mob no of this student.
	 *
	 * @param studentMobNo the student mob no of this student
	 */
	public void setStudentMobNo(long studentMobNo);

	/**
	 * Returns the student gender of this student.
	 *
	 * @return the student gender of this student
	 */
	public boolean getStudentGender();

	/**
	 * Returns <code>true</code> if this student is student gender.
	 *
	 * @return <code>true</code> if this student is student gender; <code>false</code> otherwise
	 */
	public boolean isStudentGender();

	/**
	 * Sets whether this student is student gender.
	 *
	 * @param studentGender the student gender of this student
	 */
	public void setStudentGender(boolean studentGender);

	/**
	 * Returns the student age of this student.
	 *
	 * @return the student age of this student
	 */
	public int getStudentAge();

	/**
	 * Sets the student age of this student.
	 *
	 * @param studentAge the student age of this student
	 */
	public void setStudentAge(int studentAge);

	/**
	 * Returns the student dob of this student.
	 *
	 * @return the student dob of this student
	 */
	public Date getStudentDOB();

	/**
	 * Sets the student dob of this student.
	 *
	 * @param studentDOB the student dob of this student
	 */
	public void setStudentDOB(Date studentDOB);

	/**
	 * Returns the company ID of this student.
	 *
	 * @return the company ID of this student
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this student.
	 *
	 * @param companyId the company ID of this student
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this student.
	 *
	 * @return the user ID of this student
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this student.
	 *
	 * @param userId the user ID of this student
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this student.
	 *
	 * @return the user uuid of this student
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this student.
	 *
	 * @param userUuid the user uuid of this student
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this student.
	 *
	 * @return the user name of this student
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this student.
	 *
	 * @param userName the user name of this student
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this student.
	 *
	 * @return the create date of this student
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this student.
	 *
	 * @param createDate the create date of this student
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this student.
	 *
	 * @return the modified date of this student
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this student.
	 *
	 * @param modifiedDate the modified date of this student
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the group ID of this student.
	 *
	 * @return the group ID of this student
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this student.
	 *
	 * @param groupId the group ID of this student
	 */
	@Override
	public void setGroupId(long groupId);

}