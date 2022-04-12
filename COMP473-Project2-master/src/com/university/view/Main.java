package com.university.view;

import com.university.model.use.Lab;
import com.university.model.use.Office;
import com.university.model.use.Student;
import com.university.model.use.User;


public class Main {
    public static void main(String[] args) {
        Office office =  new Office();
        office.setTypeId(1);
        office.setFacilityUseType();
        //System.out.println(office.getFacilityUseType());
        //System.out.println(office.getTypeId());

        Lab lab = new Lab();
        lab.setFacilityUseType();



        Student student = new Student();
        student.setUserId(1);
        student.setUserFirstName("John");
        student.setUserLastName("Doe");
        student.setUserTitle();
        student.setUseType(office);
        System.out.println(student.getUserTitle());
        System.out.println(student.getUseType().getTypeId());




    }
}
