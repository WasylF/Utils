package com.github.wslf.utils.json;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class to extract data from JSON object. Each method return default value if
 * can't obtain data. Initially all default values is null. You could change
 * default value by using appropriate setter.
 *
 * @author Wsl_F
 */
public class JsonExtractor {

    private String defaultStringValue = null;
    private Integer defaultIntegerValue = null;
    private Long defaultLongValue = null;
    private Double defaultDoubleValue = null;
    private Boolean defaultBooleanValue = null;

    /**
     * Sets default value
     *
     * @param defaultStringValue new default value
     */
    public void setDefaultStringValue(String defaultStringValue) {
        this.defaultStringValue = defaultStringValue;
    }

    /**
     * Sets default value
     *
     * @param defaultIntegerValue new default value
     */
    public void setDefaultIntegerValue(Integer defaultIntegerValue) {
        this.defaultIntegerValue = defaultIntegerValue;
    }

    /**
     * Sets default value
     *
     * @param defaultLongValue new default value
     */
    public void setDefaultLongValue(Long defaultLongValue) {
        this.defaultLongValue = defaultLongValue;
    }

    /**
     * Sets default value
     *
     * @param defaultDoubleValue new default value
     */
    public void setDefaultDoubleValue(Double defaultDoubleValue) {
        this.defaultDoubleValue = defaultDoubleValue;
    }

    /**
     * Sets default value
     *
     * @param defaultBooleanValue new default value
     */
    public void setDefaultBooleanValue(Boolean defaultBooleanValue) {
        this.defaultBooleanValue = defaultBooleanValue;
    }

    /**
     * Extracting String value from JSON object if it exists, otherwise
     * returning {@code null}
     *
     * @param obj JSON object, could be NULL
     * @param name filed name
     * @return String value or empty string
     */
    public String getString(JSONObject obj, String name) {
        String value = defaultStringValue;
        if (obj != null && name != null && obj.has(name)) {
            try {
                value = obj.getString(name);
            } catch (JSONException ex) {
                System.err.println("Couldn't extract String parameter: "
                        + name + " from JSON: " + obj + "\n" + ex.getMessage());
                value = defaultStringValue;
            }
        }

        return value;
    }

    /**
     * Extracting int value from JSON object if it exists, otherwise returning
     * {@code null}
     *
     * @param obj JSON object, could be NULL
     * @param name filed name
     * @return Integer value
     */
    public Integer getInt(JSONObject obj, String name) {
        Integer value = defaultIntegerValue;
        if (obj != null && name != null && obj.has(name)) {
            try {
                value = obj.getInt(name);
            } catch (JSONException ex) {
                System.err.println("Couldn't extract int parameter: "
                        + name + " from JSON: " + obj + "\n" + ex.getMessage());
                value = defaultIntegerValue;
            }
        }

        return value;
    }

    /**
     * Extracting long value from JSON object if it exists, otherwise returning
     * {@code null}
     *
     * @param obj JSON object, could be NULL
     * @param name filed name
     * @return Long value
     */
    public Long getLong(JSONObject obj, String name) {
        Long value = defaultLongValue;
        if (obj != null && name != null && obj.has(name)) {
            try {
                value = obj.getLong(name);
            } catch (JSONException ex) {
                System.err.println("Couldn't extract long parameter: "
                        + name + " from JSON: " + obj + "\n" + ex.getMessage());
                value = defaultLongValue;
            }
        }

        return value;
    }

    /**
     * Extracting boolean value from JSON object if it exists, otherwise
     * returning {@code null}
     *
     * @param obj JSON object, could be NULL
     * @param name filed name
     * @return Boolean value
     */
    public Boolean getBoolean(JSONObject obj, String name) {
        Boolean value = defaultBooleanValue;
        if (obj != null && name != null && obj.has(name)) {
            try {
                value = obj.getBoolean(name);
            } catch (JSONException ex) {
                System.err.println("Couldn't extract long parameter: "
                        + name + " from JSON: " + obj + "\n" + ex.getMessage());
                value = defaultBooleanValue;
            }
        }

        return value;
    }

    /**
     * Extracting double value from JSON object if it exists, otherwise
     * returning {@code null}
     *
     * @param obj JSON object, could be NULL
     * @param name filed name
     * @return Double value
     */
    public Double getDouble(JSONObject obj, String name) {
        Double value = defaultDoubleValue;
        if (obj != null && name != null && obj.has(name)) {
            try {
                value = obj.getDouble(name);
            } catch (JSONException ex) {
                System.err.println("Couldn't extract double parameter: "
                        + name + " from JSON: " + obj + "\n" + ex.getMessage());
                value = defaultDoubleValue;
            }
        }

        return value;
    }

}
