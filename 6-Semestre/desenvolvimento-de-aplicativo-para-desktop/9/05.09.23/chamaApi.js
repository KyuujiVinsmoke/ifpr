// Obtém uma referência ao elemento da tabela onde os personagens serão exibidos.
const corpoTabelaPersonagens = document.getElementById('corpoTabelaPersonagens');

// Função que busca os dados da API e preenche a tabela com os usuarios.

function buscarDadosEPreencherTabela() {
    // Faz uma requisição GET para a API.
    axios.get('http://infopguaifpr.com.br:3052/listarTodosUsuarios')
        .then(response => {
            console.log(response)

            // Obtém a lista de usuários da resposta.
            const usuarios = response.data.usuarios;

            // Chama a função para preencher a tabela com os usuários.
            preencherTabela(usuarios);
        })
        .catch(error => {
            // Em caso de erro, exibe uma mensagem de erro no console.
            console.error('Error fetching character data:', error);
        });
}

// Função que preenche a tabela com os dados dos usuários.
function preencherTabela(usuarios) {
    // Para cada usuário na lista...
    usuarios.forEach(usuario => {
        // Cria uma nova linha na tabela.
        const linha = document.createElement('tr');

        // Cria células para cada dado do usuário e insere o texto.
        const idCelula = document.createElement('td');
        idCelula.textContent = usuario.id;
        linha.appendChild(idCelula);

        // Cria células para cada dado do usuário e insere o texto.
        const nomeCelula = document.createElement('td');
        nomeCelula.textContent = usuario.nome;
        linha.appendChild(nomeCelula);

        const emailCelula = document.createElement('td');
        emailCelula.textContent = usuario.email;
        linha.appendChild(emailCelula);

        const disciplinaCelula = document.createElement('td');
        disciplinaCelula.textContent = usuario.disciplina;
        linha.appendChild(disciplinaCelula);

        // Cria células para os botões de editar e excluir.
        const acoesCelula = document.createElement('td');
        const editarBotao = document.createElement('a');
        editarBotao.href = '#';
        editarBotao.className = 'btn btn-primary btn-edit';
        editarBotao.textContent = 'Editar';
        editarBotao.dataset.id = usuario.id;
        acoesCelula.appendChild(editarBotao);

        const excluirBotao = document.createElement('a');
        excluirBotao.href = '#';
        excluirBotao.className = 'btn btn-danger btn-delete';
        excluirBotao.textContent = 'Excluir';
        excluirBotao.dataset.id = usuario.id;
        acoesCelula.appendChild(excluirBotao);

        linha.appendChild(acoesCelula);

        // Adiciona a linha preenchida à tabela.
        corpoTabelaPersonagens.appendChild(linha);
    });
}

// Obtém uma referência ao botão que chama a API.
const botaoChamarAPI = document.getElementById('botaoChamarAPI');
// Adiciona um ouvinte de evento para o clique no botão.
botaoChamarAPI.addEventListener('click', () => {
    // Quando o botão é clicado, chama a função para buscar dados e preencher a tabela.
    buscarDadosEPreencherTabela();

});

const express = require('express');
const router = express.Router();

const { pegarUsuarioPeloId } = require('./seuControladorDeUsuarios');

router.get('/pegarUsuarioPeloId/:id', async (req, res) => {
  try {
    const idUsuario = req.params.id;
    const usuario = await pegarUsuarioPeloId(idUsuario);
    if (!usuario) {
      return res.status(404).json({ message: 'Usuário não encontrado' });
    }
    res.json({ usuario });
  } catch (error) {
    console.error('Erro ao buscar usuário por ID:', error);
    res.status(500).json({ message: 'Erro interno do servidor' });
  }
});

module.exports = router;

const Usuario = require('./models/Usuario');

async function pegarUsuarioPeloId(idUsuario) {
  try {
    const usuario = await Usuario.findById(idUsuario); // 
    return usuario;
  } catch (error) {
    console.error('Erro ao buscar usuário por ID:', error);
    throw error;
  }
}

module.exports = { pegarUsuarioPeloId };

document.addEventListener('click', (event) => {
    if (event.target.classList.contains('btn-edit')) {
      const idUsuario = event.target.dataset.id;
      abrirModalDeEdicao(idUsuario);
    }
  });
  
  function abrirModalDeEdicao(idUsuario) {
    axios.get(`http://seuservidor.com/pegarUsuarioPeloId/${idUsuario}`)
      .then(response => {
        const usuario = response.data.usuario;
        document.getElementById('nome').value = usuario.nome;
        document.getElementById('email').value = usuario.email;
        document.getElementById('disciplina').value = usuario.disciplina;
  
        $('#editarUsuario').modal('show');
      })
      .catch(error => {
        console.error('Erro ao buscar usuário por ID:', error);
      });
  }
  
router.put('/atualizarUsuario/:id', async (req, res) => {
    try {
      const idUsuario = req.params.id;
      const dadosAtualizados = req.body;
      const usuarioAtualizado = await Usuario.findByIdAndUpdate(idUsuario, dadosAtualizados, { new: true });
      if (!usuarioAtualizado) {
        return res.status(404).json({ message: 'Usuário não encontrado' });
      }
      res.json({ usuario: usuarioAtualizado });
    } catch (error) {
      console.error('Erro ao atualizar usuário:', error);
      res.status(500).json({ message: 'Erro interno do servidor' });
    }
  });
  
document.getElementById('editarUsuario').addEventListener('submit', (event) => {
    event.preventDefault(); 
  
    const idUsuario = event.target.dataset.id;
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const disciplina = document.getElementById('disciplina').value;
  
    const dadosAtualizados = { nome, email, disciplina };
  
    axios.put(`http://seuservidor.com/atualizarUsuario/${idUsuario}`, dadosAtualizados)
      .then(response => {
        $('#editarUsuario').modal('hide');
        buscarDadosEPreencherTabela();
      })
      .catch(error => {
        console.error('Erro ao atualizar usuário:', error);
      });
  });
  