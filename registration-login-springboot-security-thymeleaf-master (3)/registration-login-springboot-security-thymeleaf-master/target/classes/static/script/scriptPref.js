document.getElementById('botao-salvar').addEventListener('click', function () {

    const preferencia1Input = document.getElementById('preferencia1'); // Obtém a referência ao campo
    const preferencia2Input = document.getElementById('preferencia2'); // Obtém a referência ao campo
    const preferencia3Input = document.getElementById('preferencia3'); // Obtém a referência ao campo
    const preferencia1 = preferencia1Input.value;
    const preferencia2 = preferencia2Input.value;
    const preferencia3 = preferencia3Input.value;
    
        // Enviar a solicitação PUT
        fetch(`/preferencia/`+ preferencia1 `/`+ preferencia2 `/`+ preferencia3, {
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
    
});

