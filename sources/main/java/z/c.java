package z;

import cn.bluemobi.dylan.http.MD5Utils;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.common.ext.h;
import com.bxkj.base.v2.common.utils.f;
import com.bxkj.base.v2.data.b;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.e;
import kotlin.text.u;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRequestInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RequestInterceptor.kt\ncom/bxkj/base/v2/http/interceptor/RequestInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,189:1\n1869#2,2:190\n216#3,2:192\n1#4:194\n*S KotlinDebug\n*F\n+ 1 RequestInterceptor.kt\ncom/bxkj/base/v2/http/interceptor/RequestInterceptor\n*L\n61#1:190,2\n114#1:192,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c implements Interceptor {
    private final String a(String str, String str2, boolean z5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (z5) {
            try {
                sb.append(URLEncoder.encode(str2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                sb.append(str2);
            }
        } else {
            sb.append(str2);
        }
        return sb.toString();
    }

    @NotNull
    public final String b(@NotNull Map<String, String> map) {
        g0.p(map, "map");
        c0.b bVar = c0.b.f1042a;
        BaseApp c6 = BaseApp.c();
        g0.o(c6, "getApp(...)");
        return bVar.h(c6, com.bxkj.base.v2.data.b.f16998d.a().g(), map);
    }

    @NotNull
    public final String c(@NotNull Map<String, String> map) {
        g0.p(map, "map");
        List v5 = f0.v5(f0.a6(map.keySet()));
        StringBuilder sb = new StringBuilder();
        int size = v5.size() - 1;
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                break;
            }
            String str = (String) v5.get(i6);
            String str2 = map.get(str);
            if (str2 != null) {
                r5 = a(str, str2, false);
            }
            sb.append(r5);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            i6++;
        }
        String str3 = (String) v5.get(v5.size() - 1);
        String str4 = map.get(str3);
        sb.append(str4 != null ? a(str3, str4, false) : null);
        try {
            String encode = URLEncoder.encode(MD5Utils.md5(sb.toString()), "UTF-8");
            g0.o(encode, "encode(...)");
            return encode;
        } catch (UnsupportedEncodingException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request;
        String str;
        String str2;
        g0.p(chain, "chain");
        Request request2 = chain.request();
        Request.Builder newBuilder = request2.newBuilder();
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        String g6 = aVar.a().g();
        String httpUrl = request2.url().toString();
        c0.b bVar = c0.b.f1042a;
        BaseApp c6 = BaseApp.c();
        g0.o(c6, "getApp(...)");
        int i6 = 0;
        Charset charset = null;
        byte b6 = 0;
        if (!u.Y1(httpUrl, bVar.l(c6, "7e9c6f977d2da2dbe67cd1005eaaf6e1"), false)) {
            String httpUrl2 = request2.url().toString();
            BaseApp c7 = BaseApp.c();
            g0.o(c7, "getApp(...)");
            if (!u.i3(httpUrl2, bVar.l(c7, "e5c6b9630a11efdfa31a4cfa4b227688"), false)) {
                String httpUrl3 = request2.url().toString();
                BaseApp c8 = BaseApp.c();
                g0.o(c8, "getApp(...)");
                if (!u.i3(httpUrl3, bVar.l(c8, "e8ed1c044ac961926d8f79bd70dee316"), false)) {
                    String httpUrl4 = request2.url().toString();
                    BaseApp c9 = BaseApp.c();
                    g0.o(c9, "getApp(...)");
                    if (!u.i3(httpUrl4, bVar.l(c9, "16dd77786f3c3e1ac964437c978434ef"), false) && !u.i3(request2.url().toString(), "https://device.jpush.cn/v3/aliases", false)) {
                        if (aVar.a().Y()) {
                            String httpUrl5 = request2.url().toString();
                            BaseApp c10 = BaseApp.c();
                            g0.o(c10, "getApp(...)");
                            if (!u.l3(httpUrl5, bVar.l(c10, "785796286eb58ca15168713af4fce70c"), false, 2, null)) {
                                str2 = "Bearer " + g6;
                                newBuilder.addHeader("Authorization", str2);
                            }
                        }
                        byte[] bytes = (aVar.a().J() + ":pig").getBytes(e.f47851b);
                        g0.o(bytes, "getBytes(...)");
                        str2 = "Basic  " + cn.bluemobi.dylan.base.utils.b.b(bytes);
                        newBuilder.addHeader("Authorization", str2);
                    }
                }
            }
        }
        newBuilder.addHeader("school", aVar.a().J());
        newBuilder.addHeader("Cookie", "host=" + aVar.a().J());
        f fVar = f.f16889a;
        BaseApp c11 = BaseApp.c();
        g0.o(c11, "getApp(...)");
        newBuilder.addHeader("uniqueCode", fVar.d(c11));
        if (u.H2(request2.url().toString(), "https://m.boxkj.com/", false, 2, null)) {
            newBuilder.addHeader("channel", "Android");
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        if (request2.headers().names().contains("timestamp")) {
            valueOf = String.valueOf(request2.headers().get("timestamp"));
        }
        BaseApp c12 = BaseApp.c();
        g0.o(c12, "getApp(...)");
        String d6 = bVar.d(c12, aVar.a().j(), g6, valueOf);
        BaseApp c13 = BaseApp.c();
        g0.o(c13, "getApp(...)");
        String e6 = bVar.e(c13, g6, valueOf);
        if (u.a2(request2.method(), "GET", true)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str3 : request2.url().queryParameterNames()) {
                String queryParameter = request2.url().queryParameter(str3);
                if (queryParameter == null || (str = u.x2(queryParameter, com.snail.antifake.deviceid.e.f37542d, "", false, 4, null)) == null) {
                    str = "";
                }
                linkedHashMap.put(str3, str);
            }
            linkedHashMap.put("appId", d6);
            linkedHashMap.put("appSecret", e6);
            newBuilder.header("timestamp", valueOf);
            newBuilder.addHeader("sign", b(linkedHashMap));
            request = request2;
        } else if (request2.body() instanceof FormBody) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            request = request2;
            if (u.H2(request2.url().toString(), "https://m.boxkj.com/", false, 2, null)) {
                FormBody.Builder builder = new FormBody.Builder(charset, 1, b6 == true ? 1 : 0);
                RequestBody body = request.body();
                g0.n(body, "null cannot be cast to non-null type okhttp3.FormBody");
                FormBody formBody = (FormBody) body;
                int size = formBody.size();
                while (i6 < size) {
                    String name = formBody.name(i6);
                    String value = formBody.value(i6);
                    linkedHashMap2.put(name, value);
                    builder.add(name, value);
                    i6++;
                }
                linkedHashMap2.put("appId", "move");
                linkedHashMap2.put("appSecret", x.f.f54746b);
                linkedHashMap2.put("timestamp", valueOf);
                String c14 = c(linkedHashMap2);
                builder.add("timestamp", valueOf);
                builder.add("sign", c14);
                newBuilder.method(request.method(), builder.build());
            } else {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                RequestBody body2 = request.body();
                g0.n(body2, "null cannot be cast to non-null type okhttp3.FormBody");
                FormBody formBody2 = (FormBody) body2;
                int size2 = formBody2.size();
                while (i6 < size2) {
                    linkedHashMap3.put(formBody2.name(i6), formBody2.value(i6));
                    i6++;
                }
                linkedHashMap3.put("appId", d6);
                linkedHashMap3.put("appSecret", e6);
                newBuilder.header("timestamp", valueOf);
                newBuilder.addHeader("sign", b(linkedHashMap3));
            }
        } else {
            request = request2;
            if (request.body() instanceof MultipartBody) {
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                RequestBody body3 = request.body();
                g0.n(body3, "null cannot be cast to non-null type okhttp3.MultipartBody");
                Pair<Map<String, String>, Map<String, String>> a6 = h.a((MultipartBody) body3);
                Map<String, String> component1 = a6.component1();
                a6.component2();
                for (Map.Entry<String, String> entry : component1.entrySet()) {
                    linkedHashMap4.put(entry.getKey(), entry.getValue());
                }
                linkedHashMap4.put("appId", d6);
                linkedHashMap4.put("appSecret", e6);
                newBuilder.header("timestamp", valueOf);
                newBuilder.addHeader("sign", b(linkedHashMap4));
            }
        }
        String decode = URLDecoder.decode(request.url().toString());
        g0.o(decode, "decode(...)");
        newBuilder.url(decode);
        return chain.proceed(newBuilder.build());
    }
}
