package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.provider.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(19)
/* loaded from: D:\Downloads\app\classes.dex */
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    public static boolean canRead(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(getRawType(context, uri));
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String rawType = getRawType(context, uri);
        int queryForInt = queryForInt(context, uri, "flags", 0);
        if (TextUtils.isEmpty(rawType)) {
            return false;
        }
        if ((queryForInt & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(rawType) || (queryForInt & 8) == 0) {
            return (TextUtils.isEmpty(rawType) || (queryForInt & 2) == 0) ? false : true;
        }
        return true;
    }

    private static int queryForInt(Context context, Uri uri, String str, int i6) {
        return (int) queryForLong(context, uri, str, i6);
    }

    private static void closeQuietly(@Nullable AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                c.a(autoCloseable);
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    public static long getFlags(Context context, Uri uri) {
        return queryForLong(context, uri, "flags", 0L);
    }

    @Nullable
    public static String getName(Context context, Uri uri) {
        return queryForString(context, uri, "_display_name", null);
    }

    @Nullable
    private static String getRawType(Context context, Uri uri) {
        return queryForString(context, uri, "mime_type", null);
    }

    public static long lastModified(Context context, Uri uri) {
        return queryForLong(context, uri, "last_modified", 0L);
    }

    public static long length(Context context, Uri uri) {
        return queryForLong(context, uri, "_size", 0L);
    }

    private DocumentsContractApi19() {
    }

    public static boolean exists(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z5 = false;
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(uri, new String[]{"document_id"}, null, null, null);
                if (cursor.getCount() > 0) {
                    z5 = true;
                }
                return z5;
            } catch (Exception e6) {
                e6.toString();
                closeQuietly(cursor);
                return false;
            }
        } finally {
            closeQuietly(cursor);
        }
    }

    @Nullable
    public static String getType(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        if ("vnd.android.document/directory".equals(rawType)) {
            return null;
        }
        return rawType;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }

    public static boolean isFile(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        if (!"vnd.android.document/directory".equals(rawType) && !TextUtils.isEmpty(rawType)) {
            return true;
        }
        return false;
    }

    public static boolean isVirtual(Context context, Uri uri) {
        if (!DocumentsContract.isDocumentUri(context, uri) || (getFlags(context, uri) & 512) == 0) {
            return false;
        }
        return true;
    }

    private static long queryForLong(Context context, Uri uri, String str, long j6) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(uri, new String[]{str}, null, null, null);
                if (cursor.moveToFirst() && !cursor.isNull(0)) {
                    long j7 = cursor.getLong(0);
                    closeQuietly(cursor);
                    return j7;
                }
                closeQuietly(cursor);
                return j6;
            } catch (Exception e6) {
                e6.toString();
                closeQuietly(cursor);
                return j6;
            }
        } catch (Throwable th) {
            closeQuietly(cursor);
            throw th;
        }
    }

    @Nullable
    private static String queryForString(Context context, Uri uri, String str, @Nullable String str2) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(uri, new String[]{str}, null, null, null);
                if (cursor.moveToFirst() && !cursor.isNull(0)) {
                    String string = cursor.getString(0);
                    closeQuietly(cursor);
                    return string;
                }
                closeQuietly(cursor);
                return str2;
            } catch (Exception e6) {
                e6.toString();
                closeQuietly(cursor);
                return str2;
            }
        } catch (Throwable th) {
            closeQuietly(cursor);
            throw th;
        }
    }
}
