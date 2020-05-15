package com.tcs.DCR.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
//import com.liferay.portal.kernel.util.File;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.takenaka.model.DesignChangeDetails;
import com.takenaka.model.TriggerMeeting;
import com.takenaka.model.TriggerMeetingDetails;
import com.takenaka.service.DesignChangeDetailsLocalServiceUtil;
import com.takenaka.service.TriggerMeetingDetailsLocalServiceUtil;
import com.takenaka.service.TriggerMeetingLocalServiceUtil;
import com.tcs.DCR.constants.DCRControllerPortletKeys;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author MADDY
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DCRController", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DCRControllerPortletKeys.DCRCONTROLLER,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js"
		, }, service = Portlet.class)
public class DCRControllerPortlet extends MVCPortlet {
	private static String ROOT_FOLDER_NAME = "File_Upload";
	private static String ROOT_FOLDER_DESCRIPTION = "Test Descprition";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	long[] longArray = new long[4];
	ArrayList<Long> array=new ArrayList<Long>();

	@ProcessAction(name = "dcrViewAction")
	public void submitDCRView(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, IOException {
		
		long rId = Long.parseLong(actionRequest.getParameter("ID"));
		int counter = 0;
		int flag = 0;
		FileItem[] item;
		int previousFileCounter = 0;
		// File Attachment Code
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		System.out.println("the map" + files.keySet());
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			FileItem item1[] = file2.getValue();
			for (FileItem item2 : item1) {
				if (item2.getFileName() != "") {
					System.out.println(item2.getFileName());
					counter++;
				}
			}
		}
		DesignChangeDetails dcd = DesignChangeDetailsLocalServiceUtil.fetchDesignChangeDetails(rId);
		if (counter != 0) {
			flag = 1;
			createFolder(actionRequest, themeDisplay);
			fileUpload1(themeDisplay, actionRequest,rId);
		}

		
		System.out.println("Inside Action!");
		System.out.println(rId);
		long[] idArray=new long[array.size()];
		for(int j=0;j<array.size();j++) {
			idArray[j]=array.get(j);
		}

		

		// trying to get the no of files the user already had before update
		if (dcd.getAttachmentId1() > 0) {
			previousFileCounter++;
		}
		if (dcd.getAttachmentId2() > 0) {
			previousFileCounter++;
		}
		if (dcd.getAttachmentId3() > 0) {
			previousFileCounter++;
		}
		if (dcd.getAttachmentId4() > 0) {
			previousFileCounter++;
		}

		String ReasonforChange = ParamUtil.getString(actionRequest, "ReasonforChange");
		String ChangeRequestedBy = ParamUtil.getString(actionRequest, "ChangeRequestedBy");
		String ChangeType = ParamUtil.getString(actionRequest, "ChangeType");
		String Others = ParamUtil.getString(actionRequest, "Others");
		String Rangeofdisclosure = ParamUtil.getString(actionRequest, "Rangeofdisclosure");
		String MeetID = ParamUtil.getString(actionRequest, "meetingId");
		String Floor = ParamUtil.getString(actionRequest, "Floor");
		String ItemDetails = ParamUtil.getString(actionRequest, "ItemDetails");
		String Action = ParamUtil.getString(actionRequest, "Action");
		String ExpectedDueDate = ParamUtil.getString(actionRequest, "ExpectedDueDate");
		String PersoninCharge = ParamUtil.getString(actionRequest, "PersoninCharge");
		String OriginalDesgin = ParamUtil.getString(actionRequest, "OriginalDesgin");
		String ChangeDesgin = ParamUtil.getString(actionRequest, "ChangeDesgin");

		String DesignCostType = ParamUtil.getString(actionRequest, "DesignCostType");
		long DesignCost = ParamUtil.getLong(actionRequest, "DesignCost");
		String ConstructionCostType = ParamUtil.getString(actionRequest, "ConstructionCostType");
		long ConstructionCost = ParamUtil.getLong(actionRequest, "ConstructionCost");
		String ExpensePayment = ParamUtil.getString(actionRequest, "ExpensePayment");
		//Date date=StringtoDate(ExpectedDueDate);
		dcd.setRfcId(ReasonforChange);
		dcd.setChangeRequestby(ChangeRequestedBy);
		dcd.setChangeType(ChangeType);
		dcd.setRfcOthers(Others);
		dcd.setRangeOfDisclosure(Rangeofdisclosure);
		dcd.setMeetingId(MeetID);
		dcd.setFloor(Floor);
		dcd.setItem(ItemDetails);
		dcd.setAction(Action);
		dcd.setResponsePeriod(ExpectedDueDate);
		dcd.setPersonInCharge(PersoninCharge);
		dcd.setOriginaldesginDetail(OriginalDesgin);
		dcd.setChangeDetail(ChangeDesgin);
		dcd.setEstdesignCosttype(DesignCostType);
		dcd.setEstdesignCost(DesignCost);
		dcd.setEstconstructionCosttype(ConstructionCostType);
		dcd.setEstconstructionCost(ConstructionCost);
		dcd.setExpenseAjustmentDivision(ExpensePayment);
		if (flag == 1) {
			if (previousFileCounter == 0) {
				if (idArray.length == 4) {
					dcd.setAttachmentId1(idArray[0]);
					dcd.setAttachmentId2(idArray[1]);
					dcd.setAttachmentId3(idArray[2]);
					dcd.setAttachmentId4(idArray[3]);
				} else if (idArray.length == 3) {

					dcd.setAttachmentId1(idArray[0]);
					dcd.setAttachmentId2(idArray[1]);
					dcd.setAttachmentId3(idArray[2]);
				} else if (idArray.length == 2) {

					dcd.setAttachmentId1(idArray[0]);
					dcd.setAttachmentId2(idArray[1]);
				} else {
					dcd.setAttachmentId1(idArray[0]);
				}
			} else if (previousFileCounter == 1) {
				if (idArray.length == 4) {
					dcd.setAttachmentId1(idArray[0]);
					dcd.setAttachmentId2(idArray[1]);
					dcd.setAttachmentId3(idArray[2]);
					dcd.setAttachmentId4(idArray[3]);
				} else if (idArray.length == 3) {

					dcd.setAttachmentId2(idArray[0]);
					dcd.setAttachmentId3(idArray[1]);
					dcd.setAttachmentId4(idArray[2]);
				} else if (idArray.length == 2) {

					dcd.setAttachmentId2(idArray[0]);
					dcd.setAttachmentId3(idArray[1]);
				} else {
					dcd.setAttachmentId2(idArray[0]);
				}
			} else if (previousFileCounter == 2) {
				if (idArray.length == 4) {
					dcd.setAttachmentId1(idArray[0]);
					dcd.setAttachmentId2(idArray[1]);
					dcd.setAttachmentId3(idArray[2]);
					dcd.setAttachmentId4(idArray[3]);
				} else if (idArray.length == 3) {

					dcd.setAttachmentId2(idArray[0]);
					dcd.setAttachmentId3(idArray[1]);
					dcd.setAttachmentId4(idArray[2]);
				} else if (idArray.length == 2) {

					dcd.setAttachmentId3(idArray[0]);
					dcd.setAttachmentId4(idArray[1]);
				} else {
					dcd.setAttachmentId3(idArray[0]);
				}
			} else if (previousFileCounter == 3) {
				if (idArray.length == 4) {
					dcd.setAttachmentId1(idArray[0]);
					dcd.setAttachmentId2(idArray[1]);
					dcd.setAttachmentId3(idArray[2]);
					dcd.setAttachmentId4(idArray[3]);
				} else if (idArray.length == 3) {

					dcd.setAttachmentId2(idArray[0]);
					dcd.setAttachmentId3(idArray[1]);
					dcd.setAttachmentId4(idArray[2]);
				} else if (idArray.length == 2) {

					dcd.setAttachmentId3(idArray[0]);
					dcd.setAttachmentId4(idArray[1]);
				} else {
					dcd.setAttachmentId4(idArray[0]);
				}
			} else {
				if (idArray.length == 4) {
					dcd.setAttachmentId1(idArray[0]);
					dcd.setAttachmentId2(idArray[1]);
					dcd.setAttachmentId3(idArray[2]);
					dcd.setAttachmentId4(idArray[3]);
				} else if (idArray.length == 3) {

					dcd.setAttachmentId1(idArray[0]);
					dcd.setAttachmentId2(idArray[1]);
					dcd.setAttachmentId3(idArray[2]);
				} else if (idArray.length == 2) {

					dcd.setAttachmentId1(idArray[0]);
					dcd.setAttachmentId2(idArray[1]);
				} else {
					dcd.setAttachmentId1(idArray[0]);
				}
			}
		
		}
		
		DesignChangeDetailsLocalServiceUtil.updateDesignChangeDetails(dcd);

	}
	@ProcessAction(name = "reqApproval")
	public void submitApproval(ActionRequest actionRequest,ActionResponse actionResponse) {
		System.out.println("inside reqApproval!");
		
		
		long approvalNumber=0L;
		approvalNumber=CounterLocalServiceUtil.increment(DesignChangeDetails.class.getName());
		int noOfRecords=Integer.parseInt(actionRequest.getParameter("size"));
		long[] idArray=new long[noOfRecords]; 
		for(int i=0;i<noOfRecords;i++) {
			idArray[i]=Long.parseLong(actionRequest.getParameter("element"+i));
			System.out.println(idArray[i]);
		}
		//System.out.println(approvalNumber);
	//	List<DesignChangeDetails> designList = null;
		for(int i=0;i<noOfRecords;i++) {
			DesignChangeDetails dcd=DesignChangeDetailsLocalServiceUtil.fetchDesignChangeDetails(idArray[i]);
			if(dcd.getApprovalNo()==0) {
				dcd.setApprovalNo(approvalNumber);
				DesignChangeDetailsLocalServiceUtil.updateDesignChangeDetails(dcd);
			}
			
		//	designList.add(DesignChangeDetailsLocalServiceUtil.fetchDesignChangeDetails(idArray[i]));
		}
//		for(DesignChangeDetails dcd:designList) {
//			dcd.setApprovalNo(approvalNumber);		
//			DesignChangeDetailsLocalServiceUtil.updateDesignChangeDetails(dcd);
//		}
		
		
	}
	@SuppressWarnings("deprecation")
	@ProcessAction(name="submitApprovall")
	public void submitApprovallURL(ActionRequest actionRequest,ActionResponse actionResponse) {
		
		long chngSeqNo=Long.parseLong(actionRequest.getParameter("chngSeqNo"));
		System.out.println(chngSeqNo);
		DesignChangeDetails dcd=DesignChangeDetailsLocalServiceUtil.fetchDesignChangeDetails(chngSeqNo);
		String approval=ParamUtil.getString(actionRequest, "Approval");
		System.out.println(approval);
		String customerApproval=ParamUtil.getString(actionRequest, "CustomerApproval");
		System.out.println(customerApproval);
		Date approvalDate=StringtoDate(ParamUtil.getString(actionRequest, "ApprovalDate"));
		System.out.println(ParamUtil.getString(actionRequest, "CustomerDate"));
		Date custApprovalDate=StringtoDate(ParamUtil.getString(actionRequest, "CustomerDate"));
		System.out.println(ParamUtil.getString(actionRequest, "ApprovalDate"));
		dcd.setApprovalDate(approvalDate);
		dcd.setClientApprovalStatus(customerApproval);
		dcd.setClientApprovalDate(custApprovalDate);
		dcd.setApprovalStatus(approval);
		DesignChangeDetailsLocalServiceUtil.updateDesignChangeDetails(dcd);
	}
	// Method for meeting Data Submit into Database
	@ProcessAction(name = "DCRAction")
	public void submitDCR(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, IOException {
		long DCRSeqno = 0L;
		DCRSeqno = CounterLocalServiceUtil.increment(DesignChangeDetails.class.getName());
		int counter = 0;
		int flag = 0;
		FileItem[] item;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		System.out.println("the map" + files.keySet());
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			FileItem item1[] = file2.getValue();
			for (FileItem item2 : item1) {
				if (item2.getFileName() != "") {
					System.out.println(item2.getFileName());
					counter++;
				}
			}
		}
		if (counter != 0) {
			flag = 1;
			createFolder(actionRequest, themeDisplay);
			fileUpload(themeDisplay, actionRequest,DCRSeqno);
		}
		System.out.println("Calling submitDCR-----");
		String changeDesign=ParamUtil.getString(actionRequest,"changeDesign");
		String Project = ParamUtil.getString(actionRequest, "Project");
		System.out.println("Project" + Project);
		String ChangeType = ParamUtil.getString(actionRequest, "ChangeType");
		System.out.println("Change Type---" + ChangeType);
		String ChangeRequestedBy = ParamUtil.getString(actionRequest, "ChangeRequestedBy");
		System.out.println("ChangeRequestedBy---" + ChangeRequestedBy);
		String ReasonforChange = ParamUtil.getString(actionRequest, "ReasonforChange");
		System.out.println("ReasonforChange Type---" + ReasonforChange);
		String Others = ParamUtil.getString(actionRequest, "Others");
		System.out.println("Others Type---" + Others);
		String Rangeofdisclosure = ParamUtil.getString(actionRequest, "Rangeofdisclosure");
		System.out.println("Rangeofdisclosure Type---" + Rangeofdisclosure);
		String MeetID = ParamUtil.getString(actionRequest, "meetingId");
		System.out.println("MeetID Type---" + MeetID);
		String Floor = ParamUtil.getString(actionRequest, "Floor");
		System.out.println("Floor Type---" + Floor);
		String ItemDetails = ParamUtil.getString(actionRequest, "ItemDetails");
		System.out.println("ItemDetails Type---" + ItemDetails);
		String Action = ParamUtil.getString(actionRequest, "Action");
		System.out.println("Action Type---" + Action);
		String ExpectedDueDate = ParamUtil.getString(actionRequest, "ExpectedDueDate");
		System.out.println("ExpectedDueDate Type---" + ExpectedDueDate);
		String PersoninCharge = ParamUtil.getString(actionRequest, "PersoninCharge");
		System.out.println("PersoninCharge Type---" + PersoninCharge);
		String OriginalDesgin = ParamUtil.getString(actionRequest, "OriginalDesgin");
		System.out.println("OriginalDesgin Type---" + OriginalDesgin);
		String DesignCostType = ParamUtil.getString(actionRequest, "DesignCostType");
		System.out.println("DesignCostType Type---" + DesignCostType);
		long DesignCost = ParamUtil.getLong(actionRequest, "DesignCost");
		
		String changeDetail = ParamUtil.getString(actionRequest, "ChangeDesgin");
		
		System.out.println("DesignCostType Type---" + DesignCostType);
		String ConstructionCostType = ParamUtil.getString(actionRequest, "ConstructionCostType");
		System.out.println("ConstructionCostType Type---" + ConstructionCostType);
		long ConstructionCost = ParamUtil.getLong(actionRequest, "ConstructionCost");
		System.out.println("ConstructionCost Type---" + ConstructionCost);
		String ExpensePayment = ParamUtil.getString(actionRequest, "ExpensePayment");
		System.out.println("ExpensePayment Type---" + ExpensePayment);
		String Attachment1 = ParamUtil.getString(actionRequest, "Attachment1");
		System.out.println("Attachment1 Type---" + longArray[0]);
		String Attachment2 = ParamUtil.getString(actionRequest, "Attachment2");
		System.out.println("Attachment2 Type---" + longArray[1]);
		String Attachment3 = ParamUtil.getString(actionRequest, "Attachment3");
		System.out.println("Attachment3 Type---" + longArray[2]);
		String Attachment4 = ParamUtil.getString(actionRequest, "Attachment4");
		System.out.println("Attachment4 Type---" + longArray[3]);
		// Inserting form data to DB by Service Builder
		try {
			
			long DCRSubSeqno = 0L;
			long groupId = 1111;
			int revisionNo = 0;
			boolean isActive = true;
			User user = PortalUtil.getUser(actionRequest);
			String UserName = user.getScreenName();
			// Insert Data to DesignChangeDetails Table
			
			DesignChangeDetails dcd = DesignChangeDetailsLocalServiceUtil.createDesignChangeDetails(DCRSeqno);
			dcd.setDcrChangeSeqno(DCRSeqno);
			dcd.setDesignchangeSubseqno(DCRSubSeqno);
			dcd.setGroupId(groupId);
			dcd.setRevisionNo(revisionNo);
			dcd.setMeetingId(MeetID);
			dcd.setIssuer(UserName);
			dcd.setChangeType(ChangeType);
			dcd.setChangeRequestby(ChangeRequestedBy);
			dcd.setRfcId(ReasonforChange);
			dcd.setChangeDetail(changeDetail);
			dcd.setRfcOthers(Others);
			dcd.setRangeOfDisclosure(Rangeofdisclosure);
			dcd.setFloor(Floor);
			dcd.setItem(ItemDetails);
			dcd.setOriginaldesginDetail(OriginalDesgin);
			dcd.setAction(Action);
			dcd.setEstdesignCosttype(DesignCostType);
			dcd.setEstdesignCost(DesignCost);
			dcd.setEstconstructionCosttype(ConstructionCostType);
			dcd.setEstconstructionCost(ConstructionCost);
			dcd.setExpenseAjustmentDivision(ExpensePayment);
			dcd.setResponsePeriod(ExpectedDueDate);
			dcd.setPersonInCharge(PersoninCharge);
			dcd.setApprovalNo(0);
			dcd.setApprovalStatus(null);
			dcd.setApprovalDate(null);
			dcd.setClientApprovalStatus(null);
			dcd.setClientApprovalDate(null);
			dcd.setConstructionStatus(null);
			dcd.setConstructionDate(null);
			dcd.setCreatedBy(UserName);
			dcd.setCreatedOn(new Date());
			dcd.setModifiedBy(UserName);
			dcd.setModifiedOn(new Date());
			dcd.setIsActive(isActive);
			if (flag == 1) {
				if (longArray.length == 4) {
					dcd.setAttachmentId1(longArray[0]);
					dcd.setAttachmentId2(longArray[1]);
					dcd.setAttachmentId3(longArray[2]);
					dcd.setAttachmentId4(longArray[3]);
				} else if (longArray.length == 3) {
					dcd.setAttachmentId1(longArray[0]);
					dcd.setAttachmentId2(longArray[1]);
					dcd.setAttachmentId3(longArray[2]);
					dcd.setAttachmentId4(0);
				} else if (longArray.length == 2) {
					dcd.setAttachmentId1(longArray[0]);
					dcd.setAttachmentId2(longArray[1]);
					dcd.setAttachmentId3(0);
					dcd.setAttachmentId4(0);
				} else {
					dcd.setAttachmentId1(longArray[0]);
					dcd.setAttachmentId2(0);
					dcd.setAttachmentId3(0);
					dcd.setAttachmentId4(0);
				}
			} else {
				dcd.setAttachmentId1(0);
				dcd.setAttachmentId2(0);
				dcd.setAttachmentId3(0);
				dcd.setAttachmentId4(0);
			}

			// Calling Service Bulder Impl class
			DesignChangeDetailsLocalServiceUtil.addDesignChangeDetails(dcd);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Code to store the attachments into the Database.
	public void fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest,long number) {
		int i = 0;
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		Folder folder = getFolder(themeDisplay);
		InputStream is;
		File file;
		String title, description, mimeType;
		long repositoryId;
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			FileItem item[] = file2.getValue();
			try {
				for (FileItem fileItem : item) {

					title = fileItem.getFileName();
					if (title != "") {
						title=Long.toString(number)+"_"+title;
						description = title + "is added through code!";
						repositoryId = themeDisplay.getScopeGroupId();
						mimeType = fileItem.getContentType();
						is = fileItem.getInputStream();
						file = fileItem.getStoreLocation();
						try {
							ServiceContext serviceContext = ServiceContextFactory
									.getInstance(DLFileEntry.class.getName(), actionRequest);
							DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title, mimeType, title,
									description, "", file, serviceContext);
							FileEntry fileentry = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(),
									folder.getFolderId(), title);
							longArray[i] = fileentry.getFileEntryId();
							i++;
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						continue;
					}

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {

		boolean folderExist = isFolderExist(themeDisplay);
		Folder folder = null;
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
						actionRequest);
				folder = DLAppServiceUtil.addFolder(repositoryId, PARENT_FOLDER_ID, ROOT_FOLDER_NAME,
						ROOT_FOLDER_DESCRIPTION, serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		}
		return folder;

	}

	public boolean isFolderExist(ThemeDisplay themeDisplay) {
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
			folderExist = true;
			System.out.println("Folder is already Exist");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folderExist;
	}

	public Folder getFolder(ThemeDisplay themeDisplay) {
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folder;
	}

	// Method for retrive the search Data
	@SuppressWarnings("deprecation")
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		if (resourceRequest.getResourceID().equals("usersObjects")) {
			System.out.println("Inside userobjects serveresource");
			String query = ParamUtil.getString(resourceRequest, "query");
			String requestType = ParamUtil.getString(resourceRequest, "requestType");
			HttpServletRequest serveletRequest = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

			if (null == query || "".equals(query)) {
				query = serveletRequest.getParameter("query");
			}

			if (null == requestType || "".equals(requestType)) {
				requestType = serveletRequest.getParameter("requestType");
			}

			if (null != requestType && "search".equals(requestType)) {
				try {

					// List<DesignChangeDetails> designChangeDetailsList =
					// DesignChangeDetailsLocalServiceUtil.getDesignChangeDetailsByFilter("","","","Patner","","","",null,null);
					// "&issuer="+issuer+"&rangeOfDisclosure="+rangeOfDisclosure+"&changeReqBy="+changeReqBy+"&dcrFromDate="+dcrFromDate+"&dcrToDate="+dcrToDate+"&approval="+approval+"&construction="+construction+"&expensePayment="+expensePayment;
					System.out.println("checkpoint2");
					System.out.println(serveletRequest.getParameter("reasonForChange"));
					System.out.println(serveletRequest.getParameter("issuer"));
					System.out.println(serveletRequest.getParameter("rangeOfDisclosure"));
					System.out.println(serveletRequest.getParameter("changeReqBy"));
					System.out.println(serveletRequest.getParameter("approval"));
					System.out.println(serveletRequest.getParameter("construction"));
					System.out.println(serveletRequest.getParameter("expensePayment"));
					System.out.println(serveletRequest.getParameter("dcrFromDate"));
					System.out.println(serveletRequest.getParameter("dcrToDate"));

					String strTo = serveletRequest.getParameter("dcrToDate");
					String strFrom = serveletRequest.getParameter("dcrFromDate");
					if (strTo == "") {
						if (strFrom == "" || strFrom.equals(null)) {
							List<DesignChangeDetails> designChangeDetailsList = DesignChangeDetailsLocalServiceUtil
									.getDesignChangeDetailsByFilter(
											(String) serveletRequest.getParameter("reasonForChange"),
											(String) serveletRequest.getParameter("issuer"),
											(String) serveletRequest.getParameter("rangeOfDisclosure"),
											(String) serveletRequest.getParameter("changeReqBy"),
											(String) serveletRequest.getParameter("approval"),
											(String) serveletRequest.getParameter("construction"),
											(String) serveletRequest.getParameter("expensePayment"), null, null);
							arrayOfJSONUserData(resourceRequest, resourceResponse, designChangeDetailsList);
						} else {
							// Date dateFrom=new SimpleDateFormat("dd/MM/yyyy").parse(strFrom);
							System.out.println("strFrom-->"+strFrom);
							Date dateFrom = StringtoDate(strFrom);
							List<DesignChangeDetails> designChangeDetailsList = DesignChangeDetailsLocalServiceUtil
									.getDesignChangeDetailsByFilter(
											(String) serveletRequest.getParameter("reasonForChange"),
											(String) serveletRequest.getParameter("issuer"),
											(String) serveletRequest.getParameter("rangeOfDisclosure"),
											(String) serveletRequest.getParameter("changeReqBy"),
											(String) serveletRequest.getParameter("approval"),
											(String) serveletRequest.getParameter("construction"),
											(String) serveletRequest.getParameter("expensePayment"), dateFrom, null);
							arrayOfJSONUserData(resourceRequest, resourceResponse, designChangeDetailsList);
						}
					} else {
						Date dateTO = StringtoDate(strTo);
						if (strFrom == "") {
							List<DesignChangeDetails> designChangeDetailsList = DesignChangeDetailsLocalServiceUtil
									.getDesignChangeDetailsByFilter(
											(String) serveletRequest.getParameter("reasonForChange"),
											(String) serveletRequest.getParameter("issuer"),
											(String) serveletRequest.getParameter("rangeOfDisclosure"),
											(String) serveletRequest.getParameter("changeReqBy"),
											(String) serveletRequest.getParameter("approval"),
											(String) serveletRequest.getParameter("construction"),
											(String) serveletRequest.getParameter("expensePayment"), null, dateTO);
							arrayOfJSONUserData(resourceRequest, resourceResponse, designChangeDetailsList);
						} else {

							Date dateFrom = StringtoDate(strFrom);
							List<DesignChangeDetails> designChangeDetailsList = DesignChangeDetailsLocalServiceUtil
									.getDesignChangeDetailsByFilter(
											(String) serveletRequest.getParameter("reasonForChange"),
											(String) serveletRequest.getParameter("issuer"),
											(String) serveletRequest.getParameter("rangeOfDisclosure"),
											(String) serveletRequest.getParameter("changeReqBy"),
											(String) serveletRequest.getParameter("approval"),
											(String) serveletRequest.getParameter("construction"),
											(String) serveletRequest.getParameter("expensePayment"), dateFrom, dateTO);
							arrayOfJSONUserData(resourceRequest, resourceResponse, designChangeDetailsList);
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				try {
					List<DesignChangeDetails> designChangeDetailsList = DesignChangeDetailsLocalServiceUtil
							.getDesignChangeDetailses(-1, -1);
					arrayOfJSONUserData(resourceRequest, resourceResponse, designChangeDetailsList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (resourceRequest.getResourceID().equals("searchPopUpData")) {

			/*
			 * System.out.println("inside resource method popup");
			 * 
			 * String MeetingType = resourceRequest.getParameter("MeetingType"); String
			 * MeetingId = resourceRequest.getParameter("MeetingId"); String Issuer =
			 * resourceRequest.getParameter("Issuer"); String MeetingFrmDate =
			 * resourceRequest.getParameter("MeetingFrmDate"); String MeetingToDate =
			 * resourceRequest.getParameter("MeetingToDate"); String MeetingTitle =
			 * resourceRequest.getParameter("MeetingTitle"); Date FrmDate = null; if
			 * (MeetingFrmDate.equals(null) || MeetingFrmDate.equals("")) {
			 * System.out.println("inside MeetingFrmDate.equals(null)"); FrmDate = null; }
			 * else { System.out.println("inside MeetingFrmDate--else"); FrmDate =
			 * StringtoDate(MeetingFrmDate); } Date ToDate = null; if
			 * (MeetingToDate.equals(null) || MeetingToDate.equals("")) {
			 * System.out.println("inside MeetingToDate.equals(null)"); ToDate = null; }
			 * else { System.out.println("inside MeetingToDate--else"); ToDate =
			 * StringtoDate(MeetingToDate);
			 * 
			 * } System.out.println("MeetingToDate" + ToDate);
			 * 
			 * // Date todate = getStringToDate(MeetingToDate);
			 * 
			 * System.out.println("MeetingFrmDate" + FrmDate);
			 * 
			 * JSONArray searchData = JSONFactoryUtil.createJSONArray(); ArrayList<String>
			 * arr = new ArrayList<String>();
			 * 
			 * try { List<TriggerMeeting> Meetins =
			 * TriggerMeetingLocalServiceUtil.getTriggerMeetingByFilter(MeetingType,
			 * MeetingId, Issuer, MeetingTitle, FrmDate, ToDate);
			 * System.out.println("Search Array Size" + Meetins); for (TriggerMeeting tm :
			 * Meetins) { List<TriggerMeetingDetails> MeetinsDetails = new
			 * ArrayList<TriggerMeetingDetails>(); MeetinsDetails
			 * .addAll(TriggerMeetingDetailsLocalServiceUtil.findByMeetingSeqnoList(tm.
			 * getMeetingSeqno())); for (TriggerMeetingDetails tmd : MeetinsDetails) {
			 * 
			 * arr.add(tm.getMeetingId()); arr.add(tm.getIssuer()); if (tm.getMeetDate() !=
			 * null) { arr.add(dateFormat(tm.getMeetDate())); } else { arr.add(""); }
			 * arr.add(tm.getMeetingType()); arr.add(tm.getMeetingTitle());
			 * arr.add(tmd.getFloor()); arr.add(tmd.getItem()); arr.add(tmd.getActions());
			 * if (tmd.getRESPONSE_DUEDATE() != null) {
			 * arr.add(dateFormat(tmd.getRESPONSE_DUEDATE())); } else { arr.add(""); }
			 * arr.add(tmd.getPersonInCharge()); }
			 * 
			 * }
			 * 
			 * System.out.println("Arrray Size---" + arr.size()); for (int i = 0; i <
			 * arr.size(); i += 10) { JSONObject jsonobj =
			 * JSONFactoryUtil.createJSONObject(); jsonobj.put("MeetingId", arr.get(i));
			 * jsonobj.put("Issuer", arr.get(i + 1)); jsonobj.put("MeetingDate", arr.get(i +
			 * 2)); jsonobj.put("MeetingType", arr.get(i + 3)); jsonobj.put("MeetingTitle",
			 * arr.get(i + 4));
			 * 
			 * jsonobj.put("Floor", arr.get(i + 5)); jsonobj.put("Items", arr.get(i + 6));
			 * jsonobj.put("Action", arr.get(i + 7)); jsonobj.put("dueDate", arr.get(i +
			 * 8)); jsonobj.put("person", arr.get(i + 9)); searchData.put(jsonobj); //
			 * System.out.println("searchData>>>>>>>" + searchData.getString(i)); } } catch
			 * (Exception e) { e.printStackTrace(); }
			 * 
			 * // jsonobj.put("UserEmail", Meetins); //
			 * System.out.println("searchData size===-" + searchData.length()); arr.clear();
			 * PrintWriter printout = resourceResponse.getWriter();
			 * printout.print(searchData.toString());
			 */
			
			System.out.println("inside meeting popup");

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
			if (null == MeetingFrmDate || MeetingFrmDate.isEmpty()) {
				MeetingFrmDate = serveletRequest.getParameter("MeetingFrmDate");

			}
			if (null == MeetingToDate || MeetingToDate.isEmpty()) {
				MeetingToDate = serveletRequest.getParameter("MeetingToDate");
			}
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
				
				//HttpServletRequest serveletRequest = PortalUtil
					//	.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

				
				JSONArray allUsersJsonArray = JSONFactoryUtil.createJSONArray();
				JSONArray jsonUserArray = null;
				for (int i = 0; i < Meetins.size(); i++) {
					TriggerMeeting tm = Meetins.get(i);
					jsonUserArray = JSONFactoryUtil.createJSONArray();
					jsonUserArray.put(tm.getMeetingSeqno());
					jsonUserArray.put(i + 1);
					jsonUserArray.put(tm.getMeetingId());
					jsonUserArray.put(tm.getIssuer());
					if (tm.getMeetDate() != null) {
						jsonUserArray.put(dateFormat(tm.getMeetDate()));
					} else {
						jsonUserArray.put("");
					}
					
					jsonUserArray.put(LanguageUtil.get(serveletRequest, tm.getMeetingType()));
					jsonUserArray.put(tm.getMeetingTitle());
					
					
					//add by sanjay
					List<TriggerMeetingDetails> MeetinsDetails =TriggerMeetingDetailsLocalServiceUtil.findByMeetingSeqnoList(tm.getMeetingSeqno());
					for (TriggerMeetingDetails tmd : MeetinsDetails) {
						//Date resDate;
						if (tmd.getRESPONSE_DUEDATE() != null) {
							//SimpleDateFormat rddate = new SimpleDateFormat("yyyy-MM-dd");
							//SimpleDateFormat srddate = new SimpleDateFormat("MM-dd-yyyy");
						    //String rDate = rdDate.format(tmd.getRESPONSE_DUEDATE());
						   	//resDate = srddate.format(rddate.parse(rDate));
						   // resDate=StringtoDate(rDate);
						   	jsonUserArray.put(tmd.getFloor());
						   	jsonUserArray.put(tmd.getItem());
						   	jsonUserArray.put(tmd.getActions());
						   	jsonUserArray.put(tmd.getPersonInCharge());
						   	
						   	System.out.println("date hereeeeee"+tmd.getRESPONSE_DUEDATE());
						   	jsonUserArray.put(dateFormat(tmd.getRESPONSE_DUEDATE()));
						   	
						   	System.out.println(tmd.getRESPONSE_DUEDATE());
						} else {
							jsonUserArray.put("");
						}
					
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

		}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
			
///

	}

	private String dateFormat(Date date) throws ParseException {

		SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatDate = sdf1.format(date);
		String formatedDate = sdf2.format(sdf1.parse(formatDate));
		// System.out.println("My Date"+formatDate);
		return formatedDate;
	}

	// String to Date convert method
	private Date StringtoDate(String meetingDate) {
		// System.out.println("Before meeting date convert" + meetingDate);
		Date convertedDate = null;
		DateFormat formatter = null;
		try {
			if (!meetingDate.equals(null)) {

				formatter = new SimpleDateFormat("yyyy-MM-dd");
				convertedDate = (Date) formatter.parse(meetingDate);
				// date = new SimpleDateFormat("yyyy-mm-dd").parse(meetingDate);
				// System.out.println("After Meeting date convart" + convertedDate);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertedDate;
	}

	public void arrayOfJSONUserData(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			List<DesignChangeDetails> designChangeDetailsList) throws IOException, PortletException {
		JSONArray allUsersJsonArray = JSONFactoryUtil.createJSONArray();
		try {
			JSONArray jsonUserArray = null;

			for (DesignChangeDetails designChangeDetails : designChangeDetailsList) {
				jsonUserArray = JSONFactoryUtil.createJSONArray();
				jsonUserArray.put(designChangeDetails.getDcrChangeSeqno()+","+designChangeDetails.getApprovalNo() +","+designChangeDetails.getApprovalStatus());
				HttpServletRequest serveletRequest = PortalUtil
						.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

				jsonUserArray.put(LanguageUtil.get(serveletRequest, designChangeDetails.getChangeRequestby()));
				jsonUserArray.put(designChangeDetails.getDcrChangeSeqno());
				jsonUserArray.put(designChangeDetails.getItem());
				jsonUserArray.put(designChangeDetails.getAction());
				jsonUserArray.put(designChangeDetails.getFloor());
				jsonUserArray.put(designChangeDetails.getEstdesignCost());
				jsonUserArray.put(designChangeDetails.getEstconstructionCost());
				jsonUserArray.put(LanguageUtil.get(serveletRequest, designChangeDetails.getExpenseAjustmentDivision()));

				String pattern = "dd-MMM-yyyy";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				String date = simpleDateFormat.format(designChangeDetails.getCreatedOn());
				jsonUserArray.put(date);
				jsonUserArray.put(LanguageUtil.get(serveletRequest, designChangeDetails.getApprovalStatus()));
				jsonUserArray.put(designChangeDetails);
				allUsersJsonArray.put(jsonUserArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject tableData = JSONFactoryUtil.createJSONObject();
		tableData.put("data", allUsersJsonArray);
		ServletResponseUtil.write(PortalUtil.getHttpServletResponse(resourceResponse), tableData.toString());
	}
	
	public void fileUpload1(ThemeDisplay themeDisplay, ActionRequest actionRequest,long number) {
		int i = 0;
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		Folder folder = getFolder(themeDisplay);
		InputStream is;
		File file;
		String title, description, mimeType;
		long repositoryId;
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			FileItem item[] = file2.getValue();
			try {
				for (FileItem fileItem : item) {

					title = fileItem.getFileName();
					if (title != "") {
						title=Long.toString(number)+"_"+title;
						description = title + "is added through code!";
						repositoryId = themeDisplay.getScopeGroupId();
						mimeType = fileItem.getContentType();
						is = fileItem.getInputStream();
						file = fileItem.getStoreLocation();
						try {
							ServiceContext serviceContext = ServiceContextFactory
									.getInstance(DLFileEntry.class.getName(), actionRequest);
							DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title, mimeType, title,
									description, "", file, serviceContext);
							FileEntry fileentry = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(),
									folder.getFolderId(), title);
							 array.add(fileentry.getFileEntryId());
							i++;
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						continue;
					}

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

//			@Override
//			public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)throws IOException , PortletException{
//			
//			}

}