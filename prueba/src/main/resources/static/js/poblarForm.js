function poblarFormulario(id, nombre, apellido, numeroDocumento, direccion, fechaIngreso,
          tipoDocumento, tipo, ciudad, nombreCiudad) {
          document.querySelector("#inputId").value = id;
          document.querySelector("#inputNombre").value = nombre;
          document.querySelector("#inputApellido").value = apellido;
          document.querySelector("#inputNumeroDocumento").value = numeroDocumento;
          document.querySelector("#inputDireccion").value = direccion;
          document.querySelector("#inputFechaIngreso").value = fechaIngreso;
          document.querySelector("#select-tipo-documento").value = tipoDocumento;
          document.querySelector("#inputTipo").value = tipo;
          document.querySelector("#inputNombreCiudad").value = nombreCiudad;
}

