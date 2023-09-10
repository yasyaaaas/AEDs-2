import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PagHTML2 {

    public static void main(String args[]) {
        String endereco, html;
        while (true) {
            endereco = MyIO.readLine();
            if (endereco.equals("FIM")) {
                break;
            }
            html = MyIO.readLine();

            try {
                URL url = new URL(html);
                InputStream is = url.openStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String line;
                StringBuilder content = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    content.append(line);
                }

                br.close();
                is.close();
                int isA = verA(url);
                int isE = verE(url);
                int isI = verI(url);
                int isO = verO(url);
                int isU = verU(url);
                int isConso = verConso(url);
                int isBr = verBr(url);
                int isTab = verTab(url);
                // int isNome = verNome(url, endereco);
                int isA1 = verA1(url);
                int isE1 = verE1(url);
                int isI1 = verI1(url);
                int isO1 = verO1(url);
                int isU1 = verU1(url);
                int isA2 = verA2(url);
                int isE2 = verE2(url);
                int isI2 = verI2(url);
                int isO2 = verO2(url);
                int isU2 = verU2(url);
                int isA3 = verA3(url);
                int isE3 = verE3(url);
                int isI3 = verI3(url);
                int isO3 = verO3(url);
                int isU3 = verU3(url);
                int isA4 = verA4(url);
                int isO4 = verO4(url);
                if (isTab != 0) {
                    isConso -= 3;
                    isA -= 1;
                    isE -= 1;
                }
                MyIO.println("a(" + isA + ") e(" + isE + ") i(" + isI + ") o(" + isO + ") u(" + isU + ") á(" + isA1
                        + ") é("
                        + isE1 + ") í(" + isI1 + ") ó(" + isO1 + ") ú(" + isU1 + ") à(" + isA2 + ") è(" + isE2 + ") ì("
                        + isI2 + ") ò(" + isO2 + ") ù(" + isU2 + ") ã(" + isA4 + ") õ(" + isO4 + ") â(" + isA3 + ") ê("
                        + isE3 + ") î(" + isI3 + ") ô(" + isO3 + ") û(" + isU3 + ") consoante(" + isConso + ") <br>("
                        + isBr
                        + ") <table>(" + isTab + ") " + endereco);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int verA(URL url) {
        String auau = "a";
        int cont = 0;

        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (auau.contains(String.valueOf(htmlContent.charAt(i)))) {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cont;
    }

    private static int verE(URL url) {
        String auau = "e";
        int cont = 0;

        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (auau.contains(String.valueOf(htmlContent.charAt(i)))) {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verI(URL url) {
        String auau = "i";
        int cont = 0;

        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (auau.contains(String.valueOf(htmlContent.charAt(i)))) {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verO(URL url) {
        String auau = "o";
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (auau.contains(String.valueOf(htmlContent.charAt(i)))) {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verU(URL url) {
        String auau = "u";
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (auau.contains(String.valueOf(htmlContent.charAt(i)))) {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verConso(URL url) {
        String auau = "bcdfghjklmnpqrstvwxyz";
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();

            for (int i = 0; i < htmlContent.length(); i++) {
                if (auau.contains(String.valueOf(htmlContent.charAt(i)))) {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verBr(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            Pattern pattern = Pattern.compile("<br>", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(htmlContent);

            while (matcher.find()) {
                cont++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verTab(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            Pattern pattern = Pattern.compile("<table>", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(htmlContent);

            while (matcher.find()) {
                cont++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verA1(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00E1') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verE1(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00E9') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verI1(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00ED') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verO1(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00F3') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verU1(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00FA') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verA2(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00E0') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verE2(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00E8') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verI2(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00EC') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verO2(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00F2') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verU2(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00F9') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verA3(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00E2') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verE3(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00EA') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verI3(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00EE') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verO3(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00F4') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verU3(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00FB') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verA4(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00E3') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    private static int verO4(URL url) {
        int cont = 0;
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();
            is.close();

            String htmlContent = content.toString();
            for (int i = 0; i < htmlContent.length(); i++) {
                if (htmlContent.charAt(i) == '\u00F5') {
                    cont++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }
}
