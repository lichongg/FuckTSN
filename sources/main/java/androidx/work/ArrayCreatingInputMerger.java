package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.Data;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ArrayCreatingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    @NonNull
    public Data merge(@NonNull List<Data> inputs) {
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        Iterator<Data> it = inputs.iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, Object> entry : it.next().getKeyValueMap().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value.getClass();
                Object obj = hashMap.get(key);
                if (obj != null) {
                    Class<?> cls2 = obj.getClass();
                    if (cls2.equals(cls)) {
                        value = cls2.isArray() ? concatenateArrays(obj, value) : concatenateNonArrays(obj, value);
                    } else if (cls2.isArray() && cls2.getComponentType().equals(cls)) {
                        value = concatenateArrayAndNonArray(obj, value);
                    } else {
                        if (!cls.isArray() || !cls.getComponentType().equals(cls2)) {
                            throw new IllegalArgumentException();
                        }
                        value = concatenateArrayAndNonArray(value, obj);
                    }
                } else if (!cls.isArray()) {
                    value = createArrayFor(value);
                }
                hashMap.put(key, value);
            }
        }
        builder.putAll(hashMap);
        return builder.build();
    }

    private Object concatenateArrayAndNonArray(Object array, Object obj) {
        int length = Array.getLength(array);
        Object newInstance = Array.newInstance(obj.getClass(), length + 1);
        System.arraycopy(array, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj);
        return newInstance;
    }

    private Object concatenateArrays(Object array1, Object array2) {
        int length = Array.getLength(array1);
        int length2 = Array.getLength(array2);
        Object newInstance = Array.newInstance(array1.getClass().getComponentType(), length + length2);
        System.arraycopy(array1, 0, newInstance, 0, length);
        System.arraycopy(array2, 0, newInstance, length, length2);
        return newInstance;
    }

    private Object concatenateNonArrays(Object obj1, Object obj2) {
        Object newInstance = Array.newInstance(obj1.getClass(), 2);
        Array.set(newInstance, 0, obj1);
        Array.set(newInstance, 1, obj2);
        return newInstance;
    }

    private Object createArrayFor(Object obj) {
        Object newInstance = Array.newInstance(obj.getClass(), 1);
        Array.set(newInstance, 0, obj);
        return newInstance;
    }
}
