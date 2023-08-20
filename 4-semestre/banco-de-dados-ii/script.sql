--a)	Um relatório contendo o nome de todos os supervisores e o número de 
--funcionários que estão sob suas responsabilidades.

SELECT F1.NOME FROM FUNCIONARIO F1, FUNCIONARIO F2 
WHERE F1.CPF = F2.CPF_SUPERVISOR GROUP BY(F1.NOME) having COUNT(F2.CPF_SUPERVISOR) > 2 
order by(COUNT(F2.CPF_SUPERVISOR)) desc

--b)	Um relatório contendo o nome de todos os funcionários do sexo masculino 
--com mais de 40 anos de idade.

SELECT F.NOME, (EXTRACT(YEAR FROM current_date)-EXTRACT(YEAR FROM F.DATANASC) as 
idade FROM FUNCIONARIO F WHERE F.SEXO = "M" 
AND ((EXTRACT(YEAR FROM current_date)-EXTRACT(YEAR FROM F.DATANASC))>=40);

--c)	Quanto se gasta com o salário dos funcionários que atuam em projetos 
--da cidade de São Paulo? O salário não é acumulativo, ou seja, deve ser 
--calculado independentemente do número de projetos.

create view aux_1(nome,salario) 
as
SELECT distinct F.nome, F.salario FROM FUNCIONARIO_PROJETO FP,PROJETO P, CIDADE C, 
FUNCIONARIO F WHERE FP.COD_PROJETO=P.COD_PROJETO AND P.COD_CIDADE=C.COD_CIDADE 
AND C.NOME LIKE "SAO PAULO" AND FP.CPF_FUNCIONARIO=F.cpf order by(F.nome);

select sum(salario) from aux_1;

--d) Qual o departamento que coordena o maior número de projetos?

create view aux_2(nome,quantidade)
as
select  D.NOME, count(D.NOME) from PROJETO P, DEPARTAMENTO D 
where D.cod_departamento=P.cod_departamento group by (D.Nome) order by(count(D.Nome)) desc;

select nome from aux_2 where quantidade=(select max(quantidade) from aux_2);

-- e)	Qual a relação de departamentos do estado de São Paulo (SP)?

SELECT D.NOME FROM DEPARTAMENTO D, CIDADE C, ESTADO E 
WHERE D.LOCALIZACAO=C.COD_CIDADE AND C.ESTADO=E.SIGLA AND E.SIGLA LIKE "SP";

-- f)	Quem é o gerente que possui maior salário?

Select f.nome as "nome do gerente" from DEPARTAMENTO d, FUNCIONARIO f where d.cpf_gerente=f.cpf
and f.salario = (Select max(f.salario) from DEPARTAMENTO d, FUNCIONARIO f where d.cpf_gerente=f.cpf)
order by(f.salario) desc; 

-- g)	Um relatório contendo o nome e a idade de todas as mulheres que 
-- trabalham em projetos e departamentos em estados do sul do Brasil (PR, SC e RS).

SELECT F.NOME, (EXTRACT(YEAR FROM current_date)-EXTRACT(YEAR FROM DATANASC)) AS IDADE 
FROM FUNCIONARIO F, DEPARTAMENTO D, CIDADE C WHERE F.SEXO LIKE "F" AND 
F.COD_DEPARTAMENTO=D.COD_DEPARTAMENTO AND D.LOCALIZACAO=C.COD_CIDADE 
AND C.ESTADO IN ("PR","SC","RS")
UNION
SELECT F.NOME, (EXTRACT(YEAR FROM current_date)-EXTRACT(YEAR FROM DATANASC)) AS IDADE 
FROM FUNCIONARIO F, FUNCIONARIO_PROJETO FP, PROJETO P, CIDADE C 
WHERE F.SEXO LIKE "F" AND F.CPF=FP.CPF_FUNCIONARIO AND 
FP.COD_PROJETO=P.COD_PROJETO AND P.COD_CIDADE=C.COD_CIDADE 
AND C.ESTADO IN ("PR","SC","RS");