# Sistema de personagens de RPG

## Como executar

Extraia o ZIP e abra a pasta no IntelliJ ou no VS Code com suporte a Java. Execute o método main de Main.java.

Ou, com um JDK instalado, abra o terminal na pasta que contém os arquivos e execute:

```sh
javac -encoding UTF-8 *.java
java Main
```

## O que todos têm em comum?

Nome, vida máxima, vida atual, nível e moedas. Os métodos para tomar dano, recuperar vida, subir de nível, receber e gastar moedas ficam somente em Personagem.java.

## O que é específico?

| Classe | Atributos próprios | Ação |
| --- | --- | --- |
| Guerreiro | forca, armadura | golpear() |
| Mago | mana, poderMagico | lancarMagia() |
| Arqueiro | quantidadeFlechas, precisao | atirar() |

Guerreiro, Mago e Arqueiro **são personagens**. Essa relação é representada por herança, usando `extends Personagem`.

## Entendendo o construtor

```java
public Guerreiro(String nome, int vidaMaxima, int forca, int armadura) {
    super(nome, vidaMaxima);
    this.forca = forca;
    this.armadura = armadura;
}
```

`super(nome, vidaMaxima)` chama o construtor de Personagem e inicializa a parte comum do objeto. `this.forca = forca` guarda o parâmetro recebido no atributo do Guerreiro. Assim, não é necessário repetir nome e vida nas subclasses.

Os atributos continuam privados. As subclasses consultam o nome por `getNome()`, sem acessar diretamente o atributo da classe base.

## Exibindo informações

Cada subclasse sobrescreve `apresentarPersonagem()`, usando `@Override`. Dentro desse método, `super.apresentarPersonagem()` exibe as informações gerais. Depois, a subclasse exibe seus atributos específicos.

A Main guarda os três objetos em um vetor `Personagem[]`. Ao chamar `apresentarPersonagem()`, Java executa a versão correspondente ao tipo real de cada objeto. Isso é polimorfismo.

## Regras preservadas do projeto enviado

- Nível inicial: 1; moedas iniciais: 100; vida atual inicialmente igual à máxima.
- `tomarDano()`: retira 10 de vida e informa morte quando a vida é menor ou igual a zero.
- `recuperarVida()`: recupera 10, limitada à vida máxima.
- `subirNivel()`: aumenta o nível em 1, a vida máxima em 100 e a vida atual em 20.
- Receber moedas soma ao saldo; gastar moedas verifica se há saldo suficiente.

As regras anteriores foram mantidas, inclusive a possibilidade de vida negativa após dano excessivo e a ausência de validação de valores negativos nos métodos de moedas. Não foram criadas regras de combate adicionais: armadura não reduz dano e precisão não calcula chances de acerto, pois isso não foi solicitado.

## Adaptações em relação ao ZIP original

A classe original se chamava Character. Ela foi renomeada para Personagem, conforme o enunciado, e `apresentarCharacter()` passou a se chamar `apresentarPersonagem()`.

O atributo textual `classe`, seu setter e o menu `alterarNomeOuClasse` foram retirados: o tipo agora é definido pela classe Java criada. `getClasse()` retorna o nome dessa classe. `setNome()` continua disponível para renomear o personagem. O campo `escolha`, que não era utilizado, também foi retirado.

A Main interativa foi substituída pela demonstração dos seis passos da atividade, sem precisar digitar entradas. Usa exatamente os três personagens dos exemplos. Gandalf lança 10 magias e Legolas atira 20 flechas; uma tentativa extra de cada ação demonstra o bloqueio. Todos também tomam dano, recuperam vida, recebem e gastam moedas e sobem de nível.

## Verificação

As cinco classes foram compiladas e a Main foi executada em Java 21. Verificações adicionais confirmaram o consumo de mana (inclusive com 10 e 19 pontos iniciais), o bloqueio com mana insuficiente, o consumo da última flecha, o bloqueio sem flechas e as regras herdadas nos três tipos.
