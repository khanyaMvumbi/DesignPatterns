/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.designPatterns.creational.Builder;

import com.cput.my.wonder.designPatterns.creational.builder.BMWVehicle;
import com.cput.my.wonder.designPatterns.creational.builder.ToyotaVehicle;
import com.cput.my.wonder.designPatterns.creational.builder.VehicleBuilder;
import com.cput.my.wonder.designPatterns.creational.builder.VehicleDirector;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Khanya
 */
public class BuilderTest {
    
    public BuilderTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void BMWBuilds() {
        
        VehicleBuilder vehicleBuilder = new BMWVehicle();
        
        VehicleDirector director = new VehicleDirector(vehicleBuilder);
        director.constructVehicle();
        
        Assert.assertEquals("5 series", director.getVehicle().getName());
                    
     }
     
     @Test
     public void ToyotaBuilds() {
        
        VehicleBuilder vehicleBuilder = new ToyotaVehicle();
        
        VehicleDirector director = new VehicleDirector(vehicleBuilder);
        director.constructVehicle();
        
        Assert.assertEquals("corrola", director.getVehicle().getName());
            
         
     }
     

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
