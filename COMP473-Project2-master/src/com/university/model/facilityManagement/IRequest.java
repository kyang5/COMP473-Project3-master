package com.university.model.facilityManagement;

import com.university.model.facility.IFacilityRoom;

import java.util.Date;

public interface IRequest {
    int getRequestID();
    Date getRequestDate();
    String getRequestStatus();
    int getRequestorID();
    String getRequestType();
    String getProblem();
    void setProblem(String problem);
    void setRequestType(String requestType);
    void setRequestID(int requestID);
    void setRequestDate(Date requestDate);
    void setRequestorID(int requestorID);
    void setRequestStatus(String requestStatus);
    IFacilityRoom getFacilityRoom();
    void setFacilityRoom(IFacilityRoom facilityRoom);
}
