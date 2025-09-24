package br.com.minhasmusicas.modelos;

import java.util.Scanner;

public class People {
    private String name;
    private Data birthday;

    public People() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        this.name = input.nextLine();

        this.birthday = new Data();
    }

    public People(String name, Data birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge(Data today){
        int age = today.year - this.birthday.year;

        // se ainda não chegou o aniversário este ano
        if ((today.month < this.birthday.month) ||
                (today.month == this.birthday.month && today.day < this.birthday.day)){
            age--;
        }
        return age;
    }

    public void setBirthday() {
         this.birthday = new Data();
    }

    public void getBirthday() {
        this.birthday.printData();
    }
}
