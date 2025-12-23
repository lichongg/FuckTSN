package com.bxkj.base.v2.common.utils;

import java.nio.charset.Charset;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final C0190a f16871a = new C0190a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f16872b = com.acse.ottn.f.f4513a;

    /* renamed from: c, reason: collision with root package name */
    private static final int f16873c = 24;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f16874d = "thanks,pig4cloud";

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f16875e = "thanks,pig4cloud";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nAESUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AESUtils.kt\ncom/bxkj/base/v2/common/utils/AESUtils$Companion\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,146:1\n106#2:147\n78#2,22:148\n*S KotlinDebug\n*F\n+ 1 AESUtils.kt\ncom/bxkj/base/v2/common/utils/AESUtils$Companion\n*L\n138#1:147\n138#1:148,22\n*E\n"})
    /* renamed from: com.bxkj.base.v2.common.utils.a$a, reason: collision with other inner class name */
    public static final class C0190a {
        public /* synthetic */ C0190a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private C0190a() {
        }

        @Nullable
        public final String a(@Nullable String str, @NotNull String key) throws Exception {
            kotlin.jvm.internal.g0.p(key, "key");
            try {
                int length = key.length();
                if (length != 16 && length != 24 && length != 32) {
                    System.out.getClass();
                    return null;
                }
                Charset forName = Charset.forName("utf-8");
                kotlin.jvm.internal.g0.o(forName, "forName(...)");
                byte[] bytes = key.getBytes(forName);
                kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
                Cipher cipher = Cipher.getInstance(a.f16872b);
                cipher.init(2, secretKeySpec);
                try {
                    byte[] doFinal = cipher.doFinal(cn.bluemobi.dylan.base.utils.b.a(str));
                    kotlin.jvm.internal.g0.m(doFinal);
                    Charset forName2 = Charset.forName("UTF-8");
                    kotlin.jvm.internal.g0.o(forName2, "forName(...)");
                    return new String(doFinal, forName2);
                } catch (Exception e6) {
                    e6.toString();
                    System.out.getClass();
                    return null;
                }
            } catch (Exception e7) {
                e7.toString();
                System.out.getClass();
                return null;
            }
        }

        @Nullable
        public final String b(@NotNull String data, @NotNull String key) throws Exception {
            kotlin.jvm.internal.g0.p(data, "data");
            kotlin.jvm.internal.g0.p(key, "key");
            int length = key.length();
            if (length != 16 && length != 24 && length != 32) {
                System.out.getClass();
                return null;
            }
            Charset forName = Charset.forName("utf-8");
            kotlin.jvm.internal.g0.o(forName, "forName(...)");
            byte[] bytes = key.getBytes(forName);
            kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance(a.f16872b);
            cipher.init(1, secretKeySpec);
            Charset forName2 = Charset.forName("utf-8");
            kotlin.jvm.internal.g0.o(forName2, "forName(...)");
            byte[] bytes2 = data.getBytes(forName2);
            kotlin.jvm.internal.g0.o(bytes2, "getBytes(...)");
            return cn.bluemobi.dylan.base.utils.b.b(cipher.doFinal(bytes2));
        }

        @Nullable
        public final String c(@NotNull String data) throws Exception {
            kotlin.jvm.internal.g0.p(data, "data");
            try {
                Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.f35751a);
                int blockSize = cipher.getBlockSize();
                Charset charset = kotlin.text.e.f47851b;
                byte[] bytes = data.getBytes(charset);
                kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
                int length = bytes.length;
                if (length % blockSize != 0) {
                    length += blockSize - (length % blockSize);
                }
                byte[] bArr = new byte[length];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                byte[] bytes2 = a.f16874d.getBytes(charset);
                kotlin.jvm.internal.g0.o(bytes2, "getBytes(...)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "AES");
                byte[] bytes3 = a.f16875e.getBytes(charset);
                kotlin.jvm.internal.g0.o(bytes3, "getBytes(...)");
                cipher.init(1, secretKeySpec, new IvParameterSpec(bytes3));
                String b6 = cn.bluemobi.dylan.base.utils.b.b(cipher.doFinal(bArr));
                kotlin.jvm.internal.g0.o(b6, "encode(...)");
                int length2 = b6.length() - 1;
                int i6 = 0;
                boolean z5 = false;
                while (i6 <= length2) {
                    boolean z6 = kotlin.jvm.internal.g0.t(b6.charAt(!z5 ? i6 : length2), 32) <= 0;
                    if (z5) {
                        if (!z6) {
                            break;
                        }
                        length2--;
                    } else if (z6) {
                        i6++;
                    } else {
                        z5 = true;
                    }
                }
                return b6.subSequence(i6, length2 + 1).toString();
            } catch (Exception e6) {
                e6.printStackTrace();
                return null;
            }
        }

        @Nullable
        public final String d(int i6) {
            if (i6 != 16 && i6 != 24 && i6 != 32) {
                System.out.getClass();
                return null;
            }
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i7 = 0; i7 < i6; i7++) {
                sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
            }
            return sb.toString();
        }
    }
}
