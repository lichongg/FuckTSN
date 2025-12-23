package com.huawei.hms.mlsdk.common;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class AppSettingHolder<T> {
    private final String persistenceKey;
    private final T setting;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppSettingHolder) {
            AppSettingHolder appSettingHolder = (AppSettingHolder) obj;
            if (this.persistenceKey.equals(appSettingHolder.persistenceKey) && this.setting.equals(appSettingHolder.setting)) {
                return true;
            }
        }
        return false;
    }

    public static <T> AppSettingHolder<T> create(String str, T t5) {
        return new AppSettingHolder<>(str, t5);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.persistenceKey, this.setting});
    }

    public final String toString() {
        String str = this.persistenceKey;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 97 + String.valueOf(this.setting).length());
        sb.append("MlModelDriverInstanceKey{persistentKey=");
        sb.append(str);
        sb.append(", setting=");
        sb.append(this.setting);
        sb.append("}");
        return sb.toString();
    }

    private AppSettingHolder(String str, T t5) {
        if (str != null) {
            if (t5 != null) {
                this.persistenceKey = str;
                this.setting = t5;
                return;
            }
            throw new NullPointerException("Null setting");
        }
        throw new NullPointerException("Null PersistentKey");
    }
}
