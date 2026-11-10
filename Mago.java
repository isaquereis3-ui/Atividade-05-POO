public class Mago extends Personagem {
    private int mana;
    private int poderMagico;

    public Mago(String nome, int vidaMaxima, int mana, int poderMagico) {
        super(nome, vidaMaxima);
        this.mana = mana;
        this.poderMagico = poderMagico;
    }

    public int getMana() {
        return mana;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void lancarMagia() {
        if (mana >= 10) {
            mana -= 10;
            System.out.println(getNome() + " lançou uma magia com poder " + poderMagico
                    + ". Mana restante: " + mana);
        } else {
            System.out.println(getNome() + " não possui mana suficiente! São necessários 10 pontos.");
        }
    }

    @Override
    public void apresentarPersonagem() {
        super.apresentarPersonagem();
        System.out.println("Mana: " + mana);
        System.out.println("Poder mágico: " + poderMagico);
    }
}
