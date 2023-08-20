import 'dart:math';

import 'package:flutter/material.dart';

class JokemPoHome extends StatefulWidget {
  const JokemPoHome({super.key});

  @override
  State<JokemPoHome> createState() => _JokemPoHomeState();
}

class _JokemPoHomeState extends State<JokemPoHome> {
  var _imgApp = Image.asset('images/padrao.png');
  var _mensagem = 'Quem venceu o jogo!!!';

  int numVitorias = 0;
  int numDerrotas = 0;
  int numEmpates = 0;

  void _joga(String opcaoJogador) {
    final listaOpcoes = ['pedra', 'papel', 'tesoura'];
    final opcaoApp = listaOpcoes[Random().nextInt(3)];

    setState(() {
      _imgApp = Image.asset('images/$opcaoApp.png');
      _mensagem = _resultado(opcaoJogador, opcaoApp);
    });
  }

  String _resultado(String opcaoJogador, String opcaoApp) {
    final String mensagem;

    if ((opcaoJogador == 'pedra' && opcaoApp == 'tesoura') ||
        (opcaoJogador == 'papel' && opcaoApp == 'pedra') ||
        (opcaoJogador == 'tesoura' && opcaoApp == 'papel')) {
      mensagem = 'Você Ganhou!!!';
      numVitorias++;
    } else if ((opcaoJogador == 'pedra' && opcaoApp == 'pedra') ||
        (opcaoJogador == 'papel' && opcaoApp == 'papel') ||
        (opcaoJogador == 'tesoura' && opcaoApp == 'tesoura')) {
      mensagem = 'Empatamos!!!!';
      numEmpates++;
    } else {
      mensagem = 'Você Perdeu!!!';
      numDerrotas++;
    }

    return mensagem;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Jokempo'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          // ignore: prefer_const_constructors
          _textLabel('Escolha do APP'),
          _imgApp,
          _textLabel(_mensagem),
          Padding(
            padding: const EdgeInsets.only(
              left: 30,
              right: 30,
            ),
            child: Row(
              children: <Widget>[
                playerChoose('pedra'),
                const SizedBox(width: 10),
                playerChoose('papel'),
                const SizedBox(width: 10),
                playerChoose('tesoura'),
              ],
            ),
          ),
          Padding(
            padding: const EdgeInsets.only(
              top: 32,
              bottom: 16,
              left: 30,
              right: 30,
            ),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: <Widget>[
                countWraCircle(
                  'Vitórias',
                  numVitorias.toString(),
                ),
                countWraCircle(
                  'Empates',
                  numEmpates.toString(),
                ),
                countWraCircle(
                  'Derrotas',
                  numDerrotas.toString(),
                ),
              ],
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          setState(() {
            numVitorias = 0;
            numEmpates = 0;
            numDerrotas = 0;
            _mensagem = 'Quem venceu o jogo!!!';
          });
        },
        backgroundColor: Theme.of(context).colorScheme.primary,
        child: const Icon(Icons.settings_backup_restore_sharp),
      ),
    );
  }

  Widget countWraCircle(String textTop, String textBottom) {
    return SizedBox(
      height: 90,
      width: 90,
      child: ClipOval(
        child: Material(
          // ignore: sort_child_properties_last
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                textTop,
                style: const TextStyle(
                  fontSize: 15,
                  fontWeight: FontWeight.bold,
                ),
              ),
              const SizedBox(
                height: 5.0,
              ),
              Text(
                textBottom,
                style: const TextStyle(
                  color: Colors.white,
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ],
          ),
          color: Colors.amberAccent,
        ),
      ),
    );
  }

  Expanded playerChoose(String imageName) {
    return Expanded(
      child: InkWell(
        onTap: () => _joga(imageName),
        child: Image.asset(
          'images/$imageName.png',
        ),
      ),
    );
  }

  Padding _textLabel(String text) {
    return Padding(
      padding: const EdgeInsets.only(
        top: 32,
        bottom: 16,
      ),
      child: Text(
        text,
        style: const TextStyle(
          fontSize: 20,
          fontWeight: FontWeight.bold,
        ),
      ),
    );
  }
}
