/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.Conexion;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
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
            try{
                masterReport=(JasperReport)JRLoader.loadObject(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                System.exit(3);
            }            
            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("fechaInicio",getFechaIni());
            parametro.put("fechaFin",getFechaFin());
            parametro.put("logo", this.getClass().getResourceAsStream(logotipo));
                       
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn.getConexion()); 
            
            String documentsPath =System.getProperty("user.home") + "\\"+"Documents";
            String nameReport="/Reporte de Prestamos.pdf";
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
            }catch(Exception j){
                System.out.println("Mensaje de Error: "+j.getMessage());
            }
    }
    
}
