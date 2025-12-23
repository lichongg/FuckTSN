package rx.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    final int f54148a;

    /* renamed from: b, reason: collision with root package name */
    Object[] f54149b;

    /* renamed from: c, reason: collision with root package name */
    Object[] f54150c;

    /* renamed from: d, reason: collision with root package name */
    volatile int f54151d;

    /* renamed from: e, reason: collision with root package name */
    int f54152e;

    List<Object> A() {
        int i6 = this.f54148a;
        int i7 = this.f54151d;
        ArrayList arrayList = new ArrayList(i7 + 1);
        Object[] f6 = f();
        int i8 = 0;
        while (true) {
            int i9 = 0;
            while (i8 < i7) {
                arrayList.add(f6[i9]);
                i8++;
                i9++;
                if (i9 == i6) {
                    break;
                }
            }
            return arrayList;
            f6 = f6[i6];
        }
    }

    public void d(Object obj) {
        if (this.f54151d == 0) {
            Object[] objArr = new Object[this.f54148a + 1];
            this.f54149b = objArr;
            this.f54150c = objArr;
            objArr[0] = obj;
            this.f54152e = 1;
            this.f54151d = 1;
            return;
        }
        int i6 = this.f54152e;
        int i7 = this.f54148a;
        if (i6 != i7) {
            this.f54150c[i6] = obj;
            this.f54152e = i6 + 1;
            this.f54151d++;
        } else {
            Object[] objArr2 = new Object[i7 + 1];
            objArr2[0] = obj;
            this.f54150c[i7] = objArr2;
            this.f54150c = objArr2;
            this.f54152e = 1;
            this.f54151d++;
        }
    }

    public int e() {
        return this.f54148a;
    }

    public Object[] f() {
        return this.f54149b;
    }

    public int g() {
        return this.f54152e;
    }

    public int j() {
        return this.f54151d;
    }

    public Object[] s() {
        return this.f54150c;
    }

    public f(int i6) {
        this.f54148a = i6;
    }

    public String toString() {
        return A().toString();
    }
}
