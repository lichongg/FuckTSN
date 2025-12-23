package io.netty.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface HashingStrategy<T> {
    public static final HashingStrategy JAVA_HASHER = new HashingStrategy() { // from class: io.netty.util.HashingStrategy.1
        @Override // io.netty.util.HashingStrategy
        public boolean equals(Object obj, Object obj2) {
            if (obj != obj2) {
                return obj != null && obj.equals(obj2);
            }
            return true;
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(Object obj) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    };

    boolean equals(T t5, T t6);

    int hashCode(T t5);
}
