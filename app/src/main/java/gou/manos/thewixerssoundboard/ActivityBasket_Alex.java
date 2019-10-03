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

public class ActivityBasket_Alex extends AppCompatActivity {
    /********************************MEDIAPLAYER*********************************/
    final MediaPlayer mediaPlayer = new MediaPlayer();
    /********************************MEDIAPLAYER*********************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket__alex);
        /********************************IMAGE-VIEW*********************************/
        final ImageView iv = (ImageView)findViewById(R.id.basket_alex_image_view);
        iv.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), R.drawable.guests_basket, 200, 200));


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.guests_basket, options);
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

        Button capoeira_xereis = (Button) findViewById(R.id.button20);
        capoeira_xereis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.capoeira_xereis, mediaPlayer);
            }
        });

        Button den_eimai_epithetikos = (Button) findViewById(R.id.button21);
        den_eimai_epithetikos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.den_eimai_epithetikos, mediaPlayer);
            }
        });

        Button den_pathenete_tipota_re = (Button) findViewById(R.id.button28);
        den_pathenete_tipota_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.den_pathenete_tipota_re, mediaPlayer);
            }
        });

        Button exo_krifo_profil = (Button) findViewById(R.id.button29);
        exo_krifo_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.exo_krifo_profil, mediaPlayer);
            }
        });

        Button fige_me_kaiei = (Button) findViewById(R.id.button30);
        fige_me_kaiei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.fige_me_kei, mediaPlayer);
            }
        });

        Button kane_me_poutana = (Button) findViewById(R.id.button31);
        kane_me_poutana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.kaneme_poutana, mediaPlayer);
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
