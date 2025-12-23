package com.bytedance.sdk.component.ae.cw;

import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements com.bytedance.sdk.component.ae.j, com.bytedance.sdk.component.ae.xt {
    private static boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private static Method f26074j;
    private static Method xt;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.sdk.component.r.j.j f26075r;
    private final boolean up;

    static {
        try {
            Class<?> cls = Class.forName("com.android.internal.util.XmlUtils");
            f26074j = cls.getDeclaredMethod("readMapXml", InputStream.class);
            xt = cls.getDeclaredMethod("writeMapXml", Map.class, OutputStream.class);
            f26074j.setAccessible(true);
            xt.setAccessible(true);
            cw = true;
        } catch (Exception unused) {
            cw = false;
        }
    }

    public up(com.bytedance.sdk.component.r.j.j jVar) {
        this.f26075r = jVar;
        this.up = false;
    }

    public static boolean j() {
        return cw;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.component.ae.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.Object> j(java.io.File r7) {
        /*
            r6 = this;
            boolean r0 = com.bytedance.sdk.component.ae.cw.up.cw
            if (r0 == 0) goto L73
            boolean r0 = r7.exists()
            if (r0 == 0) goto L73
            boolean r0 = r7.canRead()
            r1 = 0
            if (r0 != 0) goto L21
            java.lang.String r0 = "can't read file "
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r7 = r0.concat(r7)
            java.lang.String r0 = "PropReaderWriter"
            com.bytedance.sdk.component.utils.vl.xt(r0, r7)
            return r1
        L21:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r3 = 49152(0xc000, float:6.8877E-41)
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.reflect.Method r2 = com.bytedance.sdk.component.ae.cw.up.f26074j     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r4 = 0
            r3[r4] = r0     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            com.bytedance.sdk.component.ae.j.xt r2 = new com.bytedance.sdk.component.ae.j.xt     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r2.<init>()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            com.bytedance.sdk.component.r.j.j r3 = r6.f26075r     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            boolean r4 = r6.up     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.util.Map r7 = r2.j(r1, r3, r4)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r0.close()     // Catch: java.io.IOException -> L4c
        L4c:
            return r7
        L4d:
            r7 = move-exception
            r1 = r0
            goto L6d
        L50:
            r1 = move-exception
            goto L58
        L52:
            r7 = move-exception
            goto L6d
        L54:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L58:
            java.lang.String r2 = "XmlReader"
            java.lang.String r3 = "read file exception: "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r7 = r3.concat(r7)     // Catch: java.lang.Throwable -> L4d
            com.bytedance.sdk.component.utils.vl.xt(r2, r7, r1)     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L73
            r0.close()     // Catch: java.io.IOException -> L73
            goto L73
        L6d:
            if (r1 == 0) goto L72
            r1.close()     // Catch: java.io.IOException -> L72
        L72:
            throw r7
        L73:
            java.util.Map r7 = java.util.Collections.EMPTY_MAP
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ae.cw.up.j(java.io.File):java.util.Map");
    }

    public up(com.bytedance.sdk.component.r.j.j jVar, boolean z5) {
        this.f26075r = jVar;
        this.up = z5;
    }

    @Override // com.bytedance.sdk.component.ae.xt
    public void j(Map<String, Object> map, File file) throws IOException {
        if (!cw || file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    xt.invoke(null, new com.bytedance.sdk.component.ae.j.xt().j(map, this.f26075r, this.up), fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileOutputStream = fileOutputStream2;
                    vl.xt("XmlReader", "write: to file exception: ".concat(String.valueOf(file)), e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }
}
