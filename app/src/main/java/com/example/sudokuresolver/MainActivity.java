package com.example.sudokuresolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConfirmClick(View view) {
        EditText numberOneOne = findViewById(R.id.OneOne);
        EditText numberTwoOne = findViewById(R.id.TwoOne);
        EditText numberThreeOne = findViewById(R.id.ThreeOne);
        EditText numberFourOne = findViewById(R.id.FourOne);
        EditText numberFiveOne = findViewById(R.id.FiveOne);
        EditText numberSixOne = findViewById(R.id.SixOne);
        EditText numberSevenOne = findViewById(R.id.SevenOne);
        EditText numberEightOne = findViewById(R.id.EightOne);
        EditText numberNineOne = findViewById(R.id.NineOne);

        EditText numberOneTwo = findViewById(R.id.OneTwo);
        EditText numberTwoTwo = findViewById(R.id.TwoTwo);
        EditText numberThreeTwo = findViewById(R.id.ThreeTwo);
        EditText numberFourTwo = findViewById(R.id.FourTwo);
        EditText numberFiveTwo = findViewById(R.id.FiveTwo);
        EditText numberSixTwo = findViewById(R.id.SixTwo);
        EditText numberSevenTwo = findViewById(R.id.SevenTwo);
        EditText numberEightTwo = findViewById(R.id.EightTwo);
        EditText numberNineTwo = findViewById(R.id.NineTwo);

        EditText numberOneThree = findViewById(R.id.OneThree);
        EditText numberTwoThree = findViewById(R.id.TwoThree);
        EditText numberThreeThree = findViewById(R.id.ThreeThree);
        EditText numberFourThree = findViewById(R.id.FourThree);
        EditText numberFiveThree = findViewById(R.id.FiveThree);
        EditText numberSixThree = findViewById(R.id.SixThree);
        EditText numberSevenThree = findViewById(R.id.SevenThree);
        EditText numberEightThree = findViewById(R.id.EightThree);
        EditText numberNineThree = findViewById(R.id.NineThree);

        EditText numberOneFour = findViewById(R.id.OneFour);
        EditText numberTwoFour = findViewById(R.id.TwoFour);
        EditText numberThreeFour = findViewById(R.id.ThreeFour);
        EditText numberFourFour = findViewById(R.id.FourFour);
        EditText numberFiveFour = findViewById(R.id.FiveFour);
        EditText numberSixFour = findViewById(R.id.SixFour);
        EditText numberSevenFour = findViewById(R.id.SevenFour);
        EditText numberEightFour = findViewById(R.id.EightFour);
        EditText numberNineFour = findViewById(R.id.NineFour);

        EditText numberOneFive = findViewById(R.id.OneFive);
        EditText numberTwoFive = findViewById(R.id.TwoFive);
        EditText numberThreeFive = findViewById(R.id.ThreeFive);
        EditText numberFourFive = findViewById(R.id.FourFive);
        EditText numberFiveFive = findViewById(R.id.FiveFive);
        EditText numberSixFive = findViewById(R.id.SixFive);
        EditText numberSevenFive = findViewById(R.id.SevenFive);
        EditText numberEightFive = findViewById(R.id.EightFive);
        EditText numberNineFive = findViewById(R.id.NineFive);

        EditText numberOneSix = findViewById(R.id.OneSix);
        EditText numberTwoSix = findViewById(R.id.TwoSix);
        EditText numberThreeSix = findViewById(R.id.ThreeSix);
        EditText numberFourSix = findViewById(R.id.FourSix);
        EditText numberFiveSix = findViewById(R.id.FiveSix);
        EditText numberSixSix = findViewById(R.id.SixSix);
        EditText numberSevenSix = findViewById(R.id.SevenSix);
        EditText numberEightSix = findViewById(R.id.EightSix);
        EditText numberNineSix = findViewById(R.id.NineSix);

        EditText numberOneSeven = findViewById(R.id.OneSeven);
        EditText numberTwoSeven = findViewById(R.id.TwoSeven);
        EditText numberThreeSeven = findViewById(R.id.ThreeSeven);
        EditText numberFourSeven = findViewById(R.id.FourSeven);
        EditText numberFiveSeven = findViewById(R.id.FiveSeven);
        EditText numberSixSeven = findViewById(R.id.SixSeven);
        EditText numberSevenSeven = findViewById(R.id.SevenSeven);
        EditText numberEightSeven = findViewById(R.id.EightSeven);
        EditText numberNineSeven = findViewById(R.id.NineSeven);

        EditText numberOneEight = findViewById(R.id.OneEight);
        EditText numberTwoEight = findViewById(R.id.TwoEight);
        EditText numberThreeEight = findViewById(R.id.ThreeEight);
        EditText numberFourEight = findViewById(R.id.FourEight);
        EditText numberFiveEight = findViewById(R.id.FiveEight);
        EditText numberSixEight = findViewById(R.id.SixEight);
        EditText numberSevenEight = findViewById(R.id.SevenEight);
        EditText numberEightEight = findViewById(R.id.EightEight);
        EditText numberNineEight = findViewById(R.id.NineEight);

        EditText numberOneNine = findViewById(R.id.OneNine);
        EditText numberTwoNine = findViewById(R.id.TwoNine);
        EditText numberThreeNine = findViewById(R.id.ThreeNine);
        EditText numberFourNine = findViewById(R.id.FourNine);
        EditText numberFiveNine = findViewById(R.id.FiveNine);
        EditText numberSixNine = findViewById(R.id.SixNine);
        EditText numberSevenNine = findViewById(R.id.SevenNine);
        EditText numberEightNine = findViewById(R.id.EightNine);
        EditText numberNineNine = findViewById(R.id.NineNine);

        TextView txtView = findViewById(R.id.Test12);
        txtView.setText(numberOneOne.getText());
    }
}