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
public class e implements br<e, EnumC0834e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<EnumC0834e, cd> f42069d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f42070e = 7501688097813630241L;

    /* renamed from: f, reason: collision with root package name */
    private static final cv f42071f = new cv("ImprintValue");

    /* renamed from: g, reason: collision with root package name */
    private static final cl f42072g = new cl("value", (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final cl f42073h = new cl("ts", (byte) 10, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final cl f42074i = new cl("guid", (byte) 11, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f42075j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f42076k = 0;

    /* renamed from: a, reason: collision with root package name */
    public String f42077a;

    /* renamed from: b, reason: collision with root package name */
    public long f42078b;

    /* renamed from: c, reason: collision with root package name */
    public String f42079c;

    /* renamed from: l, reason: collision with root package name */
    private byte f42080l;

    /* renamed from: m, reason: collision with root package name */
    private EnumC0834e[] f42081m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends da<e> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cq cqVar, e eVar) throws bx {
            cqVar.j();
            while (true) {
                cl l6 = cqVar.l();
                byte b6 = l6.f41141b;
                if (b6 == 0) {
                    cqVar.k();
                    eVar.k();
                    return;
                }
                short s5 = l6.f41142c;
                if (s5 != 1) {
                    if (s5 != 2) {
                        if (s5 != 3) {
                            ct.a(cqVar, b6);
                        } else if (b6 == 11) {
                            eVar.f42079c = cqVar.z();
                            eVar.c(true);
                        } else {
                            ct.a(cqVar, b6);
                        }
                    } else if (b6 == 10) {
                        eVar.f42078b = cqVar.x();
                        eVar.b(true);
                    } else {
                        ct.a(cqVar, b6);
                    }
                } else if (b6 == 11) {
                    eVar.f42077a = cqVar.z();
                    eVar.a(true);
                } else {
                    ct.a(cqVar, b6);
                }
                cqVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cq cqVar, e eVar) throws bx {
            eVar.k();
            cqVar.a(e.f42071f);
            if (eVar.f42077a != null && eVar.d()) {
                cqVar.a(e.f42072g);
                cqVar.a(eVar.f42077a);
                cqVar.c();
            }
            if (eVar.g()) {
                cqVar.a(e.f42073h);
                cqVar.a(eVar.f42078b);
                cqVar.c();
            }
            if (eVar.f42079c != null && eVar.j()) {
                cqVar.a(e.f42074i);
                cqVar.a(eVar.f42079c);
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
    private static class c extends db<e> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, e eVar) throws bx {
            cw cwVar = (cw) cqVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            cwVar.a(bitSet, 3);
            if (eVar.d()) {
                cwVar.a(eVar.f42077a);
            }
            if (eVar.g()) {
                cwVar.a(eVar.f42078b);
            }
            if (eVar.j()) {
                cwVar.a(eVar.f42079c);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, e eVar) throws bx {
            cw cwVar = (cw) cqVar;
            BitSet b6 = cwVar.b(3);
            if (b6.get(0)) {
                eVar.f42077a = cwVar.z();
                eVar.a(true);
            }
            if (b6.get(1)) {
                eVar.f42078b = cwVar.x();
                eVar.b(true);
            }
            if (b6.get(2)) {
                eVar.f42079c = cwVar.z();
                eVar.c(true);
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
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    public enum EnumC0834e implements by {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, EnumC0834e> f42085d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f42087e;

        /* renamed from: f, reason: collision with root package name */
        private final String f42088f;

        public static EnumC0834e a(int i6) {
            if (i6 == 1) {
                return VALUE;
            }
            if (i6 == 2) {
                return TS;
            }
            if (i6 != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0834e b(int i6) {
            EnumC0834e a6 = a(i6);
            if (a6 != null) {
                return a6;
            }
            throw new IllegalArgumentException("Field " + i6 + " doesn't exist!");
        }

        static {
            Iterator it = EnumSet.allOf(EnumC0834e.class).iterator();
            while (it.hasNext()) {
                EnumC0834e enumC0834e = (EnumC0834e) it.next();
                f42085d.put(enumC0834e.b(), enumC0834e);
            }
        }

        EnumC0834e(short s5, String str) {
            this.f42087e = s5;
            this.f42088f = str;
        }

        @Override // com.umeng.analytics.pro.by
        public String b() {
            return this.f42088f;
        }

        public static EnumC0834e a(String str) {
            return f42085d.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f42087e;
        }
    }

    public e() {
        this.f42080l = (byte) 0;
        this.f42081m = new EnumC0834e[]{EnumC0834e.VALUE, EnumC0834e.TS, EnumC0834e.GUID};
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.f42077a;
    }

    public void c() {
        this.f42077a = null;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f42077a = null;
        b(false);
        this.f42078b = 0L;
        this.f42079c = null;
    }

    public void i() {
        this.f42079c = null;
    }

    static {
        HashMap hashMap = new HashMap();
        f42075j = hashMap;
        AnonymousClass1 anonymousClass1 = null;
        hashMap.put(da.class, new b(anonymousClass1));
        hashMap.put(db.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(EnumC0834e.class);
        enumMap.put((EnumMap) EnumC0834e.VALUE, (EnumC0834e) new cd("value", (byte) 2, new ce((byte) 11)));
        enumMap.put((EnumMap) EnumC0834e.TS, (EnumC0834e) new cd("ts", (byte) 2, new ce((byte) 10)));
        enumMap.put((EnumMap) EnumC0834e.GUID, (EnumC0834e) new cd("guid", (byte) 2, new ce((byte) 11)));
        Map<EnumC0834e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f42069d = unmodifiableMap;
        cd.a(e.class, unmodifiableMap);
    }

    public e a(String str) {
        this.f42077a = str;
        return this;
    }

    public void b(boolean z5) {
        this.f42080l = bo.a(this.f42080l, 0, z5);
    }

    public void c(boolean z5) {
        if (z5) {
            return;
        }
        this.f42079c = null;
    }

    public boolean d() {
        return this.f42077a != null;
    }

    public long e() {
        return this.f42078b;
    }

    public void f() {
        this.f42080l = bo.b(this.f42080l, 0);
    }

    public boolean g() {
        return bo.a(this.f42080l, 0);
    }

    public String h() {
        return this.f42079c;
    }

    public boolean j() {
        return this.f42079c != null;
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f42075j.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f42077a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f42078b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f42079c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f42075j.get(cqVar.D()).b().a(cqVar, this);
    }

    public void a(boolean z5) {
        if (z5) {
            return;
        }
        this.f42077a = null;
    }

    public e b(String str) {
        this.f42079c = str;
        return this;
    }

    public e(long j6, String str) {
        this();
        this.f42078b = j6;
        b(true);
        this.f42079c = str;
    }

    public e a(long j6) {
        this.f42078b = j6;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0834e fieldForId(int i6) {
        return EnumC0834e.a(i6);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ck(new dc(objectOutputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }

    public e(e eVar) {
        this.f42080l = (byte) 0;
        this.f42081m = new EnumC0834e[]{EnumC0834e.VALUE, EnumC0834e.TS, EnumC0834e.GUID};
        this.f42080l = eVar.f42080l;
        if (eVar.d()) {
            this.f42077a = eVar.f42077a;
        }
        this.f42078b = eVar.f42078b;
        if (eVar.j()) {
            this.f42079c = eVar.f42079c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f42080l = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }

    public void k() throws bx {
    }
}
