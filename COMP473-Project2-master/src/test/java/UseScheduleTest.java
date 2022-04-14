package test.java;

import com.university.model.facility.*;
import com.university.model.use.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UseScheduleTest {

    private List<IType> listActualUsage = new ArrayList<>();
    private List<IUser> listUsers = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        List<IType> listActualUsage = new ArrayList<>();
        List<IUser> listUsers = new ArrayList<>();

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        listActualUsage = null;
        listUsers = null;
    }

    @org.junit.jupiter.api.Test
    void requestAvailableCapacity() {

        FacilityLocation facility = new FacilityLocation();
        facility.setFacilityId(1);
        facility.setName("Murphy Building");
        facility.setAddressNumber(123);
        facility.setStreetName("State Street");
        facility.setCity("Chicago");
        facility.setZipcode(123456);

        FacilityRoom room = new FacilityRoom();
        room.setFacilityRoomId(1);
        room.setRoomNumber(101);
        room.setPhoneNumber("123-456-7890");
        room.setCapacity(10);
        room.setFacilityLocation(facility);
        room.setInUse(true);

        Office office =  new Office();
        office.setTypeId(1);
        office.setFacilityRoom(room);
        office.setUseStartDate(new Date(2020, 12, 1, 13, 45));
        office.setUseEndDate(new Date(2020, 12, 1, 14, 45));

        Student student = new Student(office);
        student.setUserFirstName("John");
        student.setUserLastName("Doe");
        student.setUserId(1);
        student.setOccupancy(1);

        UseSchedule useSchedule = new UseSchedule();
        useSchedule.requestAvailableCapacity(room, student);
        useSchedule.addActualUsage(office);
        useSchedule.assignUserToFacilityRoom(student);

        assertEquals(10, room.getCapacity());
        assertEquals("Office", student.getUseType().getFacilityUseType());
        assertEquals(office, student.getUseType());
        assertEquals(1, student.getOccupancy());
        assertEquals(9, useSchedule.requestAvailableCapacity(room, student));
    }

    @org.junit.jupiter.api.Test
    void assignUserToFacilityRoom() {
        FacilityLocation facility = new FacilityLocation();
        facility.setFacilityId(1);
        facility.setName("Murphy Building");
        facility.setAddressNumber(123);
        facility.setStreetName("State Street");
        facility.setCity("Chicago");
        facility.setZipcode(123456);

        FacilityRoom room = new FacilityRoom();
        room.setFacilityRoomId(1);
        room.setRoomNumber(101);
        room.setPhoneNumber("123-456-7890");
        room.setCapacity(10);
        room.setFacilityLocation(facility);
        room.setInUse(true);

        Office office =  new Office();
        office.setTypeId(1);
        office.setFacilityRoom(room);
        office.setUseStartDate(new Date(2020, 12, 1, 13, 45));
        office.setUseEndDate(new Date(2020, 12, 1, 14, 45));

        Student student = new Student(office);
        student.setUserFirstName("John");
        student.setUserLastName("Doe");
        student.setUserId(1);
        student.setOccupancy(1);

        listUsers.add(student);

        assertEquals("John", student.getUserFirstName());
        assertEquals("Doe", student.getUserLastName());
        assertEquals(1, student.getUserId());
        assertEquals(1, student.getOccupancy());
        assertTrue(listUsers.contains(student));
    }

    @org.junit.jupiter.api.Test
    void vacateFacilityRoom() {
        FacilityLocation facility = new FacilityLocation();
        facility.setFacilityId(1);
        facility.setName("Murphy Building");
        facility.setAddressNumber(123);
        facility.setStreetName("State Street");
        facility.setCity("Chicago");
        facility.setZipcode(123456);

        FacilityRoom room = new FacilityRoom();
        room.setFacilityRoomId(1);
        room.setRoomNumber(101);
        room.setPhoneNumber("123-456-7890");
        room.setCapacity(10);
        room.setFacilityLocation(facility);
        room.setInUse(true);

        Office office =  new Office();
        office.setTypeId(1);
        office.setFacilityRoom(room);
        office.setUseStartDate(new Date(2020, 12, 1, 13, 45));
        office.setUseEndDate(new Date(2020, 12, 1, 14, 45));

        Student student = new Student(office);
        student.setUserFirstName("John");
        student.setUserLastName("Doe");
        student.setUserId(1);
        student.setOccupancy(1);

        listUsers.add(student);
        listUsers.remove(student);

        assertTrue(listUsers.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addActualUsage() {
        FacilityLocation facility = new FacilityLocation();
        facility.setFacilityId(1);
        facility.setName("Murphy Building");
        facility.setAddressNumber(123);
        facility.setStreetName("State Street");
        facility.setCity("Chicago");
        facility.setZipcode(123456);

        FacilityRoom room = new FacilityRoom();
        room.setFacilityRoomId(1);
        room.setRoomNumber(101);
        room.setPhoneNumber("123-456-7890");
        room.setCapacity(10);
        room.setFacilityLocation(facility);
        room.setInUse(true);

        Office office =  new Office();
        office.setTypeId(1);
        office.setFacilityRoom(room);
        office.setUseStartDate(new Date(2020, 12, 1, 13, 45));
        office.setUseEndDate(new Date(2020, 12, 1, 14, 45));

        listActualUsage.add(office);

        assertEquals(1, office.getTypeId());
        assertEquals(room, office.getFacilityRoom());
        assertTrue(listActualUsage.contains(office));
    }

    @org.junit.jupiter.api.Test
    void removeActualUsage() {
        FacilityLocation facility = new FacilityLocation();
        facility.setFacilityId(1);
        facility.setName("Murphy Building");
        facility.setAddressNumber(123);
        facility.setStreetName("State Street");
        facility.setCity("Chicago");
        facility.setZipcode(123456);

        FacilityRoom room = new FacilityRoom();
        room.setFacilityRoomId(1);
        room.setRoomNumber(101);
        room.setPhoneNumber("123-456-7890");
        room.setCapacity(10);
        room.setFacilityLocation(facility);
        room.setInUse(true);

        Office office =  new Office();
        office.setTypeId(1);
        office.setFacilityRoom(room);
        office.setUseStartDate(new Date(2020, 12, 1, 13, 45));
        office.setUseEndDate(new Date(2020, 12, 1, 14, 45));

        listActualUsage.add(office);
        listActualUsage.remove(office);

        assertTrue(listActualUsage.isEmpty());
    }

   @org.junit.jupiter.api.Test
    void timeInterval() {

       FacilityLocation facility = new FacilityLocation();
       facility.setFacilityId(1);
       facility.setName("Murphy Building");
       facility.setAddressNumber(123);
       facility.setStreetName("State Street");
       facility.setCity("Chicago");
       facility.setZipcode(123456);

       FacilityRoom room = new FacilityRoom();
       room.setFacilityRoomId(1);
       room.setRoomNumber(101);
       room.setPhoneNumber("123-456-7890");
       room.setCapacity(10);
       room.setFacilityLocation(facility);
       room.setInUse(true);

       Office office =  new Office();
       office.setTypeId(1);
       office.setFacilityRoom(room);
       office.setUseStartDate(new Date(2020, 12, 1, 13, 45));
       office.setUseEndDate(new Date(2020, 12, 1, 14, 45));

       Student student = new Student(office);
       student.setUserFirstName("John");
       student.setUserLastName("Doe");
       student.setUserId(1);
       student.setOccupancy(1);

       UseSchedule useSchedule = new UseSchedule();
       useSchedule.requestAvailableCapacity(room, student);
       useSchedule.addActualUsage(office);
       useSchedule.assignUserToFacilityRoom(student);

        long result = useSchedule.timeInterval(office);

        assertEquals(3600000, result);
    }

}