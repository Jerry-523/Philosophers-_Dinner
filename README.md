# Problema dos Filósofos Jantando em Java

Este programa Java ilustra o clássico Problema dos Filósofos Jantando, um desafio de sincronização e concorrência. O problema consiste em um grupo finito de filósofos que passam seus tempos entre pensar e comer. Os filósofos compartilham uma mesa de jantar com um número limitado de garfos, e para comer, um filósofo deve pegar ambos os garfos adjacentes a eles.

## Implementação

O programa é desenvolvido em Java e faz uso de threads e locks para evitar deadlocks e garantir que cada filósofo só possa comer se ambos os garfos estiverem disponíveis.

### Classes

#### Garfos

A classe `Garfos` representa os garfos na mesa de jantar. Cada filósofo possui um garfo à esquerda e outro à direita. A classe utiliza locks para controlar o acesso aos garfos.

#### Filosofo

A classe `Filosofo` representa um filósofo. Cada filósofo é uma thread separada. A classe inclui métodos para pensar, comer e a lógica principal para o comportamento do filósofo. Ela utiliza locks da classe `Garfos` para garantir um acesso seguro aos garfos.

#### Filosofos

A classe `Filosofos` contém o programa principal, criando instâncias de `Garfos` e vários filósofos. Inicia threads individuais para cada filósofo para simular suas ações.

## Como Executar

Para executar o programa, chame o método `test` na classe `Filosofos`. Isso criará threads para cada filósofo e simulará suas ações.

```java
public static void main(String[] args) {
    new Filosofos().test();
}
```

## Modificações

Sinta-se à vontade para modificar o número de filósofos, ajustar as durações de espera ou experimentar com diferentes mecanismos de sincronização. A implementação atual visa evitar deadlocks e garantir um acesso justo aos garfos.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE.md).
