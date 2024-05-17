package com.ShawnMeister.springceilingfan;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class KeyEventHandler {
    private CeilingFan ceilingFan;

    public KeyEventHandler(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void createKeyListener() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    System.out.println("Key Pressed: " + e.getKeyCode());
                    if (e.getKeyCode() == KeyEvent.VK_S) {
                        System.out.println("S pressed");
                        ceilingFan.pullSpeedCord();
                    } else if (e.getKeyCode() == KeyEvent.VK_D) {
                        System.out.println("D pressed");
                        ceilingFan.pullDirectionCord();
                    }
                }
                return false;
            }
        });
    }
}
