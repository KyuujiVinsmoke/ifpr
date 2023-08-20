import 'package:flutter/material.dart';
import 'jhome.dart';

void main() {
  final ThemeData thema = ThemeData();
  runApp(MaterialApp(
    theme: ThemeData().copyWith(
        colorScheme: thema.colorScheme.copyWith(
      primary: Colors.amber,
    )),
    home: const JokemPoHome(),
    debugShowCheckedModeBanner: false,
  ));
}
