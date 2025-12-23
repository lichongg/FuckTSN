package androidx.collection;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class ArraySetJvmUtil {
    static <T> T[] resizeForToArray(T[] tArr, int i6) {
        if (tArr.length < i6) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i6));
        }
        if (tArr.length > i6) {
            tArr[i6] = null;
        }
        return tArr;
    }

    private ArraySetJvmUtil() {
    }
}
