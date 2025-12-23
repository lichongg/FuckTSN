package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.col.p0003l.ea;
import com.amap.api.col.p0003l.g4;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import com.tencent.mmkv.MMKV;
import com.umeng.analytics.pro.bi;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class da extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private Context f5916a;

    /* renamed from: b, reason: collision with root package name */
    WeakReference<IAMapDelegate> f5917b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f5918d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f5919e;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f5920g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f5921h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f5922i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f5923j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f5924k;

        a(String str, String str2, boolean z5, String str3, String str4, String str5, String str6) {
            this.f5918d = str;
            this.f5919e = str2;
            this.f5920g = z5;
            this.f5921h = str3;
            this.f5922i = str4;
            this.f5923j = str5;
            this.f5924k = str6;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            if (!TextUtils.isEmpty(this.f5918d) && !TextUtils.isEmpty(this.f5919e)) {
                boolean z5 = this.f5920g;
                String str = AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                String str2 = this.f5919e;
                String str3 = this.f5918d;
                String str4 = this.f5921h;
                if (z5) {
                    ea.d dVar = new ea.d(str2, str3, str4, str);
                    dVar.g("amap_web_logo", "md5_day");
                    Context context = da.this.f5916a;
                    b3.s();
                    new ea(context, dVar).a();
                }
                WeakReference<IAMapDelegate> weakReference = da.this.f5917b;
                if (weakReference != null && weakReference.get() != null) {
                    da.this.f5917b.get().changeLogoIconStyle(str, z5, 0);
                }
            }
            if (TextUtils.isEmpty(this.f5922i) || TextUtils.isEmpty(this.f5923j)) {
                return;
            }
            boolean z6 = this.f5920g;
            String str5 = AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
            String str6 = this.f5923j;
            String str7 = this.f5922i;
            String str8 = this.f5924k;
            if (z6) {
                ea.d dVar2 = new ea.d(str6, str7, str8, str5);
                dVar2.g("amap_web_logo", "md5_night");
                Context context2 = da.this.f5916a;
                b3.s();
                new ea(context2, dVar2).a();
            }
            WeakReference<IAMapDelegate> weakReference2 = da.this.f5917b;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            da.this.f5917b.get().changeLogoIconStyle(str5, z6, 1);
        }
    }

    private Pair<JSONObject, g4.c.a> b(StringBuilder sb) {
        String str;
        JSONObject jSONObject;
        g4.c.a aVar;
        WeakReference<IAMapDelegate> weakReference;
        try {
            long longValue = r2.a(this.f5916a, "cloud_config_pull", "cloud_config_pull_timestamp", 0L).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - longValue) >= 86400000) {
                str = sb.toString();
                str.replaceAll(";;", ";");
                r2.c(this.f5916a, "cloud_config_pull", "cloud_config_pull_timestamp", new Long(currentTimeMillis));
            } else {
                str = "";
            }
            g4.c c6 = g4.c(this.f5916a, b3.s(), str, null);
            if (g4.f6287a != 1 && str != "" && c6 != null && (weakReference = this.f5917b) != null && weakReference.get() != null) {
                Message obtainMessage = this.f5917b.get().getMainHandler().obtainMessage();
                obtainMessage.what = 2;
                String str2 = c6.f6319c;
                if (str2 != null) {
                    obtainMessage.obj = str2;
                }
                this.f5917b.get().getMainHandler().sendMessage(obtainMessage);
            }
            String str3 = GLFileUtil.getCacheDir(this.f5916a).getAbsolutePath() + "/authCustomConfigName";
            if (TextUtils.isEmpty(str) || c6 == null || (jSONObject = c6.f6322f) == null) {
                jSONObject = new JSONObject(new String(GLFileUtil.readFileContents(str3)));
            } else {
                GLFileUtil.writeDatasToFile(str3, jSONObject.toString().getBytes());
            }
            String str4 = GLFileUtil.getCacheDir(this.f5916a).getAbsolutePath() + "/authLogConfigName";
            if (TextUtils.isEmpty(str) || c6 == null || c6.f6323g == null) {
                byte[] readFileContents = GLFileUtil.readFileContents(str4);
                g4.c.a aVar2 = new g4.c.a();
                JSONObject jSONObject2 = new JSONObject(new String(readFileContents));
                aVar2.f6326a = jSONObject2.getBoolean("IsExceptionUpdate");
                if (jSONObject2.has("mOfflineLoc")) {
                    aVar2.f6328c = jSONObject2.getJSONObject("mOfflineLoc");
                }
                aVar = aVar2;
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("IsExceptionUpdate", c6.f6323g.f6326a);
                jSONObject3.put("mOfflineLoc", c6.f6323g.f6328c);
                GLFileUtil.writeDatasToFile(str4, jSONObject3.toString().getBytes());
                aVar = c6.f6323g;
            }
            return new Pair<>(jSONObject, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void c(Context context, p4 p4Var, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16V");
            boolean x5 = g4.x(optJSONObject.optString("di", ""), false);
            String optString = optJSONObject.optString("dis", "");
            boolean x6 = g4.x(optJSONObject.optString("able", ""), false);
            boolean x7 = g4.x(optJSONObject.optString("isFilter", ""), true);
            if (!x5 || q4.B(optString)) {
                x5.a(p4Var).b(context, x6, x7);
            }
        } catch (Throwable unused) {
        }
    }

    private void d(g4.c.a aVar) {
        if (aVar != null) {
            try {
                x2.a(this.f5916a, "maploc", "ue", Boolean.valueOf(aVar.f6326a));
                JSONObject jSONObject = aVar.f6328c;
                int optInt = jSONObject.optInt("fn", 1000);
                int optInt2 = jSONObject.optInt("mpn", 0);
                if (optInt2 > 500) {
                    optInt2 = 500;
                }
                if (optInt2 < 30) {
                    optInt2 = 30;
                }
                g7.b(optInt, g4.x(jSONObject.optString("igu"), false));
                x2.a(this.f5916a, "maploc", "opn", Integer.valueOf(optInt2));
            } catch (Throwable th) {
                v5.p(th, "AuthUtil", "loadConfigDataUploadException");
            }
        }
    }

    private static void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            d3.j(jSONObject.optJSONObject("17E"));
        } catch (Throwable unused) {
        }
    }

    private void f(JSONObject jSONObject) {
        IAMapDelegate iAMapDelegate;
        IAMapDelegate iAMapDelegate2;
        IAMapDelegate iAMapDelegate3;
        if (jSONObject == null) {
            return;
        }
        try {
            ha.a().b(jSONObject.optJSONObject("1A1"));
            if (!ha.a().c("feature_terrain") && (iAMapDelegate3 = this.f5917b.get()) != null) {
                iAMapDelegate3.setTerrainAuth(false);
                b3.D(new AMapException(AMapException.FEATURE_TERRAIN_NOT_SUPPORT));
            }
            if (!ha.a().c("feature_gltf") && (iAMapDelegate2 = this.f5917b.get()) != null) {
                IGlOverlayLayer glOverlayLayer = iAMapDelegate2.getGlOverlayLayer();
                if (glOverlayLayer != null) {
                    glOverlayLayer.clearOverlayByType("GLTFOVERLAY");
                }
                b3.D(new AMapException(AMapException.FEATURE_GLTF_NOT_SUPPORT));
            }
            if (ha.a().c("feature_mvt") || (iAMapDelegate = this.f5917b.get()) == null) {
                return;
            }
            IGlOverlayLayer glOverlayLayer2 = iAMapDelegate.getGlOverlayLayer();
            if (glOverlayLayer2 != null) {
                glOverlayLayer2.clearOverlayByType("MVTTILEOVERLAY");
            }
            b3.D(new AMapException(AMapException.FEATURE_MVT_NOT_SUPPORT));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private static void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16G");
            boolean x5 = g4.x(optJSONObject.optString("able", ""), false);
            boolean x6 = g4.x(optJSONObject.optString("removeCache", ""), false);
            boolean x7 = g4.x(optJSONObject.optString("uploadInfo", ""), false);
            s2.a(x5);
            s2.d(x6);
            s2.f(x7);
        } catch (Throwable unused) {
        }
    }

    private void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            r2.c(this.f5916a, "amap_param", "overlay_use_old_type", Boolean.valueOf(!g4.x(jSONObject.optJSONObject("17W").optString("able", ""), false)));
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        JSONObject optJSONObject;
        WeakReference<IAMapDelegate> weakReference;
        WeakReference<IAMapDelegate> weakReference2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        JSONObject optJSONObject2;
        Object obj6;
        JSONObject optJSONObject3;
        Object obj7;
        p4 s5;
        Object obj8;
        JSONObject optJSONObject4;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                k4.a().c(this.f5916a);
                StringBuilder sb = new StringBuilder();
                sb.append("14S");
                sb.append(";");
                sb.append("11K");
                sb.append(";");
                sb.append("001");
                sb.append(";");
                sb.append("14M");
                sb.append(";");
                sb.append("14L");
                sb.append(";");
                sb.append("16V");
                sb.append(";");
                sb.append("14Z");
                sb.append(";");
                sb.append("154");
                sb.append(";");
                sb.append("156");
                sb.append(";");
                sb.append("15C");
                sb.append(";");
                sb.append("16G");
                sb.append(";");
                sb.append("17W");
                sb.append(";");
                sb.append("17E");
                sb.append(";");
                sb.append("1A1");
                try {
                    WeakReference<IAMapDelegate> weakReference3 = this.f5917b;
                    if (weakReference3 != null && weakReference3.get() != null) {
                        IAMapDelegate iAMapDelegate = this.f5917b.get();
                        if (iAMapDelegate.getAMapExtraInterfaceManager() != null) {
                            String g6 = iAMapDelegate.getAMapExtraInterfaceManager().g();
                            if (!TextUtils.isEmpty(g6)) {
                                if (g6.indexOf(";") == 0) {
                                    sb.append(g6);
                                } else {
                                    sb.append(";");
                                    sb.append(g6);
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
                Pair<JSONObject, g4.c.a> b6 = b(sb);
                if (b6 != null && (obj8 = b6.first) != null && (optJSONObject4 = ((JSONObject) obj8).optJSONObject("154")) != null && g4.x(optJSONObject4.getString("able"), true)) {
                    String optString = optJSONObject4.optString(bi.A);
                    String optString2 = optJSONObject4.optString("si");
                    String optString3 = optJSONObject4.optString("te");
                    if (!TextUtils.isEmpty(optString)) {
                        r2.c(this.f5916a, "approval_number", bi.A, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        r2.c(this.f5916a, "approval_number", "si", optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        r2.c(this.f5916a, "approval_number", "te", optString3);
                    }
                }
                if (b6 != null && b6.second != null && (s5 = b3.s()) != null) {
                    s5.c(((g4.c.a) b6.second).f6326a);
                }
                if (b6 != null) {
                    d((g4.c.a) b6.second);
                }
                if (b6 != null) {
                    try {
                        Object obj9 = b6.first;
                        if (obj9 != null && (optJSONObject = ((JSONObject) obj9).optJSONObject("14M")) != null && optJSONObject.has("able") && g4.x(optJSONObject.getString("able"), true)) {
                            if (System.currentTimeMillis() - r2.a(this.f5916a, "Map3DCache", "time", 0L).longValue() > (optJSONObject.has("time") ? Math.max(60, optJSONObject.getInt("time")) : MMKV.ExpireInMonth) * 1000 && (weakReference = this.f5917b) != null && weakReference.get() != null) {
                                this.f5917b.get().clearTileCache();
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (b6 != null && (obj7 = b6.first) != null) {
                    try {
                        JSONObject optJSONObject5 = ((JSONObject) obj7).optJSONObject("14L");
                        if (optJSONObject5 != null && optJSONObject5.has("able")) {
                            boolean x5 = g4.x(optJSONObject5.getString("able"), false);
                            WeakReference<IAMapDelegate> weakReference4 = this.f5917b;
                            if (weakReference4 != null && weakReference4.get() != null) {
                                this.f5917b.get().setHideLogoEnble(!x5);
                            }
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (b6 != null && (obj6 = b6.first) != null && (optJSONObject3 = ((JSONObject) obj6).optJSONObject("156")) != null) {
                    p2.e(g4.x(optJSONObject3.optString("able"), false));
                }
                if (b6 != null && b6.first != null) {
                    c(this.f5916a, b3.s(), (JSONObject) b6.first);
                }
                if (b6 != null && (obj5 = b6.first) != null && (optJSONObject2 = ((JSONObject) obj5).optJSONObject("15C")) != null) {
                    boolean x6 = g4.x(optJSONObject2.optString("able"), false);
                    z2.a().b(new a(optJSONObject2.optString("logo_day_md5"), optJSONObject2.optString("logo_day_url"), x6, optJSONObject2.optString("logo_day_ipv6_url"), optJSONObject2.optString("logo_night_md5"), optJSONObject2.optString("logo_night_url"), optJSONObject2.optString("logo_night_ipv6_url")));
                }
                if (b6 != null) {
                    try {
                        if (b6.first != null && (weakReference2 = this.f5917b) != null && weakReference2.get() != null) {
                            IAMapDelegate iAMapDelegate2 = this.f5917b.get();
                            if (iAMapDelegate2.getAMapExtraInterfaceManager() != null) {
                                iAMapDelegate2.getAMapExtraInterfaceManager().h();
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (b6 != null && (obj4 = b6.first) != null) {
                    g((JSONObject) obj4);
                }
                if (b6 != null && (obj3 = b6.first) != null) {
                    h((JSONObject) obj3);
                }
                if (b6 != null && (obj2 = b6.first) != null) {
                    e((JSONObject) obj2);
                }
                if (b6 != null && (obj = b6.first) != null) {
                    f((JSONObject) obj);
                }
                v5.g(this.f5916a, b3.s());
                interrupt();
                WeakReference<IAMapDelegate> weakReference5 = this.f5917b;
                if (weakReference5 == null || weakReference5.get() == null) {
                    return;
                }
                this.f5917b.get().setRunLowFrame(false);
            }
        } catch (Throwable th3) {
            interrupt();
            v5.p(th3, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th3.printStackTrace();
            d3.l(c3.f5805e, "auth exception " + th3.getMessage());
        }
    }

    public da(Context context, IAMapDelegate iAMapDelegate) {
        this.f5917b = null;
        this.f5916a = context;
        this.f5917b = new WeakReference<>(iAMapDelegate);
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        super.interrupt();
    }
}
