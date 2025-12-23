package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;

    @LazyInit
    @MonotonicNonNullDecl
    private transient Converter<B, A> reverse;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        @Override // com.google.common.base.Converter
        @NullableDecl
        A correctedDoBackward(@NullableDecl C c6) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(c6));
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        C correctedDoForward(@NullableDecl A a6) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(a6));
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(C c6) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected C doForward(A a6) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof ConverterComposition) {
                ConverterComposition converterComposition = (ConverterComposition) obj;
                if (this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(function);
            this.backwardFunction = (Function) Preconditions.checkNotNull(function2);
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(B b6) {
            return this.backwardFunction.apply(b6);
        }

        @Override // com.google.common.base.Converter
        protected B doForward(A a6) {
            return this.forwardFunction.apply(a6);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof FunctionBasedConverter) {
                FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
                if (this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter INSTANCE = new IdentityConverter();
        private static final long serialVersionUID = 0;

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        public String toString() {
            return "Converter.identity()";
        }

        private IdentityConverter() {
        }

        @Override // com.google.common.base.Converter
        protected T doBackward(T t5) {
            return t5;
        }

        @Override // com.google.common.base.Converter
        protected T doForward(T t5) {
            return t5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        @Override // com.google.common.base.Converter
        @NullableDecl
        B correctedDoBackward(@NullableDecl A a6) {
            return this.original.correctedDoForward(a6);
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        A correctedDoForward(@NullableDecl B b6) {
            return this.original.correctedDoBackward(b6);
        }

        @Override // com.google.common.base.Converter
        protected B doBackward(A a6) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected A doForward(B b6) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }

        ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }
    }

    protected Converter() {
        this(true);
    }

    @ForOverride
    protected abstract A doBackward(B b6);

    @ForOverride
    protected abstract B doForward(A a6);

    Converter(boolean z5) {
        this.handleNullAutomatically = z5;
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() { // from class: com.google.common.base.Converter.1
            @Override // java.lang.Iterable
            public Iterator<B> iterator() {
                return new Iterator<B>() { // from class: com.google.common.base.Converter.1.1
                    private final Iterator<? extends A> fromIterator;

                    {
                        this.fromIterator = iterable.iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.fromIterator.hasNext();
                    }

                    @Override // java.util.Iterator
                    public B next() {
                        return (B) Converter.this.convert(this.fromIterator.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.fromIterator.remove();
                    }
                };
            }
        };
    }

    @NullableDecl
    A correctedDoBackward(@NullableDecl B b6) {
        if (!this.handleNullAutomatically) {
            return doBackward(b6);
        }
        if (b6 == null) {
            return null;
        }
        return (A) Preconditions.checkNotNull(doBackward(b6));
    }

    @NullableDecl
    B correctedDoForward(@NullableDecl A a6) {
        if (!this.handleNullAutomatically) {
            return doForward(a6);
        }
        if (a6 == null) {
            return null;
        }
        return (B) Preconditions.checkNotNull(doForward(a6));
    }

    <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    @CanIgnoreReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.google.common.base.Function
    @CanIgnoreReturnValue
    @NullableDecl
    @Deprecated
    public final B apply(@NullableDecl A a6) {
        return convert(a6);
    }

    @CanIgnoreReturnValue
    @NullableDecl
    public final B convert(@NullableDecl A a6) {
        return correctedDoForward(a6);
    }

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }
}
