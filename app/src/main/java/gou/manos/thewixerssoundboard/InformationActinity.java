package gou.manos.thewixerssoundboard;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import static gou.manos.thewixerssoundboard.splashScreen.decodeSampledBitmapFromResource;

public class InformationActinity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_actinity);

/********************************BACK-BUTTON*********************************/
        ImageButton Bar = (ImageButton)findViewById(R.id.back_bar_button);
        Bar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();

            }
        });
/********************************BACK-BUTTON*********************************/



    }





}
