using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practica2_201220165
{
    public partial class Default : System.Web.UI.Page
    {
        static bool abierto = false;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack)
            {
                this.form1.Attributes.Add("autocomplete", "off");
                if (FileUpload1.HasFile || FileUpload1.PostedFile.FileName != "")
                {
                    String ext = System.IO.Path.GetExtension(FileUpload1.PostedFile.FileName).ToLower();
                    if (ext == ".matt")
                    {
                        this.panelcontenido.Visible = true;
                    }
                }
            }
        }

        protected void btnSubir_Click(object sender, EventArgs e)
        {
            if (FileUpload1.HasFile || FileUpload1.PostedFile.FileName != "")
            {
                String ext = System.IO.Path.GetExtension(FileUpload1.PostedFile.FileName).ToLower();
                if (ext == ".matt")
                {
                    FileUpload1.SaveAs(Server.MapPath("temp.matt"));
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "alertIns", "alert('Archivo reconocido con exito');", true);
                    String archivo = System.IO.File.ReadAllText(Server.MapPath("temp.matt"));
                    this.TextBox1.Text = archivo;
                }
                else
                {
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "alertIns", "alert('Archivo no reconocido con exito');", true);
                    abierto = false;
                }
            }
            else
            {
                ScriptManager.RegisterStartupScript(this, this.GetType(), "alertIns", "alert('No hay ningun archivo seleccionado');", true);
                abierto = false;
            }
        }

        protected void btnNuevo_Click(object sender, EventArgs e)
        {
            if (this.panelcontenido.Visible == false)
            {
                this.panelcontenido.Visible = true;
            }
            else
            {
                String auxtexto = this.TextBox1.Text;
                String texto = System.IO.File.ReadAllText(Server.MapPath("temp.matt"));
                if (auxtexto != texto)
                {
                    System.Text.UTF8Encoding encoding = new System.Text.UTF8Encoding();
                    byte[] contenido = encoding.GetBytes(auxtexto);
                    Response.ContentType = "text/plain";
                    Response.AddHeader("content-disposition", "attachment; filename = descarga.matt");
                    Response.BufferOutput = true;
                    Response.OutputStream.Write(contenido, 0, contenido.Length);
                    Response.End();
                }
            }
        }
    }
}