package au.edu.jcu.quiz_test;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Gyroscope {

    public interface Listener{ // Create a display interface.

        void onRotation(float x, float y, float z); // Create a function to measure the rotation of the phone.

    }

    private Listener listener;

    public void setListener(Listener l){

        listener = l; // Create an instance of the listener.

    }

    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;

    Gyroscope(Context context){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE); // Create a sensor manager to control the functionality of the sensor.
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION); // Instantiate the sensor.
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) { // Check when the sensor starts working.

                if(listener != null)
                    listener.onRotation(event.values[0], event.values[1], event.values[2]); // Measure the rotation of the phone with the given coordinates.

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    public void sensorRegister(){

        sensorManager.registerListener(sensorEventListener, sensor, sensorManager.SENSOR_DELAY_NORMAL); // Start the functionality of the Gyroscope.

    }

    public void sensorUnregister(){

        sensorManager.unregisterListener(sensorEventListener); // End the functionality of the Gyroscope.

    }

}
