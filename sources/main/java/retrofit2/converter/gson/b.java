package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class b<T> implements g<T, RequestBody> {

    /* renamed from: c, reason: collision with root package name */
    private static final MediaType f52091c = MediaType.get("application/json; charset=UTF-8");

    /* renamed from: d, reason: collision with root package name */
    private static final Charset f52092d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final Gson f52093a;

    /* renamed from: b, reason: collision with root package name */
    private final TypeAdapter<T> f52094b;

    @Override // retrofit2.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequestBody convert(T t5) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.f52093a.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), f52092d));
        this.f52094b.write(newJsonWriter, t5);
        newJsonWriter.close();
        return RequestBody.create(f52091c, buffer.readByteString());
    }

    b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f52093a = gson;
        this.f52094b = typeAdapter;
    }
}
