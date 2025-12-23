package cn.jiguang.bp;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final Date f2488a;

    /* renamed from: b, reason: collision with root package name */
    private Date f2489b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f2490c;

    /* renamed from: d, reason: collision with root package name */
    private final UUID f2491d;

    /* renamed from: e, reason: collision with root package name */
    private Boolean f2492e;

    /* renamed from: f, reason: collision with root package name */
    private a f2493f;

    /* renamed from: g, reason: collision with root package name */
    private Long f2494g;

    /* renamed from: h, reason: collision with root package name */
    private Double f2495h;

    /* renamed from: i, reason: collision with root package name */
    private final String f2496i;

    /* renamed from: j, reason: collision with root package name */
    private String f2497j;

    /* renamed from: k, reason: collision with root package name */
    private final String f2498k;

    /* renamed from: l, reason: collision with root package name */
    private final Object f2499l;

    public enum a {
        Ok,
        Exited,
        Crashed
    }

    public i() {
        this(a.Ok, cn.jiguang.bz.f.c(), cn.jiguang.bz.f.c(), 0, UUID.randomUUID(), Boolean.TRUE, null, null, null, null, "production");
    }

    private double b(Date date) {
        return Math.abs(date.getTime() - this.f2488a.getTime()) / 1000.0d;
    }

    private long c(Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    public Date a() {
        Date date = this.f2488a;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public i(a aVar, Date date, Date date2, int i6, UUID uuid, Boolean bool, Long l6, Double d6, String str, String str2, String str3) {
        this.f2499l = new Object();
        this.f2493f = aVar;
        this.f2488a = date;
        this.f2489b = date2;
        this.f2490c = new AtomicInteger(i6);
        this.f2491d = uuid;
        this.f2492e = bool;
        this.f2494g = l6;
        this.f2495h = d6;
        this.f2496i = str;
        this.f2497j = str2;
        this.f2498k = str3;
    }

    public void a(Date date) {
        synchronized (this.f2499l) {
            try {
                this.f2492e = null;
                if (this.f2493f == a.Ok) {
                    this.f2493f = a.Exited;
                }
                if (date == null) {
                    date = cn.jiguang.bz.f.c();
                }
                this.f2489b = date;
                Date date2 = this.f2489b;
                if (date2 != null) {
                    this.f2495h = Double.valueOf(b(date2));
                    this.f2494g = Long.valueOf(c(this.f2489b));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public UUID b() {
        return this.f2491d;
    }

    public Boolean c() {
        return this.f2492e;
    }

    public int d() {
        return this.f2490c.get();
    }

    public a e() {
        return this.f2493f;
    }

    public Long f() {
        return this.f2494g;
    }

    public Double g() {
        return this.f2495h;
    }

    public Date h() {
        Date date = this.f2489b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public i clone() {
        return new i(this.f2493f, this.f2488a, this.f2489b, this.f2490c.get(), this.f2491d, this.f2492e, this.f2494g, this.f2495h, this.f2496i, this.f2497j, this.f2498k);
    }

    public boolean a(a aVar, String str, boolean z5) {
        boolean z6;
        boolean z7;
        synchronized (this.f2499l) {
            z6 = true;
            if (aVar != null) {
                try {
                    this.f2493f = aVar;
                    z7 = true;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                z7 = false;
            }
            if (str != null) {
                this.f2497j = str;
                z7 = true;
            }
            if (z5) {
                this.f2490c.addAndGet(1);
            } else {
                z6 = z7;
            }
            if (z6) {
                this.f2492e = null;
                Date c6 = cn.jiguang.bz.f.c();
                this.f2489b = c6;
                if (c6 != null) {
                    this.f2494g = Long.valueOf(c(c6));
                }
            }
        }
        return z6;
    }

    public void i() {
        a(cn.jiguang.bz.f.c());
    }
}
