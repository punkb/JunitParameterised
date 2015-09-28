package com.synchronoss.storage;

/**
 * com.newbay.storage.StorageAPI is the interface to a storage implementation.
 *
 * The key is a non-empty String of characters, which must be in the range a..z.
 */
public interface StorageAPI {

    /**
     * Put a file into storage, throwing an exception if the key is invalid.
     * Replaces the existing value of the object if previously stored.
     * It is permitted to store an empty array.
     *
     * @param key
     * @param fileObject
     * @throws Exception
     */
    void put(String key, byte[] fileObject) throws Exception;

    /**
     * Returns the byte array for the object, or null if not found.
     *
     * @param key
     * @return
     */
    byte[] get(String key);

    /**
     * Delete the file object, returning true if found.
     * @param key
     */
    boolean delete(String key);

    /**
     * Returns the number of items in the store.
     *
     * @return
     */
    int count();

}
