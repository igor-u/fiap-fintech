--------------------------------------------------------
--  Arquivo criado - sexta-feira-junho-07-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MOVIMENTACOES
--------------------------------------------------------

  CREATE TABLE "MOVIMENTACOES" 
   (	"CODIGO_MOVIMENTACAO" VARCHAR2(64), 
	"VALOR" FLOAT(126), 
	"DATA_MOVIMENTACAO" DATE,
    "DESCRICAO" VARCHAR(16),
	"USUARIO" VARCHAR2(16), 
	"AGENCIA_CONTA" VARCHAR2(4), 
	"CODIGO_BANCO_CONTA" VARCHAR2(3), 
	"NUMERO_CONTA" VARCHAR2(10)
   ) ;
--------------------------------------------------------
--  DDL for Table DESPESAS
--------------------------------------------------------

  CREATE TABLE "DESPESAS" 
   (	"CODIGO_DESPESA" VARCHAR2(64), 
	"VALOR" FLOAT(126), 
	"DATA_DESPESA" DATE, 
	"USUARIO" VARCHAR2(16), 
	"AGENCIA_CONTA" VARCHAR2(4), 
	"CODIGO_BANCO_CONTA" VARCHAR2(3), 
	"NUMERO_CONTA" VARCHAR2(10)
   ) ;
--------------------------------------------------------
--  DDL for Table CONTAS
--------------------------------------------------------

  CREATE TABLE "CONTAS" 
   (	"ID_CONTA" VARCHAR2(16), 
	"SALDO" FLOAT(126), 
	"AGENCIA" VARCHAR2(4), 
	"CODIGO_BANCO" VARCHAR2(3), 
	"NUMERO" VARCHAR2(10), 
	"TIPO_CONTA" CHAR(1)
   ) ;
--------------------------------------------------------
--  DDL for Table BANCOS
--------------------------------------------------------

  CREATE TABLE "BANCOS" 
   (	"CODIGO" VARCHAR2(3), 
	"NOME" VARCHAR2(50)
   ) ;
--------------------------------------------------------
--  DDL for Table INVESTIMENTOS
--------------------------------------------------------

  CREATE TABLE "INVESTIMENTOS" 
   (	"CODIGO_INVESTIMENTO" VARCHAR2(64), 
	"VALOR" FLOAT(126), 
	"LUCRO" FLOAT(126), 
	"DATA_INVESTIMENTO" DATE, 
	"CNPJ_EMPRESA" VARCHAR2(14), 
	"TIPO_INVESTIMENTO" CHAR(1), 
	"USUARIO" VARCHAR2(16), 
	"AGENCIA_CONTA" VARCHAR2(4), 
	"CODIGO_BANCO_CONTA" VARCHAR2(3), 
	"NUMERO_CONTA" VARCHAR2(10)
   ) ;
--------------------------------------------------------
--  DDL for Table TIPOS_CONTA
--------------------------------------------------------

  CREATE TABLE "TIPOS_CONTA" 
   (	"ID_TIPO" CHAR(1), 
	"DESCRICAO" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table RECEITAS
--------------------------------------------------------

  CREATE TABLE "RECEITAS" 
   (	"CODIGO_RECEITA" VARCHAR2(64), 
	"VALOR" FLOAT(126), 
	"DATA_RECEITA" DATE, 
	"USUARIO" VARCHAR2(16), 
	"AGENCIA_CONTA" VARCHAR2(4), 
	"CODIGO_BANCO_CONTA" VARCHAR2(3), 
	"NUMERO_CONTA" VARCHAR2(10)
   ) ;
--------------------------------------------------------
--  DDL for Table TIPOS_INVESTIMENTO
--------------------------------------------------------

  CREATE TABLE "TIPOS_INVESTIMENTO" 
   (	"ID_TIPO" CHAR(1), 
	"DESCRICAO" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table TIPOS_USUARIO
--------------------------------------------------------

  CREATE TABLE "TIPOS_USUARIO" 
   (	"ID_TIPO" CHAR(1), 
	"DESCRICAO" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table USUARIO_CONTA
--------------------------------------------------------

  CREATE TABLE "USUARIO_CONTA" 
   (	"USUARIO" VARCHAR2(16), 
	"AGENCIA_CONTA" VARCHAR2(4), 
	"CODIGO_BANCO_CONTA" VARCHAR2(3), 
	"NUMERO_CONTA" VARCHAR2(10)
   ) ;
--------------------------------------------------------
--  DDL for Table USUARIOS
--------------------------------------------------------

  CREATE TABLE "USUARIOS" 
   (	"ID_USUARIO" VARCHAR2(16), 
	"TIPO_USUARIO" CHAR(1), 
	"NOME" VARCHAR2(80), 
	"TELEFONE" VARCHAR2(16), 
	"EMAIL" VARCHAR2(255), 
	"HASH_SENHA" VARCHAR2(64)
   ) ;
--------------------------------------------------------
--  DDL for Index SYS_C002388096
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C002388096" ON "DESPESAS" ("CODIGO_DESPESA") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C002431980
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C002431980" ON "CONTAS" ("ID_CONTA") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C002388066
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C002388066" ON "BANCOS" ("CODIGO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C002388108
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C002388108" ON "INVESTIMENTOS" ("CODIGO_INVESTIMENTO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C002388064
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C002388064" ON "TIPOS_CONTA" ("ID_TIPO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C002388088
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C002388088" ON "RECEITAS" ("CODIGO_RECEITA") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C002388099
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C002388099" ON "TIPOS_INVESTIMENTO" ("ID_TIPO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C002388056
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C002388056" ON "TIPOS_USUARIO" ("ID_TIPO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C002388079
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C002388079" ON "USUARIO_CONTA" ("USUARIO", "AGENCIA_CONTA", "CODIGO_BANCO_CONTA", "NUMERO_CONTA") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C002388061
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C002388061" ON "USUARIOS" ("ID_USUARIO") 
  ;
--------------------------------------------------------
--  Constraints for Table DESPESAS
--------------------------------------------------------

  ALTER TABLE "DESPESAS" MODIFY ("VALOR" NOT NULL ENABLE);
  ALTER TABLE "DESPESAS" MODIFY ("DATA_DESPESA" NOT NULL ENABLE);
  ALTER TABLE "DESPESAS" MODIFY ("USUARIO" NOT NULL ENABLE);
  ALTER TABLE "DESPESAS" MODIFY ("AGENCIA_CONTA" NOT NULL ENABLE);
  ALTER TABLE "DESPESAS" MODIFY ("CODIGO_BANCO_CONTA" NOT NULL ENABLE);
  ALTER TABLE "DESPESAS" MODIFY ("NUMERO_CONTA" NOT NULL ENABLE);
  ALTER TABLE "DESPESAS" ADD PRIMARY KEY ("CODIGO_DESPESA")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table CONTAS
--------------------------------------------------------

  ALTER TABLE "CONTAS" MODIFY ("SALDO" NOT NULL ENABLE);
  ALTER TABLE "CONTAS" MODIFY ("AGENCIA" NOT NULL ENABLE);
  ALTER TABLE "CONTAS" MODIFY ("CODIGO_BANCO" NOT NULL ENABLE);
  ALTER TABLE "CONTAS" MODIFY ("NUMERO" NOT NULL ENABLE);
  ALTER TABLE "CONTAS" MODIFY ("TIPO_CONTA" NOT NULL ENABLE);
  ALTER TABLE "CONTAS" ADD PRIMARY KEY ("ID_CONTA")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table BANCOS
--------------------------------------------------------

  ALTER TABLE "BANCOS" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "BANCOS" ADD PRIMARY KEY ("CODIGO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table INVESTIMENTOS
--------------------------------------------------------

  ALTER TABLE "INVESTIMENTOS" MODIFY ("VALOR" NOT NULL ENABLE);
  ALTER TABLE "INVESTIMENTOS" MODIFY ("DATA_INVESTIMENTO" NOT NULL ENABLE);
  ALTER TABLE "INVESTIMENTOS" MODIFY ("CNPJ_EMPRESA" NOT NULL ENABLE);
  ALTER TABLE "INVESTIMENTOS" MODIFY ("TIPO_INVESTIMENTO" NOT NULL ENABLE);
  ALTER TABLE "INVESTIMENTOS" MODIFY ("USUARIO" NOT NULL ENABLE);
  ALTER TABLE "INVESTIMENTOS" MODIFY ("AGENCIA_CONTA" NOT NULL ENABLE);
  ALTER TABLE "INVESTIMENTOS" MODIFY ("CODIGO_BANCO_CONTA" NOT NULL ENABLE);
  ALTER TABLE "INVESTIMENTOS" MODIFY ("NUMERO_CONTA" NOT NULL ENABLE);
  ALTER TABLE "INVESTIMENTOS" ADD PRIMARY KEY ("CODIGO_INVESTIMENTO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table TIPOS_CONTA
--------------------------------------------------------

  ALTER TABLE "TIPOS_CONTA" MODIFY ("DESCRICAO" NOT NULL ENABLE);
  ALTER TABLE "TIPOS_CONTA" ADD PRIMARY KEY ("ID_TIPO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table RECEITAS
--------------------------------------------------------

  ALTER TABLE "RECEITAS" MODIFY ("VALOR" NOT NULL ENABLE);
  ALTER TABLE "RECEITAS" MODIFY ("DATA_RECEITA" NOT NULL ENABLE);
  ALTER TABLE "RECEITAS" MODIFY ("USUARIO" NOT NULL ENABLE);
  ALTER TABLE "RECEITAS" MODIFY ("AGENCIA_CONTA" NOT NULL ENABLE);
  ALTER TABLE "RECEITAS" MODIFY ("CODIGO_BANCO_CONTA" NOT NULL ENABLE);
  ALTER TABLE "RECEITAS" MODIFY ("NUMERO_CONTA" NOT NULL ENABLE);
  ALTER TABLE "RECEITAS" ADD PRIMARY KEY ("CODIGO_RECEITA")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table TIPOS_INVESTIMENTO
--------------------------------------------------------

  ALTER TABLE "TIPOS_INVESTIMENTO" MODIFY ("DESCRICAO" NOT NULL ENABLE);
  ALTER TABLE "TIPOS_INVESTIMENTO" ADD PRIMARY KEY ("ID_TIPO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table TIPOS_USUARIO
--------------------------------------------------------

  ALTER TABLE "TIPOS_USUARIO" MODIFY ("DESCRICAO" NOT NULL ENABLE);
  ALTER TABLE "TIPOS_USUARIO" ADD PRIMARY KEY ("ID_TIPO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIO_CONTA
--------------------------------------------------------

  ALTER TABLE "USUARIO_CONTA" MODIFY ("USUARIO" NOT NULL ENABLE);
  ALTER TABLE "USUARIO_CONTA" MODIFY ("AGENCIA_CONTA" NOT NULL ENABLE);
  ALTER TABLE "USUARIO_CONTA" MODIFY ("CODIGO_BANCO_CONTA" NOT NULL ENABLE);
  ALTER TABLE "USUARIO_CONTA" MODIFY ("NUMERO_CONTA" NOT NULL ENABLE);
  ALTER TABLE "USUARIO_CONTA" ADD PRIMARY KEY ("USUARIO", "AGENCIA_CONTA", "CODIGO_BANCO_CONTA", "NUMERO_CONTA")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "USUARIOS" MODIFY ("TIPO_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "USUARIOS" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "USUARIOS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "USUARIOS" MODIFY ("HASH_SENHA" NOT NULL ENABLE);
  ALTER TABLE "USUARIOS" ADD PRIMARY KEY ("ID_USUARIO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DESPESAS
--------------------------------------------------------

  ALTER TABLE "DESPESAS" ADD FOREIGN KEY ("USUARIO", "AGENCIA_CONTA", "CODIGO_BANCO_CONTA", "NUMERO_CONTA")
	  REFERENCES "USUARIO_CONTA" ("USUARIO", "AGENCIA_CONTA", "CODIGO_BANCO_CONTA", "NUMERO_CONTA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CONTAS
--------------------------------------------------------

  ALTER TABLE "CONTAS" ADD FOREIGN KEY ("TIPO_CONTA")
	  REFERENCES "TIPOS_CONTA" ("ID_TIPO") ENABLE;
  ALTER TABLE "CONTAS" ADD FOREIGN KEY ("CODIGO_BANCO")
	  REFERENCES "BANCOS" ("CODIGO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table INVESTIMENTOS
--------------------------------------------------------

  ALTER TABLE "INVESTIMENTOS" ADD FOREIGN KEY ("TIPO_INVESTIMENTO")
	  REFERENCES "TIPOS_INVESTIMENTO" ("ID_TIPO") ENABLE;
  ALTER TABLE "INVESTIMENTOS" ADD FOREIGN KEY ("USUARIO", "AGENCIA_CONTA", "CODIGO_BANCO_CONTA", "NUMERO_CONTA")
	  REFERENCES "USUARIO_CONTA" ("USUARIO", "AGENCIA_CONTA", "CODIGO_BANCO_CONTA", "NUMERO_CONTA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RECEITAS
--------------------------------------------------------

  ALTER TABLE "RECEITAS" ADD FOREIGN KEY ("USUARIO", "AGENCIA_CONTA", "CODIGO_BANCO_CONTA", "NUMERO_CONTA")
	  REFERENCES "USUARIO_CONTA" ("USUARIO", "AGENCIA_CONTA", "CODIGO_BANCO_CONTA", "NUMERO_CONTA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIO_CONTA
--------------------------------------------------------

  ALTER TABLE "USUARIO_CONTA" ADD FOREIGN KEY ("USUARIO")
	  REFERENCES "USUARIOS" ("ID_USUARIO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "USUARIOS" ADD FOREIGN KEY ("TIPO_USUARIO")
	  REFERENCES "TIPOS_USUARIO" ("ID_TIPO") ENABLE;
