package com.university.model.use;

import com.university.model.facility.IFacilityRoom;
import java.util.Date;

public class Type implements IType{
    private int typeId;
    private String facilityUseType;
    private IFacilityRoom facilityRoom;
    private Date useStartDate;
    private Date useEndDate;
    public int occupancy;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getFacilityUseType() {
        return facilityUseType;
    }

    public void setFacilityUseType(String facilityUseType) {
        this.facilityUseType = facilityUseType;
    }

    // assign facility room to use
    public IFacilityRoom getFacilityRoom() {
        return facilityRoom;
    }

    public void setFacilityRoom(IFacilityRoom facilityRoom) {
        this.facilityRoom = facilityRoom;
    }

    public Date getUseStartDate() {
        return useStartDate;
    }

    public void setUseStartDate(Date useStartDate) {
        this.useStartDate = useStartDate;
    }

    public Date getUseEndDate() {
        return useEndDate;
    }

    public void setUseEndDate(Date useEndDate) {
        this.useEndDate = useEndDate;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

}
