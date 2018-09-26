<?php
session_start();
include_once 'model/connection.php'; //Connecting database

//Receiving data from form
$id = $_POST['id']];

$amount = filter_input(INPUT_POST, 'amount', FILTER_SANITIZE_NUMBER_INT);

$subtotal= filter_input(INPUT_POST, 'subtotal', FILTER_SANITIZE_NUMBER_INT);

$fee = filter_input(INPUT_POST, 'fee', FILTER_SANITIZE_NUMBER_INT);

$ba_id = $_POST['ba_id'];

$ba_number = filter_input(INPUT_POST, 'ba_number', FILTER_SANITIZE_NUMBER_INT);

$ba_type = filter_input(INPUT_POST, 'ba_type', FILTER_SANITIZE_SPECIAL_CHARS);

$ba_holder = filter_input(INPUT_POST, 'ba_holder', FILTER_SANITIZE_SPECIAL_CHARS);

$bank_id = $_POST['bank_id'];

$bank_name = filter_input(INPUT_POST, 'bank_name', FILTER_SANITIZE_SPECIAL_CHARS);

$bank_description = filter_input(INPUT_POST, 'bank_description', FILTER_SANITIZE_SPECIAL_CHARS);

$status = filter_input(INPUT_POST, 'status', FILTER_SANITIZE_SPECIAL_CHARS);

$commited = filter_input(INPUT_POST, 'commited', FILTER_SANITIZE_SPECIAL_CHARS);

$paid = filter_input(INPUT_POST, 'paid', FILTER_SANITIZE_SPECIAL_CHARS);

$transation_type = filter_input(INPUT_POST, 'transaction_type', FILTER_SANITIZE_SPECIAL_CHARS);

$created_at = $_POST['created_at'];

$updated_at = $_POST['updated_at'];

if ($id ==='' || $amount==='' || $subtotal ==='' || $fee ==='' || $ba_id ==='' || $ba_number ==='' || $ba_type ==='' || $ba_holder==='' || $bank_id==='' || $bank_name==='' || $bank_description==='' || $status==='' || $commited==='' || $paid==='' || $transation_type==='' ||$created_at==='' || $updated_at==='') {
	//Returning  Error  If field is Blank
	echo json_encode("error");
}else{

	echo json_encode("Activities <br> id: ".$id. '<br> Amount: '. $amount. '<br> Subtotal '.$subtotal. '<br>Fee:'.$fee. '<br>Bank Account Id:'.$ba_id. '<br> Bank Account Number:'.$ba_number.  '<br>Bank Account Type:'.$ba_type. '<br>Bank Account Holder:'.$ba_holder. '<br> Bank Id:'.$bank_id. '<br>Bank Name:'.$bank_name. '<br> Bank Description:'.$bank_description. '<br> Status: '.$status. '<br>Commited:'.$commited. '<br>Paid:'.$paid. '<br>Transaction Type: '.$transation_type. '<br>Created at:'.$created_at. '<br>Updated at:'.$updated_at );

//Persiting Data in a database (MySQL) 

	$queryInsert = $link->query("INSERT INTO tb_activities VALUES('$id', '$amount','$subtotal', '$fee', '$ba_id', '$ba_number', '$ba_type', '$ba_holder', '$bank_id', '$bank_name', '$bank_description', '$status', '$commited', '$paid','$transation_type', '$created_at', '$updated_at' )");

	$affected_rows = mysqli_affected_rows($link);

	if ($affected_rows > 0) {

		$_SESSION['msg'] = "<p class='green lighten-3 green-text text-darken-4 center'>". ' Dados inseridos com sucesso!'. "</p>";
		header("Location:../index.php");
	}

endif;
}

?>