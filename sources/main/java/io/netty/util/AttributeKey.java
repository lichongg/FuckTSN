package io.netty.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class AttributeKey<T> extends AbstractConstant<AttributeKey<T>> {
    private static final ConstantPool<AttributeKey<Object>> pool = new ConstantPool<AttributeKey<Object>>() { // from class: io.netty.util.AttributeKey.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.ConstantPool
        public AttributeKey<Object> newConstant(int i6, String str) {
            return new AttributeKey<>(i6, str);
        }
    };

    public static <T> AttributeKey<T> valueOf(String str) {
        return (AttributeKey) pool.valueOf(str);
    }

    private AttributeKey(int i6, String str) {
        super(i6, str);
    }

    public static boolean exists(String str) {
        return pool.exists(str);
    }

    public static <T> AttributeKey<T> newInstance(String str) {
        return (AttributeKey) pool.newInstance(str);
    }

    public static <T> AttributeKey<T> valueOf(Class<?> cls, String str) {
        return (AttributeKey) pool.valueOf(cls, str);
    }
}
