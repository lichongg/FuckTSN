package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ParcelCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static <T extends Parcelable> List<T> readParcelableList(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader) {
            return parcel.readParcelableList(list, classLoader);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static Parcelable.Creator<?> readParcelableCreator(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            return parcel.readParcelableCreator(classLoader);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static <T> T[] readArray(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return (T[]) parcel.readArray(classLoader, cls);
        }

        @DoNotInline
        static <T> ArrayList<T> readArrayList(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readArrayList(classLoader, cls);
        }

        @DoNotInline
        static <V, K> HashMap<K, V> readHashMap(Parcel parcel, ClassLoader classLoader, Class<? extends K> cls, Class<? extends V> cls2) {
            return parcel.readHashMap(classLoader, cls, cls2);
        }

        @DoNotInline
        static <T> void readList(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            parcel.readList(list, classLoader, cls);
        }

        @DoNotInline
        static <K, V> void readMap(Parcel parcel, Map<? super K, ? super V> map, ClassLoader classLoader, Class<K> cls, Class<V> cls2) {
            parcel.readMap(map, classLoader, cls, cls2);
        }

        @DoNotInline
        static <T extends Parcelable> T readParcelable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return (T) parcel.readParcelable(classLoader, cls);
        }

        @DoNotInline
        static <T> T[] readParcelableArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return (T[]) parcel.readParcelableArray(classLoader, cls);
        }

        @DoNotInline
        static <T> Parcelable.Creator<T> readParcelableCreator(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return parcel.readParcelableCreator(classLoader, cls);
        }

        @DoNotInline
        static <T> List<T> readParcelableList(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return parcel.readParcelableList(list, classLoader, cls);
        }

        @DoNotInline
        static <T extends Serializable> T readSerializable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return (T) parcel.readSerializable(classLoader, cls);
        }

        @DoNotInline
        static <T> SparseArray<T> readSparseArray(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readSparseArray(classLoader, cls);
        }
    }

    @Nullable
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static <T> Object[] readArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.readArray(parcel, classLoader, cls) : parcel.readArray(classLoader);
    }

    @Nullable
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> readArrayList(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.readArrayList(parcel, classLoader, cls) : parcel.readArrayList(classLoader);
    }

    @Nullable
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <K, V> HashMap<K, V> readHashMap(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends K> cls, @NonNull Class<? extends V> cls2) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.readHashMap(parcel, classLoader, cls, cls2) : parcel.readHashMap(classLoader);
    }

    public static <T> void readList(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api33Impl.readList(parcel, list, classLoader, cls);
        } else {
            parcel.readList(list, classLoader);
        }
    }

    public static <K, V> void readMap(@NonNull Parcel parcel, @NonNull Map<? super K, ? super V> map, @Nullable ClassLoader classLoader, @NonNull Class<K> cls, @NonNull Class<V> cls2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api33Impl.readMap(parcel, map, classLoader, cls, cls2);
        } else {
            parcel.readMap(map, classLoader);
        }
    }

    @Nullable
    public static <T extends Parcelable> T readParcelable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (T) Api33Impl.readParcelable(parcel, classLoader, cls);
        }
        T t5 = (T) parcel.readParcelable(classLoader);
        if (t5 == null || cls.isInstance(t5)) {
            return t5;
        }
        throw new BadParcelableException("Parcelable " + t5.getClass() + " is not a subclass of required class " + cls.getName() + " provided in the parameter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Deprecated
    public static <T> T[] readParcelableArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (T[]) Api33Impl.readParcelableArray(parcel, classLoader, cls);
        }
        T[] tArr = (T[]) parcel.readParcelableArray(classLoader);
        if (cls.isAssignableFrom(Parcelable.class)) {
            return tArr;
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, tArr.length));
        for (int i6 = 0; i6 < tArr.length; i6++) {
            try {
                tArr2[i6] = cls.cast(tArr[i6]);
            } catch (ClassCastException unused) {
                throw new BadParcelableException("Parcelable at index " + i6 + " is not a subclass of required class " + cls.getName() + " provided in the parameter");
            }
        }
        return tArr2;
    }

    @Nullable
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static <T> Parcelable[] readParcelableArrayTyped(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? (Parcelable[]) Api33Impl.readParcelableArray(parcel, classLoader, cls) : parcel.readParcelableArray(classLoader);
    }

    @Nullable
    @RequiresApi(30)
    public static <T> Parcelable.Creator<T> readParcelableCreator(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.readParcelableCreator(parcel, classLoader, cls) : (Parcelable.Creator<T>) Api30Impl.readParcelableCreator(parcel, classLoader);
    }

    @NonNull
    @RequiresApi(api = 29)
    public static <T> List<T> readParcelableList(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.readParcelableList(parcel, list, classLoader, cls) : Api29Impl.readParcelableList(parcel, list, classLoader);
    }

    @Nullable
    public static <T extends Serializable> T readSerializable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return Build.VERSION.SDK_INT >= 33 ? (T) Api33Impl.readSerializable(parcel, classLoader, cls) : (T) parcel.readSerializable();
    }

    @Nullable
    public static <T> SparseArray<T> readSparseArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.readSparseArray(parcel, classLoader, cls) : parcel.readSparseArray(classLoader);
    }

    private ParcelCompat() {
    }

    public static boolean readBoolean(@NonNull Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static void writeBoolean(@NonNull Parcel parcel, boolean z5) {
        parcel.writeInt(z5 ? 1 : 0);
    }
}
