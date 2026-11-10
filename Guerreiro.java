public class Guerreiro extends Personagem {
    private int forca;
    private int armadura;

    public Guerreiro(String nome, int vidaMaxima, int forca, int armadura) {
        super(nome, vidaMaxima); // Inicializa os atributos comuns em Personagem.
        this.forca = forca;
        this.armadura = armadura;
    }

    public int getForca() {
        return forca;
    }

    public int getArmadura() {
        return armadura;
    }

    public void golpear() {
        System.out.println(getNome() + " realizou um golpe com força " + forca + "!");
    }

    @Override
    public void apresentarPersonagem() {
        super.apresentarPersonagem(); // Reaproveita a exibição das informações comuns.
        System.out.println("Força: " + forca);
        System.out.println("Armadura: " + armadura);
    }
}
