# 🐳 DevOps Container Solution – API para Prevenção de Desastres Ambientais

Este projeto demonstra a **conteinerização completa** de uma API Java para prevenção de desastres ambientais, utilizando **Docker** e seguindo as melhores práticas de **DevOps** e **infraestrutura como código**. A solução integra containers da aplicação e banco de dados Oracle, proporcionando um ambiente isolado, portável e escalável.

A motivação deste sistema é demonstrar como aplicações críticas de monitoramento ambiental podem ser **conteinerizadas** de forma eficiente, garantindo **portabilidade**, **escalabilidade** e **facilidade de deploy** em diferentes ambientes. O projeto atende todos os requisitos técnicos da disciplina **DEVOPS TOOLS & CLOUD COMPUTING**, implementando containers integrados com persistência de dados.

---

## 🎯 Objetivo DevOps

Demonstrar a **conteinerização completa** de uma API Java com banco Oracle, aplicando:
- **Dockerfile customizado** para aplicação Java
- **Container Oracle** com persistência via volumes
- **Integração entre containers** via link/rede
- **Execução em background** (modo daemon)
- **Monitoramento via logs** de terminal
- **CRUD completo** com persistência garantida

---

## 🔧 Requisitos Técnicos Atendidos (DevOps)

### ✅ Container da Aplicação (Dockerfile Obrigatório)
- **Dockerfile customizado** com imagem Java 17
- **Usuário não-root** (`appuser`) para segurança
- **Diretório de trabalho** definido (`/app`)
- **Variável de ambiente** para conexão com Oracle
- **Porta exposta** (8080) para acesso à API

### ✅ Container do Banco de Dados
- **Oracle Database** em container
- **Volume nomeado** (`oracle-volume`) para persistência
- **Variável de ambiente** (`ORACLE_PWD=Oracle123`)
- **Porta exposta** (1521) para acesso externo

### ✅ Execução e Monitoramento
- **Modo background** (`-d`) para ambos containers
- **Logs via terminal** (`docker logs -f`)
- **Evidências de execução** sem interface gráfica
- **CRUD completo** com persistência no Oracle

---

## 🐳 Comandos Docker

### **1. Build das Imagens**
```bash
# Build da API Java (na raiz do projeto)
docker build -t gs-java-api .

# Build do Oracle customizado
cd oracle-db
docker build -t oracle-gs .
cd ..
```

### **2. Execução dos Containers**
```bash
# Container Oracle (executar primeiro)
docker run -d \
  --name oracle-container \
  -p 1521:1521 \
  -v oracle-volume:/opt/oracle/oradata \
  -e ORACLE_PWD=Oracle123 \
  oracle-gs

# Container da API Java
docker run -d \
  --name java-api-container \
  -p 8080:8080 \
  --link oracle-container \
  gs-java-api
```

### **3. Monitoramento via Terminal**
```bash
# Verificar containers em execução
docker ps

# Logs do Oracle
docker logs -f oracle-container

# Logs da API
docker logs -f java-api-container
```

### **4. Teste do CRUD Completo**
```bash
# CREATE - Criar evento
curl -X POST http://localhost:8080/api/eventos \
  -H "Content-Type: application/json" \
  -d '{"tipo":"ENCHENTE","localizacao":"São Paulo","severidade":"ALTA"}'

# READ - Listar eventos
curl http://localhost:8080/api/eventos

# UPDATE - Atualizar evento
curl -X PUT http://localhost:8080/api/eventos/1 \
  -H "Content-Type: application/json" \
  -d '{"tipo":"ENCHENTE","localizacao":"São Paulo","severidade":"CRÍTICA"}'

# DELETE - Remover evento
curl -X DELETE http://localhost:8080/api/eventos/1
```

### **5. Verificação de Persistência**
```bash
# Conectar ao Oracle container
docker exec -it oracle-container sqlplus system/Oracle123@XE

# Verificar dados persistidos
SELECT * FROM eventos;
```

---

## 📁 Estrutura do Projeto (DevOps)

```
gs-java/
├── Dockerfile                    # Imagem customizada da API
├── docker-compose.yml            # Orquestração (opcional)
├── oracle-db/
│   └── Dockerfile                # Imagem customizada Oracle
├── src/                          # Código-fonte Java
├── target/                       # JAR compilado
├── pom.xml                       # Dependências Maven
└── README.md                     # Documentação
```

---

## 🔨 Dockerfile da Aplicação

```dockerfile
# Imagem base oficial
FROM openjdk:17-jdk-slim

# Usuário não-root (requisito obrigatório)
RUN useradd -m appuser

# Diretório de trabalho
WORKDIR /app

# Copiar JAR da aplicação
COPY target/*.jar app.jar

# Variável de ambiente (requisito)
ENV DATABASE_URL=jdbc:oracle:thin:@oracle-container:1521:XE

# Porta exposta
EXPOSE 8080

# Executar como usuário não-root
USER appuser

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 🚀 Como Executar (Passo a Passo)

### **1. Pré-requisitos**
- Docker instalado e rodando
- Java 17+ e Maven (para build local)

### **2. Compilar a Aplicação**
```bash
# Compilar código Java
mvn clean package

# Verificar JAR criado
ls target/*.jar
```

### **3. Executar Sequência Docker**
```bash
# 1. Build das imagens
docker build -t gs-java-api .
cd oracle-db && docker build -t oracle-gs . && cd ..

# 2. Executar Oracle primeiro
docker run -d --name oracle-container -p 1521:1521 -v oracle-volume:/opt/oracle/oradata -e ORACLE_PWD=Oracle123 oracle-gs

# 3. Aguardar inicialização Oracle (2-3 minutos)
docker logs -f oracle-container

# 4. Executar API Java
docker run -d --name java-api-container -p 8080:8080 --link oracle-container gs-java-api

# 5. Verificar containers
docker ps
```

### **4. Testar CRUD e Persistência**
- Acessar API: `http://localhost:8080`
- Documentação: `http://localhost:8080/swagger-ui.html`
- Executar operações CRUD via curl/Postman
- Verificar persistência no Oracle

---

## 📊 Características DevOps Implementadas

| Requisito | Implementação | Status |
|-----------|---------------|--------|
| **Container App** | Dockerfile customizado | ✅ |
| **Usuário não-root** | `appuser` definido | ✅ |
| **Variável ambiente** | `DATABASE_URL` configurada | ✅ |
| **Container DB** | Oracle com volume | ✅ |
| **Volume persistência** | `oracle-volume` nomeado | ✅ |
| **Background mode** | Flag `-d` em ambos | ✅ |
| **Logs terminal** | `docker logs -f` | ✅ |
| **CRUD completo** | API REST funcional | ✅ |

---

## 🔗 Links do Projeto

- **Repositório GitHub**: https://github.com/IDEATEC-2TDSPV-2025/GS-DEVOPS
- **Vídeo Demonstrativo**: https://youtu.be/LwV8CagW1Cg
- **Deploy Nuvem**: https://gs-java-qz1z.onrender.com/

---

## 👥 Equipe

### Desenvolvedores

| Nome | RM | 
|------|----|
| Carlos Eduardo Rodrigues Coelho Pacheco | RM 557323 |
| João Pedro Amorim Brito Virgens | RM 559213 | 
| Pedro Augusto Costa ladeira | RM 558514 | 

---

## 📝 Considerações DevOps

Esta implementação demonstra **containerização profissional** de aplicações Java com banco Oracle, seguindo:
- **Boas práticas de segurança** (usuário não-root)
- **Persistência garantida** via volumes Docker
- **Isolamento de ambientes** via containers
- **Portabilidade completa** da solução
- **Monitoramento eficiente** via logs
- **Escalabilidade horizontal** preparada

O projeto está pronto para **CI/CD**, **orquestração Kubernetes** e **deploy em nuvem**, representando uma solução DevOps completa e profissional.
