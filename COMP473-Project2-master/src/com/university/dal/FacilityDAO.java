package com.university.dal;

import com.university.model.facility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FacilityDAO {

    public FacilityLocation getFacilityLocation(int facilityId) {
        try {
            // Get facility location
            Statement st = DBHelper.getConnection().createStatement();
            String selectFacilityLocationQuery = "SELECT facilityID, name, addressNumber, streetName, city, zipcode FROM FacilityLocation WHERE facilityId = '" + facilityId + "'";

            ResultSet facilityLocationRS = st.executeQuery(selectFacilityLocationQuery);
            System.out.println("FacilityDAO: *************** Query " + selectFacilityLocationQuery);

            //Get facility location
            FacilityLocation facilityLocation = new FacilityLocation();
            while (facilityLocationRS.next()) {
                facilityLocation.setFacilityId(facilityLocationRS.getInt("facilityID"));
                facilityLocation.setName(facilityLocationRS.getString("name"));
                facilityLocation.setAddressNumber(facilityLocationRS.getInt("addressNumber"));
                facilityLocation.setStreetName(facilityLocationRS.getString("streetName"));
                facilityLocation.setCity(facilityLocationRS.getString("city"));
                facilityLocation.setZipcode(facilityLocationRS.getInt("zipcode"));

            }
            //close to manage resources
            facilityLocationRS.close();

            //Get facility manager
            String selectFacilityManagerQuery = "SELECT managerID, managerFirstName, managerLastName FROM FacilityManager WHERE facilityID = '" + facilityId + "'";
            ResultSet facilityManagerRS = st.executeQuery(selectFacilityManagerQuery);
            FacilityManager manager = new FacilityManager();

            System.out.println("FacilityDAO: *************** Query " + selectFacilityManagerQuery);

            while (facilityManagerRS.next()) {
                manager.setManagerId(facilityManagerRS.getInt("managerID"));
                manager.setManagerFirstName(facilityManagerRS.getString("managerFirstName"));
                manager.setManagerLastName(facilityManagerRS.getString("managerLastName"));
            }

            //close to manage resources
            facilityManagerRS.close();
            st.close();

            return facilityLocation;

        } catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility location object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }

        return null;
    }

    public void addFacilityLocation(FacilityLocation facilityLocation) {
        Connection con = DBHelper.getConnection();
        PreparedStatement facilityLocationPst = null;
        PreparedStatement managerPst = null;

        try {
            //Insert the facilityLocation object
            String facilityLocationStm = "INSERT INTO FacilityLocation(facilityID, name, addressName, streetName, city, zipcode) VALUES(?, ?, ?, ?, ?, ?)";
            facilityLocationPst = con.prepareStatement(facilityLocationStm);
            facilityLocationPst.setInt(1, facilityLocation.getFacilityId());
            facilityLocationPst.setString(2, facilityLocation.getName());
            facilityLocationPst.setInt(3, facilityLocation.getAddressNumber());
            facilityLocationPst.setString(4, facilityLocation.getStreetName());
            facilityLocationPst.setString(5, facilityLocation.getCity());
            facilityLocationPst.setInt(6, facilityLocation.getZipcode());
            facilityLocationPst.executeUpdate();

            //Insert facility manager object
            String managerStm = "INSERT INTO FacilityManager(facilityID, managerID, managerFirstName, managerLastName) VALUES(?, ?, ?, ?)";
            managerPst = con.prepareStatement(managerStm);
            managerPst.setInt(1, facilityLocation.getFacilityId());
            managerPst.setInt(2, facilityLocation.getFacilityManager().getManagerId());
            managerPst.setString(3, facilityLocation.getFacilityManager().getManagerFirstName());
            managerPst.setString(4, facilityLocation.getFacilityManager().getManagerLastName());
            managerPst.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            try {
                if (managerPst != null) {
                    managerPst.close();
                    facilityLocationPst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException saving the facility location object.");
                System.err.println(ex.getMessage());
            }
        }
    }

    public FacilityRoom getFacilityRoom(int facilityRoomId) {

        try {
            //Get facilityRoom
            Statement st = DBHelper.getConnection().createStatement();
            String selectFacilityRoomQuery = "SELECT facilityRoomID, phoneNumber, roomNumber, capacity, isInUse FROM FacilityRoom WHERE facilityRoomID = '" + facilityRoomId + "'";

            ResultSet facilityRoomRS = st.executeQuery(selectFacilityRoomQuery);
            System.out.println("FacilityDAO: *************** Query " + selectFacilityRoomQuery);

            //Get FacilityRoom
            FacilityRoom facilityRoom = new FacilityRoom();
            while (facilityRoomRS.next()) {
                facilityRoom.setFacilityRoomId(facilityRoomRS.getInt("facilityRoomID"));
                facilityRoom.setPhoneNumber(facilityRoomRS.getString("phoneNumber"));
                facilityRoom.setRoomNumber(facilityRoomRS.getInt("roomNumber"));
                facilityRoom.setCapacity(facilityRoomRS.getInt("capacity"));
                facilityRoom.setInUse(facilityRoomRS.getBoolean("isInUse"));
            }

            facilityRoomRS.close();

            //Get facilityLocation
            String selectFacilityLocationQuery = "SELECT facilityID, name, addressNumber, streetName, city, zipcode FROM FacilityLocation WHERE facilityRoomID = '" + facilityRoomId + "'";
            ResultSet facilityLocationRS = st.executeQuery(selectFacilityLocationQuery);
            FacilityLocation facilityLocation = new FacilityLocation();

            System.out.println("FacilityDAO:  *************** Query " + selectFacilityLocationQuery);

            while (facilityLocationRS.next()) {
                facilityLocation.setFacilityId(facilityLocationRS.getInt("facilityLocationID"));
                facilityLocation.setName(facilityLocationRS.getString("name"));
                facilityLocation.setAddressNumber(facilityLocationRS.getInt("addressNumber"));
                facilityLocation.setStreetName(facilityLocationRS.getString("streetName"));
                facilityLocation.setCity(facilityLocationRS.getString("city"));
                facilityLocation.setZipcode(facilityLocationRS.getInt("zipcode"));
            }

            facilityLocationRS.close();
            st.close();

            return facilityRoom;
        } catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility room object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }

        return null;
    }

    public void addFacilityRoom(FacilityRoom facilityRoom) {
        Connection con = DBHelper.getConnection();
        PreparedStatement facilityRoomPst = null;
        PreparedStatement facilityLocationPst = null;

        try {
            //Insert facility room object
            String facilityRoomStm = "INSERT INTO FacilityRoom(facilityRoomID, phoneNumber, roomNumber, capacity, isInUse) VALUES(?, ?, ?, ?, ?)";
            facilityRoomPst = con.prepareStatement(facilityRoomStm);
            facilityRoomPst.setInt(1, facilityRoom.getFacilityRoomId());
            facilityRoomPst.setString(2, facilityRoom.getPhoneNumber());
            facilityRoomPst.setInt(3, facilityRoom.getRoomNumber());
            facilityRoomPst.setInt(4, facilityRoom.getCapacity());
            facilityRoomPst.setBoolean(5, facilityRoom.isInUse());
            facilityRoomPst.executeUpdate();

            //Insert facility location object
            String facilityLocationStm = "INSERT INTO FacilityLocation(facilityRoomID, facilityID, name, addressNumber, streetName, city, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?)";
            facilityLocationPst = con.prepareStatement(facilityLocationStm);
            facilityLocationPst.setInt(1, facilityRoom.getFacilityRoomId());
            facilityLocationPst.setInt(2, facilityRoom.getFacilityLocation().getFacilityId());
            facilityLocationPst.setString(3, facilityRoom.getFacilityLocation().getName());
            facilityLocationPst.setInt(4, facilityRoom.getFacilityLocation().getAddressNumber());
            facilityLocationPst.setString(5, facilityRoom.getFacilityLocation().getStreetName());
            facilityLocationPst.setString(6, facilityRoom.getFacilityLocation().getCity());
            facilityLocationPst.setInt(7, facilityRoom.getFacilityLocation().getZipcode());
            facilityLocationPst.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            try {
                if (facilityLocationPst != null) {
                    facilityLocationPst.close();
                    facilityRoomPst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException saving the facility room object.");
                System.err.println(ex.getMessage());
            }
        }
    }
}