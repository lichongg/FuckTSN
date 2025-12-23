package com.acse.ottn;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class w1 implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public float f5410a;

    /* renamed from: b, reason: collision with root package name */
    public Class f5411b;

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f5412c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5413d = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends w1 {

        /* renamed from: e, reason: collision with root package name */
        public float f5414e;

        public a(float f6, float f7) {
            this.f5410a = f6;
            this.f5414e = f7;
            this.f5411b = Float.TYPE;
            this.f5413d = true;
        }

        @Override // com.acse.ottn.w1
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Float.class) {
                return;
            }
            this.f5414e = ((Float) obj).floatValue();
            this.f5413d = true;
        }

        @Override // com.acse.ottn.w1
        public Object e() {
            return Float.valueOf(this.f5414e);
        }

        @Override // com.acse.ottn.w1
        /* renamed from: g, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a(b(), this.f5414e);
            aVar.a(c());
            return aVar;
        }

        public float h() {
            return this.f5414e;
        }

        public a(float f6) {
            this.f5410a = f6;
            this.f5411b = Float.TYPE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends w1 {

        /* renamed from: e, reason: collision with root package name */
        public int f5415e;

        public b(float f6, int i6) {
            this.f5410a = f6;
            this.f5415e = i6;
            this.f5411b = Integer.TYPE;
            this.f5413d = true;
        }

        @Override // com.acse.ottn.w1
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Integer.class) {
                return;
            }
            this.f5415e = ((Integer) obj).intValue();
            this.f5413d = true;
        }

        @Override // com.acse.ottn.w1
        public Object e() {
            return Integer.valueOf(this.f5415e);
        }

        @Override // com.acse.ottn.w1
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public b clone() {
            b bVar = new b(b(), this.f5415e);
            bVar.a(c());
            return bVar;
        }

        public int h() {
            return this.f5415e;
        }

        public b(float f6) {
            this.f5410a = f6;
            this.f5411b = Integer.TYPE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends w1 {

        /* renamed from: e, reason: collision with root package name */
        public Object f5416e;

        @Override // com.acse.ottn.w1
        public void a(Object obj) {
            this.f5416e = obj;
            this.f5413d = obj != null;
        }

        @Override // com.acse.ottn.w1
        public Object e() {
            return this.f5416e;
        }

        @Override // com.acse.ottn.w1
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public c clone() {
            c cVar = new c(b(), this.f5416e);
            cVar.a(c());
            return cVar;
        }

        public c(float f6, Object obj) {
            boolean z5;
            Class<?> cls;
            this.f5410a = f6;
            this.f5416e = obj;
            if (obj != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f5413d = z5;
            if (z5) {
                cls = obj.getClass();
            } else {
                cls = Object.class;
            }
            this.f5411b = cls;
        }
    }

    public static w1 a(float f6, int i6) {
        return new b(f6, i6);
    }

    public static w1 b(float f6) {
        return new b(f6);
    }

    public static w1 c(float f6) {
        return new c(f6, null);
    }

    @Override // 
    /* renamed from: a */
    public abstract w1 clone();

    public abstract void a(Object obj);

    public void d(float f6) {
        this.f5410a = f6;
    }

    public abstract Object e();

    public static w1 a(float f6, float f7) {
        return new a(f6, f7);
    }

    public float b() {
        return this.f5410a;
    }

    public Interpolator c() {
        return this.f5412c;
    }

    public Class d() {
        return this.f5411b;
    }

    public boolean f() {
        return this.f5413d;
    }

    public static w1 a(float f6) {
        return new a(f6);
    }

    public static w1 a(float f6, Object obj) {
        return new c(f6, obj);
    }

    public void a(Interpolator interpolator) {
        this.f5412c = interpolator;
    }
}
