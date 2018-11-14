![Kamba](app-logo.png)

Hernani Neto
00244996896371
hernaniprogramacao@gmail.com

# Teste Kamba Intern - Devs Mobile, Frontend, Web
O teste deve ser realizado em **Android, iOS** ou qualquer outro Framework JavaScript como **Angular, React, Vue**, etc., a escolha reflete apenas em estar nas categorias **Mobile, Frontend e Web**.

O Candidato deve fazer um ***Fork*** deste repositório e solicitar um ***Pull Request***, **com o seu nome, contacto telefónico e e-mail na descrição**, para nossa avaliação.

**Dev Mobile:** A solução deve ser implementada usando Android ou iOS apenas. Deve possuir Telas UI.

**Dev Backend:** A solução deve ser implementada usando qualquer linguagem de programação Server-Side como **PHP, Ruby, Java, C# entre outras**. Os resultados podem ser na Consola, Browser ou Terminal sem a necessidade de UI. 

**Dev Frontend/Web:** A solução deve ser implementada usando um Framework JavaScript como **Angular, React, Vue**, entre outros. Frameworks no Layout também são permitidos, Bootstrap, Zurb, entre outros.

## URL Base a ser usada no Teste:
- Testes: `https://kamba-api-staging.herokuapp.com/v1/transactions`
- Solicitação HTTP POST

Deve passar parâmetros ao Header da Solicitação POST. Por exemplo:

```
    -H "Content-Type: application/json" \
    -H "Authorization: Token 7p2RbUyWWCq34cLd8QJJFQtt" \
    -d '{
        "foo_bar": "foobar"
    }'
```

A solicitação **HTTP POST** deve fornecer um Header `Authorization: Token 7p2RbUyWWCq34cLd8QJJFQtt` e `Content-Type: application/json`. O corpo da solicitação e resposta são codificadas em JSON.


## Transações

Uma transação representa o envio de dinheiro entre um remetente `payer` para um destinatário `receiver`. O Identificador de uma transação criada com sucesso pertence a ambas entidades. O Identificador do remetente `receiver` pode pertencer à um **Cliente Wallet** ou à um **Comerciante**.


### Modelo de Dados para Enviar no POST 

| Parâmetro | Descrição
--------- | -----------
| amount | Valor monetário da transação
| receiver_id |	Identificador único do Destinatário (encontrar Identificador abaixo)
| description	| Descrição ou mensagem na Transação

**Realizar o `POST` para `https://kamba-api-staging.herokuapp.com/v1/transactions com os seguintes atributos:**
```json
{
	"receiver_id": "034562f8-8880-4fc9-9a48-e9f24d57c0e5",
	"amount": 1000,
	"description": "Pagamento"
}
```

**OBS:** Não esqueça dos parâmetros no `HTTP Header`, sem eles, nada irá funcionar como esperado. Sua chave de API é `Authorization: Token 7p2RbUyWWCq34cLd8QJJFQtt`.

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

> Exemplo do Objeto JSON retornado após uma **Transação bem sucedida**.

```json
{
    "id": "42dd4e95-2a3c-496a-97bb-57aa58f72f9f",
    "intent": "PAY_MERCHANT",
    "amount": 1000,
    "subtotal": 1000,
    "fee": 0,
    "from": {
        "id": "b2904b19-91d3-4fd1-ae0f-06ec63474bcb",
        "firstname": "Alexandre",
        "lastname": "Juca",
        "phone_number": "995582822",
        "email": "corextechnologies@gmail.com"
    },
    "to": {
        "id": "034562f8-8880-4fc9-9a48-e9f24d57c0e5",
        "firstname": "Kamba",
        "lastname": "Pagamentos",
        "phone_number": "934426615",
        "email": "usekamba@gmail.com"
    },
    "description": "Pagamento",
    "transaction_type": "PAYMENT",
    "status": "PAID",
    "created_at": "2018-05-16T13:01:02.706Z"
}
```

## Use o JSON retornado para mostrar uma outra Tela com os Detalhes do Pagamento. Aqui você pode persistir em um Banco de Dado se quiser, ou faça apenas um Print do seu Resultado para posterior Avaliação.

**Nota:** Faça sempre uma captura de tela/*printscreen* ao atingir uma meta do Teste com sucesso.


## Estado HTTP e códigos de erro
Parâmetros | Descrição
--------- | -----------
400 | Transferência falhou
403 | Chave de API não autorizada
422 | Erros de validação
ETC | Mais códigos poderão ser retornados

# Para a solicitação POST use sempre um `HTTP Header` com *Authorization*: `Token 7p2RbUyWWCq34cLd8QJJFQtt`.

Após retornar a Transação bem sucedida deves usar o Identidicador `id` da Transação para mostrar os dados. Novamente, faça sempre uma captura de tela/*printscreen* ao atingir uma meta do Teste com sucesso.


```
O ideal para o nosso TIME é o Soldado da Frente que não se deixa esconder por traz das trincheiras por medo dos Desafios no Campo de Batalha. O que encoraja outros Soldados à seguirem para Frente de Combate. Não existe um General! Os Soldados vivem em União.

Aqui você é livre para Transformar!
```

Boa sorte! Nosso TIME te aguarda... 👍
