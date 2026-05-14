🎵 Sistema de Streaming de Música

Sistema de streaming de música desenvolvido em Java com foco na aplicação dos principais conceitos de Programação Orientada a Objetos (POO), utilizando herança, interfaces, polimorfismo, encapsulamento e organização em pacotes.

🚀 Funcionalidades
Cadastro e gerenciamento de usuários Free e Premium
Sistema de login com troca de usuário durante a execução
Reprodução de músicas com comportamentos diferentes para cada tipo de usuário:
Usuário Free → reprodução com anúncios
Usuário Premium → reprodução sem anúncios
Criação e gerenciamento de playlists
Playlists automáticas
Playlists personalizadas
Sistema de downloads exclusivo para usuários Premium
Histórico de reprodução individual por usuário
Estatísticas e relatórios do sistema
Total de usuários
Quantidade de reproduções
Total de anúncios exibidos
📂 Estrutura do Projeto
src/
└── br/
    └── com/
        └── streaming/
            ├── modelo/
            │   ├── ItemReproducao.java
            │   ├── Musica.java
            │   ├── Playlist.java
            │   ├── PlaylistAutomatica.java
            │   ├── PlaylistPersonalizada.java
            │   ├── Usuario.java
            │   ├── UsuarioFree.java
            │   └── UsuarioPremium.java
            │
            ├── servico/
            │   ├── Reproduzivel.java
            │   ├── Baixavel.java
            │   └── GeradorRecomendacoes.java
            │
            ├── util/
            │   ├── FormatadorTempo.java
            │   └── Validador.java
            │
            └── principal/
                └── StreamingMusicaAluno.java
🧩 Interfaces Implementadas
Interface	Métodos	Implementada em
Reproduzivel	reproduzir(), pausar(), parar(), getDuracaoTotal()	Musica, Playlist
Baixavel	baixar(), removerDownload(), estaBaixada(), getTamanhoBaixados()	UsuarioPremium
🛠️ Classes Utilitárias
Classe	Responsabilidade
FormatadorTempo	Conversão de tempo para formatos como mm:ss e exibição formatada
Validador	Validação de email, nome, título e duração
GeradorRecomendacoes	Geração de recomendações com base no histórico do usuário
📚 Conceitos de POO Aplicados
🔒 Encapsulamento

Utilização de atributos privados/protected com acesso controlado por getters e setters.

🧬 Herança
UsuarioFree e UsuarioPremium herdam de Usuario
PlaylistAutomatica e PlaylistPersonalizada herdam de Playlist
🔄 Polimorfismo

Sobrescrita de métodos e tratamento uniforme de usuários através de listas polimórficas.

📑 Interfaces

As interfaces Reproduzivel e Baixavel definem contratos de comportamento para diferentes classes.

🧱 Classes Abstratas

Uso de classes base para especializações de playlists e itens de reprodução.

✅ Sobrescrita de Métodos

Utilização da anotação @Override para sobrescrita explícita de métodos.

▶️ Como Executar
Pré-requisitos
Java JDK 11 ou superior
Compilação
javac -d out src/br/com/streaming/servico/*.java src/br/com/streaming/modelo/*.java src/br/com/streaming/principal/*.java
Execução
java -cp out br.com.streaming.principal.StreamingMusicaAluno
👩‍💻 Autora
Mariana Moreira Barbosa
RA: 42880726
📌 Histórico de Checkpoints
Checkpoint	Conteúdo
CP1	Fundamentos de Java — variáveis, tipos e operadores
CP2	Estruturas de controle — if, switch e loops
CP3	Orientação a Objetos — classes, objetos e construtores
CP4	Herança e polimorfismo
CP5	Coleções e tratamento de exceções
CP6	Interfaces, pacotes e finalização do sistema
