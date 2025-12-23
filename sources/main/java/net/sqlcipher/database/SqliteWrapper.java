package net.sqlcipher.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import net.sqlcipher.Cursor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SqliteWrapper {
    private static final String SQLITE_EXCEPTION_DETAIL_MESSAGE = "unable to open database file";
    private static final String TAG = "SqliteWrapper";

    private SqliteWrapper() {
    }

    public static void checkSQLiteException(Context context, SQLiteException sQLiteException) {
        if (isLowMemory(sQLiteException)) {
            Toast.makeText(context, sQLiteException.getMessage(), 0).show();
            return;
        }
        throw sQLiteException;
    }

    public static int delete(Context context, ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        try {
            return contentResolver.delete(uri, str, strArr);
        } catch (SQLiteException e6) {
            checkSQLiteException(context, e6);
            return -1;
        }
    }

    public static Uri insert(Context context, ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        try {
            return contentResolver.insert(uri, contentValues);
        } catch (SQLiteException e6) {
            checkSQLiteException(context, e6);
            return null;
        }
    }

    private static boolean isLowMemory(SQLiteException sQLiteException) {
        return sQLiteException.getMessage().equals(SQLITE_EXCEPTION_DETAIL_MESSAGE);
    }

    public static Cursor query(Context context, ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return (Cursor) contentResolver.query(uri, strArr, str, strArr2, str2);
        } catch (SQLiteException e6) {
            checkSQLiteException(context, e6);
            return null;
        }
    }

    public static boolean requery(Context context, android.database.Cursor cursor) {
        try {
            return cursor.requery();
        } catch (SQLiteException e6) {
            checkSQLiteException(context, e6);
            return false;
        }
    }

    public static int update(Context context, ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return contentResolver.update(uri, contentValues, str, strArr);
        } catch (SQLiteException e6) {
            checkSQLiteException(context, e6);
            return -1;
        }
    }
}
