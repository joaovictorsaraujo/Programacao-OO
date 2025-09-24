package banco;

import java.util.Scanner;

/**
 *
 * @author 20241bsi0319
 */
public class Data {
    private int dia, mes, ano;

    public Data(){
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o dia de nascimento: ");
        this.dia = input.nextInt();

        System.out.print("Digite o mes de nascimento: ");
        this.mes = input.nextInt();

        System.out.print("Digite o ano de nascimento: ");
        this.ano = input.nextInt();
    }

    public Data(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }
    
    public void imprimir(){
        System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
    }
    
    public boolean maior(Data d2){
        if (this.ano > d2.ano) {
            return true;
        }
        if (this.ano < d2.ano) {
            return false;
        }
        if (this.mes > d2.mes) {
            return true;
        }
        if (this.mes < d2.mes) {
            return false;
        }
        return this.dia > d2.dia;
    }

    public int getDia() {
        return dia;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }
}
