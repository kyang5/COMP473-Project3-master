package com.university.model.facilityManagement;

import com.university.model.facility.IFacilityRoom;

import java.util.Date;

public interface IOrder {
    double getCost();
    void setCost(double cost);
    String getOrderType();
    int getOrderID();
    Date getOrderDate();
    void setOrderType(String orderType);
    void setOrderID(int orderID);
    void setOrderDate(Date orderDate);
    IFacilityRoom getFacilityRoom();
    void setFacilityRoom(IFacilityRoom facilityRoom);
}
