package com.university.dal;

import com.university.model.facility.FacilityRoom;
import com.university.model.use.IUser;
import com.university.model.use.Student;
import com.university.model.use.Type;
import com.university.model.use.User;

import java.sql.*;

public class UseDAO {

    public User getUser(String userId) {

        try {
            //Get user
            Statement st = DBHelper.getConnection().createStatement();
            String selectUserQuery = "SELECT userID, userFirstName, userLastName, userTitle FROM User WHERE userId = '" + userId + "'";

            ResultSet userRS = st.executeQuery(selectUserQuery);
            System.out.println("UseDAO: *************** Query " + selectUserQuery);

            //Get user
            User user = new Student();
            while(userRS.next()) {
                user.setUserId(userRS.getInt("userID"));
                user.setUserFirstName(userRS.getString("userFirstName"));
                user.setUserLastName(userRS.getString("userLastName"));
                user.setUserTitle(userRS.getString("userTitle"));
            }
            userRS.close();

            //Get facility room
            String selectTypeQuery = "SELECT typeId, facilityUseType, useStartDate, useEndDate, occupancy FROM Type WHERE userID = '" + userId + "'";
            ResultSet typeRS = st.executeQuery(selectTypeQuery);
            Type type = new Type();

            System.out.println("UserDAO: *************** Query " + selectTypeQuery);

            while (typeRS.next()) {
                type.setTypeId(typeRS.getInt("typeID"));
                type.setFacilityUseType(typeRS.getString("facilityUseTYpe"));
                type.setUseStartDate(typeRS.getDate("useStartDate"));
                type.setUseEndDate(typeRS.getDate("useEndDate"));
                type.setOccupancy(typeRS.getInt("occupancy"));
            }

            user.setUseType(type);
            typeRS.close();
            st.close();

            return user;
        }
        catch (SQLException se) {
            System.err.println("UserDAO: Threw a SQLException retrieving the user object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }

        return null;
    }

    public void addUser(User user) {
        Connection con = DBHelper.getConnection();
        PreparedStatement userPst = null;
        PreparedStatement typePst = null;

        try{
            String userStm = "INSERT INTO User(userID, userFirstName, userLastName, userTitle) VALUES(?, ?, ?, ?)";
            userPst.setInt(1, user.getUserId());
            userPst.setString(2, user.getUserFirstName());
            userPst.setString(3, user.getUserLastName());
            userPst.setString(4, user.getUserTitle());
            userPst.executeUpdate();

            String typeStm = "INSERT INTO Type(userID, typeId, facilityUseType, useStartDate, useEndDate, occupancy) VALUES(?, ?, ?, ?, ?, ?)";
            typePst = con.prepareStatement(typeStm);
            typePst.setInt(1, user.getUserId());
            typePst.setInt(2, user.getUseType().getTypeId());
            typePst.setString(3, user.getUseType().getFacilityUseType());
            typePst.setDate(4, (Date) user.getUseType().getUseStartDate());
            typePst.setDate(5, (Date) user.getUseType().getUseEndDate());
            typePst.executeUpdate();
        } catch (SQLException ex) {

        } finally {

            try {
                if (typePst != null) {
                    typePst.close();
                    userPst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("UserDAO: Threw a SQLException saving the user object.");
                System.err.println(ex.getMessage());
            }
        }
    }

    public Type getFacilityUseType(int typeId) {

        try {
            Statement st = DBHelper.getConnection().createStatement();
            String selectFacilityUseTypeQuery = "SELECT typeId, facilityUseType, useStartDate, useEndDate, occupancy, isInUse FROM Type WHERE typeId = '" + typeId + "'";

            ResultSet facilityUseTypeRS = st.executeQuery(selectFacilityUseTypeQuery);
            System.out.println("UseDAO: *************** Query " + selectFacilityUseTypeQuery);

            Type type = new Type();

            while(facilityUseTypeRS.next()) {
                type.setTypeId(facilityUseTypeRS.getInt("typeId"));
                type.setFacilityUseType(facilityUseTypeRS.getString("facilityUseType"));
                type.setUseStartDate(facilityUseTypeRS.getDate("useStartDate"));
                type.setUseEndDate(facilityUseTypeRS.getDate("useEndDate"));
                type.setOccupancy(facilityUseTypeRS.getInt("occupancy"));
            }
            facilityUseTypeRS.close();

            //Get facility room
            String selectFacilityRoomQuery = "SELECT facilityRoomID, phoneNumber, roomNumber, capacity FROM FacilityRoom WHERE typeID = '" + typeId + "'";
            ResultSet facilityRoomRS = st.executeQuery(selectFacilityRoomQuery);

            FacilityRoom facilityRoom = new FacilityRoom();

            System.out.println("UserDAO: *************** Query " + selectFacilityRoomQuery);

            while (facilityRoomRS.next()) {
                facilityRoom.setFacilityRoomId(facilityRoomRS.getInt("facilityRoomID"));
                facilityRoom.setPhoneNumber(facilityRoomRS.getString("phoneNumber"));
                facilityRoom.setRoomNumber(facilityRoomRS.getInt("roomNumber"));
                facilityRoom.setCapacity(facilityRoomRS.getInt("capacity"));
            }
            facilityRoomRS.close();
            st.close();

            return type;
        }
        catch (SQLException se) {
            System.err.println("UserDAO: Threw a SQLException retrieving the type object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }

        return null;
    }

    public void addType(Type type) {
        Connection con = DBHelper.getConnection();
        PreparedStatement typePst = null;
        PreparedStatement addTypePst = null;

        try{
            String typeStm = "INSERT INTO Type(typeId, facilityUseType, useStartDate, useEndDate, occupancy) VALUES(?, ?, ?, ?, ?, ?)";
            typePst = con.prepareStatement(typeStm);
            typePst.setInt(1, type.getTypeId());
            typePst.setString(2, type.getFacilityUseType());
            typePst.setDate(3, (Date) type.getUseStartDate());
            typePst.setDate(4, (Date) type.getUseEndDate());
            typePst.setInt(5, type.getOccupancy());
            typePst.executeUpdate();
        } catch (SQLException ex) {

        } finally {

            try {
                if (typePst != null) {
                    typePst.close();
                    typePst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("UserDAO: Threw a SQLException saving the type object.");
                System.err.println(ex.getMessage());
            }
        }
    }
}