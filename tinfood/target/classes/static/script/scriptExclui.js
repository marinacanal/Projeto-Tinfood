const botoesExcluir = document.querySelectorAll('.botao-excluir');

botoesExcluir.forEach(botao => {
    botao.addEventListener('click', function () {
        const id = botao.getAttribute('data-id');
        // Confirmar com o usuário antes de excluir
        const confirmacao = confirm('Tem certeza de que deseja excluir esta conta?');

        if (confirmacao) {
            // Enviar a solicitação DELETE
            fetch(`/api/deletar/${id}`, {
                method: 'DELETE'
            })
                .then(response => {
                    if (response.ok) {
                        console(`User com ID ${id} excluído com sucesso.`);
                    } else {
                        console.error(`Erro ao excluir o user com ID ${id}`);
                    }
                })
                .catch(error => {
                    console.error(`Erro ao excluir o user com ID ${id}:`, error);
                });
            }
        })
})