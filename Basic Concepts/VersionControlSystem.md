# VCS - Version Control System
Um sistema de controle de versão (VCS) é um tipo de software que permite que você rastreie as alterações feitas em um conjunto de arquivos ao longo do tempo. Isso é útil porque permite que você volte para uma versão anterior dos arquivos se algo der errado ou se você precisar desfazer alterações que tenha feito. Um VCS também facilita o trabalho em equipe, permitindo que várias pessoas trabalhem em um mesmo conjunto de arquivos sem perder ou sobrescrever as alterações uns dos outros.

![git](https://miro.medium.com/max/383/1*co_1qORNdM0PI1nvCp7Iig.png)

## Git
Git é um sistema de controle de versão de código-fonte muito popular que foi criado por Linus Torvalds, o mesmo desenvolvedor do kernel do Linux. Ele permite que você rastreie as alterações em seus arquivos de código-fonte de maneira eficiente e fácil de usar. Com o Git, você pode facilmente reverter para versões anteriores de seus arquivos, ver quem fez alterações específicas e trabalhar em conjunto com outras pessoas em projetos de código-fonte.

## GitHub
É uma plataforma de desenvolvimento de código e colaboração que usa o sistema de controle de versão Git. É um lugar onde desenvolvedores podem armazenar e gerenciar seus projetos de código, bem como rastrear e controlar alterações no código. GitHub também oferece recursos como ferramentas de colaboração, integração contínua, gerenciamento de tarefas e documentação, tornando-o uma plataforma popular para projetos de código aberto e comerciais.

## Boas práticas em Git
-   Manter commits pequenos e coerentes, com alterações relacionadas ao mesmo conjunto de arquivos ou funcionalidade. Isso torna mais fácil reverter ou mesclar alterações em um commit específico, se necessário.
-   Escrever mensagens de commit claras e descritivas que expliquem as alterações realizadas em cada commit. Isso torna mais fácil para os outros desenvolvedores entenderem o que foi alterado e por quê.
-   Utilizar branches para desenvolver novas funcionalidades ou corrigir bugs, em vez de realizar alterações diretamente na branch principal (geralmente chamada de "master"). Isso permite que o código seja revisado e testado antes de ser mesclado com o código principal.
-   Realizar o merge ou o rebase de branches com frequência para manter o código principal atualizado e evitar conflitos de código.
-   Sempre verificar o código antes de realizar um commit para garantir que não estão sendo adicionados arquivos desnecessários ou que não foram resolvidos conflitos de código.
-   Trabalhar em equipe, discutir mudanças no código e utilizar ferramentas de colaboração, como pull requests, para facilitar a revisão de código e a colaboração entre os desenvolvedores.

## Comandos

### Criar
| **Operação**                        | **Comando**                                    |
|---------------------------------|--------------------------------------------|
| Clonar um repositório existente | ``$ git clone ssh://user@domain.com/repo.git`` |
| Criar um novo repositório local | ``$ git init``                                 |

### Modificações Locais
| **Operação**                                                              | **Comando**                |
|-----------------------------------------------------------------------|------------------------|
| Arquivos alterados no seu diretório                       | ``$ git status``           |
| Alterações em arquivos                                     | ``$ git diff``             |
| Adicionar todas as alterações atuais ao próximo commit                | ``$ git add .``            |
| Adicionar algumas alterações ao próximo commit                        | ``$ git add -p <arquivo>`` |
| Efetuar o commit de todas as alterações locais em arquivos | ``$ git commit -a``        |
| Efetuar o commit de alterações préviamente preparadas                 | ``$ git commit``           |
| Alterar o último commit (não altera commits publicados!)              | ``$ git commit --amend``   |

### Historico de Commits
| **Operação**                                                         | **Comando**                |
|------------------------------------------------------------------|------------------------|
| Mostrar todos os commits, começando pelo mais recente            | ``$ git log``              |
| Mostrar as alterações ao longo do tempo em um arquivo específico | ``$ git log -p <arquivo>`` |
| Quem alterou o que e quando em um ``<arquivo>``                         | ``$ git blame <arquivo>``  |

### Branches e Tags
| **Operação**                                                                      | **Comando**                                     |
|-------------------------------------------------------------------------------|---------------------------------------------|
| Listar todas as branches existentes                                       | ``$ git branch``                                |
| Mudar branch HEAD                                                        | ``$ git checkout <branch>``                |
| Criar uma nova branch com base na sua HEAD atual             | ``$ git branch <nova-branch>``             |
| Criar uma nova branch de rastreamento com base em uma branch remota | ``$ git checkout --track <remote/branch>`` |
| Excluir uma branch local                                                 | ``$ git branch -d <branch>``               |
| Marcar o commit atual com uma tag                                             | ``$ git tag <nome-da-tag>``                     |

### Update e Upload
| **Operação**                                                            | **Comando**                               |
|---------------------------------------------------------------------|---------------------------------------|
| Listar todos os repositório configurados atualmente                     | ``$ git remote -v``                       |
| Mostrar informações sobre um repositório                                 | ``$ git remote show <origin>``            |
| Adicionar novo repositório remoto, nomeado ``<origin>``                 | ``$ git remote add <origin> <url>``       |
| Baixar todas as alterações de ``<repositório>``, mas não integrá-las ao HEAD | ``$ git fetch <origin>``                  |
| Baixar alterações e integrá-las diretamente ao HEAD                 | ``$ git pull <origin> <branch>``     |
| Publicar alterações locais em um repositório                             | ``$ git push <origin> <branch>``     |
| Excluir uma branch do repositório remoto                                   | ``$ git branch -dr <origin/branch>`` |
| Publicar suas tags                                                  | ``$ git push --tags``                     |

### Merge and Rebase
| **Operação**                                                                                                  | **Comando**                                            |
|-----------------------------------------------------------------------------------------------------------|----------------------------------------------------|
| Mesclar ``<branch>`` com a sua atual HEAD                                                                     | ``$ git merge <branch>``                               |
| Rebase a sua atual HEAD em ``<branch>``                             | ``$ git rebase <branch>``                              |
| Cancelar um rebase                                                                                        | ``$ git rebase --abort``                               |
| Continuar um rebase após resolver conflitos                                                               | ``$ git rebase --continue``                            |
| Utilize a ferramenta de mesclagem configurada para resolver conflitos                                     | ``$ git mergetool``                                    |

### Resetar
| **Operação**                                                                                                           | **Comando**                     |
|--------------------------------------------------------------------------------------------------------------------|-----------------------------|
| Descartar todas as alterações locais no seu repositório                                                  | ``$ git reset --hard HEAD``     |
| Descartar alterações locais em um arquivo específico                                                               | ``$ git checkout HEAD <file>``  |
| Reverter um commit                                              | ``$ git revert <commit>``       |
| Resetar o seu ponteiro HEAD para um commit anterior e descartar todas as alterações desde então                    | ``$ git reset --hard <commit>`` |
| Resetar o seu ponteiro HEAD para um commit anterior e preservar todas as alterações como unstaged | ``$ git reset <commit>``        |
| Resetar o seu ponteiro HEAD para um commit anterior e preservar alterações locais não commitadas                   | ``$ git reset --keep <commit>`` |
