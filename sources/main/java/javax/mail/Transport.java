package javax.mail;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Transport extends Service {
    private Vector transportListeners;

    public static void send(Message message) throws MessagingException {
        message.saveChanges();
        send0(message, message.getAllRecipients());
    }

    public synchronized void addTransportListener(TransportListener transportListener) {
        try {
            if (this.transportListeners == null) {
                this.transportListeners = new Vector();
            }
            this.transportListeners.addElement(transportListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void removeTransportListener(TransportListener transportListener) {
        Vector vector = this.transportListeners;
        if (vector != null) {
            vector.removeElement(transportListener);
        }
    }

    public abstract void sendMessage(Message message, Address[] addressArr) throws MessagingException;

    private static void send0(Message message, Address[] addressArr) throws MessagingException {
        Address[] addressArr2;
        Address[] addressArr3;
        Transport transport;
        if (addressArr == null || addressArr.length == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        Hashtable hashtable = new Hashtable();
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i6 = 0; i6 < addressArr.length; i6++) {
            if (hashtable.containsKey(addressArr[i6].getType())) {
                ((Vector) hashtable.get(addressArr[i6].getType())).addElement(addressArr[i6]);
            } else {
                Vector vector4 = new Vector();
                vector4.addElement(addressArr[i6]);
                hashtable.put(addressArr[i6].getType(), vector4);
            }
        }
        int size = hashtable.size();
        if (size == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        Session session = message.session;
        Address[] addressArr4 = null;
        if (session == null) {
            session = Session.getDefaultInstance(System.getProperties(), null);
        }
        if (size == 1) {
            transport = session.getTransport(addressArr[0]);
            try {
                transport.connect();
                transport.sendMessage(message, addressArr);
                return;
            } finally {
            }
        }
        Enumeration elements = hashtable.elements();
        MessagingException messagingException = null;
        boolean z5 = false;
        while (elements.hasMoreElements()) {
            Vector vector5 = (Vector) elements.nextElement();
            int size2 = vector5.size();
            Address[] addressArr5 = new Address[size2];
            vector5.copyInto(addressArr5);
            transport = session.getTransport(addressArr5[0]);
            if (transport == null) {
                for (int i7 = 0; i7 < size2; i7++) {
                    vector.addElement(addressArr5[i7]);
                }
            } else {
                try {
                    try {
                        transport.connect();
                        transport.sendMessage(message, addressArr5);
                    } catch (SendFailedException e6) {
                        if (messagingException == null) {
                            messagingException = e6;
                        } else {
                            messagingException.setNextException(e6);
                        }
                        Address[] invalidAddresses = e6.getInvalidAddresses();
                        if (invalidAddresses != null) {
                            for (Address address : invalidAddresses) {
                                vector.addElement(address);
                            }
                        }
                        Address[] validSentAddresses = e6.getValidSentAddresses();
                        if (validSentAddresses != null) {
                            for (Address address2 : validSentAddresses) {
                                vector2.addElement(address2);
                            }
                        }
                        Address[] validUnsentAddresses = e6.getValidUnsentAddresses();
                        if (validUnsentAddresses != null) {
                            for (Address address3 : validUnsentAddresses) {
                                vector3.addElement(address3);
                            }
                        }
                        transport.close();
                        z5 = true;
                    } catch (MessagingException e7) {
                        if (messagingException == null) {
                            messagingException = e7;
                        } else {
                            messagingException.setNextException(e7);
                        }
                        transport.close();
                        z5 = true;
                    }
                } finally {
                }
            }
        }
        if (!z5 && vector.size() == 0 && vector3.size() == 0) {
            return;
        }
        if (vector2.size() > 0) {
            Address[] addressArr6 = new Address[vector2.size()];
            vector2.copyInto(addressArr6);
            addressArr2 = addressArr6;
        } else {
            addressArr2 = null;
        }
        if (vector3.size() > 0) {
            Address[] addressArr7 = new Address[vector3.size()];
            vector3.copyInto(addressArr7);
            addressArr3 = addressArr7;
        } else {
            addressArr3 = null;
        }
        if (vector.size() > 0) {
            addressArr4 = new Address[vector.size()];
            vector.copyInto(addressArr4);
        }
        throw new SendFailedException("Sending failed", messagingException, addressArr2, addressArr3, addressArr4);
    }

    protected void notifyTransportListeners(int i6, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        if (this.transportListeners == null) {
            return;
        }
        queueEvent(new TransportEvent(this, i6, addressArr, addressArr2, addressArr3, message), this.transportListeners);
    }

    public Transport(Session session, URLName uRLName) {
        super(session, uRLName);
        this.transportListeners = null;
    }

    public static void send(Message message, Address[] addressArr) throws MessagingException {
        message.saveChanges();
        send0(message, addressArr);
    }
}
