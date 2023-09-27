public class PP2 {
    public static String extractInitials(String frase) {
        String[] palavras = frase.split(" "); // split divide a string em substring sempre que tiver o " "(espaço em
                                              // branco)
        StringBuilder iniciais = new StringBuilder(); // constroi a seqeuncia de iniciais

        for (String pal : palavras) { // percorre cada elemento do array palavras, ou seja, cada palavra que foi
                                      // obtida após a divisão da frase original.
            if (!pal.isEmpty()) { // Verifica se a palavra não está vazia. Isso é feito para evitar que espaços em
                                  // branco consecutivos gerem iniciais extras. Se a palavra estiver vazia, ela é
                                  // ignorada.
                iniciais.append(pal.charAt(0)); // primeira letra da palavra é pega com o charAt(0), e colocada no
                                                // array com o initials.appaend
            }
        }

        return iniciais.toString(); // pega o initial e coloca numa string
    }

    public static void main(String args[]) {
        String frase;
        frase = MyIO.readLine();
        String extractedInitials = extractInitials(frase);
        System.out.println(extractedInitials);
    }
}
