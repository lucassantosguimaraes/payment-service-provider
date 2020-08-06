[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/guimaraes-lucas/payment-service-provider) 
[![Dependabot compatibility score](https://dependabot-badges.githubapp.com/badges/compatibility_score?dependency-name=lodash&package-manager=npm_and_yarn&previous-version=4.17.15&new-version=4.17.19)](https://help.github.com/articles/configuring-automated-security-fixes)

# O que é esse projeto?

Versão simplificada de um Payment Service Provider (PSP) como o Pagar.me, esse é o projeto de uma API RESTful feita em [Node](https://nodejs.org/en/) + [Express](https://expressjs.com) e que persiste transações.

# Instalação e execução

Existem duas maneiras de execução a primeira é utilizando o [Docker](https://docs.docker.com/docker-for-windows/install/), com o mesmo executando na maquina, utilize o seguinte comando:

```shell
./script/install.sh
```

A outra maneira é possuindo o banco de dados [PostgreSQL](https://www.postgresql.org/download/) intalado em uma maquina da rede e configurar devidamente os parâmentros/variáveis de ambiente, por exemplo:

```shell
NODE_ENV=production DB_HOST=localhost DB_PORT=5432 DB_USER=max DB_PASS=s3cr3t DB_NAME=example HOST=localhost PORT=3000 npm start
```

# Endpoints

Para testes da API é necessário que uma aplicação cliente que faça requisições aos *endpoints* da ferramenta ou mesmo uma aplicação como o [Postman](https://www.getpostman.com/downloads/) (uma ferramenta que tem como objetivo testar serviços RESTful (Web APIs) por meio do envio de requisições HTTP e da análise do seu retorno.). 

| Requisições                                  | Descrição                                                    |
| -------------------------------------------- | ------------------------------------------------------------ |
| GET `/api/transactions`                      | Retorna uma lista com todas as transações criadas.           |
| GET `/api/transactions/1`                    | Retorna uma transção específica de acordo com id passado.    |
| GET `/api/transactions/?limite=10&page=0`    | Retorna uma lista com limite de 10 de transações por página. |
| GET `/api/transactions/?limite=1&page='1=1'` | Retorna um erro em caso de tentativa de SQLInjection.        |
| POST `/api/transactions`                     | Cria uma transação e seu devido recebível.                   |
| GET `/api/payables`                          | Retorna uma lista com todos os recebíveis criados.           |
| GET `/api/payables/1`                        | Retorna um recebível específico de acordo com id passado.    |
| GET `/api/payables/?limite=10&page=0`        | Retorna uma lista com limite de 10 de recebíveis por página. |
| GET `/api/payables/?limite=1&page='1=1'`     | Retorna um erro em caso de tentativa de SQLInjection.        |

Exemplo de JSON para requisição POST `/api/transactions`:

```json
{
  "value": 850.5,
  "description": "Smartband XYZ 3.0",
  "paymentMethod": "credit_card",
  "cardNumber": "1234567812345678",
  "cardHolderName": "Fulano de Tal da Silva",
  "expirationDate": "2021-01-01",
  "cvv": "123"
}
```

**Importante**: O campo `"paymentMethod"` (Método de pagamento) é um só aceita os valores: `debit_card` ou `credit_card`.
