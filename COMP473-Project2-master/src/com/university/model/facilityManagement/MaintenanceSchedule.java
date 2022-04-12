package com.university.model.facilityManagement;
import com.university.model.facility.IFacilityRoom;

import java.util.*;

public class MaintenanceSchedule implements ISchedule {
    private Date maintenanceStartDate;
    private Date maintenanceEndDate;
    private int scheduleID;
    private IWorker maintenanceWorker;
    private IFacilityRoom facilityRoom;

    public int getScheduleID(){
        return scheduleID;
    }
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }
    public Date getMaintenanceStartDate(){
        return maintenanceStartDate;
    }
    public void setMaintenanceStartDate(Date maintenanceStartDate){
        this.maintenanceStartDate = maintenanceStartDate;
    }
    public Date getMaintenanceEndDate(){
        return maintenanceEndDate;
    }
    public void setMaintenanceEndDate(Date maintenanceEndDate){
        this.maintenanceEndDate = maintenanceEndDate;
    }

    public IWorker getMaintenanceWorker(){
        return maintenanceWorker;
    }
    public void setMaintenanceWorker(IWorker maintenanceWorker){
        this.maintenanceWorker = maintenanceWorker;
    }

    public IFacilityRoom getFacilityRoom() {
        return facilityRoom;
    }

    public void setFacilityRoom(IFacilityRoom facilityRoom) {
        this.facilityRoom = facilityRoom;
    }

    public long calcDownTimeForFacilityRoom(Date maintenanceStartDate, Date maintenanceEndDate){
        long startDate = maintenanceStartDate.getTime();
        long endDate = maintenanceEndDate.getTime();

        return endDate - startDate;
    }
}

