window.addEventListener('load', () => {
    let btnActualizarPersona = document.getElementById("btn-actualizar-persona");

    btnActualizarPersona.addEventListener('click', () => {
        const formData = {
                  id: document.querySelector("#inputId").value,
                  nombre: document.querySelector("#inputNombre").value,
                  apellido: document.querySelector("#inputApellido").value,
                  numeroDocumento: document.querySelector("#inputNumeroDocumento").value,
                  direccion: document.querySelector("#inputDireccion").value,
                  fechaIngreso: document.querySelector("#inputFechaIngreso").value,
                  tipoDocumento: {
                        id: document.querySelector("#select-tipo-documento").value,
                        tipo: document.querySelector("#inputTipo").value
                  },
                  ciudad: {
                        id: document.querySelector("#select-ciudad").value,
                        nombre: document.querySelector("#inputNombreCiudad").value
                  }
        };

        const url = "/personas";
        const settings = {
            method: "PUT",
            headers: {
                "Content-Type":"Application/json",
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
        .then(response => response.json())
        .then(data => {

            let alertResponse = document.getElementById("alert-response");

            if (data != null) {
                let rowToUpdate = document.getElementById("tr_" + formData.id)

                if (rowToUpdate) {
                    rowToUpdate.querySelector(".td_nombre").textContent = formData.nombre;
                    rowToUpdate.querySelector(".td_apellido").textContent = formData.apellido;
                    rowToUpdate.querySelector(".td_numeroDocumento").textContent = formData.numeroDocumento;
                    rowToUpdate.querySelector(".td_direccion").textContent = formData.direccion;
                    rowToUpdate.querySelector(".td_fechaIngreso").textContent = formData.fechaIngreso;
                    rowToUpdate.querySelector(".td_tipoDocumento").textContent = formData.tipoDocumento.id;
                    rowToUpdate.querySelector(".td_tipo").textContent = formData.tipoDocumento.tipo;
                    rowToUpdate.querySelector(".td_ciudad").textContent = formData.ciudad.id;
                    rowToUpdate.querySelector(".td_nombreCiudad").textContent = formData.ciudad.nombre;
                }

                alertResponse.innerHTML = `
                    <div class="alert alert-success" role="alert">
                      Se ha actualizado la persona con número de documento ${formData.numeroDocumento}
                    </div>
                `;

            } else {
                alertResponse.innerHTML = `
                                    <div class="alert alert-danger" role="alert">
                                      No se ha actualizado la persona con número de documento ${formData.numeroDocumento}
                                    </div>
                                `;
            }
        });

    });
});