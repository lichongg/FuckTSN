package cn.jiguang.az;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1840a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f1841b = new ConcurrentHashMap<>();

    private static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a, reason: collision with root package name */
        private String f1842a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f1842a, Locale.ENGLISH);
        }

        a(String str) {
            this.f1842a = str;
        }
    }

    public static String a(long j6) {
        return a("yyyyMMdd HH:mm:ss.SSS").format(new Date(j6));
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f1841b.get(str);
        if (threadLocal == null) {
            synchronized (f1840a) {
                try {
                    threadLocal = f1841b.get(str);
                    if (threadLocal == null) {
                        threadLocal = new a(str);
                        f1841b.put(str, threadLocal);
                    }
                } finally {
                }
            }
        }
        return threadLocal.get();
    }
}
