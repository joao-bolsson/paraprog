# coding=utf-8
"""
Parte 1 do Trabalho 2 - Paradigmas de Programação (UFSM)

@author João Bolsson (jvmarques@inf.ufsm.br)
@since 2017, 25 Mar.
"""

'''
1) Defina uma função addSuffix(suf,nomes) que retorne a lista de nomes com o sufixo suf adicionado.
'''


def addSuffix(suf, nomes):
    return [x + suf for x in nomes]


'''
2) Escreva uma função countShorts(words), que receba uma lista de palavras e retorne a quantidade de palavras
dessa lista que possuem menos de 5 caracteres.
'''


def countShorts(words):
    return len([word for word in words if len(word) < 5])


'''
3) Defina uma função stripVowels(s) que receba uma string e retire suas vogais.
'''


def stripVowels(s):
    return ''.join([x for x in s if x not in 'aeiouAEIOU'])


'''
4) Defina uma função hideChars(s) que receba uma string, possivelmente contendo espaços, e que retorne outra
string substituindo os demais caracteres por '-', mas mantendo os espaços.
'''


def hideChars(s):
    return ''.join([x if x is ' ' else '-' for x in s])


'''
5) Defina uma função que receba um número n e retorne uma tabela de números de 1 a n e seus quadrados, conforme
os exemplos abaixo (você vai usar tuplas em Python):
'''


def genTable(num):
    return [(x, x * x) for x in range(1, num + 1)]


'''
6) Defina uma função que receba uma lista de palavras e retorne uma string contendo o primeiro e o último
caracter de cada palavra da lista.
'''


def genCode(words):
    return ''.join([''.join([x[0], x[-1]]) for x in words])


'''
7) Defina uma função myZip(l1,l2) que reproduza o comportamento da função zip do Python.
'''


def myZip(l1, l2):
    return [(l1[x], l2[x]) for x in range(0, len(l1)) if x in range(0, len(l2))]


'''
8) Escreva uma função enumerate(words) que numere cada palavra da lista recebida
adiciona prefixo my pois escondia campo incorporado
'''


def myEnumerate(words):
    return [(x + 1, words[x]) for x in range(0, len(words))]


'''
9) Escreva uma função isBin(s) que verifique se a string recebida representa um número binário.
'''


def isBin(s):
    return len([x for x in s if x in '01']) == len(s)
