package io.netty.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface UncheckedBooleanSupplier extends BooleanSupplier {
    public static final UncheckedBooleanSupplier FALSE_SUPPLIER = new UncheckedBooleanSupplier() { // from class: io.netty.util.UncheckedBooleanSupplier.1
        @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
        public boolean get() {
            return false;
        }
    };
    public static final UncheckedBooleanSupplier TRUE_SUPPLIER = new UncheckedBooleanSupplier() { // from class: io.netty.util.UncheckedBooleanSupplier.2
        @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
        public boolean get() {
            return true;
        }
    };

    @Override // io.netty.util.BooleanSupplier
    boolean get();
}
