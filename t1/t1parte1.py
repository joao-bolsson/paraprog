# coding=utf-8
"""
Parte 1 do Trabalho 1 - Paradigmas de Programação (UFSM)

@author João Bolsson (jvmarques@inf.ufsm.br)
@since 2017, 12 Mar.
"""

'''
Defina uma função somaQuad(x,y) que calcule a soma dos quadrados de dois números x e y.
'''


def somaQuad(x, y):
    quad_x = x * x
    quad_y = y * y
    return quad_x + quad_y


'''
Crie uma função hasEqHeads(l1,l2) que verifique se as listas l1 e l2 possuem o mesmo primeiro elemento.
'''


def hasEqHeads(l1, l2):
    assert isinstance(l1, list)
    assert isinstance(l2, list)

    return l1[0] == l2[0]
