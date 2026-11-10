public class Main {
    public static void main(String[] args) {
        Guerreiro guerreiro = new Guerreiro("Aragorn", 120, 20, 15);
        Mago mago = new Mago("Gandalf", 80, 100, 30);
        Arqueiro arqueiro = new Arqueiro("Legolas", 90, 20, 25);

        // Todos podem ser tratados como Personagem, pois herdam dessa classe.
        Personagem[] personagens = {guerreiro, mago, arqueiro};
        System.out.println("=== INFORMAÇÕES INICIAIS ===");
        for (Personagem personagem : personagens) {
            personagem.apresentarPersonagem();
            System.out.println();
        }

        System.out.println("=== AÇÕES ESPECÍFICAS ===");
        guerreiro.golpear();
        mago.lancarMagia();
        arqueiro.atirar();

        System.out.println("\n=== ESGOTANDO A MANA ===");
        while (mago.getMana() >= 10) {
            mago.lancarMagia();
        }
        mago.lancarMagia(); // Demonstra que a tentativa sem mana é bloqueada.

        System.out.println("\n=== ESGOTANDO AS FLECHAS ===");
        while (arqueiro.getQuantidadeFlechas() > 0) {
            arqueiro.atirar();
        }
        arqueiro.atirar(); // Demonstra que a tentativa sem flechas é bloqueada.

        System.out.println("\n=== AÇÕES HERDADAS E ESTADO FINAL ===");
        for (Personagem personagem : personagens) {
            System.out.println("\nPersonagem: " + personagem.getNome());
            personagem.tomarDano();
            personagem.recuperarVida();
            personagem.receberMoedas(30);
            personagem.gastarMoedas(10);
            personagem.subirNivel();
            personagem.apresentarPersonagem();
        }
    }
}
