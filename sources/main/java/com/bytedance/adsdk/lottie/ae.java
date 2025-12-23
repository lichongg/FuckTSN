package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import com.bxkj.base.v2.common.utils.g0;
import com.bytedance.adsdk.lottie.r.v;
import com.bytedance.component.sdk.annotation.RawRes;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.google.mlkit.common.sdkinternal.Constants;
import com.stub.StubApp;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, jy<m>> f23207j = new HashMap();
    private static final Set<Object> xt = new HashSet();
    private static final byte[] cw = {80, 75, 3, 4};

    @WorkerThread
    public static vl<m> cw(Context context, String str) {
        return cw(context, str, "asset_" + str);
    }

    public static jy<m> xt(Context context, String str) {
        return xt(context, str, "asset_" + str);
    }

    @WorkerThread
    public static vl<m> cw(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return xt(context.getAssets().open(str), str2);
            }
            return j(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e6) {
            return new vl<>((Throwable) e6);
        }
    }

    public static jy<m> j(Context context, String str) {
        return j(context, str, "url_" + str);
    }

    public static jy<m> xt(Context context, final String str, final String str2) {
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        return j(str2, new Callable<vl<m>>() { // from class: com.bytedance.adsdk.lottie.ae.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public vl<m> call() throws Exception {
                return ae.cw(origApplicationContext, str, str2);
            }
        });
    }

    public static jy<m> j(final Context context, final String str, final String str2) {
        return j(str2, new Callable<vl<m>>() { // from class: com.bytedance.adsdk.lottie.ae.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public vl<m> call() throws Exception {
                vl<m> j6 = up.j(context).j(context, str, str2);
                if (str2 != null && j6.j() != null) {
                    com.bytedance.adsdk.lottie.model.up.j().j(str2, j6.j());
                }
                return j6;
            }
        });
    }

    public static jy<m> j(Context context, @RawRes int i6) {
        return j(context, i6, cw(context, i6));
    }

    @WorkerThread
    public static vl<m> xt(Context context, @RawRes int i6) {
        return xt(context, i6, cw(context, i6));
    }

    public static jy<m> j(Context context, @RawRes final int i6, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        return j(str, new Callable<vl<m>>() { // from class: com.bytedance.adsdk.lottie.ae.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public vl<m> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = origApplicationContext;
                }
                return ae.xt(context2, i6, str);
            }
        });
    }

    @WorkerThread
    public static vl<m> xt(Context context, @RawRes int i6, String str) {
        try {
            return xt(context.getResources().openRawResource(i6), cw(context, i6));
        } catch (Resources.NotFoundException e6) {
            return new vl<>((Throwable) e6);
        }
    }

    private static String cw(Context context, @RawRes int i6) {
        StringBuilder sb = new StringBuilder("rawRes");
        sb.append(j(context) ? "_night_" : "_day_");
        sb.append(i6);
        return sb.toString();
    }

    @WorkerThread
    public static vl<m> xt(InputStream inputStream, String str) {
        return j(inputStream, str, true);
    }

    private static boolean j(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    @WorkerThread
    private static vl<m> xt(Context context, ZipInputStream zipInputStream, String str) {
        FileOutputStream fileOutputStream;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            m mVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase(Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME)) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    mVar = j(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).j();
                } else {
                    if (!name.endsWith(g0.f16898c) && !name.endsWith(".webp") && !name.endsWith(".jpg") && !name.endsWith(".jpeg")) {
                        if (!name.endsWith(".ttf") && !name.endsWith(".otf")) {
                            zipInputStream.closeEntry();
                        }
                        if (name.contains("../")) {
                            zipInputStream.closeEntry();
                            nextEntry = zipInputStream.getNextEntry();
                        } else {
                            String[] split = name.split("/");
                            String str2 = split[split.length - 1];
                            String str3 = str2.split("\\.")[0];
                            File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context), str2);
                            new FileOutputStream(file);
                            try {
                                fileOutputStream = new FileOutputStream(file);
                            } catch (Throwable th) {
                                com.bytedance.adsdk.lottie.up.up.j("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                            }
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                Typeface createFromFile = Typeface.createFromFile(file);
                                if (!file.delete()) {
                                    com.bytedance.adsdk.lottie.up.up.xt("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                                }
                                hashMap2.put(str3, createFromFile);
                            } catch (Throwable th2) {
                                try {
                                    throw th2;
                                } catch (Throwable th3) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th4) {
                                        th2.addSuppressed(th4);
                                    }
                                    throw th3;
                                }
                            }
                        }
                    }
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] split2 = name.split("/");
                        hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (mVar == null) {
                return new vl<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                g j6 = j(mVar, (String) entry.getKey());
                if (j6 != null) {
                    j6.j(com.bytedance.adsdk.lottie.up.g.j((Bitmap) entry.getValue(), j6.j(), j6.xt()));
                }
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                boolean z5 = false;
                for (com.bytedance.adsdk.lottie.model.cw cwVar : mVar.av().values()) {
                    if (cwVar.j().equals(entry2.getKey())) {
                        cwVar.j((Typeface) entry2.getValue());
                        z5 = true;
                    }
                }
                if (!z5) {
                    com.bytedance.adsdk.lottie.up.up.xt("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (hashMap.isEmpty()) {
                Iterator<Map.Entry<String, g>> it = mVar.i().entrySet().iterator();
                while (it.hasNext()) {
                    g value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String vl = value.vl();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (vl.startsWith("data:") && vl.indexOf("base64,") > 0) {
                        try {
                            byte[] decode = Base64.decode(vl.substring(vl.indexOf(44) + 1), 0);
                            value.j(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                        } catch (IllegalArgumentException e6) {
                            com.bytedance.adsdk.lottie.up.up.j("data URL did not have correct base64 format.", e6);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, g> entry3 : mVar.i().entrySet()) {
                if (entry3.getValue().ws() == null) {
                    return new vl<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().vl()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.lottie.model.up.j().j(str, mVar);
            }
            return new vl<>(mVar);
        } catch (IOException e7) {
            return new vl<>((Throwable) e7);
        }
    }

    public static jy<m> j(final InputStream inputStream, final String str) {
        return j(str, new Callable<vl<m>>() { // from class: com.bytedance.adsdk.lottie.ae.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public vl<m> call() throws Exception {
                return ae.xt(inputStream, str);
            }
        });
    }

    @WorkerThread
    private static vl<m> j(InputStream inputStream, String str, boolean z5) {
        try {
            return j(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z5) {
                com.bytedance.adsdk.lottie.up.g.j(inputStream);
            }
        }
    }

    @WorkerThread
    public static vl<m> j(JsonReader jsonReader, String str) {
        return j(jsonReader, str, true);
    }

    private static vl<m> j(JsonReader jsonReader, String str, boolean z5) {
        try {
            try {
                m j6 = v.j(jsonReader);
                com.bytedance.adsdk.lottie.model.up.j().j(str, j6);
                vl<m> vlVar = new vl<>(j6);
                if (z5) {
                    j(jsonReader);
                }
                return vlVar;
            } catch (Exception e6) {
                vl<m> vlVar2 = new vl<>(e6);
                if (z5) {
                    j(jsonReader);
                }
                return vlVar2;
            }
        } catch (Throwable th) {
            if (z5) {
                j(jsonReader);
            }
            throw th;
        }
    }

    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    @WorkerThread
    public static vl<m> j(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return xt(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.lottie.up.g.j(zipInputStream);
        }
    }

    private static g j(m mVar, String str) {
        for (g gVar : mVar.i().values()) {
            if (gVar.vl().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    private static jy<m> j(final String str, Callable<vl<m>> callable) {
        final m j6 = str == null ? null : com.bytedance.adsdk.lottie.model.up.j().j(str);
        if (j6 != null) {
            return new jy<>(new Callable<vl<m>>() { // from class: com.bytedance.adsdk.lottie.ae.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public vl<m> call() throws Exception {
                    return new vl<>(m.this);
                }
            });
        }
        if (str != null) {
            Map<String, jy<m>> map = f23207j;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        jy<m> jyVar = new jy<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            jyVar.j(new oq<m>() { // from class: com.bytedance.adsdk.lottie.ae.2
                @Override // com.bytedance.adsdk.lottie.oq
                public void j(m mVar) {
                    ae.f23207j.remove(str);
                    atomicBoolean.set(true);
                    if (ae.f23207j.size() == 0) {
                        ae.xt(true);
                    }
                }
            });
            jyVar.cw(new oq<Throwable>() { // from class: com.bytedance.adsdk.lottie.ae.3
                @Override // com.bytedance.adsdk.lottie.oq
                public void j(Throwable th) {
                    ae.f23207j.remove(str);
                    atomicBoolean.set(true);
                    if (ae.f23207j.size() == 0) {
                        ae.xt(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, jy<m>> map2 = f23207j;
                map2.put(str, jyVar);
                if (map2.size() == 1) {
                    xt(false);
                }
            }
        }
        return jyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(boolean z5) {
        ArrayList arrayList = new ArrayList(xt);
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList.get(i6);
        }
    }
}
