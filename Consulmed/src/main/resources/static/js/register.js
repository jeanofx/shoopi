// Call the dataTables jQuery plugin
$(document).ready(function() {

});
//function fecth
async function registerUser(){
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

  
   
  const request = await fetch('users/register', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)

  });
  alert("account was created successfully!");
  window.location.href = 'login.html'

}


