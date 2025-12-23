package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class Quirks {

    @NonNull
    private final List<Quirk> mQuirks;

    public boolean contains(@NonNull Class<? extends Quirk> cls) {
        Iterator<Quirk> it = this.mQuirks.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next().getClass())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public <T extends Quirk> T get(@NonNull Class<T> cls) {
        Iterator<Quirk> it = this.mQuirks.iterator();
        while (it.hasNext()) {
            T t5 = (T) it.next();
            if (t5.getClass() == cls) {
                return t5;
            }
        }
        return null;
    }

    @NonNull
    public <T extends Quirk> List<T> getAll(@NonNull Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (Quirk quirk : this.mQuirks) {
            if (cls.isAssignableFrom(quirk.getClass())) {
                arrayList.add(quirk);
            }
        }
        return arrayList;
    }

    public Quirks(@NonNull List<Quirk> list) {
        this.mQuirks = new ArrayList(list);
    }
}
