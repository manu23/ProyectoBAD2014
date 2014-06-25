/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.Conexion;
import com.biblioteca.dao.impl.TipoArticuloDataSource;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Manuel
 */
@ManagedBean
@RequestScoped
public class ReportesController {
    
    private Date fechaIni;
    private Date fechaFin;
    private Integer tipo=0;

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
    

    /**
     * Creates a new instance of ReportesController
     */
    public ReportesController() {
    }
    
    
    public void prestamos(){
        try{       
             Conexion conn = new Conexion();
             
            String logotipo="/com/biblioteca/resources/reportes/logoBiblioteca.jpg";

            URL master = this.getClass().getResource( "/com/biblioteca/resources/reportes/ReporteDePrestamos.jasper" );

            if(master==null){
                System.out.println("No encuentro el archivo del reporte maestro...");
                System.exit(2);
            }
            
            JasperReport masterReport = null;
            masterReport=(JasperReport)JRLoader.loadObject(master);            
            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("fechaInicio",getFechaIni());
            parametro.put("fechaFin",getFechaFin());
            parametro.put("logo", this.getClass().getResourceAsStream(logotipo));
                       
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn.getConexion());
            String nameReport="/Reporte de Prestamos.pdf";
            
            exportarToPDF(jasperPrint,nameReport);
            
            }catch(Exception j){
                System.out.println("Mensaje de Error: "+j.getMessage());
            }
    }
    
    public void socios(){
        try{       
             Conexion conn = new Conexion();
             
            String logotipo="/com/biblioteca/resources/reportes/logoBiblioteca.jpg";

            URL master = this.getClass().getResource( "/com/biblioteca/resources/reportes/ReporteDeSocios.jasper" );

            if(master==null){
                System.out.println("No encuentro el archivo del reporte maestro...");
                System.exit(2);
            }
            
            JasperReport masterReport = null;
            try{
                masterReport=(JasperReport)JRLoader.loadObject(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                System.exit(3);
            }            
            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("fechaIni",getFechaIni());
            parametro.put("fechaFin",getFechaFin());
            parametro.put("logo", this.getClass().getResourceAsStream(logotipo));
                       
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn.getConexion()); 
            String nameReport="/Reporte de Socios.pdf";
            exportarToPDF(jasperPrint,nameReport);
            }catch(Exception j){
                System.out.println("Mensaje de Error: "+j.getMessage());
            }         
    }
    
    public void tipoArticulos() throws SQLException{
      try{
          String logotipo="/com/biblioteca/resources/reportes/logoBiblioteca.jpg";
          
          Conexion conn = new Conexion();
          TipoArticuloDataSource datasource = new TipoArticuloDataSource();

          datasource = conn.consultarTipoArticulo(getTipo());

          URL master = this.getClass().getResource( "/com/biblioteca/resources/reportes/ReporteDeArticulos.jasper" );

            if(master==null){
                System.out.println("No encuentro el archivo del reporte maestro...");
                System.exit(2);
            }
            
            JasperReport masterReport = null;
            try{
                masterReport=(JasperReport)JRLoader.loadObject(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                System.exit(3);
            }
            
            Map parametro = new HashMap();
            parametro.clear();
            String title=getReportTitle(getTipo());
            parametro.put("reportTitle",title);
            parametro.put("logo", this.getClass().getResourceAsStream(logotipo));
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,datasource); 
            String nameReport="/Reporte de Articulos.pdf";
            exportarToPDF(jasperPrint,nameReport);
            }catch(Exception j){
                System.out.println("Mensaje de Error: "+j.getMessage());
            }         
   
    }
    
    public void exportarToPDF(JasperPrint jasperPrint, String nameReport) throws JRException{
        
        String documentsPath =System.getProperty("user.home") + "\\"+"Documents";    
        String reportPath = documentsPath + nameReport;
            
        JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath);            
        try {
                if ((new File(reportPath)).exists()) {
                        Process p = Runtime
                           .getRuntime()
                           .exec("rundll32 url.dll,FileProtocolHandler "+reportPath);
                        p.waitFor();
                } else {
                        System.out.println("File is not exists");
                }
                System.out.println("Done");
          } catch (Exception ex) {
                ex.printStackTrace();
          }
    } 
    
    public String getReportTitle(int tipo){
        String reportTitle="";
        switch (tipo){
            case 1: reportTitle="Todas las categorias";
                    break;
            case 2: reportTitle="Categoria: Libros";
                    break;
            case 3: reportTitle="Categoria: Revistas";
                    break;
            case 4: reportTitle="Categoria: CD";
                    break;
            case 5: reportTitle="Categoria: DVD";
                    break;
            case 6: reportTitle="Categoria: Tesis";
                    break;
            case 7: reportTitle="Categoria: Periodicos";
                    break;
            case 8: reportTitle="Categoria: Obras de Referencia";
                    break;
            case 9: reportTitle="Categoria: Memorias";
                    break;
            default: reportTitle="";
                     break;
    }
               
        return reportTitle;
    }
}