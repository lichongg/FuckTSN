package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Entity
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class Preference {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "key")
    public String mKey;

    @Nullable
    @ColumnInfo(name = "long_value")
    public Long mValue;

    public Preference(@NonNull String key, boolean value) {
        this(key, value ? 1L : 0L);
    }

    public boolean equals(Object o5) {
        if (this == o5) {
            return true;
        }
        if (!(o5 instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) o5;
        if (!this.mKey.equals(preference.mKey)) {
            return false;
        }
        Long l6 = this.mValue;
        Long l7 = preference.mValue;
        return l6 != null ? l6.equals(l7) : l7 == null;
    }

    public Preference(@NonNull String key, long value) {
        this.mKey = key;
        this.mValue = Long.valueOf(value);
    }

    public int hashCode() {
        int hashCode = this.mKey.hashCode() * 31;
        Long l6 = this.mValue;
        return hashCode + (l6 != null ? l6.hashCode() : 0);
    }
}
