package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class GDTApkManager {

    /* renamed from: a, reason: collision with root package name */
    private DFA f36595a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f36596b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f36597c = false;

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f36598d = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    private Context f36599e;

    public final void loadGDTApk() {
        if (this.f36596b) {
            if (!this.f36597c) {
                this.f36598d.incrementAndGet();
                return;
            }
            DFA dfa = this.f36595a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.e("调用loadGDTApk失败，实例未被正常初始化");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.f36595a;
        if (dfa != null) {
            dfa.startInstall(this.f36599e, gDTApk);
        }
    }

    public GDTApkManager(Context context, IGDTApkListener iGDTApkListener) {
        if (a.b().d()) {
            a(context, a.b().a(), iGDTApkListener);
        }
    }

    private void a(Context context, String str, final IGDTApkListener iGDTApkListener) {
        if (TextUtils.isEmpty(str) || context == null) {
            GDTLogger.e("初始化错误：GDTApkManager 构造失败，Context和appID不能为空");
        } else {
            if (!com.qq.e.comm.a.a(context)) {
                GDTLogger.e("初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明");
                return;
            }
            this.f36596b = true;
            this.f36599e = context;
            a.f36742g.execute(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = a.b().c().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        GDTApkManager.this.f36595a = a.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                        GDTApkManager.this.f36597c = true;
                                        while (GDTApkManager.this.f36598d.getAndDecrement() > 0) {
                                            GDTApkManager.this.loadGDTApk();
                                        }
                                    }
                                } finally {
                                    try {
                                    } finally {
                                    }
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化时发生异常", th);
                    }
                }
            });
        }
    }
}
