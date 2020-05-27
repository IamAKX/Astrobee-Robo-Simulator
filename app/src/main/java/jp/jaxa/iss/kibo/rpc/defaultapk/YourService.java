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
        Point point = new Point(1.1, -2.2, 3.3);
        Quaternion quaternion = new Quaternion(4.4f, -5.5f, 6.6f, -7.7f);
        api.moveTo(point, quaternion, true);

        Bitmap snapshot = api.getBitmapNavCam();


        String valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);

        String markerId = snapshot.toString();

        api.laserControl(true);
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

    }

    @Override
    public void sendData(MessageType type, String topic,String data) {
        super.sendData(type, topic, data);
    }

    @Override
    protected void runPlan2(){
        // write here your plan 2

        api.judgeSendStart();
        // move Robot from the starting point to P1-1
        Point point = new Point(1.1, -2.2, 3.3);
        Quaternion quaternion = new Quaternion(4.4f, -5.5f, 6.6f, -7.7f);
        api.moveTo(point, quaternion, true);

        Bitmap snapshot = api.getBitmapNavCam();


        String valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);

        String markerId = snapshot.toString();

        api.laserControl(true);
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

    }

    @Override
    protected void runPlan3(){
        // write here your plan 3

        api.judgeSendStart();
        // move Robot from the starting point to P1-1
        Point point = new Point(1.3, -2.1, 3.1);
        Quaternion quaternion = new Quaternion(4.4f, -5.5f, 6.6f, -7.7f);
        api.moveTo(point, quaternion, true);

        Bitmap snapshot = api.getBitmapNavCam();


        String valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);

        String markerId = snapshot.toString();

        api.laserControl(true);
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

    }

}

