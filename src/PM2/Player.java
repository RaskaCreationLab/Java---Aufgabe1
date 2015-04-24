package PM2;

import jgame.JGObject;
import jgame.platform.JGEngine;

public class Player extends JGObject {
    private JGEngine engine;
    private Timer timer;
    private final Porsche particle;
    
     public static Player valueOf(JGEngine engine, Timer timer) {
        return new Player(engine, timer);
    }
     
    public Player(JGEngine engine, Timer timer) {
        super("PlayerModel", true, 0.0, 0.0, 1, "PlayerSprite");
        this.engine = engine;
        this.timer = timer;
    }      
    @Override
    public void move(){
        particle.step(timer.getTimeElapsed());
        x = particle.getPos(X);
        y = particle.getPos(Y);
    }
}
