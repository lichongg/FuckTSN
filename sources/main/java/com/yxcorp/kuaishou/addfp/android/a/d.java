package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.kuaishou.weapon.p0.g;
import com.yxcorp.kuaishou.addfp.android.b.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    private static volatile d f42921e;

    /* renamed from: a, reason: collision with root package name */
    private e f42922a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap f42923b = new ConcurrentHashMap(10);

    /* renamed from: c, reason: collision with root package name */
    private Context f42924c;

    /* renamed from: d, reason: collision with root package name */
    private int f42925d;

    public synchronized Pair a() {
        byte[] bArr;
        try {
            if (this.f42923b != null) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.f42923b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.f42923b);
                }
            }
            this.f42923b.clear();
            String b6 = this.f42922a.b();
            if (!TextUtils.isEmpty(b6)) {
                try {
                    bArr = Base64.decode(b6, 0);
                } catch (Throwable unused) {
                    bArr = null;
                }
                if (bArr == null) {
                    try {
                        bArr = Base64.decode(b6, 8);
                    } catch (Throwable unused2) {
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(com.yxcorp.kuaishou.addfp.android.b.b.b(bArr, "20212102sjcudiab".getBytes())));
                    this.f42923b.put("cache_e", jSONObject.optString("cache_e", ""));
                    this.f42923b.put("cache_m", jSONObject.optString("cache_m", ""));
                    this.f42923b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ConcurrentHashMap concurrentHashMap = this.f42923b;
            if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.f42923b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.f42923b);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
    }

    public LinkedHashMap b(String str) {
        Throwable th;
        ObjectInputStream objectInputStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(com.yxcorp.kuaishou.addfp.android.b.b.b(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
                try {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream2.readObject();
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return linkedHashMap;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream = objectInputStream2;
                    try {
                        th.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return new LinkedHashMap();
                    } catch (Throwable th3) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
        return new LinkedHashMap();
    }

    public static d a(Context context) {
        if (f42921e == null) {
            synchronized (d.class) {
                try {
                    if (f42921e == null) {
                        f42921e = new d(context);
                    }
                } finally {
                }
            }
        }
        return f42921e;
    }

    public boolean b() {
        return this.f42925d >= 30;
    }

    private d(Context context) {
        this.f42922a = null;
        this.f42925d = 0;
        try {
            this.f42924c = context;
            this.f42922a = new e(context);
            if (Build.VERSION.SDK_INT >= 30) {
                this.f42925d = this.f42924c.getApplicationInfo().targetSdkVersion;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String a(String str) {
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(this.f42924c, false), new String(Base64.decode(str, 0)));
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
                sb.append(readLine);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private String a(HashMap hashMap) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(hashMap);
            String str = new String(Base64.encode(com.yxcorp.kuaishou.addfp.android.b.b.c(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
            try {
                objectOutputStream.close();
            } catch (IOException unused) {
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                if (objectOutputStream == null) {
                    return "";
                }
                try {
                    objectOutputStream.close();
                    return "";
                } catch (IOException unused2) {
                    return "";
                }
            } catch (Throwable th3) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    public static void a(Context context, String str) {
        FileWriter fileWriter;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
                new File(file.getParent()).mkdirs();
                fileWriter = new FileWriter(file, false);
            } catch (Throwable unused) {
                fileWriter = null;
            }
            try {
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
            } catch (Throwable unused2) {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            }
        } catch (IOException unused3) {
        }
    }

    public synchronized void a(String str, String str2) {
        byte[] bArr;
        HashMap hashMap = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f42923b.put("c_time", Long.toString(currentTimeMillis));
            this.f42923b.put("cache_e", str);
            this.f42923b.put("cache_m", str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("c_time", currentTimeMillis);
            jSONObject.put("cache_e", str);
            jSONObject.put("cache_m", str2);
            byte[] c6 = com.yxcorp.kuaishou.addfp.android.b.b.c(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
            try {
                bArr = Base64.encode(c6, 0);
            } catch (Throwable unused) {
                bArr = null;
            }
            if (bArr == null) {
                try {
                    bArr = Base64.encode(c6, 8);
                } catch (Throwable unused2) {
                }
            }
            if (bArr != null) {
                this.f42922a.a(new String(bArr));
            }
        } catch (Throwable unused3) {
        }
        try {
            String a6 = com.yxcorp.kuaishou.addfp.c.a.a.a(this.f42924c, "k_w_o_d_out_dtt");
            if (TextUtils.isEmpty(a6) && f.a(this.f42924c, new String[]{g.f36049i, g.f36050j})) {
                a6 = a("Lm91a2R0ZnQ=");
            }
            if (!TextUtils.isEmpty(a6) && (hashMap = b(a6)) != null) {
                c cVar = b.f42915a;
                String a7 = cVar.a();
                if (!TextUtils.isEmpty(a7)) {
                    if (hashMap.containsKey(a7)) {
                        hashMap.remove(a7);
                    }
                    hashMap.put(cVar.a(), str);
                }
            }
            if (hashMap == null || hashMap.size() == 0) {
                hashMap = new LinkedHashMap();
                hashMap.put(b.f42915a.a(), str);
            }
            String a8 = a(hashMap);
            if (!TextUtils.isEmpty(a8)) {
                try {
                    Settings.System.putString(this.f42924c.getContentResolver(), "k_w_o_d_out_dtt", a8);
                } catch (Throwable unused4) {
                }
                if (f.a(this.f42924c, new String[]{g.f36049i, g.f36050j})) {
                    a(this.f42924c, a8);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
