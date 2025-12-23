package com.autonavi.base.ae.gmap.bean;

import androidx.work.PeriodicWorkRequest;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class InitStorageParam {
    private static final String DIR_NAME = "terrain_dem_files";
    private static final String INIT_STORAGE_DIR = "mapcache";

    @JBindingInclude
    private int maxFileCount;

    @JBindingInclude
    private long maxFileSize;

    @JBindingInclude
    private String path;

    @JBindingInclude
    private int version;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Holder {
        private static String sPath;

        public static void initPath(String str) {
            File file = new File(str);
            File file2 = new File(file, InitStorageParam.INIT_STORAGE_DIR);
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdir();
                }
                File file3 = new File(file2, InitStorageParam.DIR_NAME);
                if (!file3.exists()) {
                    file3.mkdir();
                }
                sPath = file3.getAbsolutePath();
            }
        }
    }

    private InitStorageParam(int i6, String str, int i7, long j6) {
        this.version = i6;
        this.path = str;
        this.maxFileCount = i7;
        this.maxFileSize = j6;
    }

    @JBindingInclude
    public static InitStorageParam obtain() {
        return new InitStorageParam();
    }

    @JBindingInclude
    public static InitStorageParam obtain(int i6, String str, int i7, long j6) {
        return new InitStorageParam(i6, str, i7, j6);
    }

    @JBindingInclude
    public int getMaxFileCount() {
        return this.maxFileCount;
    }

    @JBindingInclude
    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    @JBindingInclude
    public String getPath() {
        return this.path;
    }

    @JBindingInclude
    public int getVersion() {
        return this.version;
    }

    @JBindingInclude
    public void setMaxFileCount(int i6) {
        this.maxFileCount = i6;
    }

    @JBindingInclude
    public void setMaxFileSize(long j6) {
        this.maxFileSize = j6;
    }

    @JBindingInclude
    public void setPath(String str) {
        this.path = str;
    }

    @JBindingInclude
    public void setVersion(int i6) {
        this.version = i6;
    }

    public String toString() {
        return "InitStorageParam{version=" + this.version + ", maxFileCount=" + this.maxFileCount + ", maxFileSize=" + this.maxFileSize + ", path='" + this.path + "'}";
    }

    private InitStorageParam() {
        this(1, Holder.sPath, 1000, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
    }
}
