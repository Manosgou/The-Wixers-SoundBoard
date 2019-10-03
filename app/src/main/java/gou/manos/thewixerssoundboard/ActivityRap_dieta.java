package gou.manos.thewixerssoundboard;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

public class ActivityRap_dieta extends AppCompatActivity {
    /********************************MEDIAPLAYER*********************************/
    final MediaPlayer mediaPlayer = new MediaPlayer();
    /********************************MEDIAPLAYER*********************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rap_dieta);
        /********************************IMAGE-VIEW*********************************/
        final ImageView iv = (ImageView)findViewById(R.id.dieta_rap_image_view);
        iv.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), R.drawable.nikos_dieta, 200, 200));


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.nikos_dieta, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;;
/********************************IMAGE-VIEW*********************************/
/********************************BACK-BUTTON*********************************/
        ImageButton Bar = (ImageButton)findViewById(R.id.back_bar_button);
        Bar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.stop();
                finish();

            }
        });
/********************************BACK-BUTTON*********************************/
/********************************PLAY-BUTTONS*********************************/
        Button dieta_olo_auto = (Button) findViewById(R.id.button51);
        dieta_olo_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.dieta_olo_afto, mediaPlayer);
            }
        });

        Button ti_vyzia = (Button) findViewById(R.id.button50);
        ti_vyzia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.ti_vyzia, mediaPlayer);
            }
        });

        Button pios_to_eipe_auto = (Button) findViewById(R.id.button52);
        pios_to_eipe_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.pios_to_eipe_auto, mediaPlayer);
            }
        });

        Button ante_kai_gamisou_re_malaka = (Button) findViewById(R.id.button53);
        ante_kai_gamisou_re_malaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.ante_kai_gamisou_re_malaka, mediaPlayer);
            }
        });
/********************************PLAY-BUTTONS*********************************/
/********************************STOP-BUTTON*********************************/
        Button stop = (Button) findViewById(R.id.stop_button);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()) {

                    mediaPlayer.stop();
                }
            }
        });

/********************************STOP-BUTTON*********************************/
    }
    /********************************IMAGE-VIEW*********************************/
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    /********************************IMAGE-VIEW*********************************/
    /********************************MEDIAPLAYER*********************************/
    private void stopAndPlay(int rawId, MediaPlayer mediaPlayer) {
        mediaPlayer.reset();
        AssetFileDescriptor afd = this.getResources().openRawResourceFd(rawId);
        try {
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }
/********************************MEDIAPLAYER*********************************/
    /********************************BACK-BUTTON*********************************/
    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        finish();

    }

/********************************BACK-BUTTON*********************************/
}
