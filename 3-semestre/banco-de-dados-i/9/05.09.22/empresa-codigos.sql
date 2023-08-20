A)
select a.nome_funcionario, count(b.cpf_supervisor_funcionario)
from empresa_funcionario a
inner join empresa_funcionario b
on a.cpf_funcionario = b.cpf_supervisor_funcionario
group by a.cpf_funcionario

B)
select a.nome_funcionario, a.datanasc_funcionario
from empresa_funcionario a
where a.sexo_funcionario = 'M'
and (datediff(now(), a.datanasc_funcionario) /30/12) > 40

C)
select sum(a.salario_funcionario)
from empresa_funcionario a
inner join empresa_funcionario_projeto b
on a.cpf_funcionario = b.cpf_funcionario
inner join empresa_projeto c
on b.codigo_projeto = c.codigo_projeto
where c.codigo_cidade = 7

D)

E)
select nome_departamento 
from empresa_departamento
where codigo_cidade in (7)

F)
select a.nome_funcionario
from empresa_funcionario a
inner join empresa_departamento b 
on a.cpf_funcionario = b.cpf_gerente_departamento
where a.salario_funcionario = (select max(a.salario_funcionario) 
from empresa_funcionario a);

G)
select a.nome_funcionario, a.datanasc_funcionario
from empresa_funcionario a
where a.sexo_funcionario = 'F'
and codigo_departamento in (4)