package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.protobuf.g.b;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class g<FieldDescriptorType extends b<FieldDescriptorType>> {

    /* renamed from: d, reason: collision with root package name */
    private static final g f46496d = new g(true);

    /* renamed from: b, reason: collision with root package name */
    private boolean f46498b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f46499c = false;

    /* renamed from: a, reason: collision with root package name */
    private final s<FieldDescriptorType, Object> f46497a = s.n(16);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b<T extends b<T>> extends Comparable<T> {
        WireFormat.FieldType A();

        WireFormat.JavaType B();

        n.a G(n.a aVar, n nVar);

        boolean H();

        boolean P();

        int getNumber();
    }

    private g() {
    }

    public int k() {
        int i6 = 0;
        for (int i7 = 0; i7 < this.f46497a.i(); i7++) {
            Map.Entry<FieldDescriptorType, Object> h6 = this.f46497a.h(i7);
            i6 += f(h6.getKey(), h6.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f46497a.j()) {
            i6 += f(entry.getKey(), entry.getValue());
        }
        return i6;
    }

    public boolean n() {
        for (int i6 = 0; i6 < this.f46497a.i(); i6++) {
            if (!o(this.f46497a.h(i6))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f46497a.j().iterator();
        while (it.hasNext()) {
            if (!o(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void r(g<FieldDescriptorType> gVar) {
        for (int i6 = 0; i6 < gVar.f46497a.i(); i6++) {
            s(gVar.f46497a.h(i6));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = gVar.f46497a.j().iterator();
        while (it.hasNext()) {
            s(it.next());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46500a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f46501b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f46501b = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46501b[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46501b[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46501b[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46501b[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46501b[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f46501b[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f46501b[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f46501b[WireFormat.FieldType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f46501b[WireFormat.FieldType.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f46501b[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f46501b[WireFormat.FieldType.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f46501b[WireFormat.FieldType.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f46501b[WireFormat.FieldType.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f46501b[WireFormat.FieldType.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f46501b[WireFormat.FieldType.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f46501b[WireFormat.FieldType.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f46501b[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f46500a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f46500a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f46500a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f46500a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f46500a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f46500a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f46500a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f46500a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f46500a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    private Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int e(WireFormat.FieldType fieldType, Object obj) {
        switch (a.f46501b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.h(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.n(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.r(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.G(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.q(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.l(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.k(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.c(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.D((String) obj);
            case 10:
                return obj instanceof d ? CodedOutputStream.f((d) obj) : CodedOutputStream.d((byte[]) obj);
            case 11:
                return CodedOutputStream.F(((Integer) obj).intValue());
            case 12:
                return CodedOutputStream.y(((Integer) obj).intValue());
            case 13:
                return CodedOutputStream.z(((Long) obj).longValue());
            case 14:
                return CodedOutputStream.A(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.C(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.o((n) obj);
            case 17:
                return obj instanceof i ? CodedOutputStream.s((i) obj) : CodedOutputStream.u((n) obj);
            case 18:
                return obj instanceof h.a ? CodedOutputStream.j(((h.a) obj).getNumber()) : CodedOutputStream.j(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static <T extends b<T>> g<T> g() {
        return f46496d;
    }

    static int l(WireFormat.FieldType fieldType, boolean z5) {
        if (z5) {
            return 2;
        }
        return fieldType.getWireType();
    }

    public static <T extends b<T>> g<T> t() {
        return new g<>();
    }

    public static Object u(e eVar, WireFormat.FieldType fieldType, boolean z5) throws IOException {
        switch (a.f46501b[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(eVar.m());
            case 2:
                return Float.valueOf(eVar.q());
            case 3:
                return Long.valueOf(eVar.t());
            case 4:
                return Long.valueOf(eVar.M());
            case 5:
                return Integer.valueOf(eVar.s());
            case 6:
                return Long.valueOf(eVar.p());
            case 7:
                return Integer.valueOf(eVar.o());
            case 8:
                return Boolean.valueOf(eVar.k());
            case 9:
                return z5 ? eVar.J() : eVar.I();
            case 10:
                return eVar.l();
            case 11:
                return Integer.valueOf(eVar.L());
            case 12:
                return Integer.valueOf(eVar.E());
            case 13:
                return Long.valueOf(eVar.F());
            case 14:
                return Integer.valueOf(eVar.G());
            case 15:
                return Long.valueOf(eVar.H());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static void x(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i6, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.c0(i6, (n) obj);
        } else {
            codedOutputStream.A0(i6, l(fieldType, false));
            y(codedOutputStream, fieldType, obj);
        }
    }

    private static void y(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (a.f46501b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.V(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.b0(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.g0(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.D0(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.f0(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.Z(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.Y(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.Q(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.z0((String) obj);
                break;
            case 10:
                if (!(obj instanceof d)) {
                    codedOutputStream.R((byte[]) obj);
                    break;
                } else {
                    codedOutputStream.T((d) obj);
                    break;
                }
            case 11:
                codedOutputStream.C0(((Integer) obj).intValue());
                break;
            case 12:
                codedOutputStream.u0(((Integer) obj).intValue());
                break;
            case 13:
                codedOutputStream.v0(((Long) obj).longValue());
                break;
            case 14:
                codedOutputStream.w0(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.y0(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.d0((n) obj);
                break;
            case 17:
                codedOutputStream.i0((n) obj);
                break;
            case 18:
                if (!(obj instanceof h.a)) {
                    codedOutputStream.X(((Integer) obj).intValue());
                    break;
                } else {
                    codedOutputStream.X(((h.a) obj).getNumber());
                    break;
                }
        }
    }

    public Object h(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f46497a.get(fielddescriptortype);
        return obj instanceof i ? ((i) obj).e() : obj;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> p() {
        return this.f46499c ? new i.c(this.f46497a.entrySet().iterator()) : this.f46497a.entrySet().iterator();
    }

    public void q() {
        if (this.f46498b) {
            return;
        }
        this.f46497a.m();
        this.f46498b = true;
    }

    private static int d(WireFormat.FieldType fieldType, int i6, Object obj) {
        int E = CodedOutputStream.E(i6);
        if (fieldType == WireFormat.FieldType.GROUP) {
            E *= 2;
        }
        return E + e(fieldType, obj);
    }

    public static int f(b<?> bVar, Object obj) {
        WireFormat.FieldType A = bVar.A();
        int number = bVar.getNumber();
        if (bVar.H()) {
            int i6 = 0;
            if (bVar.P()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i6 += e(A, it.next());
                }
                return CodedOutputStream.E(number) + i6 + CodedOutputStream.w(i6);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i6 += d(A, number, it2.next());
            }
            return i6;
        }
        return d(A, number, obj);
    }

    private boolean o(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.B() == WireFormat.JavaType.MESSAGE) {
            if (key.H()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((n) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof n) {
                    if (!((n) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof i) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private void s(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof i) {
            value = ((i) value).e();
        }
        if (key.H()) {
            Object h6 = h(key);
            if (h6 == null) {
                h6 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) h6).add(c(it.next()));
            }
            this.f46497a.put(key, h6);
            return;
        }
        if (key.B() == WireFormat.JavaType.MESSAGE) {
            Object h7 = h(key);
            if (h7 == null) {
                this.f46497a.put(key, c(value));
                return;
            } else {
                this.f46497a.put(key, key.G(((n) h7).toBuilder(), (n) value).build());
                return;
            }
        }
        this.f46497a.put(key, c(value));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.h.a) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.i) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void w(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType r2, java.lang.Object r3) {
        /*
            r3.getClass()
            int[] r0 = kotlin.reflect.jvm.internal.impl.protobuf.g.a.f46500a
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType r2 = r2.getJavaType()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L42;
                case 2: goto L3f;
                case 3: goto L3c;
                case 4: goto L39;
                case 5: goto L36;
                case 6: goto L33;
                case 7: goto L2a;
                case 8: goto L21;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L44
        L15:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.n
            if (r2 != 0) goto L1f
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.i
            if (r2 == 0) goto L1e
            goto L1f
        L1e:
            r0 = 0
        L1f:
            r1 = r0
            goto L44
        L21:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L1f
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.h.a
            if (r2 == 0) goto L1e
            goto L1f
        L2a:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.d
            if (r2 != 0) goto L1f
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L1e
            goto L1f
        L33:
            boolean r1 = r3 instanceof java.lang.String
            goto L44
        L36:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L44
        L39:
            boolean r1 = r3 instanceof java.lang.Double
            goto L44
        L3c:
            boolean r1 = r3 instanceof java.lang.Float
            goto L44
        L3f:
            boolean r1 = r3 instanceof java.lang.Long
            goto L44
        L42:
            boolean r1 = r3 instanceof java.lang.Integer
        L44:
            if (r1 == 0) goto L47
            return
        L47:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.g.w(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public static void z(b<?> bVar, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType A = bVar.A();
        int number = bVar.getNumber();
        if (bVar.H()) {
            List list = (List) obj;
            if (bVar.P()) {
                codedOutputStream.A0(number, 2);
                Iterator it = list.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    i6 += e(A, it.next());
                }
                codedOutputStream.s0(i6);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    y(codedOutputStream, A, it2.next());
                }
                return;
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                x(codedOutputStream, A, number, it3.next());
            }
            return;
        }
        if (obj instanceof i) {
            x(codedOutputStream, A, number, ((i) obj).e());
        } else {
            x(codedOutputStream, A, number, obj);
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (fielddescriptortype.H()) {
            w(fielddescriptortype.A(), obj);
            Object h6 = h(fielddescriptortype);
            if (h6 == null) {
                list = new ArrayList();
                this.f46497a.put(fielddescriptortype, list);
            } else {
                list = (List) h6;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<FieldDescriptorType> clone() {
        g<FieldDescriptorType> t5 = t();
        for (int i6 = 0; i6 < this.f46497a.i(); i6++) {
            Map.Entry<FieldDescriptorType, Object> h6 = this.f46497a.h(i6);
            t5.v(h6.getKey(), h6.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f46497a.j()) {
            t5.v(entry.getKey(), entry.getValue());
        }
        t5.f46499c = this.f46499c;
        return t5;
    }

    public Object i(FieldDescriptorType fielddescriptortype, int i6) {
        if (fielddescriptortype.H()) {
            Object h6 = h(fielddescriptortype);
            if (h6 != null) {
                return ((List) h6).get(i6);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int j(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.H()) {
            Object h6 = h(fielddescriptortype);
            if (h6 == null) {
                return 0;
            }
            return ((List) h6).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public boolean m(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.H()) {
            if (this.f46497a.get(fielddescriptortype) != null) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public void v(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.H()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    w(fielddescriptortype.A(), it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            w(fielddescriptortype.A(), obj);
        }
        if (obj instanceof i) {
            this.f46499c = true;
        }
        this.f46497a.put(fielddescriptortype, obj);
    }

    private g(boolean z5) {
        q();
    }
}
