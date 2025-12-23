package com.bytedance.sdk.openadsdk.api.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import com.bytedance.sdk.openadsdk.api.plugin.tl;
import java.io.File;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
class cw {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile cw cw;

    /* renamed from: j, reason: collision with root package name */
    private static final String f27555j;
    private static final String xt;
    private volatile boolean ae;

    /* renamed from: m, reason: collision with root package name */
    private tl.j f27556m;

    /* renamed from: r, reason: collision with root package name */
    private final Context f27557r;
    private final Function<SparseArray<Object>, Object> up = new g.cw();

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append("next");
        f27555j = sb.toString();
        xt = str + "tmp";
    }

    private File cw() {
        return new File(j(), f27555j);
    }

    private File xt() {
        return new File(j(), xt);
    }

    private cw(Context context) {
        this.f27557r = context;
    }

    public static cw j(Context context) {
        if (cw == null) {
            synchronized (cw.class) {
                try {
                    if (cw == null) {
                        cw = new cw(context);
                    }
                } finally {
                }
            }
        }
        return cw;
    }

    public void j(List<tl.j> list) {
        if (list == null || list.isEmpty()) {
            up.j("plugin_download", "plugin is empty");
            return;
        }
        tl.j jVar = list.get(0);
        this.f27556m = jVar;
        if (TextUtils.isEmpty(jVar.cw)) {
            return;
        }
        String str = this.f27556m.f27592j + "-" + this.f27556m.xt + "-" + this.f27556m.f27593m + "-" + this.f27556m.ae + ".apk";
        File cw2 = cw();
        File file = new File(cw2, str);
        if (file.exists()) {
            up.j("plugin_download", "plugin file already exists");
            com.bytedance.sdk.openadsdk.api.m.xt("FileDownloadTask", "Plugin file already exists.");
            this.f27556m.f27591g = file.getAbsolutePath();
            tl.j jVar2 = this.f27556m;
            jVar2.oq = jVar2.xt < 7012;
            j(true, jVar2.f27592j, jVar2.toString());
            return;
        }
        File xt2 = xt();
        if (!cw2.exists()) {
            cw2.mkdirs();
        }
        if (!xt2.exists()) {
            xt2.mkdirs();
        }
        j(this.f27556m.cw, cw2.getAbsolutePath(), xt2.getAbsolutePath(), str);
    }

    private void j(String str, String str2, String str3, String str4) {
        if (this.ae) {
            com.bytedance.sdk.openadsdk.api.m.xt("FileDownloadTask", "Downloading...");
            return;
        }
        this.ae = true;
        try {
            File file = new File(str2 + "/" + str4);
            if (file.exists()) {
                file.delete();
            }
            com.bytedance.sdk.openadsdk.api.plugin.xt.cw.j().j(str, str2, str4, new EventListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.cw.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i6, Result result) {
                    cw.this.ae = false;
                    if (i6 != 0) {
                        String message = result.message();
                        up.j("plugin_download", "download failed: ".concat(String.valueOf(message)));
                        com.bytedance.sdk.openadsdk.api.m.up("FileDownloadTask", "Download failed. ".concat(String.valueOf(message)));
                        cw cwVar = cw.this;
                        cwVar.j(false, cwVar.f27556m.f27592j, cw.this.f27556m.toString());
                        return null;
                    }
                    up.j("plugin_download", "download success");
                    cw.this.f27556m.f27591g = result.message();
                    com.bytedance.sdk.openadsdk.api.m.xt("FileDownloadTask", "Download end." + cw.this.f27556m.f27591g);
                    cw.this.f27556m.oq = cw.this.f27556m.xt < 7012;
                    cw cwVar2 = cw.this;
                    cwVar2.j(true, cwVar2.f27556m.f27592j, cw.this.f27556m.toString());
                    return null;
                }
            });
            up.j("plugin_download", "start download");
            com.bytedance.sdk.openadsdk.api.m.xt("FileDownloadTask", "Download start.");
        } catch (Throwable th) {
            up.j("plugin_download", "download error: ".concat(String.valueOf(th)));
            com.bytedance.sdk.openadsdk.api.m.up("FileDownloadTask", "Download file error: ".concat(String.valueOf(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z5, String str, String str2) {
        ValueSet k6 = a.a().e(-999900, z5 ? 0 : 1004).i(-999903, z5).g(-999902, a.a().h(2, str2).h(3, str).k().sparseArray()).k();
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 1);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(-99999979, k6.sparseArray());
        this.up.apply(sparseArray);
    }

    private File j() {
        return xt.j(this.f27557r, "tt_pangle_bykv_file", 0);
    }
}
