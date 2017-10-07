package com.github.wslf.utils.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Reader class is class for simplifying reading from the web.
 *
 * @author Wsl_F
 */
public class WebReader {

    private int bufferSize = 10_000;

    /**
     * Change size of buffer.
     *
     * @param bufferSize new buffer's size
     */
    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    /**
     * Reads web page as plain text.
     *
     * @param urlString URL
     * @return single string that contains whole plain text from the page
     * @throws IOException if couldn't read page
     */
    public String read(final String urlString) throws IOException {
        try {
            final URL url = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            InputStream stream;
            if (huc.getResponseCode() / 100 == 2) {
                stream = huc.getInputStream();
            } else {
                stream = huc.getErrorStream();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, Charset.forName("UTF-8")));
            StringBuilder text = new StringBuilder();
            char[] cbuf = new char[bufferSize];
            int readed = 0;
            while (readed != -1) {
                readed = reader.read(cbuf);
                if (readed > 0) {
                    text.append(Arrays.copyOfRange(cbuf, 0, readed));
                }
            }
            return text.toString();
        } catch (IOException ex) {
            System.err.println("Failed to read url: " + urlString
                    + "\n" + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Getting response code for URL.
     *
     * @param urlString URL
     * @return response code
     * @throws IOException if couldn't read page
     */
    public int getResponseCode(final String urlString) throws IOException {
        try {
            final URL url = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("HEAD");
            huc.getResponseMessage();
            return huc.getResponseCode();
        } catch (IOException ex) {
            System.err.println("Failed to get response code of url: " + urlString
                    + "\n" + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Check page existence
     *
     * @param urlString URL
     * @return existence of URL
     */
    public boolean isExists(final String urlString) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection con
                    = (HttpURLConnection) new URL(urlString).openConnection();
            con.setRequestMethod("HEAD");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception ex) {
            System.err.println("Failed to check existance of url: " + urlString
                    + "\n" + ex.getMessage());
        }
        return false;
    }
}
