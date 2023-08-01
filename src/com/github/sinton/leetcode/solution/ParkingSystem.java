package com.github.sinton.leetcode.solution;

/**
 * 1603. Design Parking System
 * 设计停车系统
 */
public class ParkingSystem {
    private int[] parkings = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        this.parkings[0] = big;
        this.parkings[1] = medium;
        this.parkings[2] = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (this.parkings[0] - 1 >= 0) {
                    this.parkings[0]--;
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (this.parkings[1] - 1 >= 0) {
                    this.parkings[1]--;
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (this.parkings[2] - 1 >= 0) {
                    this.parkings[2]--;
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
}
