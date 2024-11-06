window.addEventListener('load', () => {
    (function() {
        const url = "/tipoDocumentos";
        const settings = {
            method: "GET"
        };

        fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            console.log("Información recibida: ", data);
            let selectTipoDocumento = document.getElementById("select-tipo-documento");
            if(selectTipoDocumento) {
                for (let tipoDocumento of data) {
                                let option = document.createElement("option");
                                option.value = tipoDocumento.id;
                                option.text = tipoDocumento.tipo;
                                selectTipoDocumento.appendChild(option);
                            }
            }
        })
        .catch(error => console.error("Fetch error: ", error));

    })();
});