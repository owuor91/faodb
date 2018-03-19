package io.github.owuor91.faodb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by johnowuor on 19/03/2018.
 */

public class NetworkUtil {
  private Context context;

  public NetworkUtil(Context context) {
    this.context = context;
  }

  public boolean isNetworkConnected() {
    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    return networkInfo !=null && networkInfo.isConnected();
  }
}
