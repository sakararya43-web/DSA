class Solution {
    public double[] convertTemperature(double celsius) {
        double kelvin=0;
        double fahrenheit = 0;

        double[] arr = new double[2];
        kelvin = celsius + 273.15;
        fahrenheit =(celsius * 1.80) + 32.00;

        arr[0]=kelvin;
        arr[1]=fahrenheit;
        return arr;


    }
}