import 'package:contact_crud_hive/common/box_user.dart';
import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/adapters.dart';

import 'contact_listview.dart';
import 'form_contact_fielder.dart';
import 'model/user.dart';

class HomeContact extends StatefulWidget {
  const HomeContact({super.key});

  @override
  State<HomeContact> createState() => _HomeContactState();
}

class _HomeContactState extends State<HomeContact> {
  final _formKey = GlobalKey<FormState>();
  final idUserControl = TextEditingController();
  final nameUserControl = TextEditingController();
  final telefoneUserControl = TextEditingController();
  final emailUserControl = TextEditingController();
  final searchUserController = TextEditingController();
  List<UserModel> users = [];

  Future<void> addUser(
      String id, String name, String telefone, String email) async {
    if (_formKey.currentState!.validate()) {
      _formKey.currentState!.save();

      final user = UserModel()
        ..id = id
        ..name = name
        ..telefone = telefone
        ..email = email;

      final box = UserBox.getUsers();
      box.add(user).then((value) => _clearTextControllers());

      setState(() {
        atualizaLista();
      });
    }
  }

  Future<void> editUser(UserModel user) async {
    idUserControl.text = user.id;
    nameUserControl.text = user.name;
    telefoneUserControl.text = user.telefone;
    emailUserControl.text = user.email;

    setState(() {
      atualizaLista();
    });
  }

  void _clearTextControllers() {
    idUserControl.clear();
    nameUserControl.clear();
    telefoneUserControl.clear();
    emailUserControl.clear();
  }

  @override
  void dispose() {
    idUserControl.dispose();
    nameUserControl.dispose();
    telefoneUserControl.dispose();
    emailUserControl.dispose();
    Hive.close();
    super.dispose();
  }

  //atualiza estado da lista/pesquisar
  List<UserModel> atualizaLista() {
    final users = UserBox.getUsers().values.toList().cast<UserModel>();
    final searchResults = users
        .where((user) => user.name
            .toLowerCase()
            .contains(searchUserController.text.toLowerCase()))
        .toList();

    return searchResults;
  }

  @override
  Widget build(BuildContext context) {
    return Form(
      key: _formKey,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Lista de Contatos'),
        ),
        body: SingleChildScrollView(
          padding: const EdgeInsets.all(10),
          child: Column(
            children: <Widget>[
              FormContactFielder(
                controller: idUserControl,
                iconData: Icons.code,
                hintTextName: 'Código',
              ),
              const SizedBox(height: 10),
              FormContactFielder(
                controller: nameUserControl,
                iconData: Icons.person_outline,
                hintTextName: 'Nome',
              ),
              const SizedBox(height: 10),
              FormContactFielder(
                controller: telefoneUserControl,
                iconData: Icons.phone_android,
                hintTextName: 'Telefone',
              ),
              const SizedBox(height: 10),
              FormContactFielder(
                controller: emailUserControl,
                iconData: Icons.email_outlined,
                textInputType: TextInputType.emailAddress,
                hintTextName: 'Email',
              ),
              const SizedBox(height: 10),
              Container(
                padding: const EdgeInsets.only(left: 40),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: <Widget>[
                    Expanded(
                      child: ElevatedButton(
                        onPressed: () {
                          addUser(
                            idUserControl.text,
                            nameUserControl.text,
                            telefoneUserControl.text,
                            emailUserControl.text,
                          );
                        },
                        child: const Text('Adicionar'),
                      ),
                    ),
                    const SizedBox(width: 20),
                    Expanded(
                      child: ElevatedButton(
                        onPressed: _clearTextControllers,
                        child: const Text('Limpar Campos'),
                      ),
                    ),
                  ],
                ),
              ),
              //lista/pesquisa
              const SizedBox(height: 10),
              FormContactFielder(
                controller: searchUserController,
                iconData: Icons.search,
                hintTextName: 'Pesquisar',
              ),
              //lista/pesquisa funçao
              ValueListenableBuilder(
                valueListenable: searchUserController,
                builder: (context, _, __) {
                  if (atualizaLista().isNotEmpty) {
                    return ContactListView(
                        users: atualizaLista(), onEditContact: editUser);
                  } else if (atualizaLista().isEmpty) {
                    return Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: const [
                        Icon(Icons.person_outline,
                            size: 80, color: Colors.grey),
                        Text(
                          'Nenhum Usuário Encontrado',
                          style: TextStyle(fontSize: 20, color: Colors.grey),
                          textAlign: TextAlign.center,
                        ),
                      ],
                    );
                  } else {
                    return ContactListView(
                        users: atualizaLista(), onEditContact: editUser);
                  }
                },
              ),
              //apagar todos
              Column(
                children: [
                  const SizedBox(height: 30),
                  FloatingActionButton(
                    onPressed: () {
                      showDialog(
                        context: context,
                        builder: (BuildContext context) {
                          return AlertDialog(
                            title: const Text("Apagar todos os contatos?"),
                            content: const Text(
                                "Tem certeza que deseja apagar todos os contatos?"),
                            // apagar todos funçao
                            actions: [
                              TextButton(
                                child: const Text("Cancelar"),
                                onPressed: () {
                                  Navigator.of(context).pop();
                                },
                              ),
                              TextButton(
                                child: const Text("Apagar"),
                                onPressed: () {
                                  final box = UserBox.getUsers();
                                  box.clear();
                                    setState(() {
                                    atualizaLista();
                                  });
                                  Navigator.of(context).pop();
                                },
                              ),
                            ],
                          );
                        },
                      );
                    },
                    backgroundColor: const Color.fromARGB(255, 255, 68, 68),
                    child: const Icon(Icons.delete),
                  )
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}