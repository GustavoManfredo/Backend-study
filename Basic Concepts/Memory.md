# Memory

Em Java, o gerenciamento de memória (Processo de alocar e desalocar objetos) é feito de forma automatica. Java utiliza um tipo de processo chamado *Garbage Collection* que quando um programa é executado na *JVM (Java Virtual Machine)*, os objetos são criados no *heap*, que é uma parte da memoria dedicada ao programa. O *Garbage Collector* localiza esses objetos não utilizados e os exclui para liberar memória.

![Java-Memory](https://static.javatpoint.com/core/images/memory-management-in-java.png)

## Heap
O espaço *Java Heap* é usado pelo *JRE (Java Runtime Environment)* para alocar memoria dos objetos e classes *JRE*. Sempre que criamos um objeto, ele também é criado e alocado no *Heap Space*. O *Garbage Collection* roda na memoria *heap* para "limpar" a memoria de objetos que não possui mais referencia.

### Young Generations
Os objetos recém criados começam no *Young Generation*. O *Young Generation* é subdividido em um espaço *Eden*, onde todos os novos objetos se iniciam, e dois espaço chamados *Survivor*, onde os objetos são movidos do *Eden* depois de sobriviver a um ciclo do *Garbage Collection*.

### Old Generation
Objetos de longa duração são movidos da *Young Generation* para a *Old Generation*.

### Permanent Generation
Metadados como classes e métodos são armazenados na *Permanent Generation*. As classes que não estão mais em uso podem ser coletadas da *Permanent Generation*.

![heap-memory](https://img.mandic.com.br/blog/2017/05/Java-Garbage-Collection.png)

## Stack
Em Java, *Stack Memory* é usada para execução de uma *Thread*. Ele contem os valores de metodos especificos que fazem referencia aos objetos armazenados na *heap* e esses valores se chamam *short-lived*. *Stack memory* é uma estrutura *LIFO (Last-In-First-Out)*. Quando um metodo é chamado, um novo bloco é criado no *Stack* para armazenar valores primitivos-locais e referenciar outros objetos no metodo.

### Stack Overflow
Ocorre quando tenta-se alocar algo na *stack* e a mesma não possui espaço reservado disponivel. Pode haver casos se a linguagem prover mecanismos que permitam, haver *overflow*. Mas no geral execuções recursivas descontroladas causam um *Stack Overflow*.

## Stack vs Heap
- *Heap* é utilizado por toda a aplicação, ja o *Stack* é apenas utilizado pela *Thread* em execução
- Sempre quando um objeto é criado, ele é armazenado no *Heap*, o *Stack* apenas referencia o local deste objeto no *heap*.
- Objetos armazenados no *Heap* são acessiveis de escala global, enquanto no *stack* apenas a *thread* que esta executando pode acessar.
- Tamanho de memoria *Stack* é bem inferior em comparação com a memoria *heap*. Isso ocorre devido a simplicidade de alocação de memória(*LIFO*), porem a memoria *Stack* é muito superiror em relação a velocidade comparada com a memoria *Heap*
- O Gerenciamento de memoria no *stack* é feito apartir do *LIFO*, ja em *heap* é divido em diversas formas como *Young Generation*, Old-Generation etc.
- Em Java, quando a memoria *stack* esta cheia ocorre o erro `java.lang.StackOverFlowError` e quando a memoria *heap* esta cheia ocorre o erro `java.lang.OutOfMemoryError: Java Heap Space`

![stack-vs-heap](https://journaldev.nyc3.digitaloceanspaces.com/2014/08/Java-Heap-Stack-Memory.png)