function listarUsers() {
	fetch('/api/listar')
		.then(response => response.json())
		.then(data => {
			const listarUsers = document.getElementById('listarUsers');
			listarUsers.innerHTML = '';

			data.forEach(user => {
				const div = document.createElement('div');
				div.innerHTML = `
                <div class="content">
				<div class="card">
					<div class="user">
						<img
							class="user"
							src="${user.foto_perfil}"
							alt=""
						/>
						<div class="profile">
							<div class="name" >${user.name}</div>
							<div class="local">
								<i class="fas fa-map-marker-alt"></i>
								<span>${user.preferencia1}</span>
                                <span>${user.preferencia2}</span>
                                <span>${user.preferencia3}</span>
							</div>
						</div>
					</div>
				</div>
				<div class="buttons">
					<div class="no">
						<i class="fas fa-times"></i>
					</div>
					<div class="heart" >
						<i class="fas fa-heart"></i>
					</div>
				</div>
			    </div>
            `;
				listarUsers.appendChild(div);
			});
		})
}
listarUsers();

function listaUser() {
	fetch('/api/listar/usuarioLogado')
		.then(response => response.json()) // Converte a resposta para JSON
		.then(data => {
			const listaUser = document.getElementById('listaUser');
			listaUser.innerHTML = '';
			data.forEach(usuarioLogado => {
				const div = document.createElement('div');
				div.innerHTML = `
                    <div class="avatar">
                        <img src="${usuarioLogado.foto_perfil}" alt="" />
                    </div>
                    <a href="/editar" class="link" data-id="${usuarioLogado.id}">
                        <div class="title">${usuarioLogado.name}</div>
                    </a>
                    <div>
                        <a href="/deletar" class="trash">
                            <i class="fas fa-trash" style="color: #ffffff;"></i>
                        </a>
                    </div>
                `;
				listaUser.appendChild(div);
			});
		})
		.catch(error => console.error('Erro ao buscar dados:', error));
}

const a = document.querySelectorAll('.link');
a.forEach(link => {
	link.addEventListener('click','DOMContentLoaded', function (event) {
		event.preventDefault(); // Impede o comportamento padrão do link
		const id = link.getAttribute('data-id');
		console.log('ID do usuário:', id);
		// Faça algo com o ID, por exemplo, redirecione para a página de edição
		// window.location.href = '/editar?id=' + id;
	});
});

listaUser();
