package h0;

import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface a {
    void a(LatLng newLatLng, LatLng lastLatLng, float speed, String distance, String avgSpeed, String pace, boolean isPause);

    void b(String avgSpeed, String pace, String countTime, String distance, List<LatLngTimeSpeed> latLngTimeSpeedList);

    void c(LatLng startLatLng);

    void d();

    void e(LatLng latLng);

    void f(String msg);

    void g(String countTime);

    void h(String status, int resId);
}
