package com.yalantis.ucrop.util;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42790a = "FileUtils";

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        if (r8 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002e, code lost:
    
        if (r8 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0050, code lost:
    
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L34 java.lang.IllegalArgumentException -> L37
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L34 java.lang.IllegalArgumentException -> L37
            if (r8 == 0) goto L2e
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L27 java.lang.IllegalArgumentException -> L2b
            if (r9 == 0) goto L2e
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L27 java.lang.IllegalArgumentException -> L2b
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L27 java.lang.IllegalArgumentException -> L2b
            r8.close()
            return r9
        L27:
            r0 = move-exception
            r9 = r0
            r7 = r8
            goto L51
        L2b:
            r0 = move-exception
            r9 = r0
            goto L3a
        L2e:
            if (r8 == 0) goto L50
        L30:
            r8.close()
            goto L50
        L34:
            r0 = move-exception
            r9 = r0
            goto L51
        L37:
            r0 = move-exception
            r9 = r0
            r8 = r7
        L3a:
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L27
            java.lang.String r11 = "getDataColumn: _data - [%s]"
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L27
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L27
            r1 = 0
            r0[r1] = r9     // Catch: java.lang.Throwable -> L27
            java.lang.String.format(r10, r11, r0)     // Catch: java.lang.Throwable -> L27
            if (r8 == 0) goto L50
            goto L30
        L50:
            return r7
        L51:
            if (r7 == 0) goto L56
            r7.close()
        L56:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.e.b(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean d(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean e(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean f(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean g(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private e() {
    }

    public static void a(@NonNull String str, @NonNull String str2) throws IOException {
        Throwable th;
        FileChannel fileChannel;
        if (!str.equalsIgnoreCase(str2)) {
            FileChannel fileChannel2 = null;
            try {
                FileChannel channel = new FileInputStream(new File(str)).getChannel();
                try {
                    fileChannel = new FileOutputStream(new File(str2)).getChannel();
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
                try {
                    channel.transferTo(0L, channel.size(), fileChannel);
                    channel.close();
                    channel.close();
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel2 = channel;
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static String c(Context context, Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (e(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (d(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return b(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    } catch (NumberFormatException e6) {
                        e6.getMessage();
                        return null;
                    }
                }
            } else if (g(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if (SocializeProtocolConstants.IMAGE.equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return b(context, uri2, "_id=?", new String[]{split2[1]});
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (f(uri)) {
                    return uri.getLastPathSegment();
                }
                return b(context, uri, null, null);
            }
            if (master.flame.danmaku.danmaku.parser.b.f50156c.equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }
}
