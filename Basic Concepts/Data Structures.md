Data Structures ou estrutura de dados, é um estudo sobre a forma como os dados serão agregados, organizados, processados, levando-se em consideração, por exemplo, a eficiência para buscas, o volume dos dados trabalhados, a complexidade da implementação e a forma como os dados se relacionam.

# Array

Um array é uma estrutura de dados mais simples que existe, ele armazena uma sequência de objetos, todos do mesmo tipo, em posições consecutivas da memória RAM. Essa estrutura permite acesso aleatório a qualquer elemento do vetor, sem precisar passar pelos elementos anteriores.

![img-al](https://cdn.programiz.com/sites/tutorial2program/files/initialize-array-during-declaration-java.jpg "Array")

## Usos

- Armazenar e acessar informações sequenciais
- Armazenar objetos temporarios
- Buffers de rotinas IO
- Retornar diversos valores de uma função
- Usado em programação dinamica para armazenar em cache resposta para subproblemas

## Complexidade BigO
 
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

Uma *LinkedList* é uma estrutura de dados linear que inclui diversas series de *nodes*(nó) e que em cada *node* é armazenado a informação e um *pointer*(ponteiro) para a proximo *node*, sendo o primeiro *node* a *head* e o ultimo o *tail* que sempre tera um *pointer* para o valor *null*.

![img-ll](https://cdn.programiz.com/sites/tutorial2program/files/linked-list-concept.png "Linked List Concept")

## Memory

Sua alocação de memoria varia de acordo com sua nescessidade, ja que as lintas encadeadas so pegam o que realmente elas precisam.

## Singly vs Doubly Linked Lists

Singly LinkedList (Lista encadeada), guarda apenas a referencia( *pointer* ) do proximo *node*, Em uma implementação sempre referenciamos do *head* para o *tail* de forma para remover/adicionar de forma rapida e eficiente.

Doubly LinkedList (Lista Duplamente Encadeada), cada *node* referencia( *pointer* ) o anterior e o proximo *node*, Implementando esta lista, sempre iremos referencia( *pointer* ) o *head* e o *tail* para remover/adicionar de forma rapida e eficiente.

## Usos

- Usados em diversas implementações de List, Queue & Stack .
- Otimas para criação de listas circulares.
- Usado para separar em cadeamento, que esta presente em algumas implementações de hashtable que lida com colisões.

## Pros & Cons

|               | **Pros**                                    | **Cons**                                        |
|---------------|-----------------------------------------|---------------------------------------------|
| Singly Linked | Usa menos memoria, Facil de implementar  | Dificuldade de acessar elementos anteriores |
| Doubly Linked | Pode ser percorrido de qualquer direção | Usa 2x a memoria que uma Singly             |

## Complexidade BigO

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

É uma estrutura de dados linear baseada em *LIFO* (Last in - First out) com apenas um fim, bem parecido com uma pilha de documentos da vida real. E tem duas operações primarias que é *push*(inserir) e *pop*(deletar) que são executadas no Top of the stack(Topo da pilha).
![img-stack-ds](https://static.javatpoint.com/core/images/java-stack.png "Representação de um stack")
### Usos

- Usado em editores de texto para reverter algo(*undo*).
- Usado para dar suporte a recursão, para armazenar chamadas anteriores de função
- Usado na syntax do compilador para checar brackets e braces.

### Complexidade O

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

É uma estrutura de dados linear baseada em *FIFO* (First in - First out), que remete a um modelo de fila do mundo real. Tendo como duas operações primarias *enqueue*(inserir) e *dequeue*(remover)

![img-queues](https://images.velog.io/images/iacid123/post/c9254e9d-1d58-4263-8d70-38cfc6284223/Queue.png "Representação Queue")

### Usos

- Gerenciamento de uma requisição web service onde deseja aplicar o *FIFO*
- Para qualquer aplicação de espera em fila

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
|  Stacks | Facil para iniciantes / Permite controlar a quantidade de memoria alocada / Bem mais simples que Queues | Quase não flexivel ou escalavel / Ter acesso aleatorios ao elementos é quase impossivel   |
|  Queues | São flexiveis / São rapidos e otimizados / Podem manusear multiplos tipos de dados                      | Inserir e remover elementos do meio da fila é complexo / Não é possivel pesquisar na fila |

## Queue vs Stack

- Stacks são baseadas em *LIFO* (Last in - First out), sendo assim inserções e remoções são feitas do *top* da stack. Ja em Queues são baseadas em *FIFO* (First in - First out) e suas inserções é realizada no final da Queue e sua remoção é feita no começo da Queue.
- Em uma Stack possuimos apenas um *pointer* que chamamos de *top* e ele apenas aponta para o ultimo elemento da lista. Em Queues possuimos dois *pointers* um deles é chamado de *front* onde sempre aponta para o primeiro elemento inserido na lista e o segundo tem o nome de *rear* que sempre apontará para o ultimo elemento inserido na lista.
- Queue possui diversos tipos de estruturas sendo elas a *Circular Queue*, *Priority Queue* e *Double-Ended Queue*. Diferente da Stack que não possui nenhum tipo.

A relação entre *recursion* e *Stack* é que para que ocorra a recurssão é nescessario que a ultima função precise ser completada e quando completada a função armazena a solução da mesma em uma stack e assim em diante ate ser concluido.

![stack-recursion](https://i.imgur.com/GdK7v1S.jpg)

----

# Hash Tables

É uma estrutura de dados que é usada para armazenar pares de *keys*/valores