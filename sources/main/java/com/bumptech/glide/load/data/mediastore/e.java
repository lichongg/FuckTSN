package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class e {

    /* renamed from: f, reason: collision with root package name */
    private static final String f14970f = "ThumbStreamOpener";

    /* renamed from: g, reason: collision with root package name */
    private static final a f14971g = new a();

    /* renamed from: a, reason: collision with root package name */
    private final a f14972a;

    /* renamed from: b, reason: collision with root package name */
    private final d f14973b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f14974c;

    /* renamed from: d, reason: collision with root package name */
    private final ContentResolver f14975d;

    /* renamed from: e, reason: collision with root package name */
    private final List<ImageHeaderParser> f14976e;

    e(List<ImageHeaderParser> list, d dVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this(list, f14971g, dVar, bVar, contentResolver);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0038  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(@androidx.annotation.NonNull android.net.Uri r5) {
        /*
            r4 = this;
            r0 = 0
            com.bumptech.glide.load.data.mediastore.d r1 = r4.f14973b     // Catch: java.lang.Throwable -> L21 java.lang.SecurityException -> L23
            android.database.Cursor r1 = r1.query(r5)     // Catch: java.lang.Throwable -> L21 java.lang.SecurityException -> L23
            if (r1 == 0) goto L1b
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L18 java.lang.SecurityException -> L24
            if (r2 == 0) goto L1b
            r2 = 0
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.Throwable -> L18 java.lang.SecurityException -> L24
            r1.close()
            return r5
        L18:
            r5 = move-exception
            r0 = r1
            goto L36
        L1b:
            if (r1 == 0) goto L20
            r1.close()
        L20:
            return r0
        L21:
            r5 = move-exception
            goto L36
        L23:
            r1 = r0
        L24:
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L30
            java.util.Objects.toString(r5)     // Catch: java.lang.Throwable -> L18
        L30:
            if (r1 == 0) goto L35
            r1.close()
        L35:
            return r0
        L36:
            if (r0 == 0) goto L3b
            r0.close()
        L3b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.e.b(android.net.Uri):java.lang.String");
    }

    int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f14975d.openInputStream(uri);
                int b6 = com.bumptech.glide.load.b.b(this.f14976e, inputStream, this.f14974c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return b6;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException unused3) {
            if (Log.isLoggable(f14970f, 3)) {
                Objects.toString(uri);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused4) {
                return -1;
            }
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this.f14972a = aVar;
        this.f14973b = dVar;
        this.f14974c = bVar;
        this.f14975d = contentResolver;
        this.f14976e = list;
    }

    private boolean c(File file) {
        return this.f14972a.a(file) && 0 < this.f14972a.c(file);
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b6 = b(uri);
        if (TextUtils.isEmpty(b6)) {
            return null;
        }
        File b7 = this.f14972a.b(b6);
        if (!c(b7)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b7);
        try {
            return this.f14975d.openInputStream(fromFile);
        } catch (NullPointerException e6) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e6));
        }
    }
}
