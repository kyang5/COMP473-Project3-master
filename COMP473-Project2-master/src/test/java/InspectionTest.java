package test.java;

import com.university.model.facility.FacilityLocation;
import com.university.model.facility.FacilityManager;
import com.university.model.facility.FacilityRoom;
import com.university.model.facilityManagement.Inspection;
import com.university.model.facilityManagement.Inspector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InspectionTest {

    private List<Inspector> inspectorList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception {
        inspectorList = new ArrayList<>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        inspectorList = null;
    }

    @org.junit.jupiter.api.Test
    void addInspection() {
        FacilityLocation facilityLocation = new FacilityLocation();
        facilityLocation.setFacilityId(1);
        facilityLocation.setName("Murphy Building");
        facilityLocation.setAddressNumber(123);
        facilityLocation.setStreetName("State Street");
        facilityLocation.setCity("Chicago");
        facilityLocation.setZipcode(123456);

        FacilityManager facilityManager = new FacilityManager();
        facilityManager.setManagerId(1);
        facilityManager.setManagerFirstName("Bob");
        facilityManager.setManagerLastName("Doe");
        facilityLocation.setFacilityManager(facilityManager);

        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123 - 456 - 7890");
        facilityRoom1.setCapacity(10);
        facilityRoom1.setFacilityLocation(facilityLocation);

        Inspector inspector = new Inspector();
        inspector.setInspectorID(1);
        inspector.setInspectorFirstName("Dan");
        inspector.setInspectorLastName("Tan");
        inspector.setInspectorTitle("Fire Safety Inspector");

        Inspection inspection = new Inspection();
        inspection.setInspectionID(1);
        inspection.setInspectionName("Fire safety");
        inspection.setInspector(inspector);
        inspection.setFacilityRoom(facilityRoom1);

        inspectorList.add(inspector);
        assertEquals(true, inspectorList.contains(inspector));
    }


    @org.junit.jupiter.api.Test
    void removeInspection() {
        FacilityLocation facilityLocation = new FacilityLocation();
        facilityLocation.setFacilityId(1);
        facilityLocation.setName("Murphy Building");
        facilityLocation.setAddressNumber(123);
        facilityLocation.setStreetName("State Street");
        facilityLocation.setCity("Chicago");
        facilityLocation.setZipcode(123456);

        FacilityManager facilityManager = new FacilityManager();
        facilityManager.setManagerId(1);
        facilityManager.setManagerFirstName("Bob");
        facilityManager.setManagerLastName("Doe");
        facilityLocation.setFacilityManager(facilityManager);

        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123 - 456 - 7890");
        facilityRoom1.setCapacity(10);
        facilityRoom1.setFacilityLocation(facilityLocation);

        Inspector inspector = new Inspector();
        inspector.setInspectorID(1);
        inspector.setInspectorFirstName("Dan");
        inspector.setInspectorLastName("Tan");
        inspector.setInspectorTitle("Fire Safety Inspector");

        Inspection inspection = new Inspection();
        inspection.setInspectionID(1);
        inspection.setInspectionName("Fire safety");
        inspection.setInspector(inspector);
        inspection.setFacilityRoom(facilityRoom1);

        inspectorList.add(inspector);
        inspectorList.remove(inspector);
        assertTrue(inspectorList.isEmpty());
    }
}