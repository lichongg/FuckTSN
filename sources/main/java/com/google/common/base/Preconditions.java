package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Preconditions {
    private static String badElementIndex(int i6, int i7, @NullableDecl String str) {
        if (i6 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i7 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i7));
        }
        throw new IllegalArgumentException("negative size: " + i7);
    }

    private static String badPositionIndex(int i6, int i7, @NullableDecl String str) {
        if (i6 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i7 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i7));
        }
        throw new IllegalArgumentException("negative size: " + i7);
    }

    public static void checkArgument(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i6, int i7) {
        return checkElementIndex(i6, i7, "index");
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5) {
        t5.getClass();
        return t5;
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i6, int i7) {
        return checkPositionIndex(i6, i7, "index");
    }

    public static void checkState(boolean z5) {
        if (!z5) {
            throw new IllegalStateException();
        }
    }

    private static String badPositionIndexes(int i6, int i7, int i8) {
        return (i6 < 0 || i6 > i8) ? badPositionIndex(i6, i8, "start index") : (i7 < 0 || i7 > i8) ? badPositionIndex(i7, i8, "end index") : Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i7), Integer.valueOf(i6));
    }

    public static void checkArgument(boolean z5, @NullableDecl Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i6, int i7, @NullableDecl String str) {
        if (i6 < 0 || i6 >= i7) {
            throw new IndexOutOfBoundsException(badElementIndex(i6, i7, str));
        }
        return i6;
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i6, int i7, @NullableDecl String str) {
        if (i6 < 0 || i6 > i7) {
            throw new IndexOutOfBoundsException(badPositionIndex(i6, i7, str));
        }
        return i6;
    }

    public static void checkPositionIndexes(int i6, int i7, int i8) {
        if (i6 < 0 || i7 < i6 || i7 > i8) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i6, i7, i8));
        }
    }

    public static void checkState(boolean z5, @NullableDecl Object obj) {
        if (!z5) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    private Preconditions() {
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, @NullableDecl Object... objArr) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, @NullableDecl Object... objArr) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, objArr));
    }

    public static void checkState(boolean z5, @NullableDecl String str, @NullableDecl Object... objArr) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, objArr));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, char c6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, char c6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, char c6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, int i6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, int i6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, int i6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, long j6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, long j6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, long j6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, @NullableDecl Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj));
    }

    public static void checkState(boolean z5, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, char c6, char c7) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c6), Character.valueOf(c7)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, char c6, char c7) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c6), Character.valueOf(c7)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, char c6, char c7) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c6), Character.valueOf(c7)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, char c6, int i6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c6), Integer.valueOf(i6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, char c6, int i6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c6), Integer.valueOf(i6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, char c6, int i6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c6), Integer.valueOf(i6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, char c6, long j6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c6), Long.valueOf(j6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, char c6, long j6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c6), Long.valueOf(j6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, char c6, long j6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c6), Long.valueOf(j6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, char c6, @NullableDecl Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c6), obj));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, char c6, @NullableDecl Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c6), obj));
    }

    public static void checkState(boolean z5, @NullableDecl String str, char c6, @NullableDecl Object obj) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c6), obj));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, int i6, char c6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i6), Character.valueOf(c6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, int i6, char c6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i6), Character.valueOf(c6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, int i6, char c6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i6), Character.valueOf(c6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, int i6, int i7) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i6), Integer.valueOf(i7)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, int i6, int i7) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i6), Integer.valueOf(i7)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, int i6, int i7) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i6), Integer.valueOf(i7)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, int i6, long j6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i6), Long.valueOf(j6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, int i6, long j6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i6), Long.valueOf(j6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, int i6, long j6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i6), Long.valueOf(j6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, int i6, @NullableDecl Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i6), obj));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, int i6, @NullableDecl Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i6), obj));
    }

    public static void checkState(boolean z5, @NullableDecl String str, int i6, @NullableDecl Object obj) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i6), obj));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, long j6, char c6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j6), Character.valueOf(c6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, long j6, char c6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j6), Character.valueOf(c6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, long j6, char c6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j6), Character.valueOf(c6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, long j6, int i6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j6), Integer.valueOf(i6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, long j6, int i6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j6), Integer.valueOf(i6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, long j6, int i6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j6), Integer.valueOf(i6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, long j6, long j7) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j6), Long.valueOf(j7)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, long j6, long j7) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j6), Long.valueOf(j7)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, long j6, long j7) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j6), Long.valueOf(j7)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, long j6, @NullableDecl Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j6), obj));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, long j6, @NullableDecl Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j6), obj));
    }

    public static void checkState(boolean z5, @NullableDecl String str, long j6, @NullableDecl Object obj) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j6), obj));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, @NullableDecl Object obj, char c6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Character.valueOf(c6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, @NullableDecl Object obj, char c6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Character.valueOf(c6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, @NullableDecl Object obj, char c6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Character.valueOf(c6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, @NullableDecl Object obj, int i6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Integer.valueOf(i6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, @NullableDecl Object obj, int i6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Integer.valueOf(i6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, @NullableDecl Object obj, int i6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Integer.valueOf(i6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, @NullableDecl Object obj, long j6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Long.valueOf(j6)));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, @NullableDecl Object obj, long j6) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Long.valueOf(j6)));
    }

    public static void checkState(boolean z5, @NullableDecl String str, @NullableDecl Object obj, long j6) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Long.valueOf(j6)));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2));
    }

    public static void checkState(boolean z5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3));
    }

    public static void checkState(boolean z5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3, @NullableDecl Object obj4) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3, @NullableDecl Object obj4) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    public static void checkState(boolean z5, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3, @NullableDecl Object obj4) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
