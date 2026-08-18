


Este projeto consiste em uma versão simplificada da plataforma Airbnb, desenvolvida como parte da avaliação da faculdade. O objetivo principal é aplicar conceitos fundamentais do desenvolvimento em Java, tais 
como Orientação a Objetos (POO), gerenciamento de dados e estrutura de software.

O sistema permite o cadastro e gerenciamento de usuários (anfitriões e hóspedes), acomodações e o fluxo completo de reserva de estadias.


uncionalidades

Usuários
- Cadastro e login de usuários (Hóspede / Anfitrião).
- Edição de perfil e informações pessoais.

Acomodações
- Cadastro de acomodações (anfitriões).
- Listagem e busca de imóveis disponíveis.
- Detalhes do imóvel (preço por noite, localização, capacidade, descrição).

Reservas
- Solicitação de reserva informando data de check-in e check-out.
- Cálculo automático do valor total da estadia.
- Confirmação ou cancelamento de reservas.

---

 Tecnologias Utilizadas

- Linguagem: Java (versão 17+)
- Paradigma: Orientação a Objetos (POO)
- Banco de Dados 
- Gerenciador de Dependências

---

 Conceitos de POO Aplicados

- **Abstração:** Modelagem das entidades centrais (`Usuario`, `Acomodacao`, `Reserva`).
- **Encapsulamento:** Uso de atributos privados com *getters* e *setters* para proteção dos dados.
- **Herança:** Especialização de tipos de usuários (ex: `Hospede` e `Anfitriao` herdando de `Usuario`).
- **Polimorfismo:** Métodos sobrescritos para regras de cálculo específicas (ex: descontos por longa estadia).

-

