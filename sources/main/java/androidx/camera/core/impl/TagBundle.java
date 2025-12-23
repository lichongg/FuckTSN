package androidx.camera.core.impl;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class TagBundle {
    private static final String CAMERAX_USER_TAG_PREFIX = "android.hardware.camera2.CaptureRequest.setTag.CX";
    private static final TagBundle EMPTY_TAGBUNDLE = new TagBundle(new ArrayMap());
    private static final String USER_TAG_PREFIX = "android.hardware.camera2.CaptureRequest.setTag.";
    protected final Map<String, Object> mTagMap;

    @NonNull
    public static TagBundle create(@NonNull Pair<String, Object> pair) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put((String) pair.first, pair.second);
        return new TagBundle(arrayMap);
    }

    @NonNull
    public static TagBundle emptyBundle() {
        return EMPTY_TAGBUNDLE;
    }

    @NonNull
    public static TagBundle from(@NonNull TagBundle tagBundle) {
        ArrayMap arrayMap = new ArrayMap();
        for (String str : tagBundle.listKeys()) {
            arrayMap.put(str, tagBundle.getTag(str));
        }
        return new TagBundle(arrayMap);
    }

    @Nullable
    public Object getTag(@NonNull String str) {
        return this.mTagMap.get(str);
    }

    @NonNull
    public Set<String> listKeys() {
        return this.mTagMap.keySet();
    }

    @NonNull
    public final String toString() {
        return CAMERAX_USER_TAG_PREFIX;
    }

    protected TagBundle(@NonNull Map<String, Object> map) {
        this.mTagMap = map;
    }
}
