package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class j implements h {

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, List<i>> f15435c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f15436d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        private static final String f15437d = "User-Agent";

        /* renamed from: e, reason: collision with root package name */
        private static final String f15438e;

        /* renamed from: f, reason: collision with root package name */
        private static final Map<String, List<i>> f15439f;

        /* renamed from: a, reason: collision with root package name */
        private boolean f15440a = true;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, List<i>> f15441b = f15439f;

        /* renamed from: c, reason: collision with root package name */
        private boolean f15442c = true;

        public j c() {
            this.f15440a = true;
            return new j(this.f15441b);
        }

        private Map<String, List<i>> d() {
            HashMap hashMap = new HashMap(this.f15441b.size());
            for (Map.Entry<String, List<i>> entry : this.f15441b.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return hashMap;
        }

        private void e() {
            if (this.f15440a) {
                this.f15440a = false;
                this.f15441b = d();
            }
        }

        private List<i> f(String str) {
            List<i> list = this.f15441b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f15441b.put(str, arrayList);
            return arrayList;
        }

        @VisibleForTesting
        static String g() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = property.charAt(i6);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public a a(@NonNull String str, @NonNull i iVar) {
            if (this.f15442c && "User-Agent".equalsIgnoreCase(str)) {
                return h(str, iVar);
            }
            e();
            f(str).add(iVar);
            return this;
        }

        public a b(@NonNull String str, @NonNull String str2) {
            return a(str, new b(str2));
        }

        public a i(@NonNull String str, @Nullable String str2) {
            return h(str, str2 == null ? null : new b(str2));
        }

        static {
            String g6 = g();
            f15438e = g6;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(g6)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(g6)));
            }
            f15439f = Collections.unmodifiableMap(hashMap);
        }

        public a h(@NonNull String str, @Nullable i iVar) {
            e();
            if (iVar == null) {
                this.f15441b.remove(str);
            } else {
                List<i> f6 = f(str);
                f6.clear();
                f6.add(iVar);
            }
            if (this.f15442c && "User-Agent".equalsIgnoreCase(str)) {
                this.f15442c = false;
            }
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements i {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final String f15443a;

        @Override // com.bumptech.glide.load.model.i
        public String a() {
            return this.f15443a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f15443a.equals(((b) obj).f15443a);
            }
            return false;
        }

        public int hashCode() {
            return this.f15443a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f15443a + "'}";
        }

        b(@NonNull String str) {
            this.f15443a = str;
        }
    }

    @NonNull
    private String a(@NonNull List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            String a6 = list.get(i6).a();
            if (!TextUtils.isEmpty(a6)) {
                sb.append(a6);
                if (i6 != list.size() - 1) {
                    sb.append(StringUtil.COMMA);
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f15435c.entrySet()) {
            String a6 = a(entry.getValue());
            if (!TextUtils.isEmpty(a6)) {
                hashMap.put(entry.getKey(), a6);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f15435c.equals(((j) obj).f15435c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.h
    public Map<String, String> getHeaders() {
        if (this.f15436d == null) {
            synchronized (this) {
                try {
                    if (this.f15436d == null) {
                        this.f15436d = Collections.unmodifiableMap(b());
                    }
                } finally {
                }
            }
        }
        return this.f15436d;
    }

    public int hashCode() {
        return this.f15435c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f15435c + '}';
    }

    j(Map<String, List<i>> map) {
        this.f15435c = Collections.unmodifiableMap(map);
    }
}
