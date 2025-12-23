package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e implements com.bumptech.glide.load.h<Bitmap> {

    /* renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Integer> f15596b = com.bumptech.glide.load.e.g("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Bitmap.CompressFormat> f15597c = com.bumptech.glide.load.e.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: d, reason: collision with root package name */
    private static final String f15598d = "BitmapEncoder";

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f15599a;

    public e(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f15599a = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, com.bumptech.glide.load.f fVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) fVar.c(f15597c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.h
    @NonNull
    public EncodeStrategy b(@NonNull com.bumptech.glide.load.f fVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #4 {all -> 0x0054, blocks: (B:3:0x0021, B:15:0x0050, B:18:0x0065, B:20:0x006b, B:43:0x0086, B:41:0x0089, B:34:0x0060), top: B:2:0x0021 }] */
    @Override // com.bumptech.glide.load.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(@androidx.annotation.NonNull com.bumptech.glide.load.engine.u<android.graphics.Bitmap> r8, @androidx.annotation.NonNull java.io.File r9, @androidx.annotation.NonNull com.bumptech.glide.load.f r10) {
        /*
            r7 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r1 = r7.d(r8, r10)
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.pool.b.d(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.util.g.b()     // Catch: java.lang.Throwable -> L54
            com.bumptech.glide.load.e<java.lang.Integer> r4 = com.bumptech.glide.load.resource.bitmap.e.f15596b     // Catch: java.lang.Throwable -> L54
            java.lang.Object r4 = r10.c(r4)     // Catch: java.lang.Throwable -> L54
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L54
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L54
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            com.bumptech.glide.load.engine.bitmap_recycle.b r9 = r7.f15599a     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L47
            if (r9 == 0) goto L49
            com.bumptech.glide.load.data.c r9 = new com.bumptech.glide.load.data.c     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L47
            com.bumptech.glide.load.engine.bitmap_recycle.b r5 = r7.f15599a     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L47
            r9.<init>(r6, r5)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L47
            r5 = r9
            goto L4a
        L44:
            r8 = move-exception
            r5 = r6
            goto L84
        L47:
            r5 = r6
            goto L5a
        L49:
            r5 = r6
        L4a:
            r8.compress(r1, r4, r5)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            r5.close()     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            r5.close()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            goto L56
        L54:
            r8 = move-exception
            goto L8a
        L56:
            r9 = 1
            goto L64
        L58:
            r8 = move-exception
            goto L84
        L5a:
            r9 = 3
            android.util.Log.isLoggable(r0, r9)     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L63
            r5.close()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L63
        L63:
            r9 = 0
        L64:
            r4 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L54
            if (r0 == 0) goto L80
            java.util.Objects.toString(r1)     // Catch: java.lang.Throwable -> L54
            com.bumptech.glide.util.l.h(r8)     // Catch: java.lang.Throwable -> L54
            com.bumptech.glide.util.g.a(r2)     // Catch: java.lang.Throwable -> L54
            com.bumptech.glide.load.e<android.graphics.Bitmap$CompressFormat> r0 = com.bumptech.glide.load.resource.bitmap.e.f15597c     // Catch: java.lang.Throwable -> L54
            java.lang.Object r10 = r10.c(r0)     // Catch: java.lang.Throwable -> L54
            java.util.Objects.toString(r10)     // Catch: java.lang.Throwable -> L54
            r8.hasAlpha()     // Catch: java.lang.Throwable -> L54
        L80:
            com.bumptech.glide.util.pool.b.e()
            return r9
        L84:
            if (r5 == 0) goto L89
            r5.close()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L89
        L89:
            throw r8     // Catch: java.lang.Throwable -> L54
        L8a:
            com.bumptech.glide.util.pool.b.e()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.e.a(com.bumptech.glide.load.engine.u, java.io.File, com.bumptech.glide.load.f):boolean");
    }

    @Deprecated
    public e() {
        this.f15599a = null;
    }
}
