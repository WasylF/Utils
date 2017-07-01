package com.github.wslf.utils.json;

import com.github.wslf.utils.web.WebReader;
import org.json.JSONObject;

/**
 *
 * @author Wsl_F
 */
public class JsonReader {

    public JSONObject read(String url) throws Exception {
        return new JSONObject(new WebReader().read(url));
    }
}
