# EasyPermission

EasyPermission is an Android library that simplifies the process of requesting permissions at runtime.

Android Marshmallow includes a new functionality to let users grant or deny permissions when running an app instead of granting them all when installing it. This approach gives the user more control over applications but requires developers to add lots of code to support it.

If the app can no longer request permission due to "Don't ask again" on permission it will toast a message to grant permission from settings. All the action performed after grant or deny can be customized by overriding method shown below. Custom permission can be checked instead of all permission in androidmanifests file.


Android Runtime Permission Library
==================================

 * Support for "Don't ask again"
 * Short code.
 * Can request from any context (Activity, Service, Fragment, etc).
 * Can check multiple permissions at once.
 * Quick support.
 * Open source and fully customizable.

Setup:
-----
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

### Dependency

	dependencies {
	       implementation 'com.github.webaddicted:EasyPermission:0.0.1'
	}

### Single permission
    EasyPermissions.checkAndRequestPermission(MainActivity.this, Manifest.permission.CAMERA, new EasyPermissions.PermissionListener() {
                @Override
                public void onPermissionGranted(List<String> mCustomPermission) {
                    Toast.makeText(MainActivity.this, "Permission granted.", Toast.LENGTH_SHORT).show();
                }

            @Override
            public void onPermissionDenied(List<String> mCustomPermission) {
                Toast.makeText(MainActivity.this, "Permission denied.", Toast.LENGTH_SHORT).show();
            }
        });

### Multiple permission
    List<String> multiplePermission = new ArrayList<>();
            multiplePermission.add(Manifest.permission.CAMERA);
            multiplePermission.add(Manifest.permission.READ_PHONE_STATE);
            multiplePermission.add(Manifest.permission.ACCESS_WIFI_STATE);
            multiplePermission.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            multiplePermission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

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

###  onRequestPermissionsResult function

    @Override
      public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
          EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
      }

Screenshot
-----------
<img src="https://github.com/webaddicted/EasyPermission/blob/master/screenshot/home.png" width="400">   <img src="https://github.com/webaddicted/EasyPermission/blob/master/screenshot/multiple_permission.png" width="400">

<img src="https://github.com/webaddicted/EasyPermission/blob/master/screenshot/denied.png" width="400">   <img src="https://github.com/webaddicted/EasyPermission/blob/master/screenshot/setting_permission.png" width="400">



## LICENSE
```
MIT License

Copyright (c) 2020 Deepak Sharma (webaddicted)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
