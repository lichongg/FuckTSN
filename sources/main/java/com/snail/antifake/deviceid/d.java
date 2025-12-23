package com.snail.antifake.deviceid;

import android.os.Handler;
import android.os.Looper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Handler f37531a = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f37532a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f37533b;

        a(String str, c cVar) {
            this.f37532a = str;
            this.f37533b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[0], 0, 0);
            try {
                DatagramSocket datagramSocket = new DatagramSocket();
                int i6 = 2;
                while (i6 < 255) {
                    datagramPacket.setAddress(InetAddress.getByName(this.f37532a + String.valueOf(i6)));
                    datagramSocket.send(datagramPacket);
                    i6++;
                    if (i6 == 125) {
                        datagramSocket.close();
                        datagramSocket = new DatagramSocket();
                    }
                }
                datagramSocket.close();
                d.this.c(this.f37533b);
            } catch (SocketException e6) {
                e6.printStackTrace();
            } catch (UnknownHostException e7) {
                e7.printStackTrace();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f37535a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f37537a;

            a(Map map) {
                this.f37537a = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f37535a.a(this.f37537a);
            }
        }

        b(c cVar) {
            this.f37535a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat proc/net/arp").getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        d.this.f37531a.post(new a(hashMap));
                        return;
                    } else if (!readLine.contains("00:00:00:00:00:00") && !readLine.contains("IP")) {
                        String[] split = readLine.split("\\s+");
                        hashMap.put(split[3], split[0]);
                    }
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a(Map<String, String> map);
    }

    private String d() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!(nextElement instanceof Inet6Address) && !"127.0.0.1".equals(nextElement.getHostAddress())) {
                            str = nextElement.getHostAddress();
                            break;
                        }
                    }
                }
            }
            return str;
        } catch (SocketException e6) {
            e6.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(c cVar) {
        new Thread(new b(cVar)).start();
    }

    public void e(c cVar) {
        new ArrayList();
        new HashMap();
        String d6 = d();
        new Thread(new a(d6.substring(0, d6.lastIndexOf(".") + 1), cVar)).start();
    }
}
