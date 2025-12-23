package com.acse.ottn;

import androidx.annotation.ColorInt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class q1 {

    /* renamed from: a, reason: collision with root package name */
    public int f5006a;

    /* renamed from: b, reason: collision with root package name */
    public int f5007b;

    /* renamed from: k, reason: collision with root package name */
    public b f5016k;

    /* renamed from: c, reason: collision with root package name */
    public int f5008c = 1;

    /* renamed from: d, reason: collision with root package name */
    public int f5009d = u.f5362i;

    /* renamed from: e, reason: collision with root package name */
    public int f5010e = u.f5360g;

    /* renamed from: f, reason: collision with root package name */
    public int f5011f = u.f5361h;

    /* renamed from: g, reason: collision with root package name */
    @ColorInt
    public int f5012g = u.f5358e;

    /* renamed from: h, reason: collision with root package name */
    @ColorInt
    public int f5013h = u.f5359f;

    /* renamed from: i, reason: collision with root package name */
    public int f5014i = u.f5365l;

    /* renamed from: j, reason: collision with root package name */
    public int f5015j = u.f5364k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5017l = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f5018a = 0;

        /* renamed from: b, reason: collision with root package name */
        public static final int f5019b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f5020c = 2;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f5021a;

        /* renamed from: b, reason: collision with root package name */
        public int f5022b;

        /* renamed from: c, reason: collision with root package name */
        public int f5023c;

        /* renamed from: d, reason: collision with root package name */
        public int f5024d;

        public b() {
            this(u.f5363j);
        }

        public b(int i6) {
            this(i6, i6, i6, i6);
        }

        public b(int i6, int i7, int i8, int i9) {
            this.f5021a = i6;
            this.f5022b = i7;
            this.f5023c = i8;
            this.f5024d = i9;
        }
    }

    public q1 a(b bVar) {
        this.f5016k = bVar;
        return this;
    }

    public int b() {
        return this.f5008c;
    }

    public int c() {
        return this.f5015j;
    }

    public int d() {
        return this.f5006a;
    }

    public int e() {
        return this.f5009d;
    }

    public b f() {
        if (this.f5016k == null) {
            a(new b());
        }
        return this.f5016k;
    }

    public int g() {
        return this.f5012g;
    }

    public int h() {
        return this.f5010e;
    }

    public q1 i(int i6) {
        this.f5013h = i6;
        return this;
    }

    public int j() {
        return this.f5013h;
    }

    public int a() {
        return this.f5007b;
    }

    public q1 b(int i6) {
        this.f5008c = i6;
        return this;
    }

    public q1 c(int i6) {
        this.f5015j = i6;
        return this;
    }

    public q1 d(int i6) {
        this.f5006a = i6;
        return this;
    }

    public q1 e(int i6) {
        this.f5009d = i6;
        return this;
    }

    public q1 g(int i6) {
        this.f5010e = i6;
        return this;
    }

    public q1 h(int i6) {
        this.f5014i = i6;
        return this;
    }

    public int i() {
        return this.f5014i;
    }

    public q1 j(int i6) {
        this.f5011f = i6;
        return this;
    }

    public int k() {
        return this.f5011f;
    }

    public boolean l() {
        return this.f5017l;
    }

    public q1 a(int i6) {
        this.f5007b = i6;
        return this;
    }

    public q1 a(boolean z5) {
        this.f5017l = z5;
        return this;
    }

    public q1 f(int i6) {
        this.f5012g = i6;
        return this;
    }
}
