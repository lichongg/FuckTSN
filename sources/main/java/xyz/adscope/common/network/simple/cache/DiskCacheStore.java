package xyz.adscope.common.network.simple.cache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.secure.Encryption;
import xyz.adscope.common.network.secure.Secret;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DiskCacheStore implements CacheStore {

    /* renamed from: a, reason: collision with root package name */
    private Secret f56720a;

    /* renamed from: b, reason: collision with root package name */
    private String f56721b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.simple.cache.DiskCacheStore$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f56722a;

        /* renamed from: b, reason: collision with root package name */
        private String f56723b;

        /* synthetic */ Builder(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private Builder(String str) {
            this.f56722a = str;
        }

        public DiskCacheStore build() {
            return new DiskCacheStore(this, null);
        }

        public Builder password(String str) {
            this.f56723b = str;
            return this;
        }
    }

    /* synthetic */ DiskCacheStore(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private DiskCacheStore(Builder builder) {
        this.f56721b = builder.f56722a;
        this.f56720a = Encryption.createSecret(TextUtils.isEmpty(builder.f56723b) ? this.f56721b : builder.f56723b);
    }

    private String a(String str) {
        return this.f56720a.decrypt(str);
    }

    private String b(String str) {
        return this.f56720a.encrypt(str);
    }

    private String c(String str) {
        return Encryption.getMD5ForString(this.f56721b + str);
    }

    public static Builder newBuilder(String str) {
        return new Builder(str, null);
    }

    @Override // xyz.adscope.common.network.simple.cache.CacheStore
    public boolean clear() {
        return IOUtils.delFileOrFolder(this.f56721b);
    }

    @Override // xyz.adscope.common.network.simple.cache.CacheStore
    public Cache get(String str) {
        BufferedReader bufferedReader;
        String c6 = c(str);
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File(this.f56721b, c6);
            if (file.exists() && !file.isDirectory()) {
                Cache cache = new Cache();
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    cache.setCode(Integer.parseInt(a(bufferedReader.readLine())));
                    cache.setHeaders(Headers.fromJSONString(a(bufferedReader.readLine())));
                    cache.setBody(Encryption.hexToByteArray(a(bufferedReader.readLine())));
                    cache.setExpires(Long.parseLong(a(bufferedReader.readLine())));
                    IOUtils.closeQuietly(bufferedReader);
                    return cache;
                } catch (Exception unused) {
                    try {
                        IOUtils.delFileOrFolder(new File(this.f56721b, c6));
                        IOUtils.closeQuietly(bufferedReader);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        bufferedReader = bufferedReader2;
                        IOUtils.closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly(bufferedReader);
                    throw th;
                }
            }
            IOUtils.closeQuietly(null);
            return null;
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = bufferedReader2;
            IOUtils.closeQuietly(bufferedReader);
            throw th;
        }
    }

    @Override // xyz.adscope.common.network.simple.cache.CacheStore
    public boolean remove(String str) {
        return IOUtils.delFileOrFolder(new File(this.f56721b, c(str)));
    }

    @Override // xyz.adscope.common.network.simple.cache.CacheStore
    public boolean replace(String str, Cache cache) {
        String c6 = c(str);
        BufferedWriter bufferedWriter = null;
        try {
            if (!TextUtils.isEmpty(c6) && cache != null) {
                if (!IOUtils.createFolder(this.f56721b)) {
                    return false;
                }
                File file = new File(this.f56721b, c6);
                if (!IOUtils.createNewFile(file)) {
                    return false;
                }
                bufferedWriter = IOUtils.toBufferedWriter(new FileWriter(file));
                bufferedWriter.write(b(Integer.toString(cache.getCode())));
                bufferedWriter.newLine();
                bufferedWriter.write(b(Headers.toJSONString(cache.getHeaders())));
                bufferedWriter.newLine();
                bufferedWriter.write(b(Encryption.byteArrayToHex(cache.getBody())));
                bufferedWriter.newLine();
                bufferedWriter.write(b(Long.toString(cache.getExpires())));
                bufferedWriter.flush();
                IOUtils.closeQuietly(bufferedWriter);
                return true;
            }
            return false;
        } catch (Exception unused) {
            IOUtils.delFileOrFolder(new File(this.f56721b, c6));
            return false;
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
        }
    }
}
