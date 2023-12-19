function mostrarBotao() {
    fetch('/api/listar/usuarioLogado')
        .then(response => response.json())
        .then(data => {
            const mostrarBotao = document.getElementById('mostrarBotao');
            mostrarBotao.innerHTML = '';


            data.forEach(usuarioLogado => {
                const div = document.createElement('div');
                div.innerHTML = `
                <button class="botao-apagar flat-button" data-id="${usuarioLogado.id}">Excluir</button>
                <a href="/downloadArquivo">
                    <button class="botao-cancel flat-button">Cancelar</button>
                </a>
                `;
                mostrarBotao.appendChild(div);
            });

            const botaoExcluir = document.querySelectorAll('.botao-apagar');

            botaoExcluir.forEach(botao => {
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
                                    paginaInicial()              
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
        })
};
mostrarBotao();

function paginaInicial() {
    location.replace("/")
}
