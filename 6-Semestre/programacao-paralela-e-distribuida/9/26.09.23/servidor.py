import random
from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

opcoes = ["Pedra", "Papel", "Tesoura"]

def jogar_jogo(usuario_escolha):
    servidor_escolha = random.choice(opcoes)
    if usuario_escolha not in opcoes:
        return "Escolha inválida. Escolha entre Pedra, Papel ou Tesoura."
    if usuario_escolha == servidor_escolha:
        return f"Empate! Ambos escolheram {usuario_escolha}."
    if (
        (usuario_escolha == "Pedra" and servidor_escolha == "Tesoura") or
        (usuario_escolha == "Papel" and servidor_escolha == "Pedra") or
        (usuario_escolha == "Tesoura" and servidor_escolha == "Papel")
    ):
        return f"Você ganhou! Você escolheu {usuario_escolha}, e o servidor escolheu {servidor_escolha}."
    else:
        return f"Você perdeu! Você escolheu {usuario_escolha}, e o servidor escolheu {servidor_escolha}."

server = SimpleXMLRPCServer(("localhost", 8000))

server.register_function(jogar_jogo)

print("Servidor RPC em execução na porta 8000...")
server.serve_forever()