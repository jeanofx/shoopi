$(document).ready(function () {
    // on ready
});
 

async function startSesion() {
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.pass = document.getElementById('txtPassword').value;
  
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