#   Sistema de Reserva de Quartos usando RMI

Este projeto implementa um sistema de reserva de quartos utilizando Java RMI (Remote Method Invocation), permitindo a comunicação entre um cliente e um servidor para gerenciar as reservas de um hotel.

## Descrição do Sistema

O sistema oferece a possibilidade de listar os quartos disponíveis, reservar um quarto e visualizar os hóspedes registrados. As reservas são realizadas por tipo de quarto, e cada tipo possui uma quantidade limitada e um preço por noite.

Tipos de Quartos e Preços

Tipo 0: 10 quartos individuais - R$ 55,00 por noite

Tipo 1: 20 quartos duplos - R$ 75,00 por noite

Tipo 2: 5 quartos duplos (premium) - R$ 80,00 por noite

Tipo 3: 3 quartos triplos - R$ 150,00 por noite

Tipo 4: 2 quartos quádruplos - R$ 230,00 por noite



## Executando o Projeto

1. Compilar o projeto

Navegue até o diretório do projeto e execute

2. Iniciar o Servidor RMI

Primeiro, registre o serviço RMI:

rmiregistry 1099 &

Depois, execute o servidor:

java -cp target/classes HotelServer

3. Executar o Cliente

No cliente, você pode utilizar os seguintes comandos:


### Listar quartos disponíveis

java -cp target/classes HotelClient list localhost

#### Exemplo de saída:

10 quartos do tipo 0 estão disponíveis por 55 reais por noite

20 quartos do tipo 1 estão disponíveis por 75 reais por noite

5 quartos do tipo 2 estão disponíveis por 80 reais por noite

3 quartos do tipo 3 estão disponíveis por 150 reais por noite

2 quartos do tipo 4 estão disponíveis por 230 reais por noite

![image](https://github.com/user-attachments/assets/70f322c4-51d0-4e8b-aaec-8b67f2b2694b)


### Reservar um quarto

java -cp target/classes HotelClient book localhost 1 "João da Silva"

#### Saída esperada:

Reserva confirmada para João da Silva no quarto do tipo 1.

![image](https://github.com/user-attachments/assets/0d3caa8c-6892-42bb-b2a6-8f17ee49a0ae)

![image](https://github.com/user-attachments/assets/5d596744-403f-4d48-a4b9-e8105798e32c)


### Listar hóspedes

java -cp target/classes HotelClient clients localhost

#### Saída esperada:

Tipo de quarto 1: João

![image](https://github.com/user-attachments/assets/220a731e-9dbb-4530-adf3-adc535688852)

