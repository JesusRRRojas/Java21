/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.proyecto.bean;

/**
 *
 * @author miche
 */
public class Response {
    private String  ResultadoDesc;
    private boolean ResultadoBit;

    public Response() {
    }

    public Response(String ResultadoDesc, boolean ResultadoBit) {
        this.ResultadoDesc = ResultadoDesc;
        this.ResultadoBit = ResultadoBit;
    }
    public String getResultadoDesc() {
        return ResultadoDesc;
    }

    public void setResultadoDesc(String ResultadoDesc) {
        this.ResultadoDesc = ResultadoDesc;
    }

    public boolean getResultadoBit() {
        return ResultadoBit;
    }

    public void setResultadoBit(boolean ResultadoBit) {
        this.ResultadoBit = ResultadoBit;
    }

    @Override
    public String toString() {
        return "Response{" + "ResultadoDesc=" + ResultadoDesc + ", ResultadoBit=" + ResultadoBit + '}';
    }
    
    
}
