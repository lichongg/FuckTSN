package com.bytedance.pangle;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextThemeWrapper;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends ContextThemeWrapper {
    private File mCacheDir;
    private File mCodeCacheDir;
    private File mDataDir;
    private File mExternalCacheDir;
    private File mFilesDir;
    private File mNoBackupFilesDir;
    private File mObbDir;
    private final Object mSync;

    public ae() {
        this.mSync = new Object();
    }

    protected String getPluginPkg() {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i6, SQLiteDatabase.CursorFactory cursorFactory) {
        return (i6 != 0 || getPluginDirName() == null) ? super.openOrCreateDatabase(str, i6, cursorFactory) : super.openOrCreateDatabase(makeSubName(str), i6, cursorFactory);
    }

    private static File makeFilename(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private String makeSubName(String str) {
        return getPluginDirName() + "_" + str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i6) {
        return (i6 != 0 || getPluginDirName() == null) ? super.getDir(str, i6) : ensurePrivateDirExists(new File(super.getDir(str, i6), getPluginDirName()));
    }

    protected String getPluginDirName() {
        return "pangle_" + getPluginPkg();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i6) {
        return (i6 != 0 || getPluginDirName() == null) ? super.getSharedPreferences(str, i6) : super.getSharedPreferences(makeSubName(str), i6);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i6) throws FileNotFoundException {
        return (i6 != 0 || getPluginDirName() == null) ? super.openFileOutput(str, i6) : new FileOutputStream(makeFilename(getFilesDir(), str), false);
    }

    public ae(Context context, int i6) {
        super(context, i6);
        this.mSync = new Object();
    }

    private static File ensurePrivateDirExists(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (getPluginDirName() == null) {
            return super.databaseList();
        }
        String[] databaseList = super.databaseList();
        int length = databaseList.length;
        boolean[] zArr = new boolean[length];
        int i6 = 0;
        for (int i7 = 0; i7 < databaseList.length; i7++) {
            if (databaseList[i7].startsWith(getPluginDirName())) {
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
        if (getPluginDirName() == null) {
            return super.deleteDatabase(str);
        }
        return super.deleteDatabase(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return makeFilename(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        if (getPluginDirName() == null) {
            return super.deleteSharedPreferences(str);
        }
        return super.deleteSharedPreferences(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getCacheDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mCacheDir == null) {
                    this.mCacheDir = new File(super.getCacheDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mCacheDir);
            } catch (Throwable th) {
                throw th;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mCodeCacheDir == null) {
                    this.mCodeCacheDir = new File(super.getCodeCacheDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mCodeCacheDir);
            } catch (Throwable th) {
                throw th;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getDataDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mDataDir == null) {
                    this.mDataDir = new File(getHostDataDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mDataDir);
            } catch (Throwable th) {
                throw th;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if (getPluginDirName() == null) {
            return super.getDatabasePath(str);
        }
        return super.getDatabasePath(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mExternalCacheDir == null) {
                    this.mExternalCacheDir = new File(super.getExternalCacheDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mExternalCacheDir);
            } catch (Throwable th) {
                throw th;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (getPluginDirName() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i6 = 0; i6 < externalCacheDirs.length; i6++) {
            fileArr[i6] = ensurePrivateDirExists(new File(externalCacheDirs[i6], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        if (getPluginDirName() == null) {
            return super.getExternalFilesDir(str);
        }
        return ensurePrivateDirExists(new File(super.getExternalFilesDir(str), getPluginDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (getPluginDirName() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i6 = 0; i6 < externalFilesDirs.length; i6++) {
            fileArr[i6] = ensurePrivateDirExists(new File(externalFilesDirs[i6], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (getPluginDirName() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i6 = 0; i6 < externalMediaDirs.length; i6++) {
            fileArr[i6] = ensurePrivateDirExists(new File(externalMediaDirs[i6], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getFilesDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mFilesDir == null) {
                    this.mFilesDir = new File(super.getFilesDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mFilesDir);
            } catch (Throwable th) {
                throw th;
            }
        }
        return ensurePrivateDirExists;
    }

    public File getHostDataDir() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mNoBackupFilesDir == null) {
                    this.mNoBackupFilesDir = new File(super.getNoBackupFilesDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mNoBackupFilesDir);
            } catch (Throwable th) {
                throw th;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getObbDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mObbDir == null) {
                    this.mObbDir = new File(super.getObbDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mObbDir);
            } catch (Throwable th) {
                throw th;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (getPluginDirName() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i6 = 0; i6 < obbDirs.length; i6++) {
            fileArr[i6] = ensurePrivateDirExists(new File(obbDirs[i6], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (getPluginDirName() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        if (getPluginDirName() == null) {
            return super.openFileInput(str);
        }
        return new FileInputStream(makeFilename(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i6, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i6 == 0 && getPluginDirName() != null) {
            return super.openOrCreateDatabase(makeSubName(str), i6, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(str, i6, cursorFactory, databaseErrorHandler);
    }

    @RequiresApi(api = 23)
    public ae(Context context, Resources.Theme theme) {
        super(context, theme);
        this.mSync = new Object();
    }
}
