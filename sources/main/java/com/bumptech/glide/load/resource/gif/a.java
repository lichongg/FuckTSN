package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.m;
import com.bumptech.glide.util.l;
import com.stub.StubApp;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a implements com.bumptech.glide.load.g<ByteBuffer, GifDrawable> {

    /* renamed from: f, reason: collision with root package name */
    private static final String f15713f = "BufferGifDecoder";

    /* renamed from: g, reason: collision with root package name */
    private static final C0165a f15714g = new C0165a();

    /* renamed from: h, reason: collision with root package name */
    private static final b f15715h = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Context f15716a;

    /* renamed from: b, reason: collision with root package name */
    private final List<ImageHeaderParser> f15717b;

    /* renamed from: c, reason: collision with root package name */
    private final b f15718c;

    /* renamed from: d, reason: collision with root package name */
    private final C0165a f15719d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.gif.b f15720e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.a$a, reason: collision with other inner class name */
    static class C0165a {
        GifDecoder a(GifDecoder.a aVar, com.bumptech.glide.gifdecoder.b bVar, ByteBuffer byteBuffer, int i6) {
            return new com.bumptech.glide.gifdecoder.d(aVar, bVar, byteBuffer, i6);
        }

        C0165a() {
        }
    }

    public a(Context context) {
        this(context, com.bumptech.glide.b.e(context).m().g(), com.bumptech.glide.b.e(context).h(), com.bumptech.glide.b.e(context).g());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<com.bumptech.glide.gifdecoder.c> f15721a = l.f(0);

        synchronized com.bumptech.glide.gifdecoder.c a(ByteBuffer byteBuffer) {
            com.bumptech.glide.gifdecoder.c poll;
            try {
                poll = this.f15721a.poll();
                if (poll == null) {
                    poll = new com.bumptech.glide.gifdecoder.c();
                }
            } catch (Throwable th) {
                throw th;
            }
            return poll.q(byteBuffer);
        }

        synchronized void b(com.bumptech.glide.gifdecoder.c cVar) {
            cVar.a();
            this.f15721a.offer(cVar);
        }

        b() {
        }
    }

    @Nullable
    private d c(ByteBuffer byteBuffer, int i6, int i7, com.bumptech.glide.gifdecoder.c cVar, com.bumptech.glide.load.f fVar) {
        long b6 = com.bumptech.glide.util.g.b();
        try {
            com.bumptech.glide.gifdecoder.b d6 = cVar.d();
            if (d6.b() > 0 && d6.c() == 0) {
                Bitmap.Config config = fVar.c(h.f15753a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                GifDecoder a6 = this.f15719d.a(this.f15720e, d6, byteBuffer, e(d6, i6, i7));
                a6.a(config);
                a6.i();
                Bitmap h6 = a6.h();
                if (h6 == null) {
                    if (Log.isLoggable(f15713f, 2)) {
                        com.bumptech.glide.util.g.a(b6);
                    }
                    return null;
                }
                d dVar = new d(new GifDrawable(this.f15716a, a6, m.c(), i6, i7, h6));
                if (Log.isLoggable(f15713f, 2)) {
                    com.bumptech.glide.util.g.a(b6);
                }
                return dVar;
            }
            if (Log.isLoggable(f15713f, 2)) {
                com.bumptech.glide.util.g.a(b6);
            }
            return null;
        } finally {
        }
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public d b(@NonNull ByteBuffer byteBuffer, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        com.bumptech.glide.gifdecoder.c a6 = this.f15718c.a(byteBuffer);
        try {
            return c(byteBuffer, i6, i7, a6, fVar);
        } finally {
            this.f15718c.b(a6);
        }
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return !((Boolean) fVar.c(h.f15754b)).booleanValue() && com.bumptech.glide.load.b.getType(this.f15717b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    private static int e(com.bumptech.glide.gifdecoder.b bVar, int i6, int i7) {
        int highestOneBit;
        int min = Math.min(bVar.a() / i7, bVar.d() / i6);
        if (min == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(min);
        }
        int max = Math.max(1, highestOneBit);
        if (Log.isLoggable(f15713f, 2) && max > 1) {
            bVar.d();
            bVar.a();
        }
        return max;
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this(context, list, eVar, bVar, f15715h, f15714g);
    }

    @VisibleForTesting
    a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, b bVar2, C0165a c0165a) {
        this.f15716a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f15717b = list;
        this.f15719d = c0165a;
        this.f15720e = new com.bumptech.glide.load.resource.gif.b(eVar, bVar);
        this.f15718c = bVar2;
    }
}
