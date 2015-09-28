package com.synchronoss.storage;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StorageImplementation implements StorageAPI
{
    private Map<String, byte[]> storageMap = new HashMap<String, byte[]>();

    @Override
    public void put(String key, byte[] fileObject) throws Exception {
        if (!key.matches("[a-z]*")) {
            throw new Exception("Invalid key");
        }
        if (fileObject == null)
            throw new IllegalArgumentException();
        storageMap.put(key, Arrays.copyOf(fileObject, fileObject.length));
    }

    @Override
    public byte[] get(String key) {
        if (key == null)
            throw new IllegalArgumentException();
        return storageMap.get(key);
    }

    @Override
    public boolean delete(String key) {
        return storageMap.remove(key) != null;
    }

    @Override
    public int count() {
        return storageMap.size();
    }
}
