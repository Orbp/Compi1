<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Practica2_201220165.Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
    <link rel ="stylesheet" type="text/css" href="Estilos/layout.css"
    <head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Practica 2</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1 align="center"><font face="Arial" color="white">Programa MATT</font></h1>
    </div>
        <asp:Panel ID="paneldearchivo" runat="server" Visible="true" HorizontalAlign="Center">
            <asp:Label ID="label1" runat="server"><font color ="white">Seleccionar archivo</font></asp:Label>
            &nbsp; &nbsp;
            <asp:FileUpload ID="FileUpload1" runat="server" />
            &nbsp;<br />
            <asp:Button ID="btnSubir" runat="server" Text="Subir" OnClick="btnSubir_Click"/>
            &nbsp; &nbsp;<br /><br />
            <br />
            <asp:Button ID="btnNuevo" runat="server" Text="Nuevo" OnClick="btnNuevo_Click" />
        </asp:Panel>

        <asp:Panel ID="panelcontenido" runat="server" HorizontalAlign="Center" Visible ="false">
            <asp:Label ID ="label3" runat ="server"><font color ="white">Contenido del archivo:</font></asp:Label>
            <br /><br />
            <asp:TextBox ID="TextBox1" runat="server" Height="175px" TextMode="MultiLine" Width="689px"></asp:TextBox>
            <br />
            <asp:Button ID="btnAnalizar" runat="server" Text="Analizar" />
        </asp:Panel>

    </form>
</body>
</html>
