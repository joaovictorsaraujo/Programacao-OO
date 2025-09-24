package br.com.minhasmusicas.modelos;

import java.util.Scanner;

public class Podcast extends Audio{
    private People host;
    private String description;
    private People guest;

    public People getHost() {
        return host;
    }

    public void setHost(People host) {
        this.host = host;
    }

    public void setHost(){
        this.host = new People();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public People getGuest() {
        return guest;
    }

    public void setGuest(People guest) {
        this.guest = guest;
    }

    public void setGuest(){
        this.guest = new People();
    }

    @Override
    public int getClassification() {
        if (this.getTotalLikes() > (this.getTotalReproductions() / 2)){
            return 10;
        }
        else if (this.getTotalLikes() > (this.getTotalReproductions() / 3)){
            return 5;
        }
        else if (this.getTotalLikes() > (this.getTotalReproductions() / 4)){
            return 1;
        }
        else{
            return 0;
        }
    }
}




