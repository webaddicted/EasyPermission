package com.deepaksharma.webaddicted.checkpermission;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.deepaksharma.webaddicted.easypermission.EasyPermissions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deepak Sharma
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<String> multiplePermission = new ArrayList<>();
    private String singlePermission = Manifest.permission.CAMERA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        multiplePermission.add(Manifest.permission.CAMERA);
        multiplePermission.add(Manifest.permission.READ_PHONE_STATE);
        multiplePermission.add(Manifest.permission.ACCESS_WIFI_STATE);
        multiplePermission.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        multiplePermission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        findViewById(R.id.btn_checkCameraPermission).setOnClickListener(this);
        findViewById(R.id.btn_checkMultiplePermission).setOnClickListener(this);
        findViewById(R.id.btn_requestCameraPermission).setOnClickListener(this);
        findViewById(R.id.btn_requestMultiplePermission).setOnClickListener(this);
    }


    private void isSinglePermissionGranted() {
        if (EasyPermissions.checkPermission(MainActivity.this, singlePermission))
            showToast("Permission granted.");
        else
            showToast("Permission not granted.");

    }

    private void isMultiplePermissionGranted() {
        if (EasyPermissions.checkMultiplePermission(MainActivity.this, multiplePermission))
            showToast("Permission granted.");
        else
            showToast("Permission not granted.");
    }

    private void requestSinglePermission() {
        EasyPermissions.checkAndRequestPermission(MainActivity.this, singlePermission, new EasyPermissions.PermissionListener() {
            @Override
            public void onPermissionGranted(List<String> mCustomPermission) {
                Toast.makeText(MainActivity.this, "Permission granted.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> mCustomPermission) {
                Toast.makeText(MainActivity.this, "Permission denied.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void requestMultplePermission() {
        EasyPermissions.checkAndRequestPermission(MainActivity.this, multiplePermission, new EasyPermissions.PermissionListener() {
            @Override
            public void onPermissionGranted(List<String> mCustomPermission) {
                Toast.makeText(MainActivity.this, "Permission granted.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> mCustomPermission) {
                Toast.makeText(MainActivity.this, "Permission denied.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_checkCameraPermission:
                isSinglePermissionGranted();
                break;
            case R.id.btn_checkMultiplePermission:
                isMultiplePermissionGranted();
                break;
            case R.id.btn_requestCameraPermission:
                requestSinglePermission();
                break;
            case R.id.btn_requestMultiplePermission:
                requestMultplePermission();
                break;

        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
