package com.ShawnMeister.springceilingfan;

import java.time.LocalDate;

public class CeilingFan {
    private int speed = 0;
    private boolean reversed = false;

    public void pullSpeedCord() {
        if (isDecember25th()) {
            speed = (speed + 1) % 4;
            System.out.println("Speed: " + speed + ", Direction: " + (reversed ? "Reversed" : "Forward"));
        } else {
            System.out.println("Ceiling fan is disabled on December 25th");
        }
    }

    public void pullDirectionCord() {
        if (!isDecember25th()) {
            reversed = !reversed;
            System.out.println("Speed: " + speed + ", Direction: " + (reversed ? "Reversed" : "Forward"));
        } else {
            System.out.println("Ceiling fan is disabled on December 25th");
        }
    }

    private boolean isDecember25th() {
        LocalDate today = LocalDate.now();
        System.out.println("Today is: " + today);
        return today.getMonthValue() == 12 && today.getDayOfMonth() == 25;
    }
}
