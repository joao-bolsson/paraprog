# coding=utf-8
"""
Parte 2 do Trabalho 1 - Paradigmas de Programação (UFSM)

@author João Bolsson (jvmarques@inf.ufsm.br)
@since 2017, 14 Mar.
"""


'''
1) Escreva uma função que receba uma lista de nomes e retorne uma lista com a string "Sr. " adicionada ao início de
cada nome.
'''


def nomeia(nomes):
    # caracteres acentuados saem errado
    assert isinstance(nomes, list)
    return list(map(lambda x: "Sr. " + str(x), nomes))

'''
2) Escreva uma função que, dada uma lista de números, calcule 3n*2 + 2/n + 1 para cada número n da lista.
'''


def applyFormula(numbers):
    assert isinstance(numbers, list)
    return list(map(lambda x: (3 * x * 2) + (2 / x) + 1, numbers))