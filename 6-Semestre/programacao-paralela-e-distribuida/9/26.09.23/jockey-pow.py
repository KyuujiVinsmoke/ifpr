import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:8000/")

while True:
    escolha_usuario = input("Escolha Pedra, Papel ou Tesoura (ou digite 'sair' para encerrar): ").strip().capitalize()

    if escolha_usuario.lower() == "sair":
        break

    resultado = proxy.jogar_jogo(escolha_usuario)
    print(resultado)