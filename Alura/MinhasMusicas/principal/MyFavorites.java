package br.com.minhasmusicas.modelos;

public class MyFavorites {

    public void include(Audio audio){
        if (audio.getClassification() == 10){
            System.out.println("Todos estão ouvindo " + audio.getTitle() + " no momento!");
        }
        else if (audio.getClassification() == 5){
            System.out.println("Talvez voce curta " + audio.getTitle() + "!");
        }
        else {
            System.out.println("Adicione " + audio.getTitle() + " em sua playlist para ouvir mais tarde!");
        }
    }
}
