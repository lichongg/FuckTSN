package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends ContextWrapper {
    private File ae;
    private File cw;

    /* renamed from: j, reason: collision with root package name */
    private final Object f27576j;

    /* renamed from: m, reason: collision with root package name */
    private File f27577m;

    /* renamed from: r, reason: collision with root package name */
    private File f27578r;
    private File tl;
    private File up;
    private File xt;

    protected String j() {
        return "pangle_com.byted.pangle";
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i6, SQLiteDatabase.CursorFactory cursorFactory) {
        return (i6 != 0 || j() == null) ? super.openOrCreateDatabase(str, i6, cursorFactory) : super.openOrCreateDatabase(j(str), i6, cursorFactory);
    }

    private String j(String str) {
        return j() + "_" + str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i6) {
        return (i6 != 0 || j() == null) ? super.getDir(str, i6) : j(new File(super.getDir(str, i6), j()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i6) {
        return (i6 != 0 || j() == null) ? super.getSharedPreferences(str, i6) : super.getSharedPreferences(j(str), i6);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i6) throws FileNotFoundException {
        return (i6 != 0 || j() == null) ? super.openFileOutput(str, i6) : new FileOutputStream(j(getFilesDir(), str), false);
    }

    public j(Context context) {
        super(context);
        this.f27576j = new Object();
    }

    private static File j(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (j() == null) {
            return super.databaseList();
        }
        String[] databaseList = super.databaseList();
        int length = databaseList.length;
        boolean[] zArr = new boolean[length];
        int i6 = 0;
        for (int i7 = 0; i7 < databaseList.length; i7++) {
            if (databaseList[i7].startsWith(j())) {
                zArr[i7] = true;
                i6++;
            } else {
                zArr[i7] = false;
            }
        }
        String[] strArr = new String[i6];
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            if (zArr[i9]) {
                strArr[i8] = databaseList[i9];
                i8++;
            }
        }
        return strArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        if (j() == null) {
            return super.deleteDatabase(str);
        }
        return super.deleteDatabase(j(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return j(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        if (j() == null) {
            return super.deleteSharedPreferences(str);
        }
        return super.deleteSharedPreferences(j(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File j6;
        if (j() == null) {
            return super.getCacheDir();
        }
        synchronized (this.f27576j) {
            try {
                if (this.f27577m == null) {
                    this.f27577m = new File(super.getCacheDir(), j());
                }
                j6 = j(this.f27577m);
            } catch (Throwable th) {
                throw th;
            }
        }
        return j6;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File j6;
        if (j() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.f27576j) {
            try {
                if (this.ae == null) {
                    this.ae = new File(super.getCodeCacheDir(), j());
                }
                j6 = j(this.ae);
            } catch (Throwable th) {
                throw th;
            }
        }
        return j6;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File j6;
        if (j() == null) {
            return super.getDataDir();
        }
        synchronized (this.f27576j) {
            try {
                if (this.xt == null) {
                    this.xt = new File(xt(), j());
                }
                j6 = j(this.xt);
            } catch (Throwable th) {
                throw th;
            }
        }
        return j6;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if (j() == null) {
            return super.getDatabasePath(str);
        }
        return super.getDatabasePath(j(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File j6;
        if (j() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.f27576j) {
            try {
                if (this.tl == null) {
                    this.tl = new File(super.getExternalCacheDir(), j());
                }
                j6 = j(this.tl);
            } catch (Throwable th) {
                throw th;
            }
        }
        return j6;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (j() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i6 = 0; i6 < externalCacheDirs.length; i6++) {
            fileArr[i6] = j(new File(externalCacheDirs[i6], j()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        if (j() == null) {
            return super.getExternalFilesDir(str);
        }
        return j(new File(super.getExternalFilesDir(str), j()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (j() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i6 = 0; i6 < externalFilesDirs.length; i6++) {
            fileArr[i6] = j(new File(externalFilesDirs[i6], j()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (j() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i6 = 0; i6 < externalMediaDirs.length; i6++) {
            fileArr[i6] = j(new File(externalMediaDirs[i6], j()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File j6;
        if (j() == null) {
            return super.getFilesDir();
        }
        synchronized (this.f27576j) {
            try {
                if (this.cw == null) {
                    this.cw = new File(super.getFilesDir(), j());
                }
                j6 = j(this.cw);
            } catch (Throwable th) {
                throw th;
            }
        }
        return j6;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File j6;
        if (j() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.f27576j) {
            try {
                if (this.f27578r == null) {
                    this.f27578r = new File(super.getNoBackupFilesDir(), j());
                }
                j6 = j(this.f27578r);
            } catch (Throwable th) {
                throw th;
            }
        }
        return j6;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File j6;
        if (j() == null) {
            return super.getObbDir();
        }
        synchronized (this.f27576j) {
            try {
                if (this.up == null) {
                    this.up = new File(super.getObbDir(), j());
                }
                j6 = j(this.up);
            } catch (Throwable th) {
                throw th;
            }
        }
        return j6;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (j() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i6 = 0; i6 < obbDirs.length; i6++) {
            fileArr[i6] = j(new File(obbDirs[i6], j()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (j() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        if (j() == null) {
            return super.openFileInput(str);
        }
        return new FileInputStream(j(getFilesDir(), str));
    }

    public File xt() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i6, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i6 == 0 && j() != null) {
            return super.openOrCreateDatabase(j(str), i6, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(str, i6, cursorFactory, databaseErrorHandler);
    }

    private static File j(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }
}
