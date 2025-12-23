package cn.bluemobi.dylan.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private String f1298a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1299b;

    /* renamed from: c, reason: collision with root package name */
    private File f1300c;

    /* renamed from: d, reason: collision with root package name */
    private c f1301d;

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap = null;
        try {
            try {
                bitmap = a(com.bumptech.glide.b.D(this.f1299b).a(this.f1298a).i1(Integer.MIN_VALUE, Integer.MIN_VALUE).get());
                if (bitmap != null) {
                    b(this.f1299b, bitmap);
                }
                if (bitmap == null || !this.f1300c.exists()) {
                    c cVar = this.f1301d;
                    if (cVar != null) {
                        cVar.a();
                        return;
                    }
                    return;
                }
                c cVar2 = this.f1301d;
                if (cVar2 != null) {
                    cVar2.onSuccess();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                if (bitmap == null || !this.f1300c.exists()) {
                    c cVar3 = this.f1301d;
                    if (cVar3 != null) {
                        cVar3.a();
                        return;
                    }
                    return;
                }
                c cVar4 = this.f1301d;
                if (cVar4 != null) {
                    cVar4.onSuccess();
                }
            }
        } catch (Throwable th) {
            if (bitmap == null || !this.f1300c.exists()) {
                c cVar5 = this.f1301d;
                if (cVar5 != null) {
                    cVar5.a();
                }
            } else {
                c cVar6 = this.f1301d;
                if (cVar6 != null) {
                    cVar6.onSuccess();
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        if (r0 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
    
        if (r0 == null) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.graphics.Bitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r5, android.graphics.Bitmap r6) {
        /*
            r4 = this;
            java.lang.String r0 = android.os.Environment.DIRECTORY_PICTURES
            java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)
            java.io.File r0 = r0.getAbsoluteFile()
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "download"
            r1.<init>(r0, r2)
            boolean r0 = r1.exists()
            if (r0 != 0) goto L1a
            r1.mkdirs()
        L1a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            r0.append(r2)
            java.lang.String r2 = ".jpg"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1, r0)
            r4.f1300c = r2
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            java.io.File r2 = r4.f1300c     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54 java.io.FileNotFoundException -> L57
            r2 = 100
            r6.compress(r0, r2, r1)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54 java.io.FileNotFoundException -> L57
            r1.flush()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54 java.io.FileNotFoundException -> L57
            r1.close()     // Catch: java.io.IOException -> L4c
            goto L6f
        L4c:
            r6 = move-exception
            r6.printStackTrace()
            goto L6f
        L51:
            r5 = move-exception
            r0 = r1
            goto L89
        L54:
            r6 = move-exception
            r0 = r1
            goto L60
        L57:
            r6 = move-exception
            r0 = r1
            goto L69
        L5a:
            r5 = move-exception
            goto L89
        L5c:
            r6 = move-exception
            goto L60
        L5e:
            r6 = move-exception
            goto L69
        L60:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            if (r0 == 0) goto L6f
        L65:
            r0.close()     // Catch: java.io.IOException -> L4c
            goto L6f
        L69:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            if (r0 == 0) goto L6f
            goto L65
        L6f:
            android.content.Intent r6 = new android.content.Intent
            java.io.File r0 = new java.io.File
            java.io.File r1 = r4.f1300c
            java.lang.String r1 = r1.getPath()
            r0.<init>(r1)
            android.net.Uri r0 = android.net.Uri.fromFile(r0)
            java.lang.String r1 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r6.<init>(r1, r0)
            r5.sendBroadcast(r6)
            return
        L89:
            if (r0 == 0) goto L93
            r0.close()     // Catch: java.io.IOException -> L8f
            goto L93
        L8f:
            r6 = move-exception
            r6.printStackTrace()
        L93:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.photoview.b.b(android.content.Context, android.graphics.Bitmap):void");
    }

    public b(Context context, String str, c cVar) {
        this.f1298a = str;
        this.f1299b = context;
        this.f1301d = cVar;
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap.Config config;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        System.out.getClass();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }
}
