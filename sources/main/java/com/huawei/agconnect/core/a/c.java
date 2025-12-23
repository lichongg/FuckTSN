package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.huawei.agconnect.core.ServiceDiscovery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f32972a;

    static /* synthetic */ class a {
    }

    private static class b implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    private <T extends com.huawei.agconnect.core.c> T a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (com.huawei.agconnect.core.c.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            cls.toString();
            return null;
        } catch (ClassNotFoundException e6) {
            e6.getMessage();
            return null;
        } catch (IllegalAccessException e7) {
            e = e7;
            e.getLocalizedMessage();
            return null;
        } catch (InstantiationException e8) {
            e = e8;
            e.getLocalizedMessage();
            return null;
        }
    }

    private List<String> c() {
        ArrayList arrayList = new ArrayList();
        Bundle d6 = d();
        if (d6 != null) {
            HashMap hashMap = new HashMap(10);
            for (String str : d6.keySet()) {
                if ("com.huawei.agconnect.core.ServiceRegistrar".equals(d6.getString(str))) {
                    String[] split = str.split(":");
                    if (split.length == 2) {
                        try {
                            hashMap.put(split[0], Integer.valueOf(split[1]));
                        } catch (NumberFormatException e6) {
                            e6.getMessage();
                        }
                    } else if (split.length == 1) {
                        hashMap.put(split[0], 1000);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList2, new b(null));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(((Map.Entry) it.next()).getKey());
            }
        }
        return arrayList;
    }

    private Bundle d() {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.f32972a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f32972a, (Class<?>) ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e6) {
            e6.getLocalizedMessage();
        }
        if (serviceInfo == null) {
            return null;
        }
        return serviceInfo.metaData;
    }

    c(Context context) {
        this.f32972a = context;
    }

    public List<com.huawei.agconnect.core.b> b() {
        List<String> c6 = c();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = c6.iterator();
        while (it.hasNext()) {
            com.huawei.agconnect.core.c a6 = a(it.next());
            if (a6 != null) {
                a6.b(this.f32972a);
                List<com.huawei.agconnect.core.b> a7 = a6.a(this.f32972a);
                if (a7 != null) {
                    arrayList.addAll(a7);
                }
            }
        }
        arrayList.size();
        return arrayList;
    }
}
