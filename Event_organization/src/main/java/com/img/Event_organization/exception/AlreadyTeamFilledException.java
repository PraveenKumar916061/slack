package com.img.Event_organization.exception;

public class AlreadyTeamFilledException extends Exception{
    public AlreadyTeamFilledException(){
        System.out.println("Already team filled... can't add in this team");
    }
}
