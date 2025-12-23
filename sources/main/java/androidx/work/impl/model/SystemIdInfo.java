package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class SystemIdInfo {

    @ColumnInfo(name = "system_id")
    public final int systemId;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "work_spec_id")
    public final String workSpecId;

    public boolean equals(Object o5) {
        if (this == o5) {
            return true;
        }
        if (!(o5 instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) o5;
        if (this.systemId != systemIdInfo.systemId) {
            return false;
        }
        return this.workSpecId.equals(systemIdInfo.workSpecId);
    }

    public int hashCode() {
        return (this.workSpecId.hashCode() * 31) + this.systemId;
    }

    public SystemIdInfo(@NonNull String workSpecId, int systemId) {
        this.workSpecId = workSpecId;
        this.systemId = systemId;
    }
}
