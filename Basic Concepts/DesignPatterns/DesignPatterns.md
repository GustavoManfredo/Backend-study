# Design Patterns
Design Pattern (Padrão de Projeto, em tradução livre) é uma solução bem definida e comprovada para um problema de design comum em uma determinada contexto. Em outras palavras, é uma técnica de projeto de software que foi identificada como útil em diversas situações e que pode ser reutilizada para resolver problemas semelhantes.

Existem vários tipos de Design Patterns, como os padrões de criação, estruturais e comportamentais. Cada um deles é adequado para resolver problemas específicos de design de software. 

- Padrões de criação: esses padrões abordam a forma de criar objetos de forma a ocultar a complexidade da criação de objetos de uma classe de usuário. Alguns exemplos de padrões de criação são o Factory Method, o Prototype e o Singleton.

- Padrões estruturais: esses padrões abordam a forma de compor objetos para formar estruturas mais complexas. Alguns exemplos de padrões estruturais são o Adapter e o Facade.

- Padrões comportamentais: esses padrões abordam a forma de comunicar entre objetos de forma a diminuir a dependência entre eles. Alguns exemplos de padrões comportamentais são o Iterator e o Strategy.

## Singleton
O design pattern Singleton é um padrão de projeto de software que garante que uma classe tenha apenas uma instância e forneça um ponto global de acesso a essa instância. Ele é útil quando precisamos garantir que uma classe tenha apenas uma instância e essa instância esteja disponível para todos os clientes.

## Prototype
O design pattern Prototype é um padrão de projeto de software que permite criar novas instâncias de objetos a partir de objetos existentes, sem precisar conhecer os detalhes de sua implementação. Ele é útil quando precisamos criar muitas instâncias de um objeto e não queremos ter que escrever o código de criação de cada uma delas.

## Factory Method
O design pattern Factory é um padrão de projeto de criação que define uma interface para criar um objeto, mas deixa as subclasses decidirem qual classe deve ser instanciada. Isso permite que uma classe adie a instanciação de objetos para subclasses.

## Facade
O design pattern Facade é um padrão de projeto de software que fornece uma interface simplificada para um conjunto de classes complexas. Ele cria uma classe chamada "facade" que fornece uma interface única para todas as funcionalidades dessas classes. Isso permite que os clientes trabalhem com essas funcionalidades de forma mais simples e intuitiva, sem precisar conhecer todos os detalhes da implementação dessas classes.

## Adapter
O design pattern Adapter é um padrão de projeto de software que permite que duas interfaces incompatíveis trabalhem juntas. Ele cria uma classe intermediária, chamada de "adaptador", que converte a interface de uma classe para a interface esperada pelo cliente. Dessa forma, o cliente pode trabalhar com a classe original sem precisar conhecer sua interface real.

## Iterator
O design pattern Iterator é um padrão de projeto de comportamento que permite que você acesse os elementos de uma coleção de forma sequencial, sem expor sua representação subjacente. Isso permite que você crie diferentes implementações de iteradores para diferentes tipos de coleções, de forma independente das classes de coleção.

```java
Iterator<String> iterator = arrayList.iterator();
```
[Iterator Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html)

## Strategy
O design pattern Strategy é um padrão de projeto de comportamento que permite que você altere o comportamento de uma classe de acordo com o contexto em que ela está sendo usada. Isso é feito criando diferentes algoritmos que podem ser facilmente trocados entre si.
