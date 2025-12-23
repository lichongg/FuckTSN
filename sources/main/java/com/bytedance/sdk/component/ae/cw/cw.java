package com.bytedance.sdk.component.ae.cw;

import android.content.SharedPreferences;
import com.bytedance.sdk.component.oq.oq;
import com.bytedance.sdk.component.r.j.xt;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements com.bytedance.sdk.component.r.j.xt {

    /* renamed from: j, reason: collision with root package name */
    private static ThreadPoolExecutor f26058j = null;
    private static int xt = 3;
    private final File cw;

    /* renamed from: g, reason: collision with root package name */
    private long f26059g;
    private long qv;

    /* renamed from: r, reason: collision with root package name */
    private final File f26061r;
    private volatile boolean tl;
    private final com.bytedance.sdk.component.ae.xt vl;
    private final boolean ws;
    private final Object up = new Object();

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, Object> f26060m = new ConcurrentHashMap();
    private Map<String, Object> ae = new HashMap();
    private final List<Runnable> oq = new ArrayList();
    private AtomicBoolean jy = new AtomicBoolean(false);

    public final class j implements SharedPreferences.Editor {
        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        public j() {
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            cw.this.xt();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            try {
                cw.cw(cw.this);
                cw.this.ae.clear();
            } catch (Exception unused) {
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z5) {
            cw.this.j(str, (String) Boolean.valueOf(z5));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f6) {
            cw.this.j(str, (String) Float.valueOf(f6));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i6) {
            cw.this.j(str, (String) Integer.valueOf(i6));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j6) {
            cw.this.j(str, (String) Long.valueOf(j6));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            cw.this.j(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            cw.this.j(str, (String) set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            cw.this.j(str);
            return this;
        }
    }

    static /* synthetic */ long cw(cw cwVar) {
        long j6 = cwVar.f26059g;
        cwVar.f26059g = 1 + j6;
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> ae() {
        HashMap hashMap;
        synchronized ("SharedPreferencesImpl") {
            hashMap = new HashMap(this.ae);
            this.ae = new HashMap();
        }
        HashMap hashMap2 = new HashMap(this.f26060m);
        if (!hashMap.isEmpty() || !hashMap2.isEmpty()) {
            int i6 = 0;
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Object obj = hashMap2.get(str);
                if (value == null) {
                    if (obj != null) {
                        hashMap2.remove(str);
                        i6++;
                    }
                } else if (!value.equals(obj)) {
                    hashMap2.put(str, value);
                    i6++;
                }
            }
            if (i6 <= 0) {
                return null;
            }
        }
        return hashMap2;
    }

    private String cw(String str, String str2) {
        try {
            Object obj = this.ae.get(str);
            if (obj == null) {
                obj = this.f26060m.get(str);
            }
            return obj != null ? String.valueOf(obj) : str2;
        } catch (Exception e6) {
            j("getValue error key =".concat(String.valueOf(str)), (Throwable) e6);
            return str2;
        }
    }

    private Map<String, ?> m() {
        HashMap hashMap = new HashMap(this.f26060m);
        hashMap.putAll(this.ae);
        return hashMap;
    }

    private void r() {
        while (!this.tl) {
            try {
                this.up.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private static ThreadPoolExecutor up() {
        ThreadPoolExecutor threadPoolExecutor = f26058j;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        synchronized (cw.class) {
            try {
                ThreadPoolExecutor threadPoolExecutor2 = f26058j;
                if (threadPoolExecutor2 != null) {
                    return threadPoolExecutor2;
                }
                int i6 = xt;
                com.bytedance.sdk.component.oq.r.r rVar = new com.bytedance.sdk.component.oq.r.r(i6, i6, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new oq("SharedPreferencesImpl"));
                f26058j = rVar;
                return rVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(com.bytedance.sdk.component.ae.j jVar) {
        Map<String, Object> map;
        synchronized (this.up) {
            try {
                if (this.tl) {
                    return;
                }
                if (this.f26061r.exists()) {
                    this.cw.delete();
                    this.f26061r.renameTo(this.cw);
                }
                try {
                    map = jVar.j(this.cw);
                } catch (Throwable th) {
                    j("loadFromDisk error", th);
                    map = null;
                }
                synchronized (this.up) {
                    try {
                        this.tl = true;
                        if (map != null) {
                            for (Map.Entry<String, Object> entry : map.entrySet()) {
                                Object value = entry.getValue();
                                if (value != null) {
                                    String key = entry.getKey();
                                    if (key == null) {
                                        key = "";
                                    }
                                    this.f26060m.put(key, value);
                                }
                            }
                        }
                        this.up.notifyAll();
                    } catch (Throwable th2) {
                        this.up.notifyAll();
                        throw th2;
                    } finally {
                    }
                }
                synchronized (this.oq) {
                    try {
                        Iterator<Runnable> it = this.oq.iterator();
                        while (it.hasNext()) {
                            it.next().run();
                        }
                        this.oq.clear();
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        boolean containsKey;
        if (str == null) {
            str = "";
        }
        synchronized (this.up) {
            r();
            containsKey = this.f26060m.containsKey(str);
        }
        return containsKey;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> m6;
        if (!this.ws) {
            return m();
        }
        synchronized (this.up) {
            r();
            m6 = m();
        }
        return m6;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z5) {
        boolean cw;
        if (str == null) {
            str = "";
        }
        if (!this.ws) {
            return cw(str, z5);
        }
        synchronized (this.up) {
            r();
            cw = cw(str, z5);
        }
        return cw;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f6) {
        float cw;
        if (str == null) {
            str = "";
        }
        if (!this.ws) {
            return cw(str, f6);
        }
        synchronized (this.up) {
            r();
            cw = cw(str, f6);
        }
        return cw;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i6) {
        int cw;
        if (str == null) {
            str = "";
        }
        if (!this.ws) {
            return cw(str, i6);
        }
        synchronized (this.up) {
            r();
            cw = cw(str, i6);
        }
        return cw;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j6) {
        long cw;
        if (str == null) {
            str = "";
        }
        if (!this.ws) {
            return cw(str, j6);
        }
        synchronized (this.up) {
            r();
            cw = cw(str, j6);
        }
        return cw;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        String cw;
        if (str == null) {
            str = "";
        }
        if (!this.ws) {
            return cw(str, str2);
        }
        synchronized (this.up) {
            r();
            cw = cw(str, str2);
        }
        return cw;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> cw;
        if (str == null) {
            str = "";
        }
        if (!this.ws) {
            return cw(str, set);
        }
        synchronized (this.up) {
            r();
            cw = cw(str, set);
        }
        return cw;
    }

    public cw(File file, com.bytedance.sdk.component.ae.j jVar, com.bytedance.sdk.component.ae.xt xtVar, boolean z5) {
        this.tl = false;
        this.ws = z5;
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            jVar = new com.bytedance.sdk.component.ae.cw.j(null);
            file = file2;
        }
        this.cw = file;
        this.f26061r = new File(file.getPath() + ".bak");
        this.tl = false;
        jVar = jVar == null ? new com.bytedance.sdk.component.ae.cw.j(null) : jVar;
        if (xtVar == null) {
            this.vl = new com.bytedance.sdk.component.ae.cw.j(null);
        } else {
            this.vl = xtVar;
        }
        j(jVar);
    }

    private void j(final com.bytedance.sdk.component.ae.j jVar) {
        synchronized (this.up) {
            this.tl = false;
        }
        up().execute(new Runnable() { // from class: com.bytedance.sdk.component.ae.cw.cw.1
            @Override // java.lang.Runnable
            public void run() {
                cw.this.xt(jVar);
            }
        });
    }

    private Set<String> cw(String str, Set<String> set) {
        try {
            Set<String> set2 = (Set) this.ae.get(str);
            if (set2 == null) {
                set2 = (Set) this.f26060m.get(str);
            }
            return set2 != null ? set2 : set;
        } catch (Exception e6) {
            j("getValue error key =".concat(String.valueOf(str)), (Throwable) e6);
            return set;
        }
    }

    private int cw(String str, int i6) {
        try {
            Object obj = this.ae.get(str);
            if (obj == null) {
                obj = this.f26060m.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            return obj != null ? ((Integer) obj).intValue() : i6;
        } catch (Exception e6) {
            j("getValue error key =".concat(String.valueOf(str)), (Throwable) e6);
            return i6;
        }
    }

    private void j(Runnable runnable) {
        synchronized (this.oq) {
            try {
                if (this.tl) {
                    runnable.run();
                } else {
                    this.oq.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(final xt.j<Map<String, ?>> jVar) {
        if (this.tl) {
            jVar.j(this.f26060m);
        } else {
            j(new Runnable() { // from class: com.bytedance.sdk.component.ae.cw.cw.4
                @Override // java.lang.Runnable
                public void run() {
                    jVar.j(cw.this.f26060m);
                }
            });
        }
    }

    private long cw(String str, long j6) {
        try {
            Long l6 = (Long) this.ae.get(str);
            if (l6 == null) {
                l6 = (Long) this.f26060m.get(str);
            }
            return l6 != null ? l6.longValue() : j6;
        } catch (Exception e6) {
            j("getValue error key =".concat(String.valueOf(str)), (Throwable) e6);
            return j6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void j(String str, T t5) {
        if (str == null) {
            str = "";
        }
        synchronized ("SharedPreferencesImpl") {
            this.ae.put(str, t5);
            this.f26059g++;
        }
    }

    private float cw(String str, float f6) {
        try {
            Object obj = this.ae.get(str);
            if (obj == null) {
                obj = this.f26060m.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return obj != null ? ((Float) obj).floatValue() : f6;
        } catch (Exception e6) {
            j("getValue error key =".concat(String.valueOf(str)), (Throwable) e6);
            return f6;
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, int i6) {
        j(str, (String) Integer.valueOf(i6));
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, long j6) {
        j(str, (String) Long.valueOf(j6));
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, float f6) {
        j(str, (String) Float.valueOf(f6));
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, boolean z5) {
        j(str, (String) Boolean.valueOf(z5));
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, String str2) {
        j(str, str2);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public int xt(String str, int i6) {
        return getInt(str, i6);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, Set<String> set) {
        j(str, (String) set);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public long xt(String str, long j6) {
        return getLong(str, j6);
    }

    private boolean cw(String str, boolean z5) {
        try {
            Boolean bool = (Boolean) this.ae.get(str);
            if (bool == null) {
                bool = (Boolean) this.f26060m.get(str);
            }
            return bool != null ? bool.booleanValue() : z5;
        } catch (Exception e6) {
            j("getValue error key =".concat(String.valueOf(str)), (Throwable) e6);
            return z5;
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str) {
        synchronized ("SharedPreferencesImpl") {
            this.ae.put(str, null);
            this.f26059g++;
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public float xt(String str, float f6) {
        return getFloat(str, f6);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public boolean xt(String str, boolean z5) {
        return getBoolean(str, z5);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public String xt(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public Set<String> xt(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    /* renamed from: cw, reason: merged with bridge method [inline-methods] */
    public j edit() {
        synchronized (this.up) {
            r();
        }
        return new j();
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j() {
        if (this.tl) {
            this.f26060m.clear();
            synchronized ("SharedPreferencesImpl") {
                this.ae.clear();
                this.f26059g++;
            }
            return;
        }
        j(new Runnable() { // from class: com.bytedance.sdk.component.ae.cw.cw.5
            @Override // java.lang.Runnable
            public void run() {
                cw.this.f26060m.clear();
                synchronized ("SharedPreferencesImpl") {
                    cw.this.ae.clear();
                    cw.cw(cw.this);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void xt() {
        if (!this.tl) {
            if (this.jy.compareAndSet(false, true)) {
                j(new Runnable() { // from class: com.bytedance.sdk.component.ae.cw.cw.2
                    @Override // java.lang.Runnable
                    public void run() {
                        cw.this.jy.set(false);
                        cw.this.xt();
                    }
                });
            }
        } else if (this.qv != this.f26059g && this.jy.compareAndSet(false, true)) {
            up().execute(new Runnable() { // from class: com.bytedance.sdk.component.ae.cw.cw.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, Object> ae = cw.this.ae();
                        if (ae != null) {
                            cw.this.vl.j(ae, cw.this.cw);
                        }
                        cw.this.jy.set(false);
                    } catch (Exception e6) {
                        cw.this.j("apply write error", (Throwable) e6);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, Throwable th) {
        com.bytedance.sdk.component.r.cw cwVar = (com.bytedance.sdk.component.r.cw) AutoService.j(com.bytedance.sdk.component.r.cw.class);
        if (cwVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(b.f50156c, this.cw.getAbsolutePath());
                jSONObject.put("msg", str);
                jSONObject.put("class", "SharedPreferencesImpl");
            } catch (JSONException unused) {
            }
            cwVar.j("kv", jSONObject, th);
        }
    }
}
