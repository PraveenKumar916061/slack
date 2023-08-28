package com.img.Event_organization.exception;

import java.security.PublicKey;

public class CollegeNotAllowedException extends Exception{
    public CollegeNotAllowedException(){
        System.out.println("Your are not allowed... u are from different college");
    }
}
