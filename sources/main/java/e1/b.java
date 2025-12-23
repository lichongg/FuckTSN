package e1;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.exception.BleException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class b extends BluetoothGattCallback {
    public abstract void c(BleDevice bleDevice, BleException bleException);

    public abstract void d(BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6);

    public abstract void e(boolean z5, BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6);

    public abstract void f();
}
