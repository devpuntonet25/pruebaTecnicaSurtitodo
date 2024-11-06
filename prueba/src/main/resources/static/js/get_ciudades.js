window.addEventListener('load', () => {
    (function() {
        const url = "/ciudades";
        const settings = {
            method: "GET"
        };

        fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let selectCiudades = document.querySelector("#select-ciudad");

            if(selectCiudades) {
                for (let ciudad of data) {
                    let option = document.createElement("option");
                    option.value = ciudad.id;
                    option.text = ciudad.nombre;
                    selectCiudades.appendChild(option);
                }
            }
        })
        .catch(error => console.error("Fetch error: ", error));

    })();
});