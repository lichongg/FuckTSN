package cn.jiguang.bh;

import cn.jiguang.bz.w;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class k {

    /* renamed from: d, reason: collision with root package name */
    private static k f2200d;

    /* renamed from: a, reason: collision with root package name */
    private String[] f2201a = null;

    /* renamed from: b, reason: collision with root package name */
    private g[] f2202b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f2203c = -1;

    private void a(int i6) {
        if (this.f2203c >= 0 || i6 <= 0) {
            return;
        }
        this.f2203c = i6;
    }

    private int b(String str) {
        try {
            int parseInt = Integer.parseInt(str.substring(6));
            if (parseInt >= 0) {
                return parseInt;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static synchronized k b() {
        k kVar;
        synchronized (k.class) {
            kVar = f2200d;
        }
        return kVar;
    }

    public static void c() {
        k kVar = new k();
        synchronized (k.class) {
            f2200d = kVar;
        }
    }

    private boolean d() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken(), arrayList);
            }
        }
        String property2 = System.getProperty("dns.search");
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, ",");
            while (stringTokenizer2.hasMoreTokens()) {
                b(stringTokenizer2.nextToken(), arrayList2);
            }
        }
        a(arrayList, arrayList2);
        return (this.f2201a == null || this.f2202b == null) ? false : true;
    }

    private boolean e() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        try {
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object invoke = cls.getDeclaredMethod("open", null).invoke(null, null);
            List list = (List) cls.getMethod("nameservers", null).invoke(invoke, null);
            List list2 = (List) cls.getMethod("searchlist", null).invoke(invoke, null);
            if (list.size() == 0) {
                return false;
            }
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    a((String) it.next(), arrayList);
                }
            }
            if (list2.size() > 0) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    b((String) it2.next(), arrayList2);
                }
            }
            a(arrayList, arrayList2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void f() {
        a("/etc/resolv.conf");
    }

    private void g() {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
        for (int i6 = 0; i6 < 4; i6++) {
            String a6 = w.a(strArr[i6], "");
            if (!a6.isEmpty() && ((a6.matches("^\\d+(\\.\\d+){3}$") || a6.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(a6))) {
                arrayList.add(a6);
            }
        }
        a(arrayList, arrayList2);
    }

    public void a(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i6 = -1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.startsWith("nameserver")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                        stringTokenizer.nextToken();
                        a(stringTokenizer.nextToken(), arrayList);
                    } else if (readLine.startsWith("domain")) {
                        StringTokenizer stringTokenizer2 = new StringTokenizer(readLine);
                        stringTokenizer2.nextToken();
                        if (stringTokenizer2.hasMoreTokens() && arrayList2.isEmpty()) {
                            b(stringTokenizer2.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("search")) {
                        arrayList2.clear();
                        StringTokenizer stringTokenizer3 = new StringTokenizer(readLine);
                        stringTokenizer3.nextToken();
                        while (stringTokenizer3.hasMoreTokens()) {
                            b(stringTokenizer3.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("options")) {
                        StringTokenizer stringTokenizer4 = new StringTokenizer(readLine);
                        stringTokenizer4.nextToken();
                        while (stringTokenizer4.hasMoreTokens()) {
                            String nextToken = stringTokenizer4.nextToken();
                            if (nextToken.startsWith("ndots:")) {
                                i6 = b(nextToken);
                            }
                        }
                    }
                } finally {
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException unused) {
            return;
        } catch (IOException unused2) {
        }
        a(arrayList, arrayList2);
        a(i6);
    }

    static {
        c();
    }

    public k() {
        if (!d() && !e()) {
            if (this.f2201a != null && this.f2202b != null) {
                return;
            }
            if (System.getProperty("java.vendor").indexOf("Android") != -1) {
                g();
            } else {
                f();
            }
        }
    }

    private void a(String str, List list) {
        if (list.contains(str)) {
            return;
        }
        list.add(str);
    }

    private void b(String str, List list) {
        try {
            g a6 = g.a(str, g.f2182a);
            if (list.contains(a6)) {
                return;
            }
            list.add(a6);
        } catch (Exception unused) {
        }
    }

    private void a(List list, List list2) {
        if (this.f2201a == null && list.size() > 0) {
            this.f2201a = (String[]) list.toArray(new String[0]);
        }
        if (this.f2202b != null || list2.size() <= 0) {
            return;
        }
        this.f2202b = (g[]) list2.toArray(new g[0]);
    }

    public String[] a() {
        return this.f2201a;
    }
}
