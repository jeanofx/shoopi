// Call the dataTables jQuery plugin
$(document).ready(function () {
  loadUser();
  $('#dataTable').DataTable();
});
//function fecth
async function loadUser() {

  const request = await fetch('users', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const users = await request.json();

//'<a href="#"  onclick="deleteUser('+user.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
  let listhtml = '';
  for (let user of users) {
    let deleteButton = '  <div ><!-- Circle Buttons (Default) -->   <a href="#"  onclick="selecteUser('+user.id+')" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i> </a >  <a href="#"  onclick="deleteUser('+user.id+')" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i> </a>  </div > ';
    let userhtml = '<tr><td>' + user.id + '</td><td>' + user.name + '</td><td>' + user.last_name + '</td><td>' + user.email + '</td><td>' + user.phone + '</td><td>' + user.usertype + '</td><td>' + deleteButton + '</td></tr>';
    listhtml += userhtml;
  }
  document.querySelector('#dataTable tbody').outerHTML = listhtml;

}

async function deleteUser(id) {

  if (!confirm('Do you want delete this user?')) {
    return;
  }
  const request = await fetch('users/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  alert('El usuario ' + id + ' ha sido eliminado');

  location.reload();
}

async function selecteUser() {
  if (!confirm('Desea seleccionar al usuario?')){
   // window.location.href = 'update.html'
    return;
  }  

  // const request = await fetch('log', {
  //   method: 'GET',
  //   headers: {
  //     'Accept': 'application/json',
  //     'Content-Type': 'application/json'
  //   },
  //   body: JSON.stringify(datos)
  // });

  
  alert('Será redireccionado')
  window.location.href = 'update.html'
  }
