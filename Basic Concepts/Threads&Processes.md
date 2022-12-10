# Threads
É uma execução unitaria de um processo. Um processo pode haver multiplas threads, todas sendo executadas ao mesmo tempo. Uma thread *lightweight* pode ser gerenciado de forma independente por um escalonador de processos. Ajuda no desempenho da aplicação usando o *parallelism*.
## Implementação
```java
MyThread thread = new MyThread();
```
[Threads Documentation](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html)
# Processes
Um processo é a execução de um programa que você faça certas ações especificas no programa. Pode ser definido como uma unidade de execução onde o programa "roda". Ou seja todo processo ele te da todos os recursos nescessarios para você execute o programa. Um processo possui endereço virtual, o codigo executavel, acesso aos objetos do sistema, um identificador unico do processo, etc. Todo processo começa apenas com uma thread chamada *primary thread*, mas pode criar threads adicionais.
## Implementação
```java
Process processo = new ProcessBuilder();
```
[Process Documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/Process.html)

## Thread vs Processes
- Processo significa que um programa esta em execução, Thread significa o segmento de um processo.
- O Processo não é *lightweight*, Threads são *lightweight*
- Um processo leva mais tempo para terminar, Threads levam menos tempos para terminar.
- Processos são mais isolados em relação a memoria, Threads compartilham memoria
- Processos não compartilham informações, Threads compartilham informações entre si.
## Deadlock
É uma situação que ocorre quando dois ou mais programas, processos ou outros componentes que estão mutuamente esperando um pelo outro para acessar algum recurso, que no final acaba impedindo todos de acessar o recurso. Para evitar que ocorra um *deadlock* é preciso evitar o uso de *locks* desnesessarios, ou dar *locks* para *multithreads* e utilzar o *Thread join em Java* 

![deadlock](https://i.stack.imgur.com/DDuIL.png)
## Starvation
Ocorre quando um programa, processo ou outro commponente não consegue ser executado, de forma alguma, pois sempre existem processos de prioridade maior para serem executados, de forma em que o processo "faminto" nunca consiga tempo de processamento. Sua forma de lidar com esse problema é a implementação de uma tecnica chamada *Aging* que gradualmente aumenta a prioridade dos processos que estão em espera no sistema. 

![Starvation](https://i.stack.imgur.com/WEUik.png)
## Race Condition
Ocorre quando dois threads acessam uma variável compartilhada ao mesmo tempo. O primeiro thread lê a variável e o segundo thread lê o mesmo valor da variável. Em seguida, o primeiro thread e o segundo thread executam suas operações no valor e eles correm para ver qual thread pode gravar o valor por último na variável compartilhada. O valor do thread que grava seu valor por último é preservado, porque o thread está gravando sobre o valor que o thread anterior escreveu.