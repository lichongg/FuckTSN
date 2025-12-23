package com.huawei.hms.scankit.p;

import java.util.Stack;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class r3 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f34730a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f34731b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f34732c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f34733d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f34734e = false;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f34735f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f34736g = false;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f34737h = false;

    /* renamed from: i, reason: collision with root package name */
    public static float f34738i = -1.0f;

    /* renamed from: j, reason: collision with root package name */
    public static int f34739j;

    /* renamed from: k, reason: collision with root package name */
    public static int f34740k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f34741l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f34742m;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f34743n;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f34744o;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f34745p;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f34746q;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f34747r;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f34748s;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f34749t;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f34750u;

    /* renamed from: v, reason: collision with root package name */
    public static boolean[] f34751v = new boolean[8];

    /* renamed from: w, reason: collision with root package name */
    public static Stack<Integer> f34752w = new Stack<>();

    /* renamed from: x, reason: collision with root package name */
    public static boolean f34753x = true;

    /* renamed from: y, reason: collision with root package name */
    public static float[] f34754y = new float[4];

    /* renamed from: z, reason: collision with root package name */
    public static int f34755z = 0;
    public static boolean A = false;

    public static void a() {
        f34737h = false;
        f34738i = -1.0f;
        f34739j = 0;
        f34745p = false;
        f34746q = false;
        f34747r = false;
        f34749t = false;
        f34742m = false;
        f34743n = false;
        f34744o = false;
        f34748s = false;
        f34751v = new boolean[8];
        f34752w = new Stack<>();
        f34753x = true;
        f34734e = false;
        f34733d = false;
    }

    public static void a(int i6) {
        if (i6 % 2 == 1) {
            f34745p = true;
        }
        if (i6 % 3 == 2) {
            f34746q = true;
        }
        if (i6 % 5 == 4) {
            f34747r = true;
        }
    }

    public static void a(x6 x6Var) {
        a();
        boolean z5 = x6Var.f35010e;
        f34732c = z5;
        f34753x = x6Var.f35012g;
        if (!z5) {
            a(x6Var.f35011f);
        } else {
            a(1);
        }
    }
}
