package com.lolo.se.hi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class CachedDataImpl<VALUE> implements CachedData<VALUE> {
    private final String fileName = "src/com/lolo/se/hi/cache";
    private final File cacheFile = new File(fileName);
    Hashtable<Integer, VALUE> cache = new Hashtable<>();

    private boolean isFileExist() {
        return cacheFile.isFile();
    }

    private void createCacheFileIfNotExist(){
            try {
                cacheFile.createNewFile();
            }
            catch (IOException e) {
                System.out.println("Cache file read error");
                e.printStackTrace();
            }
        }

    private void loadCacheFromFile(){
        createCacheFileIfNotExist();
        Scanner input = null;
        try {
            input = new Scanner(cacheFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            assert input != null;
            if (!input.hasNextLine()) break;
            String contents = input.nextLine();
            String[] result = contents.split(",");
            try {
                int key = Integer.parseInt(result[0]);
                int val = Integer.parseInt(result[1]);
                cache.put(key, val);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }

        }
    }

    private void saveCacheToFile() {

    }

    @Override
    public void initCache() {
        loadCacheFromFile();
    }

    @Override
    public VALUE getCached(int number) {
        return cache.get(number);
    }

    @Override
    public void addToCache(int number, VALUE result) {
        cache.put(number, result);
    }

    @Override
    public boolean isCached(int number) {
        return cache.containsKey(number);
    }
}
