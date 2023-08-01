package com.company.oop.dealership.commands;

import com.company.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.List;

public class ShowUsersCommand extends BaseCommand{

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

   //private VehicleDealershipRepository vehicleDealershipRepository;
    public ShowUsersCommand(VehicleDealershipRepository vehicleDealershipRepository){
        super(vehicleDealershipRepository);
        //this.vehicleDealershipRepository = vehicleDealershipRepository;
    }



    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return getVehicleDealershipRepository().showUsers();
    }
    @Override
    protected boolean requiresLogin() {
        return false;
    }
}