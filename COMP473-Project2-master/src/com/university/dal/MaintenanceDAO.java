package com.university.dal;
import com.university.model.facility.FacilityRoom;
import com.university.model.facilityManagement.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class MaintenanceDAO {
    public MaintenanceDAO() {

    }

    public IInspection getInspection(int inspectionID) {
        try {
            //Get Customer
            Statement st = DBHelper.getConnection().createStatement();
            String selectInspectionQuery = "SELECT inspectionID, inspectionName, inspectionLog FROM Inspection WHERE inspectionID = '" + inspectionID + "'";

            ResultSet inspectionRS = st.executeQuery(selectInspectionQuery);
            System.out.println("MaintenanceDAO: *************** Query " + selectInspectionQuery);

            //Get Inspection
            Inspection inspection = new Inspection();
            while (inspectionRS.next()) {
                inspection.setInspectionID(inspectionRS.getInt("inspectionID"));
                inspection.setInspectionName(inspectionRS.getString("inspectionName"));
                //inspection.setInspectionLog(inspectionRS.getInt("inspectionLog"));
            }
            //close to manage resources
            inspectionRS.close();

            //Get Inspector
            String selectInspectorQuery = "SELECT inspectorID, firstName, lastName, title FROM Inspector WHERE inspectionID = '" + inspectionID + "'";
            ResultSet inspectorRS = st.executeQuery(selectInspectorQuery);
            Inspector inspector = new Inspector();

            System.out.println("MaintenanceDAO: *************** Query " + selectInspectorQuery);

            while (inspectorRS.next()) {
                inspector.setInspectorID(inspectorRS.getInt("inspectorID"));
                inspector.setInspectorFirstName(inspectorRS.getString("firstName"));
                inspector.setInspectorLastName(inspectorRS.getString("lastName"));
                inspector.setInspectorTitle(inspectorRS.getString("title"));
            }

            //close to manage resources
            inspectorRS.close();
            st.close();

            return inspection;
        } catch (SQLException se) {
            System.err.println("MaintenanceDAO: Threw a SQLException retrieving the inspector object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }

        return null;
    }

    public void addInspection(IInspection inspect) {
        Connection con = DBHelper.getConnection();
        PreparedStatement inspectPst = null;
        PreparedStatement inspectorPst = null;

        try {
            //Insert the customer object
            String inspectStm = "INSERT INTO Inspection(inspectionID, inspectionName) VALUES(?, ?)";
            inspectPst = con.prepareStatement(inspectStm);
            inspectPst.setInt(1, inspect.getInspectionID());
            inspectPst.setString(2, inspect.getInspectionName());
            //inspectPst.setInt(3, inspect.getInspectionLog());
            inspectPst.executeUpdate();

            String inspectorStm = "INSERT INTO Inspection(inspectionID, inspectorID, firstName, lastName, title) VALUES(?, ?, ?, ?, ?)";
            inspectorPst = con.prepareStatement(inspectorStm);
            inspectorPst.setInt(1, inspect.getInspectionID());
            inspectorPst.setInt(2, inspect.getInspector().getInspectorID());
            inspectorPst.setString(3, inspect.getInspector().getInspectorFirstName());
            inspectorPst.setString(4, inspect.getInspector().getInspectorLastName());
            inspectorPst.setString(5, inspect.getInspector().getInspectorTitle());

            inspectorPst.executeUpdate();
        } catch (SQLException ex) {

        } finally {

            try {
                if (inspectorPst != null) {
                    inspectorPst.close();
                    inspectPst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("MaintenanceDAO: Threw a SQLException saving the inspector object.");
                System.err.println(ex.getMessage());
            }
        }
    }

    public IOrder getMaintenanceOrder(int orderID) {

        try {

            Statement st = DBHelper.getConnection().createStatement();
            String selectMaintenanceOrderQuery = "SELECT orderID, orderType, orderDate, cost FROM MaintenanceOrder WHERE orderID = '" + orderID + "'";

            ResultSet maintenanceOrderRS = st.executeQuery(selectMaintenanceOrderQuery);
            System.out.println("MaintenanceDAO: *************** Query " + selectMaintenanceOrderQuery);


            MaintenanceOrder maintenanceOrder = new MaintenanceOrder();
            while (maintenanceOrderRS.next()) {

                maintenanceOrder.setOrderID(maintenanceOrderRS.getInt("orderID"));
                maintenanceOrder.setCost(maintenanceOrderRS.getDouble("cost"));
                maintenanceOrder.setOrderType(maintenanceOrderRS.getString("orderType"));
                maintenanceOrder.setOrderDate(maintenanceOrderRS.getDate("orderDate"));

            }
            //close to manage resources
            maintenanceOrderRS.close();


            String selectFacilityRoomQuery = "SELECT facilityRoomId, capacity, roomNumber, phoneNumber, inUse FROM FacilityRoom WHERE orderID = '" + orderID + "'";
            ResultSet roomRS = st.executeQuery(selectFacilityRoomQuery);
            FacilityRoom room = new FacilityRoom();

            System.out.println("MaintenanceDAO: *************** Query " + selectFacilityRoomQuery);

            while (roomRS.next()) {
                room.setFacilityRoomId(roomRS.getInt("facilityRoomId"));
                room.setCapacity(roomRS.getInt("capacity"));
                room.setRoomNumber(roomRS.getInt("roomNumber"));
                room.setPhoneNumber(roomRS.getString("phoneNumber"));
            }
            roomRS.close();
            st.close();

            return maintenanceOrder;
        } catch (SQLException se) {
            System.err.println("MaintenanceDAO: Threw a SQLException retrieving the maintenanceOrder object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }

        return null;
    }

    public void addMaintenanceOrder(IOrder maintenanceOrder) {
        Connection con = DBHelper.getConnection();
        PreparedStatement maintOPst = null;

        try {

            String maintOStm = "INSERT INTO MaintenanceOrder(orderID, orderType, orderDate, cost, facilityRoomId, roomNumber) VALUES(?, ?, ?, ?, ?, ?)";
            maintOPst = con.prepareStatement(maintOStm);
            maintOPst.setInt(1, maintenanceOrder.getOrderID());
            maintOPst.setString(2, maintenanceOrder.getOrderType());
            maintOPst.setDate(3, (java.sql.Date) maintenanceOrder.getOrderDate());
            maintOPst.setDouble(4, maintenanceOrder.getCost());
            maintOPst.setInt(5, maintenanceOrder.getFacilityRoom().getFacilityRoomId());
            maintOPst.setInt(6, maintenanceOrder.getFacilityRoom().getRoomNumber());
            maintOPst.executeUpdate();

        } catch (SQLException ex) {

        } finally {

            try {
                if (maintOPst != null) {
                    maintOPst.close();

                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("MaintenanceDAO: Threw a SQLException saving the MaintenanceOrder object.");
                System.err.println(ex.getMessage());
            }
        }
    }

    public IRequest getMaintenanceRequest(int requestID) {

        try {

            Statement st = DBHelper.getConnection().createStatement();
            String selectRequestQuery = "SELECT requestType, requestID, requestDate, requestorID, requestStatus, problem FROM MaintenanceRequest WHERE requestID = '" + requestID + "'";

            ResultSet maintenanceRequestRS = st.executeQuery(selectRequestQuery);
            System.out.println("MaintenanceDAO: *************** Query " + selectRequestQuery);


            MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
            while (maintenanceRequestRS.next()) {

                maintenanceRequest.setRequestType(maintenanceRequestRS.getString("requestType"));
                maintenanceRequest.setRequestID(maintenanceRequestRS.getInt("requestID"));
                maintenanceRequest.setRequestDate(maintenanceRequestRS.getDate("requestDate"));
                maintenanceRequest.setRequestorID(maintenanceRequestRS.getInt("requestorID"));
                maintenanceRequest.setRequestStatus(maintenanceRequestRS.getString("requestStatus"));
                maintenanceRequest.setProblem(maintenanceRequestRS.getString("problem"));

            }
            //close to manage resources
            maintenanceRequestRS.close();


            String selectFacilityRoomQuery = "SELECT facilityRoomId, capacity, roomNumber, phoneNumber, inUse FROM FacilityRoom WHERE requestID = '" + requestID + "'";
            ResultSet roomRS = st.executeQuery(selectFacilityRoomQuery);
            FacilityRoom room = new FacilityRoom();

            System.out.println("MaintenanceDAO: *************** Query " + selectFacilityRoomQuery);

            while (roomRS.next()) {
                room.setFacilityRoomId(roomRS.getInt("facilityRoomId"));
                room.setCapacity(roomRS.getInt("capacity"));
                room.setRoomNumber(roomRS.getInt("roomNumber"));
                room.setPhoneNumber(roomRS.getString("phoneNumber"));

            }
            roomRS.close();
            st.close();
            return maintenanceRequest;
        } catch (SQLException se) {
            System.err.println("MaintenanceDAO: Threw a SQLException retrieving the maintenanceOrder object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }

        return null;
    }

    public void addMaintenanceRequest(IRequest maintenanceRequest) {
        Connection con = DBHelper.getConnection();
        PreparedStatement requestPst = null;

        try {

            String RequestStm = "INSERT INTO MaintenanceRequest(requestType, requestID, requestDate, requestorID, requestStatus, problem, facilityRoomId, roomNumber) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            requestPst = con.prepareStatement(RequestStm);
            requestPst.setString(1, maintenanceRequest.getRequestType());
            requestPst.setInt(2, maintenanceRequest.getRequestID());
            requestPst.setDate(3, (java.sql.Date) maintenanceRequest.getRequestDate());
            requestPst.setDouble(4, maintenanceRequest.getRequestorID());
            requestPst.setString(5, maintenanceRequest.getRequestStatus());
            requestPst.setString(6, maintenanceRequest.getProblem());
            requestPst.setInt(7, maintenanceRequest.getFacilityRoom().getFacilityRoomId());
            requestPst.setInt(8, maintenanceRequest.getFacilityRoom().getRoomNumber());
            requestPst.executeUpdate();

        } catch (SQLException ex) {

        } finally {

            try {
                if (requestPst != null) {
                    requestPst.close();

                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("MaintenanceDAO: Threw a SQLException saving the MaintenanceRequest object.");
                System.err.println(ex.getMessage());
            }
        }
    }

    public ISchedule getMaintenanceSchedule(int scheduleID) {

        try {

            Statement st = DBHelper.getConnection().createStatement();
            String selectScheduleQuery = "SELECT maintenanceStartDate, maintenanceEndDate, scheduleID FROM MaintenanceSchedule WHERE scheduleID = '" + scheduleID + "'";

            ResultSet scheduleRS = st.executeQuery(selectScheduleQuery);
            System.out.println("MaintenanceDAO: *************** Query " + selectScheduleQuery);


            MaintenanceSchedule maintenanceSchedule = new MaintenanceSchedule();
            while (scheduleRS.next()) {

                maintenanceSchedule.setMaintenanceStartDate(scheduleRS.getDate("maintenanceStartDate"));
                maintenanceSchedule.setMaintenanceEndDate(scheduleRS.getDate("maintenanceEndDate"));
                maintenanceSchedule.setScheduleID(scheduleRS.getInt("scheduleID"));


            }
            //close to manage resources
            scheduleRS.close();


            String selectFacilityScheduleRoomQuery = "SELECT facilityRoomId, capacity, roomNumber, phoneNumber, inUse FROM FacilityRoom WHERE scheduleID = '" + scheduleID + "'";
            ResultSet roomScheduleRS = st.executeQuery(selectFacilityScheduleRoomQuery);
            FacilityRoom roomSchedule = new FacilityRoom();

            System.out.println("MaintenanceDAO: *************** Query " + selectFacilityScheduleRoomQuery);

            while (roomScheduleRS.next()) {
                roomSchedule.setFacilityRoomId(roomScheduleRS.getInt("facilityRoomId"));
                roomSchedule.setCapacity(roomScheduleRS.getInt("capacity"));
                roomSchedule.setRoomNumber(roomScheduleRS.getInt("roomNumber"));
                roomSchedule.setPhoneNumber(roomScheduleRS.getString("phoneNumber"));

            }
            roomScheduleRS.close();
            String selectWorkerQuery = "SELECT firstName, lastName, maintenanceWorkerID, title FROM MaintenanceWorker WHERE scheduleID = '" + scheduleID + "'";
            ResultSet workerRS = st.executeQuery(selectWorkerQuery);
            MaintenanceWorker worker = new MaintenanceWorker();


            System.out.println("MaintenanceDAO: *************** Query " + selectWorkerQuery);

            while (workerRS.next()) {
                worker.setMaintFirstName(workerRS.getString("firstName"));
                worker.setMaintLastName(workerRS.getString("lastName"));
                worker.setMaintWorkerID(workerRS.getInt("maintenanceWorkerID"));
                worker.setMaintTitle(workerRS.getString("title"));


            }
            workerRS.close();
            st.close();


            return maintenanceSchedule;
        } catch (SQLException se) {
            System.err.println("MaintenanceDAO: Threw a SQLException retrieving the maintenanceSchedule object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }

        return null;
    }

    public void addMaintenanceSchedule(ISchedule maintenanceSchedule) {
        Connection con = DBHelper.getConnection();
        PreparedStatement schedulePst = null;

        try {

            String scheduleStm = "INSERT INTO MaintenanceSchedule(maintenanceStartDate, maintenanceEndDate, scheduleID, facilityRoomId, roomNumber, maintenanceWorkerID) VALUES(?, ?, ?, ?, ?, ?)";
            schedulePst = con.prepareStatement(scheduleStm);
            schedulePst.setDate(1, (java.sql.Date) maintenanceSchedule.getMaintenanceStartDate());
            schedulePst.setDate(2, (java.sql.Date) maintenanceSchedule.getMaintenanceEndDate());
            schedulePst.setInt(3, maintenanceSchedule.getScheduleID());
            schedulePst.setInt(4, maintenanceSchedule.getFacilityRoom().getFacilityRoomId());
            schedulePst.setInt(5, maintenanceSchedule.getFacilityRoom().getRoomNumber());
            schedulePst.setInt(6, maintenanceSchedule.getMaintenanceWorker().getMaintWorkerID());
            schedulePst.executeUpdate();

        } catch (SQLException ex) {

        } finally {

            try {
                if (schedulePst != null) {
                    schedulePst.close();

                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("MaintenanceDAO: Threw a SQLException saving the MaintenanceSchedule object.");
                System.err.println(ex.getMessage());
            }
        }
    }
}

