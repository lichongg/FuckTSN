package cn.jpush.android.ad;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3439a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f3440b = new ConcurrentHashMap<>();

    private static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a, reason: collision with root package name */
        private String f3441a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f3441a, Locale.ENGLISH);
        }

        a(String str) {
            this.f3441a = str;
        }
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f3440b.get(str);
        if (threadLocal == null) {
            synchronized (f3439a) {
                try {
                    threadLocal = f3440b.get(str);
                    if (threadLocal == null) {
                        threadLocal = new a(str);
                        f3440b.put(str, threadLocal);
                    }
                } finally {
                }
            }
        }
        return threadLocal.get();
    }

    public static long b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return a("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
            } catch (ParseException unused) {
                return -1L;
            }
        }
        return -1L;
    }
}
