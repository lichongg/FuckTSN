package com.bykv.vk.openvk.component.video.j.j;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.j.j.j.cw;
import com.bykv.vk.openvk.component.video.j.j.j.xt;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends MediaDataSource {

    /* renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, j> f22982j = new ConcurrentHashMap<>();
    private long cw = -2147483648L;

    /* renamed from: r, reason: collision with root package name */
    private final Context f22983r;
    private final r up;
    private final cw xt;

    public r j() {
        return this.up;
    }

    public static j j(Context context, r rVar) {
        j jVar = new j(context, rVar);
        f22982j.put(rVar.i(), jVar);
        return jVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.bykv.vk.openvk.component.video.api.m.cw.j("SdkMediaDataSource", "close: ", this.up.av());
        cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.cw();
        }
        f22982j.remove(this.up.i());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.cw == -2147483648L) {
            if (this.f22983r == null || TextUtils.isEmpty(this.up.av())) {
                return -1L;
            }
            this.cw = this.xt.r();
            com.bykv.vk.openvk.component.video.api.m.cw.j("SdkMediaDataSource", "getSize: " + this.cw);
        }
        return this.cw;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j6, byte[] bArr, int i6, int i7) throws IOException {
        return this.xt.j(j6, bArr, i6, i7);
    }

    public j(Context context, r rVar) {
        this.f22983r = context;
        this.up = rVar;
        this.xt = new xt(context, rVar);
    }
}
