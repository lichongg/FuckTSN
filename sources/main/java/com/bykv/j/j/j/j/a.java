package com.bykv.j.j.j.j;

import android.annotation.TargetApi;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final ValueSet f22763c = b(0).k();

    /* renamed from: d, reason: collision with root package name */
    public static final Bridge f22764d;

    /* renamed from: e, reason: collision with root package name */
    public static final Function<SparseArray<Object>, Object> f22765e;

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<Object> f22766a;

    /* renamed from: b, reason: collision with root package name */
    private ValueSet f22767b;

    /* renamed from: com.bykv.j.j.j.j.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0301a {
    }

    private static final class b implements ValueSet {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray<Object> f22768a;

        /* renamed from: b, reason: collision with root package name */
        private ValueSet f22769b;

        /* renamed from: c, reason: collision with root package name */
        private int f22770c;

        /* synthetic */ b(SparseArray sparseArray, ValueSet valueSet, C0301a c0301a) {
            this(sparseArray, valueSet);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i6) {
            return booleanValue(i6, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i6) {
            return floatValue(i6, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i6) {
            return intValue(i6, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i6) {
            return longValue(i6, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i6) {
            return stringValue(i6, null);
        }

        private b(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.f22770c = -1;
            this.f22768a = sparseArray;
            this.f22769b = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i6, Class<T> cls) {
            Object obj = this.f22768a.get(i6);
            if (obj == null) {
                ValueSet valueSet = this.f22769b;
                if (valueSet != null) {
                    return (T[]) valueSet.arrayValue(i6, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i6, boolean z5) {
            ValueSet valueSet;
            Object obj = this.f22768a.get(i6);
            if (obj == null && (valueSet = this.f22769b) != null) {
                return valueSet.booleanValue(i6, z5);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z5;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i6) {
            ValueSet valueSet;
            int indexOfKey = this.f22768a.indexOfKey(i6);
            return (indexOfKey >= 0 || (valueSet = this.f22769b) == null) ? indexOfKey >= 0 : valueSet.containsKey(i6);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i6) {
            ValueSet valueSet;
            Object obj = this.f22768a.get(i6);
            if (obj == null && (valueSet = this.f22769b) != null) {
                return valueSet.doubleValue(i6);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i6, float f6) {
            ValueSet valueSet;
            Object obj = this.f22768a.get(i6);
            if (obj == null && (valueSet = this.f22769b) != null) {
                return valueSet.floatValue(i6, f6);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f6;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i6, int i7) {
            ValueSet valueSet;
            Object obj = this.f22768a.get(i6);
            if (obj == null && (valueSet = this.f22769b) != null) {
                return valueSet.intValue(i6, i7);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i7;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f22768a.size();
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < size; i6++) {
                hashSet.add(Integer.valueOf(this.f22768a.keyAt(i6)));
            }
            ValueSet valueSet = this.f22769b;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.f22770c = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i6, long j6) {
            ValueSet valueSet;
            Object obj = this.f22768a.get(i6);
            if (obj == null && (valueSet = this.f22769b) != null) {
                return valueSet.longValue(i6, j6);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j6;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i6, Class<T> cls) {
            Object obj;
            T t5 = (T) this.f22768a.get(i6);
            if (t5 == null) {
                ValueSet valueSet = this.f22769b;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i6, cls);
                }
                return null;
            }
            if (com.bykv.j.j.j.j.b.a(t5)) {
                obj = com.bykv.j.j.j.j.c.a(t5).get();
                t5 = (T) obj;
            }
            if (cls.isInstance(t5)) {
                return t5;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public void remove(int i6) {
            this.f22768a.remove(i6);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.f22770c < 0) {
                keys();
            }
            return this.f22770c;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            ValueSet valueSet = this.f22769b;
            if (valueSet != null && (sparseArray = valueSet.sparseArray()) != null && sparseArray.size() > 0) {
                for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                    sparseArray2.put(sparseArray.keyAt(i6), sparseArray.valueAt(i6));
                }
            }
            SparseArray<Object> sparseArray3 = this.f22768a;
            if (sparseArray3 != null && sparseArray3.size() > 0) {
                for (int i7 = 0; i7 < this.f22768a.size(); i7++) {
                    sparseArray2.put(this.f22768a.keyAt(i7), this.f22768a.valueAt(i7));
                }
            }
            return sparseArray2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i6, String str) {
            ValueSet valueSet;
            Object obj = this.f22768a.get(i6);
            if (obj == null && (valueSet = this.f22769b) != null) {
                return valueSet.stringValue(i6, str);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            if (size() <= 0) {
                return true;
            }
            return false;
        }
    }

    private static final class c implements Bridge {
        private c() {
        }

        /* synthetic */ c(C0301a c0301a) {
            this();
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i6, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (T) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (T) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (T) Float.valueOf(0.0f);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return a.f22763c;
        }
    }

    @TargetApi(24)
    private static final class d<T, R> implements Function<T, R> {
        private d() {
        }

        /* synthetic */ d(C0301a c0301a) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(T t5) {
            if (!(t5 instanceof SparseArray)) {
                return null;
            }
            Class cls = (Class) ((SparseArray) t5).get(-99999985);
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (R) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (R) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (R) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (R) Double.valueOf(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (R) Float.valueOf(0.0f);
            }
            return null;
        }
    }

    static {
        C0301a c0301a = null;
        f22764d = new c(c0301a);
        f22765e = new d(c0301a);
    }

    public static final a a() {
        return new a(new SparseArray());
    }

    public static final a b(int i6) {
        return new a(new SparseArray(i6));
    }

    public static final a j(SparseArray<Object> sparseArray) {
        return new a(sparseArray);
    }

    public a c(int i6, double d6) {
        this.f22766a.put(i6, Double.valueOf(d6));
        return this;
    }

    public a d(int i6, float f6) {
        this.f22766a.put(i6, Float.valueOf(f6));
        return this;
    }

    public a e(int i6, int i7) {
        this.f22766a.put(i6, Integer.valueOf(i7));
        return this;
    }

    public a f(int i6, long j6) {
        this.f22766a.put(i6, Long.valueOf(j6));
        return this;
    }

    public a g(int i6, Object obj) {
        this.f22766a.put(i6, obj);
        return this;
    }

    public a h(int i6, String str) {
        this.f22766a.put(i6, str);
        return this;
    }

    public a i(int i6, boolean z5) {
        this.f22766a.put(i6, Boolean.valueOf(z5));
        return this;
    }

    public ValueSet k() {
        return new b(this.f22766a, this.f22767b, null);
    }

    private a(SparseArray<Object> sparseArray) {
        this.f22766a = sparseArray == null ? new SparseArray<>() : sparseArray;
    }
}
