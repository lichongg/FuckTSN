package com.bykv.j.j.j.j;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.i.xt.j;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static final PluginValueSet f22771c = b(0).k();

    /* renamed from: d, reason: collision with root package name */
    public static final Function<SparseArray<Object>, Object> f22772d = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<Object> f22773a;

    /* renamed from: b, reason: collision with root package name */
    private PluginValueSet f22774b;

    static /* synthetic */ class a {
    }

    private static final class b<T, R> implements Function<T, R> {
        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
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

    private static final class c implements PluginValueSet {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray<Object> f22775a;

        /* renamed from: b, reason: collision with root package name */
        private PluginValueSet f22776b;

        /* renamed from: c, reason: collision with root package name */
        private int f22777c;

        /* synthetic */ c(SparseArray sparseArray, PluginValueSet pluginValueSet, a aVar) {
            this(sparseArray, pluginValueSet);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i6) {
            return booleanValue(i6, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i6) {
            return floatValue(i6, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i6) {
            return intValue(i6, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i6) {
            return longValue(i6, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i6) {
            return stringValue(i6, null);
        }

        private c(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
            this.f22777c = -1;
            this.f22775a = sparseArray;
            this.f22776b = pluginValueSet;
        }

        private boolean c() {
            if (this.f22775a instanceof j) {
                return true;
            }
            PluginValueSet pluginValueSet = this.f22776b;
            return pluginValueSet != null && (pluginValueSet.sparseArray() instanceof j);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T[] arrayValue(int i6, Class<T> cls) {
            Object obj = this.f22775a.get(i6);
            if (obj == null) {
                PluginValueSet pluginValueSet = this.f22776b;
                if (pluginValueSet != null) {
                    return (T[]) pluginValueSet.arrayValue(i6, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i6, boolean z5) {
            PluginValueSet pluginValueSet;
            Object obj = this.f22775a.get(i6);
            if (obj == null && (pluginValueSet = this.f22776b) != null) {
                return pluginValueSet.booleanValue(i6, z5);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z5;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean containsKey(int i6) {
            PluginValueSet pluginValueSet;
            int indexOfKey = this.f22775a.indexOfKey(i6);
            return (indexOfKey >= 0 || (pluginValueSet = this.f22776b) == null) ? indexOfKey >= 0 : pluginValueSet.containsKey(i6);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public double doubleValue(int i6) {
            PluginValueSet pluginValueSet;
            Object obj = this.f22775a.get(i6);
            if (obj == null && (pluginValueSet = this.f22776b) != null) {
                return pluginValueSet.doubleValue(i6);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i6, float f6) {
            PluginValueSet pluginValueSet;
            Object obj = this.f22775a.get(i6);
            if (obj == null && (pluginValueSet = this.f22776b) != null) {
                return pluginValueSet.floatValue(i6, f6);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f6;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i6, int i7) {
            PluginValueSet pluginValueSet;
            Object obj = this.f22775a.get(i6);
            if (obj == null && (pluginValueSet = this.f22776b) != null) {
                return pluginValueSet.intValue(i6, i7);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i7;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public Set<Integer> keys() {
            int size = this.f22775a.size();
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < size; i6++) {
                hashSet.add(Integer.valueOf(this.f22775a.keyAt(i6)));
            }
            PluginValueSet pluginValueSet = this.f22776b;
            if (pluginValueSet != null) {
                hashSet.addAll(pluginValueSet.keys());
            }
            this.f22777c = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i6, long j6) {
            PluginValueSet pluginValueSet;
            Object obj = this.f22775a.get(i6);
            if (obj == null && (pluginValueSet = this.f22776b) != null) {
                return pluginValueSet.longValue(i6, j6);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j6;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T objectValue(int i6, Class<T> cls) {
            Object obj;
            T t5 = (T) this.f22775a.get(i6);
            if (t5 == null) {
                PluginValueSet pluginValueSet = this.f22776b;
                if (pluginValueSet != null) {
                    return (T) pluginValueSet.objectValue(i6, cls);
                }
                return null;
            }
            if (b(t5)) {
                obj = com.bykv.j.j.j.j.c.a(t5).get();
                t5 = (T) obj;
            }
            if (cls.isInstance(t5)) {
                return t5;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public void remove(int i6) {
            this.f22775a.remove(i6);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int size() {
            if (this.f22777c < 0) {
                keys();
            }
            return this.f22777c;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i6, String str) {
            PluginValueSet pluginValueSet;
            Object obj = this.f22775a.get(i6);
            if (obj == null && (pluginValueSet = this.f22776b) != null) {
                return pluginValueSet.stringValue(i6, str);
            }
            if (com.bykv.j.j.j.j.b.a(obj)) {
                obj = com.bykv.j.j.j.j.c.a(obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }

        private boolean a() {
            if (r0.a.a().c() >= 6803 && r0.a.a().c() < 7000) {
                return true;
            }
            return false;
        }

        private boolean b(Object obj) {
            if (a()) {
                if (!com.bykv.j.j.j.j.b.a(obj) || f.a(obj) || (obj instanceof ValueSet)) {
                    return false;
                }
                return true;
            }
            if (!com.bykv.j.j.j.j.b.a(obj) || f.a(obj)) {
                return false;
            }
            return true;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean isEmpty() {
            if (size() <= 0) {
                return true;
            }
            return false;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            if (r0.a.a().c() < 6803 && c()) {
                return new j(this);
            }
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            PluginValueSet pluginValueSet = this.f22776b;
            if (pluginValueSet != null && (sparseArray = pluginValueSet.sparseArray()) != null && sparseArray.size() > 0) {
                for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                    sparseArray2.put(sparseArray.keyAt(i6), sparseArray.valueAt(i6));
                }
            }
            SparseArray<Object> sparseArray3 = this.f22775a;
            if (sparseArray3 != null && sparseArray3.size() > 0) {
                for (int i7 = 0; i7 < this.f22775a.size(); i7++) {
                    sparseArray2.put(this.f22775a.keyAt(i7), this.f22775a.valueAt(i7));
                }
            }
            return sparseArray2;
        }
    }

    private e(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
        this.f22773a = sparseArray;
        this.f22774b = pluginValueSet;
    }

    public static final e a() {
        return new e(new SparseArray());
    }

    public static final e b(int i6) {
        return new e(new SparseArray(i6));
    }

    public static final e i(SparseArray<Object> sparseArray) {
        return new e(sparseArray);
    }

    public static final e j(PluginValueSet pluginValueSet) {
        return new e(new SparseArray(), pluginValueSet);
    }

    public e c(int i6, double d6) {
        this.f22773a.put(i6, Double.valueOf(d6));
        return this;
    }

    public e d(int i6, float f6) {
        this.f22773a.put(i6, Float.valueOf(f6));
        return this;
    }

    public e e(int i6, int i7) {
        this.f22773a.put(i6, Integer.valueOf(i7));
        return this;
    }

    public e f(int i6, Object obj) {
        this.f22773a.put(i6, obj);
        return this;
    }

    public e g(int i6, String str) {
        this.f22773a.put(i6, str);
        return this;
    }

    public e h(int i6, boolean z5) {
        this.f22773a.put(i6, Boolean.valueOf(z5));
        return this;
    }

    public PluginValueSet k() {
        return new c(this.f22773a, this.f22774b, null);
    }

    private e(SparseArray<Object> sparseArray) {
        this.f22773a = sparseArray == null ? new SparseArray<>() : sparseArray;
    }
}
