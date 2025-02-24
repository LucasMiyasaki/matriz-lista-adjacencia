# Conversão entre Matriz de Adjacência e Lista de Adjacência

Este projeto em Java implementa a conversão entre dois tipos de representações de grafos: Matriz de Adjacência e Lista de Adjacência. Além disso, ele verifica propriedades importantes dos grafos, como simplicidade, digrafo, completude e regularidade.

## Estrutura do Projeto

- **Main.java**: Classe principal que gerencia a interação com o usuário.
- **MatrizA.java**: Classe que representa a Matriz de Adjacência.
- **ListaA.java**: Classe que representa a Lista de Adjacência.

## Como o Programa Funciona

1. O usuário escolhe entre visualizar a Matriz de Adjacência ou a Lista de Adjacência.
2. A estrutura escolhida é lida a partir de um arquivo de texto (ex.: `MATRIZ.txt`).
3. O programa exibe a estrutura e verifica suas propriedades:
   - Simples
   - Digrafo
   - Regular por emissão
   - Regular por recepção (apenas para matriz)
   - Completo
4. O usuário pode optar por converter a estrutura atual para a outra forma (Matriz → Lista ou Lista → Matriz).

## Formato do Arquivo de Entrada

O arquivo deve conter a matriz de adjacência de um grafo, onde:
- As colunas e linhas representam vértices.
- Os valores são `0` (ausência de aresta) ou `1` (presença de aresta).

Exemplo de `MATRIZ.txt`:
```
A,B,C
0,1,1
1,0,0
1,0,0
```

## Como Executar

1. Compile o projeto:
```
javac Main.java MatrizA.java ListaA.java
```
2. Execute o programa:
```
java Main
```
3. Siga as instruções exibidas no terminal.
