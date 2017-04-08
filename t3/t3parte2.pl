%Defina um predicado somaQuad(X,Y,Q) que seja verdadeiro se Q 
%for a soma dos quadrados de X e Y.

somaQuad(X, Y, Q) :- Z is X*X, W is Y*Y, Q is Z+W.

%Defina um predicado zeroInit(L) que é verdadeiro se L for uma 
%lista que inicia com o número 0 (zero)

zeroInit(L) :- nth0(0, L, X), X is 0.

%Defina um predicado hasEqHeads(L1,L2) que seja verdadeiro se
%as listas L1 e L2 possuírem o mesmo primeiro elemento.

%hasEqHeads(L1, L2) :- nth0(0, L1, nth0(0, L2, Y)).
