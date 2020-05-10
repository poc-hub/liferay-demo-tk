package com.tcs.DCR.portlet;

import com.tcs.DCR.constants.DCRControllerPortletKeys;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.File;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.takenaka.model.DesignChangeDetails;
import com.takenaka.model.TriggerMeeting;
import com.takenaka.service.DesignChangeDetailsLocalServiceUtil;
import com.takenaka.service.TriggerMeetingLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author MADDY
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DCRController",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DCRControllerPortletKeys.DCRCONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js"
	},
	service = Portlet.class
)
public class DCRControllerPortlet extends MVCPortlet {
	
	// Method for meeting Data Submit into Database
		@ProcessAction(name = "DCRAction")
	public void submitDCR(ActionRequest actionRequest, ActionResponse actionResponse)
				throws PortletException, IOException {
			System.out.println("Calling submitDCR-----");
			String Project = ParamUtil.getString(actionRequest, "Project");
			System.out.println("Project" + Project);
			String ChangeType = ParamUtil.getString(actionRequest, "ChangeType");
			System.out.println("Change Type---"+ChangeType);	
			String ChangeRequestedBy = ParamUtil.getString(actionRequest, "ChangeRequestedBy");
			System.out.println("ChangeRequestedBy---"+ChangeRequestedBy);
			String ReasonforChange = ParamUtil.getString(actionRequest, "ReasonforChange");
			System.out.println("ReasonforChange Type---"+ReasonforChange);
			String Others = ParamUtil.getString(actionRequest, "Others");
			System.out.println("Others Type---"+Others);
			String Rangeofdisclosure = ParamUtil.getString(actionRequest, "Rangeofdisclosure");
			System.out.println("Rangeofdisclosure Type---"+Rangeofdisclosure);
			String MeetID = ParamUtil.getString(actionRequest, "MeetID");
			System.out.println("MeetID Type---"+MeetID);
			String Floor = ParamUtil.getString(actionRequest, "Floor");
			System.out.println("Floor Type---"+Floor);
			String ItemDetails = ParamUtil.getString(actionRequest, "ItemDetails");
			System.out.println("ItemDetails Type---"+ItemDetails);
			String Action = ParamUtil.getString(actionRequest, "Action");
			System.out.println("Action Type---"+Action);
			String ExpectedDueDate = ParamUtil.getString(actionRequest, "ExpectedDueDate");
			System.out.println("ExpectedDueDate Type---"+ExpectedDueDate);
			String PersoninCharge = ParamUtil.getString(actionRequest, "PersoninCharge");
			System.out.println("PersoninCharge Type---"+PersoninCharge);
			String OriginalDesgin = ParamUtil.getString(actionRequest, "OriginalDesgin");
			System.out.println("OriginalDesgin Type---"+OriginalDesgin);
			String DesignCostType = ParamUtil.getString(actionRequest, "DesignCostType");
			System.out.println("DesignCostType Type---"+DesignCostType);
			long DesignCost = ParamUtil.getLong(actionRequest, "DesignCost");
			System.out.println("DesignCostType Type---"+DesignCostType);
			String ConstructionCostType = ParamUtil.getString(actionRequest, "ConstructionCostType");
			System.out.println("ConstructionCostType Type---"+ConstructionCostType);
			long ConstructionCost = ParamUtil.getLong(actionRequest, "ConstructionCost");
			System.out.println("ConstructionCost Type---"+ConstructionCost);
			String ExpensePayment = ParamUtil.getString(actionRequest, "ExpensePayment");
			System.out.println("ExpensePayment Type---"+ExpensePayment);
			String Attachment1 = ParamUtil.getString(actionRequest, "Attachment1");
			System.out.println("Attachment1 Type---"+Attachment1);
			String Attachment2 = ParamUtil.getString(actionRequest, "Attachment2");
			System.out.println("Attachment2 Type---"+Attachment2);
			String Attachment3 = ParamUtil.getString(actionRequest, "Attachment3");
			System.out.println("Attachment3 Type---"+Attachment3);
			String Attachment4 = ParamUtil.getString(actionRequest, "Attachment4");
			System.out.println("Attachment4 Type---"+Attachment4);
			// Inserting form data to DB by Service Builder
			try {
				long DCRSeqno = 0L;
				long DCRSubSeqno = 0L;
				long groupId = 1111;
				int revisionNo=0;
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
				
				// Calling Service Bulder Impl class
				DesignChangeDetailsLocalServiceUtil.addDesignChangeDetails(dcd);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
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
		
}