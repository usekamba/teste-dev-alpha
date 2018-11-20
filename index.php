<?php 
//Inicio da classe CURL
$ch = curl_init();

//Declaração dos paramentros dp header
$headers = [
    'Authorization: Token ySJr21cFmVWMM7D33xRQAAtt',
    'Content-Type: application/json'
];

//Faz a busca do conteúdo da URL abaixo
curl_setopt($ch, CURLOPT_URL,"https://kamba-api-staging.herokuapp.com/v1/users/activities");

// Associa a solicitação o HEADER
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);

//Executa a solicitação
$ret = curl_exec($ch);

//Fecha a solicitação
curl_close($ch);

