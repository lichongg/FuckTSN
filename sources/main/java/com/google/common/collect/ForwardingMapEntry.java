package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Map.Entry<K, V> delegate();

    protected boolean standardEquals(@NullableDecl Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (Objects.equal(getKey(), entry.getKey()) && Objects.equal(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Beta
    protected String standardToString() {
        return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
    }

    protected ForwardingMapEntry() {
    }

    @Override // java.util.Map.Entry
    public boolean equals(@NullableDecl Object obj) {
        return delegate().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return delegate().getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return delegate().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return delegate().hashCode();
    }

    public V setValue(V v5) {
        return delegate().setValue(v5);
    }

    protected int standardHashCode() {
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
