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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.takenaka.model.DesignChangeDetails;
import com.takenaka.service.DesignChangeDetailsLocalServiceUtil;
import com.tcs.DCR.constants.DCRControllerPortletKeys;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
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
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js" }, service = Portlet.class)
public class DCRControllerPortlet extends MVCPortlet {
	
		private static String ROOT_FOLDER_NAME = "File_Upload";
		private static String ROOT_FOLDER_DESCRIPTION = "Test Descprition";
		private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long[] longArray = new long[4];

	// Method for meeting Data Submit into Database
	@ProcessAction(name = "DCRAction")
	public void submitDCR(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, IOException {
		int counter=0;
		int flag=0;
		FileItem[] item;
		ThemeDisplay themeDisplay=(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		UploadPortletRequest uploadPortletRequest=PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String,FileItem[]> files=uploadPortletRequest.getMultipartParameterMap();
		System.out.println("the map"+files.keySet());
		for(Entry<String,FileItem[]>file2:files.entrySet()) {
			FileItem item1[]=file2.getValue();
			for(FileItem item2:item1) {
				if(item2.getFileName()!="") {
					System.out.println(item2.getFileName());
					counter++;
				}
			}
		}
		if(counter!=0) {
			flag=1;
			createFolder(actionRequest,themeDisplay);
			fileUpload(themeDisplay,actionRequest);
		}
		


		
		
		
		System.out.println("Calling submitDCR-----");
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
			long DCRSeqno = 0L;
			long DCRSubSeqno = 0L;
			long groupId = 1111;
			int revisionNo = 0;
			boolean isActive = true;
			User user = PortalUtil.getUser(actionRequest);
			String UserName = user.getScreenName();
			// Insert Data to DesignChangeDetails Table
			DCRSeqno = CounterLocalServiceUtil.increment(DesignChangeDetails.class.getName());
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
			dcd.setRfcOthers(Others);
			dcd.setRangeOfDisclosure(Rangeofdisclosure);
			dcd.setFloor(Floor);
			dcd.setItem(ItemDetails);
			dcd.setOriginaldesginDetail(OriginalDesgin);
			dcd.setChangeDetail(ChangeType);
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
			if(flag==1) {
				if(longArray.length==4) {
					dcd.setAttachmentId1(longArray[0]);
					dcd.setAttachmentId2(longArray[1]);
					dcd.setAttachmentId3(longArray[2]);
					dcd.setAttachmentId4(longArray[3]);
					}
					else if(longArray.length==3) {
						dcd.setAttachmentId1(longArray[0]);
						dcd.setAttachmentId2(longArray[1]);
						dcd.setAttachmentId3(longArray[2]);
						dcd.setAttachmentId4(0);
					}
					else if(longArray.length==2) {
						dcd.setAttachmentId1(longArray[0]);
						dcd.setAttachmentId2(longArray[1]);
						dcd.setAttachmentId3(0);
						dcd.setAttachmentId4(0);
					}
					else {
						dcd.setAttachmentId1(longArray[0]);
						dcd.setAttachmentId2(0);
						dcd.setAttachmentId3(0);
						dcd.setAttachmentId4(0);
					}
			}
			else{
				dcd.setAttachmentId1(0);
				dcd.setAttachmentId2(0);
				dcd.setAttachmentId3(0);
				dcd.setAttachmentId4(0);
			}
			

			// Calling Service Bulder Impl class
			DesignChangeDetailsLocalServiceUtil.addDesignChangeDetails(dcd);
			//Code to store the attachments into the Database.
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest) {
		int i=0;
		UploadPortletRequest uploadPortletRequest=PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String,FileItem[]> files=uploadPortletRequest.getMultipartParameterMap();
		Folder folder=getFolder(themeDisplay);
		InputStream is;
		File file;
		String title,description,mimeType;
		long repositoryId;
		for(Entry<String,FileItem[]>file2:files.entrySet()) {
			FileItem item[]=file2.getValue();
				try {
				for(FileItem fileItem:item) {
					
					title=fileItem.getFileName();
					if(title!="") {
						description=title+"is added through code!";
						repositoryId=themeDisplay.getScopeGroupId();
						mimeType=fileItem.getContentType();
						is=fileItem.getInputStream();
						file=fileItem.getStoreLocation();
						try {
							ServiceContext serviceContext= ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
							DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title, mimeType, title, description, "", file, serviceContext);
							FileEntry fileentry=DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folder.getFolderId(), title);
							longArray[i]=fileentry.getFileEntryId();
							i++;
						}catch(Exception e) {
							e.printStackTrace();
						}
					
					}else {
						continue;
					}
						
					}
				}
				catch (IOException e) {
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
					ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
					folder = DLAppServiceUtil.addFolder(repositoryId,PARENT_FOLDER_ID, ROOT_FOLDER_NAME,ROOT_FOLDER_DESCRIPTION, serviceContext);
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
	public Folder getFolder(ThemeDisplay themeDisplay){
		Folder folder = null;
		try {
			folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
	}

	/*
	 * @SuppressWarnings({ "unused", "null" })
	 * 
	 * @Override public void render(RenderRequest renderRequest, RenderResponse
	 * renderResponse) throws IOException, PortletException {
	 * System.out.println("Calling Render Method"); try { ArrayList<String> arr =
	 * new ArrayList<String>(); // int totalMeetings =
	 * TriggerMeetingLocalServiceUtil.getTriggerMeetingsCount();
	 * List<TriggerMeeting> Meetins =
	 * TriggerMeetingLocalServiceUtil.getTriggerMeetings(0, 5); if
	 * (!Meetins.isEmpty()) { for (TriggerMeeting tm : Meetins) {
	 * List<TriggerMeetingDetails> MeetinsDetails = new
	 * ArrayList<TriggerMeetingDetails>(); //Adding Trigger Meeting table data //
	 * Adding Meeting Trigger Meeting table data MeetinsDetails
	 * =TriggerMeetingDetailsLocalServiceUtil
	 * .findByMeetingSeqnoList(tm.getMeetingSeqno()); for(TriggerMeetingDetails tmd
	 * : MeetinsDetails) { arr.add(tm.getMeetingId()); arr.add(tm.getIssuer()); if
	 * (tm.getMeetDate() != null) { arr.add(dateFormat(tm.getMeetDate())); } else {
	 * arr.add(""); } arr.add(tm.getMeetingType()); arr.add(tm.getMeetingTitle());
	 * arr.add(tmd.getFloor()); arr.add(tmd.getItem()); arr.add(tmd.getActions()); }
	 * } System.out.println("Render Call Meeing Size:->" + Meetins.size());
	 * //System.out.println("Render Call MeetinsDetails: " + MeetinsDetails.size());
	 * System.out.println("Render Call arr: " + arr.size()); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * super.render(renderRequest, renderResponse); }
	 * 
	 * private String dateFormat(Date meetDate) throws ParseException {
	 * 
	 * SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy"); SimpleDateFormat
	 * sdf1 = new SimpleDateFormat("yyyy-MM-dd"); String formatDate =
	 * sdf1.format(meetDate); String formatedDate =
	 * sdf2.format(sdf1.parse(formatDate)); //
	 * System.out.println("My Date"+formatDate); return formatedDate; }
	 */

	/*
	 * private static String ROOT_FOLDER_NAME = "File_Upload"; private static String
	 * ROOT_FOLDER_DESCRIPTION = "This folder is create for Upload documents";
	 * private static long PARENT_FOLDER_ID =
	 * DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	 * 
	 * public void uploadDocument(ActionRequest actionRequest,ActionResponse
	 * actionResponse) throws IOException,PortletException, PortalException,
	 * SystemException { ThemeDisplay themeDisplay = (ThemeDisplay)
	 * actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	 * createFolder(actionRequest, themeDisplay); fileUpload(themeDisplay,
	 * actionRequest);
	 * 
	 * }
	 * 
	 * public void downloadFiles(ActionRequest actionRequest,ActionResponse
	 * actionResponse) throws IOException,PortletException, PortalException,
	 * SystemException { ThemeDisplay themeDisplay = (ThemeDisplay)
	 * actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	 * 
	 * Map<String,String> urlMap = getAllFileLink(themeDisplay);
	 * actionRequest.setAttribute("urlMap", urlMap);
	 * actionResponse.setRenderParameter("jspPage","/download.jsp"); } public Folder
	 * createFolder(ActionRequest actionRequest,ThemeDisplay themeDisplay) { boolean
	 * folderExist = isFolderExist(themeDisplay); Folder folder = null; if
	 * (!folderExist) { long repositoryId = themeDisplay.getScopeGroupId(); try {
	 * ServiceContext serviceContext =
	 * ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
	 * folder = DLAppServiceUtil.addFolder(repositoryId,PARENT_FOLDER_ID,
	 * ROOT_FOLDER_NAME,ROOT_FOLDER_DESCRIPTION, serviceContext); } catch
	 * (PortalException e1) { e1.printStackTrace(); } catch (SystemException e1) {
	 * e1.printStackTrace(); } } return folder; }
	 * 
	 * 
	 * public boolean isFolderExist(ThemeDisplay themeDisplay){ boolean folderExist
	 * = false; try { DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
	 * PARENT_FOLDER_ID, ROOT_FOLDER_NAME); folderExist = true;
	 * System.out.println("Folder is already Exist"); } catch (Exception e) {
	 * System.out.println(e.getMessage()); } return folderExist; }
	 * 
	 * public Folder getFolder(ThemeDisplay themeDisplay){ Folder folder = null; try
	 * { folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
	 * PARENT_FOLDER_ID, ROOT_FOLDER_NAME); } catch (Exception e) {
	 * System.out.println(e.getMessage()); } return folder; }
	 * 
	 * 
	 * public void fileUpload(ThemeDisplay themeDisplay,ActionRequest actionRequest)
	 * { UploadPortletRequest uploadPortletRequest =
	 * PortalUtil.getUploadPortletRequest(actionRequest);
	 * 
	 * String fileName=uploadPortletRequest.getFileName("uploadedFile");
	 * java.io.File file = uploadPortletRequest.getFile("uploadedFile"); String
	 * mimeType = uploadPortletRequest.getContentType("uploadedFile"); String title
	 * = fileName; String description = "This file is added via programatically";
	 * long repositoryId = themeDisplay.getScopeGroupId();
	 * System.out.println("Title=>"+title); try { Folder folder =
	 * getFolder(themeDisplay); ServiceContext serviceContext =
	 * ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
	 * actionRequest); InputStream is = new FileInputStream(file);
	 * DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName,
	 * mimeType, title, description, "", is, ((java.io.File) file).getTotalSpace(),
	 * serviceContext);
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage());
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * public Map<String, String> getAllFileLink(ThemeDisplay themeDisplay){
	 * Map<String, String> urlMap = new HashMap<String, String>();//key = file name
	 * ,value = url long repositoryId = themeDisplay.getScopeGroupId(); try { Folder
	 * folder =getFolder(themeDisplay); List<FileEntry> fileEntries =
	 * DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId()); for
	 * (FileEntry file : fileEntries) { String url = themeDisplay.getPortalURL() +
	 * themeDisplay.getPathContext() + "/documents/" +
	 * themeDisplay.getScopeGroupId() + "/" + file.getFolderId() + "/"
	 * +file.getTitle() ; urlMap.put(file.getTitle().split("\\.")[0], url);// remove
	 * jpg or pdf
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); } return urlMap;
	 * 
	 * }
	 */
	
	
	
	public void arrayOfJSONUserData(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse,List<DesignChangeDetails> designChangeDetailsList) throws IOException,
			PortletException {
			JSONArray allUsersJsonArray = JSONFactoryUtil.createJSONArray();
			try {
			JSONArray jsonUserArray = null;


			for (DesignChangeDetails designChangeDetails : designChangeDetailsList) {
			jsonUserArray = JSONFactoryUtil.createJSONArray();
			jsonUserArray.put(designChangeDetails.getDcrChangeSeqno());
			jsonUserArray.put(designChangeDetails.getChangeRequestby());
			jsonUserArray.put(designChangeDetails.getDcrChangeSeqno());
			jsonUserArray.put(designChangeDetails.getItem());
			jsonUserArray.put(designChangeDetails.getAction());
			jsonUserArray.put(designChangeDetails.getFloor());
			jsonUserArray.put(designChangeDetails.getEstdesignCost());
			jsonUserArray.put(designChangeDetails.getEstconstructionCost());
			jsonUserArray.put(designChangeDetails.getExpenseAjustmentDivision());

			String pattern = "dd-MMM-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(designChangeDetails.getCreatedOn());
			jsonUserArray.put(date);
			jsonUserArray.put(designChangeDetails.getApprovalStatus());
			jsonUserArray.put(designChangeDetails);
			allUsersJsonArray.put(jsonUserArray);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}

			JSONObject tableData = JSONFactoryUtil.createJSONObject();
			tableData.put("data", allUsersJsonArray);
			ServletResponseUtil.write(PortalUtil.getHttpServletResponse(resourceResponse),
			tableData.toString());
			}

			@Override
			public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)throws IOException , PortletException{
			String query = ParamUtil.getString(resourceRequest,"query");
			String requestType = ParamUtil.getString(resourceRequest,"requestType");
			HttpServletRequest serveletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

			if(null == query || "".equals(query)){
				query = serveletRequest.getParameter("query");
			}

			if(null == requestType || "".equals(requestType)){
				requestType = serveletRequest.getParameter("requestType");
			}

			if(null != requestType && "search".equals(requestType)){
				try{
					List<DesignChangeDetails> designChangeDetailsList = DesignChangeDetailsLocalServiceUtil.getDesignChangeDetailsByFilter("1","","","","","","",null,null);
					arrayOfJSONUserData(resourceRequest,resourceResponse,designChangeDetailsList);
				}
				catch(Exception e){
					e.printStackTrace();
				}

			}
			else{
				try{
					List<DesignChangeDetails> designChangeDetailsList = DesignChangeDetailsLocalServiceUtil.getDesignChangeDetailses(-1,-1);
					arrayOfJSONUserData(resourceRequest,resourceResponse,designChangeDetailsList);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			}
	

}