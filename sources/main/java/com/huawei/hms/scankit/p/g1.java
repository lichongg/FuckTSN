package com.huawei.hms.scankit.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
abstract class g1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g1 f34299a;

    /* renamed from: b, reason: collision with root package name */
    public static final g1 f34300b;

    /* renamed from: c, reason: collision with root package name */
    public static final g1 f34301c;

    /* renamed from: d, reason: collision with root package name */
    public static final g1 f34302d;

    /* renamed from: e, reason: collision with root package name */
    public static final g1 f34303e;

    /* renamed from: f, reason: collision with root package name */
    public static final g1 f34304f;

    /* renamed from: g, reason: collision with root package name */
    public static final g1 f34305g;

    /* renamed from: h, reason: collision with root package name */
    public static final g1 f34306h;

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ g1[] f34307i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum a extends g1 {
        a(String str, int i6) {
            super(str, i6, null);
        }

        @Override // com.huawei.hms.scankit.p.g1
        boolean a(int i6, int i7) {
            return ((i6 + i7) & 1) == 0;
        }
    }

    private g1(String str, int i6) {
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
        f34299a = aVar;
        g1 g1Var = new g1("DATA_MASK_001", 1) { // from class: com.huawei.hms.scankit.p.g1.b
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            boolean a(int i6, int i7) {
                return (i6 & 1) == 0;
            }
        };
        f34300b = g1Var;
        g1 g1Var2 = new g1("DATA_MASK_010", 2) { // from class: com.huawei.hms.scankit.p.g1.c
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            boolean a(int i6, int i7) {
                return i7 % 3 == 0;
            }
        };
        f34301c = g1Var2;
        g1 g1Var3 = new g1("DATA_MASK_011", 3) { // from class: com.huawei.hms.scankit.p.g1.d
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            boolean a(int i6, int i7) {
                return (i6 + i7) % 3 == 0;
            }
        };
        f34302d = g1Var3;
        g1 g1Var4 = new g1("DATA_MASK_100", 4) { // from class: com.huawei.hms.scankit.p.g1.e
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            boolean a(int i6, int i7) {
                return (((i6 / 2) + (i7 / 3)) & 1) == 0;
            }
        };
        f34303e = g1Var4;
        g1 g1Var5 = new g1("DATA_MASK_101", 5) { // from class: com.huawei.hms.scankit.p.g1.f
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            boolean a(int i6, int i7) {
                return (i6 * i7) % 6 == 0;
            }
        };
        f34304f = g1Var5;
        g1 g1Var6 = new g1("DATA_MASK_110", 6) { // from class: com.huawei.hms.scankit.p.g1.g
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            boolean a(int i6, int i7) {
                return (i6 * i7) % 6 < 3;
            }
        };
        f34305g = g1Var6;
        g1 g1Var7 = new g1("DATA_MASK_111", 7) { // from class: com.huawei.hms.scankit.p.g1.h
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            boolean a(int i6, int i7) {
                return (((i6 + i7) + ((i6 * i7) % 3)) & 1) == 0;
            }
        };
        f34306h = g1Var7;
        f34307i = new g1[]{aVar, g1Var, g1Var2, g1Var3, g1Var4, g1Var5, g1Var6, g1Var7};
    }

    /* synthetic */ g1(String str, int i6, a aVar) {
        this(str, i6);
    }

    public static g1 valueOf(String str) {
        return (g1) Enum.valueOf(g1.class, str);
    }

    public static g1[] values() {
        return (g1[]) f34307i.clone();
    }
}
