package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public abstract class VehicleCore implements Vehicle {

    public static final int MAKE_NAME_LEN_MIN = 2;
    public static final int MAKE_NAME_LEN_MAX = 15;
    private static final String MAKE_NAME_LEN_ERR = format(
            "Make must be between %s and %s characters long!",
            MAKE_NAME_LEN_MIN,
            MAKE_NAME_LEN_MAX);
    public static final int MODEL_NAME_LEN_MIN = 1;
    public static final int MODEL_NAME_LEN_MAX = 15;
    private static final String MODEL_NAME_LEN_ERR = format(
            "Model must be between %s and %s characters long!",
            MODEL_NAME_LEN_MIN,
            MODEL_NAME_LEN_MAX);
    public static final double PRICE_VAL_MIN = 0;
    public static final double PRICE_VAL_MAX = 1000000;
    private static final String PRICE_VAL_ERR = format(
            "Price must be between %.1f and %.1f!",
            PRICE_VAL_MIN,
            PRICE_VAL_MAX);


    private String make;
    private String model;
    private double price;

    private List<Comment> comments;
    public VehicleCore(String make,String model,double price){
        setMake(make);
        setModel(model);
        setPrice(price);
        comments = new ArrayList<>();

    }

    private void setPrice(double price) {
        ValidationHelpers.validateDecimalRange(price, PRICE_VAL_MIN, PRICE_VAL_MAX, PRICE_VAL_ERR);

        this.price = price;
    }

    private void setModel(String model) {
        ValidationHelpers.validateStringRange(model, MODEL_NAME_LEN_MIN,MODEL_NAME_LEN_MAX, MODEL_NAME_LEN_ERR);

        this.model = model;
    }

    private void setMake(String make) {
        ValidationHelpers.validateStringRange(make, MAKE_NAME_LEN_MIN, MAKE_NAME_LEN_MAX, MAKE_NAME_LEN_ERR);

        this.make = make;
    }


    @Override
    public abstract int getWheels();

    @Override
    public abstract VehicleType getType();

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);

    }
    public List<Comment> getComments(){
        return new ArrayList<>(this.comments);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("""
                #. %s:
                Make: %s
                Model: %s
                Wheels: %d
                Price: $%.1f
                """);
        //result = String.format(result, getType(), getMake(), getModel(), getWheels(), getPrice());
        return String.format(String.valueOf(result), getType(), getMake(), getModel(), getWheels(), getPrice());
    }
}
