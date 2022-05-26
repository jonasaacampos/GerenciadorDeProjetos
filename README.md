# Gerenciador de Projetos
 11c

...

## Demo

...

## Escopo e definição do projeto
### Definição geral do projeto

- **Nome:** Gerenciador de Projetos
- **Descrição:** Aplicação para gerenciamento de projetos.
- **Objetivo:** Gerenciar as tarefas de um ou vários projetos

### Requisitos

**Entidades:**
- Projeto
    - nome
    - descrição
    - data de criação
    - data de atualização
- Tarefa
    - nome
    - descrição
    - status
    - observações
    - prazo
    - data de criação
    - data de atualização

**Funcionalidades:**
- Projetos. Permitir:
    - criar,
    - alterar,
    - deletar Projetos
- Tarefas. Permitir
    - criar,
    - alterar,
    - deletar Tarefas

### Regras de Negócio

- não é necessário sistema de login
- não existe usuários
- toda tarefa deve pertencer a um projeto

### Tecnologias utilizadas

- Java
- Sql

## Dependências

**Instalação do xaamp**
```
wget "https://sourceforge.net/projects/xampp/files/XAMPP%20Linux/7.4.27/xampp-linux-x64-7.4.27-2-installer.run/download" -O xampp-installer.run

chmod +x xampp-installer.run

sudo ./xampp-installer.run

// criar um atalho do programa
echo -e '[Desktop Entry]\n Version=1.0\n Name=xampp\n Exec=gksudo /opt/lampp/manager-linux-x64.run\n Icon=/opt/lampp/icons/world1.png\n Type=Application\n Categories=Application' | sudo tee /usr/share/applications/xampp.desktop

sudo apt-get install gksu
proje
sudo chmod +x /usr/share/applications/xampp.desktop
cp /usr/share/applications/xampp.desktop ~/Desktop

//executar no terminal
sudo /opt/lampp/lampp start

http://localhost
```

## 1. Criar Banco de dados

Como temos as entidades definidas, agora vamos iniciar a codificação. Para este projeto usaremos o xamp com serviços do mysql e apache.

**Criar banco de dados**

PhpMyAdmin > databases > create = banco de dados criado

**Criar tabelas**

Selecinar banco de dados criado > structure >
projects > 5 colunas

```
CREATE TABLE `gerenciadorDeTarefas`.`Projects` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(50) NOT NULL , `description` VARCHAR(400) NULL , `createdAt` DATETIME NOT NULL , `updatedAr` DATETIME NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
```

tasks > 9 colunas

```
CREATE TABLE `gerenciadorDeTarefas`.`tasks` ( `id` INT NOT NULL AUTO_INCREMENT , `idProject` INT NOT NULL , `name` VARCHAR(50) NOT NULL , `description` VARCHAR(255) NULL , `status` BOOLEAN NOT NULL , `notes` VARCHAR(300) NULL , `deadLine` DATE NOT NULL , `createdAt` DATETIME NOT NULL , `updatedAt` DATETIME NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
```

**Criar relacionamentos (chave estrangeira)**

Selecionar tabela de tarefas > structure > criar relações

```
ALTER TABLE `tasks` ADD CONSTRAINT `fk_project` FOREIGN KEY (`idProject`) REFERENCES `Projects`(`id`) ON DELETE CASCADE ON UPDATE CASCADE;
```

## 2. Protótipo da interface

Aplicativos de protoripagem
Paletas de cores
Icones

## check list

- [ ] Criação do banco de dados
- [ ] Criação das classes de modelo
- [ ] Criação do vínculo entre tabelas
- [ ] Criação das classes de controle de acesso
- [ ] Criação da interface gráfica
  - [ ] Tela principal
    - [ ] cellrederer Prazo
    - [ ] cellRederer Editar e deletar
  - [ ] Tela de cadastro de projeto
  - [ ] Tela de cadastro de tarefa
- [ ] Implementar eventos
- [ ] validar eventos
- [ ] Ajustes finais
- [ ] Testes
