<<<<<<< HEAD:registration-login-springboot-security-thymeleaf-master/src/main/resources/static/script/scriptEdit.js
//Script JavaScript para interagir com a API

function listaUser(id) {
    fetch(`/api/listar/${id}`)
        .then(response => response.json())
        .then(data => {
            const listaUser = document.getElementById('listaUser');
            listaUser.innerHTML = '';

            data.forEach(users => {
                const tr = document.createElement('tr');
                tr.innerHTML = `
                <td>${users.nome}</td>
                <td>${users.email}</td>
                <td>${users.password}</td>
                <td>${users.telefone}</td>
                <td>${users.genero}</td>
                <td>${users.foto_perfil}</td>
                <td>${users.descricao}</td>
                <td>${users.data_nascimento}</td>
                <td>${users.preferencia1}</td>
                <td>${users.preferencia2}</td>
                <td>${users.preferencia3}</td>
                <td>${users.categoria}</td>
                <td>
                <!-- Botão de edição com formulário oculto -->
                <button class="botao-editar flat-button" data-id="${users.id}">Editar</button>
                <form class="form-editar oculto" data-id="${users.id}">
                    <div class="form-group">
                        <label for="editarNome">Novo Nome:</label>
                        <input type="text" id="editarNome" class="form-input" required>
                    </div>
                    <div class="form-group">
                        <label for="editarEmail">Novo Email:</label>
                        <input type="email" id="editarEmail" class="form-input" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="editarSenha">Nova Senha:</label>
                        <input type="password" id="editarSenha" class="form-input" required>
                    </div>
                    <div class="form-group">
                        <label for="editarTel">Novo Telfone:</label>
                        <input type="tel" id="editarTel" class="form-input" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="editarData">Nova Data de Nascimento:</label>
                        <input type="date" id="editarData" class="form-input" required>
                    </div>
                    <div class="form-group">
                        <label for="editarGenero">Novo Gênero:</label>
                        <input type="email" id="editarGenero" class="form-input" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="editarFoto">Nova Foto:</label>
                        <input type="text" id="editarFoto" class="form-input" required>
                    </div>
                    <div class="form-group">
                        <label for="editarDescricao">Novo Descrição:</label>
                        <input type="email" id="editarDescricao" class="form-input" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="editarPref1">Nova Preferência 1:</label>
                        <input type="text" id="editarPref1" class="form-input" required>
                    </div>
                    <div class="form-group">
                        <label for="editarPref2">Novo Preferência 2:</label>
                        <input type="text" id="editarPref2" class="form-input" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="editarPref3">Nova Preferência 3:</label>
                        <input type="text" id="editarPref3" class="form-input" required>
                    </div>
                    <button type="button" class="botao-salvar flat-button">Salvar</button>
                </form>                
                    <button class="botao-excluir flat-button" data-id="${users.id}">Excluir</button>
                </td>
            `;
                listaUser.appendChild(tr);
            });

            // Adicionar eventos para os botões editar e excluir
            const botoesEditar = document.querySelectorAll('.botao-editar');
            const botoesExcluir = document.querySelectorAll('.botao-excluir');

            botoesEditar.forEach(botao => {
                botao.addEventListener('click', function () {
                    const id = botao.getAttribute('data-id');

                    // Simplesmente exemplo: abrir um prompt para edição de nome
                    const novoNome = prompt('Digite o novo nome para o produto:');
                    const novoPreco = prompt('Digite o novo preço para o produto:');


                    if (novoNome !== null) { // Verificar se o usuário não cancelou
                        // Enviar a solicitação PUT
                        fetch(`/api/atualizar/${id}`, {
                            method: 'PUT',
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify({
                                nome: novoNome,
                                descricao: novoPreco
                            })
                        })
                            .then(response => response.json())
                            .then(data => {
                                listaUser();
                            })
                            .catch(error => {
                                console.error(`Erro ao atualizar o produto com ID ${id}:`, error);
                            });
                    }
                });
            });

            botoesExcluir.forEach(botao => {
                botao.addEventListener('click', function () {
                    const id = botao.getAttribute('data-id');
                    // Confirmar com o usuário antes de excluir
                    const confirmacao = confirm('Tem certeza de que deseja excluir este produto?');

                    if (confirmacao) {
                        // Enviar a solicitação DELETE
                        fetch(`/api/deletar/${id}`, {
                            method: 'DELETE'
                        })
                            .then(response => {
                                if (response.ok) {
                                    window.confirm(`Produto com ID ${id} excluído com sucesso.`);
                                    listaUser();
                                } else {
                                    console.error(`Erro ao excluir o produto com ID ${id}`);
                                }
                            })
                            .catch(error => {
                                console.error(`Erro ao excluir o produto com ID ${id}:`, error);
                            });
                    }
                });
            });

        })
        .catch(error => {
            console.error('Erro ao listar produtos:', error);
        });
}

listaUser();
=======
//Script JavaScript para interagir com a API

function listaUser(id) {
    fetch(`/api/listar/${id}`)
        .then(response => response.json())
        .then(data => {
            const listaUser = document.getElementById('listaUser');
            listaUser.innerHTML = '';

            data.forEach(users => {
                const tr = document.createElement('tr');
                tr.innerHTML = `
                <td>${users.nome}</td>
                <td>${users.email}</td>
                <td>${users.password}</td>
                <td>${users.telefone}</td>
                <td>${users.genero}</td>
                <td>${users.foto_perfil}</td>
                <td>${users.descricao}</td>
                <td>${users.data_nascimento}</td>
                <td>${users.preferencia1}</td>
                <td>${users.preferencia2}</td>
                <td>${users.preferencia3}</td>
                <td>${users.categoria}</td>
                <td>
                <!-- Botão de edição com formulário oculto -->
                <button class="botao-editar flat-button" data-id="${users.id}">Editar</button>
                <form class="form-editar oculto" data-id="${users.id}">
                    <div class="form-group">
                        <label for="editarNome">Novo Nome:</label>
                        <input type="text" id="editarNome" class="form-input" required>
                    </div>
                    <div class="form-group">
                        <label for="editarEmail">Novo Email:</label>
                        <input type="email" id="editarEmail" class="form-input" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="editarSenha">Nova Senha:</label>
                        <input type="password" id="editarSenha" class="form-input" required>
                    </div>
                    <div class="form-group">
                        <label for="editarTel">Novo Telfone:</label>
                        <input type="tel" id="editarTel" class="form-input" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="editarData">Nova Data de Nascimento:</label>
                        <input type="date" id="editarData" class="form-input" required>
                    </div>
                    <div class="form-group">
                        <label for="editarGenero">Novo Gênero:</label>
                        <input type="email" id="editarGenero" class="form-input" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="editarFoto">Nova Foto:</label>
                        <input type="text" id="editarFoto" class="form-input" required>
                    </div>
                    <div class="form-group">
                        <label for="editarDescricao">Novo Descrição:</label>
                        <input type="email" id="editarDescricao" class="form-input" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="editarPref1">Nova Preferência 1:</label>
                        <input type="text" id="editarPref1" class="form-input" required>
                    </div>
                    <div class="form-group">
                        <label for="editarPref2">Novo Preferência 2:</label>
                        <input type="text" id="editarPref2" class="form-input" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="editarPref3">Nova Preferência 3:</label>
                        <input type="text" id="editarPref3" class="form-input" required>
                    </div>
                    <button type="button" class="botao-salvar flat-button">Salvar</button>
                </form>                
                    <button class="botao-excluir flat-button" data-id="${users.id}">Excluir</button>
                </td>
            `;
                listaUser.appendChild(tr);
            });

            // Adicionar eventos para os botões editar e excluir
            const botoesEditar = document.querySelectorAll('.botao-editar');
            const botoesExcluir = document.querySelectorAll('.botao-excluir');

            botoesEditar.forEach(botao => {
                botao.addEventListener('click', function () {
                    const id = botao.getAttribute('data-id');

                    // Simplesmente exemplo: abrir um prompt para edição de nome
                    const novoNome = prompt('Digite o novo nome para o produto:');
                    const novoPreco = prompt('Digite o novo preço para o produto:');


                    if (novoNome !== null) { // Verificar se o usuário não cancelou
                        // Enviar a solicitação PUT
                        fetch(`/api/atualizar/${id}`, {
                            method: 'PUT',
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify({
                                nome: novoNome,
                                descricao: novoPreco
                            })
                        })
                            .then(response => response.json())
                            .then(data => {
                                listaUser();
                            })
                            .catch(error => {
                                console.error(`Erro ao atualizar o produto com ID ${id}:`, error);
                            });
                    }
                });
            });

            botoesExcluir.forEach(botao => {
                botao.addEventListener('click', function () {
                    const id = botao.getAttribute('data-id');
                    // Confirmar com o usuário antes de excluir
                    const confirmacao = confirm('Tem certeza de que deseja excluir este produto?');

                    if (confirmacao) {
                        // Enviar a solicitação DELETE
                        fetch(`/api/deletar/${id}`, {
                            method: 'DELETE'
                        })
                            .then(response => {
                                if (response.ok) {
                                    window.confirm(`Produto com ID ${id} excluído com sucesso.`);
                                    listaUser();
                                } else {
                                    console.error(`Erro ao excluir o produto com ID ${id}`);
                                }
                            })
                            .catch(error => {
                                console.error(`Erro ao excluir o produto com ID ${id}:`, error);
                            });
                    }
                });
            });

        })
        .catch(error => {
            console.error('Erro ao listar produtos:', error);
        });
}

listaUser();
>>>>>>> f37bb475635418cda0b692a6fafa54d7437f1511:registration-login-springboot-security-thymeleaf-master (3)/registration-login-springboot-security-thymeleaf-master/src/main/resources/static/script/scriptEdit.js
