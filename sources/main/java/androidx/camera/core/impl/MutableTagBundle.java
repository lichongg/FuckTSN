package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class MutableTagBundle extends TagBundle {
    @NonNull
    public static MutableTagBundle create() {
        return new MutableTagBundle(new ArrayMap());
    }

    @NonNull
    public static MutableTagBundle from(@NonNull TagBundle tagBundle) {
        ArrayMap arrayMap = new ArrayMap();
        for (String str : tagBundle.listKeys()) {
            arrayMap.put(str, tagBundle.getTag(str));
        }
        return new MutableTagBundle(arrayMap);
    }

    public void addTagBundle(@NonNull TagBundle tagBundle) {
        Map<String, Object> map;
        Map<String, Object> map2 = this.mTagMap;
        if (map2 == null || (map = tagBundle.mTagMap) == null) {
            return;
        }
        map2.putAll(map);
    }

    public void putTag(@NonNull String str, @NonNull Object obj) {
        this.mTagMap.put(str, obj);
    }

    private MutableTagBundle(Map<String, Object> map) {
        super(map);
    }
}
