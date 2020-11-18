package teorvero;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static teorvero.calculations.*;
import static teorvero.forexcel.*;
import static teorvero.fromexcel.*;
import static teorvero.minithing.*;

public class tasks {

    public static void task1() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        writeIntoExcel(book, "task1", 0, 0, maxArg(x));
        writeIntoExcel(book, "task1", 0, 1, minArg(x));
        writeIntoExcel(book, "task1", 0, 2, step(x, 8));
        writeIntoExcel(book, "task1", 1, 0, maxArg(y));
        writeIntoExcel(book, "task1", 1, 1, minArg(y));
        writeIntoExcel(book, "task1", 1, 2, step(y, 8));
        writeIntoExcel(book, "task1", 0, 4, averageArg(x));
        writeIntoExcel(book, "task1", 1, 4, averageArg(y));
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        hity = hits(y, massy);
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task1", 3, i, "[ ");
            write(book, "task1", 3, i, massx[i]);
            writeString(book, "task1", 3, i, " ; ");
            write(book, "task1", 3, i, massx[i + 1]);
            writeString(book, "task1", 3, i, " ]");
            writeIntoExcel(book, "task1", 4, i, hitx[i]);
            writeIntoExcel(book, "task1", 5, i, hitx[i] / 100);
        }
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task1", 7, i, "[ ");
            write(book, "task1", 7, i, massy[i]);
            writeString(book, "task1", 7, i, " ; ");
            write(book, "task1", 7, i, massy[i + 1]);
            writeString(book, "task1", 7, i, " ]");
            writeIntoExcel(book, "task1", 8, i, hity[i]);
            writeIntoExcel(book, "task1", 9, i, hity[i] / 100);
        }
        book.write(new FileOutputStream("file.xlsx"));
        book.close();
    }

    public static void task2() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        hity = hits(y, massy);
        double c = 0;
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task2", 0, i, "[ ");
            write(book, "task2", 0, i, massx[i]);
            writeString(book, "task2", 0, i, " ; ");
            write(book, "task2", 0, i, massx[i + 1]);
            writeString(book, "task2", 0, i, " ]");
            writeIntoExcel(book, "task2", 1, i, hitx[i] / 100);
            writeIntoExcel(book, "task2", 2, i, (massx[i] + massx[i + 1]) / 2);
            writeIntoExcel(book, "task2", 3, i, ((massx[i] + massx[i + 1]) / 2) * (hitx[i] / 100));
            c = c + ((massx[i] + massx[i + 1]) / 2) * (hitx[i] / 100);
        }
        writeIntoExcel(book, "task2", 0, 10, c);
        writeIntoExcel(book, "task2", 0, 9, averageArg(x));
        writeIntoExcel(book, "task2", 0, 11, averageArg(x) - c);
        c = 0;
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task2", 5, i, "[ ");
            write(book, "task2", 5, i, massy[i]);
            writeString(book, "task2", 5, i, " ; ");
            write(book, "task2", 5, i, massy[i + 1]);
            writeString(book, "task2", 5, i, " ]");
            writeIntoExcel(book, "task2", 6, i, hity[i] / 100);
            writeIntoExcel(book, "task2", 7, i, (massy[i] + massy[i + 1]) / 2);
            writeIntoExcel(book, "task2", 8, i, ((massy[i] + massy[i + 1]) / 2) * (hity[i] / 100));
            c = c + ((massy[i] + massy[i + 1]) / 2) * (hity[i] / 100);
        }
        writeIntoExcel(book, "task2", 1, 10, c);
        writeIntoExcel(book, "task2", 1, 9, averageArg(y));
        writeIntoExcel(book, "task2", 1, 11, averageArg(y) - c);
        book.write(new FileOutputStream("file.xlsx"));
        book.close();
    }

    public static void task3() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));;
        //createExcel(book,"task3",30);
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        hity = hits(y, massy);
        double c = 0;
        double summ = 0;
        for (int i = 0; i < 100; i++) {
            c = c + Math.pow(x[i] - averageArg(x), 2);
        }
        writeIntoExcel(book, "task3", 10, 0, c / 99);
        writeIntoExcel(book, "task3", 11, 0, Math.sqrt(c / 99));
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task3", 0, i, "[ ");
            write(book, "task3", 0, i, massx[i]);
            writeString(book, "task3", 0, i, " ; ");
            write(book, "task3", 0, i, massx[i + 1]);
            writeString(book, "task3", 0, i, " ]");
            writeIntoExcel(book, "task3", 1, i, hitx[i] / 100);
            writeIntoExcel(book, "task3", 2, i, (massx[i] + massx[i + 1]) / 2);
            writeIntoExcel(book, "task3", 3, i, Math.pow((((massx[i] + massx[i + 1]) - averageArg(x)) / 2), 2) * (hitx[i] / 100));
            summ = summ + Math.pow((((massx[i] + massx[i + 1]) - averageArg(x)) / 2), 2) * (hitx[i] / 100);
        }
        writeIntoExcel(book, "task3", 10, 2, summ);
        writeIntoExcel(book, "task3", 10, 3, summ * 100 / 99);
        writeIntoExcel(book, "task3", 11, 2, Math.sqrt(summ));
        writeIntoExcel(book, "task3", 11, 3, Math.sqrt(summ * 100 / 99));

        summ = 0;
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task3", 5, i, "[ ");
            write(book, "task3", 5, i, massy[i]);
            writeString(book, "task3", 5, i, " ; ");
            write(book, "task3", 5, i, massy[i + 1]);
            writeString(book, "task3", 5, i, " ]");
            writeIntoExcel(book, "task3", 6, i, hity[i] / 100);
            writeIntoExcel(book, "task3", 7, i, (massy[i] + massy[i + 1]) / 2);
            writeIntoExcel(book, "task3", 8, i, Math.pow((((massy[i] + massy[i + 1]) - averageArg(y)) / 2), 2) * (hity[i] / 100));
            summ = summ + Math.pow((((massy[i] + massy[i + 1]) - averageArg(y)) / 2), 2) * (hity[i] / 100);
        }
        c = 0;
        for (int i = 0; i < 100; i++) {
            c = c + Math.pow(y[i] - averageArg(y), 2);
        }
        writeIntoExcel(book, "task3", 12, 0, c / 99);
        writeIntoExcel(book, "task3", 13, 0, Math.sqrt(c / 99));
        writeIntoExcel(book, "task3", 12, 2, summ);
        writeIntoExcel(book, "task3", 12, 3, summ * 100 / 99);
        writeIntoExcel(book, "task3", 13, 2, Math.sqrt(summ));
        writeIntoExcel(book, "task3", 13, 3, Math.sqrt(summ * 100 / 99));
        book.write(new FileOutputStream("file.xlsx"));
        book.close();
    }

    public static void task4() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        writeIntoExcel(book, "task4", 0, 0, (x[49] + x[50]) / 2);
        writeIntoExcel(book, "task4", 1, 0, (y[49] + y[50]) / 2);
        book.write(new FileOutputStream("file.xlsx"));
        book.close();

    }

    public static void task5() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double c = 0;
        double ax = averageArg(x);
        double ay = averageArg(y);
        c = read(book, "task3", 11, 0);
        writeIntoExcel(book, "task5", 0, 0, ax - (1.96 * c / 10));
        writeIntoExcel(book, "task5", 0, 1, ax + (1.96 * c / 10));
        writeIntoExcel(book, "task5", 0, 3, ax - (2.58 * c / 10));
        writeIntoExcel(book, "task5", 0, 4, ax + (2.58 * c / 10));
        writeIntoExcel(book, "task5", 0, 6, ax - (2.8 * c / 10));
        writeIntoExcel(book, "task5", 0, 7, ax + (2.8 * c / 10));
        c = read(book, "task3", 13, 0);
        writeIntoExcel(book, "task5", 2, 0, ay - (1.96 * c / 10));
        writeIntoExcel(book, "task5", 2, 1, ay + (1.96 * c / 10));
        writeIntoExcel(book, "task5", 2, 3, ay - (2.58 * c / 10));
        writeIntoExcel(book, "task5", 2, 4, ay + (2.58 * c / 10));
        writeIntoExcel(book, "task5", 2, 6, ay - (2.8 * c / 10));
        writeIntoExcel(book, "task5", 2, 7, ay + (2.8 * c / 10));
        book.write(new FileOutputStream("file.xlsx"));
        book.close();

    }

    public static void task6() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        hity = hits(y, massy);
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task6", 0, i, "[ ");
            write(book, "task6", 0, i, massx[i]);
            writeString(book, "task6", 0, i, " ; ");
            write(book, "task6", 0, i, massx[i + 1]);
            writeString(book, "task6", 0, i, " ]");
            writeIntoExcel(book, "task6", 1, i, hitx[i] / 100);
        }
        writeIntoExcel(book, "task6", 3, 0, step(x, 8));
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task6", 7, i, "[ ");
            write(book, "task6", 7, i, massy[i]);
            writeString(book, "task6", 7, i, " ; ");
            write(book, "task6", 7, i, massy[i + 1]);
            writeString(book, "task6", 7, i, " ]");
            writeIntoExcel(book, "task6", 8, i, hity[i] / 100);
        }
        writeIntoExcel(book, "task6", 10, 0, step(y, 8));
        book.write(new FileOutputStream("file.xlsx"));
        book.close();

    }

    public static void task7_1() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        writeIntoExcel(book, "task7_1", 0, 0, averageArg(x));
        writeIntoExcel(book, "task7_1", 0, 1, averageArg(y));
        writeIntoExcel(book, "task7_1", 1, 0, read(book, "task3", 10, 0));
        writeIntoExcel(book, "task7_1", 1, 1, read(book, "task3", 12, 0));
        writeIntoExcel(book, "task7_1", 2, 0, read(book, "task3", 11, 0));
        writeIntoExcel(book, "task7_1", 2, 1, read(book, "task3", 13, 0));
        book.write(new FileOutputStream("file.xlsx"));
        book.close();

    }

    public static void task8_1() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        //createExcel(book,"task8_1",30);
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        hity = hits(y, massy);
        writeIntoExcel(book, "task8_1", 0, 8, read(book, "task3", 11, 0));
        writeIntoExcel(book, "task8_1", 7, 8, read(book, "task3", 13, 0));
        writeIntoExcel(book, "task8_1", 0, 9, read(book, "task1", 0, 4));
        writeIntoExcel(book, "task8_1", 7, 9, read(book, "task1", 1, 4));
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task8_1", 0, i, "[ ");
            write(book, "task8_1", 0, i, massx[i]);
            writeString(book, "task8_1", 0, i, " ; ");
            write(book, "task8_1", 0, i, massx[i + 1]);
            writeString(book, "task8_1", 0, i, " ]");
        }
        writeIntoExcel(book, "task8_1", 1, 0, 0);
        for (int i = 1; i < 9; i++) {
            writeIntoExcel(book, "task8_1", 0, i + 11, massx[i]);
        }
        writeIntoExcel(book, "task8_1", 2, 7, 1);
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task8_1", 7, i, "[ ");
            write(book, "task8_1", 7, i, massy[i]);
            writeString(book, "task8_1", 7, i, " ; ");
            write(book, "task8_1", 7, i, massy[i + 1]);
            writeString(book, "task8_1", 7, i, " ]");
        }
        writeIntoExcel(book, "task8_1", 8, 0, 0);

        for (int i = 1; i < 9; i++) {
            writeIntoExcel(book, "task8_1", 7, i + 11, massy[i]);
        }
        writeIntoExcel(book, "task8_1", 9, 7, 1);
        book.write(new FileOutputStream("file.xlsx"));
        book.close();

    }

    public static void task9_1() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        //createExcel(book,"task9_1",30);
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        hity = hits(y, massy);
        double c = 0;
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task9_1", 0, i, "[ ");
            write(book, "task9_1", 0, i, massx[i]);
            writeString(book, "task9_1", 0, i, " ; ");
            write(book, "task9_1", 0, i, massx[i + 1]);
            writeString(book, "task9_1", 0, i, " ]");
            writeIntoExcel(book, "task9_1", 1, i, read(book, "task1", 5, i));
            writeIntoExcel(book, "task9_1", 2, i, read(book, "task8_1", 3, i));
            writeIntoExcel(book, "task9_1", 3, i, read(book, "task1", 5, i) - read(book, "task8_1", 3, i));
            writeIntoExcel(book, "task9_1", 4, i, (Math.pow((read(book, "task1", 5, i) - read(book, "task8_1", 3, i)), 2)) / read(book, "task8_1", 3, i));
            c = c + (Math.pow(read(book, "task1", 5, i) - read(book, "task8_1", 3, i), 2)) / read(book, "task8_1", 3, i);
        }
        writeIntoExcel(book, "task9_1", 5, 0, c);
        writeIntoExcel(book, "task9_1", 5, 1, c * 100);
        c = 0;
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task9_1", 7, i, "[ ");
            write(book, "task9_1", 7, i, massy[i]);
            writeString(book, "task9_1", 7, i, " ; ");
            write(book, "task9_1", 7, i, massy[i + 1]);
            writeString(book, "task9_1", 7, i, " ]");
            writeIntoExcel(book, "task9_1", 8, i, read(book, "task1", 9, i));
            writeIntoExcel(book, "task9_1", 9, i, read(book, "task8_1", 10, i));
            writeIntoExcel(book, "task9_1", 10, i, read(book, "task1", 9, i) - read(book, "task8_1", 10, i));
            writeIntoExcel(book, "task9_1", 11, i, (Math.pow((read(book, "task1", 9, i) - read(book, "task8_1", 10, i)), 2)) / read(book, "task8_1", 10, i));
            c = c + (Math.pow(read(book, "task1", 9, i) - read(book, "task8_1", 10, i), 2)) / read(book, "task8_1", 10, i);
        }
        writeIntoExcel(book, "task9_1", 12, 0, c);
        writeIntoExcel(book, "task9_1", 12, 1, c * 100);
        book.write(new FileOutputStream("file.xlsx"));
        book.close();
    }

    public static void task10_1() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        //createExcel(book, "task10_1", 30);
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        hity = hits(y, massy);
        double c = 0;
        for (int i = 1; i < 10; i++) {
            writeIntoExcel(book, "task10_1", 1, i, massx[i - 1]);
            if (i != 9) {
                writeIntoExcel(book, "task10_1", 3, i, hitx[i - 1]);
                writeIntoExcel(book, "task10_1", 4, i, hitx[i - 1] / 100);
                writeIntoExcel(book, "task10_1", 5, i, c);
                c = c + hitx[i - 1] / 100;
            }
        }
        c = 0;
        for (int i = 1; i < 10; i++) {
            writeIntoExcel(book, "task10_1", 11, i, massy[i - 1]);
            if (i != 9) {
                writeIntoExcel(book, "task10_1", 13, i, hity[i - 1]);
                writeIntoExcel(book, "task10_1", 14, i, hity[i - 1] / 100);
                writeIntoExcel(book, "task10_1", 15, i, c);
                c = c + hity[i - 1] / 100;
            }
        }
        book.write(new FileOutputStream("file.xlsx"));
        book.close();
    }

    public static void task10_2() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        //createExcel(book,"task10_1",30);
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        hity = hits(y, massy);
        double c = 0;
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task10_1", 0, i, "[ ");
            write(book, "task10_1", 0, i, massx[i]);
            writeString(book, "task10_1", 0, i, " ; ");
            write(book, "task10_1", 0, i, massx[i + 1]);
            writeString(book, "task10_1", 0, i, " ]");
            writeIntoExcel(book, "task10_1", 1, i, read(book, "task2", 2, i));
            writeIntoExcel(book, "task10_1", 2, i, 1 - (Math.exp(-read(book, "task2", 2, i) * (1 / read(book, "task2", 0, 9)))));
            writeIntoExcel(book, "task10_1", 3, i, read(book, "task2", 1, i));
            writeIntoExcel(book, "task10_1", 2, i + 10, Math.abs(frequency(x, read(book, "task2", 2, i)) - c));
            c = c + read(book, "task2", 1, i);
            writeIntoExcel(book, "task10_1", 4, i, c);
            writeIntoExcel(book, "task10_1", 0, i + 10, 1 - (Math.exp(-read(book, "task2", 2, i) * (1 / read(book, "task2", 0, 9)))));
            writeIntoExcel(book, "task10_1", 1, i + 10, c);
            writeIntoExcel(book, "task10_1", 3, i + 10, Math.abs(c - frequency(x, read(book, "task2", 2, i))));
        }
        c = 0;
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task10_1", 7, i, "[ ");
            write(book, "task10_1", 7, i, massy[i]);
            writeString(book, "task10_1", 7, i, " ; ");
            write(book, "task10_1", 7, i, massy[i + 1]);
            writeString(book, "task10_1", 7, i, " ]");
            writeIntoExcel(book, "task10_1", 8, i, read(book, "task2", 7, i));
            writeIntoExcel(book, "task10_1", 9, i, 1 - Math.exp((-read(book, "task2", 7, i)) * (1 / read(book, "task2", 1, 9))));
            writeIntoExcel(book, "task10_1", 10, i, read(book, "task2", 6, i));
            writeIntoExcel(book, "task10_1", 9, i + 10, Math.abs(frequency(y, read(book, "task2", 7, i)) - c));
            c = c + read(book, "task2", 6, i);
            writeIntoExcel(book, "task10_1", 11, i, c);
            writeIntoExcel(book, "task10_1", 7, i + 10, 1 - Math.exp((-read(book, "task2", 7, i)) * (1 / read(book, "task2", 1, 9))));
            writeIntoExcel(book, "task10_1", 8, i + 10, c);
            writeIntoExcel(book, "task10_1", 10, i + 10, Math.abs(c - frequency(y, read(book, "task2", 7, i))));
        }
        book.write(new FileOutputStream("file.xlsx"));
        book.close();
    }

    public static void task11_1() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        //createExcel(book,"task11_1",30);
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        writeIntoExcel(book, "task11_1", 0, 1, read(book, "task1", 0, 4));
        writeIntoExcel(book, "task11_1", 0, 2, read(book, "task1", 1, 4));
        writeIntoExcel(book, "task11_1", 0, 4, read(book, "task3", 10, 0));
        writeIntoExcel(book, "task11_1", 0, 5, read(book, "task3", 12, 0));
        writeIntoExcel(book, "task11_1", 0, 7, read(book, "task3", 11, 0));
        writeIntoExcel(book, "task11_1", 0, 8, read(book, "task3", 13, 0));
        double k = 0;
        writeIntoExcel(book, "task11_1", 2, 1, COR(x, y));
        k = cor(COR(x, y), read(book, "task3", 11, 0), read(book, "task3", 13, 0));
        writeIntoExcel(book, "task11_1", 2, 2, k);
        writeIntoExcel(book, "task11_1", 2, 3, ttt(k));
        book.write(new FileOutputStream("file.xlsx"));
        book.close();
    }

    public static void task12_1() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        //createExcel(book, "task12_1", 30);
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        hity = hits(y, massy);
        writeIntoExcel(book, "task12_1", 0, 1, read(book, "task1", 0, 4));
        writeIntoExcel(book, "task12_1", 4, 1, read(book, "task1", 1, 4));
        writeIntoExcel(book, "task12_1", 0, 3, read(book, "task3", 11, 0));
        writeIntoExcel(book, "task12_1", 1, 3, read(book, "task3", 13, 0));
        writeIntoExcel(book, "task12_1", 5, 3, read(book, "task3", 11, 0));
        writeIntoExcel(book, "task12_1", 4, 3, read(book, "task3", 13, 0));
        writeIntoExcel(book, "task12_1", 4, 5, read(book, "task1", 0, 4));
        writeIntoExcel(book, "task12_1", 0, 5, read(book, "task1", 1, 4));
        writeIntoExcel(book, "task12_1", 0, 2, read(book, "task11_1", 2, 2));
        writeIntoExcel(book, "task12_1", 4, 2, read(book, "task11_1", 2, 2));
        book.write(new FileOutputStream("file.xlsx"));
        book.close();
    }

    public static void task13_1() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        //createExcel(book, "task13_1", 120);
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        double[] xsort = new double[100];
        double[] ysort = new double[100];
        double[] xlinked = new double[100];
        double[] ylinked = new double[100];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        hity = hits(y, massy);
        xsort = sort(x);
        ysort = sort(y);
        xlinked = sortmass(x, y);
        ylinked = sortmass(y, x);
        double[] xx = new double[8];
        double[] yy = new double[8];
        xx = xuita(xlinked, hitx);
        yy = xuita(ylinked, hity);
        for (int i = 0; i < 100; i++) {
            writeIntoExcel(book, "task13_1", i, 20, xsort[i]);
            writeIntoExcel(book, "task13_1", i, 21, xlinked[i]);
            writeIntoExcel(book, "task13_1", i, 23, ysort[i]);
            writeIntoExcel(book, "task13_1", i, 24, ylinked[i]);
        }
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task13_1", 0, i + 1, "[ ");
            write(book, "task13_1", 0, i + 1, massx[i]);
            writeString(book, "task13_1", 0, i + 1, " ; ");
            write(book, "task13_1", 0, i + 1, massx[i + 1]);
            writeString(book, "task13_1", 0, i + 1, " ]");
            writeIntoExcel(book, "task13_1", 1, i + 1, read(book, "task2", 2, i));
            writeIntoExcel(book, "task13_1", 2, i + 1, xx[i]);
        }
        for (int i = 0; i < 8; i++) {
            writeIntoExcelString(book, "task13_1", 7, i + 1, "[ ");
            write(book, "task13_1", 7, i + 1, massy[i]);
            writeString(book, "task13_1", 7, i + 1, " ; ");
            write(book, "task13_1", 7, i + 1, massy[i + 1]);
            writeString(book, "task13_1", 7, i + 1, " ]");
            writeIntoExcel(book, "task13_1", 8, i + 1, read(book, "task2", 7, i));
            writeIntoExcel(book, "task13_1", 9, i + 1, yy[i]);
        }
        book.write(new FileOutputStream("file.xlsx"));
        book.close();
    }

    public static void task14_1() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("file.xlsx"));
        //createExcel(book, "task14_1", 30);
        double[] x = new double[100];
        double[] y = new double[100];
        x = readFromExcelVarX("file.xlsx");
        y = readFromExcelVarY("file.xlsx");
        double[] massx = new double[9];
        double[] massy = new double[9];
        double[] hitx = new double[8];
        double[] hity = new double[8];
        massx = inter(x);
        massy = inter(y);
        hitx = hits(x, massx);
        double[] xlinked = new double[100];
        double[] ylinked = new double[100];
        hity = hits(y, massy);
        xlinked = sortmass(x, y);
        ylinked = sortmass(y, x);
        double[] xx = new double[8];
        double[] yy = new double[8];
        xx = xuita(xlinked, hitx);
        yy = xuita(ylinked, hity);
        writeIntoExcel(book, "task14_1", 1, 1, si2(averageArg(y), hitx, xx));
        writeIntoExcel(book, "task14_1", 1, 2, SI2(averageArg(y), y));
        writeIntoExcel(book, "task14_1", 3, 1, si2(averageArg(x), hity, yy));
        writeIntoExcel(book, "task14_1", 3, 2, SI2(averageArg(x), x));
        book.write(new FileOutputStream("file.xlsx"));
        book.close();
    }

}
