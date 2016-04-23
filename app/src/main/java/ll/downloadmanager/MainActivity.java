package ll.downloadmanager;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String serviceString = Context.DOWNLOAD_SERVICE;
        DownloadManager downloadManager;
        downloadManager = (DownloadManager)getSystemService(serviceString);
        Uri uri = Uri.parse("http://www.js-lottery.com/PlayZone/downSevenData.html");
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setDestinationInExternalPublicDir("ll","seven.csv");
        request.allowScanningByMediaScanner();;
        request.setTitle("七位数数据文件");
       // request.setDescription("seven.csv");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);


        long reference = downloadManager.enqueue(request);
    }
}
