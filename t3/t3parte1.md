
### 1) Considere a seguinte base de fatos e regras: ###

##### Trace 1) [trace]  ?- avo(joao, Y). #####

|Trace output | Commentary|
|------------ | :----------:|
|Call: (8) avo(joao, _7126) ? creep | Substitui Y por variável |
|   Call: (9) pai(joao, _7344) ? creep | Procura fato com pai sendo joao|
|   Exit: (9) pai(joao, jose) ? creep | Sucesso! Acha fato com filho josé|
|   Call: (9) pai(jose, _7126) ? creep | Procura fato com pai sendo josé|
|   Fail: (9) pai(jose, _7126) ? creep | Falha! Não acha fato correspondente |
|   Fail: (8) avo(joao, _7126) ? creep | João não tem neto |
|false. | João não é avô|

##### Trace 2) [trace]  ?- avo(roberto, Y). #####

|Trace output | Commentary|
|------------ | :----------:|
|   Call: (8) avo(roberto, _6950) ? creep |  	Substitui Y por variavel |
|   Call: (9) pai(roberto, _7168) ? creep | Procura fato com pai sendo roberto|
|   Exit: (9) pai(roberto, joao) ? creep | Sucesso! Acha fato com filho joao|
|   Call: (9) pai(joao, _6950) ? creep | Procura fato com pai sendo joao|
|   Exit: (9) pai(joao, jose) ? creep | Sucesso! Acha fato com filho jose|
|   Exit: (8) avo(roberto, jose) ? creep | roberto é avo de jose|
|Y = jose ; | neto Y correspondente a jose|
|   Redo: (9) pai(roberto, _7168) ? creep | Procura fato com pai sendo roberto|
|   Exit: (9) pai(roberto, julio) ? creep | Sucesso! Acha fato com filho julio|
|   Call: (9) pai(julio, _6950) ? creep | Procura fato com pai sendo julio|
|   Exit: (9) pai(julio, marcos) ? creep | Sucesso! Acha fato com filho marcos|
|   Exit: (8) avo(roberto, marcos) ? creep | roberto é avo de marcos|
|Y = marcos ; | neto Y correspondente a marcos|
|   Redo: (9) pai(julio, _6950) ? creep | Procura outro fato com pai julio|
|   Exit: (9) pai(julio, mario) ? creep | Sucesso! Acha fato com filho mario|
|   Exit: (8) avo(roberto, mario) ? creep | roberto é avo de mario|
|Y = mario. | neto Y correspondente a mario|

### 2) Mostre o trace comentado desta consulta: (OBI) ###

##### Trace 1) [trace]  ?- azulejos(120, A). #####

|Trace output | Commentary|
|------------ | :----------:|
|   Call: (8) azulejos(120, _992) ? creep | A substituido por variavel única |
|   Call: (9) 120>0 ? creep | testa 120>0|
|   Exit: (9) 120>0 ? creep | Sucesso! teste correto|
|   Call: (9) _1218 is floor(sqrt(120)) ? creep | Executa operação em variável|
|   Exit: (9) 10 is floor(sqrt(120)) ? creep | Sucesso! Operação resulta em 10 e está correta|
|   Call: (9) _1230 is 120-10*10 ? creep | Executa segunda operação|
|   Exit: (9) 20 is 120-10*10 ? creep | Sucesso! Operação resulta em 20 e está correta|
|   Call: (9) azulejos(20, _1232) ? creep | Chama nível 2 da recursão com resultado 20|
|   Call: (10) 20>0 ? creep | testa 20>0|
|   Exit: (10) 20>0 ? creep | Sucesso! teste correto|
|   Call: (10) _1238 is floor(sqrt(20)) ? creep | Executa operação em variável|
|   Exit: (10) 4 is floor(sqrt(20)) ? creep | Sucesso! Operação resulta em 4 e está correta|
|   Call: (10) _1250 is 20-4*4 ? creep | Executa segunda operação em variável|
|   Exit: (10) 4 is 20-4*4 ? creep | Sucesso! Operação resultada em 4 está correta|
|   Call: (10) azulejos(4, _1252) ? creep | Chama nível 3 da recursão com resultado 4|
|   Call: (11) 4>0 ? creep | testa 4>0|
|   Exit: (11) 4>0 ? creep | Sucesso! teste correto|
|   Call: (11) _1258 is floor(sqrt(4)) ? creep | Executa operação em variável|
|   Exit: (11) 2 is floor(sqrt(4)) ? creep | Sucesso! Resultado 2 está correto|
|   Call: (11) _1270 is 4-2*2 ? creep | Executa segunda operação em variável|
|   Exit: (11) 0 is 4-2*2 ? creep | Sucesso! Resultado 0 correto|
|   Call: (11) azulejos(0, _1272) ? creep | Chama nível 3 de recursão com 0|
|   Exit: (11) azulejos(0, 0) ? creep | Encontra fato correspondente e retorna ao nível 3|
|   Call: (11) _1276 is 1+0 ? creep |Executa operação em variável |
|   Exit: (11) 1 is 1+0 ? creep | Sucesso! Resultado 1 correto|
|   Exit: (10) azulejos(4, 1) ? creep | Retorna ao nível 2 de recursão|
|   Call: (10) _1282 is 1+1 ? creep | Executa operação de incremento em variável|
|   Exit: (10) 2 is 1+1 ? creep | Sucesso! Resultado 2 correto|
|   Exit: (9) azulejos(20, 2) ? creep | Retorna para primeiro nível|
|   Call: (9) _992 is 1+2 ? creep | Executa operação em variável|
|   Exit: (9) 3 is 1+2 ? creep | Sucesso! Resultado 3 correto|
|   Exit: (8) azulejos(120, 3) ? creep | Regra sucede|
|A = 3 . | Regra sucede com valor de A igual a 3|

### 3) Faça a execução passo-a-passo de uma consulta com o predicado escolhido. ###

- predicado recursivo para encontrar o tamanho de uma lista:

list_length([], 0).
list_length([_|X], L) :-
        list_length(X, N),
        L is N+1.

##### Trace) [trace]  ?- list_length([a, b, c], L).#####
|Trace output | Commentary|
|------------ | :----------:|
|   Call: (8) list_length([a, b, c], _8586) ? creep | Substitui L por variavel |
|   Call: (9) list_length([b, c], _8826) ? creep | Chama o nivel 2 da recursão|
|   Call: (10) list_length([c], _8826) ? creep | Chama o nível 3 da recursão|
|   Call: (11) list_length([], _8826) ? creep | Chama o nível 4 da recursão|
|   Exit: (11) list_length([], 0) ? creep | Lista vazia|
|   Call: (11) _8830 is 0+1 ? creep |Executa operação em variável |
|   Exit: (11) 1 is 0+1 ? creep | Sucesso! resultado correto|
|   Exit: (10) list_length([c], 1) ? creep | Retorna ao nível 3 da recursão com 1 elemento|
|   Call: (10) _8836 is 1+1 ? creep | Executa operação em variável|
|   Exit: (10) 2 is 1+1 ? creep | Sucesso! resultado correto|
|   Exit: (9) list_length([b, c], 2) ? creep | Retorna ao nível 2 da recursão com 2 elementos|
|   Call: (9) _8586 is 2+1 ? creep |  Executa operação em variável|
|   Exit: (9) 3 is 2+1 ? creep | Sucesso! resultado correto|
|   Exit: (8) list_length([a, b, c], 3) ? creep | Retorna ao nível 1 da recursão com 3 elementos|
|L = 3. | Regra sucede com valor L = 3|

