import 'package:flutter/material.dart';

import 'model/user.dart';

class ContactListView extends StatelessWidget {
  const ContactListView({
    super.key,
    required this.users,
    this.onEditContact,
  });

  final List<UserModel> users;
  final void Function(UserModel user)? onEditContact;

  Future<void> deleteUser(UserModel user) async {
    user.delete();
  }

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      shrinkWrap: true,
      itemCount: users.length,
      itemBuilder: (context, index) {
        return Card(
          child: ExpansionTile(
            title: Text(
              users[index].name,
              style: const TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 20,
              ),
            ),
            subtitle: Text('${users[index].telefone}\n${users[index].email}'),
            children: <Widget>[
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  TextButton.icon(
                    onPressed: () {
                      onEditContact!(users[index]);
                      deleteUser(users[index]);
                    },
                    icon: const Icon(
                      Icons.edit,
                      color: Color.fromARGB(255, 0, 160, 255),
                    ),
                    label: const Text(
                      'Editar',
                      style: TextStyle(color: Color.fromARGB(255, 0, 160, 255)),
                    ),
                  ),
                  TextButton.icon(
                    onPressed: () {
                      deleteUser(users[index]);
                    },
                    icon: const Icon(
                      Icons.delete,
                      color: Color.fromARGB(255, 255, 68, 68),
                    ),
                    label: const Text(
                      "Excluir",
                      style: TextStyle(color: Color.fromARGB(255, 255, 68, 68)),
                    ),
                  ),
                ],
              )
            ],
          ),
        );
      },
    );
  }
}