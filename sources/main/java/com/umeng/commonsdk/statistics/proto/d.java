package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ci;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.cn;
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
public class d implements br<d, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, cd> f42050d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f42051e = 2846460275012375038L;

    /* renamed from: f, reason: collision with root package name */
    private static final cv f42052f = new cv("Imprint");

    /* renamed from: g, reason: collision with root package name */
    private static final cl f42053g = new cl("property", (byte) 13, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final cl f42054h = new cl("version", (byte) 8, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final cl f42055i = new cl("checksum", (byte) 11, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f42056j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f42057k = 0;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f42058a;

    /* renamed from: b, reason: collision with root package name */
    public int f42059b;

    /* renamed from: c, reason: collision with root package name */
    public String f42060c;

    /* renamed from: l, reason: collision with root package name */
    private byte f42061l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends da<d> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cq cqVar, d dVar) throws bx {
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
                        } else if (b6 == 11) {
                            dVar.f42060c = cqVar.z();
                            dVar.c(true);
                        } else {
                            ct.a(cqVar, b6);
                        }
                    } else if (b6 == 8) {
                        dVar.f42059b = cqVar.w();
                        dVar.b(true);
                    } else {
                        ct.a(cqVar, b6);
                    }
                } else if (b6 == 13) {
                    cn n6 = cqVar.n();
                    dVar.f42058a = new HashMap(n6.f41147c * 2);
                    for (int i6 = 0; i6 < n6.f41147c; i6++) {
                        String z5 = cqVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(cqVar);
                        dVar.f42058a.put(z5, eVar);
                    }
                    cqVar.o();
                    dVar.a(true);
                } else {
                    ct.a(cqVar, b6);
                }
                cqVar.m();
            }
            cqVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new cr("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cq cqVar, d dVar) throws bx {
            dVar.l();
            cqVar.a(d.f42052f);
            if (dVar.f42058a != null) {
                cqVar.a(d.f42053g);
                cqVar.a(new cn((byte) 11, (byte) 12, dVar.f42058a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f42058a.entrySet()) {
                    cqVar.a(entry.getKey());
                    entry.getValue().write(cqVar);
                }
                cqVar.e();
                cqVar.c();
            }
            cqVar.a(d.f42054h);
            cqVar.a(dVar.f42059b);
            cqVar.c();
            if (dVar.f42060c != null) {
                cqVar.a(d.f42055i);
                cqVar.a(dVar.f42060c);
                cqVar.c();
            }
            cqVar.d();
            cqVar.b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements cz {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends db<d> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, d dVar) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(dVar.f42058a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f42058a.entrySet()) {
                cwVar.a(entry.getKey());
                entry.getValue().write(cwVar);
            }
            cwVar.a(dVar.f42059b);
            cwVar.a(dVar.f42060c);
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, d dVar) throws bx {
            cw cwVar = (cw) cqVar;
            cn cnVar = new cn((byte) 11, (byte) 12, cwVar.w());
            dVar.f42058a = new HashMap(cnVar.f41147c * 2);
            for (int i6 = 0; i6 < cnVar.f41147c; i6++) {
                String z5 = cwVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(cwVar);
                dVar.f42058a.put(z5, eVar);
            }
            dVar.a(true);
            dVar.f42059b = cwVar.w();
            dVar.b(true);
            dVar.f42060c = cwVar.z();
            dVar.c(true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    private static class C0833d implements cz {
        private C0833d() {
        }

        /* synthetic */ C0833d(AnonymousClass1 anonymousClass1) {
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
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f42065d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f42067e;

        /* renamed from: f, reason: collision with root package name */
        private final String f42068f;

        public static e a(int i6) {
            if (i6 == 1) {
                return PROPERTY;
            }
            if (i6 == 2) {
                return VERSION;
            }
            if (i6 != 3) {
                return null;
            }
            return CHECKSUM;
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
                f42065d.put(eVar.b(), eVar);
            }
        }

        e(short s5, String str) {
            this.f42067e = s5;
            this.f42068f = str;
        }

        @Override // com.umeng.analytics.pro.by
        public String b() {
            return this.f42068f;
        }

        public static e a(String str) {
            return f42065d.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f42067e;
        }
    }

    public d() {
        this.f42061l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f42058a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f42058a;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f42058a = null;
        b(false);
        this.f42059b = 0;
        this.f42060c = null;
    }

    public void d() {
        this.f42058a = null;
    }

    public void j() {
        this.f42060c = null;
    }

    static {
        HashMap hashMap = new HashMap();
        f42056j = hashMap;
        AnonymousClass1 anonymousClass1 = null;
        hashMap.put(da.class, new b(anonymousClass1));
        hashMap.put(db.class, new C0833d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new cd("property", (byte) 1, new cg((byte) 13, new ce((byte) 11), new ci((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new cd("version", (byte) 1, new ce((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cd("checksum", (byte) 1, new ce((byte) 11)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f42050d = unmodifiableMap;
        cd.a(d.class, unmodifiableMap);
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f42058a == null) {
            this.f42058a = new HashMap();
        }
        this.f42058a.put(str, eVar);
    }

    public void b(boolean z5) {
        this.f42061l = bo.a(this.f42061l, 0, z5);
    }

    public void c(boolean z5) {
        if (z5) {
            return;
        }
        this.f42060c = null;
    }

    public boolean e() {
        return this.f42058a != null;
    }

    public int f() {
        return this.f42059b;
    }

    public void g() {
        this.f42061l = bo.b(this.f42061l, 0);
    }

    public boolean h() {
        return bo.a(this.f42061l, 0);
    }

    public String i() {
        return this.f42060c;
    }

    public boolean k() {
        return this.f42060c != null;
    }

    public void l() throws bx {
        if (this.f42058a == null) {
            throw new cr("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f42060c != null) {
            return;
        }
        throw new cr("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f42056j.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f42058a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f42059b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f42060c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f42056j.get(cqVar.D()).b().a(cqVar, this);
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i6, String str) {
        this();
        this.f42058a = map;
        this.f42059b = i6;
        b(true);
        this.f42060c = str;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i6) {
        return e.a(i6);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f42058a = map;
        return this;
    }

    public void a(boolean z5) {
        if (z5) {
            return;
        }
        this.f42058a = null;
    }

    public d a(int i6) {
        this.f42059b = i6;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f42061l = (byte) 0;
        this.f42061l = dVar.f42061l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f42058a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f42058a = hashMap;
        }
        this.f42059b = dVar.f42059b;
        if (dVar.k()) {
            this.f42060c = dVar.f42060c;
        }
    }

    public d a(String str) {
        this.f42060c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ck(new dc(objectOutputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f42061l = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }
}
