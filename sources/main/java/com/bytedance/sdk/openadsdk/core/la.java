package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.live.EcBackUpWebView;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class la implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final PluginValueSet f29430j = com.bykv.j.j.j.j.e.a().f(11, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.core.la.1
        @Override // java.util.function.Supplier
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer get() {
            return Integer.valueOf(oq.i().q());
        }
    })).g(12, "7.0.1.2").k();

    public void j(Object obj) {
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            if (bundle.containsKey(PluginConstants.KEY_PL_CONFIG_INFO)) {
                oq.i().j(bundle.getBundle(PluginConstants.KEY_PL_CONFIG_INFO));
                if (oq.i().rn().length() == 0 || com.bytedance.sdk.openadsdk.core.rn.az.xt()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.s.j.j.j().xt();
                return;
            }
            return;
        }
        if (com.bykv.j.j.j.j.f.a(obj) && !com.bytedance.sdk.openadsdk.core.wq.j.cw.xt(obj)) {
            j(a1.b.a(obj));
            return;
        }
        if (obj instanceof PluginValueSet) {
            PluginValueSet pluginValueSet = (PluginValueSet) obj;
            try {
                if (pluginValueSet.intValue(0) == 1) {
                    j((ClassLoader) pluginValueSet.objectValue(2, ClassLoader.class), pluginValueSet.stringValue(1));
                }
            } catch (Throwable unused) {
            }
        }
        if ((h.m() || com.bytedance.sdk.openadsdk.core.rn.uf.g().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.bytedance.sdk.openadsdk.core.wq.j.cw.j(obj);
        }
        if (obj instanceof TTAdInteractionListener) {
            oq.i().gx().apply(com.bytedance.sdk.openadsdk.i.r.j().j(162).j(0, new com.bytedance.sdk.openadsdk.core.rn.la().j(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, obj)).j(Void.class).xt());
        }
    }

    public void xt(Object obj) {
        if ((h.m() || com.bytedance.sdk.openadsdk.core.rn.uf.g().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.bytedance.sdk.openadsdk.core.wq.j.cw.cw(obj);
        }
    }

    public void xt(Context context) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r kt = oq.i().kt();
        if (kt != null) {
            boolean j6 = kt.j();
            boolean cw = kt.cw();
            boolean up = kt.up();
            if (!j6 && !cw && !up) {
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        com.bytedance.sdk.component.utils.xt.j(context, intent, null);
    }

    public void xt() {
        com.bytedance.sdk.openadsdk.core.rn.h.j("open_ad_sdk_meta_cache_kv").j();
        com.bytedance.sdk.openadsdk.core.rn.h.j("tt_materialMeta").j();
        com.bytedance.sdk.openadsdk.core.rn.h.j("tt_splash").j();
    }

    private void j(ClassLoader classLoader, String str) throws Throwable {
        Method method;
        Class<?> loadClass = classLoader.loadClass("com.bytedance.sdk.openadsdk.ats.AutoService");
        if (loadClass == AutoService.class || (method = loadClass.getMethod("init", a1.a.a())) == null) {
            return;
        }
        Function a6 = a1.b.a(method.invoke(null, AutoService.init(null)));
        if (a6 != null) {
            AutoService.init(a6);
        }
        if (TextUtils.equals(str, "com.byted.csj.ext")) {
            com.bytedance.sdk.openadsdk.core.ae.cw.j(v.xt().im());
        }
    }

    public gq j(Context context) {
        return new gq(context);
    }

    public SparseArray<Object> j() {
        return this.f29430j.sparseArray();
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        String str;
        String str2;
        String str3 = null;
        if (sparseArray != null) {
            PluginValueSet k6 = com.bykv.j.j.j.j.e.i(sparseArray).k();
            int intValue = k6.intValue(-99999987);
            if (intValue == -99999986) {
                PluginValueSet pluginValueSet = this.f29430j;
                if (pluginValueSet != null) {
                    return pluginValueSet.sparseArray();
                }
            } else {
                if (intValue == -999800) {
                    return new gq((Context) k6.objectValue(-998000, Context.class));
                }
                if (intValue == 16) {
                    oq.i().m(k6.booleanValue(17, false));
                    return null;
                }
                if (intValue == 19) {
                    Bundle bundle = (Bundle) k6.objectValue(20, Bundle.class);
                    if (bundle != null) {
                        int i6 = bundle.getInt("event_id", -1);
                        int i7 = bundle.getInt("event_type", -1);
                        String string = bundle.getString(bi.f40972o);
                        try {
                            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.j.cw(bundle.getString("event_token")));
                            str = jSONObject.optString(CommonNetImpl.TAG);
                            try {
                                str2 = jSONObject.optString("value");
                                try {
                                    str3 = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
                                } catch (JSONException unused) {
                                }
                            } catch (JSONException unused2) {
                                str2 = null;
                            }
                        } catch (JSONException unused3) {
                            str = null;
                            str2 = null;
                        }
                        return com.bytedance.sdk.openadsdk.core.qv.r.az.j(i6, i7, string, str, str2, str3);
                    }
                    return new Bundle();
                }
                if (intValue == 999801) {
                    return this;
                }
                switch (intValue) {
                    case 1:
                        j(k6.intValue(11));
                        break;
                    case 2:
                        return j(com.bykv.j.j.j.j.e.j(k6).k(), k6.booleanValue(13), k6.intValue(14));
                    case 3:
                        xt((Context) k6.objectValue(7, Context.class));
                        break;
                    case 4:
                        j(k6.objectValue(8, Object.class));
                        break;
                    case 5:
                        xt(k6.objectValue(8, a1.a.a()));
                        break;
                    case 6:
                        return j((Class) k6.objectValue(9, Class.class), (Bundle) k6.objectValue(10, Bundle.class));
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    private void j(Function<SparseArray<Object>, Object> function) {
        if (function != null && com.bykv.j.j.j.j.e.i(com.bytedance.sdk.openadsdk.i.cw.j(function)).k().intValue(10000) == 1 && h.m()) {
            com.bytedance.sdk.openadsdk.core.live.xt.j().j(function);
        }
    }

    /* JADX WARN: Type inference failed for: r8v13, types: [T, java.util.HashMap, java.util.Map] */
    public <T> T j(Class<T> cls, Bundle bundle) {
        boolean z5 = false;
        int i6 = bundle != null ? bundle.getInt("type") : 0;
        if (com.bytedance.sdk.openadsdk.core.wq.j.r.j(cls, bundle)) {
            return (T) com.bytedance.sdk.openadsdk.core.wq.j.r.j(com.bytedance.sdk.openadsdk.core.multipro.m.j(v.getContext()), cls, bundle);
        }
        if (cls != SparseArray.class && (cls == null || !"com.bytedance.sdk.openadsdk.AdConfig".equals(cls.getName()))) {
            if (!com.bytedance.sdk.openadsdk.i.cw.r.xt(h.xt) && i6 == 1 && cls == ITTDownloadVisitor.class) {
                return (T) com.bytedance.sdk.openadsdk.core.qv.j.oq.create();
            }
            if (cls == Bundle.class) {
                if (bundle == null) {
                    return null;
                }
                int i7 = bundle.getInt(com.umeng.ccg.a.f41544t, 0);
                if (i7 == 0) {
                    oq.i().j(bundle.getString("plugin_pkg_name"), bundle.getString(PluginConstants.KEY_PLUGIN_VERSION));
                } else if (i7 == 1) {
                    com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(bundle.getString("event_name"), bundle.getString("event_extra"));
                } else if (i7 == 2) {
                    xt();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash", 0);
                        jSONObject.put("reward", 0);
                        jSONObject.put(bn.f10754j, 0);
                        jSONObject.put("other", 0);
                        com.bykv.vk.openvk.component.video.j.j.j(jSONObject);
                        com.bytedance.sdk.openadsdk.l.g.j(0).up();
                        com.bykv.vk.openvk.component.video.j.j.j(v.xt().et());
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.vl.cw(th.getMessage());
                    }
                } else if (i7 == 3) {
                    com.bytedance.sdk.component.oq.ae.j(-1);
                }
            } else if (cls == ExecutorService.class) {
                if (bundle != null) {
                    int i8 = bundle.getInt(com.umeng.ccg.a.f41544t, 0);
                    if (i8 == 1) {
                        return (T) com.bytedance.sdk.component.oq.qv.xt.oq();
                    }
                    if (i8 == 2) {
                        return (T) com.bytedance.sdk.component.oq.qv.xt.g();
                    }
                    if (i8 != 3) {
                        return (T) com.bytedance.sdk.component.oq.qv.xt.jy();
                    }
                    return (T) com.bytedance.sdk.component.oq.qv.xt.vl();
                }
            } else if (cls == Handler.class) {
                if (bundle != null && bundle.getInt(com.umeng.ccg.a.f41544t, 0) == 1) {
                    return (T) com.bytedance.sdk.component.utils.tl.j();
                }
            } else {
                if (cls == View.class) {
                    return (T) new EcBackUpWebView(v.getContext());
                }
                if (cls == Map.class) {
                    ?? r8 = (T) new HashMap();
                    if (bundle != null && bundle.getString("extra_name").equals("use_mediation_map")) {
                        if (AdSdkInitializerHolder.isSdkInitSuccess() && v.xt().fx() && AdSdkInitializerHolder.hasDispatchAdSdkInitializer()) {
                            z5 = true;
                        }
                        r8.put("use_mediation_map", Boolean.valueOf(z5));
                    }
                    return r8;
                }
                if (cls == a1.a.a() && bundle != null && bundle.getInt(com.umeng.ccg.a.f41544t, 0) == 4) {
                    return (T) com.bytedance.sdk.openadsdk.tools.cw.j();
                }
            }
        } else if (bundle != null && !bundle.keySet().isEmpty()) {
            if (bundle.containsKey("is_paid")) {
                oq.i().up(bundle.getBoolean("is_paid"));
            }
            if (bundle.containsKey("extra_data")) {
                oq.i().ae(bundle.getString("extra_data"));
            }
            if (bundle.containsKey("keywords")) {
                oq.i().tl(bundle.getString("keywords"));
            }
            if (bundle.containsKey("quit_work")) {
                oq.i().m(bundle.getBoolean("quit_work", false));
            }
        }
        return null;
    }

    public String j(PluginValueSet pluginValueSet, boolean z5, int i6) {
        if (pluginValueSet == null || v.j() == null) {
            return null;
        }
        return v.j().j(new com.bytedance.sdk.openadsdk.i.cw.cw.xt(pluginValueSet.sparseArray()), z5, i6);
    }

    public void j(int i6) {
        if (i6 != oq.i().q()) {
            oq.i().up(i6);
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            intent.putExtra("theme_status_change", i6);
            v.getContext().sendBroadcast(intent, com.bytedance.sdk.openadsdk.core.rn.uf.s());
        }
    }
}
