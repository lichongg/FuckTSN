package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.a;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.az.tl;
import com.ss.android.socialbase.downloader.g.g;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class r extends tl<Long, Bitmap> {

    /* renamed from: j, reason: collision with root package name */
    private final Map<Long, SoftReference<c>> f37718j;

    class a implements a.e.InterfaceC0732a<Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f37719a;

        a(long j6) {
            this.f37719a = j6;
        }

        @Override // com.ss.android.downloadlib.a.e.InterfaceC0732a
        public Object j(Object obj) {
            SoftReference softReference = (SoftReference) r.this.f37718j.remove(Long.valueOf(this.f37719a));
            if (softReference == null || softReference.get() == null) {
                return null;
            }
            ((c) softReference.get()).j(r.this.get(Long.valueOf(this.f37719a)));
            return null;
        }
    }

    class b implements a.e.InterfaceC0732a<Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f37721a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f37722b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f37723c;

        @Override // com.ss.android.downloadlib.a.e.InterfaceC0732a
        public Object j(Object obj) {
            BufferedInputStream bufferedInputStream;
            Throwable th;
            g j6;
            try {
                j6 = com.ss.android.socialbase.downloader.downloader.cw.j(true, 0, this.f37721a, null);
            } catch (Exception e6) {
                e = e6;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                bufferedInputStream = null;
                th = th2;
                m.j(bufferedInputStream);
                throw th;
            }
            if (j6 == null) {
                m.j(null);
                return null;
            }
            bufferedInputStream = new BufferedInputStream(j6.j());
            try {
                try {
                    bufferedInputStream.mark(bufferedInputStream.available());
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    int i6 = options.outWidth;
                    int i7 = options.outHeight;
                    int f6 = a.h.f(com.ss.android.downloadlib.addownload.m.getContext(), 60.0f);
                    options.inSampleSize = r.xt(f6, f6, options);
                    options.inJustDecodeBounds = false;
                    bufferedInputStream.reset();
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                        jSONObject.putOpt("bm_original_w", Integer.valueOf(i6));
                        jSONObject.putOpt("bm_original_h", Integer.valueOf(i7));
                        jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                    } catch (Exception e7) {
                        vl.j(e7);
                    }
                    com.ss.android.downloadlib.r.b.a().q("ttd_pref_monitor", jSONObject, this.f37722b);
                    r.this.put(Long.valueOf(this.f37723c), decodeStream);
                    m.j(bufferedInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    m.j(bufferedInputStream);
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                com.ss.android.downloadlib.up.a.a().j(e, "BitmapCache loadBitmap");
                m.j(bufferedInputStream);
                return null;
            }
            return null;
        }

        b(String str, long j6, long j7) {
            this.f37721a = str;
            this.f37722b = j6;
            this.f37723c = j7;
        }
    }

    public interface c {
        void j(Bitmap bitmap);
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private static r f37725a = new r(null);
    }

    /* synthetic */ r(a aVar) {
        this();
    }

    private r() {
        super(8, 8);
        this.f37718j = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int xt(int i6, int i7, BitmapFactory.Options options) {
        int i8 = options.outWidth;
        if (i8 > i6 || options.outHeight > i7) {
            return Math.min(Math.round(i8 / i6), Math.round(options.outHeight / i7));
        }
        return 1;
    }

    public static r j() {
        return d.f37725a;
    }

    public void j(long j6, @NonNull c cVar) {
        if (get(Long.valueOf(j6)) != null) {
            cVar.j(get(Long.valueOf(j6)));
        } else {
            this.f37718j.put(Long.valueOf(j6), new SoftReference<>(cVar));
        }
    }

    public void j(long j6, long j7, String str) {
        if (get(Long.valueOf(j6)) != null) {
            SoftReference<c> remove = this.f37718j.remove(Long.valueOf(j6));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().j(get(Long.valueOf(j6)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.ss.android.downloadlib.addownload.compliance.a.a(12, j7);
        } else {
            a.e.c(new b(str, j7, j6), null).b(new a(j6)).d();
        }
    }
}
