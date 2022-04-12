package test.java;

import com.university.model.facility.FacilityLocation;
import com.university.model.facility.FacilityRoom;
import com.university.model.facility.IFacilityRoom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class FacilityLocationTest {

    private List<IFacilityRoom> roomList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception{
        roomList = new ArrayList<>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() throws Exception{
        roomList = null;
    }

    @org.junit.jupiter.api.Test
    void addFacilityRoom() {
        FacilityLocation facility = new FacilityLocation();
        facility.setFacilityId(1);
        facility.setName("Murphy Building");
        facility.setAddressNumber(123);
        facility.setStreetName("State Street");
        facility.setCity("Chicago");
        facility.setZipcode(123456);

        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);
        facilityRoom1.setFacilityLocation(facility);
        facilityRoom1.setInUse(true);
        roomList.add(facilityRoom1);
        assertTrue(roomList.contains(facilityRoom1));
    }

    @org.junit.jupiter.api.Test
    void removeFacilityRoom() {
        FacilityLocation facility = new FacilityLocation();
        facility.setFacilityId(1);
        facility.setName("Murphy Building");
        facility.setAddressNumber(123);
        facility.setStreetName("State Street");
        facility.setCity("Chicago");
        facility.setZipcode(123456);

        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);
        facilityRoom1.setInUse(true);
        facilityRoom1.setFacilityLocation(facility);
        roomList.remove(facilityRoom1);
        assertTrue(roomList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void calcFacilityUsage() {
        FacilityLocation facility = new FacilityLocation();
        facility.setFacilityId(1);
        facility.setName("Murphy Building");
        facility.setAddressNumber(123);
        facility.setStreetName("State Street");
        facility.setCity("Chicago");
        facility.setZipcode(123456);

        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);
        facilityRoom1.setInUse(true);
        facilityRoom1.setFacilityLocation(facility);

        FacilityRoom facilityRoom2 = new FacilityRoom();
        facilityRoom2.setFacilityRoomId(2);
        facilityRoom2.setPhoneNumber("123-456-7890");
        facilityRoom2.setCapacity(10);
        facilityRoom2.setInUse(false);
        facilityRoom2.setFacilityLocation(facility);

        FacilityRoom facilityRoom3 = new FacilityRoom();
        facilityRoom3.setFacilityRoomId(3);
        facilityRoom3.setPhoneNumber("123-456-7890");
        facilityRoom3.setCapacity(10);
        facilityRoom3.setInUse(false);
        facilityRoom3.setFacilityLocation(facility);

        roomList.add(facilityRoom1);
        roomList.add(facilityRoom2);
        roomList.add(facilityRoom3);

        double result = facility.calcFacilityUsage(roomList);

        assertEquals(0.3333333333333333, result);
    }
}