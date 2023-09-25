const btnAlternarTema = document.createElement('button');
btnAlternarTema.textContent = 'Alternar Tema';
btnAlternarTema.addEventListener('click', alternarTema);
document.body.appendChild(btnAlternarTema);
verificarLocalStorage();

function verificarLocalStorage() {
    if (!localStorage.getItem('visitas')) {
        localStorage.setItem('visitas', '0');
    }

    if (!localStorage.getItem('tema')) {
        localStorage.setItem('tema', 'light');
    }

    const contadorVisitas = parseInt(localStorage.getItem('visitas'));
    localStorage.setItem('visitas', (contadorVisitas + 1).toString());
    configurarTema(localStorage.getItem('tema'));
}
  
function configurarTema(tema) {
    if (tema === 'dark') {
        document.body.style.backgroundColor = 'black';
        document.body.style.color = 'white';
    } else {
        document.body.style.backgroundColor = 'white';
        document.body.style.color = 'black';
    }
}
  
function alternarTema() {
    const temaAtual = localStorage.getItem('tema');
    const novoTema = temaAtual === 'light' ? 'dark' : 'light';
    localStorage.setItem('tema', novoTema);
    configurarTema(novoTema);
}