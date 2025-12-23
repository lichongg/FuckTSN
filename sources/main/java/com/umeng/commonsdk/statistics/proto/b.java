package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cr;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.cz;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dc;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b implements br<b, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, cd> f42012d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f42013e = -6496538196005191531L;

    /* renamed from: f, reason: collision with root package name */
    private static final cv f42014f = new cv("IdSnapshot");

    /* renamed from: g, reason: collision with root package name */
    private static final cl f42015g = new cl("identity", (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final cl f42016h = new cl("ts", (byte) 10, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final cl f42017i = new cl("version", (byte) 8, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f42018j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f42019k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f42020l = 1;

    /* renamed from: a, reason: collision with root package name */
    public String f42021a;

    /* renamed from: b, reason: collision with root package name */
    public long f42022b;

    /* renamed from: c, reason: collision with root package name */
    public int f42023c;

    /* renamed from: m, reason: collision with root package name */
    private byte f42024m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends da<b> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cq cqVar, b bVar) throws bx {
            cqVar.j();
            while (true) {
                cl l6 = cqVar.l();
                byte b6 = l6.f41141b;
                if (b6 == 0) {
                    break;
                }
                short s5 = l6.f41142c;
                if (s5 != 1) {
                    if (s5 != 2) {
                        if (s5 != 3) {
                            ct.a(cqVar, b6);
                        } else if (b6 == 8) {
                            bVar.f42023c = cqVar.w();
                            bVar.c(true);
                        } else {
                            ct.a(cqVar, b6);
                        }
                    } else if (b6 == 10) {
                        bVar.f42022b = cqVar.x();
                        bVar.b(true);
                    } else {
                        ct.a(cqVar, b6);
                    }
                } else if (b6 == 11) {
                    bVar.f42021a = cqVar.z();
                    bVar.a(true);
                } else {
                    ct.a(cqVar, b6);
                }
                cqVar.m();
            }
            cqVar.k();
            if (!bVar.g()) {
                throw new cr("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new cr("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cq cqVar, b bVar) throws bx {
            bVar.k();
            cqVar.a(b.f42014f);
            if (bVar.f42021a != null) {
                cqVar.a(b.f42015g);
                cqVar.a(bVar.f42021a);
                cqVar.c();
            }
            cqVar.a(b.f42016h);
            cqVar.a(bVar.f42022b);
            cqVar.c();
            cqVar.a(b.f42017i);
            cqVar.a(bVar.f42023c);
            cqVar.c();
            cqVar.d();
            cqVar.b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    private static class C0831b implements cz {
        private C0831b() {
        }

        /* synthetic */ C0831b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends db<b> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, b bVar) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(bVar.f42021a);
            cwVar.a(bVar.f42022b);
            cwVar.a(bVar.f42023c);
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, b bVar) throws bx {
            cw cwVar = (cw) cqVar;
            bVar.f42021a = cwVar.z();
            bVar.a(true);
            bVar.f42022b = cwVar.x();
            bVar.b(true);
            bVar.f42023c = cwVar.w();
            bVar.c(true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d implements cz {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c(null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum e implements by {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f42028d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f42030e;

        /* renamed from: f, reason: collision with root package name */
        private final String f42031f;

        public static e a(int i6) {
            if (i6 == 1) {
                return IDENTITY;
            }
            if (i6 == 2) {
                return TS;
            }
            if (i6 != 3) {
                return null;
            }
            return VERSION;
        }

        public static e b(int i6) {
            e a6 = a(i6);
            if (a6 != null) {
                return a6;
            }
            throw new IllegalArgumentException("Field " + i6 + " doesn't exist!");
        }

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f42028d.put(eVar.b(), eVar);
            }
        }

        e(short s5, String str) {
            this.f42030e = s5;
            this.f42031f = str;
        }

        @Override // com.umeng.analytics.pro.by
        public String b() {
            return this.f42031f;
        }

        public static e a(String str) {
            return f42028d.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f42030e;
        }
    }

    public b() {
        this.f42024m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f42021a;
    }

    public void c() {
        this.f42021a = null;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f42021a = null;
        b(false);
        this.f42022b = 0L;
        c(false);
        this.f42023c = 0;
    }

    static {
        HashMap hashMap = new HashMap();
        f42018j = hashMap;
        AnonymousClass1 anonymousClass1 = null;
        hashMap.put(da.class, new C0831b(anonymousClass1));
        hashMap.put(db.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new cd("identity", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new cd("ts", (byte) 1, new ce((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new cd("version", (byte) 1, new ce((byte) 8)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f42012d = unmodifiableMap;
        cd.a(b.class, unmodifiableMap);
    }

    public b a(String str) {
        this.f42021a = str;
        return this;
    }

    public void b(boolean z5) {
        this.f42024m = bo.a(this.f42024m, 0, z5);
    }

    public void c(boolean z5) {
        this.f42024m = bo.a(this.f42024m, 1, z5);
    }

    public boolean d() {
        return this.f42021a != null;
    }

    public long e() {
        return this.f42022b;
    }

    public void f() {
        this.f42024m = bo.b(this.f42024m, 0);
    }

    public boolean g() {
        return bo.a(this.f42024m, 0);
    }

    public int h() {
        return this.f42023c;
    }

    public void i() {
        this.f42024m = bo.b(this.f42024m, 1);
    }

    public boolean j() {
        return bo.a(this.f42024m, 1);
    }

    public void k() throws bx {
        if (this.f42021a != null) {
            return;
        }
        throw new cr("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f42018j.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f42021a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f42022b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f42023c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f42018j.get(cqVar.D()).b().a(cqVar, this);
    }

    public b(String str, long j6, int i6) {
        this();
        this.f42021a = str;
        this.f42022b = j6;
        b(true);
        this.f42023c = i6;
        c(true);
    }

    public void a(boolean z5) {
        if (z5) {
            return;
        }
        this.f42021a = null;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i6) {
        return e.a(i6);
    }

    public b a(long j6) {
        this.f42022b = j6;
        b(true);
        return this;
    }

    public b a(int i6) {
        this.f42023c = i6;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ck(new dc(objectOutputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }

    public b(b bVar) {
        this.f42024m = (byte) 0;
        this.f42024m = bVar.f42024m;
        if (bVar.d()) {
            this.f42021a = bVar.f42021a;
        }
        this.f42022b = bVar.f42022b;
        this.f42023c = bVar.f42023c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f42024m = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }
}
