package com.app.instancedownload;

import android.net.Uri;

public class w_ModelClass {

    String path,filename;
    Uri uri;

    public w_ModelClass(String path, String filename, Uri uri) {
        this.path = path;
        this.filename = filename;
        this.uri = uri;
    }

    public w_ModelClass() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
