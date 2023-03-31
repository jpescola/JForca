package jogoforca;

import java.util.Scanner;

/**
 *
 * @author jpescola
 */
public class JogoForca {

    /**
     * A04ex10 Crie um jogo da forca utilizando expressões regulares; Solicite
     * uma palavra para começar o jogo; O usuário tem 7 chances, onde deve
     * especificar uma letra e, a cada letra, o sistema deve completar a palavra
     * ou diminuir uma vida; Se o usuário acertar a palavra, ou as vidas
     * acabarem, o jogo termina.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String palavra, resultado = "";
        int vidas = 7;

        System.out.print("Digite a palavra:");
        palavra = s.next();

        // criando o rótulo
        for (int i = 0; i < palavra.length(); i++) {
            resultado += "-";
        }

        do {
            System.out.println(resultado + " [vidas:" + vidas + "]");
            System.out.print("palpite: ");
            String p = s.next();

//            String regex = ".*" + p + ".*";
            String regex = ".*[a-z&&[" + p + "]].*";
//            System.out.println("regex: " + regex);
            if (palavra.matches(regex)) {// acertou

//            if (palavra.contains(p)) {
                for (int i = 0; i < resultado.length(); i++) {
                    if (resultado.charAt(i) == '-' && p.charAt(0) == palavra.charAt(i)) {

                        String prefixo = resultado.substring(0, i);
                        String sufixo = resultado.substring(i + 1, resultado.length());
                        resultado = prefixo + p + sufixo;

                        if (!resultado.contains("-")) {
                            System.out.println("Você ganhou!!!");
                            vidas = 0;
                        }

                    }
                }
            } else { // não acertou
                if (p.matches("[a-z]")) {
                    vidas--;
                } else {
                    System.out.println("    -> caractere inválido, tente novamente!");
                }
            }

        } while (vidas > 0);
        System.out.println("Game over!");
    }

}
