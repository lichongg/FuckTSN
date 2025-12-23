package com.huawei.agconnect;

import android.content.Context;
import com.huawei.hmf.tasks.k;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class f {

    /* renamed from: f, reason: collision with root package name */
    private static final String f32989f = "/client/product_id";

    /* renamed from: g, reason: collision with root package name */
    private static final String f32990g = "/client/app_id";

    /* renamed from: h, reason: collision with root package name */
    private static final String f32991h = "/client/cp_id";

    /* renamed from: i, reason: collision with root package name */
    private static final String f32992i = "/client/api_key";

    /* renamed from: j, reason: collision with root package name */
    private static final String f32993j = "/client/client_id";

    /* renamed from: k, reason: collision with root package name */
    private static final String f32994k = "/client/client_secret";

    /* renamed from: a, reason: collision with root package name */
    private String f32995a;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f32997c;

    /* renamed from: b, reason: collision with root package name */
    private com.huawei.agconnect.b f32996b = com.huawei.agconnect.b.f32910b;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, String> f32998d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final List<com.huawei.agconnect.core.b> f32999e = new ArrayList();

    class a implements l1.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f33000a;

        a(h hVar) {
            this.f33000a = hVar;
        }

        @Override // l1.b
        public k<l1.d> a(boolean z5) {
            return this.f33000a.a(z5);
        }

        @Override // l1.b
        public k<l1.d> b() {
            return this.f33000a.a(false);
        }
    }

    class b implements l1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f33002a;

        b(g gVar) {
            this.f33002a = gVar;
        }

        @Override // l1.a
        public k<l1.d> a(boolean z5) {
            return this.f33002a.a(z5);
        }

        @Override // l1.a
        public k<l1.d> b() {
            return this.f33002a.a(false);
        }

        @Override // l1.a
        public String getUid() {
            return this.f33002a.getUid();
        }

        @Override // l1.a
        public void c(l1.c cVar) {
        }

        @Override // l1.a
        public void d(l1.c cVar) {
        }
    }

    public e a(Context context) {
        return new com.huawei.agconnect.config.impl.d(context, this.f32995a, this.f32996b, this.f32997c, this.f32998d, this.f32999e, null);
    }

    public e b(Context context, String str) {
        return new com.huawei.agconnect.config.impl.d(context, this.f32995a, this.f32996b, this.f32997c, this.f32998d, this.f32999e, str);
    }

    public Map<String, String> c() {
        return new HashMap(this.f32998d);
    }

    public InputStream d() {
        return this.f32997c;
    }

    public com.huawei.agconnect.b e() {
        return this.f32996b;
    }

    public f f(String str) {
        this.f32998d.put(f32992i, str);
        return this;
    }

    public f g(String str) {
        this.f32998d.put(f32990g, str);
        return this;
    }

    public f h(String str) {
        this.f32998d.put(f32991h, str);
        return this;
    }

    public f i(String str) {
        this.f32998d.put(f32993j, str);
        return this;
    }

    public f j(String str) {
        this.f32998d.put(f32994k, str);
        return this;
    }

    public f k(g gVar) {
        if (gVar != null) {
            this.f32999e.add(com.huawei.agconnect.core.b.e(l1.a.class, new b(gVar)).a());
        }
        return this;
    }

    public f l(h hVar) {
        if (hVar != null) {
            this.f32999e.add(com.huawei.agconnect.core.b.e(l1.b.class, new a(hVar)).a());
        }
        return this;
    }

    public f m(String str, String str2) {
        this.f32998d.put(str, str2);
        return this;
    }

    public f n(InputStream inputStream) {
        this.f32997c = inputStream;
        return this;
    }

    public f o(String str) {
        this.f32995a = str;
        return this;
    }

    public f p(String str) {
        this.f32998d.put(f32989f, str);
        return this;
    }

    public f q(com.huawei.agconnect.b bVar) {
        this.f32996b = bVar;
        return this;
    }
}
