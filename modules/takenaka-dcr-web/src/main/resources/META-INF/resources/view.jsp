<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="dcrcontroller.caption"/></b>
</p>

<portlet:actionURL name="SearchAction" var="searchVar" />



<liferay-ui:tabs names="Meeting  Details,Design Change ,Distribution List" refresh="false" 
tabsValues="Meeting  Details,Design Change,Distribution List">
    <liferay-ui:section>
    
        <div class="container">
			<div class="row">
				<div class="col-sm">
					<div class="form-group">
						<label for="usr">Project</label> <input type="text"
							class="form-control" id="projectId" name="project">
					</div>
				</div>
				
				<div class="col-sm">
					<div class="form-group">
						<label for="usr">Meeting ID</label> 
							<select class="custom-select"
								id="meetingId" name="MeetingId">
								<option selected>Choose...</option>
								<!-- <option value="Design Type">Design Type</option>
								<option value="External">External</option>
								<option value="Other">Other</option> -->
							</select>
					</div>
				</div>
				
				<div class="col-sm">
					<div class="form-group">
						<label for="usr">Change ID</label> 
						<input type="text" class="form-control" id="changeIDID" name="changeId">
					</div>
				</div>
				
				<div class="col-sm">
					<div class="form-group">
						<label for="usr">Revision ID</label> <input type="text"
							class="form-control" id="revisionIDID" name="revisionId">
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-sm">
					<div class="form-group">
						<label for="usr">Change Type</label> 
							<select class="custom-select"
								id="changeTypeId" name="changeType">
								<option selected>Choose...</option>
								<!-- <option value="Design Type">Design Type</option>
								<option value="External">External</option>
								<option value="Other">Other</option> -->
							</select>
					</div>
				</div>
				
				<div class="col-sm">
					<div class="form-group">
						<label for="usr">Change Requested By</label> 
							<select class="custom-select"
								id="changeRequestedById" name="changeRequestedBy">
								<option selected>Choose...</option>
								<!-- <option value="Design Type">Design Type</option>
								<option value="External">External</option>
								<option value="Other">Other</option> -->
							</select>
					</div>
				</div>
				
				<div class="col-sm">
					<div class="form-group">
						<label for="usr">Design Code</label> 
							<select class="custom-select"
								id="designCodeId" name="designCode">
								<option selected>Choose...</option>
								<!-- <option value="Design Type">Design Type</option>
								<option value="External">External</option>
								<option value="Other">Other</option> -->
							</select>
					</div>
				</div>
				
				
				<div class="col-sm">
					<div class="form-group">
						<label for="usr">Issuer</label> <input type="text"
							class="form-control" id="issuerId" name="issuer">
					</div>
				</div>
				
			</div>
			
			
			<div class="row">
				<div class="col-sm">
					<div class="form-group">
						<label for="usr">Meeting Title</label> <input type="text"
							class="form-control" id="MeetingTitleId" name="meetingTitle">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm">
					<div class="form-group">
						<label for="usr">Summary of Changes</label> <input type="text"
							class="form-control" id="summaryOfChangesId" name="summaryOfChanges">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<center>
						<button type="button" class="btn btn-secondary">
							Save As Draft </button>
					</center>
				</div>
				<div class="col-sm-3">
					<center>
						<button type="button" class="btn btn-secondary">
							Reset</button>
					</center>
				</div>
				<div class="col-sm-3">
					<center>
						<button type="button" class="btn btn-secondary">
							Cancel</button>
					</center>
				</div>
				<div class="col-sm-3">
					<center>
						<button type="button" class="btn btn-secondary">
							Next</button>
					</center>
				</div>
			
			</div>
			
		</div>
        
        
    </liferay-ui:section>
    
    
    <liferay-ui:section>
    
       <%@ include file="designChnageNew.jsp" %>
        
        
    </liferay-ui:section>
    
    
    <liferay-ui:section>
    
    
        <%@ include file="distributionList.jsp" %>
        
        
    </liferay-ui:section>
    
    <liferay-ui:section>
    
       <%@ include file="designChnageNew.jsp" %>
        
        
    </liferay-ui:section>
</liferay-ui:tabs>

