package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public class Joiner {
    private final String separator;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a6, Map<?, ?> map) throws IOException {
            return (A) appendTo((MapJoiner) a6, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public String join(Map<?, ?> map) {
            return join(map.entrySet());
        }

        private MapJoiner(Joiner joiner, String str) {
            this.joiner = joiner;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder sb, Map<?, ?> map) {
            return appendTo(sb, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        @Beta
        public String join(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return join(iterable.iterator());
        }

        public MapJoiner useForNull(String str) {
            return new MapJoiner(this.joiner.useForNull(str), this.keyValueSeparator);
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A appendTo(A a6, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return (A) appendTo((MapJoiner) a6, iterable.iterator());
        }

        @Beta
        public String join(Iterator<? extends Map.Entry<?, ?>> it) {
            return appendTo(new StringBuilder(), it).toString();
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A appendTo(A a6, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            Preconditions.checkNotNull(a6);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a6.append(this.joiner.toString(next.getKey()));
                a6.append(this.keyValueSeparator);
                a6.append(this.joiner.toString(next.getValue()));
                while (it.hasNext()) {
                    a6.append(this.joiner.separator);
                    Map.Entry<?, ?> next2 = it.next();
                    a6.append(this.joiner.toString(next2.getKey()));
                    a6.append(this.keyValueSeparator);
                    a6.append(this.joiner.toString(next2.getValue()));
                }
            }
            return a6;
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder appendTo(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return appendTo(sb, iterable.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder appendTo(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                appendTo((MapJoiner) sb, it);
                return sb;
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a6, Iterable<?> iterable) throws IOException {
        return (A) appendTo((Joiner) a6, iterable.iterator());
    }

    public final String join(Iterable<?> iterable) {
        return join(iterable.iterator());
    }

    public MapJoiner withKeyValueSeparator(char c6) {
        return withKeyValueSeparator(String.valueOf(c6));
    }

    private Joiner(String str) {
        this.separator = (String) Preconditions.checkNotNull(str);
    }

    public static Joiner on(char c6) {
        return new Joiner(String.valueOf(c6));
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a6, Iterator<?> it) throws IOException {
        Preconditions.checkNotNull(a6);
        if (it.hasNext()) {
            a6.append(toString(it.next()));
            while (it.hasNext()) {
                a6.append(this.separator);
                a6.append(toString(it.next()));
            }
        }
        return a6;
    }

    public final String join(Iterator<?> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public Joiner skipNulls() {
        return new Joiner(this) { // from class: com.google.common.base.Joiner.2
            @Override // com.google.common.base.Joiner
            public <A extends Appendable> A appendTo(A a6, Iterator<?> it) throws IOException {
                Preconditions.checkNotNull(a6, "appendable");
                Preconditions.checkNotNull(it, "parts");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (next != null) {
                        a6.append(Joiner.this.toString(next));
                        break;
                    }
                }
                while (it.hasNext()) {
                    Object next2 = it.next();
                    if (next2 != null) {
                        a6.append(Joiner.this.separator);
                        a6.append(Joiner.this.toString(next2));
                    }
                }
                return a6;
            }

            @Override // com.google.common.base.Joiner
            public Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }

            @Override // com.google.common.base.Joiner
            public MapJoiner withKeyValueSeparator(String str) {
                throw new UnsupportedOperationException("can't use .skipNulls() with maps");
            }
        };
    }

    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(str);
    }

    private static Iterable<Object> iterable(final Object obj, final Object obj2, final Object[] objArr) {
        Preconditions.checkNotNull(objArr);
        return new AbstractList<Object>() { // from class: com.google.common.base.Joiner.3
            @Override // java.util.AbstractList, java.util.List
            public Object get(int i6) {
                return i6 != 0 ? i6 != 1 ? objArr[i6 - 2] : obj2 : obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return objArr.length + 2;
            }
        };
    }

    public final String join(Object[] objArr) {
        return join(Arrays.asList(objArr));
    }

    CharSequence toString(Object obj) {
        Preconditions.checkNotNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public Joiner useForNull(final String str) {
        Preconditions.checkNotNull(str);
        return new Joiner(this) { // from class: com.google.common.base.Joiner.1
            @Override // com.google.common.base.Joiner
            public Joiner skipNulls() {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            @Override // com.google.common.base.Joiner
            CharSequence toString(@NullableDecl Object obj) {
                return obj == null ? str : Joiner.this.toString(obj);
            }

            @Override // com.google.common.base.Joiner
            public Joiner useForNull(String str2) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    public final String join(@NullableDecl Object obj, @NullableDecl Object obj2, Object... objArr) {
        return join(iterable(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a6, Object[] objArr) throws IOException {
        return (A) appendTo((Joiner) a6, (Iterable<?>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a6, @NullableDecl Object obj, @NullableDecl Object obj2, Object... objArr) throws IOException {
        return (A) appendTo((Joiner) a6, iterable(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Iterable<?> iterable) {
        return appendTo(sb, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Iterator<?> it) {
        try {
            appendTo((Joiner) sb, it);
            return sb;
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Object[] objArr) {
        return appendTo(sb, (Iterable<?>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, @NullableDecl Object obj, @NullableDecl Object obj2, Object... objArr) {
        return appendTo(sb, iterable(obj, obj2, objArr));
    }
}
