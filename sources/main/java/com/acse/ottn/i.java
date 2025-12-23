package com.acse.ottn;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class i implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<a> f4629a = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(i iVar);

        void b(i iVar);

        void c(i iVar);

        void d(i iVar);
    }

    public abstract i a(long j6);

    public abstract void a(Interpolator interpolator);

    public void a(Object obj) {
    }

    public void b() {
    }

    public abstract void b(long j6);

    public abstract long c();

    public abstract long e();

    public abstract boolean f();

    public void a(a aVar) {
        if (this.f4629a == null) {
            this.f4629a = new ArrayList<>();
        }
        this.f4629a.add(aVar);
    }

    public void b(a aVar) {
        ArrayList<a> arrayList = this.f4629a;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(aVar);
        if (this.f4629a.size() == 0) {
            this.f4629a = null;
        }
    }

    public ArrayList<a> d() {
        return this.f4629a;
    }

    public void h() {
        ArrayList<a> arrayList = this.f4629a;
        if (arrayList != null) {
            arrayList.clear();
            this.f4629a = null;
        }
    }

    public boolean g() {
        return f();
    }

    @Override // 
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public i clone() {
        try {
            i iVar = (i) super.clone();
            ArrayList<a> arrayList = this.f4629a;
            if (arrayList != null) {
                iVar.f4629a = new ArrayList<>();
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    iVar.f4629a.add(arrayList.get(i6));
                }
            }
            return iVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public void cancel() {
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }
}
