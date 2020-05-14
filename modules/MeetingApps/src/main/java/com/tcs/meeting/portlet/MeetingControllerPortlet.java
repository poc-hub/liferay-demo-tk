package com.tcs.meeting.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.takenaka.model.TriggerMeeting;
import com.takenaka.model.TriggerMeetingDetails;
import com.takenaka.service.TriggerMeetingDetailsLocalServiceUtil;
import com.takenaka.service.TriggerMeetingLocalServiceUtil;
import com.tcs.meeting.constants.MeetingControllerPortletKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author MADDY
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.Takenaka",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/datatable.js", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MeetingController", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MeetingControllerPortletKeys.MEETINGCONTROLLER,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.requires-namespaced-parameters=false" }, service = Portlet.class)

public class MeetingControllerPortlet extends MVCPortlet {
	// Method for retrive the search Data
	@SuppressWarnings("deprecation")
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		System.out.println("inside resource method for testing ajax call using resource url");

		String MeetingType = resourceRequest.getParameter("MeetingType");
		System.out.println("MeetingType---->" + MeetingType);
		String MeetingId = resourceRequest.getParameter("MeetingId");
		String Issuer = resourceRequest.getParameter("Issuer");
		String MeetingFrmDate = resourceRequest.getParameter("MeetingFromDate");
		String MeetingToDate = resourceRequest.getParameter("MeetingToDate");
		String MeetingTitle = resourceRequest.getParameter("MeetingTitle");

		HttpServletRequest serveletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		if (null == MeetingType || MeetingType.isEmpty()) {
			MeetingType = serveletRequest.getParameter("MeetingType");
		}
		if (null == MeetingId || MeetingId.isEmpty()) {
			MeetingId = serveletRequest.getParameter("MeetingId");
		}
		if (null == Issuer || Issuer.isEmpty()) {
			Issuer = serveletRequest.getParameter("Issuer");
		}
		/*
		 * if (null == MeetingFrmDate || MeetingFrmDate.isEmpty()) { MeetingFrmDate =
		 * serveletRequest.getParameter("MeetingFrmDate");
		 * 
		 * } if (null == MeetingToDate || MeetingToDate.isEmpty()) { MeetingToDate =
		 * serveletRequest.getParameter("MeetingToDate"); }
		 */
		if (null == MeetingTitle || MeetingTitle.isEmpty()) {
			MeetingTitle = serveletRequest.getParameter("MeetingTitle");
		}
		System.out.println("Meeting Id" + MeetingId);
		System.out.println("MeetinFrmDate: " + MeetingFrmDate);
		System.out.println("MeetingToDate:" + MeetingToDate);
		System.out.println("MeetingTitle:" + MeetingTitle);

		Date FrmDate = null;

		if (MeetingFrmDate.equals(null) || MeetingFrmDate.equals("")) {
			System.out.println("inside MeetingFrmDate.equals(null)");
			FrmDate = null;

		} else {
			System.out.println("inside MeetingFrmDate--else");
			FrmDate = StringtoDate(MeetingFrmDate);
		}

		Date ToDate = null;

		if (MeetingToDate.equals(null) || MeetingToDate.equals("")) {
			System.out.println("inside MeetingToDate.equals(null)");
			ToDate = null;
		} else {
			System.out.println("inside MeetingToDate--else");
			ToDate = StringtoDate(MeetingToDate);

		}

		System.out.println("MeetingToDate" + ToDate);

		// Date todate = getStringToDate(MeetingToDate);

		System.out.println("MeetingFrmDate" + FrmDate);

		// int totalMeetings = TriggerMeetingLocalServiceUtil.getTriggerMeetingsCount();
		// List<TriggerMeeting> Meetins =
		// TriggerMeetingLocalServiceUtil.getTriggerMeetings(0, 3);

		try {
			List<TriggerMeeting> Meetins = TriggerMeetingLocalServiceUtil.getTriggerMeetingByFilter(MeetingType,
					MeetingId, Issuer, MeetingTitle, FrmDate, ToDate);
			System.out.println("Search Array Size" + Meetins);
			JSONArray allUsersJsonArray = JSONFactoryUtil.createJSONArray();
			JSONArray jsonUserArray = null;
			for (int i = 0; i < Meetins.size(); i++) {
				TriggerMeeting tm = Meetins.get(i);
				jsonUserArray = JSONFactoryUtil.createJSONArray();
				jsonUserArray.put(i + 1);
				jsonUserArray.put(tm.getMeetingId());
				jsonUserArray.put(tm.getIssuer());
				if (tm.getMeetDate() != null) {
					jsonUserArray.put(dateFormat(tm.getMeetDate()));
				} else {
					jsonUserArray.put("");
				}
				jsonUserArray.put(tm.getMeetingType());
				jsonUserArray.put(tm.getMeetingTitle());
				allUsersJsonArray.put(jsonUserArray);

			}

			JSONObject tableData = JSONFactoryUtil.createJSONObject();
			tableData.put("data", allUsersJsonArray);
			System.out.println(allUsersJsonArray);
			ServletResponseUtil.write(PortalUtil.getHttpServletResponse(resourceResponse), tableData.toString());

			/*
			 * for (TriggerMeeting tm : Meetins) {
			 * 
			 * arr.add(tm.getMeetingId()); arr.add(tm.getIssuer()); if (tm.getMeetDate() !=
			 * null) { arr.add(dateFormat(tm.getMeetDate())); } else { arr.add(""); }
			 * arr.add(tm.getMeetingType()); arr.add(tm.getMeetingTitle()); }
			 */ /*
				 * System.out.println("Arrray Size---" + arr.size()); for (int i = 0; i <
				 * arr.size(); i += 5) { JSONObject jsonobj =
				 * JSONFactoryUtil.createJSONObject(); jsonobj.put("MeetingId", arr.get(i));
				 * jsonobj.put("Issuer", arr.get(i + 1)); jsonobj.put("MeetingDate", arr.get(i +
				 * 2)); jsonobj.put("MeetingDateMeetingDate", arr.get(i + 3));
				 * jsonobj.put("MeetingTitle", arr.get(i + 4)); searchData.put(jsonobj); }
				 */
			/* System.out.println("Size of  search data-->"+searchData); */
		} catch (Exception e) {
			e.printStackTrace();
		}

		// jsonobj.put("UserEmail", Meetins);

		// PrintWriter printout = resourceResponse.getWriter();
		// printout.print(searchData.toString());
	}

	private String dateFormat(Date date) throws ParseException {

		SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatDate = sdf1.format(date);
		String formatedDate = sdf2.format(sdf1.parse(formatDate));
		System.out.println("My Date" + formatDate);
		return formatedDate;
	}

	// Method for meeting Data Submit into Database
	@SuppressWarnings("null")
	@ProcessAction(name = "meetingAction")
	public void submitMeeting(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, IOException {

		System.out.println("Calling submitMeeting-----");

		// Start Feaching form data from JSP to Controller

		// Meeting Information Pages
		String Project = ParamUtil.getString(actionRequest, "Project");
		// System.out.println("Project" + Project);
		// String MeetingId = ParamUtil.getString(actionRequest, "MeetingId");
		// System.out.println("MeetingId" + MeetingId);
		String Issuer = ParamUtil.getString(actionRequest, "Issuer");
		// System.out.println("Issuer" + Issuer);
		String MeetingType = ParamUtil.getString(actionRequest, "MeetingType");
		// System.out.println("MeetingType" + MeetingType);
		String MeetingDate = ParamUtil.getString(actionRequest, "MeetingDate");
		Date meetingDate = createStringToDate(MeetingDate);
		System.out.println("MeetingDate" + MeetingDate + "Date meeing" + meetingDate);
		String MeetingPlace = ParamUtil.getString(actionRequest, "MeetingPlace");
		// System.out.println("MeetingPlace" + MeetingPlace);
		String MeetingTitle = ParamUtil.getString(actionRequest, "MeetingTitle");
		// System.out.println("MeetingTitle" + MeetingTitle);
		String MeetingParticipants = ParamUtil.getString(actionRequest, "MeetingParticipants");
		// System.out.println("MeetingParticipants" + MeetingParticipants);
		String MeetingSummary = ParamUtil.getString(actionRequest, "MeetingSummary");
		// System.out.println("MeetingSummary" + MeetingSummary);
		// Meeting Details Page
		ArrayList<String> ceta = new ArrayList<String>();
		ArrayList<String> Floor = new ArrayList<String>();
		ArrayList<String> Items = new ArrayList<String>();
		ArrayList<String> ActionData = new ArrayList<String>();
		ArrayList<String> ExpectedDueDate = new ArrayList<String>();
		ArrayList<String> PersionInCharge = new ArrayList<String>();

		ceta.add(ParamUtil.getString(actionRequest, "Category"));
		Floor.add(ParamUtil.getString(actionRequest, "Floor"));
		Items.add(ParamUtil.getString(actionRequest, "Items"));
		ActionData.add(ParamUtil.getString(actionRequest, "Action"));
		System.out.println("ActionData-->" + ParamUtil.getString(actionRequest, "Action") + "Size" + ActionData.size());
		ExpectedDueDate.add(ParamUtil.getString(actionRequest, "ExpectedDueDate"));
		PersionInCharge.add(ParamUtil.getString(actionRequest, "PersionInCharge"));

		for (int i = 1; i < 10; i++) {
			if (ParamUtil.getString(actionRequest, "Category" + i) != "") {
				System.out.println(ParamUtil.getString(actionRequest, "Category" + i));
				ceta.add(ParamUtil.getString(actionRequest, "Category" + i));
				Floor.add(ParamUtil.getString(actionRequest, "Floor" + i));
				Items.add(ParamUtil.getString(actionRequest, "Items" + i));
				ActionData.add(ParamUtil.getString(actionRequest, "Action" + i));
				ExpectedDueDate.add(ParamUtil.getString(actionRequest, "ExpectedDueDate" + i));
				PersionInCharge.add(ParamUtil.getString(actionRequest, "PersionInCharge" + i));
			} else {
				System.out.println("else break");
				break;
			}
		}
		for (int i = 0; i < ActionData.size(); i++) {
			System.out.println("Action array size.." + ActionData.get(i));
		}

		// End

		// Inserting form data to DB by Service Builder

		try {

			long meetingSeqno = 0L;
			long meetingSeqnoDetails = 0L;
			long groupId = 1111;
			boolean isActive = true;
			// Meeting ID geneate random Code.
			// String meetingId = randomAlphaNumeric(5);
			// System.out.println("meetingId---" + meetingId);

			// Get current User
			User user = PortalUtil.getUser(actionRequest);
			String UserName = user.getScreenName();
			// System.out.println("UserName--" + UserName);

			// Create Today Date
			java.util.Date nowDate = new java.util.Date();
			@SuppressWarnings("deprecation")
			java.util.Date todaysDate = new java.util.Date(nowDate.getYear(), nowDate.getMonth(), nowDate.getDate(), 0,
					0, 0);
			// Insert Data to TriggerMeeting Table
			meetingSeqno = CounterLocalServiceUtil.increment(TriggerMeeting.class.getName());
			TriggerMeeting triggerMeeting = TriggerMeetingLocalServiceUtil.createTriggerMeeting(meetingSeqno);
			triggerMeeting.setMeetingSeqno(meetingSeqno);
			triggerMeeting.setGroupId(groupId);
			String meetingId = Project.substring(0, 3) + meetingSeqno;
			triggerMeeting.setMeetingId(meetingId);
			// System.out.println("meetingId---" + meetingId);
			triggerMeeting.setMeetingTitle(MeetingTitle);
			triggerMeeting.setIssuer(Issuer);
			triggerMeeting.setMeetingType(MeetingType);
			triggerMeeting.setMeetDate(StringtoDate(MeetingDate));
			triggerMeeting.setParticipant(MeetingParticipants);
			triggerMeeting.setMeetingPlace(MeetingPlace);
			triggerMeeting.setMeetingSummary(MeetingSummary);
			triggerMeeting.setCreatedBy(UserName);
			triggerMeeting.setCreatedOn(new Date());
			triggerMeeting.setModifiedBy(UserName);
			triggerMeeting.setModifiedOn(todaysDate);
			triggerMeeting.setIsActive(isActive);

			// Calling Service Bulder Impl class
			TriggerMeetingLocalServiceUtil.addTriggerMeeting(triggerMeeting);

			// Insert Data to TriggerMeeringDetails table.
			for (int i = 0; i < ceta.size(); i++) {
				meetingSeqnoDetails = CounterLocalServiceUtil.increment(TriggerMeetingDetails.class.getName());
				TriggerMeetingDetails triggerMeetingDetails = TriggerMeetingDetailsLocalServiceUtil
						.createTriggerMeetingDetails(meetingSeqnoDetails);
				triggerMeetingDetails.setMeetingdetailSeqno(meetingSeqnoDetails);
				triggerMeetingDetails.setMeetingSeqno(meetingSeqno);
				triggerMeetingDetails.setCategory(ceta.get(i));
				triggerMeetingDetails.setFloor(Floor.get(i));
				triggerMeetingDetails.setItem(Items.get(i));
				triggerMeetingDetails.setActions(ActionData.get(i));
				triggerMeetingDetails.setRESPONSE_DUEDATE(StringtoDate(ExpectedDueDate.get(i)));
				triggerMeetingDetails.setPersonInCharge(PersionInCharge.get(i));
				triggerMeetingDetails.setCreatedBy(UserName);
				triggerMeetingDetails.setCreatedOn(new Date());
				triggerMeetingDetails.setModifiedBy(UserName);
				triggerMeetingDetails.setModifiedOn(todaysDate);
				triggerMeetingDetails.setIsActive(isActive);

				// Calling Service Bulder Impl class
				TriggerMeetingDetailsLocalServiceUtil.addTriggerMeetingDetails(triggerMeetingDetails);
				// Redirect to Portlet Page
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
				PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
						portletName, themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
				redirectURL.setParameter("mvcPath", "/view.jsp");
				actionResponse.sendRedirect(redirectURL.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	private Date createStringToDate(String meetingDate) {
		Date d1 = null;
		try {
			String[] brkDate = meetingDate.split("-");
			d1 = new Date((Integer.parseInt(brkDate[0])), (Integer.parseInt(brkDate[1])),
					(Integer.parseInt(brkDate[2])));
			System.out.println("createStringToDate" + d1.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d1;
	}

	// String to Date convert method
	private Date StringtoDate(String meetingDate) {
		System.out.println("Before meeting date convert" + meetingDate);
		Date convertedDate = null;
		DateFormat formatter = null;
		try {
			if (!meetingDate.equals(null)) {

				formatter = new SimpleDateFormat("yyyy-MM-dd");
				convertedDate = (Date) formatter.parse(meetingDate);
				// date = new SimpleDateFormat("yyyy-mm-dd").parse(meetingDate);
				System.out.println("After Meeting date convart" + convertedDate);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertedDate;
	}

//Method for ALPHA_NUMERIC_STRING generator
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	/*
	 * @Override public void render(RenderRequest renderRequest, RenderResponse
	 * renderResponse) throws IOException, PortletException { // TODO Auto-generated
	 * method stub try { int totalMeetings =
	 * TriggerMeetingLocalServiceUtil.getTriggerMeetingsCount();
	 * List<TriggerMeeting> Meetins =
	 * TriggerMeetingLocalServiceUtil.getTriggerMeetings(0, totalMeetings);
	 * System.out.println("Meetins Size" + Meetins.size());
	 * //renderRequest.setAttribute("defaultResult", Meetins);
	 * 
	 * ListIterator<TriggerMeeting> itr = Meetins.listIterator(); while
	 * (itr.hasNext()) {
	 * 
	 * System.out.println("List -------" + itr.next()); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } super.render(renderRequest,
	 * renderResponse); }
	 */
	@ProcessAction(name = "AddDetailsMeeting")
	public void AddDetailsMeeting(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		System.out.println("I am render");

		String MeetingId = request.getParameter("meetingId");
		HttpServletRequest serveletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		if (null == MeetingId || MeetingId.isEmpty()) {
			MeetingId = serveletRequest.getParameter("MeetingId");
		}
		System.out.println("MeetingId-----" + MeetingId);

		try {
			@SuppressWarnings("unchecked")
			TriggerMeeting Meetins = (TriggerMeeting) TriggerMeetingLocalServiceUtil.findByMeetingId(MeetingId);
			System.out.println("Meetins getMeetingSeqno: " + Meetins.getMeetingSeqno());
			long meetingSeqNo = Meetins.getMeetingSeqno();
			List<TriggerMeetingDetails> MeetinsDetails = TriggerMeetingDetailsLocalServiceUtil
					.findByMeetingSeqnoList(meetingSeqNo);
			System.out.println("Meetins getFloor: " + MeetinsDetails.size());

			for (TriggerMeetingDetails tm : MeetinsDetails) {
				System.out.println("cat--" + tm.getCategory() + "flo--" + tm.getFloor() + "itm--" + tm.getItem()
						+ "due--" + tm.getRESPONSE_DUEDATE() + "ac--" + tm.getActions() + "Per--"
						+ tm.getPersonInCharge());

			}
			request.setAttribute("MeetingInfo", Meetins);
			request.setAttribute("MeetingDetails", MeetinsDetails);
			response.setRenderParameter("jspPage", "/display_meeting.jsp");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}