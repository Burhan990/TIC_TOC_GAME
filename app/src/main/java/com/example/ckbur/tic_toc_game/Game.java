package com.example.ckbur.tic_toc_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Game extends AppCompatActivity {


    int activePlayer=0;//0 is for red
    int[] gamestate ={2,2,2,2,2,2,2,2,2};//2 means unplayed
    int[][] winningLocations = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    boolean gameOver =false;
    public void gameLogic(View view) {
        ImageView tappedView = (ImageView) view;

        int tappedLocation = Integer.parseInt(view.getTag().toString());
        if (gamestate[tappedLocation] == 2 && !gameOver) {
            gamestate[tappedLocation] = activePlayer;

            tappedView.setTranslationY(-3000f);

            if (activePlayer == 0) {

                tappedView.setImageResource(R.drawable.white);
                activePlayer = 1;
            } else if (activePlayer == 1) {

                tappedView.setImageResource(R.drawable.black);
                activePlayer = 0;
            }
            tappedView.animate().translationYBy(3000f).setDuration(500);


            String msg = "";


            for (int[] winningPosition : winningLocations) {

                if (gamestate[winningPosition[0]] == gamestate[winningPosition[1]] && gamestate[winningPosition[1]] == gamestate[winningPosition[2]] && gamestate[winningPosition[0]] != 2) {

                    if (activePlayer == 0)
                        msg = "Circle is winner";

                    if (activePlayer == 1)
                        msg = "Cross is winner";


                    LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
                    winnerLayout.setVisibility(View.VISIBLE);
                    TextView winnermsg = (TextView) findViewById(R.id.textView);
                    winnermsg.setText(msg);

                    gameOver = true;

                }

            }


        }

    }




    public void playAgain(View view){
        LinearLayout winnerLayout = (LinearLayout)findViewById(R.id.winnerLayout);
        winnerLayout.setVisibility(View.INVISIBLE);

        gameOver=false;
        activePlayer=0;

        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }

        GridLayout gridLayout =(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0;i<gridLayout.getChildCount();i++){
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }
    }
    public void reMatch(View v){
        gameOver=false;
        activePlayer=0;

        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        GridLayout gridLayout =(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0;i<gridLayout.getChildCount();i++){
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


       LinearLayout winnerLayout =(LinearLayout)findViewById(R.id.winnerLayout);
       winnerLayout.setVisibility(View.INVISIBLE);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
