INSERT INTO FATURA (ID, VALOR, DATA_INICIO, DATA_FIM, FK_CARTAO)
VALUES (100, 800, '11/03/2018', '11/04/2018', 100);

INSERT INTO FATURA (ID, VALOR, DATA_INICIO, DATA_FIM, FK_CARTAO)
VALUES (101, 1000, '12/03/2018', '12/04/2018', 101);

INSERT INTO FATURA_LANCAMENTO(ID, DESCRICAO, VALOR,  DATA_LANCAMENTO, FK_FATURA)
VALUES (FATURA_LANCAMENTO_ID_SEQ.nextval, 'AUTO POSTO UNIVERSITÁRIO', 200.25, '13/03/2018', 100);

INSERT INTO FATURA_LANCAMENTO(ID, DESCRICAO, VALOR, DATA_LANCAMENTO, FK_FATURA)
VALUES (FATURA_LANCAMENTO_ID_SEQ.nextval, 'DROGA RAIA', 300.35, '15/03/2018', 100);

INSERT INTO FATURA_LANCAMENTO(ID, DESCRICAO, VALOR, DATA_LANCAMENTO, FK_FATURA)
VALUES (FATURA_LANCAMENTO_ID_SEQ.nextval, 'BURGUER KING', 300.25, '17/03/2018', 100);


INSERT INTO FATURA_LANCAMENTO(ID, DESCRICAO, VALOR,  DATA_LANCAMENTO, FK_FATURA)
VALUES (FATURA_LANCAMENTO_ID_SEQ.nextval, 'CARREFOUR', 100.15, '13/03/2018', 101);

INSERT INTO FATURA_LANCAMENTO(ID, DESCRICAO, VALOR, DATA_LANCAMENTO, FK_FATURA)
VALUES (FATURA_LANCAMENTO_ID_SEQ.nextval, 'VIVARA', 100.80, '15/03/2018', 101);

INSERT INTO FATURA_LANCAMENTO(ID, DESCRICAO, VALOR, DATA_LANCAMENTO, FK_FATURA)
VALUES (FATURA_LANCAMENTO_ID_SEQ.nextval, 'AUTO PEÇAS CENTRAL', 800.34, '17/03/2018', 101);