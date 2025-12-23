package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.acse.ottn.l3;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b {
    public static final C0902b A;
    public static final C0902b B;
    public static final C0902b C;
    public static final C0902b D;
    public static final C0902b E;
    public static final C0902b F;
    public static final C0902b G;
    public static final C0902b H;
    public static final C0902b I;
    public static final C0902b J;
    public static final C0902b K;
    public static final C0902b L;
    public static final C0902b M;
    public static final C0902b N;
    public static final C0902b O;
    public static final C0902b P;

    /* renamed from: a, reason: collision with root package name */
    public static final C0902b f46206a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0902b f46207b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0902b f46208c;

    /* renamed from: d, reason: collision with root package name */
    public static final d<ProtoBuf.Visibility> f46209d;

    /* renamed from: e, reason: collision with root package name */
    public static final d<ProtoBuf.Modality> f46210e;

    /* renamed from: f, reason: collision with root package name */
    public static final d<ProtoBuf.Class.Kind> f46211f;

    /* renamed from: g, reason: collision with root package name */
    public static final C0902b f46212g;

    /* renamed from: h, reason: collision with root package name */
    public static final C0902b f46213h;

    /* renamed from: i, reason: collision with root package name */
    public static final C0902b f46214i;

    /* renamed from: j, reason: collision with root package name */
    public static final C0902b f46215j;

    /* renamed from: k, reason: collision with root package name */
    public static final C0902b f46216k;

    /* renamed from: l, reason: collision with root package name */
    public static final C0902b f46217l;

    /* renamed from: m, reason: collision with root package name */
    public static final C0902b f46218m;

    /* renamed from: n, reason: collision with root package name */
    public static final C0902b f46219n;

    /* renamed from: o, reason: collision with root package name */
    public static final C0902b f46220o;

    /* renamed from: p, reason: collision with root package name */
    public static final d<ProtoBuf.MemberKind> f46221p;

    /* renamed from: q, reason: collision with root package name */
    public static final C0902b f46222q;

    /* renamed from: r, reason: collision with root package name */
    public static final C0902b f46223r;

    /* renamed from: s, reason: collision with root package name */
    public static final C0902b f46224s;

    /* renamed from: t, reason: collision with root package name */
    public static final C0902b f46225t;

    /* renamed from: u, reason: collision with root package name */
    public static final C0902b f46226u;

    /* renamed from: v, reason: collision with root package name */
    public static final C0902b f46227v;

    /* renamed from: w, reason: collision with root package name */
    public static final C0902b f46228w;

    /* renamed from: x, reason: collision with root package name */
    public static final C0902b f46229x;

    /* renamed from: y, reason: collision with root package name */
    public static final C0902b f46230y;

    /* renamed from: z, reason: collision with root package name */
    public static final C0902b f46231z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.metadata.deserialization.b$b, reason: collision with other inner class name */
    public static class C0902b extends d<Boolean> {
        public C0902b(int i6) {
            super(i6, 1);
        }

        private static /* synthetic */ void f(int i6) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", l3.f4736f));
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.d
        @NotNull
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i6) {
            return Boolean.valueOf((i6 & (1 << this.f46233a)) != 0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.d
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.f46233a;
            }
            return 0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c<E extends h.a> extends d<E> {

        /* renamed from: c, reason: collision with root package name */
        private final E[] f46232c;

        private static /* synthetic */ void f(int i6) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        private static <E> int g(@NotNull E[] eArr) {
            if (eArr == null) {
                f(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i6 = 31; i6 >= 0; i6--) {
                if (((1 << i6) & length) != 0) {
                    return i6 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.d
        @Nullable
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public E d(int i6) {
            int i7 = (1 << this.f46234b) - 1;
            int i8 = this.f46233a;
            int i9 = (i6 & (i7 << i8)) >> i8;
            for (E e6 : this.f46232c) {
                if (e6.getNumber() == i9) {
                    return e6;
                }
            }
            return null;
        }

        public c(int i6, E[] eArr) {
            super(i6, g(eArr));
            this.f46232c = eArr;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(E e6) {
            return e6.getNumber() << this.f46233a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class d<E> {

        /* renamed from: a, reason: collision with root package name */
        public final int f46233a;

        /* renamed from: b, reason: collision with root package name */
        public final int f46234b;

        public abstract E d(int i6);

        public abstract int e(E e6);

        private d(int i6, int i7) {
            this.f46233a = i6;
            this.f46234b = i7;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/h$a;>(Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/b$d<*>;[TE;)Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/b$d<TE;>; */
        public static d a(d dVar, h.a[] aVarArr) {
            return new c(dVar.f46233a + dVar.f46234b, aVarArr);
        }

        public static C0902b b(d<?> dVar) {
            return new C0902b(dVar.f46233a + dVar.f46234b);
        }

        public static C0902b c() {
            return new C0902b(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r5) {
        /*
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r2 = 2
            r3 = 1
            if (r5 == r3) goto L2b
            if (r5 == r2) goto L26
            r4 = 5
            if (r5 == r4) goto L2b
            r4 = 6
            if (r5 == r4) goto L21
            r4 = 8
            if (r5 == r4) goto L2b
            r4 = 9
            if (r5 == r4) goto L21
            r4 = 11
            if (r5 == r4) goto L2b
            java.lang.String r4 = "visibility"
            r0[r1] = r4
            goto L2f
        L21:
            java.lang.String r4 = "memberKind"
            r0[r1] = r4
            goto L2f
        L26:
            java.lang.String r4 = "kind"
            r0[r1] = r4
            goto L2f
        L2b:
            java.lang.String r4 = "modality"
            r0[r1] = r4
        L2f:
            java.lang.String r1 = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags"
            r0[r3] = r1
            switch(r5) {
                case 3: goto L4a;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L40;
                case 9: goto L40;
                case 10: goto L3b;
                case 11: goto L3b;
                default: goto L36;
            }
        L36:
            java.lang.String r5 = "getClassFlags"
            r0[r2] = r5
            goto L4e
        L3b:
            java.lang.String r5 = "getAccessorFlags"
            r0[r2] = r5
            goto L4e
        L40:
            java.lang.String r5 = "getPropertyFlags"
            r0[r2] = r5
            goto L4e
        L45:
            java.lang.String r5 = "getFunctionFlags"
            r0[r2] = r5
            goto L4e
        L4a:
            java.lang.String r5 = "getConstructorFlags"
            r0[r2] = r5
        L4e:
            java.lang.String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.a(int):void");
    }

    public static int b(boolean z5, @NotNull ProtoBuf.Visibility visibility, @NotNull ProtoBuf.Modality modality, boolean z6, boolean z7, boolean z8) {
        if (visibility == null) {
            a(10);
        }
        if (modality == null) {
            a(11);
        }
        return f46208c.e(Boolean.valueOf(z5)) | f46210e.e(modality) | f46209d.e(visibility) | K.e(Boolean.valueOf(z6)) | L.e(Boolean.valueOf(z7)) | M.e(Boolean.valueOf(z8));
    }

    static {
        C0902b c6 = d.c();
        f46206a = c6;
        f46207b = d.b(c6);
        C0902b c7 = d.c();
        f46208c = c7;
        d<ProtoBuf.Visibility> a6 = d.a(c7, ProtoBuf.Visibility.values());
        f46209d = a6;
        d<ProtoBuf.Modality> a7 = d.a(a6, ProtoBuf.Modality.values());
        f46210e = a7;
        d<ProtoBuf.Class.Kind> a8 = d.a(a7, ProtoBuf.Class.Kind.values());
        f46211f = a8;
        C0902b b6 = d.b(a8);
        f46212g = b6;
        C0902b b7 = d.b(b6);
        f46213h = b7;
        C0902b b8 = d.b(b7);
        f46214i = b8;
        C0902b b9 = d.b(b8);
        f46215j = b9;
        C0902b b10 = d.b(b9);
        f46216k = b10;
        C0902b b11 = d.b(b10);
        f46217l = b11;
        f46218m = d.b(b11);
        C0902b b12 = d.b(a6);
        f46219n = b12;
        f46220o = d.b(b12);
        d<ProtoBuf.MemberKind> a9 = d.a(a7, ProtoBuf.MemberKind.values());
        f46221p = a9;
        C0902b b13 = d.b(a9);
        f46222q = b13;
        C0902b b14 = d.b(b13);
        f46223r = b14;
        C0902b b15 = d.b(b14);
        f46224s = b15;
        C0902b b16 = d.b(b15);
        f46225t = b16;
        C0902b b17 = d.b(b16);
        f46226u = b17;
        C0902b b18 = d.b(b17);
        f46227v = b18;
        C0902b b19 = d.b(b18);
        f46228w = b19;
        f46229x = d.b(b19);
        C0902b b20 = d.b(a9);
        f46230y = b20;
        C0902b b21 = d.b(b20);
        f46231z = b21;
        C0902b b22 = d.b(b21);
        A = b22;
        C0902b b23 = d.b(b22);
        B = b23;
        C0902b b24 = d.b(b23);
        C = b24;
        C0902b b25 = d.b(b24);
        D = b25;
        C0902b b26 = d.b(b25);
        E = b26;
        C0902b b27 = d.b(b26);
        F = b27;
        G = d.b(b27);
        C0902b b28 = d.b(c7);
        H = b28;
        C0902b b29 = d.b(b28);
        I = b29;
        J = d.b(b29);
        C0902b b30 = d.b(a7);
        K = b30;
        C0902b b31 = d.b(b30);
        L = b31;
        M = d.b(b31);
        C0902b c8 = d.c();
        N = c8;
        O = d.b(c8);
        P = d.c();
    }
}
