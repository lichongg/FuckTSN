package io.netty.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Signal extends Error implements Constant<Signal> {
    private static final ConstantPool<Signal> pool = new ConstantPool<Signal>() { // from class: io.netty.util.Signal.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.ConstantPool
        public Signal newConstant(int i6, String str) {
            return new Signal(i6, str);
        }
    };
    private static final long serialVersionUID = -221145131122459977L;
    private final SignalConstant constant;

    public static Signal valueOf(String str) {
        return pool.valueOf(str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SignalConstant extends AbstractConstant<SignalConstant> {
        SignalConstant(int i6, String str) {
            super(i6, str);
        }
    }

    private Signal(int i6, String str) {
        this.constant = new SignalConstant(i6, str);
    }

    public static Signal valueOf(Class<?> cls, String str) {
        return pool.valueOf(cls, str);
    }

    @Override // java.lang.Comparable
    public int compareTo(Signal signal) {
        if (this == signal) {
            return 0;
        }
        return this.constant.compareTo(signal.constant);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public void expect(Signal signal) {
        if (this == signal) {
            return;
        }
        throw new IllegalStateException("unexpected signal: " + signal);
    }

    @Override // io.netty.util.Constant
    public int id() {
        return this.constant.id();
    }

    @Override // io.netty.util.Constant
    public String name() {
        return this.constant.name();
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return name();
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public Throwable initCause(Throwable th) {
        return this;
    }
}
