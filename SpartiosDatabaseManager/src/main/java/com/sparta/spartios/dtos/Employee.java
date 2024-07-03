package com.sparta.spartios.dtos;

public record Employee(String employeeID, String prefix, String firstName, String middleInitial, String lastName,
                       String gender, String email, String dateOfBirth, String dateOfJoining, String salary) {

}
