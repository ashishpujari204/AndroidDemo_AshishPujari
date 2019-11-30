package util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import com.app.androiddemo_ashishpujari.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Base activity class that changes the app window's color based on the current hour.
 */
public abstract class BaseActivity extends AppCompatActivity {

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    protected void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void startProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading....");
        progressDialog.show();
    }

    protected void startProgressDialog(String msg) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    protected void stopProgressDialog() {
        progressDialog.dismiss();
    }

    protected void showAlert(String message, String textMessage) {
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle(getString(R.string.app_name));
        alertBuilder.setMessage(message);
        alertBuilder.setCancelable(false);
        alertBuilder.setPositiveButton(textMessage, (dialogInterface, i) -> dialogInterface.dismiss()).create().show();

    }

    protected void showAlert(String message, String textMessage, ConfirmationDialogClickListeners listeners) {
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle(getString(R.string.app_name));
        alertBuilder.setMessage(message);
        alertBuilder.setCancelable(false);
        alertBuilder.setPositiveButton(textMessage, (dialogInterface, i) -> {
            if (listeners != null) {
                listeners.onPositiveButtonClick(dialogInterface);
            } else {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /**
     * @param message Text to show as message on confirmation dialog
     * @param positiveButtonText Text to be set as positive button
     * @param negativeButtonText Text to be set as negative button
     * @param buttonClickListeners to handle button clicks
     */
    protected void showConfirmationDialog(int title,String message, int positiveButtonText, int negativeButtonText, ConfirmationDialogClickListeners buttonClickListeners) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        if(title!=0)
            alertBuilder.setTitle(title);
        alertBuilder.setMessage(message);
        alertBuilder.setCancelable(false);
        alertBuilder.setPositiveButton(positiveButtonText, (dialog, which) -> {
        });
        alertBuilder.setNegativeButton(negativeButtonText, (dialog, which) -> {
        });

        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.setOnShowListener(dialog -> {
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> buttonClickListeners.onPositiveButtonClick(dialog));
            alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(v -> buttonClickListeners.onNegativeButtonClick(dialog));
        });
        alertDialog.show();
    }

    protected interface ConfirmationDialogClickListeners {
        void onPositiveButtonClick(DialogInterface dialogInterface);

        void onNegativeButtonClick(DialogInterface dialogInterface);
    }

}
