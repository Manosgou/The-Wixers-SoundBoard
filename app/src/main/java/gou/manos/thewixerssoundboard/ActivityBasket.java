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



import static gou.manos.thewixerssoundboard.R.id.basket_image_view;

public class ActivityBasket extends AppCompatActivity {
    /********************************MEDIAPLAYER*********************************/
    final MediaPlayer mediaPlayer = new MediaPlayer();
    /********************************MEDIAPLAYER*********************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        /********************************IMAGE-VIEW*********************************/
        final ImageView iv = (ImageView)findViewById(basket_image_view);
        iv.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), R.drawable.fanis_basket, 200, 200));


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.fanis_basket, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;;
        /********************************IMAGE-VIEW*********************************/
        /********************************BACK-BUTTON*********************************/
        ImageButton back = (ImageButton)findViewById(R.id.back_bar_button);
        back.setOnClickListener(new View.OnClickListener()
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
        Button epeidi_einai_vlakas = (Button) findViewById(R.id.button9);
        epeidi_einai_vlakas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.epeidi_einai_vlakas, mediaPlayer);
            }
        });

        Button gelio_fani = (Button) findViewById(R.id.button10);
        gelio_fani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.gelio_fanis, mediaPlayer);
            }
        });

        Button monos_sou = (Button) findViewById(R.id.button13);
        monos_sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.monos_sou, mediaPlayer);
            }
        });

        Button op_ston_pato_sou = (Button) findViewById(R.id.button14);
        op_ston_pato_sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.op_ston_pato_sou, mediaPlayer);
            }
        });

        Button poutana_kai_malaka = (Button) findViewById(R.id.button15);
        poutana_kai_malaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.poutana_kai_malaka_na_peite_tis_manades_sas, mediaPlayer);
            }
        });

        Button re_malakismena = (Button) findViewById(R.id.button24);
        re_malakismena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.re_malakismena, mediaPlayer);
            }
        });

        Button ton_exete_gamisei = (Button) findViewById(R.id.button25);
        ton_exete_gamisei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.ton_exete_gamisei, mediaPlayer);
            }
        });

        Button vlamenous_vlamenous = (Button) findViewById(R.id.button32);
        vlamenous_vlamenous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.vlamenos, mediaPlayer);
            }
        });

        Button to_basket_thelei_kinisi= (Button) findViewById(R.id.button33);
        to_basket_thelei_kinisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.to_mpasket_thelei_kinisi, mediaPlayer);
            }
        });

        Button emeis_gamousame_stin_ilikia_sou= (Button) findViewById(R.id.button46);
        emeis_gamousame_stin_ilikia_sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.emeis_gamousame, mediaPlayer);
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
