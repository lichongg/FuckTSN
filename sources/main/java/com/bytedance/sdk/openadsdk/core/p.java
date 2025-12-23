package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import java.io.File;

/* loaded from: D:\Downloads\app\classes4.dex */
public class p {

    /* renamed from: m, reason: collision with root package name */
    private static xt f29781m;

    /* renamed from: j, reason: collision with root package name */
    public static String f29780j = Environment.DIRECTORY_DCIM;
    private static String xt = Environment.DIRECTORY_PICTURES;
    private static String cw = "Screenshots";

    /* renamed from: r, reason: collision with root package name */
    private static volatile boolean f29782r = false;
    private static volatile boolean up = false;
    private static long ae = 0;

    private interface j {
        void j(String str);
    }

    private static final class xt extends FileObserver {

        /* renamed from: j, reason: collision with root package name */
        private j f29843j;

        private xt(String str, int i6, j jVar) {
            super(str, i6);
            this.f29843j = jVar;
        }

        static xt j(File file, j jVar) {
            if (file == null || jVar == null) {
                return null;
            }
            return Build.VERSION.SDK_INT >= 29 ? new xt(file, 256, jVar) : new xt(file.getAbsolutePath(), 256, jVar);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i6, String str) {
            j jVar = this.f29843j;
            if (jVar != null) {
                jVar.j(str);
            }
        }

        private xt(File file, int i6, j jVar) {
            super(file, i6);
            this.f29843j = jVar;
        }
    }

    private static File m() {
        return null;
    }

    public static void xt() {
        int checkSelfPermission;
        up = true;
        if (f29782r) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            checkSelfPermission = v.getContext().checkSelfPermission(com.kuaishou.weapon.p0.g.f36050j);
            if (checkSelfPermission != 0) {
                return;
            }
        }
        com.bytedance.sdk.component.oq.ae.r(new com.bytedance.sdk.component.oq.g("sso") { // from class: com.bytedance.sdk.openadsdk.core.p.1
            @Override // java.lang.Runnable
            public void run() {
                p.up();
            }
        });
    }

    public static long cw() {
        return ae;
    }

    public static void j() {
        if (!up || f29782r) {
            return;
        }
        try {
            xt();
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("ScreenShotObserver", "权限检查出错时,异常代码：" + e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void up() {
        File m6;
        if (f29782r || (m6 = m()) == null) {
            return;
        }
        f29781m = xt.j(m6, new j() { // from class: com.bytedance.sdk.openadsdk.core.p.2
            @Override // com.bytedance.sdk.openadsdk.core.p.j
            public void j(String str) {
                long unused = p.ae = System.currentTimeMillis();
            }
        });
        f29782r = true;
        m6.exists();
        xt xtVar = f29781m;
        if (xtVar != null) {
            xtVar.startWatching();
        }
    }
}
