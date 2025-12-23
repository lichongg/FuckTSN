package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import androidx.annotation.RequiresApi;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 30)
/* loaded from: D:\Downloads\app\classes5.dex */
final class ResourcesLoaderUtils {
    static boolean isColorResource(int i6) {
        return 28 <= i6 && i6 <= 31;
    }

    private ResourcesLoaderUtils() {
    }

    static boolean addResourcesLoaderToContext(Context context, Map<Integer, Integer> map) {
        ResourcesLoader create = ColorResourcesLoaderCreator.create(context, map);
        if (create != null) {
            context.getResources().addLoaders(create);
            return true;
        }
        return false;
    }
}
