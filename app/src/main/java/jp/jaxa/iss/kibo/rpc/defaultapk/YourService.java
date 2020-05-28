package jp.jaxa.iss.kibo.rpc.defaultapk;

import android.graphics.Bitmap;

import gov.nasa.arc.astrobee.android.gs.MessageType;
import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;
import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;

/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {



    @Override
    protected void runPlan1(){
        // write here your plan 1

        api.judgeSendStart();

        // move Robot from the starting point to P1-1
        Point point = new Point(11.5, -5.7, 4.5);
        Quaternion quaternion = new Quaternion(0,0,0,1);
        api.moveTo(point, quaternion, true);
        Bitmap snapshot = api.getBitmapNavCam();
        String valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        String markerId = snapshot.toString();
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

        // move Robot from the starting point to P1-2
        point = new Point(11,-6,5.55);
        quaternion = new Quaternion(0.0f,-0.7071068f,0.0f,0.7071068f);
        api.moveTo(point, quaternion, true);
        snapshot = api.getBitmapNavCam();
        valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        markerId = snapshot.toString();
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

        // move Robot from the starting point to P1-3
        point = new Point(11, -5.5, 4.33);
        quaternion = new Quaternion(0,0,1,0);
        api.moveTo(point, quaternion, true);
        snapshot = api.getBitmapNavCam();
        valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        markerId = snapshot.toString();
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

        // move Robot from the starting point to P2-1
        point = new Point(11.5,-8,5);
        quaternion = new Quaternion(0,0,0,1);
        api.moveTo(point, quaternion, true);
        snapshot = api.getBitmapNavCam();
        valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        markerId = snapshot.toString();
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);


        // move Robot from the starting point to P2-2
        point = new Point(11,-7.7,5.55);
        quaternion = new Quaternion(4.4f, -5.5f, 6.6f, -7.7f);
        api.moveTo(point, quaternion, true);
        snapshot = api.getBitmapNavCam();
        valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        markerId = snapshot.toString();
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

        // move Robot from the starting point to P2-3
        point = new Point(1.1, -2.2, 3.3);
        quaternion = new Quaternion(0.0f,-0.7071068f,0.0f,0.7071068f);
        api.moveTo(point, quaternion, true);
        snapshot = api.getBitmapNavCam();
        valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        api.laserControl(true);
        markerId = snapshot.toString();
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);



    }

    @Override
    public void sendData(MessageType type, String topic,String data) {
        super.sendData(type, topic, data);
    }

}

