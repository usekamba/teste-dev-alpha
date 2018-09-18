![Kamba](app-logo.png)

# Teste Alpha - Devs 

## Dev Mobile Android ou iOS, Dev Web Front-end, Dev Web Fullstack (Ruby On Rails/PHP/Java)
O teste deve ser realizado em uma destas linguagens/plataformas **Android (Java/Kotlin ganha mais pontos), iOS (Swift, porque vocês são raros em Angola?/ganha mais pontos só de aparecer aqui), Ruby On Rails (Web Fullstack/ganha mais pontos), PHP** ou qualquer outro Framework JavaScript como **Angular, React, Vue**, etc., a escolha reflete apenas em estar nas categorias **Mobile, Front-end, Web Fullstack (Ruby On Rails)**.

O Candidato deve fazer um ***Fork*** deste repositório e submeter um ***Pull Request***, **com o seu nome, contacto telefónico e e-mail na descrição** para nossa avaliação.

**Dev Mobile Android ou iOS:** A solução deve ser implementada usando Android (Kotlin ganha mais pontos/Java) ou iOS apenas. Deve possuir Telas UI/UX mostrando os resultados das solicitações HTTP.

**Dev Web Fullstack:** A solução deve ser implementada usando qualquer linguagem de programação server-side como **PHP, Ruby On Rails (ganha mais pontos) ou Java**. A solução deve ser implementada usando algum Framework JavaScript como **Angular, React, Vue**, entre outros no lado do Cliente. Frameworks no Layout também são permitidos, Bootstrap, Zurb, entre outros.

## API

URL Base a ser usada no Teste:
- Testes: GET `https://kamba-api-staging.herokuapp.com/v1/activities`

Deve passar parâmetros ao Header da Solicitação GET. Por exemplo:

A solicitação **HTTP GET** deve fornecer um Header `Authorization: Token TOKEN_ENVIADO_PELA_KAMBA_PARA_O_DEV` e `Content-Type: application/json`. O corpo da solicitação e resposta são codificadas em JSON. Para receber o seu TOKEN de autorização para realizar o teste envie e-mail com assunto **TOKEN API KAMBA PARA DEV CANDIDATO**

A URL a seguir mostra a listagem de resultados das atividades de transações de um Usuário em formato JSON que você precisará exibir em uma lista e em seguida poder selectionar um item da lista para mostrar sua informação individual.

**Realizar o `GET` para `https://kamba-api-staging.herokuapp.com/v1/activities` retorna:**
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

**OBS:** Não esqueça dos parâmetros no `HTTP Header`, sem eles, nada irá funcionar como esperado. Sua chave de API é `Authorization: Token CHAVE_SOLICITADA_PARA_KAMBA_VIA_EMAIL`. Contacte o suporte@usekamba.com.

Se eles não estiverem bem configurados você receberá um erro de autorização:
```
{
    "errors": {
        "message": "token não autorizado",
        "code": "unauthorized"
    }
}
```

**Ou:**
```
{
    "status": 500,
    "error": "Internal Server Error"
}
```

## Estado HTTP e códigos de erro
Parâmetros | Descrição
--------- | -----------
400 | Transferência falhou
403 | Chave de API não autorizada
422 | Erros de validação
ETC | Mais códigos poderão ser retornados

## Requisitos
- Fazer fork desse repositório e criar o seu projeto (ou workspace) usando a sua versão desse repositório, tão logo acabe o teste, submeta um pull request, não envie por e-mail ou ficheiro .zip. Controle de versão faz parte do teste. **Boas práticas! :)**
- Faça solicitações assíncronas para a API e retorne um log dos dados recebidos.
- Ler o resultado do JSON e colocar numa lista chamada **Activities**.
- Exibir os itens de **Activities** numa lista com UI. Cada item vai representar uma transação que deve mostrar seus dados na tela seguinte. Tenha atenção em relação ao `transaction_type`. Você entenderá!
- Ganha mais pontos se tiver testes para o código que você criou.


## Critério de avaliação
- Organização do código, separação de módulos, view e model, back-end e front-end.
- Conter README que explica de forma resumida qual é o problema e como executar a aplicação?
- A aplicação está faz o que é esperado. Se tem algo faltando, o README explica o porquê.
- Legibilidade do código (incluindo comentários)
- Ganha mais pontos se tiver cobertura de testes (Não esperamos cobertura completa)
- Histórico de commits (estrutura e qualidade)
- UX. A interface é de fácil uso e auto-explicativa. 
- A escolha das bibliotecas, banco de dados, arquitetura, etc, é a melhor escolha para a aplicação.

## Dúvidas
Quaisquer dúvidas consulte as issues para ver se outro Dev já não a fez e caso você não ache sua resposta, abra você mesmo uma nova issue!

```
O ideal para o nosso TIME é o Soldado da Frente que não se deixa esconder por traz das trincheiras por medo dos Desafios no Campo de Batalha. O que encoraja outros Soldados à seguirem para Frente de Combate. Não existe um General! Os Soldados vivem em União.

Aqui você é livre para Transformar!
```

Boa sorte! Nosso TIME te aguarda... 👍


![Boraaa!!!](https://media.giphy.com/media/ZVik7pBtu9dNS/giphy.gif)
