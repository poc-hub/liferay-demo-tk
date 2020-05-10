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

package com.lenovo.model.impl;

import com.lenovo.model.Product;
import com.lenovo.model.ProductModel;
import com.lenovo.model.ProductSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Product service. Represents a row in the &quot;Lenovo_Product&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProductModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProductImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductImpl
 * @generated
 */
@JSON(strict = true)
public class ProductModelImpl
	extends BaseModelImpl<Product> implements ProductModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a product model instance should use the <code>Product</code> interface instead.
	 */
	public static final String TABLE_NAME = "Lenovo_Product";

	public static final Object[][] TABLE_COLUMNS = {
		{"productId", Types.BIGINT}, {"PRODUCTNAME", Types.VARCHAR},
		{"PRODUCTDESC", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("productId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("PRODUCTNAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PRODUCTDESC", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Lenovo_Product (productId LONG not null primary key,PRODUCTNAME VARCHAR(75) null,PRODUCTDESC VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table Lenovo_Product";

	public static final String ORDER_BY_JPQL =
		" ORDER BY product.productName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Lenovo_Product.PRODUCTNAME ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long PRODUCTNAME_COLUMN_BITMASK = 1L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Product toModel(ProductSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Product model = new ProductImpl();

		model.setProductId(soapModel.getProductId());
		model.setProductName(soapModel.getProductName());
		model.setProductDesc(soapModel.getProductDesc());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Product> toModels(ProductSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Product> models = new ArrayList<Product>(soapModels.length);

		for (ProductSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ProductModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _productId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProductId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _productId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Product.class;
	}

	@Override
	public String getModelClassName() {
		return Product.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Product, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Product, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Product, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Product)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Product, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Product, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Product)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Product, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Product, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Product>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Product.class.getClassLoader(), Product.class, ModelWrapper.class);

		try {
			Constructor<Product> constructor =
				(Constructor<Product>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Product, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Product, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Product, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Product, Object>>();
		Map<String, BiConsumer<Product, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Product, ?>>();

		attributeGetterFunctions.put("productId", Product::getProductId);
		attributeSetterBiConsumers.put(
			"productId", (BiConsumer<Product, Long>)Product::setProductId);
		attributeGetterFunctions.put("productName", Product::getProductName);
		attributeSetterBiConsumers.put(
			"productName",
			(BiConsumer<Product, String>)Product::setProductName);
		attributeGetterFunctions.put("productDesc", Product::getProductDesc);
		attributeSetterBiConsumers.put(
			"productDesc",
			(BiConsumer<Product, String>)Product::setProductDesc);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getProductId() {
		return _productId;
	}

	@Override
	public void setProductId(long productId) {
		_productId = productId;
	}

	@JSON
	@Override
	public String getProductName() {
		if (_productName == null) {
			return "";
		}
		else {
			return _productName;
		}
	}

	@Override
	public void setProductName(String productName) {
		_columnBitmask = -1L;

		if (_originalProductName == null) {
			_originalProductName = _productName;
		}

		_productName = productName;
	}

	public String getOriginalProductName() {
		return GetterUtil.getString(_originalProductName);
	}

	@JSON
	@Override
	public String getProductDesc() {
		if (_productDesc == null) {
			return "";
		}
		else {
			return _productDesc;
		}
	}

	@Override
	public void setProductDesc(String productDesc) {
		_productDesc = productDesc;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Product.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Product toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Product>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProductImpl productImpl = new ProductImpl();

		productImpl.setProductId(getProductId());
		productImpl.setProductName(getProductName());
		productImpl.setProductDesc(getProductDesc());

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public int compareTo(Product product) {
		int value = 0;

		value = getProductName().compareTo(product.getProductName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Product)) {
			return false;
		}

		Product product = (Product)obj;

		long primaryKey = product.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		ProductModelImpl productModelImpl = this;

		productModelImpl._originalProductName = productModelImpl._productName;

		productModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Product> toCacheModel() {
		ProductCacheModel productCacheModel = new ProductCacheModel();

		productCacheModel.productId = getProductId();

		productCacheModel.productName = getProductName();

		String productName = productCacheModel.productName;

		if ((productName != null) && (productName.length() == 0)) {
			productCacheModel.productName = null;
		}

		productCacheModel.productDesc = getProductDesc();

		String productDesc = productCacheModel.productDesc;

		if ((productDesc != null) && (productDesc.length() == 0)) {
			productCacheModel.productDesc = null;
		}

		return productCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Product, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Product, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Product, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Product)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Product, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Product, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Product, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Product)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Product>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _productId;
	private String _productName;
	private String _originalProductName;
	private String _productDesc;
	private long _columnBitmask;
	private Product _escapedModel;

}