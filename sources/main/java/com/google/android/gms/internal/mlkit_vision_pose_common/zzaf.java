package com.google.android.gms.internal.mlkit_vision_pose_common;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzaf implements Map.Entry {
    @Override // java.util.Map.Entry
    public abstract Object getKey();

    @Override // java.util.Map.Entry
    public abstract Object getValue();

    @Override // java.util.Map.Entry
    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (zzp.zza(getKey(), entry.getKey()) && zzp.zza(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    zzaf() {
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        Object key = getKey();
        Object value = getValue();
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

    public final String toString() {
        return String.valueOf(getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(getValue());
    }
}
