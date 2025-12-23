package com.umeng.analytics.pro;

import com.tencent.open.SocialOperation;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class bj implements br<bj, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* renamed from: k, reason: collision with root package name */
    public static final Map<e, cd> f40984k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f40985l = 420342210744516016L;

    /* renamed from: m, reason: collision with root package name */
    private static final cv f40986m = new cv("UMEnvelope");

    /* renamed from: n, reason: collision with root package name */
    private static final cl f40987n = new cl("version", (byte) 11, 1);

    /* renamed from: o, reason: collision with root package name */
    private static final cl f40988o = new cl("address", (byte) 11, 2);

    /* renamed from: p, reason: collision with root package name */
    private static final cl f40989p = new cl(SocialOperation.GAME_SIGNATURE, (byte) 11, 3);

    /* renamed from: q, reason: collision with root package name */
    private static final cl f40990q = new cl("serial_num", (byte) 8, 4);

    /* renamed from: r, reason: collision with root package name */
    private static final cl f40991r = new cl("ts_secs", (byte) 8, 5);

    /* renamed from: s, reason: collision with root package name */
    private static final cl f40992s = new cl("length", (byte) 8, 6);

    /* renamed from: t, reason: collision with root package name */
    private static final cl f40993t = new cl("entity", (byte) 11, 7);

    /* renamed from: u, reason: collision with root package name */
    private static final cl f40994u = new cl("guid", (byte) 11, 8);

    /* renamed from: v, reason: collision with root package name */
    private static final cl f40995v = new cl("checksum", (byte) 11, 9);

    /* renamed from: w, reason: collision with root package name */
    private static final cl f40996w = new cl("codex", (byte) 8, 10);

    /* renamed from: x, reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f40997x;

    /* renamed from: y, reason: collision with root package name */
    private static final int f40998y = 0;

    /* renamed from: z, reason: collision with root package name */
    private static final int f40999z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a, reason: collision with root package name */
    public String f41000a;

    /* renamed from: b, reason: collision with root package name */
    public String f41001b;

    /* renamed from: c, reason: collision with root package name */
    public String f41002c;

    /* renamed from: d, reason: collision with root package name */
    public int f41003d;

    /* renamed from: e, reason: collision with root package name */
    public int f41004e;

    /* renamed from: f, reason: collision with root package name */
    public int f41005f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f41006g;

    /* renamed from: h, reason: collision with root package name */
    public String f41007h;

    /* renamed from: i, reason: collision with root package name */
    public String f41008i;

    /* renamed from: j, reason: collision with root package name */
    public int f41009j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.bj$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends da<bj> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cq cqVar, bj bjVar) throws bx {
            cqVar.j();
            while (true) {
                cl l6 = cqVar.l();
                byte b6 = l6.f41141b;
                if (b6 == 0) {
                    cqVar.k();
                    if (!bjVar.m()) {
                        throw new cr("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!bjVar.p()) {
                        throw new cr("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (bjVar.s()) {
                        bjVar.G();
                        return;
                    }
                    throw new cr("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (l6.f41142c) {
                    case 1:
                        if (b6 != 11) {
                            ct.a(cqVar, b6);
                            break;
                        } else {
                            bjVar.f41000a = cqVar.z();
                            bjVar.a(true);
                            break;
                        }
                    case 2:
                        if (b6 != 11) {
                            ct.a(cqVar, b6);
                            break;
                        } else {
                            bjVar.f41001b = cqVar.z();
                            bjVar.b(true);
                            break;
                        }
                    case 3:
                        if (b6 != 11) {
                            ct.a(cqVar, b6);
                            break;
                        } else {
                            bjVar.f41002c = cqVar.z();
                            bjVar.c(true);
                            break;
                        }
                    case 4:
                        if (b6 != 8) {
                            ct.a(cqVar, b6);
                            break;
                        } else {
                            bjVar.f41003d = cqVar.w();
                            bjVar.d(true);
                            break;
                        }
                    case 5:
                        if (b6 != 8) {
                            ct.a(cqVar, b6);
                            break;
                        } else {
                            bjVar.f41004e = cqVar.w();
                            bjVar.e(true);
                            break;
                        }
                    case 6:
                        if (b6 != 8) {
                            ct.a(cqVar, b6);
                            break;
                        } else {
                            bjVar.f41005f = cqVar.w();
                            bjVar.f(true);
                            break;
                        }
                    case 7:
                        if (b6 != 11) {
                            ct.a(cqVar, b6);
                            break;
                        } else {
                            bjVar.f41006g = cqVar.A();
                            bjVar.g(true);
                            break;
                        }
                    case 8:
                        if (b6 != 11) {
                            ct.a(cqVar, b6);
                            break;
                        } else {
                            bjVar.f41007h = cqVar.z();
                            bjVar.h(true);
                            break;
                        }
                    case 9:
                        if (b6 != 11) {
                            ct.a(cqVar, b6);
                            break;
                        } else {
                            bjVar.f41008i = cqVar.z();
                            bjVar.i(true);
                            break;
                        }
                    case 10:
                        if (b6 != 8) {
                            ct.a(cqVar, b6);
                            break;
                        } else {
                            bjVar.f41009j = cqVar.w();
                            bjVar.j(true);
                            break;
                        }
                    default:
                        ct.a(cqVar, b6);
                        break;
                }
                cqVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cq cqVar, bj bjVar) throws bx {
            bjVar.G();
            cqVar.a(bj.f40986m);
            if (bjVar.f41000a != null) {
                cqVar.a(bj.f40987n);
                cqVar.a(bjVar.f41000a);
                cqVar.c();
            }
            if (bjVar.f41001b != null) {
                cqVar.a(bj.f40988o);
                cqVar.a(bjVar.f41001b);
                cqVar.c();
            }
            if (bjVar.f41002c != null) {
                cqVar.a(bj.f40989p);
                cqVar.a(bjVar.f41002c);
                cqVar.c();
            }
            cqVar.a(bj.f40990q);
            cqVar.a(bjVar.f41003d);
            cqVar.c();
            cqVar.a(bj.f40991r);
            cqVar.a(bjVar.f41004e);
            cqVar.c();
            cqVar.a(bj.f40992s);
            cqVar.a(bjVar.f41005f);
            cqVar.c();
            if (bjVar.f41006g != null) {
                cqVar.a(bj.f40993t);
                cqVar.a(bjVar.f41006g);
                cqVar.c();
            }
            if (bjVar.f41007h != null) {
                cqVar.a(bj.f40994u);
                cqVar.a(bjVar.f41007h);
                cqVar.c();
            }
            if (bjVar.f41008i != null) {
                cqVar.a(bj.f40995v);
                cqVar.a(bjVar.f41008i);
                cqVar.c();
            }
            if (bjVar.F()) {
                cqVar.a(bj.f40996w);
                cqVar.a(bjVar.f41009j);
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
    private static class c extends db<bj> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, bj bjVar) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(bjVar.f41000a);
            cwVar.a(bjVar.f41001b);
            cwVar.a(bjVar.f41002c);
            cwVar.a(bjVar.f41003d);
            cwVar.a(bjVar.f41004e);
            cwVar.a(bjVar.f41005f);
            cwVar.a(bjVar.f41006g);
            cwVar.a(bjVar.f41007h);
            cwVar.a(bjVar.f41008i);
            BitSet bitSet = new BitSet();
            if (bjVar.F()) {
                bitSet.set(0);
            }
            cwVar.a(bitSet, 1);
            if (bjVar.F()) {
                cwVar.a(bjVar.f41009j);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, bj bjVar) throws bx {
            cw cwVar = (cw) cqVar;
            bjVar.f41000a = cwVar.z();
            bjVar.a(true);
            bjVar.f41001b = cwVar.z();
            bjVar.b(true);
            bjVar.f41002c = cwVar.z();
            bjVar.c(true);
            bjVar.f41003d = cwVar.w();
            bjVar.d(true);
            bjVar.f41004e = cwVar.w();
            bjVar.e(true);
            bjVar.f41005f = cwVar.w();
            bjVar.f(true);
            bjVar.f41006g = cwVar.A();
            bjVar.g(true);
            bjVar.f41007h = cwVar.z();
            bjVar.h(true);
            bjVar.f41008i = cwVar.z();
            bjVar.i(true);
            if (cwVar.b(1).get(0)) {
                bjVar.f41009j = cwVar.w();
                bjVar.j(true);
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
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, SocialOperation.GAME_SIGNATURE),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");


        /* renamed from: k, reason: collision with root package name */
        private static final Map<String, e> f41020k = new HashMap();

        /* renamed from: l, reason: collision with root package name */
        private final short f41022l;

        /* renamed from: m, reason: collision with root package name */
        private final String f41023m;

        public static e a(int i6) {
            switch (i6) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
                f41020k.put(eVar.b(), eVar);
            }
        }

        e(short s5, String str) {
            this.f41022l = s5;
            this.f41023m = str;
        }

        @Override // com.umeng.analytics.pro.by
        public String b() {
            return this.f41023m;
        }

        public static e a(String str) {
            return f41020k.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f41022l;
        }
    }

    public bj() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public void B() {
        this.f41008i = null;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bj deepCopy() {
        return new bj(this);
    }

    public String b() {
        return this.f41000a;
    }

    public void c() {
        this.f41000a = null;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f41000a = null;
        this.f41001b = null;
        this.f41002c = null;
        d(false);
        this.f41003d = 0;
        e(false);
        this.f41004e = 0;
        f(false);
        this.f41005f = 0;
        this.f41006g = null;
        this.f41007h = null;
        this.f41008i = null;
        j(false);
        this.f41009j = 0;
    }

    public boolean d() {
        return this.f41000a != null;
    }

    public String e() {
        return this.f41001b;
    }

    public void f() {
        this.f41001b = null;
    }

    public boolean g() {
        return this.f41001b != null;
    }

    public String h() {
        return this.f41002c;
    }

    public void i() {
        this.f41002c = null;
    }

    public boolean j() {
        return this.f41002c != null;
    }

    public void v() {
        this.f41006g = null;
    }

    public void y() {
        this.f41007h = null;
    }

    static {
        HashMap hashMap = new HashMap();
        f40997x = hashMap;
        AnonymousClass1 anonymousClass1 = null;
        hashMap.put(da.class, new b(anonymousClass1));
        hashMap.put(db.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new cd("version", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new cd("address", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new cd(SocialOperation.GAME_SIGNATURE, (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new cd("serial_num", (byte) 1, new ce((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new cd("ts_secs", (byte) 1, new ce((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new cd("length", (byte) 1, new ce((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new cd("entity", (byte) 1, new ce((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new cd("guid", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cd("checksum", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new cd("codex", (byte) 2, new ce((byte) 8)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f40984k = unmodifiableMap;
        cd.a(bj.class, unmodifiableMap);
    }

    public String A() {
        return this.f41008i;
    }

    public boolean C() {
        return this.f41008i != null;
    }

    public int D() {
        return this.f41009j;
    }

    public void E() {
        this.C = bo.b(this.C, 3);
    }

    public boolean F() {
        return bo.a(this.C, 3);
    }

    public void G() throws bx {
        if (this.f41000a == null) {
            throw new cr("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f41001b == null) {
            throw new cr("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f41002c == null) {
            throw new cr("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.f41006g == null) {
            throw new cr("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.f41007h == null) {
            throw new cr("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.f41008i != null) {
            return;
        }
        throw new cr("Required field 'checksum' was not present! Struct: " + toString());
    }

    public bj a(String str) {
        this.f41000a = str;
        return this;
    }

    public bj b(String str) {
        this.f41001b = str;
        return this;
    }

    public bj c(String str) {
        this.f41002c = str;
        return this;
    }

    public void d(boolean z5) {
        this.C = bo.a(this.C, 0, z5);
    }

    public void e(boolean z5) {
        this.C = bo.a(this.C, 1, z5);
    }

    public void f(boolean z5) {
        this.C = bo.a(this.C, 2, z5);
    }

    public void g(boolean z5) {
        if (z5) {
            return;
        }
        this.f41006g = null;
    }

    public void h(boolean z5) {
        if (z5) {
            return;
        }
        this.f41007h = null;
    }

    public void i(boolean z5) {
        if (z5) {
            return;
        }
        this.f41008i = null;
    }

    public void j(boolean z5) {
        this.C = bo.a(this.C, 3, z5);
    }

    public int k() {
        return this.f41003d;
    }

    public void l() {
        this.C = bo.b(this.C, 0);
    }

    public boolean m() {
        return bo.a(this.C, 0);
    }

    public int n() {
        return this.f41004e;
    }

    public void o() {
        this.C = bo.b(this.C, 1);
    }

    public boolean p() {
        return bo.a(this.C, 1);
    }

    public int q() {
        return this.f41005f;
    }

    public void r() {
        this.C = bo.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f40997x.get(cqVar.D()).b().b(cqVar, this);
    }

    public boolean s() {
        return bo.a(this.C, 2);
    }

    public byte[] t() {
        a(bs.c(this.f41006g));
        ByteBuffer byteBuffer = this.f41006g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f41000a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f41001b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f41002c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f41003d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f41004e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f41005f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f41006g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            bs.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f41007h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f41008i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f41009j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f41006g;
    }

    public boolean w() {
        return this.f41006g != null;
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f40997x.get(cqVar.D()).b().a(cqVar, this);
    }

    public String x() {
        return this.f41007h;
    }

    public boolean z() {
        return this.f41007h != null;
    }

    public void a(boolean z5) {
        if (z5) {
            return;
        }
        this.f41000a = null;
    }

    public void b(boolean z5) {
        if (z5) {
            return;
        }
        this.f41001b = null;
    }

    public void c(boolean z5) {
        if (z5) {
            return;
        }
        this.f41002c = null;
    }

    public bj d(String str) {
        this.f41007h = str;
        return this;
    }

    public bj e(String str) {
        this.f41008i = str;
        return this;
    }

    public bj(String str, String str2, String str3, int i6, int i7, int i8, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f41000a = str;
        this.f41001b = str2;
        this.f41002c = str3;
        this.f41003d = i6;
        d(true);
        this.f41004e = i7;
        e(true);
        this.f41005f = i8;
        f(true);
        this.f41006g = byteBuffer;
        this.f41007h = str4;
        this.f41008i = str5;
    }

    public bj a(int i6) {
        this.f41003d = i6;
        d(true);
        return this;
    }

    public bj b(int i6) {
        this.f41004e = i6;
        e(true);
        return this;
    }

    public bj c(int i6) {
        this.f41005f = i6;
        f(true);
        return this;
    }

    public bj d(int i6) {
        this.f41009j = i6;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i6) {
        return e.a(i6);
    }

    public bj a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public bj a(ByteBuffer byteBuffer) {
        this.f41006g = byteBuffer;
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
            this.C = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }

    public bj(bj bjVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = bjVar.C;
        if (bjVar.d()) {
            this.f41000a = bjVar.f41000a;
        }
        if (bjVar.g()) {
            this.f41001b = bjVar.f41001b;
        }
        if (bjVar.j()) {
            this.f41002c = bjVar.f41002c;
        }
        this.f41003d = bjVar.f41003d;
        this.f41004e = bjVar.f41004e;
        this.f41005f = bjVar.f41005f;
        if (bjVar.w()) {
            this.f41006g = bs.d(bjVar.f41006g);
        }
        if (bjVar.z()) {
            this.f41007h = bjVar.f41007h;
        }
        if (bjVar.C()) {
            this.f41008i = bjVar.f41008i;
        }
        this.f41009j = bjVar.f41009j;
    }
}
