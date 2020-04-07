package fr.redstom.betterpluginsapi.data;

import com.google.common.collect.Maps;

import java.util.Map;

public class StringData {

    public static Map<String, String> stringMap = Maps.newHashMap();

    /**
     * Add a value to the {@link StringData}
     *
     * @param key   Key to get the value
     * @param value Value got with the key
     */
    public static void addValue(String key, String value) {
        stringMap.put(key, value);
    }

    /**
     * Remove a value to the {@link StringData}
     *
     * @param key Key to remove the value
     */
    public static void removeValue(String key) {
        stringMap.remove(key);
    }

    /**
     * Get a value from the {@link StringData}
     *
     * @param key Key to get the value
     * @return The value got with the key
     */
    public static String getValue(String key) {
        return stringMap.get(key);
    }

    /**
     * Get a value from the {@link StringData} and if it's null, return the default
     *
     * @param key      Key to get the value
     * @param default_ Default in the case of the value is null
     * @return The value got with the key or the default value if it's null
     */
    public static String getOrDefault(String key, String default_) {
        return stringMap.getOrDefault(key, default_);
    }

}
