package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(19)
/* loaded from: D:\Downloads\app\classes3.dex */
public class q implements m {

    /* renamed from: d, reason: collision with root package name */
    private static final int f15047d = 8;

    /* renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f15048e;

    /* renamed from: f, reason: collision with root package name */
    private static final Bitmap.Config[] f15049f;

    /* renamed from: g, reason: collision with root package name */
    private static final Bitmap.Config[] f15050g;

    /* renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f15051h;

    /* renamed from: i, reason: collision with root package name */
    private static final Bitmap.Config[] f15052i;

    /* renamed from: a, reason: collision with root package name */
    private final c f15053a = new c();

    /* renamed from: b, reason: collision with root package name */
    private final h<b, Bitmap> f15054b = new h<>();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f15055c = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static final class b implements n {

        /* renamed from: a, reason: collision with root package name */
        private final c f15057a;

        /* renamed from: b, reason: collision with root package name */
        int f15058b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap.Config f15059c;

        public b(c cVar) {
            this.f15057a = cVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.n
        public void a() {
            this.f15057a.c(this);
        }

        public void b(int i6, Bitmap.Config config) {
            this.f15058b = i6;
            this.f15059c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f15058b == bVar.f15058b && com.bumptech.glide.util.l.d(this.f15059c, bVar.f15059c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i6 = this.f15058b * 31;
            Bitmap.Config config = this.f15059c;
            return i6 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return q.h(this.f15058b, this.f15059c);
        }

        @VisibleForTesting
        b(c cVar, int i6, Bitmap.Config config) {
            this(cVar);
            b(i6, config);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class c extends d<b> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        c() {
        }

        public b e(int i6, Bitmap.Config config) {
            b b6 = b();
            b6.b(i6, config);
            return b6;
        }
    }

    static {
        Bitmap.Config config;
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            int length = configArr.length - 1;
            config = Bitmap.Config.RGBA_F16;
            configArr[length] = config;
        }
        f15048e = configArr;
        f15049f = configArr;
        f15050g = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f15051h = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f15052i = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15056a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f15056a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15056a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15056a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15056a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private b g(int i6, Bitmap.Config config) {
        b e6 = this.f15053a.e(i6, config);
        Bitmap.Config[] i7 = i(config);
        int length = i7.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                break;
            }
            Bitmap.Config config2 = i7[i8];
            Integer ceilingKey = j(config2).ceilingKey(Integer.valueOf(i6));
            if (ceilingKey == null || ceilingKey.intValue() > i6 * 8) {
                i8++;
            } else if (ceilingKey.intValue() != i6 || (config2 != null ? !config2.equals(config) : config != null)) {
                this.f15053a.c(e6);
                return this.f15053a.e(ceilingKey.intValue(), config2);
            }
        }
        return e6;
    }

    static String h(int i6, Bitmap.Config config) {
        return "[" + i6 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config2 = Bitmap.Config.RGBA_F16;
            if (config2.equals(config)) {
                return f15049f;
            }
        }
        int i6 = a.f15056a[config.ordinal()];
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? new Bitmap.Config[]{config} : f15052i : f15051h : f15050g : f15048e;
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f15055c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f15055c.put(config, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    @Nullable
    public Bitmap removeLast() {
        Bitmap f6 = this.f15054b.f();
        if (f6 != null) {
            f(Integer.valueOf(com.bumptech.glide.util.l.h(f6)), f6);
        }
        return f6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f15054b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f15055c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f15055c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> j6 = j(bitmap.getConfig());
        Integer num2 = j6.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                j6.remove(num);
                return;
            } else {
                j6.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(bitmap) + ", this: " + this);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public String a(int i6, int i7, Bitmap.Config config) {
        return h(com.bumptech.glide.util.l.g(i6, i7, config), config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.util.l.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public String c(Bitmap bitmap) {
        return h(com.bumptech.glide.util.l.h(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public void d(Bitmap bitmap) {
        b e6 = this.f15053a.e(com.bumptech.glide.util.l.h(bitmap), bitmap.getConfig());
        this.f15054b.d(e6, bitmap);
        NavigableMap<Integer, Integer> j6 = j(bitmap.getConfig());
        Integer num = j6.get(Integer.valueOf(e6.f15058b));
        Integer valueOf = Integer.valueOf(e6.f15058b);
        int i6 = 1;
        if (num != null) {
            i6 = 1 + num.intValue();
        }
        j6.put(valueOf, Integer.valueOf(i6));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    @Nullable
    public Bitmap e(int i6, int i7, Bitmap.Config config) {
        b g6 = g(com.bumptech.glide.util.l.g(i6, i7, config), config);
        Bitmap a6 = this.f15054b.a(g6);
        if (a6 != null) {
            f(Integer.valueOf(g6.f15058b), a6);
            a6.reconfigure(i6, i7, config);
        }
        return a6;
    }
}
