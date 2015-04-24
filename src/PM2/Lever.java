/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PM2;

import jgame.platform.JGEngine;


public class Lever {
    
    public static Lever valueOf(Timer timer, int keyUp, int keyDown, JGEngine engine, double max, double timeToMax, boolean autoZero, boolean negativeValues){
        return new Lever(timer, keyUp, keyDown, engine, max, timeToMax, autoZero, negativeValues);
    }
    
    private final Timer timer;
    private double level = 0.0;
    private final int keyUp;
    private final int keyDown;
    private final JGEngine engine;
    private final double max;
    private final double timeToMax;
    private final boolean autoZero;
    private final boolean negativeValues;
    

    private Lever(Timer timer, int keyUp, int keyDown, JGEngine engine, double max, double timeToMax, boolean autoZero, boolean negativeValues) {
        this.timer = timer;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.engine = engine;
        this.max = max;
        this.timeToMax = timeToMax;
        this.autoZero = autoZero;
        this.negativeValues = negativeValues;
    }

    
    private void setLevel(double level) {
        if(level > max){
            level = max;
        }else if(negativeValues && level < -max){
            level = -max;
        }else if(!negativeValues && level < 0.0){
            level = 0.0;
        }    
        this.level = level;
    }
    
    public double getLevel() {
        return level;
    }


    public double update() {
        if(keyUp > 0 && engine.getKey(keyUp)){
            setLevel(getLevel() + (Math.abs(max)/timeToMax * timer.getTimeElapsed()));
        }else if(keyDown > 0 && engine.getKey(keyDown)){
            setLevel(getLevel() - (Math.abs(max)/timeToMax * timer.getTimeElapsed()));
        }else if(autoZero){
            setLevel(getLevel() + Math.signum(-getLevel()) * Math.abs(max)/timeToMax * timer.getTimeElapsed());
        }
        return level;
    }  
}
