package com.university.model.facilityManagement;

import com.university.model.facility.IFacilityRoom;

import java.util.Date;

public interface ISchedule {
    int getScheduleID();
    void setScheduleID(int scheduleID);
    Date getMaintenanceStartDate();
    void setMaintenanceStartDate(Date maintenanceStartDate);
    Date getMaintenanceEndDate();
    void setMaintenanceEndDate(Date maintenanceEndDate);
    IWorker getMaintenanceWorker();
    void setMaintenanceWorker(IWorker maintenanceWorker);
    IFacilityRoom getFacilityRoom();
    void setFacilityRoom(IFacilityRoom facilityRoom);
    long calcDownTimeForFacilityRoom(Date maintenanceStartDate, Date maintenanceEndDate);
    String accept(ILog maintenanceLog);
    //Implementation of Visitor Pattern.
}
