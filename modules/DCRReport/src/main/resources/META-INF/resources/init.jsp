<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="java.util.*"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*" %>

<script src="../js/main.js" type="text/javascript"></script>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<portlet:resourceURL var="saveDataUrl"/>
<portlet:renderURL var="createDCR">
    <portlet:param name="mvcPath" value="/CreateDCR.jsp"></portlet:param>
</portlet:renderURL>
<%
Date d1=new Date();
SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
String formatDate = sdf2.format(d1);

%>
