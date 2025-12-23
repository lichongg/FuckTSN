package com.bytedance.msdk.core.j.j;

import a1.a;
import a1.b;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.f;
import com.bytedance.sdk.openadsdk.l.qv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static String f24488j = "dex";

    public static Function<SparseArray<Object>, Object> cw(String str) {
        m j6 = j.j(str);
        if (j6 != null) {
            return j6.xt();
        }
        return null;
    }

    public static int j(String str, int i6) {
        if (j(str) && i6 > 0) {
            if (i6 == 1) {
                return 20012;
            }
            if (i6 == 2) {
                return 20013;
            }
            if (i6 == 3) {
                return 20014;
            }
            if (i6 == 4) {
                return 20015;
            }
        }
        return 20016;
    }

    public static Function<SparseArray<Object>, Object> xt(String str) {
        Object apply;
        Function<SparseArray<Object>, Object> r5 = r(str);
        if (r5 == null) {
            return null;
        }
        try {
            apply = r5.apply(com.bytedance.sdk.openadsdk.i.r.j().j(10000).j(a.a()).xt());
            return b.a(apply);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Integer j(String str, Function<SparseArray<Object>, Object> function) {
        Object apply;
        Object apply2;
        if (function != null) {
            if (j(str)) {
                apply2 = function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8271).j(Integer.class).xt());
                switch (apply2 instanceof Integer ? ((Integer) apply2).intValue() : -1) {
                    case IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_PACKETS /* 20009 */:
                        return 2;
                    case IjkMediaPlayer.FFP_PROP_INT64_AUDIO_CACHED_PACKETS /* 20010 */:
                        return 3;
                    case IjkMediaPlayer.FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM /* 20011 */:
                        return 4;
                    default:
                        return 1;
                }
            }
            apply = function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8121).j(20068, 1).j(Object.class).xt());
            Integer j6 = com.bytedance.sdk.openadsdk.core.wq.j.j.j(apply);
            if (j6 != null) {
                return j6;
            }
        }
        return 1;
    }

    public static int cw(com.bytedance.msdk.api.j.xt xtVar) {
        if (xtVar == null) {
            return 4;
        }
        if (com.bytedance.msdk.ae.j.j.j().ae()) {
            return xtVar.qv() == 1 ? 1 : 2;
        }
        if (com.bytedance.msdk.ae.j.j.j().tl() != 1) {
            return 3;
        }
        return xtVar.qv();
    }

    private static Function<SparseArray<Object>, Object> r(String str) {
        m j6 = j.j(str);
        if (j6 == null) {
            com.bytedance.msdk.j.up.cw.xt(f24488j, "strategy is null");
            return null;
        }
        if (!j6.j()) {
            com.bytedance.msdk.j.up.cw.xt(f24488j, "can not use dex load adn ad");
            return null;
        }
        if (!qv.ae("com.byted.mixed")) {
            com.bytedance.msdk.j.up.cw.xt(f24488j, "dex is not installed");
            return null;
        }
        if (!qv.m("com.byted.mixed")) {
            com.bytedance.msdk.j.up.cw.xt(f24488j, "dex is not loaded");
            return null;
        }
        Function<SparseArray<Object>, Object> m6 = j6.m();
        if (m6 != null) {
            return m6;
        }
        return j(j6);
    }

    private static Function<SparseArray<Object>, Object> xt(String str, int i6) {
        Object apply;
        Function<SparseArray<Object>, Object> r5 = r(str);
        if (r5 == null) {
            return null;
        }
        try {
            apply = r5.apply(com.bytedance.sdk.openadsdk.i.r.j().j(i6).j(a.a()).xt());
            return b.a(apply);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static com.bytedance.msdk.core.j.j.j.j xt(String str, int i6, int i7) {
        if (!TextUtils.equals(str, MediationConstant.ADN_GDT)) {
            return null;
        }
        switch (i6) {
            case 1:
                return new com.bytedance.msdk.core.j.j.xt.j.j.j();
            case 2:
                return new com.bytedance.msdk.core.j.j.xt.j.up.j();
            case 3:
                return new com.bytedance.msdk.core.j.j.xt.j.ae.j();
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (i7 == 4) {
                    return new com.bytedance.msdk.core.j.j.xt.j.cw.j();
                }
                if (i7 == 3) {
                    return new com.bytedance.msdk.core.j.j.xt.j.j.j();
                }
                if (i7 == 5) {
                    return new com.bytedance.msdk.core.j.j.xt.j.xt.j();
                }
                return new com.bytedance.msdk.core.j.j.xt.j.cw.j();
            case 7:
                return new com.bytedance.msdk.core.j.j.xt.j.m.j();
            case 8:
                return new com.bytedance.msdk.core.j.j.xt.j.r.j();
            case 9:
                return new com.bytedance.msdk.core.j.j.xt.j.xt.j();
            case 10:
                if (i7 == 1) {
                    return new com.bytedance.msdk.core.j.j.xt.j.up.j();
                }
                if (i7 == 2) {
                    return new com.bytedance.msdk.core.j.j.xt.j.r.j();
                }
                return null;
        }
    }

    public static boolean j(String str) {
        return (str == null || r(str) == null) ? false : true;
    }

    private static Function<SparseArray<Object>, Object> j(m mVar) {
        if (mVar == null) {
            com.bytedance.msdk.j.up.cw.xt(f24488j, "strategy is null");
            return null;
        }
        if (TextUtils.isEmpty(mVar.tl())) {
            com.bytedance.msdk.j.up.cw.xt(f24488j, "adn name is empty");
            return null;
        }
        String cw = mVar.cw();
        if (TextUtils.isEmpty(cw)) {
            com.bytedance.msdk.j.up.cw.xt(f24488j, "adn classname is empty");
            return null;
        }
        String r5 = mVar.r();
        if (TextUtils.isEmpty(r5)) {
            com.bytedance.msdk.j.up.cw.xt(f24488j, "adn versionListKey is empty");
            return null;
        }
        return j(mVar, r5, cw);
    }

    public static void xt(com.bytedance.msdk.api.j.xt xtVar) {
        if (xtVar != null) {
            xtVar.ae(3);
        }
    }

    public static int xt() {
        return com.bytedance.msdk.ae.j.j.j().tl();
    }

    private static Function<SparseArray<Object>, Object> j(m mVar, String str, String str2) {
        JSONObject optJSONObject;
        try {
            JSONObject up = qv.up("com.byted.mixed");
            if (up != null) {
                if (!up.has("adn_version") || (optJSONObject = up.optJSONObject("adn_version")) == null || !optJSONObject.has(str)) {
                    return null;
                }
                JSONArray jSONArray = optJSONObject.getJSONArray(str);
                String up2 = mVar.up();
                if (TextUtils.isEmpty(up2) || jSONArray.length() <= 0) {
                    return null;
                }
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    if (TextUtils.equals(jSONArray.getString(i6), up2)) {
                        if (!up.has(str2)) {
                            return null;
                        }
                        String optString = up.optString(str2);
                        if (TextUtils.isEmpty(optString)) {
                            return null;
                        }
                        Object newInstance = Class.forName(optString).newInstance();
                        if (!f.a(newInstance)) {
                            return null;
                        }
                        mVar.j(b.a(newInstance));
                        return mVar.m();
                    }
                }
                mVar.j(up2);
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(f24488j, "adn config json is null");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(Map<String, Object> map) {
        if (map != null) {
            j.j(map);
        }
    }

    public static Function<SparseArray<Object>, Object> j(String str, int i6, int i7) {
        try {
            if (!j.xt(str)) {
                return null;
            }
            switch (i6) {
                case 1:
                    return xt(str, IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM);
                case 2:
                    return xt(str, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_DECODER);
                case 3:
                    return xt(str, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_BYTES);
                case 4:
                case 6:
                default:
                    return null;
                case 5:
                    if (i7 == 4) {
                        return xt(str, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_DURATION);
                    }
                    if (i7 == 3) {
                        return xt(str, IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM);
                    }
                    if (i7 == 5) {
                        return xt(str, IjkMediaPlayer.FFP_PROP_INT64_SELECTED_AUDIO_STREAM);
                    }
                    return xt(str, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_DURATION);
                case 7:
                    return xt(str, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_CACHED_DURATION);
                case 8:
                    return xt(str, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_DECODER);
                case 9:
                    return xt(str, IjkMediaPlayer.FFP_PROP_INT64_SELECTED_AUDIO_STREAM);
                case 10:
                    if (i7 == 1) {
                        return xt(str, IjkMediaPlayer.FFP_PROP_INT64_AUDIO_DECODER);
                    }
                    if (i7 == 2) {
                        return xt(str, IjkMediaPlayer.FFP_PROP_INT64_VIDEO_DECODER);
                    }
                    return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String j() {
        if (com.bytedance.msdk.ae.j.j.j().ae()) {
            return "load_plugin_gdt_adapter_v2";
        }
        return "";
    }

    public static void j(com.bytedance.msdk.api.j.xt xtVar) {
        if (xtVar != null) {
            xtVar.ae(1);
        }
    }
}
