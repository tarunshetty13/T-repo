package com.sample.daggersample;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by tarun.n.shetty on 1/3/2017.
 */
public class Vehicle {

    private Motor motor;

    @Inject
    public Vehicle(Motor motor){
        this.motor = motor;
    }

    public ArrayList<String> getModelList(String brand){

        return motor.getMotorList(brand);
    }

}
