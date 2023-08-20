import 'package:flutter/material.dart';

class FormContactFielder extends StatelessWidget {
  TextEditingController controller;
  String hintTextName;
  IconData iconData;
  TextInputType textInputType;

  FormContactFielder(
      {super.key,
      required this.controller,
      required this.hintTextName,
      required this.iconData,
      this.textInputType = TextInputType.text});

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      controller: controller,
      decoration: InputDecoration(
        icon: Icon(iconData),
        hintText: hintTextName,
        filled: true,
      ),
      keyboardType: textInputType,
      validator: (value) {
        if (value == null || value.isEmpty) {
          if (hintTextName == 'Email') {
            return 'Por favor digite um Email válido';
          } else {
            return null;
          }
        }
        if (hintTextName == 'Email' && !validateEmail(value)) {
          return 'Digite um Email Válido';
        }
        return null;
      },
    );
  }
}

validateEmail(String email) {
  final emailReg = RegExp(
      r"^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,253}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,253}[a-zA-Z0-9])?)*$");
  return emailReg.hasMatch(email);
}