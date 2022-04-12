package com.university.model.facilityManagement;

import com.university.model.facility.IFacilityLocation;
import com.university.model.facility.IFacilityRoom;

import java.util.*;
public class MaintenanceLog implements ILog {
    private List<IOrder> maintenanceList = new ArrayList<>();
    private List<ISchedule> scheduleList = new ArrayList<>();
    private List<IRequest> requestList = new ArrayList<>();
    private List<IInspection> inspectionList = new ArrayList<>();

    public int getInspectionLog(List<Inspection> inspectionList) {

        return inspectionList.size();
    }

    public List<IInspection> getInspectionList() {
        return inspectionList;
    }

    public void setInspectionList(List<IInspection> inspectionList){
        this.inspectionList = inspectionList;
    }
    public void addInspection(IInspection inspection){
        inspectionList.add(inspection);
    }
    public void removeInspection(IInspection inspection){
        inspectionList.remove(inspection);
    }

    public void addMaintenanceRequest(IRequest maintenanceRequest){
        requestList.add(maintenanceRequest);
    }
    public void cancelMaintenanceRequest(IRequest maintenanceRequest){
        requestList.remove(maintenanceRequest);
    }
    public void scheduleMaintenance(ISchedule maintenanceSchedule){
        scheduleList.add(maintenanceSchedule);
    }
    public void cancelSchedule(ISchedule maintenanceSchedule){
        scheduleList.remove(maintenanceSchedule);
    }
    public void addMaintenanceOrder(IOrder maintenanceOrder){
        maintenanceList.add(maintenanceOrder);
    }
    public void cancelMaintenanceOrder(IOrder maintenanceOrder){
        maintenanceList.remove(maintenanceOrder);
    }
    public List<IOrder> getMaintenanceOrderList(){
        return maintenanceList;
    }

    public void setMaintenanceList(List<IOrder> maintenanceList) {
        this.maintenanceList = maintenanceList;
    }

    public List<ISchedule> getMaintenanceScheduleList(){
        return scheduleList;
    }

    public void setScheduleList(List<ISchedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    // same as listFacilityProblems()
    public List<IRequest> getMaintenanceRequestList(){
        return requestList;
    }

    public void setRequestList(List<IRequest> requestList) {
        this.requestList = requestList;
    }

    public double calcMaintenanceCostForFacility(IFacilityLocation facilityLocation){

        double totalCost = 0.0;
        for (IFacilityRoom room : facilityLocation.getListFacilityRooms()) {
            for(IOrder order: maintenanceList){
                if(order.getFacilityRoom().equals(room))
                    totalCost+=order.getCost();
            }
        }
        return totalCost;
    }

    public double calcProblemRateForFacility(IFacilityLocation facilityLocation) {
        double totalProblem = 0;
        double totalRooms = 0;
        for (IFacilityRoom room: facilityLocation.getListFacilityRooms()) {
            totalRooms += 1;
            for(IRequest request: requestList) {
                if(request.getFacilityRoom().equals(room)) {
                    totalProblem +=1;
                }
            }
        }
        return totalProblem/totalRooms;
    }
}
