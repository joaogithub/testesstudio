package com.testes.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.testes.android.R;

/**
 * Created by Bold on 10/03/2016.
 */
public class PermissionActivity extends Activity {

    public static final int PERMISSIONS_REQUEST_CODE = 113;

    private Button permissionsButton;

    /**
     * opens phone camera
     */
    private void execute() {
        Snackbar.make(permissionsButton, "Executa coisas. ", Snackbar.LENGTH_LONG);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_activity);

        permissionsButton = (Button) findViewById(R.id.permissionButton);

        permissionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!needsToRequestPermission(new String[]
                                {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSIONS_REQUEST_CODE, "A app precisa destas permissões para poder usar a câmara e guardar fotos do user")) {
                    execute();
                }
            }
        });

    }

    /**
     * requests a set of permissions
     * shows rationale if it needs to
     * @param permissions the permissions array
     * @param requestCode the request code
     * @param explanation the rationale explanation
     */
    private void requestPermission(final String[] permissions, final int requestCode, String explanation) {
        // Should we show an explanation?
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                permissions[0])) {

            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            Toast.makeText(this, explanation, Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ActivityCompat.requestPermissions(PermissionActivity.this,
                            permissions,
                            requestCode);
                }
            }, 3000);

        } else {

            // No explanation needed, we can request the permission.

            ActivityCompat.requestPermissions(this,
                    permissions,
                    requestCode);

            // permission is an
            // app-defined int constant. The callback method gets the
            // result of the request.
        }
    }

    /**
     * checks if the app needs to request the permissions or not
     * requests them if it needs to
     * @param permissions the permisisons to request
     * @param requestCode the request code
     * @param explanation the explanation - rationale
     * @return true if needs to request permissions, false otherwise
     */
    protected boolean needsToRequestPermission(String[] permissions, int requestCode, String explanation) {

        if (!hasAllPermissionsGranted(permissions)) {
            requestPermission(permissions, requestCode, explanation);
            return true;
        }
        return false;

    }

    /**
     * opens setting screen
     */
    private void goToPermissionSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", getPackageName(), null));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * Checks if all the permissions in the array are granted
     *
     * @param grantPermissions an array of grantpermission to check if are granted or not
     * @return true if below Build.VERSION_CODES.M (all granted at install) or all permissions are granted,
     * false if Version equal or above M, and at least one of the permissions in not GRANTED
     */
    private boolean hasAllPermissionsGranted(int[] grantPermissions) {
        if (grantPermissions.length == 1) {
            return grantPermissions[0] == PackageManager.PERMISSION_GRANTED;
        } else {
            for (int permission : grantPermissions) {
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Checks if all the permissions in the array are granted
     *
     * @param permissions an array of permission to check if are granted or not
     * @return true if below Build.VERSION_CODES.M (all granted at install) or all permissions are granted,
     * false if Version equal or above M, and at least one of the permissions in not GRANTED
     */
    private boolean hasAllPermissionsGranted(String[] permissions) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true;
        else {
            if (permissions.length == 1) {
                return ContextCompat.checkSelfPermission(this, permissions[0])
                        == PackageManager.PERMISSION_GRANTED;
            } else {
                for (String permission : permissions) {
                    if (ContextCompat.checkSelfPermission(this, permission)
                            != PackageManager.PERMISSION_GRANTED) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {

            case PERMISSIONS_REQUEST_CODE:
                // If request is canceled, the result arrays are empty.
                if (grantResults.length > 0 && hasAllPermissionsGranted(grantResults)) {
                    execute();
                } else {
                    // permission denied
                    showPermissionWarning();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    private void showPermissionWarning() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_LIGHT);
        builder.setTitle("Permissões").setMessage("Permissões não garantidas.\nDeseja aceder às Configurações?").setPositiveButton("Configurações", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goToPermissionSettings();
            }
        }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();

    }
}
