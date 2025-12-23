package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class c<T> implements g<ResponseBody, T> {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f52095a;

    /* renamed from: b, reason: collision with root package name */
    private final TypeAdapter<T> f52096b;

    @Override // retrofit2.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T convert(ResponseBody responseBody) throws IOException {
        JsonReader newJsonReader = this.f52095a.newJsonReader(responseBody.charStream());
        try {
            T read = this.f52096b.read(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }

    c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f52095a = gson;
        this.f52096b = typeAdapter;
    }
}
