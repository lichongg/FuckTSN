package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {CommonNetImpl.TAG, "work_spec_id"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class WorkTag {

    @NonNull
    @ColumnInfo(name = CommonNetImpl.TAG)
    public final String tag;

    @NonNull
    @ColumnInfo(name = "work_spec_id")
    public final String workSpecId;

    public WorkTag(@NonNull String tag, @NonNull String workSpecId) {
        this.tag = tag;
        this.workSpecId = workSpecId;
    }
}
