package restaurant.com.restaurantapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderFood extends AppCompatActivity {
    Button b1,b2,b3,b4,b5, ob,billit;
    EditText epizza , emomos, enoodles, ebrownies, eburger;
    CheckBox cpizza, cmomos, cnoodles , cbrownies, cburger;
    TextView displaytotal;
    static int billsum=0;
    int qtp=0,qtm=0,qtn=0,qtbr=0,qtbu=0;
    int ppizza=120,pmomos=30,pnoodles=60,pbrownies=80,pburger=60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_food);
        b1 = findViewById(R.id.q1);
        b2 = findViewById(R.id.q2);
        b3 = findViewById(R.id.q3);
        b4 = findViewById(R.id.q4);
        b5 = findViewById(R.id.q5);
        displaytotal=findViewById(R.id.total);
        billit = findViewById(R.id.gb);
        ob = findViewById(R.id.orderbtn);
        epizza = findViewById(R.id.pizzaedit);
        emomos = findViewById(R.id.momosedit);
        enoodles = findViewById(R.id.noodlesedit);
        ebrownies = findViewById(R.id.browniesedit);
        eburger = findViewById(R.id.burgeredit);
        epizza.setText("0");
        emomos.setText("0");
        enoodles.setText("0");
        ebrownies.setText("0");
        eburger.setText("0");
        epizza.setEnabled(false);
        emomos.setEnabled(false);
        enoodles.setEnabled(false);
        ebrownies.setEnabled(false);
        emomos.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        cpizza = findViewById(R.id.pizzack);
        cmomos = findViewById(R.id.momosck);
        cnoodles = findViewById(R.id.noodlesck);
        cbrownies = findViewById(R.id.browniesck);
        cburger = findViewById(R.id.burgerck);
        cpizza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                if(cpizza.isChecked())
             {
                 b1.setEnabled(true);
                 epizza.setEnabled(true);
                 b1.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         qtp++;
                         epizza.setText(String.valueOf(qtp));
                     }
                 });
             }
             else
             {   b1.setEnabled(false);
                 qtp=0;
                 epizza.setText("0");
                 epizza.setEnabled(false);
             }

            }}
        );
        cmomos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(cmomos.isChecked())
                {   b2.setEnabled(true);
                    emomos.setEnabled(true);
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            qtm++;
                            emomos.setText(String.valueOf(qtm));
                        }
                    });
                }
                else
                {   b2.setEnabled(false);
                    qtm=0;
                    emomos.setText("0");
                    emomos.setEnabled(false);
                }

            }}
        );
        cnoodles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(cnoodles.isChecked())
                {   b3.setEnabled(true);
                    enoodles.setEnabled(true);
                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            qtn++;
                            enoodles.setText(String.valueOf(qtn));
                        }
                    });
                }
                else
                {   b3.setEnabled(false);
                    qtn=0;
                    enoodles.setText("0");
                    enoodles.setEnabled(false);
                }

            }}
        );
        cbrownies.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(cbrownies.isChecked())
                {   b4.setEnabled(true);
                    ebrownies.setEnabled(true);
                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            qtbr++;
                            ebrownies.setText(String.valueOf(qtbr));
                        }
                    });
                }
                else
                {   b4.setEnabled(false);
                    qtbr=0;
                    ebrownies.setText("0");
                    ebrownies.setEnabled(false);
                }

            }}
        );

        cburger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(cburger.isChecked())
                {   b5.setEnabled(true);
                    eburger.setEnabled(true);
                    b5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            qtbu++;
                            eburger.setText(String.valueOf(qtbu));
                        }
                    });
                }
                else
                {
                    qtbu=0;
                    eburger.setText("0");
                    b5.setEnabled(false);
                    eburger.setEnabled(false);
                }

            }}
        );
        billit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billsum=bill();
                displaytotal.setText(String.valueOf(billsum));
            }
        });
        ob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               billit.performClick();
                call();
            }
        });
    }
    public int bill()
    {
        int totalbill=0;
        totalbill=(ppizza*qtp)+(pmomos*qtm)+(pnoodles*qtn)+(pbrownies*qtbr)+(pburger*qtbu);
        return totalbill;
    }
    public void call()
    {
        ArrayList<String> arrayList=new ArrayList<>();

        arrayList.add(String.valueOf(epizza.getText()));
        arrayList.add(String.valueOf(emomos.getText()));
        arrayList.add(String.valueOf(enoodles.getText()));
        arrayList.add(String.valueOf(ebrownies.getText()));
        arrayList.add(String.valueOf(eburger.getText()));

        ArrayList<String> price=new ArrayList<>();

        price.add(String.valueOf(ppizza*qtp));
        price.add(String.valueOf(pmomos*qtm));
        price.add(String.valueOf(pnoodles*qtn));
        price.add(String.valueOf(pbrownies*qtbr));
        price.add(String.valueOf(pburger*qtbu));

        if((qtp+qtbu+qtbr+qtn+qtm)==0)
        {
            //ob.setEnabled(false);
            Toast.makeText(this, "Please make order", Toast.LENGTH_SHORT).show();
        }
        else{
         Intent i= new Intent(OrderFood.this,Bill.class);
            i.putExtra("quantity",arrayList);
            i.putExtra("price",price);
            startActivity(i);
    }}
    }
