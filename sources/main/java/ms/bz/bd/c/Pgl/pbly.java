package ms.bz.bd.c.Pgl;

import android.util.SparseArray;
import com.google.common.primitives.SignedBytes;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pbly {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<pgla> f50380a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f50381b = 0;

    public static abstract class pgla {
        protected Object b(long j6, String str, Object obj) throws Throwable {
            return null;
        }

        public Object a(int i6, int i7, long j6, String str, Object obj) throws Throwable {
            return b(j6, str, obj);
        }
    }

    public static Object a(int i6, int i7, long j6, String str, Object obj) {
        pgla pglaVar = f50380a.get(i6);
        if (pglaVar == null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c7cf03", new byte[]{125, 37, 80, 17, 0, 32, 101, 86, 119, 50, 50, 60, 3, 82, 6, 42, 118, 23, 62, Utf8.REPLACEMENT_BYTE, 118}), Integer.valueOf(i6)));
        }
        try {
            return pglaVar.a(i6, i7, j6, str, obj);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static void b(int i6, pgla pglaVar) {
        SparseArray<pgla> sparseArray = f50380a;
        pgla pglaVar2 = sparseArray.get(i6);
        if (pglaVar2 != null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f3c10f", new byte[]{50, 34, 80, 77, 14, 117, 37, 16, 55, 100, 121, 113, 2, SignedBytes.MAX_POWER_OF_TWO, 8, 120, 118, 6, 55, 115, 57}), pglaVar2.toString()));
        }
        sparseArray.put(i6, pglaVar);
    }
}
