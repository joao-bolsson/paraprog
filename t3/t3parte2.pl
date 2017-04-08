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
