package ms.bz.bd.c.Pgl;

import android.content.Context;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.lang.reflect.Method;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class v1 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f50390a;

    /* renamed from: b, reason: collision with root package name */
    private Class f50391b;

    /* renamed from: c, reason: collision with root package name */
    private Object f50392c;

    /* renamed from: d, reason: collision with root package name */
    private Method f50393d;

    public final String a() {
        Context context = this.f50390a;
        Method method = this.f50393d;
        Object obj = this.f50392c;
        if (obj == null || method == null) {
            return null;
        }
        try {
            return (String) method.invoke(obj, context);
        } catch (Exception unused) {
            return null;
        }
    }

    public v1(Context context) {
        this.f50390a = context;
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "51c5bf", new byte[]{39, 60, 29, 15, 92, Byte.MAX_VALUE, 50, 2, 61, 108, 32, 125, 25, 69, 19, 120, HttpConstants.SEMICOLON, 0, 62, 43, 13, 55, 32, 83, 82, 103, Utf8.REPLACEMENT_BYTE, 20, 55, 119, 13, 62, 0, 77}));
            this.f50391b = cls;
            this.f50392c = cls.newInstance();
        } catch (Exception unused) {
        }
        try {
            this.f50393d = this.f50391b.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "551efe", new byte[]{BinaryMemcacheOpcodes.GATK, 50, 86, 62, 120, 91, 18}), Context.class);
        } catch (Exception unused2) {
        }
    }
}
