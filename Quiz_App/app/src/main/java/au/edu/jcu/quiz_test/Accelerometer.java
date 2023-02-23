package au.edu.jcu.quiz_test;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Accelerometer {

    public interface Listener{ // Create a display interface.

        void onTranslation(float x, float y, float z); // Create a function to measure the translation of the phone.

    }

    private Listener listener;

    public void setListener(Listener l){

        listener = l; // Create an instance of the listener.

    }

    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;

    Accelerometer(Context context){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE); // Create the sensor manager to control the functionality of the sensor.
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION); // Instantiate the sensor.
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) { // Check when the sensor starts functioning.

                if(listener != null)
                    listener.onTranslation(event.values[0], event.values[1], event.values[2]); // Measure the lateral translation of the phone.

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    public void sensorRegister(){

        sensorManager.registerListener(sensorEventListener, sensor, sensorManager.SENSOR_DELAY_NORMAL); // Start the functionality of the accelerometer.

    }

    public void sensorUnregister(){

        sensorManager.unregisterListener(sensorEventListener); // End the functionality of the accelerometer.

    }

}
