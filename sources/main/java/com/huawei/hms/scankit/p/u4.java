package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public enum u4 {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);


    /* renamed from: a, reason: collision with root package name */
    private final int[] f34874a;

    /* renamed from: b, reason: collision with root package name */
    private final int f34875b;

    public static u4 a(int i6) {
        if (i6 == 0) {
            return TERMINATOR;
        }
        if (i6 == 1) {
            return NUMERIC;
        }
        if (i6 == 2) {
            return ALPHANUMERIC;
        }
        if (i6 == 3) {
            return STRUCTURED_APPEND;
        }
        if (i6 == 4) {
            return BYTE;
        }
        if (i6 == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i6 == 7) {
            return ECI;
        }
        if (i6 == 8) {
            return KANJI;
        }
        if (i6 == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i6 == 13) {
            return HANZI;
        }
        throw new IllegalArgumentException();
    }

    u4(int[] iArr, int i6) {
        this.f34874a = iArr;
        this.f34875b = i6;
    }

    public int a(b8 b8Var) {
        int f6 = b8Var.f();
        return this.f34874a[f6 <= 9 ? (char) 0 : f6 <= 26 ? (char) 1 : (char) 2];
    }

    public int a() {
        return this.f34875b;
    }
}
