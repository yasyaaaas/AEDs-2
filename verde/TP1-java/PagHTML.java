import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class PagHTML {
    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

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

    public static void main(String args[]) {
        String endereco, html;
        while (true) {
            endereco = MyIO.readLine();
            html = getHtml(endereco);
            if (endereco.equals("FIM")) {
                break;
            }
            int isA = verA(html);
            int isE = verE(html);
            int isI = verI(html);
            int isO = verO(html);
            int isU = verU(html);
            int isConso = verConso(html);
            int isBr = verBr(html);
            int isTab = verTab(html);
            int isNome = verNome(html, endereco);
            int isA1 = verA1(html);
            int isE1 = verE1(html);
            int isI1 = verI1(html);
            int isO1 = verO1(html);
            int isU1 = verU1(html);
            int isA2 = verA2(html);
            int isE2 = verE2(html);
            int isI2 = verI2(html);
            int isO2 = verO2(html);
            int isU2 = verU2(html);
            int isA3 = verA3(html);
            int isE3 = verE3(html);
            int isI3 = verI3(html);
            int isO3 = verO3(html);
            int isU3 = verU3(html);
            int isA4 = verA4(html);
            int isO4 = verO4(html);
            MyIO.print("a(" + isA + ") e(" + isE + ") i(" + isI + ") o(" + isO + ") u(" + isU + ") á(" + isA1 + ") é("
                    + isE1 + ") í(" + isI1 + ") ó(" + isO1 + ") ú(" + isU1 + ") à(" + isA2 + ") è(" + isE2 + ") ì("
                    + isI2 + ") ò(" + isO2 + ") ù(" + isU2 + ") ã(" + isA4 + ") õ(" + isO4 + ") â(" + isA3 + ") ê("
                    + isE3 + ") î(" + isI3 + ") ô(" + isO3 + ") û(" + isU3 + ") consoante(" + isConso + ") <br>(" + isBr
                    + ") <table>(" + isTab + ") " + endereco + "(" + isNome + ")");
        }
    }

    private static int verA(String html) {
        String auau = "aA";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verE(String html) {
        String auau = "eE";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verI(String html) {
        String auau = "iI";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verO(String html) {
        String auau = "oO";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verU(String html) {
        String auau = "uU";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verConso(String html) {
        String auau = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTWXY";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verBr(String html) {
        String auau = "<br>";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verTab(String html) {
        String auau = "<table>";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verNome(String html, String endereco) {
        int cont = 0;
        String[] palavras = html.split(" ");
        for (String p : palavras) {
            if (p.equalsIgnoreCase(endereco)) { // Verifica se a palavra é igual (ignorando maiúsculas/minúsculas)
                cont++;
            }
        }
        return cont;
    }

    private static int verA1(String html) {
        String auau = "áÁ";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verE1(String html) {
        String auau = "éÉ";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verI1(String html) {
        String auau = "íÍ";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verO1(String html) {
        String auau = "óÓ";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verU1(String html) {
        String auau = "úÚ";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verA2(String html) {
        String auau = "à";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verE2(String html) {
        String auau = "è";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verI2(String html) {
        String auau = "í";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verO2(String html) {
        String auau = "ò";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verU2(String html) {
        String auau = "ù";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verA3(String html) {
        String auau = "â";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verE3(String html) {
        String auau = "ê";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verI3(String html) {
        String auau = "î";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verO3(String html) {
        String auau = "ô";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verU3(String html) {
        String auau = "û";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verA4(String html) {
        String auau = "ã";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }

    private static int verO4(String html) {
        String auau = "õ";
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (auau.contains(String.valueOf(html.charAt(i)))) {
                cont++;
            }
        }
        return cont;
    }
}
