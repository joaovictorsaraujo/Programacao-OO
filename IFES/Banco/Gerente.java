package banco;

import java.util.Scanner;

/**
 *
 * @author 20241bsi0319
 */
public class Gerente extends Pessoa {

    private String mat;
    private String pass;

    public Gerente(){
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a matricula: ");
        this.mat = input.nextLine();

        this.pass = "senha123";
    }

    public Gerente(String n, Data d, char s, String c, String mat) {
        super(n, d, s, c);
        this.mat = mat;
        this.pass = "senha123";
    }

    public Gerente(String n, int d, int m, int a, char s, String c, String mat) {
        this(n, new Data(d, m, a), s, c, mat);
    }

    public boolean validarAcesso(String s) {
        if(s.equals(this.pass)){
            System.out.println("Acesso permitido");
            return true;
        }
        else{
            System.out.println("Senha incorreta, tente novamente!");
            return false;
        }
    }

    public boolean validarAcesso(){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        String senha = input.nextLine();

        return validarAcesso(senha);
    }

    public boolean alterarSenha(String atual, String nova){
        if (validarAcesso(atual)){
            System.out.println("Senha alterada com sucesso!");
            this.pass = nova;
            return true;
        }
        else{
            System.out.println("Senha incorreta, tente novamente!");
            return false;
        }
    }

    public boolean alterarSenha(String senha){
        if (validarAcesso(senha)){
            Scanner input = new Scanner(System.in);
            System.out.print("Digite a nova senha: ");
            alterarSenha(senha, input.nextLine());
            return true;
        }
        else{
            System.out.println("Senha incorreta, tente novamente!");
            return false;
        }
    }
}
