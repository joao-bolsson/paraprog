
### 1) Considere a seguinte base de fatos e regras: ###

##### Trace 1) [trace]  ?- avo(joao, Y). #####

|Trace output | Commentary|
|------------ | :----------:|
|Call: (8) avo(joao, _7126) ? creep | Regra avo invocada |
|   Call: (9) pai(joao, _7344) ? creep | Verifica quem é o pai do joao|
|   Exit: (9) pai(joao, jose) ? creep | Sucesso! jose é pai do joao|
|   Call: (9) pai(jose, _7126) ? creep | Verifica quem é pai do jose|
|   Fail: (9) pai(jose, _7126) ? creep | José não tem pai|
|   Fail: (8) avo(joao, _7126) ? creep | |
|false. | joao nao tem avo|

##### Trace 2) [trace]  ?- avo(roberto, Y). #####

|Trace output | Commentary|
|------------ | :----------:|
|   Call: (8) avo(roberto, _6950) ? creep | comentar |
|   Call: (9) pai(roberto, _7168) ? creep | |
|   Exit: (9) pai(roberto, joao) ? creep | |
|   Call: (9) pai(joao, _6950) ? creep | |
|   Exit: (9) pai(joao, jose) ? creep | |
|   Exit: (8) avo(roberto, jose) ? creep | |
|Y = jose ; | |
|   Redo: (9) pai(roberto, _7168) ? creep | |
|   Exit: (9) pai(roberto, julio) ? creep | |
|   Call: (9) pai(julio, _6950) ? creep | |
|   Exit: (9) pai(julio, marcos) ? creep | |
|   Exit: (8) avo(roberto, marcos) ? creep | |
|Y = marcos ; | |
|   Redo: (9) pai(julio, _6950) ? creep | |
|   Exit: (9) pai(julio, mario) ? creep | |
|   Exit: (8) avo(roberto, mario) ? creep | |
|Y = mario. | |

### 2) Mostre o trace comentado desta consulta: (OBI) ###

##### Trace 1) [trace]  ?- azulejos(120, A). #####

|Trace output | Commentary|
|------------ | :----------:|
|   Call: (8) azulejos(120, _992) ? creep | comentar |
|   Call: (9) 120>0 ? creep | |
|   Exit: (9) 120>0 ? creep | |
|   Call: (9) _1218 is floor(sqrt(120)) ? creep | |
|   Exit: (9) 10 is floor(sqrt(120)) ? creep | |
|   Call: (9) _1230 is 120-10*10 ? creep | |
|   Exit: (9) 20 is 120-10*10 ? creep | |
|   Call: (9) azulejos(20, _1232) ? creep | |
|   Call: (10) 20>0 ? creep | |
|   Exit: (10) 20>0 ? creep | |
|   Call: (10) _1238 is floor(sqrt(20)) ? creep | |
|   Exit: (10) 4 is floor(sqrt(20)) ? creep | |
|   Call: (10) _1250 is 20-4*4 ? creep | |
|   Exit: (10) 4 is 20-4*4 ? creep | |
|   Call: (10) azulejos(4, _1252) ? creep | |
|   Call: (11) 4>0 ? creep | |
|   Exit: (11) 4>0 ? creep | |
|   Call: (11) _1258 is floor(sqrt(4)) ? creep | |
|   Exit: (11) 2 is floor(sqrt(4)) ? creep | |
|   Call: (11) _1270 is 4-2*2 ? creep | |
|   Exit: (11) 0 is 4-2*2 ? creep | |
|   Call: (11) azulejos(0, _1272) ? creep | |
|   Exit: (11) azulejos(0, 0) ? creep | |
|   Call: (11) _1276 is 1+0 ? creep | |
|   Exit: (11) 1 is 1+0 ? creep | |
|   Exit: (10) azulejos(4, 1) ? creep | |
|   Call: (10) _1282 is 1+1 ? creep | |
|   Exit: (10) 2 is 1+1 ? creep | |
|   Exit: (9) azulejos(20, 2) ? creep | |
|   Call: (9) _992 is 1+2 ? creep | |
|   Exit: (9) 3 is 1+2 ? creep | |
|   Exit: (8) azulejos(120, 3) ? creep | |
|A = 3 ; | |
|   Redo: (11) azulejos(0, _1272) ? creep | |
|   Call: (12) 0>0 ? creep | |
|   Fail: (12) 0>0 ? creep | |
|   Fail: (11) azulejos(0, _1272) ? creep | |
|   Fail: (10) azulejos(4, _1252) ? creep | |
|   Fail: (9) azulejos(20, _1232) ? creep | |
|   Fail: (8) azulejos(120, _992) ? creep | |
|false. | |

### 3) Faça a execução passo-a-passo de uma consulta com o predicado escolhido. ###

- predicado recursivo para encontrar o tamanho de uma lista:

list_length([], 0).
list_length([_|X], L) :-
        list_length(X, N),
        L is N+1.

##### Trace) [trace]  ?- list_length([a, b, c], L).#####
|Trace output | Commentary|
|------------ | :----------:|
|   Call: (8) list_length([a, b, c], _8586) ? creep | comentar |
|   Call: (9) list_length([b, c], _8826) ? creep | |
|   Call: (10) list_length([c], _8826) ? creep | |
|   Call: (11) list_length([], _8826) ? creep | |
|   Exit: (11) list_length([], 0) ? creep | |
|   Call: (11) _8830 is 0+1 ? creep | |
|   Exit: (11) 1 is 0+1 ? creep | |
|   Exit: (10) list_length([c], 1) ? creep | |
|   Call: (10) _8836 is 1+1 ? creep | |
|   Exit: (10) 2 is 1+1 ? creep | |
|   Exit: (9) list_length([b, c], 2) ? creep | |
|   Call: (9) _8586 is 2+1 ? creep | |
|   Exit: (9) 3 is 2+1 ? creep | |
|   Exit: (8) list_length([a, b, c], 3) ? creep | |
|L = 3. | |

