package androidx.work;

import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import kotlin.Pair;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String key) {
        g0.p(data, "<this>");
        g0.p(key, "key");
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return data.hasKeyWithValueOfType(key, Object.class);
    }

    @NotNull
    public static final Data workDataOf(@NotNull Pair<String, ? extends Object>... pairs) {
        g0.p(pairs, "pairs");
        Data.Builder builder = new Data.Builder();
        int length = pairs.length;
        int i6 = 0;
        while (i6 < length) {
            Pair<String, ? extends Object> pair = pairs[i6];
            i6++;
            builder.put(pair.getFirst(), pair.getSecond());
        }
        Data build = builder.build();
        g0.o(build, "dataBuilder.build()");
        return build;
    }
}
