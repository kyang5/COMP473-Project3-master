package com.university.model.facility;

import java.util.List;
import java.util.ArrayList;

public class FacilityLocation implements IFacilityLocation{
    private int facilityId;
    private String name;
    private int addressNumber;
    private String streetName;
    private String city;
    private int zipcode;
    private IFacilityManager facilityManager;
    private List<IFacilityRoom> listFacilityRooms = new ArrayList<>();
    private double facilityUsageRate;

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public List<IFacilityRoom> getListFacilityRooms() {
        return listFacilityRooms;
    }

    public void setListFacilityRooms(List<IFacilityRoom> listFacilityRooms) {
        this.listFacilityRooms = listFacilityRooms;
    }

    public void addFacilityRoom (IFacilityRoom facilityRoom) {
        listFacilityRooms.add(facilityRoom);
    }

    public void removeFacilityRoom(IFacilityRoom facilityRoom) {
        listFacilityRooms.remove(facilityRoom);
    }

    public IFacilityManager getFacilityManager() {
        return facilityManager;
    }

    public void setFacilityManager(IFacilityManager facilityManager) {
        this.facilityManager = facilityManager;
    }

    // total number of rooms in a facility out of total number of rooms in a facility being used
    // same as calcUseRate()
    public double calcFacilityUsage(List<IFacilityRoom> listFacilityRooms) {
        double totalNumberOfRooms = listFacilityRooms.size();
        double totalRoomsInUse = 0;

        for (IFacilityRoom room : listFacilityRooms) {
            if (room.isInUse()) {
                totalRoomsInUse += 1;
            }
            facilityUsageRate = totalRoomsInUse / totalNumberOfRooms;
        }
        return facilityUsageRate;
    }

}