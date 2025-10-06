# Welcome to Brasil — Sistema de Assessoria Migratória

## Sobre a Empresa

A **Welcome to Brasil** é uma empresa de assessoria migratória especializada em auxiliar estrangeiros no processo de obtenção da cidadania brasileira.  
Com uma abordagem humanizada, o escritório busca simplificar e agilizar cada etapa do processo, desde o cadastro até a análise final dos documentos junto à Polícia Federal.

---

## Funcionalidades do Sistema

O sistema foi desenvolvido para digitalizar e automatizar o atendimento oferecido pela empresa, permitindo que o cliente acompanhe suas informações e processos com mais transparência.  
Entre as principais funcionalidades:

- **Visualização de mensalidades de pagamento**  
- **Acompanhamento do andamento do processo migratório**  
- **Cadastro de novos usuários**, incluindo dados como endereço, telefone e número do RNM  
- **Autenticação segura de acesso** com controle de permissões  
- **Envio de notificações por e-mail** para atualização de status  

---

## Tecnologias Utilizadas

### Back-end
- **Java 21** — linguagem principal do projeto  
- **Spring Boot** — estrutura base para desenvolvimento da API  
- **Spring Security** — autenticação e autorização com tokens JWT  
- **Java Mail Sender** — envio automatizado de e-mails  
- **Gradle** — gerenciamento de dependências e build do projeto  
- **MongoDB** — banco de dados NoSQL para armazenamento dos registros

## Como Executar o Projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/vitormneris/wb-assessoria-backend-spring-boot.git
 ```
### 2. Acessar o diretório do projeto
```bash
cd wb-assessoria-backend-spring-boot
 ```
### 3. Executar a aplicação com Gradle
```bash
./gradlew bootRun
 ```
### 4. Acessar no navegador
A aplicação será iniciada por padrão em:
http://localhost:8084
