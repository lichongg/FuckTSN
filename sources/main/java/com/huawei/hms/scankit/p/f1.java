package com.huawei.hms.scankit.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
abstract class f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final f1 f34248a;

    /* renamed from: b, reason: collision with root package name */
    public static final f1 f34249b;

    /* renamed from: c, reason: collision with root package name */
    public static final f1 f34250c;

    /* renamed from: d, reason: collision with root package name */
    public static final f1 f34251d;

    /* renamed from: e, reason: collision with root package name */
    public static final f1 f34252e;

    /* renamed from: f, reason: collision with root package name */
    public static final f1 f34253f;

    /* renamed from: g, reason: collision with root package name */
    public static final f1 f34254g;

    /* renamed from: h, reason: collision with root package name */
    public static final f1 f34255h;

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ f1[] f34256i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum a extends f1 {
        a(String str, int i6) {
            super(str, i6, null);
        }

        @Override // com.huawei.hms.scankit.p.f1
        boolean a(int i6, int i7) {
            return ((i6 + i7) & 1) == 0;
        }
    }

    private f1(String str, int i6) {
    }

    final void a(s sVar, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                if (a(i7, i8)) {
                    sVar.a(i8, i7);
                }
            }
        }
    }

    abstract boolean a(int i6, int i7);

    static {
        a aVar = new a("DATA_MASK_000", 0);
        f34248a = aVar;
        f1 f1Var = new f1("DATA_MASK_001", 1) { // from class: com.huawei.hms.scankit.p.f1.b
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            boolean a(int i6, int i7) {
                return (i6 & 1) == 0;
            }
        };
        f34249b = f1Var;
        f1 f1Var2 = new f1("DATA_MASK_010", 2) { // from class: com.huawei.hms.scankit.p.f1.c
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            boolean a(int i6, int i7) {
                return i7 % 3 == 0;
            }
        };
        f34250c = f1Var2;
        f1 f1Var3 = new f1("DATA_MASK_011", 3) { // from class: com.huawei.hms.scankit.p.f1.d
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            boolean a(int i6, int i7) {
                return (i6 + i7) % 3 == 0;
            }
        };
        f34251d = f1Var3;
        f1 f1Var4 = new f1("DATA_MASK_100", 4) { // from class: com.huawei.hms.scankit.p.f1.e
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            boolean a(int i6, int i7) {
                return (((i6 / 2) + (i7 / 3)) & 1) == 0;
            }
        };
        f34252e = f1Var4;
        f1 f1Var5 = new f1("DATA_MASK_101", 5) { // from class: com.huawei.hms.scankit.p.f1.f
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            boolean a(int i6, int i7) {
                return (i6 * i7) % 6 == 0;
            }
        };
        f34253f = f1Var5;
        f1 f1Var6 = new f1("DATA_MASK_110", 6) { // from class: com.huawei.hms.scankit.p.f1.g
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            boolean a(int i6, int i7) {
                return (i6 * i7) % 6 < 3;
            }
        };
        f34254g = f1Var6;
        f1 f1Var7 = new f1("DATA_MASK_111", 7) { // from class: com.huawei.hms.scankit.p.f1.h
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            boolean a(int i6, int i7) {
                return (((i6 + i7) + ((i6 * i7) % 3)) & 1) == 0;
            }
        };
        f34255h = f1Var7;
        f34256i = new f1[]{aVar, f1Var, f1Var2, f1Var3, f1Var4, f1Var5, f1Var6, f1Var7};
    }

    /* synthetic */ f1(String str, int i6, a aVar) {
        this(str, i6);
    }

    public static f1 valueOf(String str) {
        return (f1) Enum.valueOf(f1.class, str);
    }

    public static f1[] values() {
        return (f1[]) f34256i.clone();
    }
}
