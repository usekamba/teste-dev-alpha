<?php 

$utf8 = header("Content_Type: text/html; charset=8tf-8");
$link = new mysqli('localhost', 'root', '', 'db_activities');
$link->set_charset('utf8');


 ?>