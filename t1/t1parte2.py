# coding=utf-8
"""
Parte 2 do Trabalho 1 - Paradigmas de Programação (UFSM)

@author João Bolsson (jvmarques@inf.ufsm.br)
@since 2017, 14 Mar.
"""

import datetime

'''
1) Escreva uma função que receba uma lista de nomes e retorne uma lista com a string "Sr. " adicionada ao início de
cada nome.
'''


def nomeia(nomes):
    # caracteres acentuados saem errado
    return list(map(lambda x: "Sr. " + str(x), nomes))

'''
2) Escreva uma função que, dada uma lista de números, calcule 3n*2 + 2/n + 1 para cada número n da lista.
'''


def applyFormula(numbers):
    return list(map(lambda x: (3 * x * 2) + (2 / x) + 1, numbers))

'''
3) Crie uma função que receba uma lista de nomes e retorne outra lista com somente aqueles nomes que terminarem com a
letra 'a'.
'''


def filterNames(names):
    return list(filter(lambda x: x[-1] == 'a', names))

'''
4) Escreva uma função que, dada uma lista de idades de pessoas no ano atual, retorne uma lista somente com as idades de
quem nasceu depois de 1970. Para testar a condição, sua função deverá subtrair a idade do ano atual.
'''


def filterAges(ages):
    current_year = datetime.datetime.now().year
    return list(filter(lambda x: (current_year - x) > 1970, ages))

'''
5) O código abaixo é escrito em Python imperativo. Escreva um código equivalente usando programação funcional.
numbers = [1, 2, 3, 4]
new_numbers = []
for number in numbers:
 new_numbers.append(number * 2)
print(new_numbers)
'''


def doubleNumbers(numbers):
    return list(map(lambda x: x * 2, numbers))
