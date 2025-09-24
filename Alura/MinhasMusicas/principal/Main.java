package br.com.minhasmusicas.principal;

import br.com.minhasmusicas.modelos.*;

public class Main {
    public static void main(String[] args) {
        Music myMusic = new Music();
        Artist linkinPark = new Artist("Linkin Park", new Data(01,1,1996), "NU Metal");
        myMusic.setTitle("Nobody´s Listen");

        System.out.print("A banda " + linkinPark.getName() + " surgiu em ");
        linkinPark.getBirthday();
        System.out.println(", tendo " + linkinPark.getAge(new Data(6, 9, 2025)) + " anos!");


        for (int i = 0; i < 1000; i++){
            myMusic.reproduction();
        }

        for (int i = 0; i < 900; i++){
            myMusic.like();
        }

        Podcast myPodcast = new Podcast();
        myPodcast.setTitle("PeeWeeCast");
        People myHost = new People("Miguel", new Data(21,8,1997));
        People myChest = new People("Rafa", new Data(21,8,1997));
        myPodcast.setHost(myHost);

        for  (int i = 0; i < 800; i++){
            myPodcast.reproduction();
        }

        for (int i = 0; i < 270; i++){
            myPodcast.like();
        }

        MyFavorites favorites = new MyFavorites();
        favorites.include(myMusic);
        favorites.include(myPodcast);
    }
}
