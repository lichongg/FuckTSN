package com.bxkj.base.v2.common.ext;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMultipartBodyExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultipartBodyExt.kt\ncom/bxkj/base/v2/common/ext/MultipartBodyExtKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n1869#2,2:50\n*S KotlinDebug\n*F\n+ 1 MultipartBodyExt.kt\ncom/bxkj/base/v2/common/ext/MultipartBodyExtKt\n*L\n11#1:50,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class h {
    @NotNull
    public static final Pair<Map<String, String>, Map<String, String>> a(@NotNull MultipartBody multipartBody) {
        g0.p(multipartBody, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        try {
            for (MultipartBody.Part part : multipartBody.parts()) {
                RequestBody body = part.body();
                Headers headers = part.headers();
                if (headers != null) {
                    List m52 = kotlin.text.u.m5(kotlin.text.u.x2(kotlin.text.u.x2(headers.value(0), " ", "", false, 4, null), "\"", "", false, 4, null), new String[]{";"}, false, 0, 6, null);
                    int size = m52.size();
                    if (size == 2) {
                        List m53 = kotlin.text.u.m5((CharSequence) m52.get(1), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);
                        if (m53.size() > 1) {
                            String str = (String) m53.get(1);
                            Buffer buffer = new Buffer();
                            body.writeTo(buffer);
                            linkedHashMap.put(str, buffer.readUtf8());
                        }
                    } else if (size == 3) {
                        List m54 = kotlin.text.u.m5((CharSequence) m52.get(1), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);
                        String str2 = m54.size() > 1 ? (String) m54.get(1) : "";
                        List m55 = kotlin.text.u.m5((CharSequence) m52.get(2), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);
                        String str3 = m55.size() > 1 ? (String) m55.get(1) : "";
                        linkedHashMap2.put(str2, str3 + " " + g.a(body.contentLength()));
                    }
                }
            }
        } catch (Exception e6) {
            com.orhanobut.logger.j.e(e.a(e6), new Object[0]);
        }
        return new Pair<>(linkedHashMap, linkedHashMap2);
    }
}
