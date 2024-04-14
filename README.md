## Sistema de Gerenciamento de Academia em Java POO

**Descrição:**

Este projeto implementa um sistema de gerenciamento de academia em Java POO, para a Residência em TIC/Software do Serratec,simulando o funcionamento de uma academia real. 
O sistema permite o cadastro de alunos, personal trainers, planos e a gestão de agendamentos, avaliações físicas e relatórios.

**Funcionalidades:**

* **Cadastro:**
    * `Alunos`: nome, CPF, data de nascimento, contato, senha, plano contratado, data de matrícula e avaliações físicas.
    * `Personal Trainers`: nome, CPF, data de nascimento, contato, senha, especialidade, CREF e horário de atendimento.
    * `Funcionários`: nome, CPF, data de nascimento, contato, senha, cargo (atendente, gerente, etc.).
    * `Planos`: nome, duração, valor, descrição (musculação, natação, etc.).
* **Agendamento:**
    * Data, horário, aluno e personal trainer.
    * Status (confirmada, cancelada, etc.).
* **Avaliação Física:**
    * Aluno, data, personal trainer e descrição.
* **Relatórios:**
    * Planos.
    * Alunos.
    * Equipe (funcionários e personal trainers).
    * Avaliações físicas por período.
* **Gerenciamento de Usuários:**
    * Login com CPF e senha.
    * Menus específicos para alunos, personal trainers e funcionários.
* **Tratamento de Erros:**
    * Implementação de tratamento de erros personalizado para garantir a robustez do sistema.
* **Armazenamento de Dados:**
    * Todas as informações estão registradas em arquivos de texto de saída.

**Instalação e Execução:**

1. Clone o repositório para o seu diretório local.
2. Compile o código Java utilizando um compilador Java.
3. Execute a classe principal `Programa`, no package `Principal`.
4. Siga as instruções no menu interativo para utilizar as funcionalidades do sistema.
5. As informações de cpf e senha estão nos arquivos .txt

**Observações:**

* Para populagem com dados reais, é necessário implementar a leitura de um arquivo de texto personalizado.
* O sistema pode ser expandido com novas funcionalidades e aprimoramentos de acordo com as necessidades.

**Tecnologias Utilizadas:**

* Java POO
* Manipulação de arquivos
* Menus interativos

**Autores:**

* Cassio Vaz Penha
* Emanuel Fonseca Rodrigues Silvério
* Enzo Laffront Rocha Miranda
* Giovanne Moreira Holanda
* João Pedro Soares De Brito
* Raphael Vivarini Damico

**Licença:**

Este projeto está licenciado sob a licença MIT: [https://choosealicense.com/licenses/mit/](https://choosealicense.com/licenses/mit/).

**Contribuições:**

Sinta-se à vontade para contribuir com este projeto através de pull requests, issues ou sugestões.

**Agradecimentos:**

Agradecemos a todos que contribuíram para o desenvolvimento deste projeto.
