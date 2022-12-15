# Data Structures

Data Structures ou estruturas de dados é um estudo sobre a forma como os dados são agregados, organizados e processados, levando em consideração a eficiência para buscas, o volume de dados trabalhados, a complexidade da implementação e a forma como os dados se relacionam.

# Array

Um array é uma das estruturas de dados mais simples que existem. Ele armazena uma sequência de objetos, todos do mesmo tipo, em posições consecutivas na memória RAM. Essa estrutura permite acesso aleatório a qualquer elemento do vetor, sem precisar passar pelos elementos anteriores.

![img-al](https://cdn.programiz.com/sites/tutorial2program/files/initialize-array-during-declaration-java.jpg "Array")

## Usos

- Armazenar e acessar informações sequenciais
- Armazenar objetos temporários
- Buffers de rotinas de entrada/saída
- Retornar diversos valores de uma função
- Usado em programação dinâmica para armazenar em cache as respostas para subproblemas.

## Complexidade
 
|           | Static Array | Dynamic Array |
|-----------|--------------|---------------|
| Access    | O(1)         | O(1)          |
| Search    | O(n)         | O(n)          |
| Insertion | N/A          | O(n)          |
| Appending | N/A          | O(1)          |
| Deletion  | N/A          | O(n)          |

## Implementação

### Utilizando ArrayList
```java
ArrayList<dataType> name = new ArrayList<dataType>();
```
[ArrayList Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)

# LinkedList

Uma _LinkedList_ é uma estrutura de dados linear que inclui várias séries de _nodes_ (nós) e em cada _node_ é armazenada a informação e um _pointer_ (ponteiro) para o próximo _node_, sendo o primeiro _node_ a _head_ e o último o _tail_ que sempre terá um _pointer_ para o valor _null_.

![img-ll](https://cdn.programiz.com/sites/tutorial2program/files/linked-list-concept.png "Linked List Concept")

## Memory

A alocação de memória varia de acordo com a necessidade, já que as listas encadeadas só pegam o que realmente precisam.

## Singly vs Doubly Linked Lists

Singly LinkedList (lista encadeada simples) armazena apenas a referência (_pointer_) do próximo _node_, em uma implementação sempre referenciamos do _head_ para o _tail_ de forma a remover/adicionar de forma rápida e eficiente.

Doubly LinkedList (lista encadeada dupla) cada _node_ tem uma referência (_pointer_) para o anterior e o próximo _node_, implementando esta lista sempre referenciamos o _head_ e o _tail_ para remover/adicionar de forma rápida e eficiente.

## Usos

- Usados em diversas implementações de List, Queue & Stack.
- Ótimos para criação de listas circulares.
- Usado para cadeamento, que está presente em algumas implementações de hashtable que lidam com colisões.

## Pros & Cons

|               | **Pros**                                    | **Cons**                                        |
|---------------|-----------------------------------------|---------------------------------------------|
| Singly Linked | Usa menos memória, fácil de implementar  | Dificuldade de acessar elementos anteriores |
| Doubly Linked | Pode ser percorrido em qualquer direção | Usa 2x a memória que uma Singly LinkedList.             |

## Complexidade

|                  | Singly Linked | Doubly Linked |
|------------------|---------------|---------------|
| Search           | O(n)          | O(n)          |
| Insert at Head   | O(1)          | O(1)          |
| Insert at Tail   | O(1)          | O(1)          |
| Remove at head   | O(1)          | O(1)          |
| Remove at tail   | O(n)          | O(1)          |
| Remove in middle | O(n)          | O(n)          |

## Implementação

```java
LinkedList<dataType> list = new LinkedList<>();
```
[LinkedList Documentation](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html)

## Array vs LinkedList

![img-array-vs-linkedlist](https://media.geeksforgeeks.org/wp-content/uploads/20220525085238/Screenshot20220525085154.png)

---
# Queues & Stacks

## Stack

Uma pilha é uma estrutura de dados linear baseada em _LIFO_ (Last in - First out) com apenas um fim, bem parecida com uma pilha de documentos na vida real. E tem duas operações primárias que são _push_ (inserir) e _pop_ (deletar) que são executadas no topo da pilha.
![img-stack-ds](https://static.javatpoint.com/core/images/java-stack.png "Representação de um stack")
### Usos

- Usada em editores de texto para reverter algo (_undo_).
- Usada para dar suporte a recursão, para armazenar chamadas anteriores de função.
- Usada na sintaxe do compilador para checar colchetes e chaves.

### Complexidade

|           |      |
|-----------|------|
| Pushing   | O(1) |
| Popping   | O(1) |
| Peeking   | O(1) |
| Searching | O(n) |
| Size      | O(1) |

### Implementação
```java
Stack<dataType> stack = new Stack<>();
```
[Stack Documentation](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html)

## Queues

Uma fila é uma estrutura de dados linear baseada em _FIFO_ (First in - First out), que remete a um modelo de fila do mundo real. Tendo como duas operações primárias _enqueue_ (inserir) e _dequeue_ (remover).

![img-queues](https://images.velog.io/images/iacid123/post/c9254e9d-1d58-4263-8d70-38cfc6284223/Queue.png "Representação Queue")

### Usos

- Gerenciamento de uma requisição de web service onde deseja aplicar o _FIFO_.
- Para qualquer aplicação de espera em fila.

### Complexidade

|          |      |
|----------|------|
| Enqueue  | O(1) |
| Dequeue  | O(1) |
| Peeking  | O(1) |
| Contains | O(n) |
| Removal  | O(n) |
| isEmpty  | O(1) |

### Implementação

```java
Queue<dataType> queue = new LinkedList<>();
```
[Queue Documentation](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html)

## Pros & Cons

|         | Pros                                                                                                    | Cons                                                                                      |
|---------|---------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|
|  Stacks | Fácil para iniciantes / Permite controlar a quantidade de memória alocada / Bem mais simples que filas. | Quase não flexíveis ou escaláveis / Ter acesso aleatório aos elementos é quase impossível.   |
|  Queues | Flexíveis / Rápidas e otimizadas / Podem manipular múltiplos tipos de dados.                      | Inserir e remover elementos do meio da fila é complexo / Não é possível pesquisar na fila. |

## Queue vs Stack

- Stacks são baseadas em _LIFO_ (Last in - First out), sendo assim inserções e remoções são feitas do topo da stack. Já em filas são baseadas em _FIFO_ (First in - First out) e suas inserções são realizadas no final da fila e sua remoção é feita no começo da fila.
- Em uma Stack possuímos apenas um _pointer_ que chamamos de _top_ e ele apenas aponta para o último elemento da lista. Em filas possuímos dois _pointers_, um deles é chamado de _front_ e sempre aponta para o primeiro elemento inserido na lista, e o segundo tem o nome de _rear_ e sempre aponta para o último elemento inserido na lista.
- Filas possuem diversos tipos de estruturas, sendo elas _Circular Queue_, _Priority Queue_ e _Double-Ended Queue_. Diferente das Stacks que não possuem nenhum tipo.

A relação entre recursão e Stack é que para que ocorra a recursão é necessário que a última função precise ser completada e quando completada a função armazena a solução dela em uma stack e assim por diante até ser concluída.

![stack-recursion](https://i.imgur.com/GdK7v1S.jpg)

----

# Hash Tables

Uma tabela hash é uma estrutura de dados que é usada para armazenar coleções de _keys_ e valores, onde cada _key_ e valor possui um _hash code_ que é gerado através de uma _hash function_. Exemplo:

	F(key) = key % capacidade = hash code

Mas quando uma _hash_ é calculada e retorna o mesmo valor de outra _hash_ temos um problema chamado colisão e quando isso acontece os dois valores são armazenados no mesmo _bucket_ e uma resolução comum para isso seria transformar cada _bucket_ em uma _LinkedList_.

![hash](https://cdn.programiz.com/sites/tutorial2program/files/Hash-3_1.png)

## Usos

- Aplicações criptográficas
- Verificação de senhas
- Operações de compilador

## Complexidade


|                  |  HashTable No collisions |
|------------------|--------------------------|
| Searching        | O(1)                     |
| Insertion        | O(1)                     |
| Deletion         | O(1)                     |
| Space Complexity | O(n)                     |

|                  |  HashTable Collision with chaining |
|------------------|------------------------------------|
| Searching        | O(1)                               |
| Insertion        | O(1)                               |
| Deletion         | O(1)                               |
| Space Complexity | O(m + n)                           |

## Implementação

```java
Hashtable<Integer, String> table = new Hashtable<>();
```
[HashTable Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html)

## Pros & Cons

| Pros                                                                       | Cons                                                                       |
|----------------------------------------------------------------------------|----------------------------------------------------------------------------|
| A tabela hash é o melhor tipo de sincronização em relação a outras estruturas de dados.        | Torna-se ineficiente quando possui muitas colisões.                         |
| São mais eficientes do que _Search Trees_ ou outras estruturas de dados.      | É muito difícil evitar colisões quando possui um grande conjunto de _keys_. |
| Tem um tempo constante de operação em relação a inserir, buscar e deletar.  | Não é permitido valores nulos (_null_).                                     |
