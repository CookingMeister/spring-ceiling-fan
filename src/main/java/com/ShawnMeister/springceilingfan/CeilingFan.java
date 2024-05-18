package com.ShawnMeister.springceilingfan;

import java.time.LocalDate;

public class CeilingFan {
    private int speed = 0;
    private boolean reversed = false;

    public void pullSpeedCord() {
        try {
            if (!isDecember25th()) {
                speed = (speed + 1) % 4;
                System.out.println("Speed: " + speed + ", Direction: " + (reversed ? "Reversed" : "Forward"));
            } else {
                System.out.println("Ceiling fan is disabled on December 25th");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while pulling the speed cord: " + e.getMessage());
        }
    }

    public void pullDirectionCord() {
        try {
            if (!isDecember25th()) {
                reversed = !reversed;
                System.out.println("Speed: " + speed + ", Direction: " + (reversed ? "Reversed" : "Forward"));
            } else {
                System.out.println("Ceiling fan is disabled on December 25th");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while pulling the direction cord: " + e.getMessage());
        }
    }

    public void getRecipe() {
        try {
            System.out.println("Recipe incoming...");
        } catch (Exception e) {
            System.out.println("An error occurred while getting the recipe: " + e.getMessage());
        }
    }

    private boolean isDecember25th() {
        try {
            LocalDate today = LocalDate.now();
            System.out.println("Today is: " + today);
            return today.getMonthValue() == 12 && today.getDayOfMonth() == 25;
        } catch (Exception e) {
            System.out.println("An error occurred while checking the date: " + e.getMessage());
            return false;
        }
    }
}
