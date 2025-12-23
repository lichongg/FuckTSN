package com.umeng.analytics.filter;

import android.util.Base64;
import com.baidu.mobads.sdk.internal.by;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static final String f40809b = "Ă";

    /* renamed from: c, reason: collision with root package name */
    private MessageDigest f40811c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f40813e;

    /* renamed from: a, reason: collision with root package name */
    private final String f40810a = by.f10823a;

    /* renamed from: d, reason: collision with root package name */
    private Set<Object> f40812d = new HashSet();

    public boolean a(String str) {
        return this.f40813e ? this.f40812d.contains(c(str)) : this.f40812d.contains(str);
    }

    private Integer c(String str) {
        try {
            this.f40811c.update(str.getBytes());
            byte[] digest = this.f40811c.digest();
            return Integer.valueOf(((digest[0] & 255) << 24) + ((digest[1] & 255) << 16) + ((digest[2] & 255) << 8) + (digest[3] & 255));
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public void b(String str) {
        if (this.f40813e) {
            this.f40812d.add(c(str));
        } else {
            this.f40812d.add(str);
        }
    }

    public String toString() {
        if (!this.f40813e) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : this.f40812d) {
                if (sb.length() > 0) {
                    sb.append(f40809b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.f40812d.size() * 4];
        Iterator<Object> it = this.f40812d.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            bArr[i6] = (byte) (((-16777216) & intValue) >> 24);
            bArr[i6 + 1] = (byte) ((16711680 & intValue) >> 16);
            int i7 = i6 + 3;
            bArr[i6 + 2] = (byte) ((65280 & intValue) >> 8);
            i6 += 4;
            bArr[i7] = (byte) (intValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }

    public d(boolean z5, String str) {
        this.f40813e = z5;
        try {
            this.f40811c = MessageDigest.getInstance(by.f10823a);
        } catch (NoSuchAlgorithmException e6) {
            e6.printStackTrace();
        }
        if (str != null) {
            int i6 = 0;
            if (z5) {
                try {
                    byte[] decode = Base64.decode(str.getBytes(), 0);
                    while (i6 < decode.length / 4) {
                        int i7 = i6 * 4;
                        this.f40812d.add(Integer.valueOf(((decode[i7] & 255) << 24) + ((decode[i7 + 1] & 255) << 16) + ((decode[i7 + 2] & 255) << 8) + (decode[i7 + 3] & 255)));
                        i6++;
                    }
                    return;
                } catch (IllegalArgumentException e7) {
                    e7.printStackTrace();
                    return;
                }
            }
            String[] split = str.split(f40809b);
            int length = split.length;
            while (i6 < length) {
                this.f40812d.add(split[i6]);
                i6++;
            }
        }
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.f40812d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.getClass();
    }
}
