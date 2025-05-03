/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.proyecto.bean;

import javax.swing.JOptionPane;

/**
 *
 * @author miche
 */
public class EscuelaConductor{

    private int id;
    private String codDep;
    private String codPro;
    private String codDis;
    private String nomDep;
    private String nomPro;
    private String nomDis;
    private String nroRuc;
    private String nombreEstablecimiento;
    private String direccion;
    private String correo;
    private String telefono;
    private String estado;

    public EscuelaConductor(){}
    public EscuelaConductor(int id, String codDep, String codPro, String codDis, String nroRuc, String nombreEstablecimiento, String direccion, String correo, String telefono, String estado) {
        this.id = id;
        this.codDep = codDep;
        this.codPro = codPro;
        this.codDis = codDis;
        this.nroRuc = nroRuc;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int idConductor) {
        this.id = idConductor;
    }

    public String getCodDep() {
        return codDep;
    }

    public void setCodDep(String codDep) {
        if (codDep == null || codDep.length() != 2) {
            MuestraMensajeJPanel("El codigo de departamento debe tener 2 caracteres");
        }
        this.codDep = codDep;
    }

    public String getCodPro() {
        return codPro;
    }

    public void setCodPro(String codPro) {
        if (codPro == null || codPro.length() != 4) {
            MuestraMensajeJPanel("El codigo de provincia debe tener 4 caracteres");
        }
        this.codPro = codPro;
    }

    public String getCodDis() {
        return codDis;
    }

    public void setCodDis(String codDis) {
        if (codDis == null || codDis.length() != 6) {
            MuestraMensajeJPanel("El codigo de distrito debe tener 6 caracteres");
        }
        this.codDis = codDis;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }
    public String getNomDep() {
        return nomDep;
    }

    
    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public String getNomPro() {
        return nomPro;
    }
    
    
    public void setNomDis(String nomDis) {
        this.nomDis = nomDis;
    }

    public String getNomDis() {
        return nomDis;
    }
    
    
    public String getNroRuc() {
        return nroRuc;
    }

    public void setNroRuc(String nroRuc) {
        if (nroRuc == null || !nroRuc.matches("\\d{11}")) {
            MuestraMensajeJPanel("El RUC debe tener 11 dígitos numericos");
        }
        this.nroRuc = nroRuc;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        if (nombreEstablecimiento == null || nombreEstablecimiento.length() > 200) {
            MuestraMensajeJPanel("El nombre del establecimiento no debe superar los 200 caracteres");
        }
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.length() > 300) {
            MuestraMensajeJPanel("La dirección no debe superar los 300 caracteres");
        }
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null || correo.length() > 100 || !correo.contains("@")) {
            MuestraMensajeJPanel("El correo debe ser válido y no superar los 100 caracteres");
        }
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{7,9}")) {
            MuestraMensajeJPanel("El teléfono debe contener entre 7 y 9 digitos");
        }
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.length() > 50) {
            MuestraMensajeJPanel("El estado no debe superar los 50 caracteres");
        }
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Conductor{" + "idConductor=" + id + ", codDep=" + codDep + ", codPro=" + codPro + ", codDis=" + codDis + ", nroRuc=" + nroRuc + ", nombreEstablecimiento=" + nombreEstablecimiento + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", estado=" + estado + '}';
    }
    
    
    private void MuestraMensajeJPanel(String texto){
        JOptionPane.showMessageDialog(null,"Ocurrio el siguiente error : "+ texto );
    }
}
