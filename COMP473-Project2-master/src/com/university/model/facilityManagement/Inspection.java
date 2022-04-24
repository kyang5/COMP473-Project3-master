package com.university.model.facilityManagement;
import com.university.model.facility.IFacilityRoom;

import java.util.ArrayList;
import java.util.List;

public class Inspection implements IInspection {
    private String inspectionName;
    private int inspectionID;
    private IInspector inspector;
    private IFacilityRoom facilityRoom;
    private List<IInspector> inspectorList = new ArrayList<>();


    public IFacilityRoom getFacilityRoom(){
        return facilityRoom;
    }

    public void setFacilityRoom(IFacilityRoom facilityRoom){
        this.facilityRoom = facilityRoom;
    }

    public String getInspectionName() {
        return inspectionName;
    }

    public int getInspectionID(){
        return inspectionID;
    }
    public void setInspectionName(String inspectionName){
        this.inspectionName = inspectionName;
    }

    public void setInspectionID(int inspectionID){
        this.inspectionID = inspectionID;
    }

    public void addInspector(IInspector inspector){
        inspectorList.add(inspector);
    }
    public void removeInspector(IInspector inspector){
        inspectorList.remove(inspector);
    }

    public IInspector getInspector() {
        return inspector;
    }

    public void setInspector(IInspector inspector) {
        this.inspector = inspector;
    }

    public List<IInspector> getInspectorList(){
        return inspectorList;
    }
    public void setInspectorList(List <IInspector> inspectorList){ this.inspectorList = inspectorList;}

    @Override
    public String accept(ILog maintenanceLog) {
        return maintenanceLog.visitInspection(this);
    }
    //Implementation of Visitor Pattern.
}


