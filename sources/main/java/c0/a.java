package c0;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.bn;
import com.bxkj.base.BaseApp;
import com.bxkj.base.util.b0;
import com.bxkj.base.v2.common.utils.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f1040a = new a();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<String, Object> f1041b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appType", "Android");
        b bVar = b.f1042a;
        BaseApp c6 = BaseApp.c();
        g0.o(c6, "getApp(...)");
        linkedHashMap.put("versionCode", Integer.valueOf(bVar.m(c6)));
        BaseApp c7 = BaseApp.c();
        g0.o(c7, "getApp(...)");
        linkedHashMap.put("versionName", bVar.n(c7));
        BaseApp c8 = BaseApp.c();
        g0.o(c8, "getApp(...)");
        linkedHashMap.put("signatureMD5", bVar.f(c8));
        linkedHashMap.put(bn.f10754j, b0.d());
        linkedHashMap.put(bn.f10753i, b0.e());
        linkedHashMap.put(ConstantHelper.LOG_OS, b0.f());
        linkedHashMap.put("version", b0.c());
        f fVar = f.f16889a;
        BaseApp c9 = BaseApp.c();
        g0.o(c9, "getApp(...)");
        linkedHashMap.put("uniqueCode", fVar.d(c9));
        f1041b = linkedHashMap;
    }

    @NotNull
    public final Map<String, Object> a() {
        return f1041b;
    }

    private a() {
    }
}
