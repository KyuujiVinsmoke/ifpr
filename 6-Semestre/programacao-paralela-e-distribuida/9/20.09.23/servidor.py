import xmlrpc.server

def soma(a, b):
    return a + b

server = xmlrpc.server.SimpleXMLRPCServer(("localhost", 8000))

server.register_function(soma, "soma")

print("Servidor RPC rodando na porta 8000...")

try:
    server.serve_forever()

finally:
    server.server_close()