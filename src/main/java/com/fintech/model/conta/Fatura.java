package com.fintech.model.conta;

import java.math.BigDecimal;
import java.util.Date;

public class Fatura {

    private long idFatura;
    private BigDecimal valorFatura;
    private Date dataFechamento;
    private Date dataVencimento;

    public Fatura(long idFatura, BigDecimal valorFatura, Date dataFechamento, Date dataVencimento) {
        this.idFatura = idFatura;
        this.valorFatura = valorFatura;
        this.dataFechamento = dataFechamento;
        this.dataVencimento = dataVencimento;
    }

    public long getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(long idFatura) {
        this.idFatura = idFatura;
    }

    public BigDecimal getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(BigDecimal valorFatura) {
        this.valorFatura = valorFatura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
