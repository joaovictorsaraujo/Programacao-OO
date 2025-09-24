package br.com.minhasmusicas.modelos;

import java.util.Scanner;

public class Audio {
    private String title;
    private int durationMinutes;
    private int totalReproductions;
    private int totalLikes;
    private int classification;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitle(){
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o titulo: ");
        this.title = input.nextLine();
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public int getTotalReproductions() {
        return totalReproductions;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getClassification() {
        return classification;
    }

    public void like(){
        this.totalLikes++;
    }

    public void reproduction(){
        this.totalReproductions++;
    }
}
