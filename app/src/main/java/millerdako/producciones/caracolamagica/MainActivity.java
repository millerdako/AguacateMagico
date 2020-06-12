package millerdako.producciones.caracolamagica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button askButton;
        askButton = (Button) findViewById(R.id.askButton);

        final ImageView ballDisplay = (ImageView) findViewById(R.id.image_eightBall);




        final int[] ballArray = {
                R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5
        };

        final int[] songArray = {
                R.raw.preguntanuevamente,
                R.raw.negativo,
                R.raw.afirmativo,
                R.raw.nose,
                R.raw.claroquesi
        };


        askButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Log.d("magicBall","Boton Pregunta presionado!");
                Random randomNumberGenerator = new Random();
                int number = randomNumberGenerator.nextInt(5);
                ballDisplay.setImageResource(ballArray[number]);

                if(mp !=null){
                    mp.release();
                }

                mp = MediaPlayer.create( MainActivity.this, songArray[number]);
                mp.start();
            }
        });
    }
}
