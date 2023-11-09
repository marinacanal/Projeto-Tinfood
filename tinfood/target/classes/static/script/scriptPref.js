document.getElementById('botao-salvar').addEventListener('click', function () {
    const preferencia1 = document.getElementById('preferencia1'); // Substitua pelo valor desejado
    const preferencia2 = document.getElementById('preferencia2');; // Substitua pelo valor desejado
    const preferencia3 = document.getElementById('preferencia3');; // Substitua pelo valor desejado

        // Enviar a solicitação PUT
        fetch(`/preferencia/`+ preferencia1.value + `/` + preferencia2.value + `/` + preferencia3.value , {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                preferencia1: preferencia1,
                preferencia2: preferencia2,
                preferencia3: preferencia3
            })
        })  
        paginaUpload()              
    })

function paginaUpload() {
location.replace("/uploadArquivo")
}
