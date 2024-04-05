package com.example.dientesabio


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.provider.DocumentsContract
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dientesabio.controller.AdapterInicio
import com.example.dientesabio.data.InicioTemas
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import java.io.File
import java.io.FileOutputStream
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE





class Inicio : AppCompatActivity() {

    lateinit var adapterInicio: AdapterInicio
    lateinit var recycledView: RecyclerView
    private val REQUEST_CODE_WRITE_STORAGE_PERMISSION = 1001

    //para guardar los temas
    //lateinit var datosTemas: InicioTemas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        //datosTemas = intent.getParcelableExtra("datosTemas")!!
    }

    override fun onStart() {
        super.onStart()
        val layoutManager = LinearLayoutManager(this)
        recycledView = findViewById(R.id.lista_maxilar)
        recycledView.layoutManager = layoutManager
        recycledView.setHasFixedSize(true)
        adapterInicio = AdapterInicio(getTemasList())
        recycledView.adapter = adapterInicio


        adapterInicio.onItemClick= {
            val intent = Intent (this, InicioDetalle::class.java).apply{}

            intent.putExtra("datosTemas", it)
            startActivity(intent)
        }

    }
    fun getTemasList() : ArrayList<InicioTemas>{


        val temasList : ArrayList<InicioTemas> = ArrayList()

        //Acceso a la base de datos
        val admin = BaseDatosApp(this, "bd", null, 1)
        val bd = admin.writableDatabase


        val reg = bd.rawQuery("SELECT ID, NOMBRE, DESCRIPCION, IMAGEN FROM InicioTemas", null)


        var id : Int
        var nombre : String
        var descripcion : String
        var imagen : Int


        //Recorrer la BD y asignar cada registro a una variable
        if (reg.moveToFirst()){
            do {
                id = reg.getString(0).toInt()
                nombre = reg.getString(1)
                descripcion = reg.getString(2)
                imagen = reg.getString(3).toInt()

                temasList.add(InicioTemas(id, nombre, descripcion,imagen))
            } while (reg.moveToNext())
        }
        reg.close()
        return temasList
    }


    fun datos_usuario(view: View){
        val i = Intent(this,Pefil::class.java)
        startActivity(i)
    }

    fun ir_buscar(view: View){
        val i = Intent(this,Buscar::class.java)
        startActivity(i)
    }

    fun inicio(view: View){
        val i = Intent(this,Inicio::class.java)
        startActivity(i)
    }

    fun ir_guardados(view: View){
        val i = Intent(this,Guardados::class.java)
        startActivity(i)
    }
    override
    fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.PDF -> {
                checkWriteStoragePermission() // Verificar permisos antes de generar el PDF
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun generatePdf() {
        val temasList = getTemasList()
        //val directoryPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        //val file = File(directoryPath, "temas_report.pdf")
        val file = File(Environment.getExternalStorageDirectory(), "temas_report.pdf")


        try {
            val fileOutputStream = FileOutputStream(file)
            val pdfWriter = PdfWriter(fileOutputStream)
            val pdfDocument = PdfDocument(pdfWriter)

            val document = Document(pdfDocument)


            val title = Paragraph("Informe de Temas Registrados\n\n")
            document.add(title)

            for ((index, tema) in temasList.withIndex()) {
                val paragraph = Paragraph("${index + 1}. Nombre: ${tema.nombre}, Descripción: ${tema.descripcion}\n")
                document.add(paragraph)
            }

            document.close()

            Log.d("PDFGeneration", "PDF generado correctamente")
        } catch (e: Exception) {
            Log.e("PDFGeneration", "Error generando PDF", e)
        }
    }



    private fun checkWriteStoragePermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Solicitar permiso de escritura en el almacenamiento externo
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CODE_WRITE_STORAGE_PERMISSION
            )
        } else {
            // Permiso ya concedido, generar PDF
            generatePdf() // Llamar a generatePdf() después de verificar los permisos
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_WRITE_STORAGE_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, generar PDF
                generatePdf()
            } else {
                // Permiso denegado, manejar el caso en consecuencia (por ejemplo, mostrar un mensaje al usuario)
                Toast.makeText(
                    this,
                    "Permiso de escritura en el almacenamiento externo denegado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }



}



