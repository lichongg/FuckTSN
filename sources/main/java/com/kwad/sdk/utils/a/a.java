package com.kwad.sdk.utils.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class h extends j {
        @Override // com.kwad.sdk.utils.a.a.b
        final byte Sp() {
            return (byte) 8;
        }

        h(int i6, int i7, Object obj, int i8, boolean z5) {
            super(i6, i7, obj, i8, z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.utils.a.a$a, reason: collision with other inner class name */
    static class C0710a extends j {
        @Override // com.kwad.sdk.utils.a.a.b
        final byte Sp() {
            return (byte) 7;
        }

        C0710a(int i6, int i7, Object obj, int i8, boolean z5) {
            super(i6, i7, obj, i8, z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class b {
        int offset;

        abstract byte Sp();

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends b {
        boolean value;

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Sp() {
            return (byte) 1;
        }

        c(int i6, boolean z5) {
            this.offset = i6;
            this.value = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d extends b {
        double value;

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Sp() {
            return (byte) 5;
        }

        d(int i6, double d6) {
            this.offset = i6;
            this.value = d6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e extends b {
        float value;

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Sp() {
            return (byte) 3;
        }

        e(int i6, float f6) {
            this.offset = i6;
            this.value = f6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f extends b {
        int value;

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Sp() {
            return (byte) 2;
        }

        f(int i6, int i7) {
            this.offset = i6;
            this.value = i7;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g extends b {
        long value;

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Sp() {
            return (byte) 4;
        }

        g(int i6, long j6) {
            this.offset = i6;
            this.value = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class i extends j {
        @Override // com.kwad.sdk.utils.a.a.b
        final byte Sp() {
            return (byte) 6;
        }

        i(int i6, int i7, String str, int i8, boolean z5) {
            super(i6, i7, str, i8, z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class j extends b {
        int bbS;
        boolean bbT;
        int start;
        Object value;

        j(int i6, int i7, Object obj, int i8, boolean z5) {
            this.start = i6;
            this.offset = i7;
            this.value = obj;
            this.bbS = i8;
            this.bbT = z5;
        }
    }
}
