package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.x1;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileProvider;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import com.umeng.analytics.pro.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u8 implements x1.a {
    private boolean B;
    private AMap3DModelTileOverlay D;
    private a F;

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f7406b;

    /* renamed from: c, reason: collision with root package name */
    private CustomMapStyleOptions f7407c;

    /* renamed from: i, reason: collision with root package name */
    private int f7413i;

    /* renamed from: j, reason: collision with root package name */
    private Context f7414j;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7421q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f7422r;

    /* renamed from: v, reason: collision with root package name */
    private x1 f7426v;

    /* renamed from: w, reason: collision with root package name */
    private x1 f7427w;

    /* renamed from: a, reason: collision with root package name */
    private final String f7405a = "__MACOSX";

    /* renamed from: d, reason: collision with root package name */
    private boolean f7408d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7409e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7410f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7411g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7412h = false;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f7415k = null;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f7416l = null;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f7417m = null;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f7418n = null;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f7419o = null;

    /* renamed from: p, reason: collision with root package name */
    private byte[] f7420p = null;

    /* renamed from: s, reason: collision with root package name */
    private boolean f7423s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f7424t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f7425u = false;

    /* renamed from: x, reason: collision with root package name */
    private byte[] f7428x = null;

    /* renamed from: y, reason: collision with root package name */
    private byte[] f7429y = null;

    /* renamed from: z, reason: collision with root package name */
    private byte[] f7430z = null;
    private boolean A = false;
    private HashMap<String, byte[]> C = new HashMap<>();
    private MyTrafficStyle E = new MyTrafficStyle();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();
    }

    private boolean l(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            return this.f7406b.getGLMapEngine().checkCustomStyleData(this.f7413i, bArr);
        } catch (Throwable th) {
            v5.p(th, "AMapCustomStyleManager", "checkData");
            b3.D(th);
            return true;
        }
    }

    private static byte[] o(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr3 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr3);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            try {
                b3.D(th);
                th.printStackTrace();
                return bArr2;
            } finally {
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
            }
        }
        return bArr2;
    }

    public final void a() {
        IAMapDelegate iAMapDelegate;
        if (this.f7407c == null || this.f7422r) {
            return;
        }
        try {
            MapConfig mapConfig = this.f7406b.getMapConfig();
            if (mapConfig == null) {
                return;
            }
            synchronized (this) {
                try {
                    if (mapConfig.isHideLogoEnable() && (iAMapDelegate = this.f7406b) != null && iAMapDelegate.getUiSettings() != null) {
                        if (this.f7406b.getUiSettings().isLogoEnable()) {
                            if (!this.f7407c.isEnable()) {
                                this.f7406b.getUiSettings().setLogoEnable(true);
                            } else if (this.f7424t) {
                                this.f7406b.getUiSettings().setLogoEnable(false);
                            }
                        } else if (!this.f7424t) {
                            this.f7406b.getUiSettings().setLogoEnable(true);
                        }
                    }
                    if (this.f7408d) {
                        if (!this.f7407c.isEnable()) {
                            this.f7406b.getGLMapEngine().setNativeMapModeAndStyle(this.f7413i, mapConfig.getMapStyleMode(), mapConfig.getMapStyleTime());
                            this.f7424t = false;
                            if (mapConfig.isCustomStyleEnable()) {
                                if (mapConfig.getMapStyleMode() == 0 && mapConfig.getMapStyleTime() == 0) {
                                    s();
                                }
                                t();
                                if (this.f7425u) {
                                    r();
                                }
                                mapConfig.setCustomStyleEnable(false);
                            }
                            this.f7408d = false;
                            return;
                        }
                        this.f7406b.getGLMapEngine().setNativeMapModeAndStyle(this.f7413i, 0, 0);
                        mapConfig.setCustomStyleEnable(true);
                        this.f7408d = false;
                    }
                    if (this.f7410f) {
                        String styleTexturePath = this.f7407c.getStyleTexturePath();
                        if (this.f7407c.getStyleTextureData() == null && !TextUtils.isEmpty(styleTexturePath)) {
                            this.f7407c.setStyleTextureData(FileUtil.readFileContents(styleTexturePath));
                        }
                        if (this.f7407c.getStyleTextureData() != null) {
                            this.A = true;
                            if (mapConfig.isProFunctionAuthEnable()) {
                                this.f7423s = true;
                                this.f7406b.getGLMapEngine().setCustomStyleTexture(this.f7413i, this.f7407c.getStyleTextureData());
                                mapConfig.setUseProFunction(true);
                            } else {
                                t();
                            }
                        } else {
                            t();
                            this.A = false;
                        }
                        this.f7410f = false;
                    }
                    if (this.f7409e) {
                        String styleDataPath = this.f7407c.getStyleDataPath();
                        if (this.f7407c.getStyleData() == null && !TextUtils.isEmpty(styleDataPath)) {
                            this.f7407c.setStyleData(FileUtil.readFileContents(styleDataPath));
                        }
                        if (this.f7407c.getStyleData() == null && this.f7428x == null) {
                            if (this.f7424t) {
                                this.f7408d = true;
                                this.f7407c.setEnable(false);
                            }
                            this.f7409e = false;
                        }
                        if (this.f7419o == null) {
                            this.f7419o = o(FileUtil.readFileContentsFromAssets(this.f7414j, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_0_FOR_TEXTURE));
                        }
                        byte[] bArr = this.f7428x;
                        if (bArr == null) {
                            bArr = this.f7407c.getStyleData();
                        }
                        if (l(bArr)) {
                            this.f7406b.getGLMapEngine().setCustomStyleData(this.f7413i, bArr, this.f7419o);
                            this.f7424t = true;
                            IAMapDelegate iAMapDelegate2 = this.f7406b;
                            if (iAMapDelegate2 != null) {
                                iAMapDelegate2.resetRenderTime();
                            }
                        } else {
                            i2.a();
                        }
                        this.f7409e = false;
                    }
                    if (this.f7411g) {
                        String styleExtraPath = this.f7407c.getStyleExtraPath();
                        if (this.f7407c.getStyleExtraData() == null && !TextUtils.isEmpty(styleExtraPath)) {
                            this.f7407c.setStyleExtraData(FileUtil.readFileContents(styleExtraPath));
                        }
                        if (this.f7407c.getStyleExtraData() != null || this.f7429y != null) {
                            byte[] bArr2 = this.f7429y;
                            if (bArr2 == null) {
                                bArr2 = this.f7407c.getStyleExtraData();
                            }
                            if (bArr2 != null) {
                                h(bArr2);
                                this.f7425u = true;
                            }
                        }
                        this.f7411g = false;
                    }
                    if (this.f7412h) {
                        e(mapConfig);
                        this.f7412h = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            v5.p(th2, "AMapCustomStyleManager", "updateStyle");
            b3.D(th2);
        }
    }

    public final byte[] i(String str) {
        MapConfig mapConfig;
        if (str == null || (mapConfig = this.f7406b.getMapConfig()) == null) {
            return null;
        }
        if (!mapConfig.isProFunctionAuthEnable()) {
            return FileUtil.readFileContentsFromAssetsByPreName(this.f7414j, AMapEngineUtils.MAP_MAP_ASSETS_NAME, m(str));
        }
        for (String str2 : this.C.keySet()) {
            if (str.contains(str2)) {
                return this.C.get(str2);
            }
        }
        return null;
    }

    public final void q() {
        synchronized (this) {
            try {
                CustomMapStyleOptions customMapStyleOptions = this.f7407c;
                if (customMapStyleOptions != null) {
                    customMapStyleOptions.setEnable(false);
                    u();
                    this.f7408d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g(JSONObject jSONObject) {
        this.f7406b.getGLMapEngine().setCustomThirdLayerStyle(this.f7413i, jSONObject.toString());
    }

    private void h(byte[] bArr) {
        b2 c6;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (bArr == null || (c6 = d2.c(bArr)) == null || c6.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(c6.a());
            JSONObject optJSONObject3 = jSONObject.optJSONObject("mapStyle");
            String str = null;
            boolean z5 = true;
            if (optJSONObject3 != null && (optJSONObject2 = optJSONObject3.optJSONObject("bg")) != null) {
                z5 = optJSONObject2.optBoolean("visible", true);
                str = optJSONObject2.optString("lineColor", null);
            }
            f(str, z5);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("layer");
            if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject(d.F)) != null) {
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("multiFillColors");
                if (optJSONObject.optBoolean("visible") && optJSONObject5 != null) {
                    int b6 = d2.b(optJSONObject5.optString("smooth"));
                    int b7 = d2.b(optJSONObject5.optString("slow"));
                    int b8 = d2.b(optJSONObject5.optString("congested"));
                    int b9 = d2.b(optJSONObject5.optString("seriousCongested"));
                    this.E.setSmoothColor(b6);
                    this.E.setSlowColor(b7);
                    this.E.setCongestedColor(b8);
                    this.E.setSeriousCongestedColor(b9);
                    if (this.f7420p == null) {
                        this.f7420p = FileUtil.readFileContentsFromAssets(this.f7414j, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_TRL_NAME);
                    }
                    this.f7406b.setTrafficStyleWithTexture(this.f7420p, this.E);
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("third_layer");
            if (optJSONObject6 != null) {
                g(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("model_layer");
            if (optJSONObject7 != null) {
                k(optJSONObject7.optString("id"));
            }
        } catch (Throwable th) {
            v5.p(th, "AMapCustomStyleManager", "setExtraStyle");
            b3.D(th);
        }
    }

    private void k(String str) {
        AMap3DModelTileProvider aMap3DModelTileProvider = new AMap3DModelTileProvider();
        aMap3DModelTileProvider.setUrl("https://restapi.amap.com/rest/lbs/geohub/3d/tiles?z=%d&x=%d&y=%d&id=" + str);
        AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions = new AMap3DModelTileOverlayOptions();
        aMap3DModelTileOverlayOptions.setTileProvider(aMap3DModelTileProvider);
        try {
            this.D = this.f7406b.add3DModelTileOverlay(aMap3DModelTileOverlayOptions);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private static String m(String str) {
        if (str == null) {
            return str;
        }
        int indexOf = str.indexOf("99999_");
        return indexOf == -1 ? str : str.substring(0, indexOf).replace("99999_", "");
    }

    private void r() {
        IAMapDelegate iAMapDelegate = this.f7406b;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null && this.f7420p != null) {
            this.f7406b.getGLMapEngine().setTrafficStyleWithTexture(this.f7413i, this.f7420p, new MyTrafficStyle());
        }
        IAMapDelegate iAMapDelegate2 = this.f7406b;
        if (iAMapDelegate2 != null && iAMapDelegate2.getGLMapEngine() != null && this.f7417m != null) {
            this.f7406b.getGLMapEngine().setBackgroundTexture(this.f7413i, this.f7417m);
        }
        AMap3DModelTileOverlay aMap3DModelTileOverlay = this.D;
        if (aMap3DModelTileOverlay != null) {
            aMap3DModelTileOverlay.remove();
        }
        this.f7425u = false;
    }

    private void s() {
        if (this.B) {
            if (this.f7416l == null) {
                this.f7416l = o(FileUtil.readFileContentsFromAssets(this.f7414j, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_ABROAD));
            }
        } else if (this.f7416l == null) {
            this.f7416l = o(FileUtil.readFileContentsFromAssets(this.f7414j, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA));
        }
        this.f7406b.getGLMapEngine().setCustomStyleData(this.f7413i, this.f7416l, this.f7415k);
        this.f7424t = false;
        this.C.clear();
    }

    private void t() {
        if (this.f7423s) {
            if (this.f7418n == null) {
                this.f7418n = FileUtil.readFileContentsFromAssets(this.f7414j, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME_FOR_CUSTOM);
            }
            this.f7423s = false;
            this.f7406b.getGLMapEngine().setCustomStyleTexture(this.f7413i, this.f7418n);
        }
    }

    private void u() {
        CustomMapStyleOptions customMapStyleOptions = this.f7407c;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId(null);
            this.f7407c.setStyleDataPath(null);
            this.f7407c.setStyleData(null);
            this.f7407c.setStyleTexturePath(null);
            this.f7407c.setStyleTextureData(null);
            this.f7407c.setStyleExtraData(null);
            this.f7407c.setStyleExtraPath(null);
        }
    }

    @Override // com.amap.api.col.3l.x1.a
    public final void b(byte[] bArr, int i6) {
        MapConfig mapConfig;
        a aVar;
        if (this.f7407c != null) {
            synchronized (this) {
                try {
                    IAMapDelegate iAMapDelegate = this.f7406b;
                    if (iAMapDelegate != null && (mapConfig = iAMapDelegate.getMapConfig()) != null && mapConfig.isProFunctionAuthEnable()) {
                        mapConfig.setUseProFunction(true);
                        if (i6 == 1) {
                            this.f7428x = bArr;
                            this.f7409e = true;
                        } else if (i6 == 0) {
                            this.f7429y = bArr;
                            this.f7411g = true;
                        } else if (i6 == 2) {
                            String str = this.f7407c.getStyleId() + "_sdk_1000.data";
                            String str2 = this.f7407c.getStyleId() + "_abroad_sdk.json";
                            Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr, new String[]{str, str2});
                            if (uncompressToByteWithKeys != null) {
                                byte[] bArr2 = uncompressToByteWithKeys.get(str);
                                if (bArr2 != null) {
                                    this.f7428x = bArr2;
                                    this.f7409e = true;
                                }
                                if (uncompressToByteWithKeys.get(str2) != null && (aVar = this.F) != null) {
                                    aVar.a();
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void c(a aVar) {
        this.F = aVar;
    }

    public final void d(CustomMapStyleOptions customMapStyleOptions) {
        IAMapDelegate iAMapDelegate;
        if (this.f7407c == null || customMapStyleOptions == null) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.f7421q) {
                    this.f7421q = true;
                    if (this.f7407c.isEnable()) {
                        this.f7408d = true;
                    }
                }
                if (this.f7407c.isEnable() != customMapStyleOptions.isEnable()) {
                    this.f7407c.setEnable(customMapStyleOptions.isEnable());
                    this.f7408d = true;
                    y2.m(this.f7414j, customMapStyleOptions.isEnable());
                }
                if (this.f7407c.isEnable()) {
                    if (!TextUtils.equals(this.f7407c.getStyleId(), customMapStyleOptions.getStyleId())) {
                        this.f7407c.setStyleId(customMapStyleOptions.getStyleId());
                        String styleId = this.f7407c.getStyleId();
                        if (!TextUtils.isEmpty(styleId) && (iAMapDelegate = this.f7406b) != null && iAMapDelegate.getMapConfig() != null && this.f7406b.getMapConfig().isProFunctionAuthEnable()) {
                            if (this.f7426v == null) {
                                if (this.B) {
                                    this.f7426v = new x1(this.f7414j, this, 2, "abroad_sdk_json_sdk_1000_zip");
                                } else {
                                    this.f7426v = new x1(this.f7414j, this, 1, "sdk_1000");
                                }
                            }
                            this.f7426v.b(styleId);
                            this.f7426v.b();
                            if (this.f7427w == null) {
                                this.f7427w = new x1(this.f7414j, this, 0, null);
                            }
                            this.f7427w.b(styleId);
                            this.f7427w.b();
                        }
                    }
                    if (!TextUtils.equals(this.f7407c.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                        this.f7407c.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                        this.f7409e = true;
                    }
                    if (this.f7407c.getStyleData() != customMapStyleOptions.getStyleData()) {
                        this.f7407c.setStyleData(customMapStyleOptions.getStyleData());
                        this.f7409e = true;
                    }
                    if (!TextUtils.equals(this.f7407c.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                        this.f7407c.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                        this.f7410f = true;
                    }
                    if (this.f7407c.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                        this.f7407c.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                        this.f7410f = true;
                    }
                    if (!TextUtils.equals(this.f7407c.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                        this.f7407c.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                        this.f7411g = true;
                    }
                    if (this.f7407c.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                        this.f7407c.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                        this.f7411g = true;
                    }
                    if (!TextUtils.equals(this.f7407c.getStyleResDataPath(), customMapStyleOptions.getStyleResDataPath())) {
                        this.f7407c.setStyleResDataPath(customMapStyleOptions.getStyleResDataPath());
                        this.f7412h = true;
                    }
                    if (this.f7407c.getStyleResData() != customMapStyleOptions.getStyleResData()) {
                        this.f7407c.setStyleResData(customMapStyleOptions.getStyleResData());
                        this.f7412h = true;
                    }
                    y2.j(this.f7414j, true);
                } else {
                    u();
                    y2.j(this.f7414j, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j() {
        if (this.f7407c == null) {
            return;
        }
        synchronized (this) {
            try {
                IAMapDelegate iAMapDelegate = this.f7406b;
                if (iAMapDelegate != null && iAMapDelegate.getMapConfig() != null && !this.f7406b.getMapConfig().isProFunctionAuthEnable()) {
                    this.f7407c.setStyleId(null);
                    this.f7428x = null;
                    this.f7429y = null;
                    this.f7430z = null;
                }
                this.f7410f = true;
                this.f7409e = true;
                if (this.f7425u) {
                    this.f7411g = true;
                }
                this.f7408d = true;
                this.f7412h = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n() {
        if (this.f7407c == null) {
            this.f7407c = new CustomMapStyleOptions();
        }
    }

    public final boolean p() {
        return this.f7407c != null;
    }

    public u8(IAMapDelegate iAMapDelegate, Context context, boolean z5) {
        this.f7413i = -1;
        this.f7421q = false;
        this.f7422r = false;
        this.B = false;
        this.f7406b = iAMapDelegate;
        this.f7414j = context;
        this.f7421q = false;
        this.f7422r = false;
        this.B = z5;
        this.f7413i = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
    }

    private void e(MapConfig mapConfig) {
        byte[] bArr;
        if (!mapConfig.isProFunctionAuthEnable()) {
            this.C.clear();
            return;
        }
        String styleResDataPath = this.f7407c.getStyleResDataPath();
        if (this.f7407c.getStyleResData() == null && !TextUtils.isEmpty(styleResDataPath)) {
            this.f7407c.setStyleResData(FileUtil.readFileContents(styleResDataPath));
        }
        if (this.f7407c.getStyleResData() != null || this.f7430z != null) {
            byte[] bArr2 = this.f7430z;
            if (bArr2 == null) {
                bArr2 = this.f7407c.getStyleResData();
            }
            if (bArr2 != null) {
                mapConfig.setUseProFunction(true);
                this.C.clear();
                Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr2, null);
                if (uncompressToByteWithKeys != null) {
                    for (String str : uncompressToByteWithKeys.keySet()) {
                        if (str != null && !str.contains("__MACOSX") && (bArr = uncompressToByteWithKeys.get(str)) != null) {
                            if (FileUtil.isGzip(bArr)) {
                                this.C.put(str, bArr);
                            } else {
                                this.C.put(str, FileUtil.compress(bArr));
                            }
                        }
                    }
                }
            }
        }
    }

    private void f(String str, boolean z5) {
        int i6;
        boolean z6;
        if (!TextUtils.isEmpty(str)) {
            i6 = d2.b(str);
        } else {
            i6 = Integer.MIN_VALUE;
        }
        IAMapDelegate iAMapDelegate = this.f7406b;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null) {
            if (this.f7417m == null) {
                this.f7417m = FileUtil.readFileContentsFromAssets(this.f7414j, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_CUSTOM_BACKGROUND_NAME);
            }
            byte[] bArr = this.f7417m;
            if (bArr != null) {
                if (!z5) {
                    i6 = 0;
                } else if (i6 == Integer.MIN_VALUE) {
                    z6 = true;
                    this.f7406b.getGLMapEngine().setBackgroundTexture(this.f7413i, b3.T((byte[]) bArr.clone(), 0, i6, z6));
                }
                z6 = false;
                this.f7406b.getGLMapEngine().setBackgroundTexture(this.f7413i, b3.T((byte[]) bArr.clone(), 0, i6, z6));
            }
        }
    }

    @Override // com.amap.api.col.3l.x1.a
    public final void a(byte[] bArr, int i6) {
        b(bArr, i6);
    }
}
