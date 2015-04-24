package PM2;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import jgame.JGColor;
import jgame.platform.JGEngine;

public class Window extends JGEngine {
    private Timer timer;
    private Switch halloSwitch;
    private Switch halloSwitch2;
    private boolean isloaded = false;
    private Lever redHello;
    private Lever greenHello;
    private Player player;
    
    private Window(int width, int height) {
        timer = Timer.valueOf();
        halloSwitch = Switch.valueOf(this, KeyEvent.VK_H);
        isloaded = true;
        //(timer, keyUp, keyDown, engine, max, timeToMax, autoZero, negativeValues)
        redHello = Lever.valueOf(timer, KeyEvent.VK_A, KeyEvent.VK_S, this, 255, 3.0, false, false);
        greenHello = Lever.valueOf(timer, KeyEvent.VK_Q, KeyEvent.VK_W, this, 255, 3.0, true, false);
        initEngine(width, height);
        player = Player.valueOf(this,timer);
    }
    
    public static Window valueOf(int width, int height) {
        return new Window(width, height);
    }
    

    @Override
    public void initCanvas() {
        setCanvasSettings(
                50, // Anzahl auf x-Achse
                37, // Anzahl auf y-Achse
                16, // Breite Tiles
                16, // Hoehe Tiles
                JGColor.blue, // Vordergrund
                new JGColor(0, 200, 100, 100), // Hintergrund (Rot=0, Gruen=100, Blue=100)
                null // Schriftart
        );
    }

    @Override
    public void initGame() {
        while(!isloaded) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setFrameRate(60, 2);
        defineImage("PlayerSprite", "p", 0, "0.png", "-");
    }
    
    @Override
    public void doFrame() {
        // LOGIK
        
        // Update-Aufruf vom Timer
        double timeDiff = timer.update();
        //System.out.println(timeDiff);
        halloSwitch.update();
        redHello.update();
        greenHello.update();
        moveObjects();
        // Step-Aufruf von Porsche
        //porsche.step(timeDiff, 1.0);
    }
    
    @Override
    public void paintFrame() {
        setColor(new JGColor((int) redHello.getLevel(), (int) greenHello.getLevel(), 0));
        // RENDERN
        if(halloSwitch.isOn()) {
         drawString("Hello world!",
                viewWidth()/2, // x-Position
                viewHeight()/2, // y-Position
                0); // 0 = zentriert, -1 = linksbuendig, 1 = rechtsbuendig
        }
    }
}
