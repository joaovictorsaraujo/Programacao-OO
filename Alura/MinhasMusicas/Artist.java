package br.com.minhasmusicas.modelos;

import java.util.Scanner;

public class Artist extends People {
    private String genre;

    public Artist(String name, Data birthday, String genre) {
        super(name, birthday);
        this.genre = genre;
    }

    public Artist() {
        super();
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o genero musical: ");
        this.genre = input.nextLine();
    }
}
