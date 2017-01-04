package com.sample.daggersample;

import java.util.ArrayList;

/**
 * Created by tarun.n.shetty on 1/3/2017.
 */
public class Motor {

    ArrayList<String> mMarutiModels;
    ArrayList<String> mHyundaiModels;

    public Motor(){
        mMarutiModels = new ArrayList<>();
        mMarutiModels.add("Ciaz");
        mMarutiModels.add("Ertiga");
        mMarutiModels.add("Swift Dzire");
        mMarutiModels.add("Celerio");
        mMarutiModels.add("Ritz");
        mMarutiModels.add("Swift");
        mMarutiModels.add("Baleno");
        mMarutiModels.add("Zen Estilo");

        mHyundaiModels = new ArrayList<>();
        mHyundaiModels.add("i20");
        mHyundaiModels.add("i10");
        mHyundaiModels.add("Creta");
        mHyundaiModels.add("Verna");
        mHyundaiModels.add("Eon");
        mHyundaiModels.add("Elantra");
    }

    public ArrayList<String> getMotorList(String brand){
        ArrayList<String> list = new ArrayList<>();

        if (brand.equalsIgnoreCase("Maruti Suzuki")){

            list.addAll(mMarutiModels);

        }else{
            list.addAll(mHyundaiModels);

        }
        return list;
    }

}
