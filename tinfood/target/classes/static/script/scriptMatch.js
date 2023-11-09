//Script JavaScript para interagir com a API
function listarUsers() {
    fetch('/api/listar')
        .then(response => response.json())
        .then(data => {
            const listarUsers = document.getElementById('listarUsers');
            listarUsers.innerHTML = '';

            data.forEach(user => {
                const div = document.createElement('div');
                div.innerHTML = `
                <h2>${user.name}</h2>
                <h3>${user.descricao}</h3>
                <h3>${user.preferencia1}</h3>
                <h3>${user.preferencia2}</h3>
                <h3>${user.preferencia3}</h3>
                <img src="${user.foto_perfil}">
                <br>
                <button>Gostei</button>
                <button>Não Gostei</button>
            `;
                listarUsers.appendChild(div);                
            });
        })
    }
    listarUsers();
