package com.huawei.hms.scankit.p;

import java.util.List;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l1 {

    /* renamed from: b, reason: collision with root package name */
    public static final l1 f34504b;

    /* renamed from: c, reason: collision with root package name */
    public static final l1 f34505c;

    /* renamed from: d, reason: collision with root package name */
    public static final l1 f34506d;

    /* renamed from: e, reason: collision with root package name */
    public static final l1 f34507e;

    /* renamed from: f, reason: collision with root package name */
    public static final l1 f34508f;

    /* renamed from: g, reason: collision with root package name */
    public static final l1 f34509g;

    /* renamed from: h, reason: collision with root package name */
    public static final l1 f34510h;

    /* renamed from: i, reason: collision with root package name */
    public static final l1 f34511i;

    /* renamed from: j, reason: collision with root package name */
    public static final l1 f34512j;

    /* renamed from: k, reason: collision with root package name */
    public static final l1 f34513k;

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ l1[] f34514l;

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f34515a;

    static {
        l1 l1Var = new l1("OTHER", 0, Object.class);
        f34504b = l1Var;
        l1 l1Var2 = new l1("POSSIBLE_FORMATS", 1, List.class);
        f34505c = l1Var2;
        Class cls = Void.TYPE;
        l1 l1Var3 = new l1("PHOTO_MODE", 2, cls);
        f34506d = l1Var3;
        l1 l1Var4 = new l1("PHOTO_MODE_NUM", 3, Integer.TYPE);
        f34507e = l1Var4;
        l1 l1Var5 = new l1("NEED_JNI", 4, cls);
        f34508f = l1Var5;
        l1 l1Var6 = new l1("TRY_HARDER", 5, Void.class);
        f34509g = l1Var6;
        l1 l1Var7 = new l1("CHARACTER_SET", 6, String.class);
        f34510h = l1Var7;
        l1 l1Var8 = new l1("RETURN_CODABAR_START_END", 7, Void.class);
        f34511i = l1Var8;
        l1 l1Var9 = new l1("NEED_RESULT_POINT_CALLBACK", 8, v6.class);
        f34512j = l1Var9;
        l1 l1Var10 = new l1("ALLOWED_EAN_EXTENSIONS", 9, int[].class);
        f34513k = l1Var10;
        f34514l = new l1[]{l1Var, l1Var2, l1Var3, l1Var4, l1Var5, l1Var6, l1Var7, l1Var8, l1Var9, l1Var10};
    }

    public static l1 valueOf(String str) {
        return (l1) Enum.valueOf(l1.class, str);
    }

    public static l1[] values() {
        return (l1[]) f34514l.clone();
    }

    private l1(String str, int i6, Class cls) {
        this.f34515a = cls;
    }
}
