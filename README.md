# Transferências Financeiras

Este projeto consiste em um sistema para agendamento e gerenciamento de transferências financeiras. Ele é composto por uma API back-end desenvolvida em Java (Spring Boot) e um front-end desenvolvido em Angular.

## 📚 Decisões Arquiteturais

### Back-End
1. **Linguagem e Framework:**
    - Utilizamos Java 17 devido às suas melhorias de desempenho e novos recursos.
    - O framework Spring Boot foi escolhido por sua simplicidade na configuração e robustez para construir APIs REST.

2. **Validações:**
    - A biblioteca `Jakarta Validation` é usada para garantir a consistência dos dados recebidos no back-end.

3. **Banco de Dados:**
    - Banco H2 em memória para simplificar o desenvolvimento e testes. Pode ser alterado para outro banco em produção (MySQL, PostgreSQL, etc.).

4. **CORS:**
    - Configurado para permitir a integração com o front-end Angular.

5. **Estrutura de Código:**
    - Separação clara entre as camadas de `controller`, `service`, `repository` e `model`.

### Front-End
1. **Framework:**
    - Angular 19 foi utilizado pela sua modularidade, ferramentas poderosas e suporte robusto a SPAs (Single Page Applications).

2. **Comunicação com API:**
    - O módulo `HttpClient` é usado para realizar requisições HTTP ao back-end.

3. **Arquitetura:**
    - O front-end foi estruturado com módulos para facilitar o gerenciamento de funcionalidades e implementação de lazy loading.

4. **Estilos:**
    - O design foi feito com Bootstrap para agilizar o desenvolvimento da interface.

---

## 🛠️ Ferramentas Utilizadas

- **Back-End:**
    - Java 17
    - Spring Boot 3.1.x
    - H2 Database
    - Maven

- **Front-End:**
    - Angular 19
    - Node.js (v18+)
    - Bootstrap 5

---

## 🚀 Instruções para Subida do Projeto

### Pré-Requisitos
- **Java 17** ou superior
- **Node.js** (v18 ou superior) e NPM (v9 ou superior)
- **Angular CLI** (instalado globalmente com `npm install -g @angular/cli`)

### 1. Subida do Back-End
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/transferencias-financeiras.git
   cd transferencias-financeiras/backend

aração clara entre as camadas de controller, service, rep

2. Compile e execute o projeto:
   ```bash
   ./mvnw spring-boot:run

3. O back-end será iniciado em http://localhost:8080

4. http://localhost:8080/h2-console

    JDBC URL: jdbc:h2:mem:tokio_db
      Usuário: sa
      Senha: sa


## 🌐 Endpoints da API

Transferências
POST /api/transferencias

Agendar uma nova transferência.
GET /api/transferencias

Listar todas as transferências cadastradas.
GET /api/transferencias/data

Filtrar transferências por data (query param: data).