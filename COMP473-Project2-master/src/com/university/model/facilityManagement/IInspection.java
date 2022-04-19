package com.university.model.facilityManagement;

import com.university.model.facility.IFacilityRoom;

import java.util.List;

public interface IInspection {
    IFacilityRoom getFacilityRoom();
    void setFacilityRoom(IFacilityRoom facilityRoom);
    String getInspectionName();
    int getInspectionID();
    void setInspectionName(String inspectionName);
    void setInspectionID(int inspectionID);
    void addInspector(IInspector inspector);
    void removeInspector(IInspector inspector);
    IInspector getInspector();
    void setInspector(IInspector inspector);
    List<IInspector> getInspectorList();
    void setInspectorList(List <IInspector> inspectorList);
    String accept(ILog maintenanceLog);
}
