# TCP & UDP

## UDP
O protocolo UDP (User Datagram Protocol) é um tipo mais simples quando comparado com o TCP. Ele permite que a aplicação envie um datagrama em um pacote IPv4 ou um IPv6 para determinado destino, sem garantias de que o pacote de dados chegue ao destino de forma correta. Esse protocolo não é confiável e não oferece o nível de proteção e verificação dos dados transmitidos entre os usuários e dispositivos de uma determinada rede. Ele é um registro indivisível, voltado à transmissão de bytes sem um começo e sem um fim determinado. Ele é utilizado quando a velocidade de transmissão de dados é priorizada em detrimento da segurança desses dados. Sendo muito utilizado em serviços de streaming ao vivo e jogos online.

![UDP](https://nordvpn.com/wp-content/uploads/blog-how-udp-works-infographic-server-phone-pt-br-1200x628-1.svg)

## TCP
O protocolo TCP (Transmission Control Protocol) é um protocolo base da internet, complementado pelo IP, sendo um tipo bastante versátil e robusto de protocolo, fazendo com que ele seja adequado para grandes redes, como a web. Sua função principal é verificar se os dados que circulam entre os dispositivos de uma rede são enviados de forma correta e na sequência apropriada. Esse é o protocolo mais comum utilizado na rede. Sempre que você requisita o acesso a um website no seu navegador, por exemplo, sua máquina envia um pacote TCP para o endereço de servidor do website, que responde enviando um fluxo de pacotes TCP que são reunidos pelo seu navegador e, assim, permitir seu acesso ao endereço eletrônico.

![TCP](https://nordvpn.com/wp-content/uploads/blog-how-tcp-works-infographic-server-phone-pt-br-1200x628-1.svg)

## TCP vs UDP
O protocolo TCP é prezado pela confiabilidade, agregando em seu _header_ bits de controle de fluxo e recebimento. Já o UDP dispensa esses bits de controle. Pode-se dizer que o TCP é orientado para a conexão através do seu _Acknowledgment_, enquanto que o UDP não, uma vez que não é criada uma conexão para ele, apenas o envio direto de dados.

|                              | TCP                            | UDP                           |
|------------------------------|--------------------------------|-------------------------------|
| Confiabilidade               | Alto                           | Baixo                         |
| Rapidez                      | Baixo                          | Alto                          |
| Método de transferência      | Pacotes entregues em sequência | Pacotes entregues em um fluxo |
| Detecção e correção de erros | Sim                            | Não                           |
| Controle de congestão        | Sim                            | Não                           |
| Reconhecimento               | Sim                            | Apenas a verificação          |

# Protocol HTTP
O protocolo HTTP define um conjunto de métodos de requisições responsáveis por indicar a ação a ser executada para um dado ou recurso. Os métodos são:

### GET
Solicita a representação de um recurso específico. Requisições utilizando o método GET devem retornar apenas dados.

### POST
É utilizado para submeter uma entidade a um recurso específico, frequentemente causando uma mudança no estado do recurso ou efeitos colaterais no servidor.

### PUT
Substitui todas as atuais representações do recurso de destino pela carga de dados da requisição.

### DELETE
Remove um recurso específico.

## REST
**REST** (_Representational State Transfer_) refere-se a um grupo de restrições de design dentro da arquitetura de software que geram sistemas distribuídos eficientes, confiáveis e escaláveis. Os web services que estão em conformidade com a arquitetura REST são denominados web services _RESTful_. As solicitações em uma aplicação _RESTful_ provocarão uma resposta com a carga útil formatada em HTML, XML, JSON ou algum outro formato.

![REST](https://www.service-architecture.com/images/web_services/rest_messages.jpg)
*Obs: Em uma arquitetura REST a resposta pode ser tanto em JSON quanto em XML*

## SOAP
O protocolo **SOAP** (Simple Object Access Protocol) é um protocolo para troca de informações estruturadas em uma plataforma descentralizada e distribuída. Ele se baseia em XML para seu formato de mensagem e, normalmente, se baseia em outros protocolos da camada de aplicação, como o RPC e o próprio HTTP.

![SOAP](https://www.service-architecture.com/images/web_services/soap_messages.jpg)
*Obs: Em arquitetura SOAP a resposta sempre sera em XML*

## Status Code HTTP
Um código de status HTTP consiste em três dígitos. O primeiro dígito varia de um a cinco e indica o tipo de status. O segundo e terceiro dígitos referem-se aos códigos de status no intervalo do primeiro dígito. Apesar de estar no header HTTP da página, os navegadores geralmente não exibem o código de status HTTP por padrão. Para ver os headers HTTP que o servidor retorna, você pode usar as *Dev Tools* presentes nos navegadores para verificar a resposta HTTP.

#### 1xx (Informativo)
O servidor recebeu a solicitação e está processando.

#### 2xx (Confirmação)
O servidor recebeu a solicitação e enviou a resposta esperada.

#### 3xx (Redirecionamento)
Indica que algo precisa ser feito ou foi feito para completar a solicitação.

#### 4xx (Erro do cliente)
Indica que a solicitação não pode ser concluída ou contém uma sintaxe incorreta.

#### 5xx (Erro no servidor)
O servidor falhou ao concluir a solicitação.

### Códigos de Status HTTPS comuns
-   Código de Status 200 - É compreendido como um "OK" para uma requisição HTTP bem sucedida. A resposta depende da requisição feita. Por exemplo, para uma requisição GET, a resposta estará incluída no corpo da mensagem.
-   Código de Status 201 - Esse status confirma que a requisição foi concluída e como resultado, um novo recurso foi criado. Está presente após uma requisição POST/PUT.
-   Código de Status 304 - indica que não há necessidade de retransmitir a requisição de recursos. É um redirecionamento implícito para o recurso em cache.
-   Código de Status 403 - indica que o servidor entendeu o pedido, mas se recusa a autorizá-lo. Ocorre devido ao cliente/usuário não ter a permissão necessária para executar tal ação.
-   Código de Status 404 - indica que o servidor não conseguiu encontrar o recurso solicitado. Normalmente, links que levam a uma página 404 estão quebrados ou desativados.
-   Código de Status 500 - indica que o servidor encontrou uma condição inesperada e que o impediu de atender à solicitação.