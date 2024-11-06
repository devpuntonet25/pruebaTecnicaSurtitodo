window.addEventListener('load', () => {
    let formularioGuardarPersona = document.querySelector("#form-guardar-persona");

    formularioGuardarPersona.addEventListener('submit', (event) => {
        event.preventDefault();

        const formData = {
                             "nombre": document.querySelector("#inputNombre").value,
                             "apellido": document.querySelector("#inputApellido").value,
                             "numeroDocumento": document.querySelector("#inputNumeroDocumento").value,
                             "direccion": document.querySelector("#inputDireccion").value,
                             "fechaIngreso": document.querySelector("#inputFechaIngreso").value,
                             "tipoDocumento": {
                                 "id": document.querySelector("#select-tipo-documento").value
                             },
                             "ciudad": {
                                 "id": document.querySelector("#select-ciudad").value
                             }
                         };

        const url = "/personas";

        const settings = {
            method: "POST",
            headers: {
                "Content-Type":"application/json"
            },
            body:JSON.stringify(formData)
        };

        fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let alertResponseDiv = document.querySelector("#alert-response");
            if (data != null) {
                alertResponseDiv.innerHTML = `
                    <div class="alert alert-success" role="alert">
                      Se ha guardado la persona ${formData.nombre} ${formData.apellido}
                      con número de documento ${formData.numeroDocumento} de forma exitosa.
                      Haga click <a href="/listarPersonas.html" class="alert-link">aquí</a> para ver los cambios.
                    </div>
                `;
            } else {
                alertResponseDiv.innerHTML = `
                     <div class="alert alert-danger" role="alert">
                       No se guardó la persona ${formData.nombre} ${formData.apellido}
                       con número de documento ${formData.numeroDocumento}.
                     </div>
                `;
            }

            alertResponseDiv.style.display = 'block';
        })
        .catch(error => console.log("Fetch error: ", error));

    });
});