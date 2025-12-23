package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    static final Bitmap.Config f15343e = Bitmap.Config.RGB_565;

    /* renamed from: a, reason: collision with root package name */
    private final int f15344a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15345b;

    /* renamed from: c, reason: collision with root package name */
    private final Bitmap.Config f15346c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15347d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f15348a;

        /* renamed from: b, reason: collision with root package name */
        private final int f15349b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap.Config f15350c;

        /* renamed from: d, reason: collision with root package name */
        private int f15351d;

        public a(int i6) {
            this(i6, i6);
        }

        public a(int i6, int i7) {
            this.f15351d = 1;
            if (i6 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i7 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.f15348a = i6;
            this.f15349b = i7;
        }

        d a() {
            return new d(this.f15348a, this.f15349b, this.f15350c, this.f15351d);
        }

        Bitmap.Config b() {
            return this.f15350c;
        }

        public a c(@Nullable Bitmap.Config config) {
            this.f15350c = config;
            return this;
        }

        public a d(int i6) {
            if (i6 <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.f15351d = i6;
            return this;
        }
    }

    Bitmap.Config a() {
        return this.f15346c;
    }

    int b() {
        return this.f15345b;
    }

    int c() {
        return this.f15347d;
    }

    int d() {
        return this.f15344a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f15345b == dVar.f15345b && this.f15344a == dVar.f15344a && this.f15347d == dVar.f15347d && this.f15346c == dVar.f15346c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f15344a * 31) + this.f15345b) * 31) + this.f15346c.hashCode()) * 31) + this.f15347d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f15344a + ", height=" + this.f15345b + ", config=" + this.f15346c + ", weight=" + this.f15347d + '}';
    }

    d(int i6, int i7, Bitmap.Config config, int i8) {
        this.f15346c = (Bitmap.Config) k.e(config, "Config must not be null");
        this.f15344a = i6;
        this.f15345b = i7;
        this.f15347d = i8;
    }
}
