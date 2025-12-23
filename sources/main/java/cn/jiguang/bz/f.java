package cn.jiguang.bz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f2730b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f2731c = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public static String f2729a = "yyyyMMdd_HHmm";

    /* renamed from: d, reason: collision with root package name */
    private static final TimeZone f2732d = TimeZone.getTimeZone("UTC");

    /* renamed from: e, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f2733e = new ThreadLocal<SimpleDateFormat>() { // from class: cn.jiguang.bz.f.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
            simpleDateFormat.setTimeZone(f.f2732d);
            return simpleDateFormat;
        }
    };

    private static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a, reason: collision with root package name */
        private String f2734a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f2734a, Locale.ENGLISH);
        }

        a(String str) {
            this.f2734a = str;
        }
    }

    public static long a(int i6) {
        Calendar calendar = Calendar.getInstance();
        calendar.roll(6, i6);
        return calendar.getTime().getTime();
    }

    public static String a() {
        return a("yyyyMMdd HH:mm:ss.SSS").format(new Date());
    }

    public static Date c() {
        return Calendar.getInstance(f2732d).getTime();
    }

    public static String a(Date date) {
        return f2733e.get().format(date);
    }

    public static String b() {
        return a("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f2731c.get(str);
        if (threadLocal == null) {
            synchronized (f2730b) {
                try {
                    threadLocal = f2731c.get(str);
                    if (threadLocal == null) {
                        threadLocal = new a(str);
                        f2731c.put(str, threadLocal);
                    }
                } finally {
                }
            }
        }
        return threadLocal.get();
    }
}
