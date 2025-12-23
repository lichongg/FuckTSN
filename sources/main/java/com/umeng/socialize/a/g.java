package com.umeng.socialize.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
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
final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final int f42224a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final int f42225b = 2;

    /* renamed from: c, reason: collision with root package name */
    private static final String f42226c = "AZX";

    g() {
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        if (UMShareAPI.getSmartEnableFlag()) {
            e a6 = e.a(ContextUtil.getContext());
            a6.e();
            int c6 = a6.c();
            long d6 = a6.d();
            if (d6 < c6) {
                if (a.f42199c) {
                    m.a(f42226c, "launch times skipped. times:", Long.valueOf(d6), " config:", Integer.valueOf(c6));
                    return;
                }
                return;
            }
            if (!a6.b()) {
                if (a.f42199c) {
                    m.a(f42226c, "interval skipped.");
                    return;
                }
                return;
            }
            try {
                final Context context = ContextUtil.getContext();
                final String appkey = UMUtils.getAppkey(context);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(bi.al, UMUtils.getZid(context));
                try {
                    jSONObject2.put("imei", DeviceConfig.getImeiNew(context));
                    jSONObject2.put("oaid", DeviceConfig.getOaid(context));
                } catch (Throwable unused) {
                }
                try {
                    jSONObject2.put("idfa", DeviceConfig.getIdfa(context));
                } catch (Throwable unused2) {
                }
                jSONObject2.put("umid", UMUtils.getUMId(context));
                jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context));
                jSONObject2.put("sdk_v", "7.3.2");
                jSONObject2.put("os_v", Build.VERSION.RELEASE);
                jSONObject2.put("lvl", Build.VERSION.SDK_INT);
                String[] networkAccessMode = UMUtils.getNetworkAccessMode(context);
                if (TextUtils.isEmpty(networkAccessMode[0])) {
                    networkAccessMode[0] = "Unknown";
                }
                jSONObject2.put(TKDownloadReason.KSAD_TK_NET, networkAccessMode[0]);
                jSONObject2.put(bn.f10754j, c.a());
                long a7 = a6.a();
                if (a7 > 0) {
                    jSONObject2.put("last", a7);
                }
                try {
                    jSONObject = d.a(jSONObject2, a.f42197a, appkey, a.f42199c);
                } catch (Exception e6) {
                    if (a.f42199c) {
                        m.d(f42226c, "request failed. ", e6.getMessage());
                    }
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    if (a.f42199c) {
                        m.a(f42226c, "response == null");
                    }
                    a6.a(7200L);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    if (a.f42199c) {
                        m.a(f42226c, "data empty skipped.");
                    }
                    a6.a(7200L);
                    return;
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                int optInt = optJSONObject2.optInt("launch", 5);
                a6.a(optInt);
                if (a6.d() < optInt) {
                    if (a.f42199c) {
                        m.a(f42226c, "launch times skipped. config:", Integer.valueOf(optInt));
                        return;
                    }
                    return;
                }
                a6.a(optJSONObject.optLong(RtspHeaders.Values.TTL, 86400L));
                final long optLong = optJSONObject.optLong("id", -1L);
                if (optLong <= 0) {
                    if (a.f42199c) {
                        m.a(f42226c, "id skipped, id:", Long.valueOf(optLong));
                        return;
                    }
                    return;
                }
                final int max = Math.max(optJSONObject2.optInt(com.umeng.ccg.a.f41543s, 300), 100);
                final int optInt2 = optJSONObject2.optInt(com.umeng.ccg.a.f41544t, 1);
                int optInt3 = optJSONObject2.optInt("delay");
                if (optInt2 != 1 && optInt2 != 2) {
                    if (a.f42199c) {
                        m.a(f42226c, "action skipped. ", Integer.valueOf(optInt2));
                        return;
                    }
                    return;
                }
                j.a(new Runnable() { // from class: com.umeng.socialize.a.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ByteArrayOutputStream byteArrayOutputStream;
                        String str;
                        ByteArrayOutputStream byteArrayOutputStream2 = null;
                        try {
                            TreeSet treeSet = new TreeSet();
                            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = {18, -119, Ascii.US, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, SignedBytes.MAX_POWER_OF_TWO, 48, -101, -83, -59, -99, BinaryMemcacheOpcodes.GATKQ, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, -47, -59, -86, 14, -12, -100, -12, 53, 85, 37, -75, -30, Ascii.US, HttpConstants.COMMA, -83, 99, -108, -92, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, BinaryMemcacheOpcodes.GATK, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, BinaryMemcacheOpcodes.GATK, -68, HttpConstants.COLON, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, Ascii.ESC, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, 13, 3, 21, 21, 12, 40, 14, 29};
                                byte[] copyOfRange = Arrays.copyOfRange(bArr, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 187);
                                byte[] copyOf = Arrays.copyOf(bArr, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT);
                                i.a(copyOf, copyOfRange);
                                l.b(copyOf, byteArrayOutputStream3);
                                JSONObject jSONObject3 = new JSONObject(byteArrayOutputStream3.toString());
                                if (a.f42199c) {
                                    try {
                                        m.a(g.f42226c, jSONObject3.toString());
                                    } catch (Throwable th) {
                                        th = th;
                                        byteArrayOutputStream2 = byteArrayOutputStream3;
                                        try {
                                            m.d(g.f42226c, th.getMessage());
                                            return;
                                        } finally {
                                            c.a(byteArrayOutputStream2);
                                        }
                                    }
                                }
                                Object a8 = k.a(jSONObject3.optString("c"), jSONObject3.optString("p"), null, context, null);
                                int i6 = optInt2;
                                Class cls = Integer.TYPE;
                                String str2 = "a";
                                byteArrayOutputStream = byteArrayOutputStream3;
                                try {
                                    if (1 == i6) {
                                        str = "p";
                                        Object a9 = k.a(jSONObject3.optString(t.f36152m), jSONObject3.optString("q"), new Class[]{k.a(jSONObject3.optString("i")), cls}, a8, new Object[]{k.a(jSONObject3.optString("i"), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject3.optString("a")}), 0});
                                        if (a9 instanceof List) {
                                            Field a10 = k.a(jSONObject3.optString(t.f36150k), jSONObject3.optString("s"));
                                            Field a11 = k.a(jSONObject3.optString(bi.aL), jSONObject3.optString("n"));
                                            Iterator it = ((List) a9).iterator();
                                            while (it.hasNext()) {
                                                Object a12 = k.a(a11, k.a(a10, it.next()));
                                                if (a12 != null) {
                                                    treeSet.add((String) a12);
                                                }
                                            }
                                            if (a.f42199c) {
                                                m.a(g.f42226c, "size:" + treeSet.size());
                                            }
                                        }
                                    } else {
                                        str = "p";
                                        try {
                                            Object a13 = k.a(jSONObject3.optString(t.f36152m), jSONObject3.optString("u"), new Class[]{cls}, a8, new Object[]{0});
                                            if (a13 instanceof List) {
                                                Field a14 = k.a(jSONObject3.optString("v"), jSONObject3.optString("n"));
                                                Iterator it2 = ((List) a13).iterator();
                                                while (it2.hasNext()) {
                                                    Object a15 = k.a(a14, it2.next());
                                                    if (a15 != null) {
                                                        treeSet.add((String) a15);
                                                    }
                                                }
                                                if (a.f42199c) {
                                                    m.a(g.f42226c, "size:" + treeSet.size());
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            byteArrayOutputStream2 = byteArrayOutputStream;
                                            m.d(g.f42226c, th.getMessage());
                                            return;
                                        }
                                    }
                                    if (treeSet.isEmpty()) {
                                        if (a.f42199c) {
                                            m.a(g.f42226c, "app list empty!");
                                        }
                                        c.a(byteArrayOutputStream);
                                        return;
                                    }
                                    if (a8 == null) {
                                        c.a(byteArrayOutputStream);
                                        return;
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator it3 = treeSet.iterator();
                                    int i7 = 0;
                                    while (it3.hasNext()) {
                                        Object a16 = c.a(a8, (String) it3.next(), 0);
                                        if (a16 != null) {
                                            f fVar = new f(a8, a16);
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put(str2, fVar.f42219b);
                                            String str3 = str;
                                            jSONObject4.put(str3, fVar.f42218a);
                                            jSONObject4.put("v", fVar.f42220c);
                                            jSONObject4.put(bi.aL, fVar.f42223f);
                                            String str4 = str2;
                                            jSONObject4.put("i", fVar.f42221d);
                                            jSONObject4.put("u", fVar.f42222e);
                                            jSONArray.put(jSONObject4);
                                            i7++;
                                            try {
                                                if (jSONArray.length() == max) {
                                                    arrayList.add(jSONArray);
                                                    jSONArray = new JSONArray();
                                                }
                                                str = str3;
                                                str2 = str4;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                byteArrayOutputStream2 = byteArrayOutputStream;
                                                m.d(g.f42226c, th.getMessage());
                                                return;
                                            }
                                        }
                                    }
                                    if (jSONArray.length() > 0) {
                                        arrayList.add(jSONArray);
                                    }
                                    if (a.f42199c) {
                                        m.a(g.f42226c, "total:", Integer.valueOf(i7));
                                        Iterator it4 = arrayList.iterator();
                                        while (it4.hasNext()) {
                                            JSONArray jSONArray2 = (JSONArray) it4.next();
                                            m.c(g.f42226c, "--- start ---");
                                            m.b(g.f42226c, "--- size:", Integer.valueOf(jSONArray2.length()));
                                            m.b(g.f42226c, jSONArray2);
                                            m.c(g.f42226c, "--- end ---");
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        c.a(byteArrayOutputStream);
                                        return;
                                    }
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put(bi.al, UMUtils.getZid(context));
                                    jSONObject5.put("appkey", appkey);
                                    jSONObject5.put("umid", UMUtils.getUMId(context));
                                    jSONObject5.put("v", "2.0");
                                    jSONObject5.put("sdk_v", "7.3.2");
                                    jSONObject5.put("os_v", Build.VERSION.RELEASE);
                                    jSONObject5.put(bn.f10754j, c.a());
                                    jSONObject5.put(bn.f10753i, c.b());
                                    jSONObject5.put("smart_id", optLong);
                                    jSONObject5.put("src", "share");
                                    jSONObject5.put("imei", DeviceConfig.getImeiNew(context));
                                    try {
                                        jSONObject5.put("oaid", DeviceConfig.getOaid(context));
                                    } catch (Throwable unused3) {
                                    }
                                    try {
                                        jSONObject5.put("idfa", DeviceConfig.getIdfa(context));
                                    } catch (Throwable unused4) {
                                    }
                                    jSONObject5.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context));
                                    jSONObject5.put("pkg", context.getPackageName());
                                    jSONObject5.put("app_v", UMUtils.getAppVersionName(context));
                                    jSONObject5.put("board", c.c());
                                    try {
                                        Locale locale = UMUtils.getLocale(context);
                                        if (locale != null) {
                                            jSONObject5.put("os_lang", locale.getLanguage());
                                        }
                                    } catch (Throwable unused5) {
                                    }
                                    jSONObject5.put("c_ts", System.currentTimeMillis());
                                    jSONObject5.put("total", i7);
                                    try {
                                        jSONObject5.put("os_i", Build.VERSION.SDK_INT);
                                        jSONObject5.put("os_t", context.getApplicationInfo().targetSdkVersion);
                                        jSONObject5.put("grant", c.b(context) ? 1 : 0);
                                    } catch (Throwable unused6) {
                                    }
                                    Iterator it5 = arrayList.iterator();
                                    int i8 = 0;
                                    while (it5.hasNext()) {
                                        JSONArray jSONArray3 = (JSONArray) it5.next();
                                        i8++;
                                        jSONObject5.put(com.umeng.ccg.a.f41543s, i8);
                                        jSONObject5.put("data", jSONArray3);
                                        try {
                                            d.a(jSONObject5, a.f42198b, appkey);
                                        } catch (Exception e7) {
                                            if (a.f42199c) {
                                                m.d(g.f42226c, "upload error:", e7.getMessage());
                                            }
                                            throw e7;
                                        }
                                    }
                                    c.a(byteArrayOutputStream);
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                byteArrayOutputStream = byteArrayOutputStream3;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                }, optInt3, TimeUnit.SECONDS);
            } catch (Throwable th) {
                if (a.f42199c) {
                    m.d(f42226c, th.getMessage());
                }
            }
        }
    }
}
