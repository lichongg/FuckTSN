package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class MultiValueSet<C> {
    private Set<C> mSet = new HashSet();

    @Override // 
    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract MultiValueSet<C> mo0clone();

    public void addAll(@NonNull List<C> list) {
        this.mSet.addAll(list);
    }

    @NonNull
    public List<C> getAllItems() {
        return Collections.unmodifiableList(new ArrayList(this.mSet));
    }
}
