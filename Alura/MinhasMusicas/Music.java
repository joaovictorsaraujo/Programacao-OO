package br.com.minhasmusicas.modelos;

import java.util.Scanner;

public class Music extends Audio{
    private String album;
    private Artist singer;
    private String genre;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setAlbum(){
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o album: ");
        this.album = input.nextLine();
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setGenre(){
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o genero: ");
        this.genre = input.nextLine();
    }

    public Artist getSinger() {
        return singer;
    }

    public void setSinger(Artist singer) {
        this.singer = singer;
    }

    public void setSinger(){
        this.singer = new Artist();
    }

    @Override
    public int getClassification() {
        if(this.getTotalReproductions() / this.getTotalLikes() <= 1){
            return 10;
        }
        else if(this.getTotalReproductions() / this.getTotalLikes() <= 5){
            return 5;
        }
        else if(this.getTotalReproductions() / this.getTotalLikes() <= 10){
            return 1;
        }
        else{
            return 0;
        }
    }
}
