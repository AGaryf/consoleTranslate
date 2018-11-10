package com.greendislike;

import javax.net.ssl.HttpsURLConnection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Translator {

    private static final String TRANSALTE_ROOT = "https://translate.yandex.net/api/v1.5/tr.json/translate";

    private static final String DEFAULT_LANG = "en-ru";

    private static final String KEY = "trnsl.1.1.20181108T111527Z.fadba51af158760b.e81f68400682fd79ebdc50ed45724ff2593faa68";

    private static final String httpsUrl = TRANSALTE_ROOT + "?" + "lang=" + DEFAULT_LANG + "&" + "key=" + KEY;

    public static String translate(String line) {

        try {
            URL urlObj = new URL(httpsUrl);
            HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes("text=" + URLEncoder.encode(line, "UTF-8"));

            InputStream inputStream = connection.getInputStream();
            String json = new java.util.Scanner(inputStream).nextLine();
            int start = json.indexOf("[");
            int end = json.indexOf("]");
            String translated = json.substring(start + 2, end - 1);

            return translated;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
