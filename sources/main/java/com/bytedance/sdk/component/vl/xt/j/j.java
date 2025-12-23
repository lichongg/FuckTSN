package com.bytedance.sdk.component.vl.xt.j;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.api.j.xt;
import java.io.File;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements xt {

    /* renamed from: j, reason: collision with root package name */
    private long f26931j;
    private String xt = "tt_video_reward_full";
    private String cw = "tt_video_brand";

    /* renamed from: r, reason: collision with root package name */
    private String f26933r = "tt_video_splash";
    private String up = "tt_video_default";

    /* renamed from: m, reason: collision with root package name */
    private String f26932m = null;
    private String ae = null;
    private String tl = null;

    /* renamed from: g, reason: collision with root package name */
    private String f26930g = null;
    private String oq = null;
    private String qv = null;

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public void j(String str) {
        if (!TextUtils.isEmpty(this.qv) && !this.qv.equals(str)) {
            this.f26932m = null;
            this.ae = null;
            this.tl = null;
            this.f26930g = null;
            this.oq = null;
        }
        this.qv = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public String xt() {
        if (this.tl == null) {
            this.tl = this.qv + File.separator + this.cw;
            File file = new File(this.tl);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.tl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public String cw() {
        if (this.f26930g == null) {
            this.f26930g = this.qv + File.separator + this.f26933r;
            File file = new File(this.f26930g);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f26930g;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public String r() {
        if (this.oq == null) {
            this.oq = this.qv + File.separator + this.up;
            File file = new File(this.oq);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.oq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public long xt(r rVar) {
        return this.f26931j;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public String j() {
        if (this.ae == null) {
            this.ae = this.qv + File.separator + this.xt;
            File file = new File(this.ae);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.ae;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public boolean j(r rVar) {
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(rVar.i(), rVar.up());
        if (cacheInfoByFilePath != null) {
            boolean jy = rVar.jy();
            this.f26931j = cacheInfoByFilePath.mCacheSizeFromZero;
            int xt = rVar.xt() > 0 ? rVar.xt() : rVar.m();
            if (jy) {
                xt = (int) rVar.vl();
            }
            if (cacheInfoByFilePath.mCacheSizeFromZero >= xt) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public void up() {
    }
}
