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

    public String exportInspection(IInspection... args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\\n");
        for (IInspection inspection: args) {
            stringBuilder.append(inspection.accept(this)).append("\n");
        }
        return stringBuilder.toString();
    }

    public String visitInspection(IInspection inspection) {
        return "<inspection>" + "\n" +
                "<inspectionID>" + inspection.getInspectionID() + "</inspectionID>" + "\n" +
                "<inspectionName>" + inspection.getInspectionName() + "</inspectionName>" + "\n" +
                "<inspector>" + inspection.getInspector() + "</inspector>" + "\n" +
                "<facilityRoom>" + inspection.getFacilityRoom() + "</facilityRoom>" + "\n" +
                "</inspection>";
    }
    public String exportRequest(IRequest... args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\\n");
        for (IRequest request: args) {
            stringBuilder.append(request.accept(this)).append("\n");
        }
        return stringBuilder.toString();
    }

    public String visitRequest(IRequest request) {
        return "<request>" + "\n" +
                "<requestID>" + request.getRequestID() + "</requestID>" + "\n" +
                "<requestDate>" + request.getRequestDate() + "</requestDate>" + "\n" +
                "<requestStatus>" + request.getRequestStatus() + "</requestStatus>" + "\n" +
                "<requestorID>" + request.getRequestorID() + "</requestorID>" + "\n" +
                "<requestType>" + request.getRequestType() + "</requestType>" + "\n" +
                "<problem>" + request.getProblem() + "</problem>" + "\n" +
                "<facilityRoom" + request.getFacilityRoom() + "</facilityRoom>" + "\n" +
                "</request>";
    }
    public String exportOrder(IOrder... args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\\n");
        for (IOrder order: args) {
            stringBuilder.append(order.accept(this)).append("\n");
        }
        return stringBuilder.toString();
    }

    public String visitOrder(IOrder order) {
        return "<order>" + "\n" +
                "<cost>" + order.getCost() + "</cost>" + "\n" +
                "<orderType>" + order.getOrderType() + "</orderType>" + "\n" +
                "<orderID>" + order.getOrderID() + "</orderID>" + "\n" +
                "<orderDate>" + order.getOrderDate() + "</orderDate>" + "\n" +
                "<facilityRoom>" + order.getFacilityRoom() + "</facilityRoom>" + "\n" +
                "</order>";
    }

}
