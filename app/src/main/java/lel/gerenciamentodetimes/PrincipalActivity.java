package lel.gerenciamentodetimes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import lel.servicos.Validacao;
import lel.dados.Time;
import java.util.ArrayList;
import lel.servicos.Cadastrar;


public class PrincipalActivity extends ActionBarActivity {

    protected ArrayList<Time> times = new ArrayList<Time>();
    private AlertDialog alerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_verRegistro:
                listarTodos(times);
                return true;
            case R.id.action_cadastrar:
                verCadastrar();
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_) {
        //    return true;
        //}

        //return super.onOptionsItemSelected(item);
    }
    public void cadastrar_click(View view){

        //TextView titulo;
        //titulo = (TextView)findViewById(R.id.t_nome);
        //titulo.setText("Funcionou");
        RadioButton nao_tem;
        RadioButton tem_estadio;
        EditText renda_t,nome_t,quantidade_t,matricula_t;
        RadioButton segunda;
        RadioButton primeira;

        nao_tem = (RadioButton) findViewById(R.id.nao_tem_estadio_rb);
        tem_estadio = (RadioButton) findViewById(R.id.tem_estadio_rb);
        renda_t = (EditText) findViewById(R.id.renda_t);
        primeira = (RadioButton)findViewById(R.id.primeira_rb);
        segunda = (RadioButton)findViewById(R.id.segunda_rb);
        matricula_t = (EditText) findViewById(R.id.matricula_t);
        nome_t = (EditText) findViewById(R.id.nome_t);
        quantidade_t = (EditText) findViewById(R.id.quantidade_t);

        if(primeira.isChecked() == true){
            String resultadoValidacao = Validacao.validaTime(nome_t.getText().toString(), matricula_t.getText().toString(),
                    quantidade_t.getText().toString(), tem_estadio.isChecked(), nao_tem.isChecked(),
                    renda_t.getText().toString(), times, true);
            if(resultadoValidacao==null){
                times.add(Cadastrar.cadastrarPrimeira(nome_t.getText().toString(),
                        matricula_t.getText().toString(),quantidade_t.getText().toString(),
                        tem_estadio.isChecked(),nao_tem.isChecked()));
                limparCampos();
                this.criarAviso("Cadastramento efetuado com sucesso!");
               // Aviso.avisoOK("Cadastramento efetuado com sucesso!");
            }else {
                this.criarAviso(resultadoValidacao);
            }
        }
        else{
            if(segunda.isChecked() == true){
                String resultadoValidacao = Validacao.validaTime(nome_t.getText().toString(),matricula_t.getText().toString(),
                        quantidade_t.getText().toString(),tem_estadio.isChecked(),
                        nao_tem.isChecked(),renda_t.getText().toString(),times,false);
                if(resultadoValidacao==null){
                    times.add(Cadastrar.cadastrarSegunda(nome_t.getText().toString(),
                            matricula_t.getText().toString(),quantidade_t.getText().toString(),
                            renda_t.getText().toString()));
                    limparCampos();
                    this.criarAviso("Cadastramento efetuado com sucesso!");
                   // Aviso.avisoOK("Cadastramento efetuado com sucesso!");
                }else {
                    this.criarAviso(resultadoValidacao);
                }
            }
        }

    }
    public void primeira_click(View view) {
        RadioButton nao_tem;
        RadioButton tem_estadio;
        TextView renda_t;
        EditText t_renda;
        RadioButton segunda;

        nao_tem = (RadioButton) findViewById(R.id.nao_tem_estadio_rb);
        nao_tem.setVisibility(View.VISIBLE);
        tem_estadio = (RadioButton) findViewById(R.id.tem_estadio_rb);
        tem_estadio.setVisibility(View.VISIBLE);
        renda_t = (TextView) findViewById(R.id.t_renda);
        renda_t.setVisibility(View.INVISIBLE);
        t_renda = (EditText) findViewById(R.id.renda_t);
        t_renda.setVisibility(View.INVISIBLE);
        segunda = (RadioButton)findViewById(R.id.segunda_rb);
        segunda.setChecked(false);
    }
    public void segunda_click(View view) {
        RadioButton nao_tem;
        RadioButton tem_estadio;
        TextView renda_t;
        EditText t_renda;
        RadioButton primeira;

        nao_tem = (RadioButton) findViewById(R.id.nao_tem_estadio_rb);
        nao_tem.setVisibility(View.INVISIBLE);
        tem_estadio = (RadioButton) findViewById(R.id.tem_estadio_rb);
        tem_estadio.setVisibility(View.INVISIBLE);
        renda_t = (TextView) findViewById(R.id.t_renda);
        renda_t.setVisibility(View.VISIBLE);
        t_renda = (EditText) findViewById(R.id.renda_t);
        t_renda.setVisibility(View.VISIBLE);
        primeira = (RadioButton)findViewById(R.id.primeira_rb);
        primeira.setChecked(false);
    }
    public void limparCampos(){
        EditText renda_t,nome_t,quantidade_t,matricula_t;
        RadioButton nao_tem;
        RadioButton tem_estadio;
        nao_tem = (RadioButton) findViewById(R.id.nao_tem_estadio_rb);
        nao_tem.setChecked(false);
        tem_estadio = (RadioButton) findViewById(R.id.tem_estadio_rb);
        tem_estadio.setChecked(false);
        renda_t = (EditText) findViewById(R.id.renda_t);
        matricula_t = (EditText) findViewById(R.id.matricula_t);
        nome_t = (EditText) findViewById(R.id.nome_t);
        quantidade_t = (EditText) findViewById(R.id.quantidade_t);
        renda_t.setText("");
        matricula_t.setText("");
        quantidade_t.setText("");
        nome_t.setText("");
    }
    public void temEstadio_click(View view) {
        RadioButton nao_tem;

        nao_tem = (RadioButton) findViewById(R.id.nao_tem_estadio_rb);
        nao_tem.setChecked(false);
    }
    public void naoTemEstadio_click(View view) {
        RadioButton tem_estadio;

        tem_estadio = (RadioButton) findViewById(R.id.tem_estadio_rb);
        tem_estadio.setChecked(false);

    }

    private void criarAviso(String frase) {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setMessage(frase);
        //define um botão como positivo

        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                // Toast.makeText(MainActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });

        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }
    private void listarTodos(ArrayList<Time> times){
        setContentView(R.layout.activity_ver_registro);
        ListView lista;
        lista = (ListView)findViewById(R.id.listView_todos);
        ArrayList<String> arrayList = new ArrayList<String>();

            if(times.size() !=0){

                for(int aux=0; aux< times.size();aux++){

                    arrayList.add(times.get(aux).toString());

                    System.out.println(times.get(aux));
                }
            }
            else {
                arrayList.add("Nao ha registros.");
            }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        lista.setAdapter(adapter);
    }
    private void verCadastrar(){
        setContentView(R.layout.activity_principal);
    }

}

