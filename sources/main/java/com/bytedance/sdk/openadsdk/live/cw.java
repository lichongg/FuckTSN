package com.bytedance.sdk.openadsdk.live;

import a1.b;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.cw.r;
import com.bytedance.sdk.openadsdk.i.j.j.az;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private static final cw f31564j = new cw();
    private Map<String, String> cw;

    /* renamed from: r, reason: collision with root package name */
    private volatile xt f31565r;
    private volatile Function<SparseArray<Object>, Object> xt;

    private final class xt implements TTPluginListener {

        /* renamed from: j, reason: collision with root package name */
        int f31569j;
        String xt;

        private xt() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i6, ClassLoader classLoader, Resources resources, Bundle bundle) {
            j(i6, classLoader, resources, bundle, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(int i6, ClassLoader classLoader, Resources resources, Bundle bundle, boolean z5) {
            this.f31569j = i6;
            if (cw.this.xt != null) {
                cw.this.xt.apply(a.a().e(0, i6).g(1, classLoader).g(2, resources).g(3, bundle).g(4, cw.this.j(z5)).e(-99999987, 3).k().sparseArray());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(int i6, String str, boolean z5) {
            this.f31569j = i6;
            this.xt = str;
            if (cw.this.xt != null) {
                a e6 = a.a().e(0, i6);
                if (str != null) {
                    e6.h(1, str);
                }
                e6.g(2, cw.this.j(z5)).e(-99999987, 2);
                cw.this.xt.apply(e6.k().sparseArray());
            }
        }
    }

    private Object up(Map<String, Object> map) {
        String str;
        try {
            str = (String) map.get("expand_method_name");
        } catch (Throwable th) {
            th = th;
            str = null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
            Object[] objArr = (Object[]) map.get("expand_method_param");
            if (objArr == null) {
                return liveRoomService.callExpandMethod(str, new Object[0]);
            }
            for (int i6 = 0; i6 < objArr.length; i6++) {
                if (f.a(objArr[i6])) {
                    objArr[i6] = new com.bytedance.sdk.openadsdk.live.j(b.a(objArr[i6]));
                }
            }
            return liveRoomService.callExpandMethod(str, objArr);
        } catch (Throwable th2) {
            th = th2;
            j("invokeLiveExpandMethod-".concat(String.valueOf(str)), th);
            m.xt("TTLiveSDkBridge", th);
            return null;
        }
    }

    private static final class j implements Function<SparseArray<Object>, Object> {

        /* renamed from: j, reason: collision with root package name */
        private ILiveAdCustomConfig f31568j;

        j(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.f31568j = iLiveAdCustomConfig;
        }

        @Override // java.util.function.Function
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            int intValue = ((Integer) sparseArray.get(-99999987)).intValue();
            if (intValue != -99999986) {
                if (intValue != 0) {
                    if (intValue != 1) {
                        if (intValue != 2) {
                            if (intValue != 3) {
                                if (intValue != 4) {
                                    if (intValue != 5) {
                                        return null;
                                    }
                                    return this.f31568j;
                                }
                                this.f31568j.onEventV3((String) sparseArray.get(0), (JSONObject) sparseArray.get(1));
                                return null;
                            }
                            return this.f31568j.invoke(((Integer) sparseArray.get(0)).intValue(), (Bundle) sparseArray.get(1));
                        }
                        return this.f31568j.convertToEnterMethod(((Integer) sparseArray.get(0)).intValue(), ((Boolean) sparseArray.get(1)).booleanValue());
                    }
                    return this.f31568j.convertToEnterFromMerge(((Integer) sparseArray.get(0)).intValue());
                }
                return Integer.valueOf(this.f31568j.openLR((String) sparseArray.get(0)));
            }
            return a.a().e(10000, 1).k().sparseArray();
        }
    }

    private void cw(Map map) {
        ILiveHostContextParam.Builder addHostInitExtra = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.cw.1
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                Object apply;
                if (cw.this.xt == null) {
                    return null;
                }
                apply = cw.this.xt.apply(a.a().h(0, str).g(1, map2).e(-99999987, 0).k().sparseArray());
                return apply;
            }
        }).setPartnerSecret("p_secret").setHostPermission(new com.bytedance.sdk.openadsdk.live.j.j(r(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.j.xt(this.xt)).addHostInitExtra(xt(map));
        Map<String, String> map2 = this.cw;
        if (map2 != null) {
            addHostInitExtra.addHostInitExtra(map2);
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.cw.2
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFailed(String str) {
                m.j("TTLiveSDkBridge", "onLiveInitFailed! ", str);
                if (cw.this.f31565r != null) {
                    cw.this.f31565r.j(-3, str, false);
                }
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFinish() {
                m.xt("TTLiveSDkBridge", "onLiveInitFinish!");
                com.bytedance.sdk.openadsdk.live.xt.j();
                if (cw.this.f31565r != null) {
                    cw.this.f31565r.j(2, null, false);
                }
                cw.this.cw = null;
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            addHostInitExtra.setContext((Application) TTAppContextHolder.getContext());
        }
        Boolean valueOf = Boolean.valueOf(String.valueOf(map.get("sub_process")));
        m.j("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.bytedance.sdk.openadsdk.live.xt.j(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), addHostInitExtra, iLiveInitCallback, valueOf.booleanValue())), " subProcess=", valueOf);
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Boolean m(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get(d.X));
            Uri parse = Uri.parse(str);
            if (parse != null && context != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.xt.j(context, parse));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            j("handleLiveScheme", th);
            m.xt("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    private Function<SparseArray<Object>, Object> r(Map map) {
        return az.j(map.get("c_control"));
    }

    private Map<String, String> xt(Map map) {
        Object obj = map.get("live_tob_init_extra");
        return obj instanceof Map ? (Map) obj : new HashMap();
    }

    private cw() {
    }

    public static cw j() {
        return f31564j;
    }

    public static Function<SparseArray<Object>, Object> j(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new j(iLiveAdCustomConfig);
    }

    public void j(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.cw = map;
    }

    public <T> T j(int i6, Map<String, Object> map) {
        if (i6 == 0) {
            if (!com.bytedance.sdk.openadsdk.live.xt.j(getContext(map.get(d.X)), j(map.get("bundle")))) {
                return (T) 2;
            }
            return (T) 0;
        }
        if (i6 == 7) {
            return (T) up(map);
        }
        if (i6 != 8) {
            return null;
        }
        return (T) m(map);
    }

    private Bundle j(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    public static void j(String str, Throwable th) {
        try {
            TTAdManager adManager = TTAdSdk.getAdManager();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", str);
            if (th != null) {
                jSONObject.put("msg", Log.getStackTraceString(th));
            }
            Bundle bundle = new Bundle();
            bundle.putInt(com.umeng.ccg.a.f41544t, 1);
            bundle.putString("event_name", "exception");
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        } catch (Exception e6) {
            m.xt("TTLiveSDkBridge", e6);
        }
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet k6 = a.j(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        if (intValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 2);
            return sparseArray2;
        }
        if (intValue == 5) {
            cw((Map) k6.objectValue(0, Map.class));
            return null;
        }
        if (intValue != 9) {
            return j(intValue, (Map<String, Object>) k6.objectValue(0, Map.class));
        }
        this.xt = az.j(k6.objectValue(0, Object.class));
        if (this.f31565r != null) {
            if (this.f31565r.f31569j == 2 || this.f31565r.f31569j == -3) {
                this.f31565r.j(this.f31565r.f31569j, this.f31565r.xt, true);
            } else if (this.f31565r.f31569j != 0) {
                this.f31565r.j(this.f31565r.f31569j, null, null, null, true);
            }
        } else {
            this.f31565r = new xt();
            Function<SparseArray<Object>, Object> j6 = az.j(r.j().apply(a.b(2).e(0, 4).e(-99999987, 10).k().sparseArray()));
            ValueSet k7 = a.b(2).e(-99999987, 106).g(0, this.f31565r).k();
            if (j6 != null) {
                j6.apply(k7.sparseArray());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map j(boolean z5) {
        HashMap hashMap = new HashMap();
        hashMap.put("onlyUpdateState", Boolean.valueOf(z5));
        return hashMap;
    }
}
