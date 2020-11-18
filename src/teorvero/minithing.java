package teorvero;

public class minithing {



    public static double maxArg(double[] mass) {
        double max = -1000;

        for (int i = 0; i < mass.length; i++) {
            if (max < mass[i]) {
                max = mass[i];
            }
        }
        return max;
    }

    public static double minArg(double[] mass) {
        double min = 1000;

        for (int i = 0; i < mass.length; i++) {
            if (min > mass[i]) {
                min = mass[i];
            }
        }
        return min;
    }
    public static double[] pi(double[] hits){
        double[] piki = new double[8];
        for (int i = 0; i < hits.length; i++) {
            piki[i]=hits[i]/100;
        }
        return piki;
    }
}
