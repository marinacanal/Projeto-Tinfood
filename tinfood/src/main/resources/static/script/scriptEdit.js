//Script JavaScript para interagir com a API
let usuarioLogado;

function listaUser() {
    fetch('/api/listar/usuarioLogado')
        .then(response => response.json())
        .then(data => {
            const listaUser = document.getElementById('listaUser');
            listaUser.innerHTML = '';

            data.forEach(usuarioLogado => {
                const div = document.createElement('div');
                div.innerHTML = `<div class="container">
                <div class="row">
                <div class="col-6 esquerdo">
                <form>
                <div class="image">
                <img src="${usuarioLogado.foto_perfil}" data-original-src="${usuarioLogado.foto_perfil}"  alt="" id="image-selected" height="150px" width="150px">
                <br>
                </div>
                <br>
                </form>
                <br>
                <input type="text" id="nome" placeholder="${usuarioLogado.name}" value="${usuarioLogado.name}"/>
                <br>
                <input type="text" id="descricao" name="descricao" placeholder="${usuarioLogado.descricao}" value="${usuarioLogado.descricao}"/>
                <br>
                <br>
                <div class="preferencias">
                <input type="text" id="pref1" placeholder="${usuarioLogado.preferencia1}" value="${usuarioLogado.preferencia1}"/>
                <input type="tel" id="pref2" placeholder="${usuarioLogado.preferencia2}" value="${usuarioLogado.preferencia2}"/>
                <input type="tel" id="pref3" placeholder="${usuarioLogado.preferencia3}" value="${usuarioLogado.preferencia3}"/>
                </div>
                </div>

                <div class="col-6 direito">
                <div class="comlabel">
                <label for="email">Email:</label>
                <br>
                <input type="email" id="email" placeholder="${usuarioLogado.email}" value="${usuarioLogado.email}"/>
                <br>
                <label for="email">Senha:</label>
                <br>
                <input type="password" id="password" placeholder="***"/>
                <br>
                <label for="email">Telefone:</label>
                <br>
                <input type="tel" id="tel" placeholder="${usuarioLogado.telefone}" value="${usuarioLogado.telefone}"/>
                <br>
                <label for="email">Data de Nascimento:</label>
                <br>
                <input placeholder="${usuarioLogado.data_nascimento}" value="${usuarioLogado.data_nascimento}" type="text" onfocus="(this.type='date')" onblur="(this.type='text')" name="data_nascimento" id="data_nascimento">
                <br>
                <label for="email">Gênero:</label>
                <br>
                <select name="sexo" id="genero">
                <option value="${usuarioLogado.genero}">${usuarioLogado.genero}</option>
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
                <option value="Não Informado">Prefiro não informar</option>
                </select>
                </div>
                <br>
                <!-- Botão de edição com formulário oculto -->
                <button type="submit" class="botao-editar flat-button" data-id="${usuarioLogado.id}">Salvar Alterações</button>
                </div>
                </div>
                </div>
            `;
                listaUser.appendChild(div);
            });

            // Adicionar eventos para os botões editar e excluir
            const botoesEditar = document.querySelectorAll('.botao-editar');

            botoesEditar.forEach(botao => {
                botao.addEventListener('click', function () {
                    const id = botao.getAttribute('data-id');

                    const nomeInput = document.getElementById('nome'); // Obtém a referência ao campo de nome
                    const fotoInput = document.getElementById('image-selected');
                    const emailInput = document.getElementById('email'); // Obtém a referência ao campo de nome
                    const dataInput = document.getElementById('data_nascimento'); // Obtém a referência ao campo de nome
                    const telInput = document.getElementById('tel'); // Obtém a referência ao campo de nome
                    const generoInput = document.getElementById('genero'); // Obtém a referência ao campo de nome
                    const senhaInput = document.getElementById('password'); // Obtém a referência ao campo de nome
                    const descInput = document.getElementById('descricao'); // Obtém a referência ao campo de nome
                    const pref1Input = document.getElementById('pref1'); // Obtém a referência ao campo de nome
                    const pref2Input = document.getElementById('pref2'); // Obtém a referência ao campo de nome
                    const pref3Input = document.getElementById('pref3'); // Obtém a referência ao campo de nome

                    const novoNome = nomeInput.value;
                    const novoEmail = emailInput.value;
                    const novaFoto = fotoInput.getAttribute('data-original-src');                   
                    const novoDataN = dataInput.value;
                    const novoTel = telInput.value;
                    const novoGen = generoInput.value;
                    const novoSenha = senhaInput.value;
                    const novoDesc = descInput.value;
                    const novoPref1 = pref1Input.value;
                    const novoPref2 = pref2Input.value;
                    const novoPref3 = pref3Input.value;
                        
                    fetch(`/api/atualizar/${id}`, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({
                            name: novoNome,
                            email: novoEmail,
                            foto_perfil: novaFoto,
                            password: novoSenha,
                            data_nascimento: novoDataN,
                            telefone: novoTel,
                            genero: novoGen,
                            descricao: novoDesc,
                            preferencia1: novoPref1,
                            preferencia2: novoPref2,
                            preferencia3: novoPref3
                        })
                    })
                        .then(response => response.json())
                        .then(data => {
                            paginaMatch();
                        })
                        .catch(error => {
                            console.error('Erro ao atualizar o user com ID ${id}:', error);
                        });
                })
            });
        })
        .catch(error => {
            console.error('Erro ao listar user:', error);
        });
}
listaUser();

function paginaMatch() {
    location.replace("/downloadArquivo")
}