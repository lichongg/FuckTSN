package com.huawei.agconnect.config.impl;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f32917a = "Utils";

    /* renamed from: b, reason: collision with root package name */
    private static final int f32918b = 4096;

    /* renamed from: c, reason: collision with root package name */
    public static final String f32919c = "DEFAULT_INSTANCE";

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void b(Reader reader, Writer writer) throws IOException {
        c(reader, writer, new char[4096]);
    }

    public static Map<String, String> d(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashMap.put(e(entry.getKey()), entry.getValue());
        }
        return hashMap;
    }

    public static com.huawei.agconnect.b f(String str, String str2) {
        if (str == null) {
            if (str2 != null) {
                if (str2.contains("connect-drcn")) {
                    return com.huawei.agconnect.b.f32911c;
                }
                if (str2.contains("connect-dre")) {
                    return com.huawei.agconnect.b.f32912d;
                }
                if (str2.contains("connect-drru")) {
                    return com.huawei.agconnect.b.f32913e;
                }
                if (str2.contains("connect-dra")) {
                    return com.huawei.agconnect.b.f32914f;
                }
            }
            return com.huawei.agconnect.b.f32910b;
        }
        switch (str) {
            case "CN":
                return com.huawei.agconnect.b.f32911c;
            case "DE":
                return com.huawei.agconnect.b.f32912d;
            case "RU":
                return com.huawei.agconnect.b.f32913e;
            case "SG":
                return com.huawei.agconnect.b.f32914f;
            default:
                return com.huawei.agconnect.b.f32910b;
        }
    }

    public static String g(InputStream inputStream, String str) throws UnsupportedEncodingException, IOException {
        StringWriter stringWriter = new StringWriter();
        b(new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }

    public static void c(Reader reader, Writer writer, char[] cArr) throws IOException {
        while (true) {
            int read = reader.read(cArr);
            if (-1 != read) {
                writer.write(cArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String e(String str) {
        int i6 = 0;
        if (str.length() > 0) {
            while (str.charAt(i6) == '/') {
                i6++;
            }
        }
        return "/" + str.substring(i6);
    }
}
