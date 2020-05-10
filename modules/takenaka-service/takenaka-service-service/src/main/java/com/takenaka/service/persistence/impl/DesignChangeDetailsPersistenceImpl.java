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

package com.takenaka.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;

import com.takenaka.exception.NoSuchDesignChangeDetailsException;
import com.takenaka.model.DesignChangeDetails;
import com.takenaka.model.impl.DesignChangeDetailsImpl;
import com.takenaka.model.impl.DesignChangeDetailsModelImpl;
import com.takenaka.service.persistence.DesignChangeDetailsPersistence;
import com.takenaka.service.persistence.impl.constants.takenakaPersistenceConstants;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the design change details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @generated
 */
@Component(service = DesignChangeDetailsPersistence.class)
public class DesignChangeDetailsPersistenceImpl
	extends BasePersistenceImpl<DesignChangeDetails>
	implements DesignChangeDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DesignChangeDetailsUtil</code> to access the design change details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DesignChangeDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DesignChangeDetailsPersistenceImpl() {
		setModelClass(DesignChangeDetails.class);

		setModelImplClass(DesignChangeDetailsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("dcrChangeSeqno", "DCR_CHANGE_SEQNO");
		dbColumnNames.put("designchangeSubseqno", "DESIGNCHANGE_SUBSEQNO");
		dbColumnNames.put("groupId", "GROUP_ID");
		dbColumnNames.put("revisionNo", "REVISION_NO");
		dbColumnNames.put("meetingId", "MEETING_ID");
		dbColumnNames.put("issuer", "ISSUER");
		dbColumnNames.put("changeType", "CHANGETYPE");
		dbColumnNames.put("changeRequestby", "CHANGEREQUESTBY");
		dbColumnNames.put("rfcId", "RFC_ID");
		dbColumnNames.put("rfcOthers", "RFC_OTHERS");
		dbColumnNames.put("rangeOfDisclosure", "RANGE_OF_DISCLOSURE");
		dbColumnNames.put("floor", "FLOOR");
		dbColumnNames.put("item", "ITEM");
		dbColumnNames.put("originaldesginDetail", "ORIGINALDESGIN_DETAIL");
		dbColumnNames.put("changeDetail", "CHANGE_DETAIL");
		dbColumnNames.put("action", "ACTION");
		dbColumnNames.put("estdesignCosttype", "ESTDESIGN_COSTTYPE");
		dbColumnNames.put("estdesignCost", "ESTDESIGN_COST");
		dbColumnNames.put(
			"estconstructionCosttype", "ESTCONSTRUCTION_COSTTYPE");
		dbColumnNames.put("estconstructionCost", "ESTCONSTRUCTION_COST");
		dbColumnNames.put(
			"expenseAjustmentDivision", "EXPENSE_AJUSTMENT_DIVISION");
		dbColumnNames.put("attachmentId1", "ATTACHMENT_ID_1");
		dbColumnNames.put("attachmentId2", "ATTACHMENT_ID_2");
		dbColumnNames.put("attachmentId3", "ATTACHMENT_ID_3");
		dbColumnNames.put("attachmentId4", "ATTACHMENT_ID_4");
		dbColumnNames.put("attachment1", "ATTACHMENT1");
		dbColumnNames.put("attachment2", "ATTACHMENT2");
		dbColumnNames.put("attachment3", "ATTACHMENT3");
		dbColumnNames.put("attachment4", "ATTACHMENT4");
		dbColumnNames.put("responsePeriod", "RESPONSE_PERIOD");
		dbColumnNames.put("personInCharge", "PERSON_IN_CHARGE");
		dbColumnNames.put("approvalNo", "APPROVAL_NO");
		dbColumnNames.put("approvalStatus", "APPROVAL_STATUS");
		dbColumnNames.put("approvalDate", "APPROVAL_DATE");
		dbColumnNames.put("clientApprovalStatus", "CLIENT_APPROVAL_STATUS");
		dbColumnNames.put("clientApprovalDate", "CLIENT_APPROVAL_DATE");
		dbColumnNames.put("constructionStatus", "CONSTRUCTION_STATUS");
		dbColumnNames.put("constructionDate", "CONSTRUCTION_DATE");
		dbColumnNames.put("createdBy", "CREATED_BY");
		dbColumnNames.put("createdOn", "CREATED_ON");
		dbColumnNames.put("modifiedBy", "MODIFIED_BY");
		dbColumnNames.put("modifiedOn", "MODIFIED_ON");
		dbColumnNames.put("isActive", "IS_ACTIVE");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the design change details in the entity cache if it is enabled.
	 *
	 * @param designChangeDetails the design change details
	 */
	@Override
	public void cacheResult(DesignChangeDetails designChangeDetails) {
		entityCache.putResult(
			entityCacheEnabled, DesignChangeDetailsImpl.class,
			designChangeDetails.getPrimaryKey(), designChangeDetails);

		designChangeDetails.resetOriginalValues();
	}

	/**
	 * Caches the design change detailses in the entity cache if it is enabled.
	 *
	 * @param designChangeDetailses the design change detailses
	 */
	@Override
	public void cacheResult(List<DesignChangeDetails> designChangeDetailses) {
		for (DesignChangeDetails designChangeDetails : designChangeDetailses) {
			if (entityCache.getResult(
					entityCacheEnabled, DesignChangeDetailsImpl.class,
					designChangeDetails.getPrimaryKey()) == null) {

				cacheResult(designChangeDetails);
			}
			else {
				designChangeDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all design change detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DesignChangeDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the design change details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DesignChangeDetails designChangeDetails) {
		entityCache.removeResult(
			entityCacheEnabled, DesignChangeDetailsImpl.class,
			designChangeDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DesignChangeDetails> designChangeDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DesignChangeDetails designChangeDetails : designChangeDetailses) {
			entityCache.removeResult(
				entityCacheEnabled, DesignChangeDetailsImpl.class,
				designChangeDetails.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DesignChangeDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new design change details with the primary key. Does not add the design change details to the database.
	 *
	 * @param dcrChangeSeqno the primary key for the new design change details
	 * @return the new design change details
	 */
	@Override
	public DesignChangeDetails create(long dcrChangeSeqno) {
		DesignChangeDetails designChangeDetails = new DesignChangeDetailsImpl();

		designChangeDetails.setNew(true);
		designChangeDetails.setPrimaryKey(dcrChangeSeqno);

		return designChangeDetails;
	}

	/**
	 * Removes the design change details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details that was removed
	 * @throws NoSuchDesignChangeDetailsException if a design change details with the primary key could not be found
	 */
	@Override
	public DesignChangeDetails remove(long dcrChangeSeqno)
		throws NoSuchDesignChangeDetailsException {

		return remove((Serializable)dcrChangeSeqno);
	}

	/**
	 * Removes the design change details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the design change details
	 * @return the design change details that was removed
	 * @throws NoSuchDesignChangeDetailsException if a design change details with the primary key could not be found
	 */
	@Override
	public DesignChangeDetails remove(Serializable primaryKey)
		throws NoSuchDesignChangeDetailsException {

		Session session = null;

		try {
			session = openSession();

			DesignChangeDetails designChangeDetails =
				(DesignChangeDetails)session.get(
					DesignChangeDetailsImpl.class, primaryKey);

			if (designChangeDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignChangeDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(designChangeDetails);
		}
		catch (NoSuchDesignChangeDetailsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DesignChangeDetails removeImpl(
		DesignChangeDetails designChangeDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designChangeDetails)) {
				designChangeDetails = (DesignChangeDetails)session.get(
					DesignChangeDetailsImpl.class,
					designChangeDetails.getPrimaryKeyObj());
			}

			if (designChangeDetails != null) {
				session.delete(designChangeDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (designChangeDetails != null) {
			clearCache(designChangeDetails);
		}

		return designChangeDetails;
	}

	@Override
	public DesignChangeDetails updateImpl(
		DesignChangeDetails designChangeDetails) {

		boolean isNew = designChangeDetails.isNew();

		Session session = null;

		try {
			session = openSession();

			if (designChangeDetails.isNew()) {
				session.save(designChangeDetails);

				designChangeDetails.setNew(false);
			}
			else {
				designChangeDetails = (DesignChangeDetails)session.merge(
					designChangeDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, DesignChangeDetailsImpl.class,
			designChangeDetails.getPrimaryKey(), designChangeDetails, false);

		designChangeDetails.resetOriginalValues();

		return designChangeDetails;
	}

	/**
	 * Returns the design change details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the design change details
	 * @return the design change details
	 * @throws NoSuchDesignChangeDetailsException if a design change details with the primary key could not be found
	 */
	@Override
	public DesignChangeDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignChangeDetailsException {

		DesignChangeDetails designChangeDetails = fetchByPrimaryKey(primaryKey);

		if (designChangeDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignChangeDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return designChangeDetails;
	}

	/**
	 * Returns the design change details with the primary key or throws a <code>NoSuchDesignChangeDetailsException</code> if it could not be found.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details
	 * @throws NoSuchDesignChangeDetailsException if a design change details with the primary key could not be found
	 */
	@Override
	public DesignChangeDetails findByPrimaryKey(long dcrChangeSeqno)
		throws NoSuchDesignChangeDetailsException {

		return findByPrimaryKey((Serializable)dcrChangeSeqno);
	}

	/**
	 * Returns the design change details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dcrChangeSeqno the primary key of the design change details
	 * @return the design change details, or <code>null</code> if a design change details with the primary key could not be found
	 */
	@Override
	public DesignChangeDetails fetchByPrimaryKey(long dcrChangeSeqno) {
		return fetchByPrimaryKey((Serializable)dcrChangeSeqno);
	}

	/**
	 * Returns all the design change detailses.
	 *
	 * @return the design change detailses
	 */
	@Override
	public List<DesignChangeDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @return the range of design change detailses
	 */
	@Override
	public List<DesignChangeDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of design change detailses
	 */
	@Override
	public List<DesignChangeDetails> findAll(
		int start, int end,
		OrderByComparator<DesignChangeDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the design change detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignChangeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of design change detailses
	 * @param end the upper bound of the range of design change detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of design change detailses
	 */
	@Override
	public List<DesignChangeDetails> findAll(
		int start, int end,
		OrderByComparator<DesignChangeDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DesignChangeDetails> list = null;

		if (useFinderCache) {
			list = (List<DesignChangeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DESIGNCHANGEDETAILS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNCHANGEDETAILS;

				sql = sql.concat(DesignChangeDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<DesignChangeDetails>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the design change detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DesignChangeDetails designChangeDetails : findAll()) {
			remove(designChangeDetails);
		}
	}

	/**
	 * Returns the number of design change detailses.
	 *
	 * @return the number of design change detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DESIGNCHANGEDETAILS);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "DCR_CHANGE_SEQNO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESIGNCHANGEDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DesignChangeDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the design change details persistence.
	 */
	@Activate
	public void activate() {
		DesignChangeDetailsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DesignChangeDetailsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DesignChangeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DesignChangeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DesignChangeDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = takenakaPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.takenaka.model.DesignChangeDetails"),
			true);
	}

	@Override
	@Reference(
		target = takenakaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = takenakaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DESIGNCHANGEDETAILS =
		"SELECT designChangeDetails FROM DesignChangeDetails designChangeDetails";

	private static final String _SQL_COUNT_DESIGNCHANGEDETAILS =
		"SELECT COUNT(designChangeDetails) FROM DesignChangeDetails designChangeDetails";

	private static final String _ORDER_BY_ENTITY_ALIAS = "designChangeDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DesignChangeDetails exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DesignChangeDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"dcrChangeSeqno", "designchangeSubseqno", "groupId", "revisionNo",
			"meetingId", "issuer", "changeType", "changeRequestby", "rfcId",
			"rfcOthers", "rangeOfDisclosure", "floor", "item",
			"originaldesginDetail", "changeDetail", "action",
			"estdesignCosttype", "estdesignCost", "estconstructionCosttype",
			"estconstructionCost", "expenseAjustmentDivision", "attachmentId1",
			"attachmentId2", "attachmentId3", "attachmentId4", "attachment1",
			"attachment2", "attachment3", "attachment4", "responsePeriod",
			"personInCharge", "approvalNo", "approvalStatus", "approvalDate",
			"clientApprovalStatus", "clientApprovalDate", "constructionStatus",
			"constructionDate", "createdBy", "createdOn", "modifiedBy",
			"modifiedOn", "isActive"
		});

	static {
		try {
			Class.forName(takenakaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}