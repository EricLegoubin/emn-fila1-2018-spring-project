/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emn.GEO.simulateur;

/**
 *
 * @author eliot
 */
public class FasterSystemClock {
    private double speed;
    private long startTime;
    public static FasterSystemClock clock = new FasterSystemClock();
    
    private FasterSystemClock(){
        speed=10;
        startTime=System.currentTimeMillis();
    }
    
    public long getTime(){
        return (long) ((System.currentTimeMillis() - this.startTime) * this.speed + this.startTime);
    }
}
