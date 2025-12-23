package com.bytedance.msdk.m.xt;

import a1.a;
import a1.b;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.ws;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends com.bytedance.sdk.openadsdk.core.wq.r implements com.bytedance.msdk.j.j.r {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private cw f25193j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.msdk.api.r.cw f25194m;
    private Function<SparseArray<Object>, Object> up;
    private Function<SparseArray<Object>, Object> xt;

    /* renamed from: r, reason: collision with root package name */
    private List<com.bytedance.msdk.j.j.cw> f25195r = new CopyOnWriteArrayList();
    private long ae = 0;
    private int tl = 0;

    public static String xt(String str) {
        str.getClass();
        switch (str) {
            case "sigmob":
                return "a.b.c.d.e.f.sob.SobFunction";
            case "xiaomi":
                return "a.b.c.d.e.f.xmi.XmiFunction";
            case "ks":
                return "a.b.c.d.e.f.kou.KouFunction";
            case "gdt":
                return "a.b.c.d.e.f.gng.GngFunction";
            case "admob":
                return "a.b.c.d.e.f.aob.AobFunction";
            case "baidu":
                return "a.b.c.d.e.f.bdu.BduFunction";
            case "unity":
                return "a.b.c.d.e.f.uty.UtyFunction";
            case "mintegral":
                return "a.b.c.d.e.f.mal.MalFunction";
            default:
                return null;
        }
    }

    @Override // com.bytedance.msdk.j.j.r
    public void ae() {
        this.tl = 0;
        this.ae = 0L;
    }

    @Override // com.bytedance.msdk.j.j.r
    public String cw() {
        return null;
    }

    @Override // com.bytedance.msdk.j.j.xt
    public void j(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull com.bytedance.msdk.j.j.cw cwVar) {
        if (!this.f25195r.contains(cwVar)) {
            this.f25195r.add(cwVar);
        }
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
        up.j(j6);
        j6.j(3, map.get("app_id"));
        j6.j(8550, Boolean.valueOf(com.bytedance.msdk.core.j.qv().ch()));
        j6.j(8, com.bytedance.msdk.core.j.qv().tj());
        j6.j(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold, map.get("app_key"));
        String str = (String) map.get(MediationConstant.EXTRA_ADN_NAME);
        this.cw = str;
        j6.j(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, j(str));
        j6.j(8560, xt(this.cw));
        j6.j(8003, map.get(MediationConstant.EXTRA_ADN_NAME));
        j6.j(8410, "3.3.76.5.4");
        j6.j(8411, com.bytedance.msdk.xt.xt.cw());
        j6.j(8412, "17.2.0.70");
        j6.j(8413, "9.3905.5");
        j6.j(8414, "4.640.1510.4");
        j6.j(8415, "2.11.0.3.31");
        j6.j(8417, "4.22.2.4");
        j6.j(8418, "4.3.0.37");
        j6.j(8416, "16.6.57.13");
        j6.j(8558, "2.11.0.3.31");
        j6.j(7, Integer.valueOf(g()));
        j6.j(8425, map);
        j6.j(8300, this);
        try {
            Function<SparseArray<Object>, Object> cw = com.bytedance.msdk.core.j.j.up.cw(this.cw);
            if (cw != null) {
                this.up = cw;
                cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8240).j(Void.class).j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).j(8424, j6.xt()).xt());
            } else {
                j6.j(AVMDLDataLoader.KeyIsLiveLoaderEnable).j(Void.class);
                this.xt.apply(j6.xt());
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    private void vl() {
        Iterator<com.bytedance.msdk.j.j.cw> it = this.f25195r.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
        this.f25195r.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 8122) {
            this.up = b.a(pluginValueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, a.a()));
            vl();
        } else if (i6 == 8123) {
            SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class);
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class);
            }
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(8022, SparseArray.class);
            }
            if (sparseArray != null) {
                PluginValueSet k6 = e.i(sparseArray).k();
                j(new com.bytedance.msdk.api.j(k6.intValue(-999900), k6.stringValue(-999901)));
                return null;
            }
        } else if (i6 == 8212) {
            if (this.f25194m != null) {
                this.f25194m.j(pluginValueSet.intValue(8095));
            }
        } else if (i6 == 8266) {
            this.up = b.a(pluginValueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, a.a()));
        } else if (i6 == 8270) {
            this.tl = pluginValueSet.intValue(8557);
            this.ae = pluginValueSet.longValue(8556) - pluginValueSet.longValue(8555);
        }
        return null;
    }

    @Override // com.bytedance.msdk.j.j.r
    public int m() {
        return this.tl;
    }

    public String tl() {
        return this.cw;
    }

    @Override // com.bytedance.msdk.j.j.r
    public long up() {
        return this.ae;
    }

    public r() {
        cw j6 = cw.j(com.bytedance.msdk.core.j.qv().ol());
        this.f25193j = j6;
        this.xt = j6.j();
    }

    private int g() {
        com.bytedance.msdk.j.cw.cw xt = com.bytedance.msdk.core.j.qv().xt();
        if (xt != null) {
            return xt.ch();
        }
        return 0;
    }

    private void oq() {
        com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", tl() + "版本号：" + xt() + " , 聚合版本号：" + com.bytedance.sdk.gromore.init.j.cw());
    }

    private void qv() {
        String cw = com.bytedance.sdk.gromore.init.j.cw();
        if (!TextUtils.isEmpty(j())) {
            com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", tl() + "版本号：" + xt() + " , " + tl() + "Adapter版本号：" + j() + " , 聚合版本号：" + cw);
            return;
        }
        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_SDK_Init", tl() + "版本号：" + xt() + " , ***" + tl() + "Adapter未接入，请检查***, 聚合版本号：" + cw);
    }

    @Override // com.bytedance.msdk.j.j.r
    public void r() {
        try {
            if (com.bytedance.msdk.core.j.j.up.cw(tl()) != null) {
                oq();
            } else {
                qv();
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.msdk.j.j.r
    public Map<String, Object> xt(Context context, Map<String, Object> map) {
        Object apply;
        if (this.up != null) {
            apply = this.up.apply(com.bytedance.sdk.openadsdk.i.r.j().j(AVMDLDataLoader.KeyIsLiveGetLoaderType).j(String.class).j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).j(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).xt());
            if (apply instanceof Map) {
                return (Map) apply;
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.j.j.r
    public String xt() {
        Object apply;
        try {
            Function<SparseArray<Object>, Object> function = this.up;
            if (function != null) {
                apply = function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8104).j(String.class).xt());
                return apply instanceof String ? (String) apply : "";
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        return "";
    }

    public static String j(String str) {
        str.getClass();
        switch (str) {
            case "klevin":
                return MediationConstant.KLEVIN_ADN_CLASS_NAME;
            case "sigmob":
                return MediationConstant.SIGMOB_ADN_CLASS_NAME;
            case "xiaomi":
                return MediationConstant.XIAOMI_ADN_CLASS_NAME;
            case "ks":
                return MediationConstant.KS_ADN_CLASS_NAME;
            case "gdt":
                return MediationConstant.GDT_ADN_CLASS_NAME;
            case "admob":
                return MediationConstant.ADMOB_ADN_CLASS_NAME;
            case "baidu":
                return MediationConstant.BAIDU_ADN_CLASS_NAME;
            case "unity":
                return MediationConstant.UNITY_ADN_CLASS_NAME;
            case "mintegral":
                return MediationConstant.MINTEGRAL_ADN_CLASS_NAME;
            default:
                return null;
        }
    }

    @Override // com.bytedance.msdk.j.j.r
    public String j() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.up;
        if (function != null) {
            apply = function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable).j(String.class).xt());
            if (apply instanceof String) {
                return (String) apply;
            }
        }
        return "";
    }

    @Override // com.bytedance.msdk.j.j.r
    public String j(Context context, Map<String, Object> map) {
        Object apply;
        if (this.up != null) {
            apply = this.up.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8102).j(String.class).j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).j(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).xt());
            if (apply instanceof String) {
                return (String) apply;
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.j.j.r
    public void j(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> function = this.up;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8242).j(Void.class).j(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).xt());
        }
    }

    @Override // com.bytedance.msdk.j.j.r
    public int j(com.bytedance.msdk.api.r.cw cwVar) {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.up;
        if (function != null) {
            this.f25194m = cwVar;
            apply = function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8126).j(Integer.class).xt());
            if (apply != null) {
                return ((Integer) apply).intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.msdk.j.j.r
    public void j(ws wsVar, SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> function = this.up;
        if (function == null || wsVar == null) {
            return;
        }
        function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8124).j(Void.class).j(8517, sparseArray).xt());
    }

    private void j(com.bytedance.msdk.api.j jVar) {
        Iterator<com.bytedance.msdk.j.j.cw> it = this.f25195r.iterator();
        while (it.hasNext()) {
            it.next().j(jVar);
        }
        this.f25195r.clear();
    }
}
