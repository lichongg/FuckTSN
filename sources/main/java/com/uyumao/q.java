package com.uyumao;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.uyumao.o;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class q implements Runnable {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f42617a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f42618b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f42619c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f42620d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f42621e;

        public a(q qVar, Context context, int i6, int i7, String str, long j6) {
            this.f42617a = context;
            this.f42618b = i6;
            this.f42619c = i7;
            this.f42620d = str;
            this.f42621e = j6;
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteArrayOutputStream byteArrayOutputStream;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                TreeSet treeSet = new TreeSet();
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = {18, -119, Ascii.US, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, SignedBytes.MAX_POWER_OF_TWO, 48, -101, -83, -59, -99, BinaryMemcacheOpcodes.GATKQ, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, -47, -59, -86, 14, -12, -100, -12, 53, 85, 37, -75, -30, Ascii.US, HttpConstants.COMMA, -83, 99, -108, -92, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, BinaryMemcacheOpcodes.GATK, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, BinaryMemcacheOpcodes.GATK, -68, HttpConstants.COLON, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, Ascii.ESC, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, 13, 3, 21, 21, 12, 40, 14, 29};
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 187);
                    byte[] copyOf = Arrays.copyOf(bArr, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT);
                    e.a(copyOf, copyOfRange);
                    e.a(copyOf, byteArrayOutputStream3);
                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream3.toString());
                    Object a6 = t.a(jSONObject.optString("c"), jSONObject.optString("p"), null, this.f42617a, null);
                    int i6 = this.f42618b;
                    String str = bi.aL;
                    Class cls = Integer.TYPE;
                    try {
                        if (1 == i6) {
                            byteArrayOutputStream = byteArrayOutputStream3;
                            Object a7 = t.a(jSONObject.optString(com.kuaishou.weapon.p0.t.f36152m), jSONObject.optString("q"), new Class[]{t.a(jSONObject.optString("i")), cls}, a6, new Object[]{t.a(jSONObject.optString("i"), new Class[]{String.class}, new Object[]{jSONObject.optString("a")}), 0});
                            if (a7 instanceof List) {
                                Field a8 = t.a(jSONObject.optString(com.kuaishou.weapon.p0.t.f36150k), jSONObject.optString("s"));
                                Field a9 = t.a(jSONObject.optString(bi.aL), jSONObject.optString("n"));
                                Iterator it = ((List) a7).iterator();
                                while (it.hasNext()) {
                                    Object a10 = t.a(a9, t.a(a8, it.next()));
                                    if (a10 != null) {
                                        treeSet.add((String) a10);
                                    }
                                }
                            }
                        } else {
                            byteArrayOutputStream = byteArrayOutputStream3;
                            Object a11 = t.a(jSONObject.optString(com.kuaishou.weapon.p0.t.f36152m), jSONObject.optString("u"), new Class[]{cls}, a6, new Object[]{0});
                            if (a11 instanceof List) {
                                Field a12 = t.a(jSONObject.optString("v"), jSONObject.optString("n"));
                                Iterator it2 = ((List) a11).iterator();
                                while (it2.hasNext()) {
                                    Object a13 = t.a(a12, it2.next());
                                    if (a13 != null) {
                                        treeSet.add((String) a13);
                                    }
                                }
                            }
                        }
                        if (treeSet.isEmpty()) {
                            n.a(byteArrayOutputStream);
                            return;
                        }
                        if (a6 == null) {
                            n.a(byteArrayOutputStream);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = new JSONArray();
                        Iterator it3 = treeSet.iterator();
                        int i7 = 0;
                        while (it3.hasNext()) {
                            Object a14 = n.a(a6, (String) it3.next(), 0);
                            if (a14 != null) {
                                p pVar = new p(a6, a14);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("a", pVar.f42612b);
                                jSONObject2.put("p", pVar.f42611a);
                                jSONObject2.put("v", pVar.f42613c);
                                jSONObject2.put(str, pVar.f42616f);
                                String str2 = str;
                                jSONObject2.put("i", pVar.f42614d);
                                jSONObject2.put("u", pVar.f42615e);
                                jSONArray.put(jSONObject2);
                                i7++;
                                if (jSONArray.length() == this.f42619c) {
                                    arrayList.add(jSONArray);
                                    jSONArray = new JSONArray();
                                }
                                str = str2;
                            }
                        }
                        if (jSONArray.length() > 0) {
                            arrayList.add(jSONArray);
                        }
                        if (arrayList.isEmpty()) {
                            n.a(byteArrayOutputStream);
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(bi.al, UMUtils.getZid(this.f42617a));
                        jSONObject3.put("appkey", this.f42620d);
                        jSONObject3.put("umid", UMUtils.getUMId(this.f42617a));
                        jSONObject3.put("v", "2.0");
                        jSONObject3.put("sdk_v", "1.1.2");
                        jSONObject3.put("os_v", Build.VERSION.RELEASE);
                        jSONObject3.put(bn.f10754j, n.b());
                        jSONObject3.put(bn.f10753i, n.c());
                        jSONObject3.put("smart_id", this.f42621e);
                        jSONObject3.put("src", "risk");
                        jSONObject3.put("imei", DeviceConfig.getImeiNew(this.f42617a));
                        try {
                            jSONObject3.put("oaid", DeviceConfig.getOaid(this.f42617a));
                        } catch (Throwable unused) {
                        }
                        try {
                            jSONObject3.put("idfa", DeviceConfig.getIdfa(this.f42617a));
                        } catch (Throwable unused2) {
                        }
                        jSONObject3.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(this.f42617a));
                        jSONObject3.put("pkg", this.f42617a.getPackageName());
                        jSONObject3.put("app_v", UMUtils.getAppVersionName(this.f42617a));
                        jSONObject3.put("board", n.a());
                        try {
                            Locale locale = UMUtils.getLocale(this.f42617a);
                            if (locale != null) {
                                jSONObject3.put("os_lang", locale.getLanguage());
                            }
                        } catch (Throwable unused3) {
                        }
                        jSONObject3.put("c_ts", System.currentTimeMillis());
                        jSONObject3.put("total", i7);
                        try {
                            jSONObject3.put("os_i", Build.VERSION.SDK_INT);
                            jSONObject3.put("os_t", this.f42617a.getApplicationInfo().targetSdkVersion);
                            jSONObject3.put("grant", n.a(this.f42617a) ? 1 : 0);
                        } catch (Throwable unused4) {
                        }
                        Iterator it4 = arrayList.iterator();
                        int i8 = 0;
                        while (it4.hasNext()) {
                            JSONArray jSONArray2 = (JSONArray) it4.next();
                            int i9 = i8 + 1;
                            jSONObject3.put(com.umeng.ccg.a.f41543s, i9);
                            jSONObject3.put("data", jSONArray2);
                            try {
                                e.a(jSONObject3, com.umeng.socialize.a.a.f42198b, this.f42620d);
                                i8 = i9;
                            } catch (Exception e6) {
                                throw e6;
                            }
                        }
                        n.a(byteArrayOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            th.getMessage();
                        } finally {
                            n.a(byteArrayOutputStream2);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream3;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i6;
        JSONObject jSONObject;
        Context context = e.f42582a;
        if (o.f42607a == null) {
            synchronized (o.class) {
                try {
                    if (o.f42607a == null) {
                        o.f42607a = new o(context);
                    }
                } finally {
                }
            }
        }
        o oVar = o.f42607a;
        if (n.c(oVar.f42608b)) {
            oVar.f42609c.b(com.umeng.socialize.a.a.f42200d, oVar.a() + 1);
        }
        String str = oVar.f42609c.f42610a + com.umeng.socialize.a.a.f42202f;
        String valueOf = String.valueOf(0);
        try {
            if (n.c(e.f42582a)) {
                valueOf = m.a().f42602b.getString(str, valueOf);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            i6 = Integer.parseInt(valueOf);
        } catch (Exception unused) {
            i6 = 0;
        }
        if (oVar.a() >= i6 && oVar.a(com.umeng.socialize.a.a.f42201e)) {
            try {
                Context context2 = e.f42582a;
                String appkey = UMUtils.getAppkey(context2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(bi.al, UMUtils.getZid(context2));
                try {
                    jSONObject2.put("imei", DeviceConfig.getImeiNew(context2));
                    jSONObject2.put("oaid", DeviceConfig.getOaid(context2));
                } catch (Throwable unused2) {
                }
                try {
                    jSONObject2.put("idfa", DeviceConfig.getIdfa(context2));
                } catch (Throwable unused3) {
                }
                jSONObject2.put("umid", UMUtils.getUMId(context2));
                jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context2));
                jSONObject2.put("sdk_v", "1.1.2");
                jSONObject2.put("os_v", Build.VERSION.RELEASE);
                jSONObject2.put("lvl", Build.VERSION.SDK_INT);
                String[] networkAccessMode = UMUtils.getNetworkAccessMode(context2);
                if (TextUtils.isEmpty(networkAccessMode[0])) {
                    networkAccessMode[0] = "Unknown";
                }
                jSONObject2.put(TKDownloadReason.KSAD_TK_NET, networkAccessMode[0]);
                jSONObject2.put(bn.f10754j, n.b());
                long a6 = oVar.f42609c.a("smart_ts", 0L);
                if (a6 > 0) {
                    jSONObject2.put("last", a6);
                }
                try {
                    jSONObject = e.a(jSONObject2, "https://ccs.umeng.com/ra", appkey, false);
                } catch (Exception unused4) {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    oVar.a(7200L);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    oVar.a(7200L);
                    return;
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                int optInt = optJSONObject2.optInt("launch", 5);
                o.a aVar = oVar.f42609c;
                aVar.a(aVar.f42610a + com.umeng.socialize.a.a.f42202f, String.valueOf(optInt));
                if (oVar.a() < optInt) {
                    return;
                }
                oVar.a(optJSONObject.optLong(RtspHeaders.Values.TTL, 86400L));
                long optLong = optJSONObject.optLong("id", -1L);
                if (optLong <= 0) {
                    return;
                }
                int max = Math.max(optJSONObject2.optInt(com.umeng.ccg.a.f41543s, 300), 100);
                int optInt2 = optJSONObject2.optInt(com.umeng.ccg.a.f41544t, 1);
                int optInt3 = optJSONObject2.optInt("delay");
                if (optInt2 == 1 || optInt2 == 2) {
                    s.a(new a(this, context2, optInt2, max, appkey, optLong), optInt3, TimeUnit.SECONDS);
                }
            } catch (Throwable unused5) {
            }
        }
    }
}
