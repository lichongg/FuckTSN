package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.Data;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class OverwritingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    @NonNull
    public Data merge(@NonNull List<Data> inputs) {
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        Iterator<Data> it = inputs.iterator();
        while (it.hasNext()) {
            hashMap.putAll(it.next().getKeyValueMap());
        }
        builder.putAll(hashMap);
        return builder.build();
    }
}
