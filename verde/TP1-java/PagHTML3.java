import java.io.*;
import java.net.*;

public class PagHTML3 {
    public static String getHtml(String endereco) { // código do gitHub
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }

    public static String confereLet(String codfonte) { // conferir as letras
        String resposta = ""; // cria uma string de resposta
        // crei adiversas variaveis
        int a1 = 0, e1 = 0, i1 = 0, o1 = 0, u1 = 0; // a,e,i,o,u
        int a2 = 0, e2 = 0, i2 = 0, o2 = 0, u2 = 0; // á,é,í,ó,ú
        int a3 = 0, o3 = 0; // ã,õ
        int a4 = 0, e4 = 0, i4 = 0, o4 = 0, u4 = 0;// â,ê,î,ô,û
        int a5 = 0, e5 = 0, i5 = 0, o5 = 0, u5 = 0; // à,è,ì,ò,ù
        int consoante = 0; // consoante
        int br = 0, table = 0; // br e table
        // criamos um for para que ver o char qeuy esta no i (que vai até o final do
        // codigo fonte)
        // e confere se o char daquele espaço corresposde a algum dos int vistos e os
        // adiciona a sua respectiva variavel
        for (int i = 0; i < codfonte.length(); i++) {

            if (codfonte.charAt(i) == 'a') {
                a1++;
            }
            if (codfonte.charAt(i) == 'e') {
                e1++;
            }
            if (codfonte.charAt(i) == 'i') {
                i1++;
            }
            if (codfonte.charAt(i) == 'o') {
                o1++;
            }
            if (codfonte.charAt(i) == 'u') {
                u1++;
            }

            if (codfonte.charAt(i) == '\u00E1') {
                a2++;
            }
            if (codfonte.charAt(i) == '\u00E9') {
                e2++;
            }
            if (codfonte.charAt(i) == '\u00ED') {
                i2++;
            }
            if (codfonte.charAt(i) == '\u00F3') {
                o2++;
            }
            if (codfonte.charAt(i) == '\u00FA') {
                u2++;
            }

            if (codfonte.charAt(i) == '\u00E3') {
                a3++;
            }
            if (codfonte.charAt(i) == '\u00F5') {
                o3++;
            }

            if (codfonte.charAt(i) == '\u00E2') {
                a4++;
            }
            if (codfonte.charAt(i) == '\u00EA') {
                e4++;
            }
            if (codfonte.charAt(i) == '\u00EE') {
                i4++;
            }
            if (codfonte.charAt(i) == '\u00F4') {
                o4++;
            }
            if (codfonte.charAt(i) == '\u00FB') {
                u4++;
            }

            if (codfonte.charAt(i) == '\u00E0') {
                a5++;
            }
            if (codfonte.charAt(i) == '\u00E8') {
                e5++;
            }
            if (codfonte.charAt(i) == '\u00EC') {
                i5++;
            }
            if (codfonte.charAt(i) == '\u00F2') {
                o5++;
            }
            if (codfonte.charAt(i) == '\u00F9') {
                u5++;
            }
            // olha as consoantes
            if (codfonte.charAt(i) >= 'b' && codfonte.charAt(i) <= 'z') {
                if (codfonte.charAt(i) != 'e' && codfonte.charAt(i) != 'i' && codfonte.charAt(i) != 'o'
                        && codfonte.charAt(i) != 'u') {
                    consoante++;
                }
            }
            // olha os <br>
            if (codfonte.charAt(i) == '<' && codfonte.charAt(i + 1) == 'b' && codfonte.charAt(i + 2) == 'r'
                    && codfonte.charAt(i + 3) == '>') {
                br++;
                consoante -= 2;
            }
            // olha os <table>
            if (codfonte.charAt(i) == '<' && codfonte.charAt(i + 1) == 't' && codfonte.charAt(i + 2) == 'a'
                    && codfonte.charAt(i + 3) == 'b' && codfonte.charAt(i + 4) == 'l' && codfonte.charAt(i + 5) == 'e'
                    && codfonte.charAt(i + 6) == '>') {
                table++;
                consoante -= 3;
                a1--;
                e1--;
            }

        }
        // e aqui temos a resposta
        resposta = "a(" + a1 + ") e(" + e1 + ") i(" + i1 + ") o(" + o1 + ") u(" + u1 + ") á(" + a2 + ") é("
                + e2 + ") í(" + i2 + ") ó(" + o2 + ") ú(" + u2 + ") à(" + a5 + ") è(" + e5
                + ") ì(" + i5 + ") ò(" + o5 + ") ù(" + u5 + ") ã(" + a3 + ") õ(" + o3 + ") â("
                + a4 + ") ê(" + e4 + ") î(" + i4 + ") ô(" + o4 + ") û("
                + u4 + ") consoante(" + consoante + ") <br>(" + br + ") <table>(" + table + ") ";

        return resposta; // restornamos a resposta pois temso que retornar uma string

    }

    public static void main(String[] args) {
        String endereco = "", html = ""; // criamos as string sde endereço e do html
        while (true) {
            endereco = MyIO.readLine(); // lemos o endereço
            if (endereco.charAt(0) == 'F' && endereco.charAt(1) == 'I' && endereco.charAt(2) == 'M') {
                System.exit(0); // se a string for FIM terminamos o código
            } else { // senão repetimos o código novamente
                html = MyIO.readLine(); // lendo a string do html
                MyIO.println(confereLet(getHtml(html)) + endereco); // printando a resposta o confereLet
            }
        }
    }
}
