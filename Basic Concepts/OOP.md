# Object-Oriented Programming
Programação orientada a objetos é um modelo que resolve o conceito dos objetos.

## 4 Conceitos da OOP
![concepts-oop](https://codingnomads.co/wp-content/uploads/2020/12/OOP-graphic-blog-oop-concepts-in-java-what-is-object-oriented-programming.png)

### Abstração
A abstração é um processo de separar ideias de instâncias específicas, desenvolvendo classes em termos de sua funcionalidade em vez de implementar detalhes. A técnica de abstração visa separar os detalhes de implementação de uma classe de seu comportamento.

### Encapsulamento
Encapsular os dados de uma aplicação significa evitar que eles sofram acessos indevidos. Para isso, é criada uma estrutura que contém métodos que podem ser utilizados por qualquer outra classe, sem causar inconsistências no desenvolvimento de um código.

### Polimorfismo
O principal conceito do polimorfismo é a propriedade de duas ou mais classes derivadas de uma mesma superclasse responderem à mesma mensagem, cada uma de uma forma diferente. Isso ocorre quando uma subclasse redefine um método existente na superclasse, ou seja, quando temos os métodos sobrescritos (overriding).

### Herança
A herança dá ao objeto a habilidade de ter acesso aos campos de métodos de outra classe. Ela provê a reutilização de código e pode ser usada para adicionar novas funcionalidades a uma classe já existente sem precisar modificá-la.

## Modificadores de acesso

- **Public**: o código pode ser acessado de qualquer lugar e por qualquer entidade que possa visualizar a classe.
- **Private**: o código só é acessível quando declarado.
- **Protected**: acessível apenas para classes do mesmo pacote ou através de herança.
- **Default**: acessível apenas para o mesmo pacote.
- **Final**: a classe não pode ser herdada por outra classe.
- **Abstract**: a classe não pode ser usada para criar objetos.

## Override vs Overload

#### Override
Ocorre quando dois métodos possuem o mesmo nome e parâmetros. Um dos métodos é a classe "pai" e a outra é a classe "filho". O _override_ permite que a classe "filho" implemente outro tipo específico de método que já está presente na classe "pai".

#### Overloading
Ocorre quando dois ou mais métodos em uma classe têm o mesmo nome, mas parâmetros diferentes.

| Overloading                                                                                 | Overriding                                                                          |
|---------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| Precisa ter pelo menos dois métodos com o mesmo nome na classe.                              | Precisa ter pelo menos um método com o mesmo nome em ambas as classes (pai e filha). |
| Precisa ter um número diferente de parâmetros.                                               | Precisa ter os mesmos números de parâmetros.                                          |
| Se o número de parâmetros for o mesmo, então os tipos de parâmetros precisam ser diferentes. | Precisa ter os mesmos tipos de parâmetros.                                           |
| Mais conhecido como _compile-time_ polimorfismo.                                             | Mais conhecido como _runtime_ polimorfismo.                                          |

![overridevsoverload](https://www.educative.io/api/edpresso/shot/5486484477968384/image/5514672927145984)

## Abstract vs Interface

| Interface                                                              | Abstrata                                                         |
|------------------------------------------------------------------------|------------------------------------------------------------------|
| Em uma interface, só podem haver métodos abstratos                     | Pode ter métodos abstratos ou não-abstratos                      |
| Variáveis declaradas em uma interface Java são, por padrão, final      | Pode conter ou não variáveis non-final                           |
| Possui apenas variáveis static e final                                 | Possui variáveis final, non-final, static e non-static           |
| Uma interface não pode fornecer a implementação de uma classe abstrata | A classe abstrata pode fornecer a implementação de uma interface |
| Pode ser implementada usando a keyword "implements"                    | Pode ser herdada usando a keyword "extends"                      |
| Uma interface suporta múltiplas heranças                               | Uma classe abstrata não suporta múltiplas heranças               |
| Os "Data Members" de uma interface são públicos por padrão             | Em uma classe abstrata, pode haver private, protected, etc.      |

![abstract-vs-interface](https://media.geeksforgeeks.org/wp-content/uploads/Abstract-Class-vs-Interface.png)

## SOLID
São os cinco princípios da programação orientada a objetos que facilitam o desenvolvimento de softwares, tornando-os fáceis de manter e entender.

### Single-Responsibility Principle
Esse princípio declara que uma classe deve ser especializada em um único assunto e possuir apenas uma responsabilidade dentro do software, ou seja, a classe deve ter uma única tarefa ou ação para executar. Exemplo:

```java
public class Order {
	public int calculateTotalSum(){/*...*/};
	public void getItems(){/*...*/};
	public void addItem(){/*...*/};
}

public class OrderRepository {
	public void load(){/*...*/};
	public void save(){/*...*/};
	public void update(){/*...*/};
}

public class OrderViewer {
	public void printOrder(){/*...*/};
	public void showOrder(){/*...*/};
}
```

#### Sua violação gera alguns problemas
-   Falta de coerência - uma classe não deve assumir responsabilidades que não são suas.
-   Alto acoplamento - Mais responsabilidades geram um maior nível de dependências, deixando o sistema rígido e frágil para alterações.
-   Dificuldades na implementação de testes automatizados - É difícil "mockar" esse tipo de classe.
-   Dificuldades para reaproveitar o código.

### Open-Closed Principle
Objetos ou entidades devem estar abertos para extensão, mas fechados para modificação, ou seja, quando novos comportamentos e recursos precisam ser adicionados no software, devemos estender e não alterar o código fonte original. Exemplo:

```java
public interface Remuneravel {
	public void remuneracao();
}

public class ContratoClt implements Remuneravel{
	public void remuneracao(){/*...*/};
}

public class Estagio implements Remuneravel{
	public void remuneracao(){/*...*/};
}

public class FolhaDePagamento {
	protected saldo;

	public void calcular(funcionario){/*...*/};
}
```

### Liskov Substitution Principle
Este princípio diz que as classes derivadas devem ser substituíveis por suas classes base sem causar qualquer tipo de problema ou falha. Em outras palavras, se uma classe filha herda de uma classe pai, ela deve manter o mesmo comportamento que a classe pai e ser compatível com seus métodos e propriedades. Isso torna o código mais flexível e facilita a manutenção e o reuso.

### Interface Segregation Principle
Uma classe não deve ser forçada a implementar interfaces e métodos que não irão utilizar. Basicamente, diz que é melhor criar interfaces mais específicas, ao invés de termos uma única interface genérica. Exemplo:

```java
public interface Aves {
	public void setLocalizacao(){/*...*/};
	public void renderizar(){/*...*/};
}

public interface AvesQueVoam extends Aves{
	public void setAltitude(){/*...*/};
}

public class Papagaio implements AvesQueVoam{
	public void setLocalizacao(){/*...*/};
	public void setAltitude(){/*...*/};
	public void renderizar(){/*...*/};
}

public class Papagaio implements Aves{
	public void setLocalizacao(){/*...*/};
	public void renderizar(){/*...*/};
}
```

### Dependency Inversion Principle
Dependa de abstrações e não de implementações. De acordo com _Uncle Bob_, esse princípio pode ser definido da seguinte forma:

	"Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender da abstração."

	"Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações."

Um exemplo seria a conexão com um banco de dados, onde aplicamos um conceito de: “Programe para uma interface e não para uma implementação.”

```java
public interface DBConnectionInterface{
	public void connect();
}

class MySQLConnection implements DBConnectionInterface{
	public void connect(){/*...*/};
}

class OracleConnection implements DBConnectionInterface{
	public void connect(){/*...*/};
}

class PasswordReminder{
	private dbConnection;

	public void connect(DBConnectionInterface dbConnection){/*...*/};
}
```
