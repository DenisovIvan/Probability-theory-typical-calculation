package teorvero;

import static teorvero.minithing.maxArg;
import static teorvero.minithing.minArg;

public class calculations {

    public static double step(double[] mass, int K) {

        return (maxArg(mass) - minArg(mass)) / K;
    }

    public static double averageArg(double[] mass) {
        double summ = 0;
        for (int i = 0; i < mass.length; i++) {
            summ = summ + mass[i];
        }
        return summ / mass.length;
    }

    public static double[] sort(double[] m) {
        double[] massave = new double[100];
        for (int i = 0; i < 100; i++) {
            massave[i] = m[i];
        }
        double[] mass = new double[100];
        for (int i = 0; i < 100; i++) {
            double save = -100;
            int savej = 0;
            for (int j = 0; j < 100; j++) {
                if (save < massave[j]) {
                    save = massave[j];
                    savej = j;
                }
            }
            mass[99 - i] = save;
            massave[savej] = -777;
        }
        return mass;
    }

    public static double[] sortmass(double[] MASS, double[] mass) {
        double[] newmass = new double[100];
        double[] massave = new double[100];
        for (int i = 0; i < 100; i++) {
            massave[i] = MASS[i];
        }
        for (int i = 0; i < 100; i++) {
            double save = -1000;
            int savej = 0;
            for (int j = 0; j < 100; j++) {
                if (save < massave[j]) {
                    save = massave[j];
                    savej = j;
                }
            }
            newmass[99 - i] = mass[savej];
            massave[savej] = -666;
        }
        return newmass;
    }

    public static double[] inter(double[] massArg) {
        double[] inter = new double[9];
        double min = minArg(massArg);
        int c = 0;
        for (int i = 0; i < 9; i++) {
            inter[i] = min + step(massArg, 8) * c;
            c = c + 1;
        }
        return inter;
    }

    public static double[] hits(double[] massArg, double[] inter) {
        double[] hits = new double[8];
        int c = 0;
        int check = 0;
        for (int p = 0; p < 8; p++) {
            for (int i = 0; i < massArg.length; i++) {

                if (massArg[i] > inter[p] && massArg[i] < inter[p + 1]) {
                    hits[c] = hits[c] + 1;

                } else {
                    if (massArg[i] == inter[p] | massArg[i] == inter[p + 1]) {
                        if (p == 0 || p == 7) {
                            hits[c] = hits[c] + 1;
                        } else {
                            if (check == 0) {
                                hits[c] = hits[c] + 0.5;
                                hits[c + 1] = hits[c + 1] + 0.5;
                                check = 1;
                            } else {
                                check = 0;
                            }

                        }
                    }
                }

            }
            c = c + 1;
        }

        return hits;
    }

    public static double frequency(double[] mass, double n) {
        double save = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < n) {
                save = save + 1;
            }
        }
        return save / 100;
    }

    public static double COR(double[] massx, double[] massy) {
        double save = 0;
        double b = 0;
        for (int i = 0; i < 100; i++) {
            save = save + ((massx[i] * massy[i]));
        }
        b = (save / 100) - (averageArg(massx) * averageArg(massy));
        return b;
    }

    public static double cor(double COR, double x, double y) {
        double save = 0;
        save = COR / (x * y);
        return save;
    }

    public static double ttt(double cor) {
        double save = 0;
        save = ((cor / (Math.sqrt(1 - Math.pow(cor, 2)))) * Math.sqrt(98));
        return save;
    }

    public static double[] xuita(double[] link, double[] hits) {
        double mass[] = new double[8];
        int level = 0;
        int c = 0;
        for (int i = 0; i < 8; i++) {
            double savenum = 0;
            double savekol = 0;
            if (hits[i] % 1 == 0) {
                for (int j = 0; j < hits[i]; j++) {
                    savenum = savenum + link[c];
                    savekol = savekol + 1;
                    c = c + 1;
                }
            } else {
                if (level == 0) {
                    for (int j = 0; j < hits[i] - 0.5; j++) {
                        savenum = savenum + link[c];
                        savekol = savekol + 1;
                        c = c + 1;
                    }
                    level = 1;
                    savenum = savenum + link[c] / 2;
                    savekol = savekol + 1 / 2;
                } else {
                    savenum = savenum + link[c] / 2;
                    savekol = savekol + 1 / 2;
                    c = c + 1;
                    for (int j = 0; j < hits[i] - 0.5; j++) {
                        savenum = savenum + link[c];
                        savekol = savekol + 1;
                        c = c + 1;
                    }
                    level = 0;
                }
            }
            mass[i] = savenum / savekol;
        }
        return mass;
    }
        public static double si2(double average,double[] hits,double[] znag) {
            
        double save = 0;
            for (int i = 0; i < 8; i++) {
                save =save + hits[i]*Math.pow(znag[i],2);
            }
        return (save-(Math.pow(average,2)*100))/99;
    }
                public static double SI2(double average,double[] arg) {
            
        double save = 0;
            for (int i = 0; i < 100; i++) {
                save =save + Math.pow(arg[i],2);
            }
        return (save-(Math.pow(average,2)*100))/99;
    }
}
