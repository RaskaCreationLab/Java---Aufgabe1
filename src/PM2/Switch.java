
package PM2;

import jgame.platform.JGEngine;

public class Switch {
    public static Switch valueOf(JGEngine engine, int key){
        return new Switch(engine, key);
    }
    
    private boolean on = false;
    private final JGEngine engine;
    private final int key;
    private boolean onceNotUsed = true;
    
    private Switch(JGEngine engine, int key){
       this.engine = engine;
       this.key = key;
    }
    
    public boolean isOn() {
        return on;
    }
    
    public boolean update(){
        if(engine.getKey(key) && onceNotUsed) {
            on = !on;
            onceNotUsed = false;
        }else if(!engine.getKey(key)) {
            onceNotUsed = true;
        }
        
        return on;
    }
}