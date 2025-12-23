package com.bytedance.sdk.openadsdk.core.ugeno.up;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.j.cw.j;
import com.bytedance.sdk.component.adexpress.j.xt.cw;
import com.bytedance.sdk.component.adexpress.j.xt.r;
import com.bytedance.sdk.component.adexpress.r.oq;
import com.bytedance.sdk.component.adexpress.up.up;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.ugeno.m.xt;
import com.bytedance.sdk.openadsdk.core.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends cw {
    private static volatile File cw;

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f30834j;
    private static AtomicReference<xt> up = new AtomicReference<>(null);
    private AtomicBoolean xt = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private AtomicBoolean f30835r = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                if (up.get() != null) {
                    return;
                }
                File file = new File(j(), "package_ugen_temp.json");
                long length = file.length();
                Long valueOf = Long.valueOf(length);
                if (length > 0 && file.exists() && file.isFile()) {
                    byte[] bArr = new byte[valueOf.intValue()];
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        up.set(xt.xt(new JSONObject(new String(bArr, "utf-8"))));
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            vl.cw("PlayComponentEngineCacheManager", "version init error", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e6) {
                                    vl.j(e6);
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
        } catch (IOException e7) {
            vl.j(e7);
        }
    }

    public static j xt() {
        if (f30834j == null) {
            synchronized (j.class) {
                try {
                    if (f30834j == null) {
                        f30834j = new j();
                    }
                } finally {
                }
            }
        }
        return f30834j;
    }

    public void ae() {
        xt xtVar = up.get();
        if (xtVar == null || !xtVar.m()) {
            return;
        }
        boolean j6 = j(xtVar.getResources());
        if (!j6) {
            up();
        }
        this.f30835r.set(j6);
    }

    public void cw() {
        ae.j(new g("enginecache-init") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.j.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    j.this.g();
                    j.this.ae();
                    j.this.r();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.j.xt.cw
    public File j() {
        if (cw == null) {
            try {
                File file = new File(new File(r.j(), "tt_ugen_pkg"), "engine");
                file.mkdirs();
                cw = file;
            } catch (Throwable th) {
                vl.cw("PlayComponentEngineCacheManager", "ge", th);
            }
        }
        return cw;
    }

    public void r() {
        try {
            if (this.xt.get()) {
                return;
            }
            boolean z5 = true;
            this.xt.set(true);
            xt xtVar = new xt(v.j().j(2));
            xt xtVar2 = up.get();
            if (!xtVar.m()) {
                this.xt.set(false);
                return;
            }
            if (!cw.j(xtVar2, xtVar.cw())) {
                this.xt.set(false);
                return;
            }
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.j.2
                @Override // java.lang.Runnable
                public void run() {
                    up.j().xt();
                }
            });
            List<j.C0397j> xt = xt(xtVar, xtVar2);
            if (xt == null) {
                z5 = false;
            }
            if (xt == null) {
                this.xt.set(false);
            }
            if (z5 && j(xtVar.getResources())) {
                up.set(xtVar);
                cw.j(j(), up.get(), "package_ugen_temp.json");
                xt(xt);
            }
            ae();
            this.xt.set(false);
        } catch (Throwable unused) {
        }
    }

    public boolean tl() {
        AtomicBoolean atomicBoolean = this.f30835r;
        return atomicBoolean != null && atomicBoolean.get();
    }

    public void m() {
        try {
            up();
            File j6 = j();
            if (j6 != null && j6.exists()) {
                if (j6.getParentFile() != null) {
                    m.cw(j6.getParentFile());
                } else {
                    m.cw(j6);
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public void up() {
        cw.xt(j(), up.get(), "package_ugen_temp.json");
        up.set(null);
    }

    private File xt(String str) {
        xt xtVar;
        if (!tl() || (xtVar = up.get()) == null) {
            return null;
        }
        Iterator<j.C0397j> it = xtVar.getResources().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j.C0397j next = it.next();
            if (next.j() != null && next.j().equals(str)) {
                File file = new File(j(), com.bytedance.sdk.component.utils.up.xt(next.j()));
                String j6 = com.bytedance.sdk.component.utils.up.j(file);
                if (next.xt() == null || !next.xt().equals(j6)) {
                    break;
                }
                return file;
            }
        }
        return null;
    }

    public WebResourceResponse j(WebView webView, oq.j jVar, String str) {
        File xt;
        try {
            if (TextUtils.isEmpty(str) || jVar == oq.j.IMAGE || (xt = xt(str)) == null) {
                return null;
            }
            return new WebResourceResponse(jVar.getType(), "utf-8", new FileInputStream(xt));
        } catch (Throwable th) {
            vl.cw("PlayComponentEngineCacheManager", "grwe", th);
            return null;
        }
    }
}
