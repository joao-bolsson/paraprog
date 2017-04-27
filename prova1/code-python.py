# coding=utf-8
"""
Prova 1 - Paradigmas de Programação (UFSM)

@author João Bolsson (jvmarques@inf.ufsm.br)
@since 2017, 17 Apr.
"""
import operator

'''
7)
'''


def filterVowels(names):
    return list(filter(lambda x: x[0] in 'aeiouAEIOU', names))


'''
8)
'''


def myPow(number):
    exp = list(range(0, number + 1))
    return list(map(lambda x: operator.pow(2, x), exp))
