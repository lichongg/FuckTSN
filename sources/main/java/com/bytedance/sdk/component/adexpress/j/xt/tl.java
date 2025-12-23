package com.bytedance.sdk.component.adexpress.j.xt;

import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {

    /* renamed from: j, reason: collision with root package name */
    private static com.bytedance.sdk.component.adexpress.j.cw.j f25830j;

    public static void j() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(up.ae(), "temp_pkg_info.json");
                long length = file.length();
                Long valueOf = Long.valueOf(length);
                if (length > 0 && file.exists() && file.isFile()) {
                    byte[] bArr = new byte[valueOf.intValue()];
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        com.bytedance.sdk.component.adexpress.j.cw.j j6 = com.bytedance.sdk.component.adexpress.j.cw.j.j(new JSONObject(new String(bArr, "utf-8")));
                        if (j6 != null) {
                            f25830j = j6;
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            vl.cw("Version", "version init error", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th3;
                        }
                    }
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } catch (Throwable th4) {
                fileInputStream = null;
                th = th4;
            }
        } catch (IOException unused2) {
        }
    }

    public static synchronized com.bytedance.sdk.component.adexpress.j.cw.j xt() {
        com.bytedance.sdk.component.adexpress.j.cw.j jVar;
        synchronized (tl.class) {
            jVar = f25830j;
        }
        return jVar;
    }

    public static boolean xt(com.bytedance.sdk.component.adexpress.j.cw.j jVar) {
        return cw.cw(xt(), jVar);
    }

    public static void cw() {
        cw.j(up.ae(), xt(), "temp_pkg_info.json");
    }

    public static void r() {
        cw.xt(up.ae(), xt(), "temp_pkg_info.json");
        f25830j = null;
    }

    public static synchronized void j(com.bytedance.sdk.component.adexpress.j.cw.j jVar) {
        synchronized (tl.class) {
            if (jVar != null) {
                if (jVar.m()) {
                    f25830j = jVar;
                }
            }
        }
    }

    public static boolean j(String str) {
        return cw.j(xt(), str);
    }
}
