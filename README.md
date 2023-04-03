# Imersão Java Alura 
## Aulas 1-2-3 - Criar o Sticker com a capa do filme

-Consumir a API pública do IMDB
-Recuparar a lista dos 250 filmes mais bem avaliados no formato JSon
-Criar um sticker com uma frase personalizada 

Foi utilizada a biblioteca java.awt para realizar esta tarefa
Primeiro a imagem original é lida em um BufferedImage através de um InputStream
Depois é criada uma nova imagem um pouco mais alta que a original, deixando um espaço para o texto.
É montado o texto através do método drawString

## Desafios
-Criar o diretório de saída dinamicamente caso não exista
-Centralizar o texto
-Utilizar uma fonte personalizada
-Colocar um contorno (outline) no texto
-Colocar uma imagem pessoal, de acordo com a nota do filme
