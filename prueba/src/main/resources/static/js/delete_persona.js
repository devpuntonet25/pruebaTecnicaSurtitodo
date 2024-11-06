function eliminar(id) {
    const url = "/personas/" + id;
    const settings = {
    method: "DELETE"
    };

    fetch(url, settings)
    .then(response => {
        if (response.ok) {
            let rowToRemove = document.querySelector("#tr_" + id);
            if (rowToRemove) {
                rowToRemove.remove();
            }
        }
    })
    .catch(error => console.error("Fetch error: ", error));

}