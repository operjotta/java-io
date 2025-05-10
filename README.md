Manipulação de Ficheiros (Java IO)
=============================================

---------------------------------------------

A manipulação de ficheiros é uma capacidade fundamental na programação,
que permite que aplicações leiam e escrevam dados em ficheiros na memória
persistente do computador. Este repositório demonstra as diferentes formas
de realizar as operações de escrita e leitura em ficheiros (de texto ou
ainda binários) no computador.

A API de Entrada e Saída ([Java IO](https://docs.oracle.com/javase/8/docs/api/java/io/package-summary.html))
fornece mecanismos poderosos para estas operações, baseados principalmente
em [streams](https://pt.wikipedia.org/wiki/Stream_(computa%C3%A7%C3%A3o)#:~:text=Na%20ci%C3%AAncia%20da%20computa%C3%A7%C3%A3o%2C%20stream%2C%20em%20portugu%C3%AAs%20fluxo%2C%20%C3%A9%20uma%20sequ%C3%AAncia%20de%20elementos%20de%20dados%20disponibilizados%20ao%20longo%20do%20tempo.%20Um%20fluxo%20pode%20ser%20considerado%20como%20itens%20em%20uma%20esteira%20transportadora%20sendo%20processados%20um%20por%20vez%2C%20em%20vez%20de%20em%20grandes%20lotes.),
que facilitam o processo sequencial de dados.

# Principais Classes para operações de E/S

- ``InputStream``
- ``OutputStream``
- ``FileInputStream``
- ``FielOutputStream``
- ``Reader``
- ``Writer``
- [``FileReader``](#a-classe-filereader-e-bufferedreader)
- [``BufferedReader``](#a-classe-filereader-e-bufferedreader)
- ``FileWriter``
- [``Scanner``](#a-classe-scanner)
- [``Files``](#a-classe-files)

# A classe ``FileReader`` e ``BufferedReader``

A classe ``FileReader`` pode ser utilizada para ler ficheiros de
caracteres, enquanto ``BufferedReader`` melhora a eficiência ao
armazenar os dados de entrada num *buffer*. É comum combinar as
duas classes para leitura de ficheiros de texto.

````java
try(FileReader fr = new FileReader("historia_java.txt");
    BufferedReader reader = new BufferedReader(fr)) {
    String linha;
    while ((linha = reader.readLine()) != null) {
        System.out.println(linha);
    }
}
````

Este método lê o conteúdo do ficheiro [historia_java.txt](historia_java.txt)
linha por linha, as imprime na linha de comandos. Este método é particularmente
útil para ficheiros de tamanho considerável, pois não carrega todo
conteúdo para a memória de uma vez só. A classe [LeituraLinhaPorLinha](src/LeituraLinhaPorLinha.java)
contém métodos que demonstram o uso destas duas classes para ler o conteúdo de
ficheiros de texto.

# A classe ``Scanner``

A classe [``Scanner``](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)
também pode ser utilizada para ler ficheiros de texto. Esta oferece mais
funcionalidades para maior tokenizar a entrada.

O ficheiro [scanner.txt](scanner.txt) contém uma simples lista de produtos a serem adquiridos,
a quantidade e os seus preços correspondentes. Podemos utilizar esta classe para ler o conteúdo
e converter os dados diretamente para os tipos de dados Java correspondente.

````java
File file = new File("scanner.txt");
try (Scanner scanner = new Scanner(file)) {
    while(scanner.hasNext()) {
        String produto = scanner.next();
        int qtd = scanner.nextInt();
        double preco = scanner.nextDouble();
        boolean adquirido = scanner.nextBoolean();
        
        System.out.println("Produto: " + produto);
        System.out.println("Quantidade: " + qtd);
        System.out.println("Preço: " + preco);
        System.out.println("Adquirido: " + adquirido);
    }
} catch(FileNotFoundException ex) {
    System.err.println("Ficheiro não encontrado!");
}
````

Este fragmento de código demonstra como ler o conteúdo de um ficheiro de texto,
que neste caso é uma lista com produtos com a quantidade e o preço por ser adquiridos,
formata o conteúdo do ficheiro para o tipo de dado correspondente Java e imprime
o total por se pagar pelos produtos. Consulte a classe [LerFormatarComScanner](src/LerFormatarComScanner.java)
para melhores demonstrações e alguns truques de formatação.

# A classe ``Files``

Introduzida no JDK 7, esta classe oferece uma abordagem mais concisa para leitura
e escrita em ficheiros, incluindo a leitura de todas as linhas para uma lista, ou ainda
de todo o conteúdo para uma String.

````java
File file = new File("historia_java.txt");
try {
    List<String> linhas = Files.readAllLines(file.toPath());
    for (String linha : linhas) {
        System.out.println(linha);
    }
} catch(IOException ex) {
    System.err.println("Erro de leitura: " + ex.getMessage());
}
````

Este fragmento de código lê todas as linhas do ficheiro [historia_java.txt](historia_java.txt)
numa lista e a seguir as imprime na linha de comandos.

# Outras classes e operações

Para melhor compreender as operações consulte o diretório [src](src), este contém classes
para cada uma das classes da API do Java para as operações de leitura e escrita.

Para começar, clone o repositório executando os comandos abaixo, ou clique [aqui](https://github.com/operjotta/java-io/archive/refs/heads/main.zip)
e faça download.

# Clone do repositório

````shell
git clone https://github.com/operjotta/java-io
````

# Executar o projecto
Com o repositório transferido, pode abrir com a sua IDE favorita, execute as classes
e observe o resultado. Ou ainda execute comandos na linha de comandos para compilar
e executar as classes.

````shell
javac -d out -cp src src/[nome-da-ficheiro.java]
java -cp out [nome-da-classe]
````
