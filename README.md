# 🎵 Sistema de Streaming de Música

Sistema de streaming de música desenvolvido em Java, aplicando os conceitos de Programação Orientada a Objetos (POO) com interfaces, herança, polimorfismo e encapsulamento.

## Funcionalidades

**Cadastro e gerenciamento de usuários** — criação de contas Free e Premium
**Sistema de login** — troca de usuário logado durante a execução
**Reprodução de músicas** — com comportamento diferente para Free (com anúncios) e Premium (sem anúncios)
**Sistema de playlists** — playlists automáticas (Top, Recentes, Recomendadas) e personalizadas
**Sistema de downloads** — exclusivo para usuários Premium, com baixar, remover e listar músicas
**Histórico de reprodução** — cada usuário mantém seu histórico de músicas ouvidas
**Estatísticas e relatórios**— total de usuários, reproduções por tipo e anúncios exibidos


## Arquitetura
**Pacotes**

Pacotes
src/
└── br/
    └── com/
        └── streaming/
            ├── modelo/         → Classes de domínio (entidades)
            │   ├── ItemReproducao.java      (classe abstrata)
            │   ├── Musica.java
            │   ├── Playlist.java
            │   ├── PlaylistAutomatica.java
            │   ├── PlaylistPersonalizada.java
            │   ├── Usuario.java
            │   ├── UsuarioFree.java
            │   └── UsuarioPremium.java
            ├── servico/        → Interfaces e serviços de comportamento
            │   ├── Reproduzivel.java        (interface)
            │   ├── Baixavel.java            (interface)
            │   └── GeradorRecomendacoes.java
            ├── util/           → Classes utilitárias
            │   ├── FormatadorTempo.java
            │   └── Validador.java
            └── principal/      → Ponto de entrada
                └── StreamingMusicaAluno.java
                └── README.md


##  Interfaces implementadas
Interface            Métodos                                                            Implementada em
Reproduzivel        reproduzir(), pausar(), parar(), getDuracaoTotal()                  Musica, Playlist
Baixavel            baixar(), removerDownload(), estaBaixada(), getTamanhoBaixados()    UsuarioPremium


## Classes utilitárias
Classe                    Responsabilidade
FormatadorTempo           Converte segundos para mm:ss, por extenso e formato de playlist
Validador                 Valida email, nome, título e duração com tratamento de exceções
GeradorRecomendacoes      Sugere músicas não ouvidas com base no histórico do usuário



## Conceitos de POO aplicados

*Encapsulamento* — atributos privados/protected com getters
*Herança* — UsuarioFree e UsuarioPremium estendem Usuario; PlaylistAutomatica e PlaylistPersonalizada estendem Playlist
*Polimorfismo* — reproduzirMusica() sobrescrito nas subclasses; lista de Usuario trata Free e Premium de forma uniforme
*Interfaces* — Reproduzivel e Baixavel definem contratos de comportamento
*Classes abstratas* — hierarquia de Playlist como base para especializações
*@Override* — métodos sobrescritos explicitamente marcados


## Como Executar
Pré-requisitos

Java JDK 11 ou superior

##  Compilação

bash# A partir da raiz do projeto
javac -d out src/br/com/streaming/servico/*.java src/br/com/streaming/modelo/*.java src/br/com/streaming/principal/*.java

## Execução
bashjava -cp out br.com.streaming.principal.StreamingMusicaAluno


## Autor

Nome: Mariana Moreira Barbosa
RA: 42880726


## Histórico de Checkpoints 
**Checkpoint**  **Conteúdo**
CP 1          Fundamentos de Java — variáveis, tipos, operadores
CP 2          Estruturas de controle — if, switch, loops
CP 3          Orientação a Objetos — classes, objetos, construtores
CP 4          Herança e polimorfismo
CP 5          Coleções e tratamento de exceções
CP 6          Interfaces, pacotes e finalização do sistema
