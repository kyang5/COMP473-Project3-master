package com.university.model.facilityManagement;

public class Inspector implements IInspector {
    //Variables for information about the inspector
    private String firstName;
    private String lastName;
    private int inspectorID;
    private String title;

    public String getInspectorFirstName() {
        return firstName;

    }

    public String getInspectorLastName() {
        return lastName;

    }

    public int getInspectorID() {
        return inspectorID;

    }

    public String getInspectorTitle() {
        return title;

    }

    public void setInspectorFirstName(String firstName) {
        this.firstName = firstName;


    }

    public void setInspectorLastName(String lastName) {
        this.lastName = lastName;

    }

    public void setInspectorID(int inspectorID) {
        this.inspectorID = inspectorID;

    }

    public void setInspectorTitle(String title) {
        this.title = title;

    }
}
