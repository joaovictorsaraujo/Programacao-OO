package br.com.minhasmusicas.modelos;

import java.util.Scanner;

public class Data {
    int day, month, year;

    public Data(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    Data(){
        Scanner input = new Scanner(System.in);

        System.out.println("Informe a data:");
        System.out.print("Digite o dia: ");
        this.day = input.nextInt();

        System.out.print("Digite o mes: ");
        this.month = input.nextInt();

        System.out.print("Digite o ano: ");
        this.year = input.nextInt();
    }

    public void printData(){
        System.out.print(this.day + "/" + this.month + "/" + this.year);
    }
}
