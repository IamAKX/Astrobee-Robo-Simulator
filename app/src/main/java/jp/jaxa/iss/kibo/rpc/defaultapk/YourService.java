package jp.jaxa.iss.kibo.rpc.defaultapk;

import android.graphics.Bitmap;

import org.opencv.core.Mat;

import java.util.HashMap;

import gov.nasa.arc.astrobee.android.gs.MessageType;
import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;
import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;
import jp.jaxa.iss.kibo.rpc.api.types.PointCloud;

/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    HashMap<String, Point> KMinMap = new HashMap<>();
    HashMap<String, Point> KMaxMap = new HashMap<>();


    @Override
    protected void runPlan1(){
        // write here your plan 1

        api.judgeSendStart();

        // move Robot from the starting point to P1-1
        Point point = new Point(11.5, -5.7, 4.5);
        Quaternion quaternion = new Quaternion(0,0,0,1);
        point = checkKIZ(point, new Point(10.75,-4.9,4.8), new Point(10.95,-4.7,5.0));
        api.moveTo(point, quaternion, true);
        Bitmap snapshot = api.getBitmapNavCam();
        String valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        String markerId = snapshot.toString();
        api.judgeSendDiscoveredAR(markerId);
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

        // move Robot from the P1-1 to P1-2
        point = new Point(11,-6,5.55);
        quaternion = new Quaternion(0.0f,-0.7071068f,0.0f,0.7071068f);
        api.moveTo(point, quaternion, true);
        snapshot = api.getBitmapNavCam();
        valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        markerId = snapshot.toString();
        api.judgeSendDiscoveredAR(markerId);
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

        // move Robot from the P1-2 to P1-3
        point = new Point(11, -5.5, 4.33);
        quaternion = new Quaternion(0.0f,0.7071068f,0.0f,0.7071068f);
        api.moveTo(point, quaternion, true);
        snapshot = api.getBitmapNavCam();
        valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        markerId = snapshot.toString();
        api.judgeSendDiscoveredAR(markerId);
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

        // move Robot from the P1-3 to P2-1
        point = new Point(10.30,-7.5,4.7);
        quaternion = new Quaternion(0,0,1,0);
        api.moveTo(point, quaternion, true);
        snapshot = api.getBitmapNavCam();
        valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        markerId = snapshot.toString();
        api.judgeSendDiscoveredAR(markerId);
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);


        // move Robot from the P2-1 to P2-2
        point = new Point(11.5,-8,5);
        quaternion = new Quaternion(0,0,0,1);
        api.moveTo(point, quaternion, true);
        snapshot = api.getBitmapNavCam();
        valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        markerId = snapshot.toString();
        api.judgeSendDiscoveredAR(markerId);
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

        // move Robot from the P2-2 to P2-3
        point = new Point(11, -7.7, 5.55);
        quaternion = new Quaternion(0.0f,-0.7071068f,0.0f,0.7071068f);
        api.moveTo(point, quaternion, true);
        snapshot = api.getBitmapNavCam();
        valueX = String.valueOf(point.getX());
        api.judgeSendDiscoveredQR(0, valueX);
        markerId = snapshot.toString();
        api.judgeSendDiscoveredAR(markerId);
        sendData(MessageType.JSON, "data", "SUCCESS:defaultapk "+markerId);

        Mat navCam = api.getMatNavCam();
        PointCloud pointCloudHazCam = api.getPointCloudHazCam();


        api.laserControl(true);
        api.judgeSendFinishSimulation();

    }

    private Point checkKIZ(Point point, Point pMin, Point pMax) {
        Point p = point;
        if(point.getX() > pMin.getX() && point.getX() < pMax.getX())
        {

        }
        else
        {

        }
        return p;
    }


    @Override
    public void sendData(MessageType type, String topic,String data) {
        super.sendData(type, topic, data);
    }

}

