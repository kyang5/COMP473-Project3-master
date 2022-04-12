package com.university.model.facilityManagement;
import com.university.model.facility.IFacilityRoom;

import java.util.*;

public class MaintenanceOrder implements IOrder {
    private String orderType;
    private int orderID;
    private Date orderDate;
    private double cost;
    public IFacilityRoom facilityRoom;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOrderType() {
        return orderType;
    }

    public int getOrderID() {
        return orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;

    }

    public IFacilityRoom getFacilityRoom() {
        return facilityRoom;
    }


    public void setFacilityRoom(IFacilityRoom facilityRoom) {
        this.facilityRoom = facilityRoom;
    }

}
