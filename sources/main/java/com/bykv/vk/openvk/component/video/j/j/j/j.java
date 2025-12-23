package com.bykv.vk.openvk.component.video.j.j.j;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements com.bykv.vk.openvk.component.video.api.j.xt {

    /* renamed from: j, reason: collision with root package name */
    private String f22985j = "video_reward_full";
    private String xt = "video_brand";
    private String cw = "video_splash";

    /* renamed from: r, reason: collision with root package name */
    private String f22987r = "video_default";
    private String up = null;

    /* renamed from: m, reason: collision with root package name */
    private String f22986m = null;
    private String ae = null;
    private String tl = null;

    /* renamed from: g, reason: collision with root package name */
    private String f22984g = null;

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public void j(String str) {
        this.up = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public synchronized void up() {
        try {
            com.bykv.vk.openvk.component.video.api.m.cw.j("Exec clear video cache ");
            com.bykv.vk.openvk.component.video.api.m.cw.j(this.up);
            List<com.bykv.vk.openvk.component.video.api.j.j> m6 = m();
            if (Build.VERSION.SDK_INT >= 23) {
                Set<String> set = null;
                for (com.bykv.vk.openvk.component.video.api.j.j jVar : m6) {
                    File[] j6 = jVar.j();
                    if (j6 != null && j6.length >= jVar.xt()) {
                        if (set == null) {
                            set = ae();
                        }
                        int xt = jVar.xt() - 2;
                        if (xt < 0) {
                            xt = 0;
                        }
                        j(jVar.j(), xt, set);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public String xt() {
        if (this.ae == null) {
            this.ae = this.up + File.separator + this.xt;
            File file = new File(this.ae);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.ae;
    }

    private Set<String> ae() {
        HashSet hashSet = new HashSet();
        for (com.bykv.vk.openvk.component.video.j.j.j jVar : com.bykv.vk.openvk.component.video.j.j.j.f22982j.values()) {
            if (jVar != null && jVar.j() != null) {
                r j6 = jVar.j();
                hashSet.add(com.bykv.vk.openvk.component.video.j.up.cw.xt(j6.up(), j6.i()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.j.up.cw.cw(j6.up(), j6.i()).getAbsolutePath());
            }
        }
        for (com.bykv.vk.openvk.component.video.j.j.xt.xt xtVar : com.bykv.vk.openvk.component.video.j.j.xt.cw.f22993j.values()) {
            if (xtVar != null && xtVar.j() != null) {
                r j7 = xtVar.j();
                hashSet.add(com.bykv.vk.openvk.component.video.j.up.cw.xt(j7.up(), j7.i()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.j.up.cw.cw(j7.up(), j7.i()).getAbsolutePath());
            }
        }
        return hashSet;
    }

    private List<com.bykv.vk.openvk.component.video.api.j.j> m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bykv.vk.openvk.component.video.api.j.j(new File(j()).listFiles(), com.bykv.vk.openvk.component.video.j.j.cw()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.j.j(new File(cw()).listFiles(), com.bykv.vk.openvk.component.video.j.j.xt()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.j.j(new File(xt()).listFiles(), com.bykv.vk.openvk.component.video.j.j.r()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.j.j(new File(r()).listFiles(), com.bykv.vk.openvk.component.video.j.j.up()));
        return arrayList;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public String cw() {
        if (this.tl == null) {
            this.tl = this.up + File.separator + this.cw;
            File file = new File(this.tl);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.tl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public String j() {
        if (this.f22986m == null) {
            this.f22986m = this.up + File.separator + this.f22985j;
            File file = new File(this.f22986m);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f22986m;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public String r() {
        if (this.f22984g == null) {
            this.f22984g = this.up + File.separator + this.f22987r;
            File file = new File(this.f22984g);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f22984g;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public long xt(r rVar) {
        if (TextUtils.isEmpty(rVar.up()) || TextUtils.isEmpty(rVar.i())) {
            return 0L;
        }
        return com.bykv.vk.openvk.component.video.j.up.cw.j(rVar.up(), rVar.i());
    }

    @Override // com.bykv.vk.openvk.component.video.api.j.xt
    public boolean j(r rVar) {
        if (TextUtils.isEmpty(rVar.up()) || TextUtils.isEmpty(rVar.i())) {
            return false;
        }
        return new File(rVar.up(), rVar.i()).exists();
    }

    private static void j(File[] fileArr, int i6, Set<String> set) {
        if (i6 >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i6) {
                    List asList = Arrays.asList(fileArr);
                    Collections.sort(asList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.j.j.j.j.1
                        @Override // java.util.Comparator
                        /* renamed from: j, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long lastModified = file2.lastModified() - file.lastModified();
                            if (lastModified == 0) {
                                return 0;
                            }
                            if (lastModified < 0) {
                                return -1;
                            }
                            return 1;
                        }
                    });
                    while (i6 < asList.size()) {
                        File file = (File) asList.get(i6);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) asList.get(i6)).delete();
                        }
                        i6++;
                    }
                }
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }
}
