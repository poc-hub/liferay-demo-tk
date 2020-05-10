package com.lenovo.portlet;

import com.lenovo.constants.LenovoWebPortletKeys;
import com.lenovo.exception.NoSuchProductException;
import com.lenovo.model.Product;
import com.lenovo.service.ProductLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sanjay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LenovoWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LenovoWebPortletKeys.LENOVOWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LenovoWebPortlet extends MVCPortlet {
	
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		 
		Product obj = (Product) ProductLocalServiceUtil.getProducts(-1, -1);
		
		
		try {
			Product ob2 =(Product) ProductLocalServiceUtil.findByproductName("name");
		} catch (NoSuchProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}