<<<<<<< HEAD:registration-login-springboot-security-thymeleaf-master/src/main/resources/static/script/scriptPref.js
document.getElementById('botao-salvar').addEventListener('click', function () {
    var preferencia1 = document.getElementById('preferencia1'); // Substitua pelo valor desejado
    var preferencia2 = document.getElementById('preferencia2');; // Substitua pelo valor desejado
    var preferencia3 = document.getElementById('preferencia3');; // Substitua pelo valor desejado

    $.post("/preferencia/" + preferencia1.value + "/" + preferencia2.value + "/" + preferencia3.value, function(data) {
        // Manipule a resposta da solicitação, se necessário
        // Você pode redirecionar o usuário para a página "/preferencia" aqui
    }).done(function(data) {
        // A solicitação foi bem-sucedida, você pode redirecionar o usuário aqui
        window.location.href = "/preferencia";
    }).fail(function() {
        // A solicitação falhou, lide com os erros aqui
    });
});
=======
document.getElementById('botao-salvar').addEventListener('click', function () {

    const preferencia1Input = document.getElementById('preferencia1'); // Obtém a referência ao campo
    const preferencia2Input = document.getElementById('preferencia2'); // Obtém a referência ao campo
    const preferencia3Input = document.getElementById('preferencia3'); // Obtém a referência ao campo
    const preferencia1 = preferencia1Input.value;
    const preferencia2 = preferencia2Input.value;
    const preferencia3 = preferencia3Input.value;
    
        // Enviar a solicitação PUT
        fetch(`/preferencia/`+ preferencia1 `/`+ preferencia2 `/`+ preferencia3, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                preferencia1: preferencia1,
                preferencia2: preferencia2,
                preferencia3: preferencia3
            })
        })  
    
});

>>>>>>> f37bb475635418cda0b692a6fafa54d7437f1511:registration-login-springboot-security-thymeleaf-master (3)/registration-login-springboot-security-thymeleaf-master/target/classes/static/script/scriptPref.js
