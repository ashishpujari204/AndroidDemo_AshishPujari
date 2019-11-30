package util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.app.androiddemo_ashishpujari.R;

public class AppUtils {
    public static boolean isNetworkAvailable(Context mContext) {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isAvailable = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (!isAvailable && mContext instanceof Activity) {
            Toast.makeText(mContext, mContext.getString(R.string.no_network), Toast.LENGTH_LONG).show();
        }

        return isAvailable;
    }
}
