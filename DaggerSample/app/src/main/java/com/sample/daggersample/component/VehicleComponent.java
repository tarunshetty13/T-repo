package com.sample.daggersample.component;

import com.sample.daggersample.Vehicle;
import com.sample.daggersample.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tarun.n.shetty on 1/3/2017.
 */

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    Vehicle provideVehicle();
}
