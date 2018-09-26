
  var url ='https://kamba-api-staging.herokuapp.com/v1/users/activities';

	var bodyContent = document.querySelector('#bodyContent')
	function getContent(){
		fetch(url, {method:'GET',
      headers: {
        'Content-Type': 'application/json', 
        'authorization': 'Token VS7elyzN7ZqMNcQmQA5Cjgtt'
      } 

    })
		.then(res => res.json())
    .then(urlItems=>{
      
        for(let index of urlItems){
       

          bodyContent.innerHTML +=`


                <ul class="list-group">
                  <li class="list-group-item">id: ${index.id}</li>
                  <li class="list-group-item" >amount: ${index.amount}</li>
                  <li class="list-group-item">Subtotal: ${index.subtotal}</li>
                  <li class="list-group-item">fee: ${index.fee}</li>
                   <li class="list-group-item list-group-item-success ">bank account
                    <ul>
                      <li class="list-group-item">id: ${index.bank_account.id}</li>
                      <li class="list-group-item">number: ${index.bank_account.number}</li>
                      <li class="list-group-item">type of:${index.bank_account.type_of}</li>
                      <li class="list-group-item">holder:${index.bank_account.holder}</li>
                      <li class="list-group-item list-group-item-success">Bank
                        <ul>
                          <li class="list-group-item">id:${index.bank_account.bank.id}</li>
                          <li class="list-group-item">name:${index.bank_account.bank.name}</li>
                          <li class="list-group-item">description: ${index.bank_account.bank.description}</li>
                        </ul>
                      </li>
                      
                    </ul>
                  </li>
                  <li class="list-group-item">status: ${index.status}</li>
                  <li class="list-group-item">commited: ${index.committed}</li>
                  <li class="list-group-item">paid: ${index.paid}</li>
                  <li class="list-group-item">transaction_type: ${index.transaction_type}</li>
                  <li class="list-group-item">created_at: ${index.created_at}</li>
                  <li class="list-group-item">updated_at: ${index.updated_at}</li>
                  
                </ul>



                 
          `
        }
    })
   
}

//Function to post to database
/*var form = document.getElementById('form')
var notice = document.getElementById('notice');
form.addEventListener('submit', function(e){
  e.preventDefault();
  var formValues = new FormData(form);

  console.log(formValues)
  console.log(formValues.get('id'))
  console.log(formValues.get('amount'))

 fetch('controllers/post.php', {
    method: 'POST',
    body: formValues
  })

 .then( res => res.json())
 .then( data =>{
    console.log(data.get('id'))
     console.log(data.get('amount'))
      console.log(data.get('subtotal'))
    if (data ==='error') {
      notice.innerHTML = `
      <div class="alert alert-danger" role="alert">
           Prencher todos os campos!
          </div>
      `
    }else{
      notice.innerHTML = `
      <div class="alert alert-primary" role="alert">
           ${data}
          </div>
      `
    }
 })
})
    */ 
