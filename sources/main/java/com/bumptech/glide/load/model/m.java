package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class m<A, B> {

    /* renamed from: b, reason: collision with root package name */
    private static final int f15449b = 250;

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.util.h<b<A>, B> f15450a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends com.bumptech.glide.util.h<b<A>, B> {
        a(long j6) {
            super(j6);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.util.h
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void l(@NonNull b<A> bVar, @Nullable B b6) {
            bVar.c();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static final class b<A> {

        /* renamed from: d, reason: collision with root package name */
        private static final Queue<b<?>> f15452d = com.bumptech.glide.util.l.f(0);

        /* renamed from: a, reason: collision with root package name */
        private int f15453a;

        /* renamed from: b, reason: collision with root package name */
        private int f15454b;

        /* renamed from: c, reason: collision with root package name */
        private A f15455c;

        static <A> b<A> a(A a6, int i6, int i7) {
            b<A> bVar;
            Queue<b<?>> queue = f15452d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a6, i6, i7);
            return bVar;
        }

        private void b(A a6, int i6, int i7) {
            this.f15455c = a6;
            this.f15454b = i6;
            this.f15453a = i7;
        }

        public void c() {
            Queue<b<?>> queue = f15452d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f15454b == bVar.f15454b && this.f15453a == bVar.f15453a && this.f15455c.equals(bVar.f15455c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.f15453a * 31) + this.f15454b) * 31) + this.f15455c.hashCode();
        }

        private b() {
        }
    }

    public m() {
        this(250L);
    }

    public m(long j6) {
        this.f15450a = new a(j6);
    }

    public void a() {
        this.f15450a.b();
    }

    @Nullable
    public B b(A a6, int i6, int i7) {
        b<A> a7 = b.a(a6, i6, i7);
        B i8 = this.f15450a.i(a7);
        a7.c();
        return i8;
    }

    public void c(A a6, int i6, int i7, B b6) {
        this.f15450a.m(b.a(a6, i6, i7), b6);
    }
}
