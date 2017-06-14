package com.codekul.externalstorage;

/**
 * Created by aniruddha on 14/6/17.
 */

public class FileItem {

    public int ic;
    public String nm;
    public String mdFd;
    public String sz;

    public FileItem(int ic, String nm, String mdFd, String sz) {
        this.ic = ic;
        this.nm = nm;
        this.mdFd = mdFd;
        this.sz = sz;
    }
}
