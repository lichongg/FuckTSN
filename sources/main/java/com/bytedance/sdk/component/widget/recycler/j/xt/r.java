package com.bytedance.sdk.component.widget.recycler.j.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class r {

    public interface j<T> {
        T j();

        boolean j(T t5);
    }

    public static class xt<T> implements j<T> {

        /* renamed from: j, reason: collision with root package name */
        private final Object[] f27083j;
        private int xt;

        private boolean xt(T t5) {
            for (int i6 = 0; i6 < this.xt; i6++) {
                if (this.f27083j[i6] == t5) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.j.xt.r.j
        public T j() {
            int i6 = this.xt;
            if (i6 <= 0) {
                return null;
            }
            int i7 = i6 - 1;
            Object[] objArr = this.f27083j;
            T t5 = (T) objArr[i7];
            objArr[i7] = null;
            this.xt = i6 - 1;
            return t5;
        }

        public xt(int i6) {
            if (i6 > 0) {
                this.f27083j = new Object[i6];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // com.bytedance.sdk.component.widget.recycler.j.xt.r.j
        public boolean j(T t5) {
            if (!xt(t5)) {
                int i6 = this.xt;
                Object[] objArr = this.f27083j;
                if (i6 >= objArr.length) {
                    return false;
                }
                objArr[i6] = t5;
                this.xt = i6 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }
}
