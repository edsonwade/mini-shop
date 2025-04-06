# Domain-Driven Design (DDD)

Domain-Driven Design (DDD) é uma abordagem para o desenvolvimento de software que se concentra na modelagem do domínio e
na colaboração entre especialistas do domínio e desenvolvedores. O objetivo é criar um modelo de domínio que reflita com
precisão as regras de negócios e as necessidades da aplicação.

## Princípios Fundamentais do DDD

### 1. Foco no Domínio

- **Definição**: O domínio é a área de conhecimento ou atividade em que a aplicação opera. É essencial entender o
  domínio para criar um modelo que atenda às suas necessidades.
- **Colaboração**: Envolver especialistas do domínio (stakeholders) no processo de desenvolvimento para garantir que o
  modelo reflita a realidade do negócio.

### 2. Ubiquitous Language (Linguagem Ubíqua)

- **Definição**: Uma linguagem comum que é usada por todos os membros da equipe (desenvolvedores e especialistas do
  domínio) para descrever o domínio.
- **Objetivo**: Reduzir a ambiguidade e melhorar a comunicação, garantindo que todos tenham uma compreensão clara dos
  conceitos e termos usados no domínio.

### 3. Modelagem do Domínio

- **Entidades**: Objetos que têm uma identidade distinta e são definidos por suas características e comportamentos.
  Exemplo: `Product`, `User`.
- **Value Objects**: Objetos que não têm identidade própria e são definidos apenas por seus atributos.
  Exemplo: `Address`, `Money`.
- **Agregados**: Um grupo de entidades e value objects que são tratados como uma unidade. Um agregado tem uma raiz (
  Aggregate Root) que controla o acesso a seus membros. Exemplo: um `Order` pode ser um agregado que
  contém `OrderItems`.
- **Repositórios**: Interfaces que fornecem métodos para acessar e manipular agregados.
  Exemplo: `ProductRepository`, `OrderRepository`.
- **Serviços de Domínio**: Classes que contêm lógica de negócios que não se encaixa bem em entidades ou value objects.
  Exemplo: `PaymentService`, `ShippingService`.

### 4. Camadas do DDD

- **Camada de Apresentação**: Interage com o usuário e exibe informações. Pode incluir controladores e interfaces de
  usuário.
- **Camada de Aplicação**: Orquestra a lógica de negócios e coordena as operações entre a camada de apresentação e a
  camada de domínio.
- **Camada de Domínio**: Contém o modelo de domínio, incluindo entidades, value objects, agregados e serviços de
  domínio.
- **Camada de Infraestrutura**: Fornece implementações específicas de infraestrutura, como acesso a dados, serviços
  externos e outras funcionalidades técnicas.

### 5. Estratégias de Design

- **Bounded Contexts (Contextos Delimitados)**: Uma parte do modelo de domínio que é explicitamente definida e isolada.
  Cada contexto delimitado pode ter seu próprio modelo e linguagem ubíqua. É importante para evitar confusões e garantir
  que diferentes partes do sistema possam evoluir independentemente.
- **Context Mapping**: A prática de mapear as interações entre diferentes contextos delimitados, definindo como eles se
  comunicam e compartilham dados.

## Benefícios do DDD

- **Alinhamento com o Negócio**: O DDD ajuda a garantir que o software atenda às necessidades do negócio, criando um
  modelo que reflete a lógica e as regras do domínio.
- **Melhoria na Comunicação**: A linguagem ubíqua e a colaboração entre desenvolvedores e especialistas do domínio
  melhoram a comunicação e reduzem mal-entendidos.
- **Flexibilidade e Manutenção**: Um modelo de domínio bem projetado facilita a manutenção e a evolução do software,
  permitindo que novas funcionalidades sejam adicionadas com menos esforço.

### Exemplo

```bash
com.example.minishop
│
├── application
│   ├── services
│   │   ├── AccountApplicationService.java
│   │   ├── ClientApplicationService.java
│   │   ├── OrderApplicationService.java
│   │   ├── PaymentApplicationService.java
│   │   └── ProductApplicationService.java
│   └── dto
│       ├── AccountDTO.java
│       ├── ClientDTO.java
│       ├── OrderDTO.java
│       ├── PaymentDTO.java
│       └── ProductDTO.java
│
├── config
│   ├── AppConfig.java
│   ├── DatabaseConfig.java
│   ├── SecurityConfig.java
│   └── SwaggerConfig.java
│
├── domain
│   ├── account
│   │   ├── Account.java
│   │   ├── AccountRepository.java --> interface
│   │   ├── AccountService.java
│   ├── client
│   │   ├── Client.java
│   │   ├── ClientRepository.java   --> interface
│   ├── order
│   │   ├── Order.java
│   │   ├── OrderRepository.java
│   ├── payment
│   │   ├── Payment.java
│   │   ├── PaymentRepository.java --> interface
│   └── product
│       ├── Product.java
│       ├── ProductRepository.java --> interface
│
├── infrastructure
│   ├── database
│   │   ├── AccountJpaRepository.java
│   │   ├── ClientJpaRepository.java
│   │   ├── OrderJpaRepository.java
│   │   ├── PaymentJpaRepository.java
│   │   └── ProductJpaRepository.java
│   ├── logging
│   │   ├── LogService.java
│   │   └── LogFormatter.java
│   ├── httpclient
│   │   ├── HttpClientService.java
│   │   └── HttpClientConfig.java
│   ├── messaging
│   │   └── MessageBroker.java
│   └── external
│       └── PaymentGateway.java
│
├── interfaces
│   ├── controllers
│   │   ├── AccountController.java
│   │   ├── ClientController.java
│   │   ├── OrderController.java
│   │   ├── PaymentController.java
│   │   └── ProductController.java
│   └── exceptions
│       └── CustomExceptionHandler.java   exceções de forma centralizada (@ControllerAdvice)
│       ├── ResourceNotFoundException.java
│       ├── InvalidInputException.java
│       └── BusinessLogicException.java
│
├── shared
│   ├── utils
│   │   ├── DateUtils.java
│   │   ├── StringUtils.java
│   │   └── ValidationUtils.java
│   ├── constants
│   │   └── AppConstants.java
│   └── security
│       ├── JwtTokenProvider.java
│       ├── SecurityUtils.java
│       └── UserDetailsServiceImpl.java
│
└── resources
    ├── messages.properties
    └── application.properties
```

## Arquitetura final

```bash
src/main/java/com/example/minishop
│
├── application
│ ├── dto
│ │ ├── AccountDTO.java
│ │ ├── ClientDTO.java
│ │ ├── OrderDTO.java
│ │ ├── PaymentDTO.java
│ │ └── ProductDTO.java
│ └── services
│ ├── AccountApplicationService.java
│ ├── ClientApplicationService.java
│ ├── OrderApplicationService.java
│ ├── PaymentApplicationService.java
│ └── ProductApplicationService.java
│
├── config
│ ├── AppConfig.java
│ ├── DatabaseConfig.java
│ ├── SecurityConfig.java
│ └── SwaggerConfig.java
│
├── domain
│ ├── account
│ │ ├── Account.java
│ │ ├── AccountRepository.java
│ │ └── AccountService.java
│ ├── client
│ │ ├── Client.java
│ │ ├── ClientRepository.java
│ │ └── ClientService.java
│ ├── order
│ │ ├── Order.java
│ │ ├── OrderRepository.java
│ │ └── OrderService.java
│ ├── payment
│ │ ├── Payment.java
│ │ ├── PaymentRepository.java
│ │ └── PaymentService.java
│ └── product
│ ├── Product.java
│ ├── ProductRepository.java
│ └── ProductService.java
│
├── infrastructure
│ ├── database
│ │ ├── AccountJpaRepository.java
│ │ ├── ClientJpaRepository.java
│ │ ├── OrderJpaRepository.java
│ │ ├── PaymentJpaRepository.java
│ │ └── ProductJpaRepository.java
│ ├── httpclient
│ │ ├── HttpClientService.java
│ │ └── HttpClientConfig.java
│ ├── logging
│ │ ├── LogService.java
│ │ └── LogFormatter.java
│ ├── messaging
│ │ └── MessageBroker.java
│ └── external
│ └── PaymentGateway.java
│
├── interfaces
│ ├── controllers
│ │ ├── AccountController.java
│ │ ├── ClientController.java
│ │ ├── OrderController.java
│ │ ├── PaymentController.java
│ │ └── ProductController.java
│ └── exceptions
│ └── CustomExceptionHandler.java
│
├── shared
│ ├── utils
│ │ ├── DateUtils.java
│ │ ├── StringUtils.java
│ │ └── ValidationUtils.java
│ ├── constants
│ │ └── AppConstants.java
│ └── security
│ ├── JwtTokenProvider.java
│ ├── SecurityUtils.java
│ └── UserDetailsServiceImpl.java
│
└── resources
├── messages.properties
└── application.properties
```

# Arquitetura da Aplicação

Esta arquitetura é uma implementação típica de uma aplicação Java usando o Spring ‘Framework’, seguindo o padrão de
arquitetura em camadas.

## 1. Camada de Apresentação (interfaces)

- **Responsabilidade**: Interagir com o usuário ou cliente, lidando com requisições HTTP e retornando respostas
  apropriadas.
- **Componentes**:
    - **Controladores (Controllers)**:
        - Exemplo: `ProductController`, `AccountController`
        - Recebem requisições do cliente, processam entradas e chamam os serviços apropriados.
    - **Manipuladores de Exceções**:
        - Exemplo: `CustomExceptionHandler`
        - Tratam exceções e retornam mensagens de erro apropriadas.

## 2. Camada de Aplicação (application)

- **Responsabilidade**: Orquestrar a lógica de negócios e a comunicação entre a camada de apresentação e a camada de
  domínio.
- **Componentes**:
    - **DTOs (Data Transfer Objects)**:
        - Exemplo: `ProductDTO`, `ClientDTO`
        - Usados para transferir dados entre a camada de apresentação e a camada de serviço.
    - **Serviços de Aplicação**:
        - Exemplo: `ProductApplicationService`, `AccountApplicationService`
        - Contêm a lógica de aplicação e interagem com os serviços de domínio.

## 3. Camada de Domínio (domain)

- **Responsabilidade**: Contém a lógica de negócios central da aplicação, definindo as entidades do domínio e as regras
  de negócio.
- **Componentes**:
    - **Entidades**:
        - Exemplo: `Product`, `Account`
        - Representam os objetos de domínio e contêm dados e comportamentos relacionados.
    - **Repositórios**:
        - Exemplo: `ProductRepository`
        - Definem as operações de persistência que podem ser realizadas nas entidades.
    - **Serviços de Domínio**:
        - Exemplo: `ProductService`
        - Contêm a lógica de negócios relacionada a uma entidade específica.

## 4. Camada de Infraestrutura (infrastructure)

- **Responsabilidade**: Fornecer implementações específicas de infraestrutura e serviços que suportam a aplicação.
- **Componentes**:
    - **Repositórios JPA**:
        - Exemplo: `ProductJpaRepository`
        - Fornecem a implementação concreta para operações de persistência usando Spring Data JPA.
    - **Serviços de Cliente HTTP**:
        - Exemplo: `HttpClientService`
        - Usados para fazer chamadas a APIs externas.
    - **Logging, Mensageria, etc.**:
        - Classes que lidam com logging, mensageria e outras funcionalidades de infraestrutura.

## 5. Camada de Configuração (config)

- **Responsabilidade**: Contém as configurações da aplicação, como configurações de banco de dados, segurança e
  documentação da API.
- **Componentes**:
    - **Classes de Configuração**:
        - Exemplo: `AppConfig`, `DatabaseConfig`, `SecurityConfig`
        - Definem como a aplicação deve se comportar e como os componentes devem ser configurados.

## 6. Camada Compartilhada (shared)

- **Responsabilidade**: Contém utilitários, constantes e classes de segurança que podem ser usadas em toda a aplicação.
- **Componentes**:
    - **Utilitários**:
        - Exemplo: `DateUtils`, `StringUtils`
        - Fornecem métodos utilitários que podem ser usados em várias partes da aplicação.
    - **Constantes**:
        - Classes que definem constantes usadas em toda a aplicação.
    - **Segurança**:
        - Exemplo: `JwtTokenProvider`, `UserDetailsServiceImpl`
        - Classes que lidam com segurança.

## Conclusão

Essa arquitetura em camadas promove uma separação clara de responsabilidades, facilitando a manutenção, escalabilidade e
testabilidade da aplicação. Cada camada tem um propósito específico e interage com as outras camadas de maneira
organizada, permitindo um desenvolvimento e manutenção mais eficientes.
