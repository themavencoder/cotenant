package com.getmobileltd.cotenant.profile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

import com.getmobileltd.cotenant.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static okhttp3.internal.Internal.instance;

public class TakePicture extends AppCompatActivity implements SurfaceHolder.Callback{
    private ImageView iv_image;
    //a variable to store a reference to the Surface View at the main.xml file
    private SurfaceView sv;
    //a bitmap to display the captured image
    private Bitmap bmp;
    //Camera variables
//a surface holder
    private SurfaceHolder sHolder;
    //a variable to control the camera
    private Camera mCamera;
    //the camera parameters
    private Camera.Parameters parameters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        iv_image = (ImageView) findViewById(R.id.imageView);
//get the Surface View at the main.xml file
        sv = (SurfaceView) findViewById(R.id.surfaceView);
//Get a surface
        sHolder = sv.getHolder();
//add the callback interface methods defined below as the Surface View callbacks
        sHolder.addCallback(this);
//tells Android that this surface will have its data constantly replaced
        sHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        // The Surface has been created, acquire the camera and tell it where
// to draw the preview.
        mCamera = Camera.open();
        try {
            mCamera.setPreviewDisplay(surfaceHolder);
        } catch (IOException exception) {
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
//get camera parameters
        parameters = mCamera.getParameters();
//set camera parameters
        mCamera.setParameters(parameters);
        mCamera.startPreview();
//sets what code should be executed after the picture is taken
        Camera.PictureCallback mCall = new Camera.PictureCallback()
        {
            @Override
            public void onPictureTaken(byte[] data, Camera camera)
            {
//decode the data obtained by the camera into a Bitmap
                bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                String filename=Environment.getExternalStorageDirectory()
                        + File.separator + "testimage.jpg";
                FileOutputStream out = null;
                try {
                    out = new FileOutputStream(filename);
                    bmp.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap
// PNG is a lossless format, the compression factor (100) is ignored
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//set the iv_image
                iv_image.setImageBitmap(bmp);
            }
        };
        mCamera.takePicture(null, null, mCall);

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
//stop the preview
        mCamera.stopPreview();
//release the camera
        mCamera.release();
//unbind the camera from this object
        mCamera = null;
    }
}
