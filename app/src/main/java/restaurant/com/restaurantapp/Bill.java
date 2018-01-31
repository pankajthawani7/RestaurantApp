package restaurant.com.restaurantapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Bill extends AppCompatActivity {
    int qtp=0,qtm=0,qtn=0,qtbr=0,qtbu=0;
    Button bcancel,bproceed;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        bcancel=findViewById(R.id.cancelb);
        t1=findViewById(R.id.displaybill);
        bcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Bill.this,OrderFood.class);
                startActivity(i);
            }
        });
        bproceed=findViewById(R.id.proceedb);
        bproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Bill.this,Last.class);
                startActivity(i);
            }
        });
        Intent intent = getIntent();
        ArrayList <String> arrayList = intent.getStringArrayListExtra("quantity");
        ArrayList <String> priceArray=intent.getStringArrayListExtra("price");
        ArrayList<String> name=new ArrayList<>();
        name.add("Pizza");
        name.add("Momos");
        name.add("Noodles");
        name.add("Brownies");
        name.add("Burger");
        qtp=Integer.parseInt(arrayList.get(0));
        qtm=Integer.parseInt(arrayList.get(1));
        qtn=Integer.parseInt(arrayList.get(2));
        qtbr=Integer.parseInt(arrayList.get(3));
        qtbu=Integer.parseInt(arrayList.get(4));

        StringBuilder sb=new StringBuilder();
        sb.append("Item"+"      "+"Qty"+"       "+"Price"+"\n\n");
        for(int i=0;i<5;i++)
        {
            if(Integer.parseInt(arrayList.get(i))!=0)
            {
                sb.append(name.get(i) +"        "+arrayList.get(i)+"        "+priceArray.get(i));
                sb.append("\n");

            }
        }
        sb.append("\n");
        sb.append("Total Bill:"+"        "+OrderFood.billsum);
        t1.setText(sb);
    }
}
