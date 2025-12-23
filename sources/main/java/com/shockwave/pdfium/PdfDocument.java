package com.shockwave.pdfium;

import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class PdfDocument {

    /* renamed from: a, reason: collision with root package name */
    long f37487a;

    /* renamed from: b, reason: collision with root package name */
    ParcelFileDescriptor f37488b;

    /* renamed from: c, reason: collision with root package name */
    final Map<Integer, Long> f37489c = new ArrayMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Bookmark {

        /* renamed from: a, reason: collision with root package name */
        private List<Bookmark> f37490a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        String f37491b;

        /* renamed from: c, reason: collision with root package name */
        long f37492c;

        /* renamed from: d, reason: collision with root package name */
        long f37493d;

        public List<Bookmark> a() {
            return this.f37490a;
        }

        public long b() {
            return this.f37492c;
        }

        public String c() {
            return this.f37491b;
        }

        public boolean d() {
            return !this.f37490a.isEmpty();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Link {

        /* renamed from: a, reason: collision with root package name */
        private RectF f37494a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f37495b;

        /* renamed from: c, reason: collision with root package name */
        private String f37496c;

        public RectF a() {
            return this.f37494a;
        }

        public Integer b() {
            return this.f37495b;
        }

        public String c() {
            return this.f37496c;
        }

        public Link(RectF rectF, Integer num, String str) {
            this.f37494a = rectF;
            this.f37495b = num;
            this.f37496c = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Meta {

        /* renamed from: a, reason: collision with root package name */
        String f37497a;

        /* renamed from: b, reason: collision with root package name */
        String f37498b;

        /* renamed from: c, reason: collision with root package name */
        String f37499c;

        /* renamed from: d, reason: collision with root package name */
        String f37500d;

        /* renamed from: e, reason: collision with root package name */
        String f37501e;

        /* renamed from: f, reason: collision with root package name */
        String f37502f;

        /* renamed from: g, reason: collision with root package name */
        String f37503g;

        /* renamed from: h, reason: collision with root package name */
        String f37504h;

        public String a() {
            return this.f37498b;
        }

        public String b() {
            return this.f37503g;
        }

        public String c() {
            return this.f37501e;
        }

        public String d() {
            return this.f37500d;
        }

        public String e() {
            return this.f37504h;
        }

        public String f() {
            return this.f37502f;
        }

        public String g() {
            return this.f37499c;
        }

        public String h() {
            return this.f37497a;
        }
    }

    public boolean a(int i6) {
        return this.f37489c.containsKey(Integer.valueOf(i6));
    }

    PdfDocument() {
    }
}
