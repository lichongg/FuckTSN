package cn.jiguang.be;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.bb.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f2037a = "JDataControlManager";

    /* renamed from: c, reason: collision with root package name */
    private static String f2038c = "DISABLE_DATA";

    /* renamed from: d, reason: collision with root package name */
    private static String f2039d = "ENABLE_DATA";

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, ConcurrentHashMap<String, Set<Integer>>> f2040b;

    /* renamed from: e, reason: collision with root package name */
    private Context f2041e;

    /* renamed from: cn.jiguang.be.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f2042a = new c(null);
    }

    private c() {
        this.f2040b = new ConcurrentHashMap<>();
    }

    public synchronized Bundle a(Context context, String str, Bundle bundle) {
        try {
            f.c(f2037a, "setDataControl control=" + bundle + " sdkType=" + str);
            this.f2041e = context;
            ConcurrentHashMap<String, Set<Integer>> concurrentHashMap = this.f2040b.get(str);
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
            }
            Set<Integer> set = concurrentHashMap.get("enable_c_c");
            if (set == null) {
                set = new HashSet<>();
            }
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("enable_c_c");
            Set<Integer> set2 = concurrentHashMap.get("disable_c_c");
            if (set2 == null) {
                set2 = new HashSet<>();
            }
            ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList("disable_c_c");
            if (integerArrayList2 != null) {
                set2.addAll(integerArrayList2);
            }
            if (integerArrayList != null) {
                Iterator<Integer> it = integerArrayList.iterator();
                while (it.hasNext()) {
                    Integer next = it.next();
                    next.intValue();
                    set2.remove(next);
                }
            }
            if (integerArrayList2 != null) {
                Iterator<Integer> it2 = integerArrayList2.iterator();
                while (it2.hasNext()) {
                    Integer next2 = it2.next();
                    next2.intValue();
                    set.remove(next2);
                }
            }
            if (integerArrayList != null) {
                set.addAll(integerArrayList);
            }
            concurrentHashMap.put("enable_c_c", set);
            concurrentHashMap.put("disable_c_c", set2);
            this.f2040b.put(str, concurrentHashMap);
        } catch (Throwable th) {
            throw th;
        }
        return b();
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c a() {
        return a.f2042a;
    }

    public Bundle b() {
        ConcurrentHashMap concurrentHashMap;
        try {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            Bundle bundle = new Bundle();
            synchronized (this) {
                concurrentHashMap = new ConcurrentHashMap(this.f2040b);
            }
            if (!concurrentHashMap.isEmpty()) {
                Iterator it = concurrentHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) ((Map.Entry) it.next()).getValue();
                    Set set = (Set) concurrentHashMap2.get("enable_c_c");
                    if (set != null) {
                        arrayList.addAll(new ArrayList(set));
                    }
                    Set set2 = (Set) concurrentHashMap2.get("disable_c_c");
                    if (set2 != null) {
                        arrayList2.addAll(new ArrayList(set2));
                    }
                }
                bundle.putIntegerArrayList(f2038c, arrayList2);
                bundle.putIntegerArrayList(f2039d, arrayList);
            }
            if (!arrayList2.isEmpty()) {
                Iterator<Integer> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    cn.jiguang.bw.a.a().b(it2.next().intValue());
                }
            }
            f.c(f2037a, "sendDataToRemoteProcess bundle=" + bundle);
            return bundle;
        } catch (Throwable th) {
            f.c(f2037a, "sendDataToRemoteProcess throwable=" + th);
            return null;
        }
    }
}
