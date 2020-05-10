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

import com.takenaka.exception.NoSuchProjTableException;
import com.takenaka.model.ProjTable;
import com.takenaka.model.impl.ProjTableImpl;
import com.takenaka.model.impl.ProjTableModelImpl;
import com.takenaka.service.persistence.ProjTablePersistence;
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
 * The persistence implementation for the proj table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sanjay.Panchal
 * @generated
 */
@Component(service = ProjTablePersistence.class)
public class ProjTablePersistenceImpl
	extends BasePersistenceImpl<ProjTable> implements ProjTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProjTableUtil</code> to access the proj table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProjTableImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ProjTablePersistenceImpl() {
		setModelClass(ProjTable.class);

		setModelImplClass(ProjTableImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("recId", "REC_ID");
		dbColumnNames.put("groupId", "GROUP_ID");
		dbColumnNames.put("groupFlag", "GROUP_FLAG");
		dbColumnNames.put("yosoKojiCd", "YOSO_KOJI_CD");
		dbColumnNames.put("sekkeiCd", "SEKKEI_CD");
		dbColumnNames.put("sekkeiCdYy", "SEKKEI_CD_YY");
		dbColumnNames.put("mitumoriNendo", "MITUMORI_NENDO");
		dbColumnNames.put("mitumoriCd", "MITUMORI_CD");
		dbColumnNames.put("kojiCd", "KOJI_CD");
		dbColumnNames.put("mitumoriSeiriNo", "MITUMORI_SEIRI_NO");
		dbColumnNames.put("shukanSekkeiCd", "SHUKAN_SEKKEI_CD");
		dbColumnNames.put("sekkeiTogoSaki", "SEKKEI_TOGO_SAKI");
		dbColumnNames.put("sekkeiBunkatuMoto", "SEKKEI_BUNKATU_MOTO");
		dbColumnNames.put("jutakuSekkeiTaisho", "JUTAKU_SEKKEI_TAISHO");
		dbColumnNames.put("honsitenRid", "HONSITEN_RID");
		dbColumnNames.put("honsitenGid", "HONSITEN_GID");
		dbColumnNames.put("orgYkoji", "ORG_YKOJI");
		dbColumnNames.put("orgJKOJI", "ORG_JKOJI");
		dbColumnNames.put("orgMdd", "ORG_MDD");
		dbColumnNames.put("orgPdd", "ORG_PDD");
		dbColumnNames.put("orgEsmas", "ORG_ESMAS");
		dbColumnNames.put("orgPrist", "ORG_PRIST");
		dbColumnNames.put("procSekkei", "PROC_SEKKEI");
		dbColumnNames.put("procMitumori", "PROC_MITUMORI");
		dbColumnNames.put("procSekkeiOen", "PROC_SEKKEI_OEN");
		dbColumnNames.put("procSekkeiTogo", "PROC_SEKKEI_TOGO");
		dbColumnNames.put("procSekkeiBunkatu", "PROC_SEKKEI_BUNKATU");
		dbColumnNames.put("procSekkeiJutaku", "PROC_SEKKEI_JUTAKU");
		dbColumnNames.put("taketuChusiToketuKb", "TAKETU_CHUSI_TOKETU_KB");
		dbColumnNames.put("kanryoChusiStatus", "KANRYO_CHUSI_STATUS");
		dbColumnNames.put("mitumoriKeijoShubetu", "MITUMORI_KEIJO_SHUBETU");
		dbColumnNames.put("torikesiKb", "TORIKESI_KB");
		dbColumnNames.put("kessanNendo", "KESSAN_NENDO");
		dbColumnNames.put("updDate", "UPD_DATE");
		dbColumnNames.put("updTime", "UPD_TIME");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the proj table in the entity cache if it is enabled.
	 *
	 * @param projTable the proj table
	 */
	@Override
	public void cacheResult(ProjTable projTable) {
		entityCache.putResult(
			entityCacheEnabled, ProjTableImpl.class, projTable.getPrimaryKey(),
			projTable);

		projTable.resetOriginalValues();
	}

	/**
	 * Caches the proj tables in the entity cache if it is enabled.
	 *
	 * @param projTables the proj tables
	 */
	@Override
	public void cacheResult(List<ProjTable> projTables) {
		for (ProjTable projTable : projTables) {
			if (entityCache.getResult(
					entityCacheEnabled, ProjTableImpl.class,
					projTable.getPrimaryKey()) == null) {

				cacheResult(projTable);
			}
			else {
				projTable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all proj tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjTableImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the proj table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjTable projTable) {
		entityCache.removeResult(
			entityCacheEnabled, ProjTableImpl.class, projTable.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProjTable> projTables) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjTable projTable : projTables) {
			entityCache.removeResult(
				entityCacheEnabled, ProjTableImpl.class,
				projTable.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ProjTableImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new proj table with the primary key. Does not add the proj table to the database.
	 *
	 * @param recId the primary key for the new proj table
	 * @return the new proj table
	 */
	@Override
	public ProjTable create(long recId) {
		ProjTable projTable = new ProjTableImpl();

		projTable.setNew(true);
		projTable.setPrimaryKey(recId);

		return projTable;
	}

	/**
	 * Removes the proj table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table that was removed
	 * @throws NoSuchProjTableException if a proj table with the primary key could not be found
	 */
	@Override
	public ProjTable remove(long recId) throws NoSuchProjTableException {
		return remove((Serializable)recId);
	}

	/**
	 * Removes the proj table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the proj table
	 * @return the proj table that was removed
	 * @throws NoSuchProjTableException if a proj table with the primary key could not be found
	 */
	@Override
	public ProjTable remove(Serializable primaryKey)
		throws NoSuchProjTableException {

		Session session = null;

		try {
			session = openSession();

			ProjTable projTable = (ProjTable)session.get(
				ProjTableImpl.class, primaryKey);

			if (projTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(projTable);
		}
		catch (NoSuchProjTableException noSuchEntityException) {
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
	protected ProjTable removeImpl(ProjTable projTable) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projTable)) {
				projTable = (ProjTable)session.get(
					ProjTableImpl.class, projTable.getPrimaryKeyObj());
			}

			if (projTable != null) {
				session.delete(projTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (projTable != null) {
			clearCache(projTable);
		}

		return projTable;
	}

	@Override
	public ProjTable updateImpl(ProjTable projTable) {
		boolean isNew = projTable.isNew();

		Session session = null;

		try {
			session = openSession();

			if (projTable.isNew()) {
				session.save(projTable);

				projTable.setNew(false);
			}
			else {
				projTable = (ProjTable)session.merge(projTable);
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
			entityCacheEnabled, ProjTableImpl.class, projTable.getPrimaryKey(),
			projTable, false);

		projTable.resetOriginalValues();

		return projTable;
	}

	/**
	 * Returns the proj table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the proj table
	 * @return the proj table
	 * @throws NoSuchProjTableException if a proj table with the primary key could not be found
	 */
	@Override
	public ProjTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjTableException {

		ProjTable projTable = fetchByPrimaryKey(primaryKey);

		if (projTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return projTable;
	}

	/**
	 * Returns the proj table with the primary key or throws a <code>NoSuchProjTableException</code> if it could not be found.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table
	 * @throws NoSuchProjTableException if a proj table with the primary key could not be found
	 */
	@Override
	public ProjTable findByPrimaryKey(long recId)
		throws NoSuchProjTableException {

		return findByPrimaryKey((Serializable)recId);
	}

	/**
	 * Returns the proj table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recId the primary key of the proj table
	 * @return the proj table, or <code>null</code> if a proj table with the primary key could not be found
	 */
	@Override
	public ProjTable fetchByPrimaryKey(long recId) {
		return fetchByPrimaryKey((Serializable)recId);
	}

	/**
	 * Returns all the proj tables.
	 *
	 * @return the proj tables
	 */
	@Override
	public List<ProjTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proj tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proj tables
	 * @param end the upper bound of the range of proj tables (not inclusive)
	 * @return the range of proj tables
	 */
	@Override
	public List<ProjTable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the proj tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proj tables
	 * @param end the upper bound of the range of proj tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proj tables
	 */
	@Override
	public List<ProjTable> findAll(
		int start, int end, OrderByComparator<ProjTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proj tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proj tables
	 * @param end the upper bound of the range of proj tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proj tables
	 */
	@Override
	public List<ProjTable> findAll(
		int start, int end, OrderByComparator<ProjTable> orderByComparator,
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

		List<ProjTable> list = null;

		if (useFinderCache) {
			list = (List<ProjTable>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJTABLE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJTABLE;

				sql = sql.concat(ProjTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<ProjTable>)QueryUtil.list(
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
	 * Removes all the proj tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjTable projTable : findAll()) {
			remove(projTable);
		}
	}

	/**
	 * Returns the number of proj tables.
	 *
	 * @return the number of proj tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJTABLE);

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
		return "REC_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROJTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProjTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the proj table persistence.
	 */
	@Activate
	public void activate() {
		ProjTableModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ProjTableModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ProjTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ProjTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ProjTableImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.takenaka.model.ProjTable"),
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

	private static final String _SQL_SELECT_PROJTABLE =
		"SELECT projTable FROM ProjTable projTable";

	private static final String _SQL_COUNT_PROJTABLE =
		"SELECT COUNT(projTable) FROM ProjTable projTable";

	private static final String _ORDER_BY_ENTITY_ALIAS = "projTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProjTable exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ProjTablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"recId", "groupId", "groupFlag", "yosoKojiCd", "sekkeiCd",
			"sekkeiCdYy", "mitumoriNendo", "mitumoriCd", "kojiCd",
			"mitumoriSeiriNo", "shukanSekkeiCd", "sekkeiTogoSaki",
			"sekkeiBunkatuMoto", "jutakuSekkeiTaisho", "honsitenRid",
			"honsitenGid", "orgYkoji", "orgJKOJI", "orgMdd", "orgPdd",
			"orgEsmas", "orgPrist", "procSekkei", "procMitumori",
			"procSekkeiOen", "procSekkeiTogo", "procSekkeiBunkatu",
			"procSekkeiJutaku", "taketuChusiToketuKb", "kanryoChusiStatus",
			"mitumoriKeijoShubetu", "torikesiKb", "kessanNendo", "updDate",
			"updTime"
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