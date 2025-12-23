package com.clj.fastble.bluetooth;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.clj.fastble.exception.BleException;
import com.clj.fastble.exception.OtherException;
import e1.k;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f32057a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f32058b;

    /* renamed from: c, reason: collision with root package name */
    private com.clj.fastble.bluetooth.b f32059c;

    /* renamed from: d, reason: collision with root package name */
    private String f32060d;

    /* renamed from: e, reason: collision with root package name */
    private String f32061e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f32062f;

    /* renamed from: g, reason: collision with root package name */
    private int f32063g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f32064h;

    /* renamed from: i, reason: collision with root package name */
    private long f32065i;

    /* renamed from: j, reason: collision with root package name */
    private k f32066j;

    /* renamed from: k, reason: collision with root package name */
    private Queue<byte[]> f32067k;

    /* renamed from: l, reason: collision with root package name */
    private int f32068l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 51) {
                e.this.l();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends k {
        b() {
        }

        @Override // e1.k
        public void e(BleException bleException) {
            if (e.this.f32066j != null) {
                e.this.f32066j.e(new OtherException("exception occur while writing: " + bleException.getDescription()));
            }
            if (e.this.f32064h) {
                e.this.f32058b.sendMessageDelayed(e.this.f32058b.obtainMessage(51), e.this.f32065i);
            }
        }

        @Override // e1.k
        public void f(int i6, int i7, byte[] bArr) {
            int size = e.this.f32068l - e.this.f32067k.size();
            if (e.this.f32066j != null) {
                e.this.f32066j.f(size, e.this.f32068l, bArr);
            }
            if (e.this.f32064h) {
                e.this.f32058b.sendMessageDelayed(e.this.f32058b.obtainMessage(51), e.this.f32065i);
            }
        }
    }

    private void h() {
        this.f32057a.quit();
        this.f32058b.removeCallbacksAndMessages(null);
    }

    private static Queue<byte[]> i(byte[] bArr, int i6) {
        byte[] bArr2;
        if (i6 > 20) {
            com.clj.fastble.utils.a.d("Be careful: split count beyond 20! Ensure MTU higher than 23!");
        }
        LinkedList linkedList = new LinkedList();
        int length = bArr.length % i6 == 0 ? bArr.length / i6 : Math.round((bArr.length / i6) + 1);
        if (length > 0) {
            for (int i7 = 0; i7 < length; i7++) {
                if (length == 1 || i7 == length - 1) {
                    int length2 = bArr.length % i6 == 0 ? i6 : bArr.length % i6;
                    byte[] bArr3 = new byte[length2];
                    System.arraycopy(bArr, i7 * i6, bArr3, 0, length2);
                    bArr2 = bArr3;
                } else {
                    bArr2 = new byte[i6];
                    System.arraycopy(bArr, i7 * i6, bArr2, 0, i6);
                }
                linkedList.offer(bArr2);
            }
        }
        return linkedList;
    }

    private void j() {
        byte[] bArr = this.f32062f;
        if (bArr == null) {
            throw new IllegalArgumentException("data is Null!");
        }
        int i6 = this.f32063g;
        if (i6 < 1) {
            throw new IllegalArgumentException("split count should higher than 0!");
        }
        Queue<byte[]> i7 = i(bArr, i6);
        this.f32067k = i7;
        this.f32068l = i7.size();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f32067k.peek() == null) {
            h();
            return;
        }
        this.f32059c.L().x(this.f32060d, this.f32061e).y(this.f32067k.poll(), new b(), this.f32061e);
        if (this.f32064h) {
            return;
        }
        this.f32058b.sendMessageDelayed(this.f32058b.obtainMessage(51), this.f32065i);
    }

    public void k(com.clj.fastble.bluetooth.b bVar, String str, String str2, byte[] bArr, boolean z5, long j6, k kVar) {
        this.f32059c = bVar;
        this.f32060d = str;
        this.f32061e = str2;
        this.f32062f = bArr;
        this.f32064h = z5;
        this.f32065i = j6;
        this.f32063g = com.clj.fastble.a.v().D();
        this.f32066j = kVar;
        j();
    }

    public e() {
        HandlerThread handlerThread = new HandlerThread("splitWriter");
        this.f32057a = handlerThread;
        handlerThread.start();
        this.f32058b = new a(this.f32057a.getLooper());
    }
}
