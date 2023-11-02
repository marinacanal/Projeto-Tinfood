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