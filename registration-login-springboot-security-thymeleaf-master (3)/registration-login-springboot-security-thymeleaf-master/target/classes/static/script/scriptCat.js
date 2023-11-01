function clickTeclado(categoria) {

    if (categoria !== null) { // Verificar se o usuário não cancelou
        // Enviar a solicitação PUT
        fetch(`/categoria/`+ categoria, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                categoria: categoria
            })
        })  
        paginaEdit()
    }
}

function paginaEdit() {
    location.replace("/editar")
}