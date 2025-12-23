package com.acse.ottn;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.regex.Pattern;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b1<T> implements retrofit2.g<ResponseBody, T> {

    /* renamed from: a, reason: collision with root package name */
    public final Type f4240a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
    @Override // retrofit2.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T convert(ResponseBody responseBody) throws IOException {
        String a6;
        int i6;
        BufferedSource buffer = Okio.buffer(responseBody.source());
        String readUtf8 = buffer.readUtf8();
        buffer.close();
        T t5 = (T) null;
        try {
            JSONObject jSONObject = new JSONObject(readUtf8);
            try {
                jSONObject.getInt(com.kuaishou.weapon.p0.t.f36150k);
                t5 = (T) JSON.parseObject(readUtf8, this.f4240a, new Feature[0]);
                return t5;
            } catch (Exception unused) {
                boolean z5 = true;
                if (jSONObject.getInt("heart_beat") != 1) {
                    z5 = false;
                }
                a6 = k0.a(z5);
                i6 = t5;
                if (TextUtils.isEmpty(a6)) {
                    return (T) JSON.parseObject(readUtf8, this.f4240a, new Feature[i6]);
                }
                c2.a(m3.f4828e, "samon responese data = " + a(b(f.a().a(readUtf8, a6))));
                return (T) JSON.parseObject(a(b(f.a().a(readUtf8, a6))), this.f4240a, new Feature[i6]);
            }
        } catch (JSONException unused2) {
            a6 = k0.a((boolean) t5);
            i6 = t5;
        }
    }

    public static String b(String str) {
        StringBuilder sb;
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (Integer.toHexString(charAt).length() == 1) {
                sb = new StringBuilder();
                str2 = "u0";
            } else {
                sb = new StringBuilder();
                str2 = "u";
            }
            sb.append(str2);
            sb.append(Integer.toHexString(charAt));
            stringBuffer.append(sb.toString());
        }
        return Pattern.compile("u02").matcher(stringBuffer).replaceAll("");
    }

    public b1(Type type) {
        this.f4240a = type;
    }

    public static String a(String str) {
        if (!str.contains("u")) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = str.split("u");
        for (int i6 = 1; i6 < split.length; i6++) {
            stringBuffer.append((char) Integer.parseInt(split[i6], 16));
        }
        return stringBuffer.toString();
    }
}
