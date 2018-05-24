<?php

	//1- Passo - Realização da Solicitação Post

	$curl = curl_init();
	$request = '{
				"receiver_id": "034562f8-8880-4fc9-9a48-e9f24d57c0e5",
				"amount": 1000,
				"description": "Pagamento"
				}';

	curl_setopt($curl, CURLOPT_URL, 'https://kamba-api-staging.herokuapp.com/v1/transactions');
	curl_setopt($curl, CURLOPT_POST, true);
	curl_setopt($curl, CURLOPT_HTTPHEADER, ['content-type: application/json', 'authorization: Token 7p2RbUyWWCq34cLd8QJJFQtt']);
	curl_setopt($curl, CURLOPT_POSTFIELDS, $request);
	curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);

	$result = curl_exec($curl);
	$erro = curl_error($curl);

	if ($erro) {
		echo "Erro em CURL: " . $erro;
	}
	else
	{
		
		$response = json_decode($result, true);
		//print_r($response);
	}


	//2 - Passo - Apresentação dos detalhes do Pagamento

	echo "DETALHES DO PAGAMENTO";
	echo "<hr>";
	echo "Remetente: ".$response['from']['firstname']." ".$response['from']['lastname']."<br>";
	echo "Telemóvel: ".$response['from']['phone_number']."<br>";
	echo "E-mail: ".$response['from']['email']."<br>";
	echo "<hr>";
	
	echo "Destinatário: ".$response['to']['firstname']." ".$response['to']['lastname']."<br>";
	echo "Telemóvel: ".$response['to']['phone_number']."<br>";
	echo "E-mail: ".$response['to']['email']."<br>";
	echo "<hr>";

	echo "Montante: ".$response['amount']." Kz <br>";
	echo "Subtotal: ".$response['subtotal']." Kz <br>";
	echo "Tipo de Transição: ".$response['transaction_type']."<br>";
	echo "Descrição: ".$response['description']."<br>";
	echo "Estado: ".$response['status']."<br>";
	echo "Data e Hora: ".$response['created_at']."<br>";
	


	//3- Passo - Persistir os detalhes de Pagamento no Banco de Dados MYSQL

	try
	{
		$db = new PDO('mysql:host=localhost; dbname=kamba', 'root', '');
	}
	catch(PDOException $e)
	{
		echo $e;
	}

	$remetente = $response['from']['firstname']." ".$response['from']['lastname'];
	$destinatario = $response['to']['firstname']." ".$response['to']['lastname'];

	$query = "INSERT INTO detalhe_pagamentos(payer_id, payer_name, payer_phone_number, payer_email, receiver_id, receiver_name, receiver_phone_number, receiver_email, transaction_id, amount, subtotal, transaction_type, description, status, created_at) VALUES(:payer_id, :payer_name, :payer_phone_number, :payer_email, :receiver_id, :receiver_name, :receiver_phone_number, :receiver_email, :transaction_id, :amount, :subtotal, :transaction_type, :description, :status, :created_at)";
	$statement = $db->prepare($query);
	$statement->execute([
		'payer_id' => $response['from']['id'],
		'payer_name' => $remetente,
		'payer_phone_number' => $response['from']['phone_number'],
		'payer_email' => $response['from']['email'],
		'receiver_id' => $response['to']['id'],
		'receiver_name' => $destinatario,
		'receiver_phone_number' => $response['to']['phone_number'],
		'receiver_email' => $response['to']['email'],
		'transaction_id' => $response['id'],
		'amount' => $response['amount'],
		'subtotal' => $response['subtotal'],
		'transaction_type' => $response['transaction_type'],
		'description' => $response['description'],
		'status' => $response['status'],
		'created_at' => $response['created_at']
	]);
?>