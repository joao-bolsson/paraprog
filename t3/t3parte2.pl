%Defina um predicado somaQuad(X,Y,Q) que seja verdadeiro se Q 
%for a soma dos quadrados de X e Y.

somaQuad(X, Y, Q) :- Z is X*X, W is Y*Y, Q is Z+W.

%Defina um predicado zeroInit(L) que é verdadeiro se L for uma 
%lista que inicia com o número 0 (zero)

zeroInit(L) :- [X|_] = L, X =:= 0.

%Defina um predicado hasEqHeads(L1,L2) que seja verdadeiro se
%as listas L1 e L2 possuírem o mesmo primeiro elemento.

hasEqHeads(L1, L2) :- [X|_] = L1, [Y|_] = L2, X = Y.

%Defina um predicado has5(L) que seja verdadeiro se L for uma 
%lista de 5 elementos. Lembre de como funciona a unificação em 
%Prolog e resolva este exercício sem usar o predicado pré-definido length

list_length([], 0).
list_length([_|X], L) :- 
	list_length(X, N),
	L is N+1.

has5(L) :- list_length(L, X), X = 5.

%Defina um predicado hasN(L,N) que seja verdadeiro se L for uma 
%lista de N elementos. Agora você pode usar um predicado pré-definido.

hasN(L, N) :- length(L, X), X = N.

%Defina um predicado isBin(L) que seja verdadeiro se L for uma 
%lista contendo somente elementos 0 e 1. Use recursão.

isBin([0]).
isBin([1]).
isBin(L) :-
	L = [H|T],
	member(H, [0, 1]),
	isBin(T).

%Defina um predicado mesmaPosicao(A,L1,L2) para verificar se um 
%elemento A está na mesma posição nas listas L1 e L2. Assuma que 
%L1 e L2 sejam permutações de uma lista de elementos distintos, 
%sem repetições. Dica: procure auxílio em predicados pré-definidos.


mesmaPosicao(A, [A|_], [A|_]).
mesmaPosicao(A, L1, L2) :- 
	member(A, L1),
	member(A, L2),
	L1 = [_|T1],
	L2 = [_|T2],
	mesmaPosicao(A, T1, T2).

%INCOMPLETA
%Defina um predicado repete5(E,L) que seja verdadeiro se a lista L for 
%composta por exatamente 5 repetições do elemento E. Não use recursão.


%Defina um predicado recursivo sumQuads(L,S) que seja verdadeiro se S 
%for o somatório dos quadrados dos elementos da lista L

sumQuads([], 0).
sumQuads([H|T], S) :- 
	D is H*H,
	sumQuads(T, N),
	S is D+N.

%Defina um predicado recursivo repete(N,E,L) que seja verdadeiro se a 
%lista L for composta por exatamente N repetições do elemento E.

repete(0, _, []).
repete(N, E, [E|T]) :-
	repete(A, E, T),
	N is A+1.






