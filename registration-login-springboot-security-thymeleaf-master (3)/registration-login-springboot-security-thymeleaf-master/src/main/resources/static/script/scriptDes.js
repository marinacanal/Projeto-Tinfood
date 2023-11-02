document.getElementById('botao-salvar').addEventListener('click', function () {

        const descricaoInput = document.getElementById('descricao'); // Obtém a referência ao campo de nome
        const descricao = descricaoInput.value;

        if (descricao !== null) { // Verificar se o usuário não cancelou
            // Enviar a solicitação PUT
            fetch(`/descricao/`+ descricao, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    descricao: descricao
                })
            })  
            paginaPref()              
        }
    });

function paginaPref() {
    location.replace("/uploadArquivo")
}
