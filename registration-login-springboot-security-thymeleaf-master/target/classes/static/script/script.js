document.getElementById('criarUsuario').addEventListener('click', function () {
    
    const nomeInput = document.getElementById('nome'); // Obtém a referência ao campo de nome
    const emailInput = document.getElementById('email'); // Obtém a referência ao campo de nome
    const dataInput = document.getElementById('data_nascimento'); // Obtém a referência ao campo de nome
    const telInput = document.getElementById('telefone'); // Obtém a referência ao campo de nome
    const generoInput = document.getElementById('genero'); // Obtém a referência ao campo de nome
    const senhaInput = document.getElementById('senha'); // Obtém a referência ao campo de nome
    
    const nome = nomeInput.value;
    const email = emailInput.value;
    const dataN = dataInput.value;
    const tel = telInput.value;
    const genero = generoInput.value;
    const senha = senhaInput.value;
    

    fetch('/registrar/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: nome,
            email: email,
            password: senha,
            data_nascimento: dataN,
            telefone: tel,
            genero: genero
        })        
    })
        paginaDeLogin() 
   
}); 

function paginaDeLogin() {
    location.replace("/login")
}

