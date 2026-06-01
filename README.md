# 🎓 Meritum01

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Flutter](https://img.shields.io/badge/Flutter-3.x-blue)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED)
![JWT](https://img.shields.io/badge/Auth-JWT-red)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Future-blue)
![MySQL](https://img.shields.io/badge/MySQL-Workbench-4479A1)
![Status](https://img.shields.io/badge/Status-In_Development-yellow)

**Sistema Inteligente de Gestão Acadêmica, Econômica e Gamificação Educacional**

*Transformando desempenho acadêmico em crescimento real.*

</div>

---

# 📌 Sobre o Projeto

O **Meritum** é uma plataforma inteligente de **gestão acadêmica, economia virtual e gamificação educacional**, projetada para instituições de ensino brasileiras.

O sistema busca aumentar:

* engajamento estudantil;
* desempenho acadêmico;
* colaboração;
* responsabilidade coletiva;
* acompanhamento pedagógico.

Inspirado em modelos de incentivo e progressão educacional, o projeto adapta conceitos de economia gamificada para a realidade institucional brasileira de forma **ética, segura e escalável**.

---

# 🎯 Objetivos

O Meritum foi criado para:

✅ aumentar a participação estudantil;
✅ incentivar desempenho acadêmico;
✅ reduzir faltas e indisciplina;
✅ recompensar boas práticas;
✅ centralizar gestão institucional;
✅ fornecer analytics acadêmicos;
✅ promover colaboração entre turmas.

---

# 💰 Economia Educacional

O sistema utiliza uma moeda virtual institucional:

## **Pontos Econômicos**

Os alunos podem **ganhar** pontos por:

* 📚 desempenho acadêmico
* ✅ frequência
* 🎯 participação
* 🧪 projetos
* 🏅 olimpíadas
* 👨‍🏫 monitoria
* 🤝 comportamento

Os alunos podem **perder** pontos por:

* ❌ faltas
* ⏰ atrasos
* ⚠️ advertências
* 🚫 plágio
* 🛑 indisciplina

---

## 🎁 Benefícios Reais

Os pontos podem ser convertidos em:

* desconto em mensalidade;
* vouchers;
* créditos no refeitório;
* materiais escolares;
* prioridade em cursos;
* certificados de mérito;
* horas complementares.

---

# 🏫 Estrutura de Turmas

O sistema adota um modelo híbrido:

### **70% Individual**

Baseado no desempenho do aluno.

### **30% Coletivo**

Baseado no desempenho da turma.

Cada turma possui:

* até **16 alunos**
* score coletivo
* ranking
* metas
* desafios
* bonificações

---

# 🏗 Arquitetura do Sistema

O projeto utiliza:

## **Monólito Modular**

Preparado para evolução em **Microsserviços**.

### Arquitetura Inicial

```text
Frontend Web (HTML/CSS/JS)
           │
           ▼
     Spring Boot API
           │
 ┌─────────┼─────────┐
 ▼         ▼         ▼
Core   Academic   Economy
 ▼         ▼         ▼
Social  Analytics  Admin
           │
           ▼
     MySQL/PostgreSQL
```

### Evolução Futura

Separação planejada:

* Auth Service
* Economy Service
* Academic Service
* Chat Service
* Analytics Service

---

# 🛠 Stack Tecnológica

## Backend

* Java 21
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate
* Maven

## Frontend Web

* HTML5
* CSS3
* JavaScript

## Mobile

* Flutter
* Riverpod
* Dio
* Hive

## Banco de Dados

### Inicial

* MySQL
* MySQL Workbench

### Futuro

* PostgreSQL

## Infraestrutura

* Docker
* Docker Compose
* GitHub Actions
* CI/CD

---

# 📂 Estrutura do Projeto

```text
meritum/
│
├── backend/
│   ├── core/
│   ├── academic/
│   ├── economy/
│   ├── social/
│   ├── administrative/
│   └── shared/
│
├── mobile/
│   ├── lib/
│   ├── features/
│   ├── core/
│   └── shared/
│
├── frontend/
│
├── docs/
│
└── docker/
```

---

# ⚙️ Módulos do Sistema

## 🔐 Core

* autenticação JWT
* controle de usuários
* permissões
* RBAC
* dashboard

## 📚 Academic

* notas
* frequência
* disciplinas
* desempenho
* projetos
* olimpíadas

## 💰 Economy

* carteira virtual
* pontos econômicos
* extrato
* marketplace
* recompensas
* ranking

## 💬 Social

* chat
* equipes
* desafios
* liderança estudantil

## 📊 Administrative

* analytics
* auditoria
* antifraude
* relatórios

---

# 🔒 Segurança

O Meritum utiliza:

* JWT Authentication
* Refresh Token
* RBAC (Role Based Access Control)
* BCrypt Password Hash
* HTTPS
* Auditoria completa
* Logs de transações
* Sistema antifraude

### Roles

```text
ADMIN
COORDINATION
TEACHER
STUDENT_COUNCIL
CLASS_LEADER
STUDENT
```

---

# 🚀 Roadmap

## MVP (Versão 1)

* [ ] Login JWT
* [ ] Gestão de usuários
* [ ] Frequência
* [ ] Notas
* [ ] Carteira virtual
* [ ] Pontos econômicos
* [ ] Dashboard aluno
* [ ] Ranking

---

## V2

* [ ] Marketplace
* [ ] Chat
* [ ] Sistema de desafios
* [ ] Gamificação
* [ ] Conselho estudantil

---

## V3

* [ ] Analytics avançado
* [ ] IA de desempenho acadêmico
* [ ] Sistema preditivo
* [ ] Microsserviços

---

# 🐳 Docker

Executar ambiente local:

```bash
docker-compose up --build
```

Parar containers:

```bash
docker-compose down
```

---

# ⚙️ Configuração do Ambiente

### Backend

```bash
cd backend
./mvnw spring-boot:run
```

### Flutter

```bash
cd mobile
flutter pub get
flutter run
```

---

# 📘 Documentação

Toda a documentação do projeto encontra-se em:

```text
/docs
```

Estrutura:

```text
docs/
├── 01-visao-geral.md
├── 02-arquitetura.md
├── 03-requisitos.md
├── 04-modelagem.md
├── 05-spring-architecture.md
├── 06-flutter-architecture.md
├── 07-security-jwt-rbac.md
├── 08-devops-ci-cd.md
└── 09-roadmap.md
```

---

# 👥 Equipe

Projeto desenvolvido por:

**Equipe Meritum**

Funções recomendadas:

* Backend Developer
* Mobile Developer
* Frontend Developer
* DevOps/Database
* Product/Architecture

---

# 📜 Licença

Este projeto está licenciado sob a licença **MIT**.

---

<div align="center">

**Meritum © 2026**

*Tecnologia, educação e mérito conectados.*

</div>
