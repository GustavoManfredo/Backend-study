# Object-Oriented Programming
Programação orientada a objetos é um modelo que resolve o conceito dos objetos. 

## 4 Conceitos da OOP
![concepts-oop](https://codingnomads.co/wp-content/uploads/2020/12/OOP-graphic-blog-oop-concepts-in-java-what-is-object-oriented-programming.png)

### Abstração
É um processo de separar ideas de instancias especificas, desenvolver classes no termo de sua funcionalidade ao inves de implementar detalhes. A técnica de abstração visa separar os detalhes de implementação de uma classe de seu comportamento

### Encapsulamento
Encapsular os dados de uma aplicação significa evitar que estes sofram acessos indevidos. Para isso, é criada uma estrutura que contém métodos que podem ser utilizados por qualquer outra classe, sem causar inconsistências no desenvolvimento de um código.

### Polimorfismo
O principal conceito é a propriedade de duas ou mais classes derivadas de uma mesma superclasse responderem a mesma mensagem, cada uma de uma forma diferente. Ocorre quando uma subclasse redefine um método existente na superclasse, ou seja, quando temos os métodos sobrescritos (overriding)

### Herança
Da ao objeto a habilidade de ter acesso ao campos de metodos de uma outra classe, Herança providencia a reutilização de codigo e pode ser usado para features adicionais para uma classe ja existente sem precisar modifica-la.

## Modificadores de acesso

- **Public**, o código pode ser acessado de qualquer lugar e por qualquer entidade que possa visualizar a classe.
- **Private**, o código so é acessivel quando declarado
- **Protected**, acessível apenas paras classes do mesmo pacote ou através de herança.
- **Default**, acessível apenas para o mesmo pacote.
- **Final**, a classe não pode ser herdada por outra classe.
- **Abstract**, a classe não pode ser usada para criar objetos.

## Override vs Overload

#### Override
Ocorre quando dois metodos, possuem o mesmo nome e parametros. Um dos metodos é a classe "pai" e a outra é a classe "filho". *Overriding* permite que a classe "filho" implemente outro tipo especifico de metodo que ja está presente na classe "pai".

#### Overloading
Ocorre quando dois ou mais metodos em uma classe tem o mesmo nome mas parametros diferentes.

| Overloading                                                                                 | Overriding                                                                          |
|---------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| Precisa ter pelo menos dois metodos com o mesmo nome na classe                              | Precisa ter pelo menos um metodo com o mesmo nome em ambas as classes (pai e filha) |
| Precisa ter um numero diferente de parametros                                               | Precisa ter os mesmo numeros de parametros                                          |
| Se o numero de parametros for o mesmo, então os tipos de parametros precisam ser diferentes | Precisa ter os mesmos tipos de parametros                                           |
| Mais conhecido como *compile-time* polimorfismo                                             | Mais conhecido como *runtime* polimorfismo                                          |

![overridevsoverload](https://www.educative.io/api/edpresso/shot/5486484477968384/image/5514672927145984)

## Abstract vs Interface

| Interface                                                              | Abstrata                                                         |
|------------------------------------------------------------------------|------------------------------------------------------------------|
| Em uma interface apenas pode ter metodos abstratos                     | Pode ter metodos abstratos ou não-abstratos                      |
| Variaveis declaradas em uma interface java são por padrão *final*      | Pode conter ou não variaveis *non-final*                         |
| Possui apenas variaveis *static* e *final*                             | Possui variaveis *final*, *non-final*, *static* e *non-static*.  |
| Uma interface não pode fornecer a implementação de uma classe abstrata | A classe abstrata pode fornecer a implementação de uma interface |
| Pode ser implementada usando a *keyword* "*implements*"                | Pode ser herdada usando a *keyword* "*extends*"                  |
| Uma interface suporta multiplas heranças                               | Uma classe abstrata não suporta multiplas heranças               |
| Os "*Data Members*" de uma interface são publicos por padrão           | Em uma classe abstrata pode haver private, protected, etc.       |

![abstract-vs-interface](https://media.geeksforgeeks.org/wp-content/uploads/Abstract-Class-vs-Interface.png)

## SOLID
São os cinco princípios da programação orientada a objetos que facilitam no desenvolvimento de softwares, tornando-os fáceis de manter e entender.

### Single-Responsibility Principle
Esse princípio declara que uma classe deve ser especializada em um único assunto e possuir apenas uma responsabilidade dentro do software, ou seja, a classe deve ter uma única tarefa ou ação para executar. Ex:

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
- Falta de coesão - uma classe não deve assumir responsabilidades que não são suas.
- Alto acoplamento - Mais responsabilidades geram um maior nível de dependências, deixando o sistema engessado e frágil para alterações.
- Dificuldades na implementação de testes automatizados - É difícil de "mockar" esse tipo de classe.
- Dificuldades para reaproveitar o código.

### Open-Closed Principle
Objetos ou entidades devem estar abertos para extensão, mas fechados para modificação, ou seja, quando novos comportamentos e recursos precisam ser adicionados no software, devemos estender e não alterar o código fonte original. Ex:

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
Uma classe derivada deve ser substituível por sua classe base. Um exemplo de facil compreensão:

"se S é um subtipo de T, então os objetos do tipo T, em um programa, podem ser substituídos pelos objetos de tipo S sem que seja necessário alterar as propriedades deste programa."

### Interface Segregation Principle
Uma classe não deve ser forçada a implementar interfaces e métodos que não irão utilizar. Basicamente diz que é melhor criar interfaces mais específicas ao invés de termos uma única interface genérica. Ex:

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
Dependa de abstrações e não de implementações. De acordo com *Uncle Bob*, esse princípio pode ser definido da seguinte forma:

	"Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender da abstração."

	"Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações."

Um exemplo seria a conexão com um banco de dados onde aplicamos um conceito de: “Programe para uma interface e não para uma implementação.”

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
