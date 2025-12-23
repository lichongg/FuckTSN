package com.bumptech.glide.repackaged.com.google.common.collect;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
abstract class c<K, V> implements Map.Entry<K, V> {
    @Override // java.util.Map.Entry
    public abstract K getKey();

    @Override // java.util.Map.Entry
    public abstract V getValue();

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (com.bumptech.glide.repackaged.com.google.common.base.c.a(getKey(), entry.getKey()) && com.bumptech.glide.repackaged.com.google.common.base.c.a(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v5) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
    }

    c() {
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        int hashCode;
        K key = getKey();
        V value = getValue();
        int i6 = 0;
        if (key == null) {
            hashCode = 0;
        } else {
            hashCode = key.hashCode();
        }
        if (value != null) {
            i6 = value.hashCode();
        }
        return hashCode ^ i6;
    }
}
