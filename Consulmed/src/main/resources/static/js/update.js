// Call the dataTables jQuery plugin
$(document).ready(function() {

});
//function fecth
async function updateUser(){
  window.location.href = 'update.html'
  let data = {};
  data.name = document.getElementById('txtname').value;
  data.last_name = document.getElementById('txtLastName').value;
  data.email = document.getElementById('txtEmail').value;
  data.phone = document.getElementById('txtPhone').value;
  data.usertype = document.getElementById('txtType').value;
  data.pass = document.getElementById('txtPassword').value;

  let repeatPass = document.getElementById('txtRepeatPassword').value;

  if (repeatPass != data.pass){
      alert('Your Password do not match!');
      return;
  }

  
async function updateby(id){

  if (!confirm('Desea eliminar este usuario?')){
    return;
  }  
   
  const request = await fetch('users/update/' +id, {
    method: 'PUT',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)

  });
  alert("account was created successfully!");
  window.location.href = 'users.html'
  }
}

async function selecteUser() {
  if (!confirm('Do you want delete this user?')){
    return;
  }  

  const request = await fetch('log', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const respuesta = await request.text();
  if (respuesta != 'FAIL') {
    localStorage.token = respuesta;
    localStorage.email = datos.email;
    alert('datos correctos')
    window.location.href = 'home.html'
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }

}