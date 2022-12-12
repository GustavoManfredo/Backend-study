# VCS - Version Control System
Gerencia o histórico das alterações que os arquivos do projeto sofreu ao longo do tempo. Exemplo, você pode comparar mudanças, reverter alterações e ver quem modificou algo.

## Git
Git é um sistema de controle de versões distribuído e um sistema de gerenciamento de código fonte, com ênfase em alta velocidade. O Git foi inicialmente era um projeto para o desenvolvimento do Kernel Linux, mas foi adotado por muitos outros projetos e atualmente é o controlador de versões mais utilizado.

![git](https://miro.medium.com/max/383/1*co_1qORNdM0PI1nvCp7Iig.png)

## Comandos

### Git init
O comando `git init` cria um novo repositório do Git. Ele pode ser usado para converter um projeto existente e não versionado em um repositório do Git ou inicializar um novo repositório vazio.
```bash
git init
```

### Git config
O comando `git config` é a função conveniente usada para definir valores de configuração do Git em projetos de nível global ou local. Esses níveis de configuração correspondem aos arquivos de texto do `.gitconfig` .

#### Definindo um username
```bash
git config --global user.name "user"
```

#### Definindo um email
```bash
git config --global user.email "user@email.com"
```

#### Listando configurações
```bash
git config --list
```

### Git add
O comando `git add` adiciona uma alteração no diretório ativo à área de staging. Ele diz ao Git que você quer incluir atualizações a um arquivo específico no próximo commit. No entanto, `git add` não tem efeito real e significativo no repositório, as alterações não são gravadas mesmo até você executar `git commit`.

```bash
git add <arquivo>||<diretorio>||*(tudo)
```

Junto com esses comandos, você também vai precisar de `git status` para ver o estado do diretório ativo e da área de staging.
```bash
git status
```

### Git commit
O comando `git commit` captura um instantâneo das mudanças preparadas do projeto no momento. Os instantâneos com commit podem ser considerados versões "seguras" de um projeto, o Git nunca os altera, a menos que você peça a ele.

```bash
git commit -m "commit message"
```

Para corrigir o ultimo commit é nescessario colocar um `--amend`
```bash
git commit --amend -m "commit message"
```

Para desfazer um commit é nescessario
```bash
git reset --soft HEAD-1
```

### Git log
O comando `git log` permite visualizar o histórico do repositório.
```bash
git log
```

```bash
git log --oneline
```

### Estágios do arquivo
![archive-stages](https://user.oc-static.com/upload/2022/01/04/16412576933806_image30.png)

### Git diff
Para visualizar diferenças entre versões do projeto, é possível utilizar o comando `git diff`
```bash
git diff
```

### Git restore
O comando `git restore` ele pega qualquer modificação feita no arquivo e descarta essas modificações
```bash
git restore <file>
```

## Github
É uma plataforma de hospedagem de código-fonte e arquivos com controle de versão usando o Git. Ele permite que qualquer usuario cadastrado na plataforma contribuam em projetos *Open Source* ou privados(desde de que tenham permissão) de qualquer lugar do mundo.

![github](https://cdn-icons-png.flaticon.com/512/25/25231.png)

## Repositórios remotos

### Git remote
Para gerenciar comunicação repositórios remotos, você precisa salvar no seu repositório local referências para os repositórios remotos. Para fazer isso, existe o comando `git remote`.
```bash
git remote add origin <project link>
```

### Git clone
Para clonar repositórios remotos, é possível usar o comando `git clone`.
```bash
git clone <repo link> ./path
```

### Git push
Para mandar suas mudanças a um remoto salvo como `origin` numa *branch* `main`.
```bash
git push origin -u main
```

### Git pull
Semelhantemente, para receber mudanças de um repositório remoto salvo como `origin` numa *branch* `main`
```bash
git pull origin main
```

