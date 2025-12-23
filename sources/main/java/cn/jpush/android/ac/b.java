package cn.jpush.android.ac;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.f;
import cn.jpush.android.ad.l;
import cn.jpush.android.ad.m;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.Iterator;
import java.util.LinkedList;
import okio.Utf8;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3367a = "I7MUZXCPZWRFZAJS";

    /* renamed from: b, reason: collision with root package name */
    private static final String f3368b = "CBDHJXMDDVXH8THW";

    /* renamed from: c, reason: collision with root package name */
    private static final String f3369c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f3370d;

    /* renamed from: e, reason: collision with root package name */
    private static LinkedList<String> f3371e;

    private static class a extends f {

        /* renamed from: a, reason: collision with root package name */
        private Context f3372a;

        /* renamed from: b, reason: collision with root package name */
        private String f3373b;

        /* renamed from: c, reason: collision with root package name */
        private cn.jpush.android.ac.a f3374c;

        @Override // cn.jpush.android.ad.f
        public void a() {
            String str;
            String str2;
            try {
                if (System.currentTimeMillis() - cn.jpush.android.cache.a.t(this.f3372a) < 86400000) {
                    Logger.d("JPConfig", "it not sdk config request business time");
                    return;
                }
                byte e6 = e.a().e(this.f3372a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dev_key", this.f3373b);
                jSONObject.put("p_name", this.f3372a.getPackageName());
                jSONObject.put(JThirdPlatFormInterface.KEY_ROM_TYPE, (int) e6);
                String upperCase = cn.jpush.android.ad.a.d(this.f3373b + cn.jpush.android.ad.a.d(jSONObject.toString()).toUpperCase()).toUpperCase();
                if (TextUtils.isEmpty(upperCase)) {
                    str2 = "authToken is null";
                } else {
                    String encodeToString = Base64.encodeToString((this.f3373b + ":" + upperCase).getBytes(), 10);
                    if (!TextUtils.isEmpty(encodeToString)) {
                        String a6 = l.a(jSONObject.toString().getBytes(), b.f3367a, b.f3368b);
                        b();
                        m.a(this.f3372a, b.f3371e);
                        Iterator it = b.f3371e.iterator();
                        while (it.hasNext()) {
                            String str3 = (String) it.next();
                            cn.jpush.android.w.c cVar = new cn.jpush.android.w.c(str3);
                            cVar.a("init_config");
                            cVar.a("Content-Type", "application/json");
                            cVar.a("Accept", "application/json");
                            cVar.a("X-Http-Platform", FaceEnvironment.OS);
                            cVar.a("Authorization", "Basic " + encodeToString);
                            cVar.a("Charset", "UTF-8");
                            cVar.a((Object) a6);
                            Logger.d("JPConfig", "url: " + str3 + ", request param: " + jSONObject.toString());
                            cn.jpush.android.w.d a7 = cn.jpush.android.w.e.a(this.f3372a, cVar);
                            int b6 = a7.b();
                            Logger.d("JPConfig", "responseCode:" + b6);
                            if (200 == b6) {
                                String a8 = a7.a();
                                Logger.d("JPConfig", "responseBody:" + a8);
                                if (TextUtils.isEmpty(a8)) {
                                    continue;
                                } else {
                                    try {
                                        str = new String(l.a(a8, b.f3367a, b.f3368b));
                                    } catch (Throwable th) {
                                        str = "";
                                        Logger.w("JPConfig", "decode response failed, " + th.getMessage());
                                    }
                                    if (this.f3374c != null && !TextUtils.isEmpty(str)) {
                                        Logger.d("JPConfig", "request response - p2:" + str);
                                        JSONObject jSONObject2 = new JSONObject(str);
                                        if (jSONObject2.optInt("code") == 2000) {
                                            cn.jpush.android.cache.a.d(this.f3372a, System.currentTimeMillis());
                                            this.f3374c.a(this.f3372a, jSONObject2.optJSONObject("data").toString());
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        cn.jpush.android.ac.a aVar = this.f3374c;
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    str2 = "authorization is null";
                }
                Logger.w("JPConfig", str2);
            } catch (Throwable th2) {
                Logger.w("JPConfig", "request JP config failed, " + th2.getMessage());
            }
        }

        public a(Context context, String str, cn.jpush.android.ac.a aVar) {
            this.f3372a = context;
            this.f3443e = "JPConfig";
            this.f3374c = aVar;
            this.f3373b = str;
        }

        private void b() {
            Bundle bundle = JPushConstants.getBundle();
            if (JConstants.isTestEnv() && bundle != null) {
                String string = bundle.getString("test_key_config_url");
                if (!TextUtils.isEmpty(string) && m.c(string) != null) {
                    b.f3371e.clear();
                    b.f3371e.addAll(m.c(string));
                    Logger.d("JPConfig", "test env and use the test urls " + b.f3371e);
                }
            }
        }
    }

    static {
        String b6 = cn.jpush.android.ad.d.b(new byte[]{96, 98, 101, SignedBytes.MAX_POWER_OF_TWO, 83, BinaryMemcacheOpcodes.GATK, 39, 57, 114, 85, 19, 124, Utf8.REPLACEMENT_BYTE, BinaryMemcacheOpcodes.GATK, 117, 5, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 102, 89, 15, 122, 102, 122});
        f3369c = b6;
        String b7 = cn.jpush.android.ad.d.b(new byte[]{113, 124, 98, 97, 67, 26, 54, 39, 117, 116, 3, 69, 46, 61, 114, BinaryMemcacheOpcodes.GATKQ, 29, 73, 105, 126, 32, Utf8.REPLACEMENT_BYTE, 90, 80, 108, 123, 126, Utf8.REPLACEMENT_BYTE, 83, 78, 54, Byte.MAX_VALUE, Byte.MAX_VALUE, 62, 83, 78, 117});
        f3370d = b7;
        LinkedList<String> linkedList = new LinkedList<>();
        f3371e = linkedList;
        linkedList.clear();
        f3371e.add(b6);
        f3371e.add(b7);
    }

    public static void a(Context context, String str, cn.jpush.android.ac.a aVar) {
        JCoreHelper.normalExecutor(context, null, new a(context, str, aVar));
    }
}
