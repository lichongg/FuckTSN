package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class l1 {

    /* renamed from: c, reason: collision with root package name */
    private static l1 f50297c;

    /* renamed from: a, reason: collision with root package name */
    private Context f50298a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList f50299b = new ArrayList();

    public final synchronized int[] e() {
        int size = this.f50299b.size();
        if (size <= 0) {
            return new int[0];
        }
        if (size == 1) {
            return new int[]{((Integer) this.f50299b.get(0)).intValue()};
        }
        try {
            ArrayList arrayList = this.f50299b;
            int i6 = size - 10;
            if (i6 <= 0) {
                i6 = 0;
            }
            List subList = arrayList.subList(i6, size);
            int[] iArr = new int[subList.size()];
            for (int i7 = 0; i7 < subList.size(); i7++) {
                iArr[i7] = ((Integer) subList.get(i7)).intValue();
            }
            return iArr;
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    public static l1 c(Context context) {
        if (f50297c == null) {
            synchronized (l1.class) {
                try {
                    if (f50297c == null) {
                        f50297c = new l1(context);
                    }
                } finally {
                }
            }
        }
        return f50297c;
    }

    public final int a() {
        Intent registerReceiver = this.f50298a.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "034497", new byte[]{32, Utf8.REPLACEMENT_BYTE, 67, 82, 9, 41, 55, 92, 108, 106, 53, 52, 73, 84, 72, BinaryMemcacheOpcodes.SASL_AUTH, 48, 6, 108, 107, 47, Byte.MAX_VALUE, 101, 97, 50, 20, 22, 32, 92, 91, 2, 25, 102, 110, BinaryMemcacheOpcodes.SASL_AUTH, 5, 23})));
        if (registerReceiver == null) {
            return -1;
        }
        return registerReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b9faad", new byte[]{99, 55, 0, 18, 89, 118, 101}), -1);
    }

    public final int b() {
        if (this.f50298a.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f6668b", new byte[]{118, HttpConstants.COLON, 65, 80, 8, 124, 97, 89, 110, 104, 99, 49, 75, 86, 73, 116, 102, 3, 110, 105, 121, 122, 103, 99, 51, 65, SignedBytes.MAX_POWER_OF_TWO, 37, 94, 89, 84, 28, 100, 108, 32, 80, 65}))) == null) {
            return -1;
        }
        return Math.round(((r0.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "34228b", new byte[]{46, 51, 87, 67, 11}), -1) / r0.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cb09c5", new byte[]{97, 99, 66, 65, 89}), -1)) * 100.0f) * 10.0f) / 10;
    }

    public final int f() {
        Intent registerReceiver = this.f50298a.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "809a2d", new byte[]{40, 60, 78, 7, 2, 122, Utf8.REPLACEMENT_BYTE, 95, 97, Utf8.REPLACEMENT_BYTE, 61, 55, 68, 1, 67, 114, 56, 5, 97, 62, 39, 124, 104, 52, 57, 71, 30, BinaryMemcacheOpcodes.GATK, 81, 14, 10, 26, 107, HttpConstants.SEMICOLON, 42, 86, Ascii.US})));
        if (registerReceiver == null) {
            return -1;
        }
        int intExtra = registerReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "88c189", new byte[]{HttpConstants.COLON, 46, 17, 81, 18, 61}), -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }

    private l1(Context context) {
        this.f50298a = null;
        this.f50298a = context;
    }

    public final void d() {
        int i6;
        int a6;
        int b6;
        try {
            if (pble.b() != null) {
                try {
                    synchronized (this) {
                        a6 = a();
                        b6 = b();
                    }
                    i6 = (a6 * 10000) + b6;
                } catch (Exception unused) {
                    i6 = -10001;
                }
                this.f50299b.add(Integer.valueOf(i6));
                try {
                    int size = this.f50299b.size();
                    if (size > 20) {
                        ArrayList arrayList = new ArrayList(this.f50299b.subList(size - 10, size));
                        this.f50299b.clear();
                        this.f50299b = arrayList;
                        return;
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
        } catch (Throwable unused3) {
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bc673e", new byte[]{112, 105, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 7, 50, 103, 71, 115, 100, 123, 67, 68, 87, 24, 119, 115, 91, 84, 115, 114, 117, 80, 80, Utf8.REPLACEMENT_BYTE, 102, 115, 75, 105, 96, 51, 104, 75, 3, 14, 115, 98, 73, 96, 117, 124, 116, 75, 71});
    }
}
