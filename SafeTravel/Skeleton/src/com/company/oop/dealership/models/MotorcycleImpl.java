package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Motorcycle;
import com.company.oop.dealership.models.enums.VehicleType;

import static java.lang.String.format;

public class MotorcycleImpl extends VehicleCore implements Motorcycle {

    public static final int CATEGORY_LEN_MIN = 3;
    public static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);

    private String category;

    public MotorcycleImpl(String make, String model, double price, String category) {
        super(make, model, price);
    }

    @Override
    public int getWheels() {
        return 2;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.MOTORCYCLE;
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    //TODO


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append(String.format("Category: %s", getCategory())).append(System.lineSeparator());
        return result.toString();
    }
}