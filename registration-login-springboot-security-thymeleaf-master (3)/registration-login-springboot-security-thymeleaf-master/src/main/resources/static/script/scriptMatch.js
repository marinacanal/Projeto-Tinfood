<<<<<<< HEAD:registration-login-springboot-security-thymeleaf-master/src/main/resources/static/script/scriptMatch.js
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
               
            `;
                listarUsers.appendChild(div);
            });
        })
=======
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
               
            `;
                listarUsers.appendChild(div);
            });
        })
>>>>>>> f37bb475635418cda0b692a6fafa54d7437f1511:registration-login-springboot-security-thymeleaf-master (3)/registration-login-springboot-security-thymeleaf-master/src/main/resources/static/script/scriptMatch.js
    }