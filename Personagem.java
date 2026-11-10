import java.util.Scanner;

public class Personagem {
    private String nome;
    private String classe;
    private int vidaMaxima;
    private int vidaAtual;
    private int nivel = 1;
    private int moedas = 100;
    private int escolha;




    public Personagem(String nome, int vidaMaxima) {
        this.nome = nome;
        this.classe = classe;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
    }

    public void apresentarPersonagem() {
        System.out.println("Nome: " + getNome());
        System.out.println("Classe: " + getClasse());
        System.out.println("Vida: " + getVidaAtual() + "/" + vidaMaxima);
        System.out.println("Nível:" + nivel);
        System.out.println("Moedas:" + moedas);
    }

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return getClass().getSimpleName();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void tomarDano() {
        this.vidaAtual = vidaAtual - 10;
        if (vidaAtual <= 0) {
            System.out.println("Voce morreu!");
        } else{
            System.out.println("Você tomou dano, sua vida é " + vidaAtual + "/" + vidaMaxima);
        }

    }

    public void recuperarVida() {
        this.vidaAtual = vidaAtual + 10;
        if (vidaAtual >= vidaMaxima) {
            System.out.println("Você está com a vida cheia");
            this.vidaAtual = vidaMaxima;
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void subirNivel() {
        this.nivel = nivel + 1;
        this.vidaMaxima = vidaMaxima + 100;
        this.vidaAtual = vidaAtual + 20;
    }

    public int getMoedas() {
        return moedas;
    }

    public void receberMoedas(int moedasRecebidas) {
        this.moedas = moedas + moedasRecebidas;
        System.out.println("Você recebeu " + moedasRecebidas + " moedas");
        System.out.println("Seu saldo atual é " + moedas + " moedas");
    }

    public void gastarMoedas(int quantidade) {
        if (quantidade <= moedas) {
            moedas = moedas - quantidade;
            System.out.println("Compra realizada com sucesso!");
            System.out.println("Saldo atual: " + moedas + " moedas.");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}