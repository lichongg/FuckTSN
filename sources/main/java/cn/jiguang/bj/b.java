package cn.jiguang.bj;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.work.PeriodicWorkRequest;
import cn.jiguang.bb.f;
import cn.jiguang.bz.w;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private long f2298a;

    /* renamed from: b, reason: collision with root package name */
    private long f2299b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Pair<InetAddress[], Long>> f2300c;

    /* renamed from: cn.jiguang.bj.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class a implements Callable<InetAddress[]> {

        /* renamed from: a, reason: collision with root package name */
        private Context f2301a;

        /* renamed from: b, reason: collision with root package name */
        private String f2302b;

        /* renamed from: c, reason: collision with root package name */
        private b f2303c;

        /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.net.InetAddress[] call() {
            /*
                Method dump skipped, instructions count: 253
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bj.b.a.call():java.net.InetAddress[]");
        }

        a(Context context, String str, b bVar) {
            this.f2301a = context;
            this.f2302b = str;
            this.f2303c = bVar;
        }
    }

    /* renamed from: cn.jiguang.bj.b$b, reason: collision with other inner class name */
    private static final class C0033b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f2304a = new b(null);
    }

    private b() {
        this.f2298a = 36000000L;
        this.f2299b = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
        this.f2300c = new HashMap();
    }

    private Pair<InetAddress[], Boolean> a(Context context, String str, long j6, long j7) {
        InetAddress[] inetAddressArr;
        Pair<InetAddress[], Long> pair = this.f2300c.get(str);
        boolean z5 = pair == null || pair.first == null;
        long longValue = ((Long) (z5 ? cn.jiguang.e.b.a(context, cn.jiguang.e.a.c(str)) : pair.second)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > longValue + j6) {
            return null;
        }
        if (z5) {
            inetAddressArr = a(context, str);
            if (inetAddressArr != null) {
                this.f2300c.put(str, new Pair<>(inetAddressArr, Long.valueOf(longValue)));
            }
        } else {
            inetAddressArr = (InetAddress[]) pair.first;
        }
        if (inetAddressArr != null) {
            return new Pair<>(inetAddressArr, Boolean.valueOf(currentTimeMillis > longValue + j7));
        }
        return null;
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return C0033b.f2304a;
    }

    public InetAddress a(Context context, String str, long j6, boolean z5) {
        InetAddress[] b6 = b(context, str, j6, z5);
        if (b6 == null || b6.length <= 0) {
            return null;
        }
        return b6[0];
    }

    public InetAddress[] b(Context context, String str, long j6, boolean z5) {
        InetAddress[] inetAddressArr;
        InetAddress[] inetAddressArr2;
        InetAddress[] inetAddressArr3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        InetAddress a6 = a(str);
        if (a6 != null) {
            return new InetAddress[]{a6};
        }
        Pair<InetAddress[], Boolean> a7 = a(context, str, this.f2298a, this.f2299b);
        if (a7 != null) {
            Object obj = a7.first;
            if (obj != null) {
                inetAddressArr2 = (InetAddress[]) obj;
            } else {
                inetAddressArr2 = null;
            }
            if (!((Boolean) a7.second).booleanValue()) {
                if (z5) {
                    cn.jiguang.be.b.e(new FutureTask(new a(context, str, this)));
                }
                f.c("DNSLoader", "use cache=" + Arrays.toString(inetAddressArr2));
                return inetAddressArr2;
            }
            inetAddressArr = inetAddressArr2;
        } else {
            inetAddressArr = null;
        }
        FutureTask futureTask = new FutureTask(new a(context, str, this));
        cn.jiguang.be.b.e(futureTask);
        if (j6 == 0) {
            f.c("DNSLoader", "use cache=" + Arrays.toString(inetAddressArr));
            return inetAddressArr;
        }
        try {
            f.c("DNSLoader", "waiting dns for " + str);
            inetAddressArr3 = (InetAddress[]) futureTask.get(j6, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            f.i("DNSLoader", "run futureTask e:" + th);
        }
        if (inetAddressArr3 != null) {
            f.c("DNSLoader", "use resolved result=" + Arrays.toString(inetAddressArr3));
            return inetAddressArr3;
        }
        f.c("DNSLoader", "use cache=" + Arrays.toString(inetAddressArr));
        return inetAddressArr;
    }

    private InetAddress a(String str) {
        if (!w.f(str) && !w.g(str)) {
            return null;
        }
        try {
            return InetAddress.getByName(str);
        } catch (UnknownHostException e6) {
            f.i("DNSLoader", "dns resolve failed:" + e6);
            return null;
        }
    }

    private InetAddress[] a(Context context, String str) {
        String str2 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.b(str));
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] split = str2.split(",");
        LinkedList linkedList = new LinkedList();
        for (String str3 : split) {
            InetAddress a6 = a(str3);
            if (a6 != null) {
                linkedList.add(a6);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return (InetAddress[]) linkedList.toArray(new InetAddress[0]);
    }
}
