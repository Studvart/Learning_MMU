package ITP_Week1;

public class SwimmingPool {
    public static void main(String[] args)
    {

        int length = 25;
        int width = 10;
        int depth = 2;

        //“A pool of length 25m, width 10m and depth 2m will require 500 cubic metres of water to fill it.”
        System.out.println("A pool of length " + length + "m, width " + width + "m and depth " + depth + "m will require " + (length * width * depth) + " cubic metres of water to fill it.");

        // A pool of length: 25m, width 10m and depth 2m will require 500000 litres of water to fill it.
        System.out.println("A pool of length " + length + "m, width " + width + "m and depth " + depth + "m will require " + ((length * width * depth)*1000) + " cubic metres of water to fill it.");


    }
}
