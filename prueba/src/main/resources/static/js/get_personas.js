window.addEventListener('load', () => {
    (function() {
        const url = "/personas";
            const settings = {
                method: "GET"
            };

            fetch(url, settings)
            .then(response => response.json())
            .then(data => {

                let personasTable = document.getElementById("personaTable");
                for (persona of data) {
                    let insertedRow = personasTable.insertRow();
                    insertedRow.id = 'tr_' + persona.id;
                    insertedRow.innerHTML = `
                        <th class="td_id" scope="row">${persona.id}</th>
                        <td class="td_nombre">${persona.nombre}</td>
                        <td class="td_apellido">${persona.apellido}</td>
                        <td class="td_numeroDocumento">${persona.numeroDocumento}</td>
                        <td class="td_direccion">${persona.direccion}</td>
                        <td class="td_fechaIngreso">${persona.fechaIngreso}</td>
                        <td class="td_tipoDocumento">${persona.tipoDocumento.id}</td>
                        <td class="td_tipo">${persona.tipoDocumento.tipo}</td>
                        <td class="td_ciudad">${persona.ciudad.id}</td>
                        <td class="td_nombreCiudad">${persona.ciudad.nombre}</td>
                        <td class="td_botonAbrirModalActualizar">
                        <button
                        type="button"
                        class="btn btn-info"
                        data-bs-toggle="modal"
                        data-bs-target="#modalActualizar"
                        onclick="poblarFormulario('${persona.id}', '${persona.nombre}', '${persona.apellido}',
                         '${persona.numeroDocumento}', '${persona.direccion}', '${persona.fechaIngreso}',
                          '${persona.tipoDocumento.id}', '${persona.tipoDocumento.tipo}', '${persona.ciudad.id}',
                           '${persona.ciudad.nombre}')"
                        >
                        Actualizar
                        </button>
                        </td>
                        <td class="td_botonEliminar">
                        <button type="button" class="btn btn-danger" onclick="eliminar('${persona.id}')">Eliminar</button>
                        </td>
                    `;

                };

            })
            .catch(error => console.error("Error fetch: ", error));
    })();

});