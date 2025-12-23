package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.security.MessageDigest;
import ms.bz.bd.c.Pgl.pblk;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class b1 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f50283a;

    /* renamed from: b, reason: collision with root package name */
    private String f50284b;

    /* renamed from: c, reason: collision with root package name */
    private c1 f50285c;

    /* renamed from: d, reason: collision with root package name */
    ServiceConnection f50286d;

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b1.this.f50285c = new c1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            b1.this.f50285c = null;
        }
    }

    private String a(c1 c1Var, String str) {
        Signature[] signatureArr;
        String str2;
        MessageDigest messageDigest;
        String packageName = this.f50283a.getPackageName();
        String str3 = null;
        if (this.f50284b == null) {
            try {
                signatureArr = this.f50283a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception unused) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    messageDigest = MessageDigest.getInstance((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "23c2aa", new byte[]{16, 25, 49, 23}));
                } catch (Exception unused2) {
                }
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b6 : digest) {
                        sb.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3));
                    }
                    str2 = sb.toString();
                    this.f50284b = str2;
                }
            }
            str2 = null;
            this.f50284b = str2;
        }
        String str4 = this.f50284b;
        c1Var.getClass();
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "db40f4", new byte[]{118, 111, 74, 10, 81, 38, 126, 87, 100, 112, HttpConstants.SEMICOLON, 111, 87, 65, 87, 42, 99, 13, 76, 79, 101, 101, 73, 109, 125}));
                obtain.writeString(packageName);
                obtain.writeString(str4);
                obtain.writeString(str);
                c1Var.f50288a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str3 = obtain2.readString();
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        } catch (Exception unused3) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dc4b3e", new byte[]{122, 113, 78});
        }
        obtain.recycle();
        obtain2.recycle();
        return str3;
    }

    public b1(Context context) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c4be4c", new byte[]{93, 3, 56, 53});
        this.f50286d = new pgla();
        this.f50283a = context;
    }

    public final void c(pblk.pblb pblbVar) {
        boolean z5;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "549818", new byte[]{39, 57, 71, 2, 6, 42, 47, 1, 105, 120, 106, 57, 90, 73, 0, 38, 50}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0bf234", new byte[]{34, 111, 24, 8, 4, 38, 42, 87, 54, 114, 111, 111, 5, 67, 2, 42, 55, 13, 30, 102, BinaryMemcacheOpcodes.GATKQ, 110, 1, 79, 10, HttpConstants.COLON, 0, 70, 37, 116, 40, 99, 16})));
            intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3e59a2", new byte[]{BinaryMemcacheOpcodes.GATK, 100, 82, 68, 81, 43, 126, 71, 107, 100, 108, 111, 67, 84, 74, BinaryMemcacheOpcodes.GATKQ, 32, 10, 107, 121, 39, 105, 79, 73, 16, 10, 0, 97, 74, 86, 11, 67, 121, 126, 123, 23, 6, 109, 71, 76}));
            try {
                z5 = true;
            } catch (Throwable unused) {
                z5 = false;
            }
            if (this.f50283a.bindService(intent, this.f50286d, 1)) {
                try {
                    try {
                        SystemClock.sleep(3000L);
                    } catch (Throwable unused2) {
                        try {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a140b", new byte[]{45, 115});
                            if (!z5) {
                                return;
                            }
                            this.f50283a.unbindService(this.f50286d);
                            return;
                        } finally {
                        }
                    }
                } catch (Exception unused3) {
                }
                c1 c1Var = this.f50285c;
                if (c1Var != null) {
                    String a6 = a(c1Var, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c527fe", new byte[]{93, 2, 104, 103}));
                    if (pblbVar != null) {
                        pblbVar.j(a6);
                    }
                }
                this.f50283a.unbindService(this.f50286d);
                return;
            }
            return;
        }
        throw new IllegalStateException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0444b4", new byte[]{2, 55, 73, 78, 82, 55, 115, 7, 112, 106, 97, 57, 73, 0, 112, 34, HttpConstants.COLON, Ascii.ESC, 81, 108, 51, 51, 70, 68}));
    }
}
