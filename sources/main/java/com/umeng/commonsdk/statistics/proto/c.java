package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ci;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.cm;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c implements br<c, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, cd> f42032d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f42033e = -5764118265293965743L;

    /* renamed from: f, reason: collision with root package name */
    private static final cv f42034f = new cv("IdTracking");

    /* renamed from: g, reason: collision with root package name */
    private static final cl f42035g = new cl("snapshots", (byte) 13, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final cl f42036h = new cl("journals", (byte) 15, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final cl f42037i = new cl("checksum", (byte) 11, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f42038j;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f42039a;

    /* renamed from: b, reason: collision with root package name */
    public List<com.umeng.commonsdk.statistics.proto.a> f42040b;

    /* renamed from: c, reason: collision with root package name */
    public String f42041c;

    /* renamed from: k, reason: collision with root package name */
    private e[] f42042k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends da<c> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cq cqVar, c cVar) throws bx {
            cqVar.j();
            while (true) {
                cl l6 = cqVar.l();
                byte b6 = l6.f41141b;
                if (b6 == 0) {
                    cqVar.k();
                    cVar.n();
                    return;
                }
                short s5 = l6.f41142c;
                int i6 = 0;
                if (s5 != 1) {
                    if (s5 != 2) {
                        if (s5 != 3) {
                            ct.a(cqVar, b6);
                        } else if (b6 == 11) {
                            cVar.f42041c = cqVar.z();
                            cVar.c(true);
                        } else {
                            ct.a(cqVar, b6);
                        }
                    } else if (b6 == 15) {
                        cm p5 = cqVar.p();
                        cVar.f42040b = new ArrayList(p5.f41144b);
                        while (i6 < p5.f41144b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(cqVar);
                            cVar.f42040b.add(aVar);
                            i6++;
                        }
                        cqVar.q();
                        cVar.b(true);
                    } else {
                        ct.a(cqVar, b6);
                    }
                } else if (b6 == 13) {
                    cn n6 = cqVar.n();
                    cVar.f42039a = new HashMap(n6.f41147c * 2);
                    while (i6 < n6.f41147c) {
                        String z5 = cqVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(cqVar);
                        cVar.f42039a.put(z5, bVar);
                        i6++;
                    }
                    cqVar.o();
                    cVar.a(true);
                } else {
                    ct.a(cqVar, b6);
                }
                cqVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cq cqVar, c cVar) throws bx {
            cVar.n();
            cqVar.a(c.f42034f);
            if (cVar.f42039a != null) {
                cqVar.a(c.f42035g);
                cqVar.a(new cn((byte) 11, (byte) 12, cVar.f42039a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f42039a.entrySet()) {
                    cqVar.a(entry.getKey());
                    entry.getValue().write(cqVar);
                }
                cqVar.e();
                cqVar.c();
            }
            if (cVar.f42040b != null && cVar.j()) {
                cqVar.a(c.f42036h);
                cqVar.a(new cm((byte) 12, cVar.f42040b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f42040b.iterator();
                while (it.hasNext()) {
                    it.next().write(cqVar);
                }
                cqVar.f();
                cqVar.c();
            }
            if (cVar.f42041c != null && cVar.m()) {
                cqVar.a(c.f42037i);
                cqVar.a(cVar.f42041c);
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
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    private static class C0832c extends db<c> {
        private C0832c() {
        }

        /* synthetic */ C0832c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, c cVar) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(cVar.f42039a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f42039a.entrySet()) {
                cwVar.a(entry.getKey());
                entry.getValue().write(cwVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            cwVar.a(bitSet, 2);
            if (cVar.j()) {
                cwVar.a(cVar.f42040b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f42040b.iterator();
                while (it.hasNext()) {
                    it.next().write(cwVar);
                }
            }
            if (cVar.m()) {
                cwVar.a(cVar.f42041c);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, c cVar) throws bx {
            cw cwVar = (cw) cqVar;
            cn cnVar = new cn((byte) 11, (byte) 12, cwVar.w());
            cVar.f42039a = new HashMap(cnVar.f41147c * 2);
            for (int i6 = 0; i6 < cnVar.f41147c; i6++) {
                String z5 = cwVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(cwVar);
                cVar.f42039a.put(z5, bVar);
            }
            cVar.a(true);
            BitSet b6 = cwVar.b(2);
            if (b6.get(0)) {
                cm cmVar = new cm((byte) 12, cwVar.w());
                cVar.f42040b = new ArrayList(cmVar.f41144b);
                for (int i7 = 0; i7 < cmVar.f41144b; i7++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(cwVar);
                    cVar.f42040b.add(aVar);
                }
                cVar.b(true);
            }
            if (b6.get(1)) {
                cVar.f42041c = cwVar.z();
                cVar.c(true);
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
        public C0832c b() {
            return new C0832c(null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum e implements by {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f42046d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f42048e;

        /* renamed from: f, reason: collision with root package name */
        private final String f42049f;

        public static e a(int i6) {
            if (i6 == 1) {
                return SNAPSHOTS;
            }
            if (i6 == 2) {
                return JOURNALS;
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
                f42046d.put(eVar.b(), eVar);
            }
        }

        e(short s5, String str) {
            this.f42048e = s5;
            this.f42049f = str;
        }

        @Override // com.umeng.analytics.pro.by
        public String b() {
            return this.f42049f;
        }

        public static e a(String str) {
            return f42046d.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f42048e;
        }
    }

    public c() {
        this.f42042k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f42039a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f42039a;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f42039a = null;
        this.f42040b = null;
        this.f42041c = null;
    }

    public void d() {
        this.f42039a = null;
    }

    public void i() {
        this.f42040b = null;
    }

    public void l() {
        this.f42041c = null;
    }

    static {
        HashMap hashMap = new HashMap();
        f42038j = hashMap;
        AnonymousClass1 anonymousClass1 = null;
        hashMap.put(da.class, new b(anonymousClass1));
        hashMap.put(db.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new cd("snapshots", (byte) 1, new cg((byte) 13, new ce((byte) 11), new ci((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new cd("journals", (byte) 2, new cf((byte) 15, new ci((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cd("checksum", (byte) 2, new ce((byte) 11)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f42032d = unmodifiableMap;
        cd.a(c.class, unmodifiableMap);
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f42039a == null) {
            this.f42039a = new HashMap();
        }
        this.f42039a.put(str, bVar);
    }

    public void b(boolean z5) {
        if (z5) {
            return;
        }
        this.f42040b = null;
    }

    public void c(boolean z5) {
        if (z5) {
            return;
        }
        this.f42041c = null;
    }

    public boolean e() {
        return this.f42039a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f42040b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f42040b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f42040b;
    }

    public boolean j() {
        return this.f42040b != null;
    }

    public String k() {
        return this.f42041c;
    }

    public boolean m() {
        return this.f42041c != null;
    }

    public void n() throws bx {
        if (this.f42039a != null) {
            return;
        }
        throw new cr("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f42038j.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f42039a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f42040b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f42041c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f42038j.get(cqVar.D()).b().a(cqVar, this);
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f42039a = map;
    }

    public c(c cVar) {
        this.f42042k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f42039a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f42039a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f42040b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.f42040b = arrayList;
        }
        if (cVar.m()) {
            this.f42041c = cVar.f42041c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f42039a = map;
        return this;
    }

    public void a(boolean z5) {
        if (z5) {
            return;
        }
        this.f42039a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f42040b == null) {
            this.f42040b = new ArrayList();
        }
        this.f42040b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f42040b = list;
        return this;
    }

    public c a(String str) {
        this.f42041c = str;
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

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new ck(new dc(objectInputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }
}
