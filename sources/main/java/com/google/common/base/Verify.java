package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Verify {
    public static void verify(boolean z5) {
        if (!z5) {
            throw new VerifyException();
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(@NullableDecl T t5) {
        return (T) verifyNotNull(t5, "expected a non-null reference", new Object[0]);
    }

    public static void verify(boolean z5, @NullableDecl String str, @NullableDecl Object... objArr) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(@NullableDecl T t5, @NullableDecl String str, @NullableDecl Object... objArr) {
        verify(t5 != null, str, objArr);
        return t5;
    }

    private Verify() {
    }

    public static void verify(boolean z5, @NullableDecl String str, char c6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, int i6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, long j6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, obj));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, char c6, char c7) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c6), Character.valueOf(c7)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, int i6, char c6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i6), Character.valueOf(c6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, long j6, char c6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j6), Character.valueOf(c6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, @NullableDecl Object obj, char c6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Character.valueOf(c6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, char c6, int i6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c6), Integer.valueOf(i6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, int i6, int i7) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i6), Integer.valueOf(i7)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, long j6, int i6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j6), Integer.valueOf(i6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, @NullableDecl Object obj, int i6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Integer.valueOf(i6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, char c6, long j6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c6), Long.valueOf(j6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, int i6, long j6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i6), Long.valueOf(j6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, long j6, long j7) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j6), Long.valueOf(j7)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, @NullableDecl Object obj, long j6) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Long.valueOf(j6)));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, char c6, @NullableDecl Object obj) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c6), obj));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, int i6, @NullableDecl Object obj) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i6), obj));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, long j6, @NullableDecl Object obj) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j6), obj));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void verify(boolean z5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3, @NullableDecl Object obj4) {
        if (!z5) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
