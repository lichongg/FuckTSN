package com.bxkj.student.run.app.utils;

import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.Shader;
import com.bxkj.base.BaseApp;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class q {

    /* renamed from: h, reason: collision with root package name */
    private PathMeasure f20335h;

    /* renamed from: i, reason: collision with root package name */
    private Path f20336i;

    /* renamed from: a, reason: collision with root package name */
    private final long f20328a = 5000;

    /* renamed from: b, reason: collision with root package name */
    private final long f20329b = 2000;

    /* renamed from: c, reason: collision with root package name */
    private final int f20330c = PredefinedCaptureConfigurations.f35652s;

    /* renamed from: e, reason: collision with root package name */
    private long f20332e = 2000;

    /* renamed from: f, reason: collision with root package name */
    private final float f20333f = 2000.0f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<a> f20334g = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private int f20331d = r.e(BaseApp.c());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private Path f20337a;

        /* renamed from: b, reason: collision with root package name */
        private Shader f20338b;

        /* renamed from: c, reason: collision with root package name */
        private float f20339c;

        /* renamed from: d, reason: collision with root package name */
        private int f20340d;

        /* renamed from: e, reason: collision with root package name */
        private Point f20341e;

        /* renamed from: f, reason: collision with root package name */
        private int f20342f;

        public a(Path path, float pathLength, Shader shader) {
            this.f20337a = path;
            this.f20339c = pathLength;
            this.f20338b = shader;
        }

        public int a() {
            return this.f20342f;
        }

        public Point b() {
            return this.f20341e;
        }

        public int c() {
            return this.f20340d;
        }

        public Path d() {
            return this.f20337a;
        }

        public float e() {
            return this.f20339c;
        }

        public Shader f() {
            return this.f20338b;
        }

        public void g(int endColor) {
            this.f20342f = endColor;
        }

        public void h(Point endPoint) {
            this.f20341e = endPoint;
        }

        public void i(int index) {
            this.f20340d = index;
        }
    }

    private void b(float pathLength) {
        float f6 = pathLength / ((this.f20331d * 2000.0f) / 1080.0f);
        if (f6 <= 1.0f) {
            return;
        }
        long j6 = (long) (f6 * 2000.0f);
        if (j6 >= 5000) {
            g(5000L);
        } else {
            g(j6);
        }
    }

    public void a(Point start, Point end, int startColor, int endColor) {
        if (this.f20336i == null) {
            Path path = new Path();
            this.f20336i = path;
            path.moveTo(start.x, start.y);
            this.f20336i.lineTo(end.x, end.y);
        }
        this.f20336i.lineTo(end.x, end.y);
        Path path2 = new Path();
        path2.moveTo(start.x, start.y);
        path2.lineTo(end.x, end.y);
        this.f20335h = new PathMeasure(path2, false);
        a aVar = new a(path2, this.f20335h.getLength(), new LinearGradient(start.x, start.y, end.x, end.y, new int[]{startColor, endColor}, (float[]) null, Shader.TileMode.CLAMP));
        aVar.h(end);
        aVar.g(endColor);
        this.f20334g.add(aVar);
        aVar.i(this.f20334g.size() - 1);
    }

    public long c() {
        return this.f20332e;
    }

    public float d() {
        ArrayList<a> arrayList = this.f20334g;
        float f6 = 0.0f;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                f6 += this.f20334g.get(i6).e();
            }
        }
        b(f6);
        return f6;
    }

    public ArrayList<a> e() {
        return this.f20334g;
    }

    public Path f() {
        return this.f20336i;
    }

    public void g(long ANIM_DURATION) {
        this.f20332e = ANIM_DURATION;
    }
}
