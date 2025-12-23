package androidx.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class DataBinderMapper {
    public abstract String convertBrIdToString(int i6);

    public abstract ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i6);

    public abstract ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i6);

    public abstract int getLayoutId(String str);

    @NonNull
    public List<DataBinderMapper> collectDependencies() {
        return Collections.EMPTY_LIST;
    }
}
