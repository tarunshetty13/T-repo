package com.sample.daggersample;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tarun.n.shetty on 1/3/2017.
 */
@Module
public class VehicleModule {

    @Provides
    @Singleton
    Motor provideMotor(){
        return new Motor();
    }

    @Provides @Singleton
    Vehicle provideVehicle(){
        return new Vehicle(new Motor());
    }
}
