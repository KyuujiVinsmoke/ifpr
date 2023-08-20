import 'package:contact_crud_hive/home_contact.dart';
import 'package:contact_crud_hive/model/user.dart';
import 'package:flutter/material.dart';
import 'package:hive_flutter/hive_flutter.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Hive.initFlutter();
  /** Registra o Adapter */
  Hive.registerAdapter(UserModelAdapter());
  /** Abre um Box tipado */
  await Hive.openBox<UserModel>('users');

  final ThemeData thema = ThemeData();
  runApp(MaterialApp(
    home: const HomeContact(),
    title: 'Lista de Contatos',
    theme: ThemeData().copyWith(
      colorScheme: thema.colorScheme.copyWith(
        primary: const Color.fromARGB(255, 0, 156, 40),
      )
    ),
    debugShowCheckedModeBanner: false,
  ));
}