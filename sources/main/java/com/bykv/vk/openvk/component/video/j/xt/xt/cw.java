package com.bykv.vk.openvk.component.video.j.xt.xt;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bytedance.sdk.component.oq.oq;
import com.stub.StubApp;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private static volatile cw xt;
    private final r cw;

    /* renamed from: j, reason: collision with root package name */
    private final SparseArray<Map<String, j>> f23117j;

    /* renamed from: r, reason: collision with root package name */
    private final Executor f23118r;
    private volatile SQLiteStatement up;

    private String xt(int i6) {
        if (i6 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i6 << 1);
        sb.append("?");
        for (int i7 = 1; i7 < i6; i7++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public void insert(final j jVar) {
        if (jVar != null) {
            Map<String, j> map = this.f23117j.get(jVar.f23123r);
            if (map != null) {
                map.put(jVar.f23122j, jVar);
            }
            this.f23118r.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.xt.xt.cw.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (cw.this.up == null) {
                            cw cwVar = cw.this;
                            cwVar.up = cwVar.cw.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        } else {
                            cw.this.up.clearBindings();
                        }
                        cw.this.up.bindString(1, jVar.f23122j);
                        cw.this.up.bindString(2, jVar.xt);
                        cw.this.up.bindLong(3, jVar.cw);
                        cw.this.up.bindLong(4, jVar.f23123r);
                        cw.this.up.bindString(5, jVar.up);
                        cw.this.up.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private cw(Context context) {
        SparseArray<Map<String, j>> sparseArray = new SparseArray<>(2);
        this.f23117j = sparseArray;
        this.f23118r = new com.bytedance.sdk.component.oq.r.r(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new oq(5, "video_proxy_db"));
        this.cw = new r(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public static cw j(Context context) {
        if (xt == null) {
            synchronized (cw.class) {
                try {
                    if (xt == null) {
                        xt = new cw(context);
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    public void delete(final String str, final int i6) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, j> map = this.f23117j.get(i6);
            if (map != null) {
                map.remove(str);
            }
            this.f23118r.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.xt.xt.cw.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        cw.this.cw.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i6)});
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public j query(String str, int i6) {
        j jVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, j> map = this.f23117j.get(i6);
        if (map == null) {
            jVar = null;
        } else {
            jVar = map.get(str);
        }
        if (jVar != null) {
            return jVar;
        }
        try {
            Cursor query = this.cw.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i6)}, null, null, null, "1");
            if (query != null) {
                if (query.getCount() > 0 && query.moveToNext()) {
                    jVar = new j(query.getString(query.getColumnIndex("key")), query.getString(query.getColumnIndex(IMediaFormat.KEY_MIME)), query.getInt(query.getColumnIndex("contentLength")), i6, query.getString(query.getColumnIndex(JThirdPlatFormInterface.KEY_EXTRA)));
                }
                query.close();
            }
            if (jVar != null && map != null) {
                map.put(str, jVar);
            }
            return jVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void j(Collection<String> collection, int i6) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        Map<String, j> map = this.f23117j.get(i6);
        int i7 = -1;
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i7++;
            strArr[i7] = str;
        }
        strArr[i7 + 1] = String.valueOf(i6);
        try {
            this.cw.getWritableDatabase().delete("video_http_header_t", "key IN(" + xt(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void j(final int i6) {
        Map<String, j> map = this.f23117j.get(i6);
        if (map != null) {
            map.clear();
        }
        this.f23118r.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.xt.xt.cw.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.this.cw.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i6)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
