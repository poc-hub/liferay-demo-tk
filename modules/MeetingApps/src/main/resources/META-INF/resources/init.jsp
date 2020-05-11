<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="java.util.*"%>
<%@page import="com.takenaka.model.TriggerMeeting"%>
<%@page import="com.takenaka.service.*" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<portlet:renderURL var="createMeeting">
    <portlet:param name="mvcPath" value="/CreateMeeting.jsp"></portlet:param>
</portlet:renderURL>

<portlet:resourceURL var="saveDataUrl"/>

<script src="../js/main.js" type="text/javascript"></script>

<!-- <script src="../js/dataTable.js" type="text/javascript"></script> -->
<%
int totalMeetings = TriggerMeetingLocalServiceUtil.getTriggerMeetingsCount();
List<TriggerMeeting> Meetins = TriggerMeetingLocalServiceUtil.getTriggerMeetings(0, totalMeetings);
%>
