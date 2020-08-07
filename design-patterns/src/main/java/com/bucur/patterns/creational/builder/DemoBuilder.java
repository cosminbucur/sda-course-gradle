package com.bucur.patterns.creational.builder;

import com.bucur.patterns.creational.builder.builders.CarBuilder;
import com.bucur.patterns.creational.builder.builders.CarManualBuilder;
import com.bucur.patterns.creational.builder.cars.Car;
import com.bucur.patterns.creational.builder.director.Director;
import com.bucur.patterns.creational.builder.manuals.Manual;

public class DemoBuilder {

    public static void main(String[] args) {
        Director director = new Director();

        // Director gets the concrete com.bucur.builder object from the client
        // (application code). That's because application knows better which
        // com.bucur.builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        // The final product is often retrieved from a com.bucur.builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
