# Memory

Em Java, o gerenciamento de memória (processo de alocar e desalocar objetos) é feito de forma automática. Java utiliza um tipo de processo chamado _Garbage Collection_ que, quando um programa é executado na _JVM (Java Virtual Machine)_, os objetos são criados no _heap_, que é uma parte da memória dedicada ao programa. O _Garbage Collector_ localiza esses objetos não utilizados e os exclui para liberar memória.

![Java-Memory](https://static.javatpoint.com/core/images/memory-management-in-java.png)

## Heap
O espaço _Java Heap_ é usado pelo _JRE (Java Runtime Environment)_ para alocar memória dos objetos e classes _JRE_. Sempre que criamos um objeto, ele também é criado e alocado no _Heap Space_. O _Garbage Collector_ roda na memória _heap_ para "limpar" a memória de objetos que não possuem mais referência.

### Young Generations
Os objetos recém criados começam no _Young Generation_. O _Young Generation_ é subdividido em um espaço _Eden_, onde todos os novos objetos se iniciam, e dois espaços chamados _Survivor_, onde os objetos são movidos do _Eden_ depois de sobreviver a um ciclo do _Garbage Collection_.

### Old Generation
Objetos de longa duração são movidos da _Young Generation_ para a _Old Generation_.

### Permanent Generation
Metadados como classes e métodos são armazenados na _Permanent Generation_. As classes que não estão mais em uso podem ser coletadas da _Permanent Generation_.

![heap-memory](https://img.mandic.com.br/blog/2017/05/Java-Garbage-Collection.png)

## Stack
Em Java, a memória _Stack Memory_ é usada para execução de uma _Thread_. Ele contém os valores de métodos específicos que fazem referência aos objetos armazenados no _heap_ e esses valores são chamados de _short-lived_. A memória _Stack_ é uma estrutura _LIFO (Last-In-First-Out)_. Quando um método é chamado, um novo bloco é criado na _Stack_ para armazenar valores primitivos-locais e referenciar outros objetos no método.

### Stack Overflow
Ocorre quando se tenta alocar algo na _stack_ e ela não possui espaço reservado disponível. Pode haver casos em que a linguagem fornece mecanismos que permitam _overflow_. Mas em geral, execuções recursivas descontroladas causam um _Stack Overflow_.

## Stack vs Heap
- O heap é utilizado por toda a aplicação, já o stack é apenas utilizado pela thread em execução.
- Sempre quando um objeto é criado, ele é armazenado no heap, o stack apenas referencia o local deste objeto no heap.
- Objetos armazenados no heap são acessíveis de escala global, enquanto no stack apenas a thread que está executando pode acessar.
- Tamanho de memória stack é bem inferior em comparação com a memória heap. Isso ocorre devido à simplicidade de alocação de memória (LIFO), porém a memória stack é muito superior em relação à velocidade comparada com a memória heap.
- O gerenciamento de memória no stack é feito a partir do LIFO, já em heap é divido em diversas formas como Young Generation, Old-Generation etc.
- Em Java, quando a memória stack está cheia ocorre o erro `java.lang.StackOverFlowError` e quando a memória heap está cheia ocorre o erro `java.lang.OutOfMemoryError: Java Heap Space`.

![stack-vs-heap](https://journaldev.nyc3.digitaloceanspaces.com/2014/08/Java-Heap-Stack-Memory.png)