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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a implements br<a, e>, Serializable, Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public static final Map<e, cd> f41989e;

    /* renamed from: f, reason: collision with root package name */
    private static final long f41990f = 9132678615281394583L;

    /* renamed from: g, reason: collision with root package name */
    private static final cv f41991g = new cv("IdJournal");

    /* renamed from: h, reason: collision with root package name */
    private static final cl f41992h = new cl("domain", (byte) 11, 1);

    /* renamed from: i, reason: collision with root package name */
    private static final cl f41993i = new cl("old_id", (byte) 11, 2);

    /* renamed from: j, reason: collision with root package name */
    private static final cl f41994j = new cl("new_id", (byte) 11, 3);

    /* renamed from: k, reason: collision with root package name */
    private static final cl f41995k = new cl("ts", (byte) 10, 4);

    /* renamed from: l, reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f41996l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f41997m = 0;

    /* renamed from: a, reason: collision with root package name */
    public String f41998a;

    /* renamed from: b, reason: collision with root package name */
    public String f41999b;

    /* renamed from: c, reason: collision with root package name */
    public String f42000c;

    /* renamed from: d, reason: collision with root package name */
    public long f42001d;

    /* renamed from: n, reason: collision with root package name */
    private byte f42002n;

    /* renamed from: o, reason: collision with root package name */
    private e[] f42003o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    private static class C0830a extends da<a> {
        private C0830a() {
        }

        /* synthetic */ C0830a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cq cqVar, a aVar) throws bx {
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
                            if (s5 != 4) {
                                ct.a(cqVar, b6);
                            } else if (b6 == 10) {
                                aVar.f42001d = cqVar.x();
                                aVar.d(true);
                            } else {
                                ct.a(cqVar, b6);
                            }
                        } else if (b6 == 11) {
                            aVar.f42000c = cqVar.z();
                            aVar.c(true);
                        } else {
                            ct.a(cqVar, b6);
                        }
                    } else if (b6 == 11) {
                        aVar.f41999b = cqVar.z();
                        aVar.b(true);
                    } else {
                        ct.a(cqVar, b6);
                    }
                } else if (b6 == 11) {
                    aVar.f41998a = cqVar.z();
                    aVar.a(true);
                } else {
                    ct.a(cqVar, b6);
                }
                cqVar.m();
            }
            cqVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new cr("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cq cqVar, a aVar) throws bx {
            aVar.n();
            cqVar.a(a.f41991g);
            if (aVar.f41998a != null) {
                cqVar.a(a.f41992h);
                cqVar.a(aVar.f41998a);
                cqVar.c();
            }
            if (aVar.f41999b != null && aVar.g()) {
                cqVar.a(a.f41993i);
                cqVar.a(aVar.f41999b);
                cqVar.c();
            }
            if (aVar.f42000c != null) {
                cqVar.a(a.f41994j);
                cqVar.a(aVar.f42000c);
                cqVar.c();
            }
            cqVar.a(a.f41995k);
            cqVar.a(aVar.f42001d);
            cqVar.c();
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
        public C0830a b() {
            return new C0830a(null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends db<a> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, a aVar) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(aVar.f41998a);
            cwVar.a(aVar.f42000c);
            cwVar.a(aVar.f42001d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            cwVar.a(bitSet, 1);
            if (aVar.g()) {
                cwVar.a(aVar.f41999b);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, a aVar) throws bx {
            cw cwVar = (cw) cqVar;
            aVar.f41998a = cwVar.z();
            aVar.a(true);
            aVar.f42000c = cwVar.z();
            aVar.c(true);
            aVar.f42001d = cwVar.x();
            aVar.d(true);
            if (cwVar.b(1).get(0)) {
                aVar.f41999b = cwVar.z();
                aVar.b(true);
            }
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
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* renamed from: e, reason: collision with root package name */
        private static final Map<String, e> f42008e = new HashMap();

        /* renamed from: f, reason: collision with root package name */
        private final short f42010f;

        /* renamed from: g, reason: collision with root package name */
        private final String f42011g;

        public static e a(int i6) {
            if (i6 == 1) {
                return DOMAIN;
            }
            if (i6 == 2) {
                return OLD_ID;
            }
            if (i6 == 3) {
                return NEW_ID;
            }
            if (i6 != 4) {
                return null;
            }
            return TS;
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
                f42008e.put(eVar.b(), eVar);
            }
        }

        e(short s5, String str) {
            this.f42010f = s5;
            this.f42011g = str;
        }

        @Override // com.umeng.analytics.pro.by
        public String b() {
            return this.f42011g;
        }

        public static e a(String str) {
            return f42008e.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f42010f;
        }
    }

    public a() {
        this.f42002n = (byte) 0;
        this.f42003o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f41998a;
    }

    public void c() {
        this.f41998a = null;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f41998a = null;
        this.f41999b = null;
        this.f42000c = null;
        d(false);
        this.f42001d = 0L;
    }

    public boolean d() {
        return this.f41998a != null;
    }

    public void f() {
        this.f41999b = null;
    }

    public void i() {
        this.f42000c = null;
    }

    static {
        HashMap hashMap = new HashMap();
        f41996l = hashMap;
        AnonymousClass1 anonymousClass1 = null;
        hashMap.put(da.class, new b(anonymousClass1));
        hashMap.put(db.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new cd("domain", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new cd("old_id", (byte) 2, new ce((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new cd("new_id", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new cd("ts", (byte) 1, new ce((byte) 10)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f41989e = unmodifiableMap;
        cd.a(a.class, unmodifiableMap);
    }

    public a a(String str) {
        this.f41998a = str;
        return this;
    }

    public a b(String str) {
        this.f41999b = str;
        return this;
    }

    public a c(String str) {
        this.f42000c = str;
        return this;
    }

    public void d(boolean z5) {
        this.f42002n = bo.a(this.f42002n, 0, z5);
    }

    public String e() {
        return this.f41999b;
    }

    public boolean g() {
        return this.f41999b != null;
    }

    public String h() {
        return this.f42000c;
    }

    public boolean j() {
        return this.f42000c != null;
    }

    public long k() {
        return this.f42001d;
    }

    public void l() {
        this.f42002n = bo.b(this.f42002n, 0);
    }

    public boolean m() {
        return bo.a(this.f42002n, 0);
    }

    public void n() throws bx {
        if (this.f41998a == null) {
            throw new cr("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f42000c != null) {
            return;
        }
        throw new cr("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f41996l.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f41998a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f41999b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f42000c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f42001d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f41996l.get(cqVar.D()).b().a(cqVar, this);
    }

    public void a(boolean z5) {
        if (z5) {
            return;
        }
        this.f41998a = null;
    }

    public void b(boolean z5) {
        if (z5) {
            return;
        }
        this.f41999b = null;
    }

    public void c(boolean z5) {
        if (z5) {
            return;
        }
        this.f42000c = null;
    }

    public a(String str, String str2, long j6) {
        this();
        this.f41998a = str;
        this.f42000c = str2;
        this.f42001d = j6;
        d(true);
    }

    public a a(long j6) {
        this.f42001d = j6;
        d(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i6) {
        return e.a(i6);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ck(new dc(objectOutputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }

    public a(a aVar) {
        this.f42002n = (byte) 0;
        this.f42003o = new e[]{e.OLD_ID};
        this.f42002n = aVar.f42002n;
        if (aVar.d()) {
            this.f41998a = aVar.f41998a;
        }
        if (aVar.g()) {
            this.f41999b = aVar.f41999b;
        }
        if (aVar.j()) {
            this.f42000c = aVar.f42000c;
        }
        this.f42001d = aVar.f42001d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f42002n = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }
}
