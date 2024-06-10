package com.fintech.model.conta;

import java.util.Date;
import java.util.List;

public class Cartao {

    private long numeroCartao;
    private int codigoCvv;
    private Date dataVencimento;
    private List<Fatura> faturas;

    public Cartao(long numeroCartao, int codigoCvv, Date dataVencimento) {
        this.numeroCartao = numeroCartao;
        this.codigoCvv = codigoCvv;
        this.dataVencimento = dataVencimento;
    }

    public long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getCodigoCvv() {
        return codigoCvv;
    }

    public void setCodigoCvv(int codigoCvv) {
        this.codigoCvv = codigoCvv;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public List<Fatura> getFaturas() {
        return faturas;
    }

    public void setFaturas(List<Fatura> faturas) {
        this.faturas = faturas;
    }
}
