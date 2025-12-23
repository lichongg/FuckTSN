package io.netty.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DomainMappingBuilder<V> {
    private final DomainNameMappingBuilder<V> builder;

    public DomainMappingBuilder(V v5) {
        this.builder = new DomainNameMappingBuilder<>(v5);
    }

    public DomainMappingBuilder<V> add(String str, V v5) {
        this.builder.add(str, v5);
        return this;
    }

    public DomainNameMapping<V> build() {
        return this.builder.build();
    }

    public DomainMappingBuilder(int i6, V v5) {
        this.builder = new DomainNameMappingBuilder<>(i6, v5);
    }
}
