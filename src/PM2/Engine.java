package PM2;

import java.util.Set;
import jgame.JGColor;
import jgame.JGPoint;
import jgame.platform.JGEngine;

/**
 *
 * @author Marvin
 */
class Engine extends JGEngine {

    private long lastFrameAtInMillis = System.currentTimeMillis();

    private Set particles;

    public Engine(JGPoint size) {
        // This inits the engine as an application.
        initEngine(size.x, size.y);
    }

    public void setParticles(Set particles) {
        this.particles = particles;
    }


    public void initCanvas() {
        setCanvasSettings(
                20, // width of the canvas in tiles
                15, // height of the canvas in tiles
                16, // width of one tile
                16, // height of one tile
                //    (note: total size = 20*16=320  x  15*16=240)
                null,// foreground colour -> use default colour white
                new JGColor(255, 255, 255),// background colour -> use default colour black
                null // standard font -> use default font
                );
    }

    @Override
    public void initGame() {
        setFrameRate(
                35,// 35 = frame rate, 35 frames per second
                2 //  2 = frame skip, skip at most 2 frames before displaying
                //      a frame again
                );
        lastFrameAtInMillis = System.currentTimeMillis();
    }

    /** Game logic is done here.  No painting can be done here, define
     * paintFrame to do that. */
    @Override
    public void doFrame() {
        long currentMillis = System.currentTimeMillis();
        for(Object value: particles){
            ParticleInterface particle = (ParticleInterface)value;
            particle.simulateStep((float)(currentMillis - lastFrameAtInMillis)/1000);
            //Alternative:
//            particle.simulateStep(1f / (float) getFrameRate());
        }
        lastFrameAtInMillis = System.currentTimeMillis();
    }

    /** Any graphics drawing beside objects or tiles should be done here.
     * Usually, only status / HUD information needs to be drawn here. */
    @Override
    public void paintFrame() {
        setColor(JGColor.black);
        for(Object value: particles){
            ParticleInterface particle = (ParticleInterface)value;
            drawOval(particle.getXInMeters(), particle.getYInMeters(), 5, 5, true, true);
        }
    }
}