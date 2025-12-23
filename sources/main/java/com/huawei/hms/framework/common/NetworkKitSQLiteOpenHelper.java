package com.huawei.hms.framework.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class NetworkKitSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;

    /* renamed from: a, reason: collision with root package name */
    private static final String f33323a = "PLSQLiteOpenHelper";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33324b = "networkkit_dynamic.db";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33325c = "networkkit.db";

    /* renamed from: d, reason: collision with root package name */
    private static final String f33326d = "-journal";

    /* renamed from: e, reason: collision with root package name */
    private static String f33327e = "networkkit.db";

    /* renamed from: f, reason: collision with root package name */
    private static volatile NetworkKitSQLiteOpenHelper f33328f;

    private NetworkKitSQLiteOpenHelper(Context context, String str, int i6) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i6);
    }

    public boolean tabbleIsExistInDB(String str, String str2) {
        SQLiteDatabase networkKitReadableDatabase;
        if (str2 != null && (networkKitReadableDatabase = getNetworkKitReadableDatabase()) != null) {
            try {
                networkKitReadableDatabase = SQLiteDatabase.openDatabase(networkKitReadableDatabase.getPath().replace(f33327e, str), null, 0);
                networkKitReadableDatabase.rawQuery("select count(1) from " + str2, null);
                IoUtils.closeSecure(networkKitReadableDatabase);
                return true;
            } catch (Throwable unused) {
                IoUtils.closeSecure(networkKitReadableDatabase);
            }
        }
        return false;
    }

    public static NetworkKitSQLiteOpenHelper getInstance() {
        if (f33328f == null) {
            synchronized (NetworkKitSQLiteOpenHelper.class) {
                try {
                    if (f33328f == null) {
                        f33328f = new NetworkKitSQLiteOpenHelper(Build.VERSION.SDK_INT < 24 ? ContextHolder.getAppContext() : ContextHolder.getAppContext().createDeviceProtectedStorageContext(), f33327e, 1);
                    }
                } finally {
                }
            }
        }
        return f33328f;
    }

    public boolean deleteDbFileByPath(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        Logger.i(f33323a, "db is not exists");
        return false;
    }

    public boolean deleteUnusedDbFile() {
        String str = f33327e;
        String str2 = f33324b;
        if (str.equals(f33324b)) {
            str2 = f33325c;
        }
        return deleteDbFileByPath(getNetworkKitReadableDatabase().getPath().replace(f33327e, str2));
    }

    public String getDbName() {
        return f33327e;
    }

    public String getDbNameSuffix() {
        return f33326d;
    }

    public SQLiteDatabase getNetworkKitReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = getReadableDatabase();
        } catch (Throwable th) {
            Logger.e(f33323a, "getReadableDatabase db error:" + th.getMessage());
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            Logger.e(f33323a, "getReadableDatabase db is null");
        }
        return sQLiteDatabase;
    }

    public SQLiteDatabase getNetworkKitWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = getWritableDatabase();
        } catch (Throwable th) {
            Logger.e(f33323a, "getWritableDatabase db error:" + th.getMessage());
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            Logger.e(f33323a, "getWritableDatabase db is null");
        }
        return sQLiteDatabase;
    }

    public SQLiteDatabase getNetworkkitUnusedDbDB() {
        String str = f33327e;
        String str2 = f33324b;
        if (str.equals(f33324b)) {
            str2 = f33325c;
        }
        return getDbByName(str2);
    }

    static {
        if (ContextHolder.getKitContext() != null) {
            f33327e = f33324b;
        }
    }

    public boolean deleteDbFile() {
        return deleteDbFileByPath(getNetworkKitReadableDatabase().getPath());
    }

    public SQLiteDatabase getDbByName(String str) {
        SQLiteDatabase networkKitReadableDatabase = getNetworkKitReadableDatabase();
        if (networkKitReadableDatabase != null) {
            String replace = networkKitReadableDatabase.getPath().replace(f33327e, str);
            if (new File(replace).exists()) {
                return SQLiteDatabase.openDatabase(replace, null, 0);
            }
            Logger.i(f33323a, "old db is not exists");
        }
        return networkKitReadableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
    }
}
