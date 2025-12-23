package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class b<T> extends u0<T> {

    /* renamed from: a, reason: collision with root package name */
    private EnumC0170b f15879a = EnumC0170b.NOT_READY;

    /* renamed from: b, reason: collision with root package name */
    private T f15880b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.repackaged.com.google.common.collect.b$b, reason: collision with other inner class name */
    private enum EnumC0170b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected abstract T a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15881a;

        static {
            int[] iArr = new int[EnumC0170b.values().length];
            f15881a = iArr;
            try {
                iArr[EnumC0170b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15881a[EnumC0170b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private boolean c() {
        this.f15879a = EnumC0170b.FAILED;
        this.f15880b = a();
        if (this.f15879a == EnumC0170b.DONE) {
            return false;
        }
        this.f15879a = EnumC0170b.READY;
        return true;
    }

    protected final T b() {
        this.f15879a = EnumC0170b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        com.bumptech.glide.repackaged.com.google.common.base.d.n(this.f15879a != EnumC0170b.FAILED);
        int i6 = a.f15881a[this.f15879a.ordinal()];
        if (i6 == 1) {
            return false;
        }
        if (i6 != 2) {
            return c();
        }
        return true;
    }

    protected b() {
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f15879a = EnumC0170b.NOT_READY;
            T t5 = this.f15880b;
            this.f15880b = null;
            return t5;
        }
        throw new NoSuchElementException();
    }
}
