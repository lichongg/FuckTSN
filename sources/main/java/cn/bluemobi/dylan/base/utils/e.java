package cn.bluemobi.dylan.base.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e {
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(java.lang.String r4) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            java.io.InputStream r2 = r4.getInputStream()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            int r2 = r1.available()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            r1.mark(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            r2.<init>()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            r3 = 1
            r2.inJustDecodeBounds = r3     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            r3 = 0
            r2.inJustDecodeBounds = r3     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            r1.reset()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            r4.disconnect()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            r1.close()     // Catch: java.io.IOException -> L37
        L37:
            return r2
        L38:
            r4 = move-exception
            r0 = r1
            goto L4a
        L3b:
            r4 = move-exception
            goto L41
        L3d:
            r4 = move-exception
            goto L4a
        L3f:
            r4 = move-exception
            r1 = r0
        L41:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L49
            r1.close()     // Catch: java.io.IOException -> L49
        L49:
            return r0
        L4a:
            if (r0 == 0) goto L4f
            r0.close()     // Catch: java.io.IOException -> L4f
        L4f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.base.utils.e.a(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0047: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:72), block:B:23:0x0047 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap b(java.lang.String r4, android.widget.ImageView r5) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.io.InputStream r2 = r4.getInputStream()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            int r2 = r1.available()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            r1.mark(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            r2.<init>()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            r3 = 1
            r2.inJustDecodeBounds = r3     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            cn.bluemobi.dylan.base.utils.i$a r5 = cn.bluemobi.dylan.base.utils.i.c(r5)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            int r3 = r5.f1226a     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            int r5 = r5.f1227b     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            int r5 = cn.bluemobi.dylan.base.utils.i.a(r2, r3, r5)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            r2.inSampleSize = r5     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            r5 = 0
            r2.inJustDecodeBounds = r5     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            r1.reset()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            r4.disconnect()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            r1.close()     // Catch: java.io.IOException -> L45
        L45:
            return r5
        L46:
            r4 = move-exception
            r0 = r1
            goto L58
        L49:
            r4 = move-exception
            goto L4f
        L4b:
            r4 = move-exception
            goto L58
        L4d:
            r4 = move-exception
            r1 = r0
        L4f:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L46
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.io.IOException -> L57
        L57:
            return r0
        L58:
            if (r0 == 0) goto L5d
            r0.close()     // Catch: java.io.IOException -> L5d
        L5d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.base.utils.e.b(java.lang.String, android.widget.ImageView):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.String r4, java.io.File r5) {
        /*
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.net.URLConnection r4 = r2.openConnection()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r5 = 512(0x200, float:7.17E-43)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
        L1a:
            int r1 = r4.read(r5)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
            r3 = -1
            if (r1 == r3) goto L2b
            r2.write(r5, r0, r1)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
            goto L1a
        L25:
            r5 = move-exception
        L26:
            r1 = r4
            goto L52
        L28:
            r5 = move-exception
        L29:
            r1 = r4
            goto L41
        L2b:
            r2.flush()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
            r4.close()     // Catch: java.io.IOException -> L31
        L31:
            r2.close()     // Catch: java.io.IOException -> L34
        L34:
            r4 = 1
            return r4
        L36:
            r5 = move-exception
            r2 = r1
            goto L26
        L39:
            r5 = move-exception
            r2 = r1
            goto L29
        L3c:
            r5 = move-exception
            r2 = r1
            goto L52
        L3f:
            r5 = move-exception
            r2 = r1
        L41:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L4b
            r1.close()     // Catch: java.io.IOException -> L4a
            goto L4b
        L4a:
        L4b:
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.io.IOException -> L50
        L50:
            return r0
        L51:
            r5 = move-exception
        L52:
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.io.IOException -> L58
            goto L59
        L58:
        L59:
            if (r2 == 0) goto L5e
            r2.close()     // Catch: java.io.IOException -> L5e
        L5e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.base.utils.e.c(java.lang.String, java.io.File):boolean");
    }
}
