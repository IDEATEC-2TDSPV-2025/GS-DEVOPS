# 🌎 Global Solution IdeaTec – API para Prevenção de Desastres Ambientais

Este projeto propõe uma solução inovadora para monitoramento, alerta e prevenção de desastres ambientais, integrando sensores IoT, dados geográficos e participação cidadã. A API centraliza informações de zonas de risco, leituras de sensores, alertas automáticos e relatos de usuários, permitindo respostas rápidas e decisões baseadas em dados para proteger vidas e comunidades.

---

## 💡 Objetivo

O sistema visa mitigar os impactos de eventos extremos (inundações, deslizamentos, etc.) por meio de tecnologia e inteligência. Ao concentrar dados em uma API robusta, facilita a integração com aplicativos, painéis de monitoramento e órgãos de Defesa Civil, promovendo cidades mais seguras e resilientes.

---

## LINKS

Vídeo Pitch - https://youtu.be/l4zLjS73bEw  
Vídeo do Projeto em Java - https://youtu.be/lWVgAz0M_jE  
Link do Deploy - https://gs-java-qz1z.onrender.com/

---

## 🔑 Requisitos Técnicos Atendidos

### • API REST com Boas Práticas de Arquitetura

O projeto segue arquitetura em camadas (controller, service, repository, model, dto, security, config, exception), separando responsabilidades e facilitando manutenção e testes. Os endpoints REST são claros, padronizados e utilizam corretamente os códigos HTTP.

### • Persistência com Banco Relacional e Spring Data JPA

Toda a persistência é feita via Spring Data JPA, garantindo integração eficiente com bancos relacionais (Oracle por padrão, mas adaptável a outros). As entidades são mapeadas com anotações JPA, e os repositórios usam interfaces do Spring para consultas e paginação.

### • Mapeamento de Relacionamentos

Relacionamentos como `@ManyToOne`, `@OneToMany` e `@Enumerated` são utilizados para refletir a estrutura real do domínio: sensores associados a zonas de risco, alertas vinculados a zonas, ocorrências ligadas a usuários, etc.

### • Validação com Bean Validation

A entrada de dados é validada com Bean Validation (`@NotBlank`, `@Email`, `@NotNull`, etc.), garantindo integridade e respostas claras em caso de erro. Os DTOs e controllers usam `@Valid` para acionar as validações automaticamente.

### • Paginação, Ordenação e Filtros

Endpoints de listagem suportam paginação e ordenação via parâmetros padrão do Spring (`page`, `size`, `sort`). Filtros por entidade relacionada (ex: listar sensores de uma zona, ocorrências por usuário) estão disponíveis para facilitar consultas eficientes.

### • Documentação da API com Swagger

A API é totalmente documentada com Swagger/OpenAPI, permitindo visualização e testes interativos dos endpoints em `/swagger-ui.html`. Cada endpoint possui descrição clara de uso, parâmetros e exemplos de resposta.

### • Autenticação JWT

A segurança é implementada com Spring Security e JWT, protegendo endpoints sensíveis e permitindo autenticação robusta para diferentes perfis de usuário. O fluxo de login retorna um token JWT, que deve ser usado nas requisições subsequentes.

### • Deploy em Nuvem

O projeto está pronto para deploy em nuvem (Heroku, AWS, Railway, etc.), com configurações externas para banco de dados e variáveis sensíveis. O uso de `application.properties` permite fácil adaptação para diferentes ambientes.

---

## 🗂 Estrutura dos Principais Pacotes

- **config/**: Configurações globais (Swagger, Security, CORS)
- **controller/**: Endpoints REST para cada recurso principal
- **dto/**: Objetos de transferência de dados (requests/responses)
- **exception/**: Tratamento global de erros e validações
- **model/**: Entidades JPA e enums de domínio
- **repository/**: Interfaces Spring Data JPA para persistência
- **security/**: Implementação completa do fluxo JWT
- **service/**: Lógica de negócio e conversão entre entidades e DTOs

---

## 🚀 Como Executar

1. **Pré-requisitos**
    - Java 17+
    - Maven 3.8+
    - Oracle Database (ou H2 para testes)

2. **Configuração**
    - Ajuste o arquivo `src/main/resources/application.properties` com as credenciais do seu banco Oracle.

3. **Rodando o Projeto**

4. **Acessando a API**
- Documentação: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Endpoints protegidos exigem JWT (obtenha via `/api/auth/login`).

---

## 🔒 Exemplo de Fluxo de Autenticação

1. **Registrar usuário**

2. **Login**
- O retorno será um token JWT para ser usado no header `Authorization`.

---

## ☁️ Deploy em Nuvem

- O projeto pode ser facilmente publicado em plataformas como Heroku, AWS ou Railway.
- Basta configurar as variáveis de ambiente do banco e executar o build Maven.

---

## 📝 Considerações Finais

Esta API promove cidades mais seguras e inteligentes, conectando sensores, cidadãos e autoridades em um ecossistema digital de prevenção de desastres. O código segue padrões profissionais, é seguro, extensível e pronto para integração com qualquer front-end ou aplicativo móvel.

A documentação, arquitetura e exemplos de uso estão claros para facilitar tanto a avaliação quanto a evolução futura do projeto.
