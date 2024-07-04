package com.sparta.spartios.datasanitisation;

import com.sparta.spartios.dtos.Employee;

import javax.xml.crypto.Data;
import java.util.HashSet;

public class DuplicateEmployeeIDPredicate implements java.util.function.Predicate<Employee>{
    private final HashSet<String> seenIDs = new HashSet<>();

    @Override

    public boolean test(Employee employee){

        if(!seenIDs.add(employee.employeeID())){
            DataCheck.increaseNumberOfCorruptions();
            return false;
        }
        else return true;
    }
}
