package com.kwad.sdk.core.local;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.au;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static LocalWriteResult a(Context context, String str, byte[] bArr, String str2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b(context, str, bArr, str2);
        }
        return a(context, bArr, str2 + "." + MimeTypeMap.getSingleton().getExtensionFromMimeType(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.content.ContentResolver] */
    private static LocalWriteResult b(Context context, String str, byte[] bArr, String str2) {
        OutputStream outputStream;
        LocalWriteResult localWriteResult = LocalWriteResult.FAIL;
        ?? r12 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentValues contentValues = new ContentValues();
        ?? contentResolver = context.getContentResolver();
        contentValues.put("_display_name", str2);
        contentValues.put("mime_type", str);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        contentValues.put("is_pending", (Integer) 1);
        Uri insert = contentResolver.insert(r12, contentValues);
        if (insert == null) {
            return localWriteResult;
        }
        Closeable closeable = null;
        try {
            try {
                outputStream = contentResolver.openOutputStream(insert);
            } catch (Exception e6) {
                e = e6;
                outputStream = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                throw th;
            }
            try {
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                r12 = outputStream;
            } catch (Exception e7) {
                e = e7;
                c.printStackTraceOnly(e);
                r12 = outputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r12);
                contentValues.clear();
                contentValues.put("is_pending", (Integer) 0);
                contentResolver.update(insert, contentValues, null, null);
                return LocalWriteResult.SUCCESS;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r12);
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(insert, contentValues, null, null);
            return LocalWriteResult.SUCCESS;
        } catch (Throwable th2) {
            th = th2;
            closeable = r12;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    private static LocalWriteResult a(Context context, byte[] bArr, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e6;
        if (au.at(context, g.f36050j) == 0) {
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), (String) str));
                } catch (Exception e7) {
                    fileOutputStream = null;
                    e6 = e7;
                } catch (Throwable th2) {
                    str = 0;
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                    throw th;
                }
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    LocalWriteResult localWriteResult = LocalWriteResult.SUCCESS;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    return localWriteResult;
                } catch (Exception e8) {
                    e6 = e8;
                    LocalWriteResult localWriteResult2 = LocalWriteResult.FAIL;
                    c.printStackTraceOnly(e6);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    return localWriteResult2;
                }
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                throw th;
            }
        }
        return LocalWriteResult.PERMISSION_DENIED;
    }
}
