package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.base.b;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;
import xyz.adscope.common.network.cookie.db.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    static final b.C0168b f15966a = g.f15901a.j(ContainerUtils.KEY_VALUE_DELIMITER);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends s0<Object, Map.Entry<Object, Object>> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.google.common.base.a f15967b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bumptech.glide.repackaged.com.google.common.collect.s0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<Object, Object> a(Object obj) {
            return x.b(obj, this.f15967b.apply(obj));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class b implements com.bumptech.glide.repackaged.com.google.common.base.a<Map.Entry<?, ?>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15968a;

        /* renamed from: b, reason: collision with root package name */
        public static final b f15969b;

        /* renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f15970c;

        private b(String str, int i6) {
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum a extends b {
            a(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.repackaged.com.google.common.collect.x$b$b, reason: collision with other inner class name */
        enum C0173b extends b {
            C0173b(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        static {
            a aVar = new a("KEY", 0);
            f15968a = aVar;
            C0173b c0173b = new C0173b(Field.VALUE, 1);
            f15969b = c0173b;
            f15970c = new b[]{aVar, c0173b};
        }

        /* synthetic */ b(String str, int i6, a aVar) {
            this(str, i6);
        }
    }

    static boolean a(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> b(K k6, V v5) {
        return new m(k6, v5);
    }

    static <V> com.bumptech.glide.repackaged.com.google.common.base.a<Map.Entry<?, V>, V> d() {
        return b.f15969b;
    }

    static String c(Map<?, ?> map) {
        StringBuilder b6 = g.b(map.size());
        b6.append('{');
        f15966a.d(b6, map);
        b6.append('}');
        return b6.toString();
    }
}
