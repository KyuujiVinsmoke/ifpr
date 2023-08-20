import 'dart:convert';
import 'dart:html';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class HomeConver extends StatefulWidget {
  const HomeConver({Key? key}) : super(key: key);

  @override
  State<HomeConver> createState() => _HomeConverState();
}

class _HomeConverState extends State<HomeConver> {
  final realControl = TextEditingController();
  final dolarControl = TextEditingController();
  final euroControl = TextEditingController();
  final yenControl = TextEditingController();
  final pesoControl = TextEditingController();
  final guaraniControl = TextEditingController();

  double dolar = 0;
  double euro = 0;
  double yen = 0;
  double peso = 0;
  double guarani = 0;

  @override
  void dispose() {
    realControl.dispose();
    dolarControl.dispose();
    euroControl.dispose();
    yenControl.dispose();
    pesoControl.dispose();
    guaraniControl.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Conversor de Moedas'),
        ),
        body: FutureBuilder<Map>(
          future: getData(),
          builder: (context, snapshot) {
            if (!snapshot.hasError) {
              if (snapshot.connectionState == ConnectionState.done) {
                dolar = double.parse(snapshot.data!['USDBRL']['bid']);
                euro = double.parse(snapshot.data!['EURBRL']['bid']);
                yen = double.parse(snapshot.data!['JPYBRL']['bid']);
                peso = double.parse(snapshot.data!['ARSBRL']['bid']);
                guarani = double.parse(snapshot.data!['PYGBRL']['bid']);
                return SingleChildScrollView(
                  padding: const EdgeInsets.only(top: 15, left: 10, right: 10),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.stretch,
                    children: <Widget>[
                      const Icon(
                        Icons.monetization_on_outlined,
                        size: 120,
                      ),
                      const SizedBox(height: 20),
                      currencyTextField(
                          'Reais', 'R\$ ', realControl, _convertReal),
                      const SizedBox(height: 20),
                      currencyTextField(
                          'Dolares', 'US\$ ', dolarControl, _convertDolar),
                      const SizedBox(height: 20),
                      currencyTextField(
                          'Euros', '€ ', euroControl, _convertEuro),
                      const SizedBox(height: 20),
                      currencyTextField('Yens', '¥ ', yenControl, _convertYen),
                      const SizedBox(height: 20),
                      currencyTextField(
                          'Pesos', '\$ ', pesoControl, _convertPeso),
                      const SizedBox(height: 20),
                      currencyTextField(
                          'Guaranis', '₲ ', guaraniControl, _convertGuarani),
                        Padding(
                          padding: const EdgeInsets.only(top: 15, left: 365, right: 10),
                          child: ElevatedButton.icon(
                          onPressed: () {
                            _clearFields();
                          },
                          icon: Icon(Icons.clear),
                          label: Text('Limpar'),
                          style: ElevatedButton.styleFrom(
                            primary: Color.fromARGB(255, 0, 0, 0),
                            onPrimary: Color.fromARGB(255, 255, 255, 255),
                          ),
                        ),
                      ),   
                    ],
                  ),
                );
              } else {
                return waitingIndicator();
              }
            } else {
              return waitingIndicator();
            }
          },
        ));
  }

  TextField currencyTextField(String label, String prefixText,
      TextEditingController controller, Function f) {
    return TextField(
      controller: controller,
      decoration: InputDecoration(
        labelText: label,
        border: const OutlineInputBorder(),
        prefixText: prefixText,
      ),
      onChanged: (value) => f(value),
      keyboardType: TextInputType.number,
    );
  }

  Center waitingIndicator() {
    return const Center(
      child: CircularProgressIndicator(),
    );
  }

  void _convertReal(String text) {
    if (text.trim().isEmpty) {
      _clearFields();
      return;
    }

    double real = double.parse(text);
    dolarControl.text = (real / dolar).toStringAsFixed(2);
    euroControl.text = (real / euro).toStringAsFixed(2);
    yenControl.text = (real / yen).toStringAsFixed(2);
    pesoControl.text = (real / peso).toStringAsFixed(2);
    guaraniControl.text = (real / guarani).toStringAsFixed(2);
  }

  void _convertDolar(String text) {
    if (text.trim().isEmpty) {
      _clearFields();
      return;
    }

    double dolar = double.parse(text);
    realControl.text = (this.dolar * dolar).toStringAsFixed(2);
    euroControl.text = ((this.dolar * dolar) / euro).toStringAsFixed(2);
    yenControl.text = ((this.dolar * dolar) / yen).toStringAsFixed(2);
    pesoControl.text = ((this.dolar * dolar) / peso).toStringAsFixed(2);
    guaraniControl.text = ((this.dolar * dolar) / guarani).toStringAsFixed(2);
  }

  void _convertEuro(String text) {
    if (text.trim().isEmpty) {
      _clearFields();
      return;
    }

    double euro = double.parse(text);
    realControl.text = (this.euro * euro).toStringAsFixed(2);
    dolarControl.text = ((this.euro * euro) / dolar).toStringAsFixed(2);
    yenControl.text = ((this.euro * euro) / yen).toStringAsFixed(2);
    pesoControl.text = ((this.euro * euro) / peso).toStringAsFixed(2);
    guaraniControl.text = ((this.euro * euro) / guarani).toStringAsFixed(2);
  }

  void _convertYen(String text) {
    if (text.trim().isEmpty) {
      _clearFields();
      return;
    }

    double yen = double.parse(text);
    realControl.text = (this.yen * yen).toStringAsFixed(2);
    dolarControl.text = ((this.yen * yen) / dolar).toStringAsFixed(2);
    euroControl.text = ((this.yen * yen) / euro).toStringAsFixed(2);
    pesoControl.text = ((this.yen * yen) / peso).toStringAsFixed(2);
    guaraniControl.text = ((this.yen * yen) / guarani).toStringAsFixed(2);
  }

  void _convertPeso(String text) {
    if (text.trim().isEmpty) {
      _clearFields();
      return;
    }

    double peso = double.parse(text);
    realControl.text = (this.peso * peso).toStringAsFixed(2);
    dolarControl.text = ((this.peso * peso) / dolar).toStringAsFixed(2);
    euroControl.text = ((this.peso * peso) / euro).toStringAsFixed(2);
    yenControl.text = ((this.peso * peso) / yen).toStringAsFixed(2);
    guaraniControl.text = ((this.peso * peso) / guarani).toStringAsFixed(2);
  }

  void _convertGuarani(String text) {
    if (text.trim().isEmpty) {
      _clearFields();
      return;
    }

    double guarani = double.parse(text);
    realControl.text = (this.guarani * guarani).toStringAsFixed(2);
    dolarControl.text = ((this.guarani * guarani) / dolar).toStringAsFixed(2);
    euroControl.text = ((this.guarani * guarani) / euro).toStringAsFixed(2);
    yenControl.text = ((this.guarani * guarani) / yen).toStringAsFixed(2);
    pesoControl.text = ((this.guarani * guarani) / peso).toStringAsFixed(2);
  }

  void _clearFields() {
    realControl.clear();
    dolarControl.clear();
    euroControl.clear();
    yenControl.clear();
    pesoControl.clear();
    guaraniControl.clear();
  }
}

Future<Map> getData() async {
  //* ENDEREÇO DA API NOVA
  //* https://docs.awesomeapi.com.br/api-de-moedas

  const requestApi =
      "https://economia.awesomeapi.com.br/json/last/USD-BRL,EUR-BRL,JPY-BRL,ARS-BRL,PYG-BRL";
  var response = await http.get(Uri.parse(requestApi));
  return jsonDecode(response.body);

  //* json manual para teste em caso de
  //* problema com a conexão http
/*   var response = {
    "USDBRL": {
      "code": "USD",
      "codein": "BRL",
      "name": "Dólar Americano/Real Brasileiro",
      "high": "5.3388",
      "low": "5.2976",
      "varBid": "0.0382",
      "pctChange": "0.72",
      "bid": "5.3348",
      "ask": "5.3363",
      "timestamp": "1679660987",
      "create_date": "2023-03-24 09:29:47"
    },
    "EURBRL": {
      "code": "EUR",
      "codein": "BRL",
      "name": "Euro/Real Brasileiro",
      "high": "5.7429",
      "low": "5.6772",
      "varBid": "-0.0095",
      "pctChange": "-0.17",
      "bid": "5.7256",
      "ask": "5.7293",
      "timestamp": "1679660999",
      "create_date": "2023-03-24 09:29:59"
    }
  };

  return jsonDecode(jsonEncode(response));
 */
}
