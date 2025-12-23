package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class MoreObjects {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.base.MoreObjects$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class ValueHolder {

            @NullableDecl
            String name;

            @NullableDecl
            ValueHolder next;

            @NullableDecl
            Object value;

            private ValueHolder() {
            }

            /* synthetic */ ValueHolder(AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        /* synthetic */ ToStringHelper(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder = new ValueHolder(null);
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, @NullableDecl Object obj) {
            return addHolder(str, obj);
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(@NullableDecl Object obj) {
            return addHolder(obj);
        }

        @CanIgnoreReturnValue
        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder(null);
            this.holderHead = valueHolder;
            this.holderTail = valueHolder;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, boolean z5) {
            return addHolder(str, String.valueOf(z5));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(boolean z5) {
            return addHolder(String.valueOf(z5));
        }

        public String toString() {
            boolean z5 = this.omitNullValues;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.className);
            sb.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                Object obj = valueHolder.value;
                if (!z5 || obj != null) {
                    sb.append(str);
                    String str2 = valueHolder.name;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private ToStringHelper addHolder(@NullableDecl Object obj) {
            addHolder().value = obj;
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, char c6) {
            return addHolder(str, String.valueOf(c6));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(char c6) {
            return addHolder(String.valueOf(c6));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, double d6) {
            return addHolder(str, String.valueOf(d6));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(double d6) {
            return addHolder(String.valueOf(d6));
        }

        private ToStringHelper addHolder(String str, @NullableDecl Object obj) {
            ValueHolder addHolder = addHolder();
            addHolder.value = obj;
            addHolder.name = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, float f6) {
            return addHolder(str, String.valueOf(f6));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(float f6) {
            return addHolder(String.valueOf(f6));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, int i6) {
            return addHolder(str, String.valueOf(i6));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(int i6) {
            return addHolder(String.valueOf(i6));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, long j6) {
            return addHolder(str, String.valueOf(j6));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(long j6) {
            return addHolder(String.valueOf(j6));
        }
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName(), null);
    }

    public static <T> T firstNonNull(@NullableDecl T t5, @NullableDecl T t6) {
        if (t5 != null) {
            return t5;
        }
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName(), null);
    }

    private MoreObjects() {
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str, null);
    }
}
