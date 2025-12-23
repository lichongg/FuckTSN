package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.google.common.primitives.SignedBytes;
import com.stub.StubApp;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import okio.Utf8;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f50309a;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f50310b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static CopyOnWriteArraySet f50311c = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f50312d = 0;

    public interface pgla {
        String a();

        Map<String, String> b(String str, byte[] bArr);

        void c(String str);

        void d(String str);

        void e(String str);

        void f(String str);

        void g(int i6);
    }

    static synchronized void b(Context context) {
        synchronized (n0.class) {
            if (!f50309a) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                pblv.a().b(origApplicationContext);
                e1.a(origApplicationContext);
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a3d8a5", new byte[]{62, 60, 4});
                pbly.b(16777218, new j());
                pbly.b(16777217, new u());
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "955618", new byte[]{102, HttpConstants.COLON, 66});
                pbly.b(16777219, new f0());
                pbly.b(16777221, new g0());
                pbly.b(16777222, new h0());
                pbly.b(16777223, new i0());
                pbly.b(16777224, new j0());
                pbly.b(16777225, new k0());
                pbly.b(16777226, new l0());
                pbly.b(16777228, new pblz());
                pbly.b(InputDeviceCompat.SOURCE_JOYSTICK, new a());
                pbly.b(16777233, new b());
                pbly.b(16777235, new c());
                pbly.b(16777238, new d());
                pbly.b(16777239, new e());
                pbly.b(16777241, new f());
                pbly.b(16777242, new g());
                pbly.b(16777243, new h());
                pbly.b(16777244, new i());
                pbly.b(16777245, new k());
                pbly.b(16777246, new l());
                pbly.b(16777247, new m());
                pbly.b(16777248, new n());
                pbly.b(16777249, new o());
                pbly.b(16777250, new p());
                pbly.b(16777251, new q());
                pbly.b(16777240, new r());
                pbly.b(16777252, new s());
                pbly.b(16777253, new t());
                pbly.b(16777254, new v());
                pbly.b(16777255, new w());
                pbly.b(16777256, new x());
                pbly.b(16777257, new y());
                pbly.b(16777258, new z());
                pbly.b(16777259, new a0());
                pbly.b(16777261, new b0());
                pbly.b(16777266, new c0());
                pbly.b(16777272, new d0());
                pbly.b(33554435, new e0());
                v0.a();
                w0.a();
                com.volcengine.mobsecBiz.matrix.pgla.a(16777219, 0, 0L, null, origApplicationContext);
                f50309a = true;
            }
        }
    }

    public static synchronized void c(String str) {
        synchronized (n0.class) {
            if (pblv.a().c() != null) {
                pblu pbluVar = (pblu) f50310b.get(str);
                if (e(str) != null && pbluVar != null) {
                    f50311c.addAll(pbluVar.f50374p);
                    com.volcengine.mobsecBiz.metasec.ml.b a6 = com.volcengine.mobsecBiz.metasec.ml.c.a(str);
                    if (a6 != null) {
                        a6.d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3856e8", new byte[]{29, 51, 72, 75, 78, 16, 34, 28, 116, 105, 48, 46}));
                    }
                }
            }
        }
    }

    public static synchronized boolean d(Context context, pblu pbluVar) {
        synchronized (n0.class) {
            try {
                if (context == null) {
                    throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "074801", new byte[]{34, HttpConstants.COLON, 73, 88, 10, 62, 39, 86, 102, 103, 52, 57, 67, 12, 1, 41, 39, 86, 103, 109, 97, HttpConstants.SEMICOLON, 82, SignedBytes.MAX_POWER_OF_TWO, 3}));
                }
                if (pbluVar == null) {
                    throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1649cb", new byte[]{BinaryMemcacheOpcodes.GATK, HttpConstants.SEMICOLON, 73, 75, 85, 114, 114, 20, 106, 124, HttpConstants.COMMA, 48, 7, 67, 83, 97, 114, 21, 96, 41, 46, BinaryMemcacheOpcodes.SASL_AUTH, 75, 65}));
                }
                String str = pbluVar.f50359a;
                String str2 = (str == null || str.length() <= 0) ? pbluVar.f50365g : pbluVar.f50359a;
                if (str2 == null || str2.length() <= 0) {
                    throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1497c9", new byte[]{BinaryMemcacheOpcodes.SASL_AUTH, 38, 90, 106, 120, 110, Utf8.REPLACEMENT_BYTE, 0, 123, 115, 96, 52, 79, 3, 79, 43, 38}));
                }
                if (!f50309a) {
                    synchronized (n0.class) {
                        try {
                            if (!f50309a) {
                                b(context);
                                f50309a = true;
                            }
                        } finally {
                        }
                    }
                }
                if (f50310b.containsKey(str2)) {
                    return false;
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(pblu.a(pbluVar.f50359a));
                jSONArray.put(pblu.a(pbluVar.f50366h));
                jSONArray.put(pblu.a(pbluVar.f50365g));
                jSONArray.put(pblu.a(pbluVar.f50367i));
                jSONArray.put(pblu.a(n1.a()));
                jSONArray.put(pblu.a(pbluVar.f50360b));
                jSONArray.put(pblu.a(pbluVar.f50361c));
                jSONArray.put(pblu.a(pbluVar.f50362d));
                jSONArray.put(pblu.a(pbluVar.f50363e));
                jSONArray.put(pblu.a(pbluVar.f50364f));
                jSONArray.put(String.valueOf(pbluVar.f50369k));
                jSONArray.put(String.valueOf(pbluVar.f50370l));
                jSONArray.put(String.valueOf(pbluVar.f50371m));
                JSONArray jSONArray2 = new JSONArray();
                for (Map.Entry<String, String> entry : pbluVar.f50372n.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONArray2.put(pblu.a(entry.getKey()));
                        jSONArray2.put(pblu.a(entry.getValue()));
                    }
                }
                jSONArray.put(jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                for (Map.Entry entry2 : pbluVar.f50373o.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry2.getKey())) {
                        if (((String) entry2.getKey()).equals("kOA1") && TextUtils.equals((CharSequence) entry2.getValue(), "1")) {
                            a1.f50277c = false;
                            a1.f50278d = pbluVar.f50368j;
                        }
                        jSONArray3.put(pblu.a(entry2.getKey()));
                        jSONArray3.put(pblu.a(entry2.getValue()));
                    }
                }
                jSONArray.put(jSONArray3);
                String jSONArray4 = jSONArray.toString();
                int i6 = pbly.f50381b;
                if (!((Boolean) com.volcengine.mobsecBiz.matrix.pgla.a(67108865, 0, 0L, jSONArray4, null)).booleanValue()) {
                    return false;
                }
                f50310b.put(str2, pbluVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized m0 e(String str) {
        synchronized (n0.class) {
            if (str == null) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "45d9c4", new byte[]{BinaryMemcacheOpcodes.GATKQ, 39, 7, 100, 120, 99, HttpConstants.COLON, 1, 38, 125, 101, 53, 18, 13, 79, 38, BinaryMemcacheOpcodes.GATK}));
            }
            if (!f50309a) {
                return null;
            }
            int i6 = pbly.f50381b;
            Object a6 = com.volcengine.mobsecBiz.matrix.pgla.a(67108866, 0, 0L, str, null);
            if (a6 == null) {
                return null;
            }
            pblu pbluVar = (pblu) f50310b.get(str);
            if (pbluVar == null) {
                return null;
            }
            return new m0(pbluVar, pblv.a().c(), ((Long) a6).longValue());
        }
    }

    protected n0() {
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "03a485", new byte[]{46, Utf8.REPLACEMENT_BYTE, 32, 69, 23, 45, BinaryMemcacheOpcodes.SASL_AUTH, 6, 22, 109, 47, 56, 1, 72, 71, 54, 60, 25, 53, 106, 97, 124, 95, 13, 71});
            Iterator it = f50311c.iterator();
            while (it.hasNext()) {
                ((PglITokenObserver) it.next()).onTokenLoaded(str);
            }
        }
    }
}
