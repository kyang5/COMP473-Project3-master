package com.university.model.facilityManagement;

public interface IInspector {
    String getInspectorFirstName();
    String getInspectorLastName();
    int getInspectorID();
    String getInspectorTitle();
    void setInspectorFirstName(String firstName);
    void setInspectorLastName(String lastName);
    void setInspectorID(int inspectorID);
    void setInspectorTitle(String title);
}
