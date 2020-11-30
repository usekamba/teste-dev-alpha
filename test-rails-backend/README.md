![Kamba](app-logo.png)

# Teste Alpha - Devs 

**Backend Demo** [HerokuApp](https://kamba-test-rails.herokuapp.com/api/v1/kambas)

**Dev Web Fullstack:** A solução deve ser implementada usando qualquer linguagem de programação server-side como **PHP, Ruby On Rails (ganha mais pontos) ou Java**. A solução deve ser implementada usando algum Framework JavaScript como **Angular, React, Vue**, entre outros no lado do Cliente. Frameworks no Layout também são permitidos, Bootstrap, Zurb, entre outros.

## API

URL Base a ser usada no Teste:
- Testes: GET `https://kamba-api-staging.herokuapp.com/v1/users/activities`

Deve passar parâmetros ao Header da Solicitação GET. Por exemplo:

A solicitação **HTTP GET** deve fornecer um Header `Authorization: Token TOKEN_ENVIADO_PELA_KAMBA_PARA_O_DEV` e `Content-Type: application/json`. O corpo da solicitação e resposta são codificadas em JSON. Para receber o seu TOKEN de autorização para realizar o teste envie e-mail com assunto **TOKEN API KAMBA PARA DEV CANDIDATO**

A URL a seguir mostra a listagem de resultados das atividades de transações de um Usuário em formato JSON que você precisará exibir em uma lista e em seguida poder selectionar um item da lista para mostrar sua informação individual.

**Realizar o `GET` para `https://kamba-api-staging.herokuapp.com/v1/users/activities` retorna:**
```json
[
    {
        "id": "KB-a47438-d579-459c-9e8c-086c8397ff4b",
        "amount": 2500,
        "subtotal": 2500,
        "fee": 0,
        "bank_account": {
            "id": "KB-6b6b2-d379-459b-8567-4726a2b10f59",
            "number": "124543464",
            "type_of": "Conta corrente",
            "holder": "Amarildo Lucas",
            "bank": {
                "id": "KB-78737-2205-4142-8a96-efd3bd1c98ba",
                "name": "BFA - Banco de Fomento Angola",
                "description": "Disponível em até 48 horas úteis"
            }
        },
        "status": "CREATED",
        "committed": false,
        "paid": false,
        "transaction_type": "WITHDRAWAL",
        "created_at": "2018-09-16T16:09:58.590Z",
        "updated_at": "2018-09-16T16:09:58.593Z"
    },
    {
        "id": "KB-5d7aa-5a81-47d2-b36e-cbd4a586b14d",
        "amount": 2500,
        "payment_method": {
            "id": "KB-61d7e-c9de-4fd5-aacd-d68d4678b7af",
            "name": "Depósito Bancário",
            "description": "Disponível em até 72 horas úteis"
        },
        "company_bank_account": {
            "id": "KB-3b60a-235b-4af9-a74e-2280c81b0f42",
            "iban": "AO06004000008555704410186",
            "number": "1231111110",
            "type_of": "Conta Empresa",
            "holder": "USEKAMBA, LDA.",
            "bank": {
                "id": "KB-4262c-c62b-4b14-92e7-7d3de7e2e422",
                "name": "Banco Millennium Angola",
                "description": "Disponível em até 48 horas úteis"
            }
        },
        "status": "WAITING",
        "created_at": "2018-09-16T16:09:47.664Z",
        "transaction_type": "DEPOSIT"
    },
    {
        "id": "KB-a6a9a-155d-4b14-861f-6408150af0d2",
        "tv_card_number": "123465124345",
        "tv_operator_recharge_card_id": "KB-f7814-da15-4ae8-b7e6-fb6f6476ff4e",
        "recharge_code": "143256865768",
        "status": "RECHARGED",
        "transaction_id": "KB-905b7-1909-418a-9e98-573da794f9d9",
        "transaction_type": "TVRECHARGE",
        "operator_name": "Zap TV",
        "operator_logo_url": "https://s3-sa-east-1.amazonaws.com/kamba-images/tv-recharge-operators/ZapLogo.png",
        "operator_type": "ZAP",
        "plan_name": "ZAP Mini",
        "price": 2200,
        "validity": 30,
        "number_of_channels": 45,
        "recharged_at": "2018-09-16T16:09:21.717Z"
    },
    {
        "id": "KB-905b7-1909-418a-9e98-573da794f9d9",
        "intent": "PAY_MERCHANT",
        "amount": 2200,
        "subtotal": 2200,
        "fee": 0,
        "from": {
            "id": "KB-99a99-2baf-447b-b595-f9e528784595",
            "firstname": "Amarildo",
            "lastname": "Lucas",
            "phone_number": "924426615",
            "email": "vmarildo@gmail.com"
        },
        "to": {
            "id": "KB-562f8-8880-4fc9-9a48-e9f24d57c0e5",
            "firstname": "Kamba",
            "lastname": "Pagamentos",
            "phone_number": "925426615",
            "email": "usekamba@gmail.com"
        },
        "description": "Recarga Zap TV de 2200 Kz&#x2F;30 dias",
        "transaction_type": "PAYMENT",
        "status": "PAID",
        "created_at": "2018-09-16T16:09:21.589Z",
        "reference_checkout": null,
        "reference_recharge": null
    }
]
```

## :computer: Tecnologias

Esse projeto foi desenvolvido utilizando:
- [Ruby on Rails](https://rubyonrails.org/)
- [PostgreSQL](https://www.postgresql.org/)

## :rocket: Como Executar a Aplicação

- Faça um `git clone` do repositório;
- Instale todas ruby gems rodando no terminal o comando `bundle install`;<br>
- Configure o arquivo `database.yml` no diretório `config` na raíz do projecto;<br>
- Rode os seguintes comandos
    - `rails db:prepare`;
    - `rails s`
- Acesse a URL `localhost:3000/api/v1/kambas`;
- Divirta-se :smile:

## Para executar os testes

- Basta rodar o comando `rspec` no terminal;
