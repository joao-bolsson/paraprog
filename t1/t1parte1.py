# coding=utf-8
"""
Parte 1 do Trabalho 1 - Paradigmas de Programação (UFSM)

@author João Bolsson (jvmarques@inf.ufsm.br)
@since 2017, 12 Mar.
"""

'''
1) Defina uma função somaQuad(x,y) que calcule a soma dos quadrados de dois números x e y.
'''


def somaQuad(x, y):
    quad_x = x * x
    quad_y = y * y
    return quad_x + quad_y


'''
2) Crie uma função hasEqHeads(l1,l2) que verifique se as listas l1 e l2 possuem o mesmo primeiro elemento.
'''


def hasEqHeads(l1, l2):
    return l1[0] == l2[0]


'''
3) Escreva uma função que receba uma lista de nomes e retorne uma lista com a string "Sr. " adicionada ao início de
cada nome. Defina uma função auxiliar para ajudar neste exercício.
'''


def nomeia(nomes):
    # caracteres acentuados saem errado
    return list(map(lambda x: "Sr. " + str(x), nomes))


'''
4) Crie uma função que receba uma string e retorne o número de espaços nela contidos.
Defina uma função auxiliar para ajudar neste exercício.
'''


def countSpaces(string):
    return len(list(filter(lambda x: x == ' ', string)))


'''
5) Escreva uma função que, dada uma lista de números, calcule 3n*2 + 2/n + 1 para cada número n da lista.
Defina uma função auxiliar para ajudar neste exercício.
'''


def applyFormula(numbers):
    return list(map(lambda x: (3 * x * 2) + (2 / x) + 1, numbers))


'''
6) Escreva uma função que, dada uma lista de números, retorne uma lista com apenas os que forem negativos.
Defina uma função auxiliar para ajudar neste exercício.
'''


def filterNegatives(numbers):
    return list(filter(lambda x: x < 0, numbers))


'''
7) Escreva uma função que receba uma lista de números e retorne somente os que estiverem entre 1 e 100, inclusive.
Defina uma função auxiliar para ajudar neste exercício.
'''


def filterLessThan100(numbers):
    return list(filter(lambda x: (1 < x < 100), numbers))


'''
8) Escreva uma função que receba uma lista de números e retorne somente aqueles que forem pares.
Defina uma função auxiliar para ajudar neste exercício.
'''


def filterEven(numbers):
    return list(filter(lambda x: x % 2 == 0, numbers))


'''
9) Crie uma função charFound(c,s) que verifique se o caracter c está contido na string. O resultado deve ser True ou
False. Você não deve usar o operador in. Defina uma função auxiliar para ajudar neste exercício.
'''


def compare(c):
    def isTheSameChar(x):
        return x == c
    return isTheSameChar


def charFound(c, s):
    # TODO: retornar true assim que encontrar o valor procurado
    result = list(filter(compare(c), s))
    return len(result) > 0

'''
10) Escreva uma função que receba uma lista de strings e retorne uma nova lista com adição de marcações
HTML (p.ex.: <B> e </B>) antes e depois de cada string.
'''


def toHTML(strings):
    return list(map(lambda x: '<b>' + x + '</b>', strings))
