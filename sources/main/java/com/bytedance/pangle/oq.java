package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.qv;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq {

    /* renamed from: j, reason: collision with root package name */
    private static volatile oq f25416j;
    private boolean xt;
    private final List<ZeusPluginStateListener> cw = new CopyOnWriteArrayList();

    /* renamed from: r, reason: collision with root package name */
    private final List<ZeusPluginEventCallback> f25418r = new ArrayList();
    private final Handler up = new Handler(Looper.getMainLooper());

    /* renamed from: m, reason: collision with root package name */
    private ZeusPluginDecodeCallback f25417m = null;
    private Map<String, JSONObject> ae = new ConcurrentHashMap();

    public static oq j() {
        if (f25416j == null) {
            synchronized (oq.class) {
                try {
                    if (f25416j == null) {
                        f25416j = new oq();
                    }
                } finally {
                }
            }
        }
        return f25416j;
    }

    public boolean xt() {
        return this.xt;
    }

    private void ae() {
        try {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke disableApiWarning");
            FieldUtils.writeField(com.bytedance.pangle.up.j.j(), "mHiddenApiWarningShown", Boolean.TRUE);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
        } catch (Exception e6) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e6);
        }
    }

    private void m() {
        ProviderInfo[] providerInfoArr;
        String str;
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "start");
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                            if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                                str = providerInfo.processName.split(":")[1];
                                if (Zeus.getServerManagerHashMap().get(str) != null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                                    Zeus.getServerManagerHashMap().put(str, providerInfo);
                                }
                            }
                            str = "main";
                            if (Zeus.getServerManagerHashMap().get(str) != null) {
                            }
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, ConstantHelper.LOG_FINISH);
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e6) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "error:".concat(String.valueOf(e6)));
            throw new RuntimeException(e6);
        }
    }

    private Object[] tl() {
        Object[] array;
        synchronized (this.f25418r) {
            try {
                array = !this.f25418r.isEmpty() ? this.f25418r.toArray() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return array == null ? new Object[0] : array;
    }

    public List<ZeusPluginStateListener> cw() {
        return this.cw;
    }

    public ZeusPluginDecodeCallback r() {
        return this.f25417m;
    }

    public Map<String, JSONObject> up() {
        return this.ae;
    }

    public void xt(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = this.cw;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public void xt(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.f25418r) {
            this.f25418r.remove(zeusPluginEventCallback);
        }
    }

    synchronized void j(Application application) {
        Throwable th;
        try {
            try {
                if (this.xt) {
                    try {
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                j(3000, 0, null, -1, null);
                Zeus.setAppContext(application);
                GlobalParam globalParam = GlobalParam.getInstance();
                globalParam.init();
                if (application != null) {
                    ZeusLogger.setDebug(globalParam.isDebug());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
                    com.bytedance.pangle.up.up.xt(new Runnable() { // from class: com.bytedance.pangle.oq.1
                        @Override // java.lang.Runnable
                        public void run() {
                            qv.xt();
                        }
                    });
                    if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                        com.bytedance.pangle.m.m.j();
                    }
                    com.bytedance.pangle.r.xt.j().j(new com.bytedance.pangle.r.j() { // from class: com.bytedance.pangle.oq.2
                        @Override // com.bytedance.pangle.r.j
                        public void j(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                            com.bytedance.pangle.log.xt.j(str, jSONObject, jSONObject2, jSONObject3);
                        }
                    });
                    if (!globalParam.isCloseFlipped()) {
                        xt.j();
                    }
                    if (com.bytedance.pangle.util.g.i()) {
                        com.bytedance.pangle.up.up.j(new Runnable() { // from class: com.bytedance.pangle.oq.3
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke SystemConfig");
                                    MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                                } catch (Throwable th3) {
                                    GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "invoke SystemConfig error : ".concat(String.valueOf(th3)));
                                }
                            }
                        });
                    }
                    if (com.bytedance.pangle.util.g.az()) {
                        ae();
                    }
                    m();
                    ContentProviderManager.getInstance().initSystemContentProviderInfo();
                    if (!globalParam.closeHookHuaweiOnInit()) {
                        Zeus.hookHuaWeiVerifier(application);
                    }
                    this.xt = true;
                    try {
                        j(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "context is null");
                throw new IllegalArgumentException("context must be not null !!!");
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public void j(ZeusPluginStateListener zeusPluginStateListener) {
        this.cw.add(zeusPluginStateListener);
    }

    public void j(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.f25418r) {
            this.f25418r.add(zeusPluginEventCallback);
        }
    }

    public void j(final int i6, final int i7, @Nullable final String str, final int i8, @Nullable final Throwable th) {
        for (final Object obj : tl()) {
            this.up.post(new Runnable() { // from class: com.bytedance.pangle.oq.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i6, i7, str, i8, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void j(ZeusPluginDecodeCallback zeusPluginDecodeCallback) {
        this.f25417m = zeusPluginDecodeCallback;
    }
}
