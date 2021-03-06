package com.university.model.facilityManagement;


import com.university.model.facility.IFacilityLocation;

import java.util.List;

public interface ILog {
    int getInspectionLog(List<Inspection> inspectionList);
    List<IInspection> getInspectionList();
    void setInspectionList(List<IInspection> inspectionList);
    void addInspection(IInspection inspection);
    void removeInspection(IInspection inspection);
    void addMaintenanceRequest(IRequest maintenanceRequest);
    void cancelMaintenanceRequest(IRequest maintenanceRequest);
    void scheduleMaintenance(ISchedule maintenanceSchedule);
    void cancelSchedule(ISchedule maintenanceSchedule);
    void addMaintenanceOrder(IOrder maintenanceOrder);
    void cancelMaintenanceOrder(IOrder maintenanceOrder);
    List<IOrder> getMaintenanceOrderList();
    void setMaintenanceList(List<IOrder> maintenanceList);
    List<ISchedule> getMaintenanceScheduleList();
    void setScheduleList(List<ISchedule> scheduleList);
    List<IRequest> getMaintenanceRequestList();
    void setRequestList(List<IRequest> requestList);
    double calcMaintenanceCostForFacility(IFacilityLocation facilityLocation);
    double calcProblemRateForFacility(IFacilityLocation facilityLocation);
   //The following methods are an implementation of the Visitor Pattern. (See MaintenanceLog, MaintenanceSchedule,
    //MaintenanceOrder, MaintenanceRequest, and Inspection).
    String visitInspection(IInspection inspection);
    String visitRequest(IRequest request);
    String visitOrder(IOrder order);
    String visitSchedule(ISchedule schedule);
}
