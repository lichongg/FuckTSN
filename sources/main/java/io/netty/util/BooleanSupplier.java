package io.netty.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface BooleanSupplier {
    public static final BooleanSupplier FALSE_SUPPLIER = new BooleanSupplier() { // from class: io.netty.util.BooleanSupplier.1
        @Override // io.netty.util.BooleanSupplier
        public boolean get() {
            return false;
        }
    };
    public static final BooleanSupplier TRUE_SUPPLIER = new BooleanSupplier() { // from class: io.netty.util.BooleanSupplier.2
        @Override // io.netty.util.BooleanSupplier
        public boolean get() {
            return true;
        }
    };

    boolean get() throws Exception;
}
