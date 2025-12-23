package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a implements n {
    protected int memoizedHashCode = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0905a<BuilderType extends AbstractC0905a> implements n.a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a$a, reason: collision with other inner class name */
        static final class C0906a extends FilterInputStream {

            /* renamed from: a, reason: collision with root package name */
            private int f46462a;

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f46462a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f46462a--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j6) throws IOException {
                long skip = super.skip(Math.min(j6, this.f46462a));
                if (skip >= 0) {
                    this.f46462a = (int) (this.f46462a - skip);
                }
                return skip;
            }

            C0906a(InputStream inputStream, int i6) {
                super(inputStream);
                this.f46462a = i6;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f46462a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i6, int i7) throws IOException {
                int i8 = this.f46462a;
                if (i8 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i6, Math.min(i7, i8));
                if (read >= 0) {
                    this.f46462a -= read;
                }
                return read;
            }
        }

        @Override // 
        /* renamed from: c */
        public abstract BuilderType p();

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
        public abstract BuilderType e(e eVar, f fVar) throws IOException;

        protected static <T> void a(Iterable<T> iterable, Collection<? super T> collection) {
            if (iterable instanceof l) {
                b(((l) iterable).h());
                collection.addAll((Collection) iterable);
            } else {
                if (iterable instanceof Collection) {
                    b(iterable);
                    collection.addAll((Collection) iterable);
                    return;
                }
                for (T t5 : iterable) {
                    t5.getClass();
                    collection.add(t5);
                }
            }
        }

        protected static UninitializedMessageException f(n nVar) {
            return new UninitializedMessageException(nVar);
        }

        private static void b(Iterable<?> iterable) {
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
        }
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream L = CodedOutputStream.L(bArr);
            writeTo(L);
            L.a();
            return bArr;
        } catch (IOException e6) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e6);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream K = CodedOutputStream.K(outputStream, CodedOutputStream.v(CodedOutputStream.w(serializedSize) + serializedSize));
        K.s0(serializedSize);
        writeTo(K);
        K.J();
    }
}
