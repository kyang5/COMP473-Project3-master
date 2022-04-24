package com.university.model.use;

import com.university.model.facility.IFacilityRoom;

import java.util.Date;

public class Office implements IType{
    private int typeId;
    private IFacilityRoom facilityRoom;
    private Date useStartDate;
    private Date useEndDate;


    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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

    public String getFacilityUseType() {
        return "Office";
    }
    //See the IType interface for its implementation and interaction with the Bridge Pattern.
}
