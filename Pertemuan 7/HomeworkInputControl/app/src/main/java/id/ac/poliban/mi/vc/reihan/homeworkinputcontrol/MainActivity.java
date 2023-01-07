package id.ac.poliban.mi.vc.reihan.homeworkinputcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb1,cb2,cb3,cb4,cb5;
    private String msj1 = "",msj2="",msj3="",msj4="",msj5="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //relacion entre la parte gráfica y logica
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        cb4 = (CheckBox)findViewById(R.id.cb4);
        cb5 = (CheckBox)findViewById(R.id.cb5);
    }


    /**
     * método para capturar y mostrar el toast
     * @param message
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onShowToast(View view) {
        String mensaje ="";

        //si el radio button fue seleccionado
        if(cb1.isChecked()){
            msj1 = cb1.getText().toString();
        }else if(cb2.isChecked()){
            msj2 =cb2.getText().toString();
        }else if(cb3.isChecked()){
            msj3 = cb3.getText().toString();
        }
        else if(cb4.isChecked()){
            msj4 = cb4.getText().toString();
        }else if(cb5.isChecked()){
            msj5 = cb5.getText().toString();
        }
        mensaje = "Topings: "+msj1 + msj2 + msj3 +msj4 + msj5;
        displayToast(mensaje);
    }

}