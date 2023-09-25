import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:8000/")

try:
    num1 = float(input("Digite o primeiro número: "))
    num2 = float(input("Digite o segindo número: "))

    resultado_soma = proxy.soma(num1, num2)
    print(f"{num1} + {num2} = {resultado_soma}")
except ValueError as e:
    print("Erro:", e)
except Exception as e:
    print("Erro:", e)