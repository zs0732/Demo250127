package com.example.demo250127;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demo250127.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder button1,button2,button3,button4,button5;
    public View backgroundLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        backgroundLayout = findViewById(R.id.backgroundLayout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });
    }

    private void changeColor() {
        Random random = new Random();
        int randomNum = random.nextInt(5) + 1; // יצירת מספר בין 1 ל-5

        // שינוי צבע הרקע בהתאם למספר הרנדומלי
        if (randomNum == 1) {
            backgroundLayout.setBackgroundColor(Color.GREEN); // צבע ירוק
        } else if (randomNum == 2) {
            backgroundLayout.setBackgroundColor(Color.RED); // צבע אדום
        } else if (randomNum == 3) {
            backgroundLayout.setBackgroundColor(Color.BLUE); // צבע כחול
        } else if (randomNum == 4) {
            backgroundLayout.setBackgroundColor(Color.GRAY); // צבע אפור
        } else if (randomNum == 5) {
            backgroundLayout.setBackgroundColor(Color.YELLOW); // צבע צהוב
        }
    }



    public void Message(View view) {
        button1=new AlertDialog.Builder(this);
        button1.setTitle("Example");
        button1.setMessage("ziv hamalca");
        AlertDialog mg=button1.create();
        mg.show();
    }


    public void Message2(View view) {
        button2=new AlertDialog.Builder(this);
        button2.setTitle("Example2");
        button2.setMessage("Albert hamelech");
        button2.setIcon(R.drawable.ziv);
        AlertDialog mg2=button2.create();
        mg2.show();
    }

    public void Message3(View view) {
        button3=new AlertDialog.Builder(this);
        button3.setTitle("Example3");
        button3.setMessage("enter the button");
        button3.setIcon(R.drawable.ziv);
        button3.setCancelable(false);
        button3.setPositiveButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }

        });
        AlertDialog mg3=button3.create();
        mg3.show();
    }

    public void Message4(View view) {
        button4 = new AlertDialog.Builder(this);
        button4.setTitle("Example4");
        button4.setMessage("To change background color and close");
        button4.setIcon(R.drawable.ziv);
        button4.setCancelable(false);

        // הוספת הכפתורים
        button4.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // סוגר את תיבת הדיאלוג
            }
        });

        button4.setNeutralButton("Change Color", null); // לא סוגר את הדיאלוג אוטומטית

        // יצירת הדיאלוג
        AlertDialog mg4 = button4.create();

        // הוספת מאזין ידני לכפתור Change Color
        mg4.setOnShowListener(dialog -> {
            // השג את כפתור Change Color
            mg4.getButton(AlertDialog.BUTTON_NEUTRAL).setOnClickListener(v -> {
                changeColor(); // קריאה לפונקציה לשינוי הצבע
            });
        });

        mg4.show();
    }

    public void Message5(View view) {
        button5 = new AlertDialog.Builder(this);
        button5.setTitle("Example5");
        button5.setMessage("To change background color, reset to white, or close");
        button5.setIcon(R.drawable.ziv);
        button5.setCancelable(false);

        button5.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        button5.setNeutralButton("change color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                changeColor();
            }
        });

        button5.setPositiveButton("reset to white", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                backgroundLayout.setBackgroundColor(Color.WHITE);
            }
        });

        AlertDialog mg5 = button5.create();
        mg5.show();
    }

}